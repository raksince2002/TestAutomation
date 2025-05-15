package Cura_Libraries;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.CommonTestMethods;

public class Page1 {
	
	WebDriver wd;
	ReadData r ;
	CommonTestMethods c1;
	
	public Page1() throws IOException {
		r = new ReadData();
		c1 = new CommonTestMethods();
	}
	
	protected By makeappoint = By.xpath("//a[@id='btn-make-appointment']");
	
	protected By facility = By.xpath("//select[@id='combo_facility']");
	
	protected By username = By.xpath("//input[@id='txt-username']");
	
	protected By password = By.xpath("//input[@id='txt-password']");
	
	protected By login = By.xpath("//button[@id='btn-login']");
	
	protected By hosre = By.xpath("//input[@id='chk_hospotal_readmission']");
	
	protected By radio = By.xpath("//input[@id='radio_program_medicaid']");
	
	protected By date = By.xpath("//input[@id='txt_visit_date']");
	
	protected By bookappoint = By.xpath("//button[@id='btn-book-appointment']");
	
	protected By appointconfirm = By.xpath("//h2[contains(text(),'Appointment Confirmation')]");
	
	public void init(WebDriver wd) {
		this.wd = wd;
		c1.init_common(wd);
		c1.launch("https://katalon-demo-cura.herokuapp.com");
		c1.Maximize_Browser();
		wd.findElement(makeappoint).click();
	}
	
}
