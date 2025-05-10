package Curatests;

import org.testng.annotations.Test;

import Cura_Libraries.Page1;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class test {
	
	WebDriver wd ;
	Page1 c ;
	
	public test() throws IOException {
		c = new Page1();
	}
	
  @Test
  public void logintest() throws IOException, InterruptedException {
	  c.manipulations();
  }
  
  @BeforeClass
  public void beforeClass() {
	  wd = new EdgeDriver();
	  c.init(wd); 
  }

  @AfterClass
  public void afterClass() {
  }
  
  
  

}
