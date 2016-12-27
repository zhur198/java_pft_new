package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreateNewContactTests extends TestBase{

    @Test
    public void testCreateNewContact() {

        app.getContactHelper().openNewContactPage();
        app.getContactHelper().fillNewContactForm(new ContactData("Ivan", "M", "Ivaniv", "407-499-0809", "ivaniv@somemail.com"));
        app.getContactHelper().submitNewContactForm();
        app.getNavigationHelper().gotoHomePage();
    }
}
