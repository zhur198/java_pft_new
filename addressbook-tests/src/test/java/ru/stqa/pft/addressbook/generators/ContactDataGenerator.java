package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;
import sun.jvm.hotspot.oops.FieldType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhur198 on 2/16/17.
 */
public class ContactDataGenerator {

  public static void main (String[] args) throws IOException {
    int count = Integer.parseInt(args [0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts (count);
    save (contacts, file);

  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname()
              , contact.getEmail(), contact.getMobilePhone(), contact.getAddress()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("Ivan %s", i)).withLastname(String.format("Ivanov %s", i))
              .withEmail(String.format("Ivanov%s@gmail.com", i)).withMobilePhone(String.format("222-22-222%s", i)).withAddress(String.format("123 Main st. # %s, Chicago, IL ", i)));
    }
    return contacts;
  }
}
