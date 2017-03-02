package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table (name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column (name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column (name = "firstname")
  private String firstname;

  @Transient
  private String middlename;

  @Expose
  @Column (name = "lastname")
  private String lastname;

  @Expose
  @Column (name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Transient
  private String email;

  @Transient
  private String group;

  @Expose
  @Column (name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Expose
  @Column (name = "work")
  @Type(type = "text")
  private String workPhone;

  @Expose
  @Transient
  private String address;

  @Transient
  private String allPhones;

  @Transient
  private String email2;

  @Transient
  private String email3;

  @Transient
  private String allEmails;

  @Column (name = "photo")
  @Type(type = "text")
  private String photo;

  //  public ContactData(String firstname, String middlename, String lastname, String homePhone, String email, String group) {

  //  this.id = Integer.MAX_VALUE;
//    this.firstname = firstname;
//    this.middlename = middlename;
//    this.lastname = lastname;
//    this.homePhone = homePhone;
//    this.email = email;
//    this.group = group;
//  }

  //  public ContactData(int id, String firstname, String middlename, String lastname, String homePhone, String email, String group) {
  //  this.id = id;
//    this.firstname = firstname;
//    this.middlename = middlename;
//    this.lastname = lastname;
//    this.homePhone = homePhone;
//    this.email = email;
//    this.group = group;
//  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withHomePhone(String homephone) {
    this.homePhone = homephone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public int getId() {return id;}

  public String getLastname() {
    return lastname;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {return email3;}

  public String getAllEmails() {return allEmails;}

  public String getGroup() {
    return group;
  }

  public String getWorkPhone() { return workPhone; }

  public String getMobilePhone() { return mobilePhone; }

  public String getAddress() { return address; }

  public String getAllPhones() {return allPhones;}

  public File getPhoto() {return new File(photo);}


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", email='" + email + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", address='" + address + '\'' +
            '}';
  }


}
