package Curatests;

import org.testng.annotations.Test;

import Cura_Libraries.Page1;
import Cura_Libraries.Page4;
import Cura_Libraries.ReadData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class test {
	
	WebDriver wd ;
	Page4 c ;
	ReadData r ;
	static int i = 1;
	
	public test() throws IOException {
		c = new Page4();
		r = new ReadData();
	}
	
  @Test(dataProvider="dp", priority = 1)
  public void logintest(String UserName, String Password) throws IOException, InterruptedException {
	  c.login_page(UserName, Password);
  }
  
  @Test(dataProvider="dp",priority = 2)
  public void choosetest(String UserName, String Password) throws IOException, InterruptedException {
	  try {
		  c.choose_facility("Hongkong CURA Healthcare Center");
	  }
	  catch(Exception e){
		  System.out.println("Test Failed");
		  r.set_cell(i, 3, "Failed", 0);
		  i++;
	  }
  }
  
  @Test(dataProvider="dp",dependsOnMethods= {"choosetest"}, priority = 3)
  public void click_apply(String UserName, String Password) throws InterruptedException {
	  c.click_apply();
  }
  
  
  @Test(dataProvider="dp",dependsOnMethods= {"choosetest"}, priority = 4)
  public void click_radio(String UserName, String Password) throws InterruptedException {
	  c.click_radio();
  }
  
  @Test(dataProvider="dp",dependsOnMethods= {"choosetest"}, priority = 5)
  public void choose_date(String UserName, String Password) throws InterruptedException {
	  c.Date("01/12/2000");
  }
  
  @Test(dataProvider="dp",dependsOnMethods= {"choosetest"}, priority = 6)
  public void click_book(String UserName, String Password) throws InterruptedException {
	  c.Bookappo();
  }
  
  @Test(dataProvider="dp",dependsOnMethods= {"choosetest"}, priority = 7)
  public void screenshot(String UserName, String Password) throws InterruptedException, IOException {
	  System.out.println("Test Passed");
	  r.set_cell(i, 3, "Passed", 0);
	  c.ss(i);
	  i++;
  }
  
  @BeforeClass
  public void beforeClass() {
	  wd = new EdgeDriver();
	  c.init(wd); 
  }
  
  @DataProvider(name="dp")
  Object[][] login_data(){
	  int rtotal = r.total_rows(0);
	  int ctotal = r.total_columns(0)-2;
	  Object data[][] = new Object[rtotal-1][ctotal];
	  for(int i=1;i<rtotal;i++) {
		  for(int j=0;j<ctotal;j++) {
			  data[i-1][j]=r.read_cell(i, j, 0);
		  }
	  }
	  return data;
  }

  @AfterClass
  public void afterClass() {
	  
  }
  
  
  

}
