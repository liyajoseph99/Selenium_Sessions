package testNGsession;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNGAnnotationAttributes {
  @Test(priority = 2,dependsOnMethods = "orange",alwaysRun = true)
  public void mango() {
	  System.out.println("Mango");
  }
  
  @Test(dependsOnGroups = "test",alwaysRun = true)
  public void lemon() {
	  System.out.println("lemon");
  }
  
  @Test(groups = "test")	//the group this method belongs to
  public void grape() {
	  System.out.println("grape");
	  String[] arr= {"rat","mat","cat","pet"};
	  for(int i=0;i<5;i++) {
		  System.out.println(arr[i]);
	  }
  }
  
  @Test(priority = 1)
  public void orange() {
	  System.out.println("Orange");
  }
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
