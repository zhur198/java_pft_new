package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhur198 on 12/27/16.
 */
public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensureContactPresent () {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().IsThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ivan", "M", "Ivaniv", "407-499-0809", "ivaniv@somemail.com", "test1"));
    }
  }

  @Test (enabled = false)

  public void testContactModification () {

    List<ContactData> before = app.getContactHelper().getContactList();
//    int before = app.getContactHelper().getContactCount();
    ContactData contact = new ContactData("Ivan", "M", "Ivaniv", "407-499-0809", "ivaniv@somemail.com", null);
    int index = before.size() - 1;
    app.getContactHelper().modifyContact(contact, index);

    List<ContactData> after = app.getContactHelper().getContactList();
//    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
//    Comparator<? super ContactData> byLastname = (c1, c2) -> String.compare(c1.getLastname(), c2.getLastname());
//    before.sort(byLastname);
//    after.sort(byLastname);
    Assert.assertEquals(before, after);
  }
}
