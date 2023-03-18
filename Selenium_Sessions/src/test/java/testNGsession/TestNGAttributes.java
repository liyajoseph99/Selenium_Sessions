package testNGsession;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNGAttributes {

  @Test(priority = 2,invocationCount = 5,invocationTimeOut = 30,enabled = false)
  public void apple() {
	  System.out.println("Testcase1");
  }
  

  @Test(priority = 1,enabled = false)
  public void orange() {
	  System.out.println("Testcase2");
  }
  

  @Test(priority = 3,enabled = false)
  public void grapes() {
	  System.out.println("Testcase3");
  }
  

  @Test(enabled = false,description = "ArrayOutofIndex")
  public void pear() {
	  System.out.println("pear");
	  String[] arr= {"rat","mat","cat","pet"};
	  for(int i=0;i<5;i++) {
		  System.out.println(arr[i]);
	  }
  }
  

  @Test(dependsOnMethods = "pear",alwaysRun = true,enabled = false)
  public void mango() {
	  System.out.println("i am depend on pear");
  }
  
  @Test(groups = "sanity")
  public void tomato() {
	  System.out.println("group1");
  }
  
  @Test(groups = "sanity")	//the group this method belongs to
  public void ginger() {
	  System.out.println("group2");
  }
  
  @Test(dependsOnGroups = "sanity")
  public void lemon() {
	  System.out.println("I am depend on group");
  }
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
