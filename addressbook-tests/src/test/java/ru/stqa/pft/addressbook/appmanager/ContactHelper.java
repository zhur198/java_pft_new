package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail ());
    attach(By.name("photo"), contactData.getPhoto ());
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

  public void selectContactById (int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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
    contactCache = null;
    returnToContactPage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    editContact();
    fillNewContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    closeAlertWindow();
    contactCache = null;
    returnToContactPage();
  }

  private void returnToContactPage() {
    click(By.linkText("home"));
  }

  public boolean IsThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

//  public List<ContactData> list() {
//    List<ContactData> contacts = new ArrayList<ContactData>();
//    List<WebElement> rows = wd.findElements(By.name("entry"));
//    for (WebElement row : rows) {
//      List<WebElement> cells = row.findElements(By.tagName("td"));
//      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
//      String lastname = cells.get(1).getText();
//      String firstname = cells.get(2).getText();
//      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
//    }
//    return contacts;
//  }

  public Set<ContactData> alls() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
//      String[] phones = cells.get(5).getText().split("\n");
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
//      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
//              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]).withEmail(email).withAddress(address));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return contacts;
  }

  public Contacts all() {

    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String email = cells.get(4).getText();
      String address = cells.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withEmail(email).withAddress(address));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById (contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home)
            .withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
//    WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public ContactData infoFromViewForm(ContactData contact) {
    initContactViewById (contact.getId());
    String firstname = wd.findElement(By.xpath(".//*[@id='content']/b")).getText().split("\\s+")[0];
//    System.out.println(firstname);
    String lastname = wd.findElement(By.xpath(".//*[@id='content']/b")).getText().split("\\s+")[2];
//    System.out.println(lastname);
    String address = wd.findElement(By.xpath(".//*[@id='content']")).getText().split("\n")[1];
//    System.out.println(address);
    String home = wd.findElement(By.xpath(".//*[@id='content']")).getText().split("\n")[3].replace("H:", "").replace(" ", "");
//    System.out.println(home);
    String mobile = wd.findElement(By.xpath(".//*[@id='content']")).getText().split("\n")[4].replace("M:", "").replace(" ", "");
//    System.out.println(mobile);
    String work = wd.findElement(By.xpath(".//*[@id='content']")).getText().split("\n")[5].replace("W:", "").replace(" ", "");
//    System.out.println(work);
    String email = wd.findElement(By.xpath(".//*[@id='content']")).getText().split("\n")[7];
//    System.out.println(email);
    String email2 = wd.findElement(By.xpath(".//*[@id='content']")).getText().split("\n")[8];
//    System.out.println(email2);
    String email3 = wd.findElement(By.xpath(".//*[@id='content']")).getText().split("\n")[9];
//    System.out.println(email3);
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withAddress(address)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  private void initContactViewById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }
}

