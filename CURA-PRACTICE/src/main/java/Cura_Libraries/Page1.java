package Cura_Libraries;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page1 {
	
	WebDriver wd;
	ReadData r ;
	CommonTestMethods c1;
	
	public Page1() throws IOException {
		r = new ReadData();
		c1 = new CommonTestMethods();
	}
	
	public void init(WebDriver wd) {
		this.wd = wd;
		wd.get("https://katalon-demo-cura.herokuapp.com");
		wd.manage().window().maximize();
	}
	
	
	public void manipulations() throws IOException {
		wd.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
		int rtotal = r.total_rows(0);
		for(int i=1;i<rtotal;i++) {
			try {
				wd.findElement(By.xpath("//input[@id='txt-username']")).sendKeys(r.read_cell(i, 0, 0));						
				wd.findElement(By.xpath("//input[@id='txt-password']")).sendKeys(r.read_cell(i, 1, 0));						
				wd.findElement(By.xpath("//button[@id='btn-login']")).click();
				WebElement we = wd.findElement(By.xpath("//select[@id='combo_facility']"));
				Select s1 = new Select(we);
				s1.selectByVisibleText("Hongkong CURA Healthcare Center");
				wd.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
				wd.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();
				wd.findElement(By.xpath("//input[@id='txt_visit_date']")).sendKeys("01/12/2000");
				wd.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
				System.out.println("Test Passed");
				r.set_cell(i, 3, "Passed", 0);
				if(i!=rtotal-1) {
					wd.findElement(By.xpath("//a[@id='menu-toggle']")).click();
					wd.findElement(By.xpath("(//nav//ul//li//a)[5]")).click();
					wd.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();					
				}
				else {
					r.file_close();
				}
			}
			catch(Exception e) {
				System.out.println("Test Failed");
				r.set_cell(i, 3, "Failed", 0);
			}
		}
		
	}
	
	
	
}
