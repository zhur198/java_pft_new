package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by zhur198 on 12/27/16.
 */
public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensureContactPresent () {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Ivan").withMiddlename("M").withLastname("Ivaniv").withHomephone("407-499-0809").withEmail("ivaniv@somemail.com").withGroup("test1"));
    }
  }

  @Test

  public void testDeleteContact () {

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.goTo().homePage();
    app.contact().delete(deletedContact);

    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));

  }
}
