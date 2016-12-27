package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by zhur198 on 12/27/16.
 */
public class ContactDeletionTests extends TestBase{

  @Test

  public void testDeleteContact () {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlertWindow();
    app.getNavigationHelper().gotoHomePage();
  }
}
