package Curatests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Cura_Libraries.Page4;
import Cura_Libraries.ReadData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDDCura {
	
	WebDriver wd ;
	Page4 c;
	ReadData r;
	int rtotal;
	
	public BDDCura() throws IOException {
		c = new Page4();
		r = new ReadData();
		rtotal=r.total_rows(0);
	}
	
	@Given("I am in home page of CuraHealth Services and I click on Make Appointment to move to login page")
	public void I_am_in_home_page_of_CuraHealth_Services_and_I_click_on_Make_Appointment_to_move_to_login_page() {
		wd = new EdgeDriver();
		c.init(wd);
	}
	
	@When("I am entering each row details with username, password and I click on Login and I choose the facility, healthcare and date and I click on book appointment and then I either navigate to login page or end the booking session")
	public void I_am_entering_each_row_details_with_username_password_and_I_click_on_Login_and_I_choose_the_facility_healthcare_and_date_and_I_click_on_book_appointment_and_then_I_either_navigate_to_login_page_or_end_the_booking_session() throws IOException{
		for(int i=1;i<rtotal;i++) {
			try {
				  String username=r.read_cell(i, 0, 0);
				  String password=r.read_cell(i, 1, 0);
				  c.login_page(username,password);		  
				  c.choose_facility("Hongkong CURA Healthcare Center");
				  c.click_apply();
				  c.click_radio();
				  c.Date("01/12/2000");
				  c.Bookappo();
				  r.set_cell(i, 3, "Passed", 0);
				  c.ss(i);
			  }
			  catch(Exception e) {		  
				  r.set_cell(i, 3, "Failed", 0);
			  }
		}
	}
	
	@Then("I display the status of result of each row")
	public void I_display_the_status_of_result_of_each_row() {
		for(int i=1;i<rtotal;i++) {			
			String result = r.read_cell(i, 3, 0);
			System.out.println("Test "+result);
		}
	}
	
	
}
