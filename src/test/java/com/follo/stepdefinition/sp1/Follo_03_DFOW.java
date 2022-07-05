package com.follo.stepdefinition.sp1;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;
import com.follo.module.method.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_03_DFOW extends Baseclass {

	@Given("User clicks settings button")
	public void user_clicks_settings_button() throws Throwable {

		try {
			ReportConfig.ReportCreateFeatureTest("To verify the DFOW feature");
			ReportConfig.ReportCreateScenarioTest("To navigate to DFOW feature");


			Wait(5000);
			if(IsElementDisplayed("DeliveryCalendar", DFOWLocators)) {
				Click("DeliveryCalendar", DFOWLocators);

				ClickPageDown();

				Click("Settings", DFOWLocators);
				Print("Click on Setting Button");
				ReportConfig.Givenlogpass("User clicks settings button","Click on Setting Button");

			}
		} catch (Exception e) {
			PrintError("Settings button is not clicked");

			Print(e.getMessage());
			ReportConfig.Givenlogfail("User clicks settings button","Settings button is not clicked because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Settings button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}


	}

	@And("User scrolls in the settings menu")
	public void user_scrolls_in_the_settings_menu() throws Throwable {


		try {

			ClickPageDown();

			Print("Click on the Down arrow in Keyboard");
			ReportConfig.Andlogpass("User scrolls in the settings menu", "Click on the Down arrow in Keyboard");

		} catch (Exception e) {
			PrintError("Page down button is not clicked");
			ReportConfig.Andlogfail("User scrolls in the settings menu", "Page down button is not clicked in keyboard because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Page down button is clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@And("User clicks the DFOW from the menu")
	public void user_clicks_the_dfow_from_the_menu() throws Throwable {

		try {
			if(IsElementDisplayed("DFOW", DFOWLocators)) {

				Click("DFOW", DFOWLocators);
				Print("Click on the DFOW button");
				ReportConfig.Andlogpass("User clicks the DFOW from the menu","Click on the DFOW button");
				ClickPageDown();
			}
		} catch (Exception e) {
			PrintError("DFOW button is not clicked");
			ReportConfig.Andlogfail("User clicks the DFOW from the menu","DFOW button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@Then("DFOW page should be displayed")
	public void dfow_page_should_be_displayed() throws Throwable {


		try {

			if(IsElementDisplayed("AddRow", DFOWLocators)) {
				Print("Validate DFOW Page");
				ReportConfig.Thenlogpass("DFOW page should be displayed","Validate DFOW Page");
			}

		} 

		catch (Exception e) {

			PrintError("DFOW page is not dispayed");
			ReportConfig.Thenlogfail("DFOW page should be displayed","DFOW page is not dispayed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW page is not dispayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}
	}



	@Given("User clicks add row")
	public void user_clicks_add_row() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Add DFOW list");
			Wait(2000);
			WaitForTheElement("AddRow", DFOWLocators);
			Click("AddRow", DFOWLocators);
			Print("Click on AddRow button");
			ReportConfig.Givenlogpass("User clicks add row","Click on AddRow button");

		} catch (Exception e) {
			PrintError("AddRow button is not clicked");
			ReportConfig.Givenlogfail("User clicks add row","AddRow button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "AddRow button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

	}

	@And("User adds DFOW list")
	public void user_adds_dfow_list() throws Throwable {

		try {


			F_03_DFOW.AddDFOW();
			ReportConfig.Andlogpass("User adds DFOW list", "Validate the dfow list ");

		}  catch (Exception e) {

			ReportConfig.Andlogpass("User adds DFOW list", "Dfow details are not filled because : " + e.getMessage());
			Print(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Dfow details are not filled" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

	}

	@And("User clicks the save button")
	public void user_clicks_the_save_button() throws Throwable {

		try {
			if(IsElementDisplayed("AddRow", DFOWLocators)) {

				Click("SaveButton", DFOWLocators);
				Print("Click on Save button");
				ReportConfig.Andlogpass("User clicks the save button", "Click on Save button");
				ClickPageDown();
			}
		} catch (Exception e) {
			PrintError("Save button is not clicked");
			ReportConfig.Andlogfail("User clicks the save button","Save button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Save button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

	}

	@Then("DFOW list should get added")
	public void dfow_list_should_get_added() throws Throwable {

		try {

			F_03_DFOW.AddSuccessfullMessage();
			if(getElement("SuccessfullMessage", DFOWLocators).isDisplayed()) {
				Click("SuccessfullMessage", DFOWLocators);
				Print("Validate the list");
				ReportConfig.Thenlogpass("DFOW list should get added", "Validate the list");

			}
		} 
		catch (Exception e) {
			PrintError("DFOW list not added");
			Print(e.getMessage());
			ReportConfig.Thenlogfail("DFOW list should get added","DFOW list not added because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW list not added" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}


	}

	@Given("User enters the dfow value in the search bar")
	public void user_enters_the_dfow_value_in_the_search_bar() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("Search DFOW");
			F_03_DFOW.SearchDFOW();
			ReportConfig.Givenlogpass("User search the dfow", "DFOW are searched successfully");

		} catch (Exception e) {
			ReportConfig.Givenlogfail("User search the dfow", "DFOW search failed because : " + e.getMessage());
			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW search failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}
	}



	@Given("User looks for the export button")
	public void user_looks_for_the_export_button()  throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Export DFOW list");
			Waitfortheelement("Export", DFOWLocators);
			if(IsElementDisplayed("Export", DFOWLocators)){

				Print("Validate Export button : DFOW list is available");
				ReportConfig.Givenlogpass("User looks for the export button", "Validate Export button");

			}
		} 
		catch (Exception e) {
			PrintError("Export button is not displayed");
			ReportConfig.Givenlogfail("User looks for the export button", "Export button is not displayed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Export button is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}


	}

	@Then("User clicks the export button to export the file")
	public void user_clicks_the_export_button_to_export_the_file() throws Throwable {
		try {
			Wait(2000);
			if(IsElementDisplayed("Export", DFOWLocators)){
				Click("Export", DFOWLocators);


				Print("Validate Export button click");
				ReportConfig.Thenlogpass("User looks for the export button","Validate Export button click");
			}
		} catch (Exception e) {
			PrintError("Export button is not clicked : File is not exported");
			ReportConfig.Thenlogfail("User looks for the export button","Export button is not clicked : File is not exported because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "File is not exported" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@Given("User edits a DFOW from the list")
	public void user_edits_a_dfow_from_the_list() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("Edit a DFOW from the list");

			F_03_DFOW.EditDFOW();
			ReportConfig.Givenlogpass("User edits a DFOW from the list", "Dfow values are edited");

		} 	
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User edits a DFOW from the list", "Dfow values are not edited because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Dfow values are not edited" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			
		}
	}

	@Then("User should get edit success popup")
	public void user_should_get_edit_success_popup() throws Throwable {


		try {

			F_03_DFOW.AddSuccessfullMessage();
			if(IsElementDisplayed("SuccessfullMessage", DFOWLocators)) {
				Click("SuccessfullMessage", DFOWLocators);
				Print("DFOW edited successfully");
				ReportConfig.Thenlogpass("User should get edit success popup","DFOW edited successfully");

			}
		} 
		catch (Exception e) {
			PrintError("DFOW list not edited successfully");
			PrintError(e.getMessage());
			ReportConfig.Thenlogfail("User should get edit success popup","DFOW list not edited because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW list not edited" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}


	@Given("User deletes a DFOW from the list")
	public void user_deletes_a_dfow_from_the_list() throws Throwable {
		try {
			ReportConfig.ReportCreateScenarioTest("User deletes a DFOW from the list");
			Wait(2000);
			F_03_DFOW.DeleteDFOW();
			ReportConfig.Givenlogpass("User deletes a DFOW from the list","DFOW list deleted successfully");


		} catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User deletes a DFOW from the list","DFOW list not deleted because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW list not deleted" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

	}

	@Given("User selects all DFOW")
	public void user_selects_all_dfow() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Delete all DFOW from the list");

			Wait(2000);
			if(IsElementDisplayed("SelectAll", DFOWLocators)){
				Click("SelectAll", DFOWLocators);

				Print("All DFOW are selected");
				ReportConfig.Givenlogpass("User selects all DFOW","All DFOW are selected");
			}
		} catch (Exception e) {
			PrintError("All DFOW are not selected");
			ReportConfig.Givenlogfail("User selects all DFOW","All DFOW are not selected because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "All DFOW are not selected" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@And("User clicks remove button and click yes")
	public void user_clicks_remove_button_and_click_yes()throws Throwable {


		try {
			if(IsElementDisplayed("RemoveDFOW", DFOWLocators)){
				Click("RemoveDFOW", DFOWLocators);
				Wait(2000);
				Click("YesDelete", DFOWLocators);


				Print("Remove button is clicked");
				ReportConfig.Andlogpass("User clicks remove button and click yes","Remove button is clicked");
			}
		} catch (Exception e) {
			PrintError("Remove button is not clicked");
			ReportConfig.Andlogfail("User clicks remove button and click yes","Remove button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Remove button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@Then("All the DFOW in the list should be removed")
	public void all_the_dfow_in_the_list_should_be_removed() throws Throwable {


		try {


			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[2]/div/table/tr/td/div"));
				}
			});


			if(IsElementDisplayed("NoRecordFound", DFOWLocators)) {
				Print("No record found is dispayed : All DFOW are deleted");
				ReportConfig.Thenlogpass("All the DFOW in the list should be removed","No record found is dispayed : All DFOW are deleted");
			}

		} 

		catch (Exception e) {

			PrintError("No record found is not dispayed : All DFOW are not deleted");
			ReportConfig.Thenlogfail("All the DFOW in the list should be removed","No record found is not dispayed : All DFOW are not deleted because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "No record found is not dispayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			
		}

	}




	@Given("User clicks import button")
	public void user_clicks_import_button() throws Throwable {


		try {

			ReportConfig.ReportCreateScenarioTest("Import DFOW list");

			if(IsElementDisplayed("Import", DFOWLocators)) {
				Click("Import", DFOWLocators);
				ReportConfig.Givenlogpass("User clicks import button","Click on Import button");
				Print("Click on Import button");
			}
		} catch (Exception e) {
			PrintError("Import button is not clicked");
			ReportConfig.Givenlogfail("User clicks import button","Import button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Import button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@And("User selects file to upload")
	public void user_selects_file_to_upload() throws Throwable {


		try {

			F_03_DFOW.DfowBulkUpload();
			ReportConfig.Andlogpass("User selects file to upload","DFOW list excel file is selected from the system");

		} catch (Exception e) {
			PrintError("DFOW list excel file is not selected from the system");
			ReportConfig.Andlogfail("User selects file to upload","DFOW list excel file is not selected from the system because : " + e.getMessage());

			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW list excel file is not selected from the system" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@And("User clicks the done button")
	public void user_clicks_the_done_button() throws Throwable {

		try {
			Wait(2000);
			if(IsElementDisplayed("DoneButton", DFOWLocators)){
				Click("DoneButton", DFOWLocators);
				ReportConfig.Andlogpass("User clicks the done button","Click on Done button");

				Print("Click on Done button");
				ClickPageDown();
			}
		} catch (Exception e) {
			PrintError("Done button is not clicked");
			ReportConfig.Andlogfail("User clicks the done button","Done button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Done button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

	}

	@Then("DFOW list from the excel should get added")
	public void dfow_list_from_the_excel_should_get_added() throws Throwable {


		try {

			F_03_DFOW.BulkSuccessfullMessage();

			if(IsElementDisplayed("SuccessfullMessage2", DFOWLocators)){
				Print("Validate the list");
				ReportConfig.Thenlogpass("User clicks the done button","Validate the list");

			}
		} 
		catch (Exception e) {
			PrintError("DFOW list not added");
			PrintError(e.getMessage());
			ReportConfig.Thenlogfail("User clicks the done button","DFOW list not added because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW list not added" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}
	}

	@Given("User uploads invalid DFOW file")
	public void user_uploads_invalid_dfow_file() throws Throwable {
		try {

			ReportConfig.ReportCreateScenarioTest("User uploads invalid DFOW file");
			F_03_DFOW.DfowUploadWrongFile();

		} catch (Exception e) {
			PrintError("DFOW list invalid file is selected from the system");
			ReportConfig.Givenlogfail("User uploads invalid DFOW file" ,"DFOW list invalid file upload failed because : " + e.getMessage());
			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW list invalid file upload" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

}
