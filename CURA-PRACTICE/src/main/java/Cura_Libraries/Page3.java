package Cura_Libraries;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page3 extends Page2 {

	public Page3() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void choose_facility(String s) {
		WebElement we = wd.findElement(facility);
		Select s1 = new Select(we);
		s1.selectByVisibleText(s);
	}
	
	public void click_apply() throws InterruptedException {
		wd.findElement(hosre).click();
	}
	
	public void click_radio() throws InterruptedException {
		wd.findElement(radio).click();
	}
	
	public void Date(String s) throws InterruptedException {
		wd.findElement(date).sendKeys(s);
	}
	
	public void Bookappo() throws InterruptedException {
		wd.findElement(bookappoint).click();
	}

}
