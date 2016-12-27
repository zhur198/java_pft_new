package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by zhur198 on 12/27/16.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitNewContactForm() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname ());
    type(By.name("middlename"), contactData.getMiddlename ());
    type(By.name("lastname"), contactData.getLastname ());
    type(By.name("home"), contactData.getHomephone ());
    type(By.name("email"), contactData.getEmail ());
  }

  public void openNewContactPage() {
      click(By.linkText("add new"));
  }
}
