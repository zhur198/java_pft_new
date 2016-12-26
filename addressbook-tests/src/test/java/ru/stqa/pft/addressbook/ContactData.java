package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String homephone;
  private final String email;

  public ContactData(String firstname, String middlename, String lastname, String homephone, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.homephone = homephone;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getEmail() {
    return email;
  }
}
