package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zhur198 on 2/1/17.
 */
public class ConatctFormVerificationTests extends TestBase{

  @BeforeMethod
  public void ensureContactPresent () {
    app.goTo().homePage();
    if (app.contact().alls().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Ivan").withMiddlename("M").withLastname("Ivaniv").withHomePhone("4074990809")
              .withEmail("ivaniv@somemail.com").withGroup("test1").withWorkPhone("356543").withMobilePhone("999999999"));
    }
  }

  @Test

  public void testContactFormVerification() {
    ContactData contact = app.contact().alls().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getFirstname(), equalTo(contactInfoFromEditForm.getFirstname()));
    assertThat(contact.getLastname(), equalTo(contactInfoFromEditForm.getLastname()));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}