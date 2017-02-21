package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class CreateNewContactTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new ContactData().withFirstname("Ivan 1").withMiddlename("M1").withLastname("Ivaniv 1").withHomePhone("107-499-0809")
                .withEmail("ivaniv1@somemail.com").withGroup("test1").withWorkPhone("356543").withMobilePhone("999999999")});
        list.add(new Object[] {new ContactData().withFirstname("Ivan 2").withMiddlename("M2").withLastname("Ivaniv 2").withHomePhone("207-499-0809")
                .withEmail("ivaniv2@somemail.com").withGroup("test1").withWorkPhone("356543").withMobilePhone("999999999")});
        list.add(new Object[] {new ContactData().withFirstname("Ivan 3").withMiddlename("M3").withLastname("Ivaniv 3").withHomePhone("307-499-0809")
                .withEmail("ivaniv3@somemail.com").withGroup("test1").withWorkPhone("356543").withMobilePhone("999999999")});
        return list.iterator();
    }

    @Test (dataProvider = "validContacts")
    public void testCreateNewContact(ContactData contact) {

        app.goTo().homePage();
        Contacts before = app.contact().all();
//        File photo = new File("src/test/resources/maxresdefault.png");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

//    @Test
//    public void testCurrentDir() {
//        File currentDir = new File(".");
//        System.out.println(currentDir.getAbsolutePath());
//        File photo = new File("src/test/resources/maxresdefault.png");
//        System.out.println(photo.getAbsolutePath());
//        System.out.println(photo.exists());
//    }

    @Test
    public void testCreateBadNewContact() {

        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Ivan'").withMiddlename("M").withLastname("Ivaniv").withHomePhone("407-499-0809").withEmail("ivaniv@somemail.com")
                .withGroup("test1").withWorkPhone("356543").withMobilePhone("999999999");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}
