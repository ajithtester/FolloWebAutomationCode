package com.follo.stepdefinition.sp4;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_11_QueuedRequest;
import com.follo.module.method.F_12_CalendarSettings;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import report.ReportConfig;

public class Follo_12_CalendarSettings extends Baseclass {
	
	
	@Given("User clicks settings button from the menu")
	public void user_clicks_settings_button_from_the_menu() throws Throwable {
		

		try {
			ReportConfig.ReportCreateFeatureTest("To verify the Calendar settings feature");
			ReportConfig.ReportCreateScenarioTest("To click settings button from the menu");

			Click("Settings", CalendarSettingsLocators);
			Wait(2000);
			ClickPageDown();
			if(IsElementDisplayed("CalendarSettings", CalendarSettingsLocators)){
				Print("Calendar settings button is displayed");
				ReportConfig.Givenlogpass("User clicks settings button from the menu","Calendar settings button is displayed");

			}
		
		} 
		catch (Exception e) {
			
			PrintError("Calendar settings button is not displayed");
			ReportConfig.Givenlogfail("User clicks settings button from the menu","Calendar settings button is not displayed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Calendar settings button is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	   
	    
	}

	@And("User clicks Calendar settings button from the menu")
	public void user_clicks_calendar_settings_button_from_the_menu() throws Throwable {
		
		try {
			
			Click("CalendarSettings", CalendarSettingsLocators);
			Waitfortheelement("Calendar", CalendarSettingsLocators);
			if(IsElementDisplayed("Calendar", CalendarSettingsLocators)){
				
				Print("Click on yes Calendar settings button");
				ReportConfig.Andlogpass("User clicks Calendar settings button from the menu","Click on yes Calendar settings button");

			}
		
		} 
		catch (Exception e) {
			
			PrintError("Calendar settings button is not clicked");
			ReportConfig.Andlogfail("User clicks Calendar settings button from the menu","Calendar settings button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Calendar settings button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	   
	    
	}

	@Given("User add new event in Calendar settings")
	public void user_add_new_event_in_calendar_settings() throws Throwable {
	   
		
		try {
			ReportConfig.ReportCreateScenarioTest("To add new event in Calendar settings");

			F_12_CalendarSettings.AddEvent();	
		//	ReportConfig.Givenlogpass("User add new event in Calendar settings","Calendar settings event added successfully");

		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User add new event in Calendar settings","Calendar settings event add failed because : " + e.getMessage());

			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Calendar settings event add failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}
	
	@Given("User search and view the event from the calendar settings")
	public void user_search_and_view_the_event_from_the_calendar_settings() throws Throwable {

		
		try {
			ReportConfig.ReportCreateScenarioTest("To search a event in Calendar settings");
			F_12_CalendarSettings.SearchEvent();
		//	ReportConfig.Givenlogpass("User search and view the event from the calendar settings","Calendar settings event searched successfully");


			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User search and view the event from the calendar settings","Calendar settings event search failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Calendar settings event search failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	}
	
	@Given("User edit a event request from the calendar settings")
	public void user_edit_a_event_request_from_the_calendar_settings() throws Throwable {
		
	try {
		ReportConfig.ReportCreateScenarioTest("To edit a event in Calendar settings");
			F_12_CalendarSettings.EditEvent();
			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User edit a event request from the calendar settings","Event updated failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Event updated failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	}
	
	@Given("User uploads invalid date time in CalendarSettings")
	public void user_uploads_invalid_date_time_in_CalendarSettings() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("To check invalid date time error in CalendarSettings");
			F_12_CalendarSettings.AddEventError();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User uploads invalid date time in CalendarSettings","Upload failed because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "User uploads invalid date time in CalendarSettings" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}

	}
}
