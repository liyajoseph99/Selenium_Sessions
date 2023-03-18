package testNGsession;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAnnotations {
  @Test
  public void test1() {
	   System.out.println("I am a testcase1");
  }
  @Test
  public void test2() {
	  System.out.println("I am a testcase2");
  }
  @Test
  public void test3() {
	  System.out.println("I am a testcase3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("I am beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("I am afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("I am beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("I am afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("I am beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("I am afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("I am beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("I am afterSuite");
  }

}
