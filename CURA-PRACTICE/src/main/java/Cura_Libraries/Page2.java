package Cura_Libraries;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Page2 extends Page1 {

	public Page2() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void login_page(String uname, String pwd) {	
		wd.findElement(username).sendKeys(uname);
		wd.findElement(password).sendKeys(pwd);
		wd.findElement(login).click();
	}

}
