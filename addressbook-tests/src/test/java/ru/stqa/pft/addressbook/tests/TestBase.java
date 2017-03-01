package ru.stqa.pft.addressbook.tests;

import org.omg.CORBA.Object;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by zhur198 on 12/26/16.
 */
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);


  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

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
  @AfterSuite (alwaysRun = true)
  public void tearDown() {
  app.stop();
}

//  /**
//   * Use this for logging info, errors, messages, etc.
//   */
//
//  @BeforeMethod
//  public void logTestStart(Method m, Object[] p) {
//    logger.info("Start test " + m.getName() + " with parametrs " + Arrays.asList(p));
//  }
//
//  @AfterMethod (alwaysRun = true)
//  public void logTestStop(Method m) {
//    logger.info("Stop test " + m.getName());
//  }
}
