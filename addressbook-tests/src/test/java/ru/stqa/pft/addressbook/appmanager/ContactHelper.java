package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhur198 on 12/27/16.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewContactForm() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname ());
    type(By.name("middlename"), contactData.getMiddlename ());
    type(By.name("lastname"), contactData.getLastname ());
    type(By.name("home"), contactData.getHomephone ());
    type(By.name("email"), contactData.getEmail ());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void openNewContactPage() {
      click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
//    click(By.name("selected[]"));
  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlertWindow() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact) {
    openNewContactPage();
    fillNewContactForm(contact, true);
    submitNewContactForm();
    returnToContactPage();
  }

  public void modify(ContactData contact, int index) {
    selectContact(index);
    editContact();
    fillNewContactForm(contact, false);
    submitContactModification();
    returnToContactPage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
    closeAlertWindow();
    returnToContactPage();
  }

  private void returnToContactPage() {
    click(By.linkText("home"));
  }

  public boolean IsThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
//      System.out.println(lastname);
//      ContactData contact = new ContactData().withFirstname(firstname).withLastname(lastname);
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }
}
