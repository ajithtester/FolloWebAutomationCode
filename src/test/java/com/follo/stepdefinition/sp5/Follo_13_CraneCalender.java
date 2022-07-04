package com.follo.stepdefinition.sp5;

import java.io.IOException;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_13_CraneCalender;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_13_CraneCalender extends Baseclass {



	@Given("User clicks Crane calendar button from the menu")
	public void user_clicks_crane_calendar_button_from_the_menu() throws Throwable {

		try {
			ReportConfig.ReportCreateFeatureTest("To verify the Crane Calendar feature");
			ReportConfig.ReportCreateScenarioTest("To click Crane calendar button from the menu");
			ClickPageUp();
			Wait(2000);
			Click("CraneCalendar", CraneCalenderLocators);

			Print("Crane calendar button is clicked");
			ReportConfig.Givenlogpass("User clicks Crane calendar button from the menu","Crane calendar button is clicked");

		} 
		catch (Exception e) {

			PrintError("Crane calendar button is not clicked");
			ReportConfig.Givenlogfail("User clicks Crane calendar button from the menu","Crane calendar button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane calendar button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}

	@Then("Crane calendar page should display")
	public void crane_calendar_page_should_display() throws Throwable {

		try {

			Waitfortheelement("Calendar", CraneCalenderLocators);

			if(IsElementDisplayed("Calendar", CraneCalenderLocators)){

				Print("Crane calendar page is displayed");
				ReportConfig.Thenlogpass("Crane calendar page should display","Crane calendar page is displayed");

			}
		}
		catch (Exception e) {

			PrintError("Crane calendar page is not displayed");
			ReportConfig.Thenlogfail("Crane calendar page should display","Crane calendar page is not displayed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane calendar page is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}


	}

	@Given("User add new crane request")
	public void user_add_new_crane_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To add new crane request");

			F_13_CraneCalender.AddCraneCalender();	
			ReportConfig.Givenlogpass("User add new crane request","Crane request are added");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User add new crane request","Crane request add failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request add failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	}

	



	@Given("User view Crane request information")
	public void user_view_crane_request_information() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To view a crane request");
			F_13_CraneCalender.ViewCraneRequestInfo();		
			ReportConfig.Givenlogpass("User view Crane request information", "Crane request info viewed successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User view Crane request information" ,"Crane request info view failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request info view failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}

	}


	@Given("User edit a Crane request from the list")
	public void user_edit_a_crane_request_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("To edit a crane request");
			F_13_CraneCalender.EditCraneCalendar();		
			ReportConfig.Givenlogpass("User edit a Crane request from the list", "Crane request edited successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User edit a Crane request from the list" ,"Crane request edit failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request edit failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}

	}

	@Given("User filter the Crane request from the list")
	public void user_filter_the_crane_request_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("To filter a crane request");
			F_13_CraneCalender.FilterCraneCalendar();
			ReportConfig.Givenlogpass("User filter the Crane request from the list", "Crane request filtered successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User filter the Crane request from the list" ,"Crane request filter failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request filter failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	}

	@Given("User add a comment to a crane request in calendar settings")
	public void user_add_a_comment_to_a_crane_request_in_calendar_settings() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User add a comment to a crane request ");
			F_13_CraneCalender.AddComment();
			ReportConfig.Givenlogpass("User add a comment to a crane request in calendar settings", "Comment added to Crane request successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User add a comment to a crane request in calendar settings", "Comment added to Crane request failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Comment added to Crane request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

	@Given("User search and view the crane request in calendar settings")
	public void user_search_and_view_the_crane_request_in_calendar_settings() throws Throwable {
		try {
			ReportConfig.ReportCreateScenarioTest("User add a comment to a crane request ");
			F_13_CraneCalender.Search();
			ReportConfig.Givenlogpass("User search and view the crane request in calendar settings", "Crane request searched successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User search and view the crane request in calendar settings", "Crane request search failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request search failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	}

	@Given("User a crane request in calendar settings to void")
	public void user_a_crane_request_in_calendar_settings_to_void() throws Throwable, IOException {
		try {
			
			ReportConfig.ReportCreateScenarioTest("Push a crane request in calendar settings to void");
			F_13_CraneCalender.PushToVoid();
			ReportConfig.Givenlogpass("Push a crane request in calendar settings to void", "Crane request pushed to void successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("Push a crane request in calendar settings to void", "Crane request push to void failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request push to void failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	}


	@Given("User approve or reject the crane request in calendar settings")
	public void user_approve_or_reject_the_crane_request_in_calendar_settings() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User view and approve or reject the crane request");
			F_13_CraneCalender.ApproveOrRejectCraneCalendar();
			ReportConfig.Givenlogpass("User view and approve or reject the crane request", "Crane request approved or rejected successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User view and approve or reject the crane request", "Crane request approve or reject failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request approve or reject failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

	@Given("User complete the crane requestt in calendar settings")
	public void user_complete_the_crane_requestt_in_calendar_settings() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("User complete the crane request");
			F_13_CraneCalender.Complete();
			ReportConfig.Givenlogpass("User complete the crane request", "Crane request marked completed successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User complete the crane request", "Crane request completed failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request completed failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	}

	@Given("User add attachment to the crane calendar request")
	public void user_add_attachment_to_the_crane_calendar_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User add attachment to the crane calendar request");
			F_13_CraneCalender.AddAttcahment();
			ReportConfig.Givenlogpass("User add attachment to the crane calendar request", "Attcahment added successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User add attachment to the crane calendar request", "Attcahment add failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Attcahment add failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}
	
	@Given("User add a crane request without mandatory feild")
	public void user_add_a_crane_request_without_mandatory_feild() throws Throwable {

		try {
			
			ReportConfig.ReportCreateScenarioTest("User add a crane request without mandatory feild");
			
			F_13_CraneCalender.NegativeMandatory();	
			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			
			ReportConfig.Givenlogfail("User add a crane request without mandatory feild","Crane request add failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User add a crane request without mandatory feild" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}
	
	@Given("User gives invalid time in Crane calendar")
	public void user_gives_invalid_time_in_crane_calendar() throws Throwable {


	try {
			
			ReportConfig.ReportCreateScenarioTest("User gives invalid time in Crane calendar");
			
			F_13_CraneCalender.InValidTime();	
			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			
			ReportConfig.Givenlogfail("User gives invalid time in Crane calendar","Crane request add failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "User gives invalid time in Crane calendar" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			

		}
	}
	
	
	@Given("User edit and save a crane request without company in Crane Calendar")
	public void user_edit_and_save_a_crane_request_without_company_in_crane_calendar() throws Throwable {

	try {
			
			ReportConfig.ReportCreateScenarioTest("User edit and save a crane request without company in Crane Calendar");
			
			F_13_CraneCalender.EditWithoutCompany_Negative();	
			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			
			ReportConfig.Givenlogfail("User edit and save a crane request without company in Crane Calendar","Crane request edit failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User edit and save a crane request without company in Crane Calendar" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	
	}

	@Given("User edit and save a crane request without DFOW in Crane Calendar")
	public void user_edit_and_save_a_crane_request_without_dfow_in_crane_calendar() throws Throwable {

	try {
			
			ReportConfig.ReportCreateScenarioTest("User edit and save a crane request without DFOW in Crane Calendar");
			
			F_13_CraneCalender.EditWithoutDFOW_Negative();	
			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			
			ReportConfig.Givenlogfail("User edit and save a crane request without company in DFOW Calendar","Crane request edit failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User edit and save a crane request without DFOW in Crane Calendar" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	
	}
	
	@Given("User upload a invalid file in attachment in Crane Calendar")
	public void user_upload_a_invalid_file_in_attachment_in_crane_calendar() throws Throwable {

	try {
			
			ReportConfig.ReportCreateScenarioTest("User edit and save a crane request without DFOW in Crane Calendar");
			
			F_13_CraneCalender.EditWithoutDFOW_Negative();	
			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			
			ReportConfig.Givenlogfail("User edit and save a crane request without company in DFOW Calendar","Crane request edit failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User upload a invalid file in attachment in Crane Calendar" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	
	
	}


}
