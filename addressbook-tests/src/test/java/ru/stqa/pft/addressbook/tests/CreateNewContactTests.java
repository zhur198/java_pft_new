package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreateNewContactTests extends TestBase{

    @Test
    public void testCreateNewContact() {

        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().openNewContactPage();
        app.getContactHelper().fillNewContactForm(new ContactData("Ivan", "M", "Ivaniv", "407-499-0809", "ivaniv@somemail.com", "test1"), true);
        app.getContactHelper().submitNewContactForm();
        app.getNavigationHelper().gotoHomePage();

        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }
}
