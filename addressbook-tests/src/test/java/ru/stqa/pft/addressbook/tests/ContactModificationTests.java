package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by zhur198 on 12/27/16.
 */
public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensureContactPresent () {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Ivan").withMiddlename("M").withLastname("Ivaniv").withHomephone("407-499-0809").withEmail("ivaniv@somemail.com").withGroup("test1"));
    }
  }

  @Test

  public void testContactModification () {

    List<ContactData> before = app.contact().list();
//    int before = app.contact().getContactCount();
    ContactData contact = new ContactData().withFirstname("Ivan").withMiddlename("M").withLastname("Ivaniv").withHomephone("407-499-0809").withEmail("ivaniv@somemail.com");
    int index = before.size() - 1;
    app.contact().modify(contact, index);

    List<ContactData> after = app.contact().list();
//    int after = app.contact().getContactCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
//    Comparator<? super ContactData> byLastname = (c1, c2) -> String.compare(c1.getLastname(), c2.getLastname());
//    before.sort(byLastname);
//    after.sort(byLastname);
//    Assert.assertEquals(before, after);
  }
}
