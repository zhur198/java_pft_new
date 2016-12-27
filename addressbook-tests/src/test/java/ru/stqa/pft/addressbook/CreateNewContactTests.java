package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class CreateNewContactTests extends TestBase{

    @Test
    public void testCreateNewContact() {

        app.openNewContactPage();
        app.fillNewContactForm(new ContactData("Ivan", "M", "Ivaniv", "407-499-0809", "ivaniv@somemail.com"));
        app.submitNewContactForm();
        app.gotoHomePage();
    }
}
