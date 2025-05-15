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
	Integer i = 1;
	
	public test() throws IOException {
		c = new Page4();
		r = new ReadData();
	}
	
  @Test(dataProvider="dp")
  public void data_driven_test(String UserName, String Password) throws IOException, InterruptedException {
	  try {
		  c.login_page(UserName, Password);		  
		  c.choose_facility("Hongkong CURA Healthcare Center");
		  c.click_apply();
		  c.click_radio();
		  c.Date("01/12/2000");
		  c.Bookappo();
		  System.out.println("Test Passed:");
		  r.set_cell(i, 3, "Passed", 0);
		  c.ss(i);
		  i++;
	  }
	  catch(Exception e) {		  
		  System.out.println("Test Failed:");
		  r.set_cell(i, 3, "Failed", 0);
		  i++;
	  }
  }
  
  @BeforeClass
  public void beforeClass() {
	  wd = new EdgeDriver();
	  c.init(wd); 
  }
  
  @DataProvider(name="dp")
  Object[][] login_data(){
	  int rtotal1 = r.total_rows(0);
	  int ctotal1 = r.total_columns(0)-2;
	  Object data[][] = new Object[rtotal1-1][ctotal1];
	  for(int i=1;i<rtotal1;i++) {
		  for(int j=0;j<ctotal1;j++) {
			  data[i-1][j]=r.read_cell(i, j, 0);
		  }
	  }
	  return data;
  }

  @AfterClass
  public void afterClass() {
	  
  }
  
  
  

}
