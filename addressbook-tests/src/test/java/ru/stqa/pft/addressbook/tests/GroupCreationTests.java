package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().groupPage();
//    Set<GroupData> before = app.group().all();
//    int before = app.group().getGroupCount();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
//    Set<GroupData> after = app.group().all();
    Groups after = app.group().all();
//    int after = app.group().getGroupCount();
//    Assert.assertEquals(after.size(), before.size() + 1);
    assertThat(after.size(), equalTo(before.size() + 1));

//    before.add(group);
//    Assert.assertEquals(before, after);
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
