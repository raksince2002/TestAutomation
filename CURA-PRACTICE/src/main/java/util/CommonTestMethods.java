package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class CommonTestMethods {

	WebDriver wd;
	JavascriptExecutor js;
	Actions act;
	
	public void init_common(WebDriver wd) {
		this.wd= wd;
		js = (JavascriptExecutor) wd;
		act = new Actions(wd);
	}
	
	public void launch(String url) {
		wd.get(url);
	}
	
	public void Maximize_Browser() { 
		wd.manage().window().maximize();
	} 
	
	public void Minimize_Browser() {
		wd.manage().window().minimize();
	}
	
	public void implicit_wait(int t) { 
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(t)); 
	} 
	
	public void explicit_wait(int t, String xPath) {
		WebDriverWait ww = new WebDriverWait(wd,Duration.ofSeconds(t));
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}
	
	public void capture_ss(String f1, String sdir) throws IOException { 
		File sr = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);  //TakesScreenshot is an interface for automation of screenshot. Outputtype is used to store a file
		
		Files.copy(sr, new File(sdir+"/"+f1+".png")); //Filepath
		
	} 
	
	public void scrollDownDemo(int s) {
		js.executeScript("scroll(0,"+s+")");
	}
	
	public void scroll_To_Element(WebElement we) {
		js.executeScript("arguments[0].scrollIntoView();", we);
	}
	
	public void scroll_By_Pixels(WebElement w,int x, int y) {
		js.executeScript("arguments[0].scrollBy("+x+","+y+")", w);
	}
	
	public void js_click(WebElement w) { // alternative to click() method using WebElement
		js.executeScript("arguments[0].click()", w);
	}
	
	public void js_sendkeys(WebElement w, String s) {
		js.executeScript("arguments[0].setAttribute('value','"+s+"'", w);
	}
	
	public void scroll_bottom() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scroll_top() {
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	public String current_window() {
		return wd.getWindowHandle();
	}
	
	public void mouse_hover(WebElement w) {
		act.moveToElement(w).click().build().perform();
	}
	
	public void double_click(WebElement w) {
		act.doubleClick(w).perform();
	}
	
	public void context_click(WebElement w) {
		act.contextClick(w).perform();
	}
	
	public void drag_and_drop(WebElement src, WebElement dest) {
		act.dragAndDrop(src, dest).perform();
	}
		
	public void navigate_to(String url) {
		wd.navigate().to(url); 
	}
	
	public void navigate_back() {
		wd.navigate().back();
	}
	
	public void navigate_forward() {
		wd.navigate().forward();
	}
	
	public void reload_page() {
		wd.navigate().refresh();
	}
	
	public void close() {
		if(wd!=null) {
			wd.quit();
		}
	}
	
}