package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by zhur198 on 12/27/16.
 */
public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification () {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillNewContactForm(new ContactData("Ivan", "M", "Ivaniv", "407-499-0809", "ivaniv@somemail.com"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
