package com.follo.stepdefinition.sp7;

import java.io.IOException;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_17_ConcreteRequest;

import io.cucumber.java.en.Given;
import report.ReportConfig;

public class Follo_17_ConcreteRequest extends Baseclass {
	
	@Given("User clicks All requests button from the menu to click Concrete")
	public void user_clicks_all_requests_button_from_the_menu_to_click_concrete() throws Throwable {
		
		try {
			ReportConfig.ReportCreateFeatureTest("To verify concrete requests feature");

			ReportConfig.ReportCreateScenarioTest("User clicks All requests button from the menu to click Concrete");

			Wait(2000);
			Click("ConcreteRequest.AllRequests", ConcreteRequestLocators);

			Print("Click on All requests button");
			ReportConfig.Givenlogpass("User clicks All requests button from the menu to click Concrete","Click on All requests button");

		} 
		catch (Exception e) {

			PrintError("All requests button is not clicked");
			ReportConfig.Givenlogfail("User clicks All requests button from the menu to click Concrete","All requests button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "All requests button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	    
	}

	@Given("User clicks Concrete requests button from the menu")
	public void user_clicks_concrete_requests_button_from_the_menu() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User clicks Concrete requests button from the menu");

			Wait(2000);
			Click("ConcreteRequest.Requests", ConcreteRequestLocators);

			Print("Click on Concrete requests button");
			ReportConfig.Givenlogpass("User clicks All requests button from the menu to click Concrete","Click on Concrete requests button");

		} 
		catch (Exception e) {

			PrintError("Concrete requests button is not clicked");
			ReportConfig.Givenlogfail("User clicks All requests button from the menu to click Concrete","Concrete requests button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Concrete requests button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	    
	}

	@Given("User add new Concrete request")
	public void user_add_new_concrete_request() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User add new Concrete request");

			Wait(2000);

			F_17_ConcreteRequest.AddConcreteRequest();	

			//ReportConfig.Givenlogpass("User add new Concrete request","Concrete request is added successfully");

		} 
		catch (Exception e) {

			PrintError("Add concrete request is failed");
			ReportConfig.Givenlogfail("User add new Concrete request","Add concrete request is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add concrete request is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	}

	@Given("User search the Concrete request from the list")
	public void user_search_the_concrete_request_from_the_list() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User search the Concrete request from the list");

			Wait(2000);

			F_17_ConcreteRequest.SearchConcreteRequest();	

			//ReportConfig.Givenlogpass("User search the Concrete request from the list","Concrete request is searched successfully");

		} 
		catch (Exception e) {

			PrintError("Search concrete request is failed");
			ReportConfig.Givenlogfail("User search the Concrete request from the list","Search concrete request is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Search concrete request is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	}

	@Given("User edit a Concrete request from the list")
	public void user_edit_a_concrete_request_from_the_list() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User edit a Concrete request from the list");

			Wait(2000);

			F_17_ConcreteRequest.EditConcreteRequest();	

			//ReportConfig.Givenlogpass("User edit a Concrete request from the list","Concrete request is added successfully");

		} 
		catch (Exception e) {

			PrintError("Edit concrete request failed");
			ReportConfig.Givenlogfail("User edit a Concrete request from the list","Edit concrete request is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Edit concrete request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}

	@Given("User filter the Concrete request from the list")
	public void user_filter_the_concrete_request_from_the_list() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User filter the Concrete request from the list");

			Wait(2000);

			F_17_ConcreteRequest.FilterConcreteRequest();	

			//ReportConfig.Givenlogpass("User filter the Concrete request from the list","Concrete request is filtered successfully");

		} 
		catch (Exception e) {

			PrintError("Filter concrete request is failed");
			ReportConfig.Givenlogfail("User filter the Concrete request from the list","Filter concrete request is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Filter concrete request is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	    
	}

	@Given("User view info and history, add comment, add attachment to the Concrete request")
	public void user_view_info_and_history_add_comment_add_attachment_to_the_concrete_request() throws Throwable {
		

		try {
			ReportConfig.ReportCreateScenarioTest("User view info and history, add comment, add attachment to the Concrete request");

			Wait(2000);

			F_17_ConcreteRequest.ConcreteRequestInfo();	

			//ReportConfig.Givenlogpass("User view info and history, add comment, add attachment to the Concrete request","Concrete request is added successfully");

		} 
		catch (Exception e) {

			PrintError("View info and history is failed");
			ReportConfig.Givenlogfail("User view info and history, add comment, add attachment to the Concrete request","View info and history is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "View info and history is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	    
	}

	@Given("User Approve and Complete a concrete request from the list")
	public void user_approve_and_complete_a_concrete_request_from_the_list() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User Approve and Complete a concrete request from the list");
			Wait(2000);
			F_17_ConcreteRequest.ApproveAndComplete();	

			//ReportConfig.Givenlogpass("User Approve and Complete a concrete request from the list","Concrete request approved and completed successfully");

		} 
		catch (Exception e) {

			PrintError("Concrete request approve and complete is failed");
			ReportConfig.Givenlogfail("User Approve and Complete a concrete request from the list","Concrete request approve and complete is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Concrete request approve and complete is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	    
	}

	@Given("User add pump to the concrete request in the list")
	public void user_add_pump_to_the_concrete_request_in_the_list() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User add pump to the concrete request in the list");

			Wait(2000);

			F_17_ConcreteRequest.AddPump();	

			//ReportConfig.Givenlogpass("User add pump to the concrete request in the list","Pump added successfully");

		} 
		catch (Exception e) {

			PrintError("Add pump failed");
			ReportConfig.Givenlogfail("User add pump to the concrete request in the list","Add pump failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add pump failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	    
	}

	@Given("User push a Concrete request from the list")
	public void user_push_a_concrete_request_from_the_list() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User push a Concrete request from the list");

			Wait(2000);

			F_17_ConcreteRequest.VoidConcreteRequest();	

		//	ReportConfig.Givenlogpass("User push a Concrete request from the list","Concrete request is pushed to void successfully");

		} 
		catch (Exception e) {

			PrintError("Request push to void is failed");
			ReportConfig.Givenlogfail("User push a Concrete request from the list","Request push to void is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Request push to void is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	    
	}

	@Given("User add new Concrete request without filling mandatory field")
	public void user_add_new_concrete_request_without_filling_mandatory_field() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User add new Concrete request without filling mandatory field");

			Wait(2000);

			F_17_ConcreteRequest.NegativeMandatory();	


		} 
		catch (Exception e) {

			PrintError("Add Concrete request failed");
			ReportConfig.Givenlogfail("User add new Concrete request without filling mandatory field","Add Concrete request failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add Concrete request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
		
	    
	    
	}

	@Given("User add new Concrete request with invalid date and time")
	public void user_add_new_concrete_request_with_invalid_date_and_time() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User add new Concrete request with invalid date and time");

			Wait(2000);

			F_17_ConcreteRequest.AddInviteDateAndTime();	


		} 
		catch (Exception e) {

			PrintError("Add Concrete request failed");
			ReportConfig.Givenlogfail("User add new Concrete request with invalid date and time","Add Concrete request failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add Concrete request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	    
	}

	@Given("User add invalid file in Concrete request")
	public void user_add_invalid_file_in_concrete_request() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("User add invalid file in Concrete request");

			Wait(2000);

			F_17_ConcreteRequest.InvalidFile();	


		} 
		catch (Exception e) {

			PrintError("Add Concrete request failed");
			ReportConfig.Givenlogfail("User add invalid file in Concrete request","Add attachment failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add Concrete request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}
	
	@Given("User delete Concrete request")
	public void user_delete_concrete_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User delete Concrete request");

			Wait(2000);

			F_17_ConcreteRequest.DeleteConcreteRequest();	


		} 
		catch (Exception e) {

			PrintError("Delete concrete request failed");
			ReportConfig.Givenlogfail("User delete Concrete request","Delete concrete request failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Delete concrete request failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
		
	}
	
	

}
