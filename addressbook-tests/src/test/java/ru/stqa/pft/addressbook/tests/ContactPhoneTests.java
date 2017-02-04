package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zhur198 on 2/1/17.
 */
public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensureContactPresent () {
    app.goTo().homePage();
    if (app.contact().alls().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Ivan").withMiddlename("M").withLastname("Ivaniv").withHomePhone("4074990809")
              .withEmail("ivaniv@somemail.com").withGroup("test1").withWorkPhone("356543").withMobilePhone("999999999"));
    }
  }

  @Test

  public void testContactPhones() {
    ContactData contact = app.contact().alls().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
  }

  public String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
