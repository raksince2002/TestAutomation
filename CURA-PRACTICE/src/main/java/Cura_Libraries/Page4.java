package Cura_Libraries;

import java.io.IOException;

import org.openqa.selenium.By;

public class Page4 extends Page3 {

	public Page4() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void ss(Integer number) throws InterruptedException, IOException {
		c1.capture_ss("img"+Integer.toString(number), "Screenshots");
		int i = (int) number;
		int rtotal = r.total_rows(0);
		if(i!=rtotal-1) {
			wd.findElement(By.xpath("//a[@id='menu-toggle']")).click();
			wd.findElement(By.xpath("(//nav//ul//li//a)[5]")).click();				
		}
		else {
			r.file_close();
		}
	}

}
