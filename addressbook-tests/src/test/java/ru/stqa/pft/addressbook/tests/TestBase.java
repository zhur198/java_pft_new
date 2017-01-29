package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by zhur198 on 12/26/16.
 */
public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

//  @BeforeMethod
//  public void setUp() throws Exception {
//    app.init();
//  }

    @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

//  @AfterMethod
//  public void tearDown() {
//    app.stop();
//  }
//
  @AfterSuite
  public void tearDown() {
  app.stop();
}
}
