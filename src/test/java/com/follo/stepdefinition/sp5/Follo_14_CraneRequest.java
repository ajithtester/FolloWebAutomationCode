package com.follo.stepdefinition.sp5;

import java.io.IOException;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_10_DeliveryRequest;
import com.follo.module.method.F_13_CraneCalender;
import com.follo.module.method.F_14_CraneRequest;

import io.cucumber.java.en.Given;
import report.ReportConfig;

public class Follo_14_CraneRequest extends Baseclass{

	@Given("User clicks All requests button from the menu to click crane")
	public void user_clicks_all_requests_button_from_the_menu_to_click_crane() throws Throwable {

		try {

			Wait(3000);
			ReportConfig.ReportCreateFeatureTest("To verify the Crane requests feature");
			ReportConfig.ReportCreateScenarioTest("Click All requests button from the menu to click crane");
			if(IsElementDisplayed("AllRequest", DeliveryRequestLocators)) {

				JsClick("AllRequest", DeliveryRequestLocators);
				Wait(2000);
				ClickPageDown();
				Print("All request button is clicked");
				ReportConfig.Givenlogpass("User clicks All requests button from the menu","All request button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("All request button is not clicked");
			ReportConfig.Givenlogfail("User clicks All requests button from the menu","All request button is clicked because : " + e.getMessage());
		
			String IssueSummary = e.getMessage() ;
			String Storydescription = "All request button is clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}	    
	}

	@Given("User clicks Crane requests button from the menu")
	public void user_clicks_crane_requests_button_from_the_menu() throws Throwable {

		try {
			Wait(2000);
			ReportConfig.ReportCreateScenarioTest("To click Crane requests button from the menu");
			Waitfortheelement("CraneRequest", CraneRequestLocators);
			if(IsElementDisplayed("CraneRequest", CraneRequestLocators)) {
				Print("Crane request button is displayed");
				Click("CraneRequest", CraneRequestLocators);
				Print("Crane request button is clicked");
				ReportConfig.Givenlogpass("User clicks Crane requests button from the menu","Crane request button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Crane request button is not clicked");
			ReportConfig.Givenlogfail("User clicks Crane requests button from the menu","Crane request button is not clicked because : " + e.getMessage());

			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
			
		}

	}

	@Given("User add new Crane request")
	public void user_add_new_crane_request() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("To add new Crane request");
			F_14_CraneRequest.AddCraneRequest();	
			ReportConfig.Givenlogpass("User add new Crane request","New crane request is added");



		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User add new Crane request","New crane request is not added because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "New crane request is not added" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

	@Given("User view the Crane request information")
	public void user_view_the_crane_request_information() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("To view Crane request");
			F_14_CraneRequest.ViewCraneRequestInfo();	
			ReportConfig.Givenlogpass("User view the Crane request information","Crane request info is viewed");



		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User view the Crane request information","Crane request info view is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request info view is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	}


	@Given("User edit a crane request from the list")
	public void user_edit_a_crane_request_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To edit Crane request");
			F_14_CraneRequest.EditCraneRequest();
			ReportConfig.Givenlogpass("User edit a crane request from the list","Crane request edit is successfull");



		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User edit a crane request from the list","Crane request edit is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request info edit is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

	@Given("User filter crane request from the list")
	public void user_filter_crane_request_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To filter Crane request");
			F_14_CraneRequest.FilterCraneRequest();	
			ReportConfig.Givenlogpass("User filter crane request from the list","Crane request filter is successfull");


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User filter crane request from the list","Crane request filter is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request filter is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

	@Given("User search and view the crane request from the list")
	public void user_search_and_view_the_crane_request_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To search Crane request");

			F_14_CraneRequest.SearchCraneRequest();	
			ReportConfig.Givenlogpass("User search and view the crane request from the list","Crane request search is successfull");

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and view the crane request from the list","Crane request search is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request search is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	}

	@Given("User push a crane request to void")
	public void user_push_a_crane_request_to_void() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To push a crane request to void");

			F_14_CraneRequest.CranePushToVoid();
			ReportConfig.Givenlogpass("User push a crane request to void","Crane request is pushed to void successfully");



		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User push a crane request to void","Crane request void push is failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request void push is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	}

	@Given("User complete the request")
	public void user_complete_the_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To complete the request");
			F_14_CraneRequest.CompleteRequest();	
			ReportConfig.Givenlogpass("User complete the request","Crane request is marked complete successfully");



		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User complete the request","Crane request is not marked completed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request is not marked completed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	}

