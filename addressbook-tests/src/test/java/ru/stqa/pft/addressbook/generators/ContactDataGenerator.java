package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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

  @Parameter(names = "-cc", description = "Contact count")
  public int count;

  @Parameter (names = "-cf", description = "Target file")
  public String file;

  public static void main (String[] args) throws IOException {

    ContactDataGenerator gererator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(gererator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    gererator.run();

//    int count = Integer.parseInt(args [0]);
//    File file = new File(args[1]);
  }

  private void run() throws IOException {
    List <ContactData> groups = generateContacts(count);
    save(groups, new File (file));
  }

  private void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname()
              , contact.getEmail(), contact.getMobilePhone(), contact.getAddress()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("Ivan %s", i)).withLastname(String.format("Ivanov %s", i))
              .withEmail(String.format("Ivanov%s@gmail.com", i)).withMobilePhone(String.format("222-22-222%s", i)).withAddress(String.format("123 Main st. # %s, Chicago, IL ", i)));
    }
    return contacts;
  }
}
