package lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Methods {
	
	WebDriver wd;
	JavascriptExecutor js ;
	
	public void init(WebDriver wd) {
		this.wd = wd;
		wd.get("https://testautomationpractice.blogspot.com/");
		js = (JavascriptExecutor) wd ;
	}
	
	public void string_search() {
		wd.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
	}
	
	public void count_and_click_links() {
		List<WebElement> l = wd.findElements(By.xpath("//div[@class='widget-content']//ul/li//a[@href!='#']"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++) {
			
			l.get(i).click();
		}
	}
	
	public void get_windowHandles() {
		
	}
	
	public void close_window() {
		
	}

}
