package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by zhur198 on 12/27/16.
 */
public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensureContactPresent () {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Ivan", "M", "Ivaniv", "407-499-0809", "ivaniv@somemail.com", "test1"));
    }
  }

  @Test

  public void testDeleteContact () {

    List<ContactData> before = app.contact().list();
//    int before = app.contact().getContactCount();
    int index = before.size() - 1;
    app.goTo().homePage();
    app.contact().delete(index);

    List<ContactData> after = app.contact().list();
//    int after = app.contact().getContactCount();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
