package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateNewContactTests extends TestBase{

    @Test
    public void testCreateNewContact() {

        app.goTo().homePage();
//        Set<ContactData> before = app.contact().all();
//    int before = app.contact().getContactCount();

        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Ivan").withMiddlename("M").withLastname("Ivaniv").withHomephone("407-499-0809").withEmail("ivaniv@somemail.com").withGroup("test1");
        app.contact().create(contact);

        Contacts after = app.contact().all();
//    int after = app.contact().getContactCount();
        Assert.assertEquals(after.size(), before.size() + 1);

//        Assert.assertEquals(before, after);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
