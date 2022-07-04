package com.follo.stepdefinition.sp7;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_16_ConcreteCalendar;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_16_ConcreteCalendar extends Baseclass {

	@Given("User clicks Crane Concrete button from the menu")
	public void user_clicks_crane_concrete_button_from_the_menu() throws Throwable {

		try {
			ReportConfig.ReportCreateFeatureTest("To verify the Concrete Calendar feature");
			ReportConfig.ReportCreateScenarioTest("User clicks Crane Concrete button from the menu");

			Wait(2000);
			Click("Concrete.Calendar", ConcreteCalendarLocators);

			Print("Concrete calendar button is clicked");
			ReportConfig.Givenlogpass("User clicks Crane calendar button from the menu","Concrete calendar button is clicked");

		} 
		catch (Exception e) {

			PrintError("Concrete calendar button is not clicked");
			ReportConfig.Givenlogfail("User clicks Concrete calendar button from the menu","Concrete calendar button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Concrete calendar button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}

	}

	@Then("Concrete calendar page should display")
	public void concrete_calendar_page_should_display() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Concrete calendar page should display");

			Wait(2000);
			Waitfortheelement("Concrete.DateAndMonth", ConcreteCalendarLocators);
			Click("Concrete.DateAndMonth", ConcreteCalendarLocators);

			Print("Concrete page is displayed");
			ReportConfig.Givenlogpass("Concrete calendar page should display","Concrete page is displayed");

		} 
		catch (Exception e) {

			PrintError("Concrete page button is not displayed");
			ReportConfig.Givenlogfail("Concrete calendar page should display","Concrete page is not displayed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Concrete page is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}

	@Given("User add new Concrete calendar request")
	public void user_add_new_concrete_calendar_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User add new Concrete calendar request");

			Wait(2000);

			F_16_ConcreteCalendar.AddConcreteRequest();	

			ReportConfig.Givenlogpass("User add new Concrete request","Concrete request is added successfully");

		} 
		catch (Exception e) {

			PrintError("Add concrete calendar request is failed");
			ReportConfig.Givenlogfail("User add new Concrete request","Add concrete request is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add concrete calendar request is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}

	@Given("User search the Concrete request in calendar")
	public void user_search_the_concrete_request_in_calendar() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User search the Concrete request");

			Wait(2000);

			F_16_ConcreteCalendar.SearchConcreteRequest();	

			ReportConfig.Givenlogpass("User search the Concrete request","Concrete request is searched successfully");

		} 
		catch (Exception e) {

			PrintError("Search concrete calendar request is failed");
			ReportConfig.Givenlogfail("User search the Concrete request","Search concrete request is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Search concrete calendar request is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}
	
	@Given("User filter the Concrete request in calendar")
	public void user_filter_the_concrete_request_in_calendar() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User filter the Concrete request in calendar");

			Wait(2000);

			F_16_ConcreteCalendar.FilterConcreteRequest();	

			ReportConfig.Givenlogpass("User filter the Concrete request in calendar","Concrete request is filtered successfully");

		} 
		catch (Exception e) {

			PrintError("Filter concrete calendar request is failed");
			ReportConfig.Givenlogfail("User filter the Concrete request in calendar","Filter concrete request is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Filter concrete calendar request is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
		
		
	}


	@Given("User view info and history, add comment, add attachment to the Concrete calendar request")
	public void user_view_info_and_history_add_comment_add_attachment_to_the_concrete_calendar_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To view info and history, add comment, add attachment to the Concrete request");

			Wait(2000);

			F_16_ConcreteCalendar.ConcreteCalendarInfo();	

			ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request","Concrete request is added successfully");

		} 
		catch (Exception e) {

			PrintError("View info and history is failed");
			ReportConfig.Givenlogfail("To view info and history, add comment, add attachment to the Concrete request","View info and history is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "View info and history is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}

	}


	@Given("User edit a Concrete request from the calendar")
	public void user_edit_a_concrete_request_from_the_calendar() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User edit a Concrete request from the calendar");

			Wait(2000);

			F_16_ConcreteCalendar.EditConcreteRequest();	

			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar","Concrete request is added successfully");

		} 
		catch (Exception e) {

			PrintError("Edit concrete calendar request failed");
			ReportConfig.Givenlogfail("User edit a Concrete request from the calendar","Edit concrete request is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Edit concrete calendar request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}

	@Given("User push a Concrete request from the calendar")
	public void user_push_a_concrete_request_from_the_calendar() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User push a Concrete request from the calendar");

			Wait(2000);

			F_16_ConcreteCalendar.VoidConcreteRequest();	

			ReportConfig.Givenlogpass("User push a Concrete request from the calendar","Concrete request is pushed to void successfully");

		} 
		catch (Exception e) {

			PrintError("Concrete calendar request push to void is failed");
			ReportConfig.Givenlogfail("User push a Concrete request from the calendar","Request push to void is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Concrete calendar request push to void is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
		
		
	}
	
	@Given("User Approve and Complete a concrete request in the calendar")
	public void user_approve_and_complete_a_concrete_request_in_the_calendar() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Approve and Complete a concrete request in the calendar");

			Wait(2000);

			F_16_ConcreteCalendar.ApproveAndComplete();	

			ReportConfig.Givenlogpass("User Approve and Complete a concrete calendar request in the calendar","Concrete request approved and completed successfully");

		} 
		catch (Exception e) {

			PrintError("Concrete request approve and complete is failed");
			ReportConfig.Givenlogfail("User Approve and Complete a concrete calendar request in the calendar","Concrete request approve and complete is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Concrete request approve and complete is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}
	
	@Given("User add pump to the concrete request in concrete calendar")
	public void user_add_pump_to_the_concrete_request_in_concrete_calendar() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Add pump to the concrete request in concrete calendar");

			Wait(2000);

			F_16_ConcreteCalendar.AddPump();	

			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar","Pump added successfully");

		} 
		catch (Exception e) {

			PrintError("Concrete calendar add pump failed");
			ReportConfig.Givenlogfail("User add pump to the concrete request in concrete calendar","Add pump failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Concrete calendar add pump failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}
	
	@Given("User add new Concrete calendar request without filling mandatory field")
	public void user_add_new_concrete_calendar_request_without_filling_mandatory_field() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User add new Concrete request without filling mandatory field");

			Wait(2000);

			F_16_ConcreteCalendar.NegativeMandatory();	


		} 
		catch (Exception e) {

			PrintError("Add Concrete calendar request failed");
			ReportConfig.Givenlogfail("User add new Concrete request without filling mandatory field","Add Concrete request failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add Concrete calendar request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
		
	  
	}

	@Given("User add new Concrete calendar request with invalid date and time")
	public void user_add_new_concrete_calendar_request_with_invalid_date_and_time() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User add new Concrete request with invalid date and time");

			Wait(2000);

			F_16_ConcreteCalendar.AddInviteDateAndTime();	


		} 
		catch (Exception e) {

			PrintError("Add Concrete calendar request failed");
			ReportConfig.Givenlogfail("User add new Concrete request with invalid date and time","Add Concrete request failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add Concrete calendar request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}
	
	@Given("User add invalid file in Concrete calendar request")
	public void user_add_invalid_file_in_concrete_calendar_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User add invalid file in Concrete request");
			Wait(2000);
			F_16_ConcreteCalendar.InvalidFile();	

		} 
		catch (Exception e) {

			PrintError("Add Concrete calendar request failed");
			ReportConfig.Givenlogfail("User add invalid file in Concrete request","Add attachment failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add Concrete calendar request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
		
	}
	
	

}