	@Given("User approve or reject the crane request")
	public void user_approve_or_reject_the_crane_request() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User view and approve or reject the crane request");
			F_14_CraneRequest.CraneApproveReject();	
			ReportConfig.Givenlogpass("User approve or reject the crane request","Crane request is approved or rejected successfully");

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User approve or reject the crane request","Crane request approve or reject failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request approve or reject failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	}

	@Given("User add a comment to a crane request")
	public void user_add_a_comment_to_a_crane_request() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("To add a comment to a crane request");
			F_14_CraneRequest.Comment();	
			ReportConfig.Givenlogpass("User add a comment to a crane request","Comment added successfully");


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User add a comment to a crane request","Comment add failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Comment add failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	}

	@Given("User add attachment to the crane request")
	public void user_add_attachment_to_the_crane_request() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("User add attachment to the crane request");
			F_14_CraneRequest.Attachment();	
			ReportConfig.Givenlogpass("User add attachment to the crane request","Attachment added successfully");


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User add attachment to the crane request","Attachment add failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Attachment add failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}

	}

	@Given("User view the history of the crane request")
	public void user_view_the_history_of_the_crane_request() throws Throwable {



		try {
			ReportConfig.ReportCreateScenarioTest("User view the history of the crane request");
			F_14_CraneRequest.ViewHistoryInfo();	
			ReportConfig.Givenlogpass("User view the history of the crane request","History viewed successfully");


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User view the history of the crane request","History view failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "History view failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	}

	@Given("User add a Crane request without mandatory feild")
	public void user_add_a_crane_request_without_mandatory_feild() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User add a Crane request without mandatory feild");

			F_14_CraneRequest.NegativeMandatory();	

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	

			ReportConfig.Givenlogfail("User add a Crane request without mandatory feild","Crane request add failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Crane request add failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

	@Given("User gives invalid time in Crane request")
	public void user_gives_invalid_time_in_crane_request() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User gives invalid time in Crane request");

			F_14_CraneRequest.InValidTime();	

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	

			ReportConfig.Givenlogfail("User gives invalid time in Crane request","Crane request add failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "User gives invalid time in Crane request" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	}

	@Given("User edit and save a crane request without company in Crane request")
	public void user_edit_and_save_a_crane_request_without_company_in_crane_request() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User edit and save a crane request without company in Crane request");

			F_14_CraneRequest.EditWithoutCompany_Negative();	

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	

			ReportConfig.Givenlogfail("User edit and save a crane request without company in Crane request","Crane request edit failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User edit and save a crane request without company in Crane request" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

	@Given("User edit and save a crane request without DFOW in Crane request")
	public void user_edit_and_save_a_crane_request_without_dfow_in_crane_request() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User edit and save a crane request without DFOW in Crane request");

			F_14_CraneRequest.EditWithoutDFOW_Negative();	

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	

			ReportConfig.Givenlogfail("User edit and save a crane request without company in DFOW request","Crane request edit failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User edit and save a crane request without DFOW in Crane request" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

	@Given("User upload a invalid file in attachment in Crane request")
	public void user_upload_a_invalid_file_in_attachment_in_crane_request() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("To upload a invalid file in attachment in Crane request");

			F_14_CraneRequest.NegativeAttachment();	

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	

			ReportConfig.Givenlogfail("User upload a invalid file in attachment in Crane request","Attachment add failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User upload a invalid file in attachment in Crane request" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

}
