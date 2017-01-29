package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class CreateNewContactTests extends TestBase{

    @Test
    public void testCreateNewContact() {

        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
//    int before = app.contact().getContactCount();
        ContactData contact = new ContactData("Ivan", "M", "Ivaniv", "407-499-0809", "ivaniv@somemail.com", "test1");
        app.contact().create(contact);

        List<ContactData> after = app.contact().list();
//    int after = app.contact().getContactCount();
        Assert.assertEquals(after.size(), before.size() + 1);
//
        before.add(contact);

        //    Comparator<? super ContactData> byLastname = (c1, c2) -> String.compare(c1.getLastname(), c2.getLastname());
//    before.sort(byLastname);
//    after.sort(byLastname);
//        Assert.assertEquals(before, after);
    }
}
