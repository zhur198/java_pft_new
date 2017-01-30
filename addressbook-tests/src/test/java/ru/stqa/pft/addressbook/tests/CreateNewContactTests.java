package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class CreateNewContactTests extends TestBase{

    @Test
    public void testCreateNewContact() {

        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
//    int before = app.contact().getContactCount();
        ContactData contact = new ContactData().withFirstname("Ivan").withMiddlename("M").withLastname("Ivaniv").withHomephone("407-499-0809").withEmail("ivaniv@somemail.com").withGroup("test1");
        app.contact().create(contact);

        List<ContactData> after = app.contact().list();
//    int after = app.contact().getContactCount();
        Assert.assertEquals(after.size(), before.size() + 1);

//        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
