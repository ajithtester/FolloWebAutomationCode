package com.follo.stepdefinition.sp2;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;
import com.follo.module.method.F_04_Companies;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_04_Companies extends Baseclass {


	@Given("User clicks Company button")
	public void user_clicks_company_button() throws Throwable {

		try {
			ReportConfig.ReportCreateFeatureTest("To verify the Company feature");
			ReportConfig.ReportCreateScenarioTest("To navigate to Company feature");
			if(IsElementDisplayed("Companies", CompaniesLocators)) {

				Click("Companies", CompaniesLocators);
				Print("Click on Companies button ");
				ReportConfig.Givenlogpass("User clicks Company button","Click on Companies button");
			}
		} 

		catch (Exception e) {
			PrintError("Companies button is not clicked");
			ReportConfig.Givenlogfail("User clicks Company button","Companies button is not clicked because : " + e.getMessage());
		
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Companies button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}
	}

	@Given("User add new companies")
	public void user_add_new_new_companies() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To add new companies");

			F_04_Companies.AddDCompany();
			ReportConfig.Givenlogpass("User add new companies","Validate Companies Page");
		} 

		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User add new companies","Companies are not added because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Companies are not added" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}

	}

	@Given("User search and view the company")
	public void user_search_and_view_the_company() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Search Company");
			F_04_Companies.SearchCompany();
		//	ReportConfig.Givenlogpass("User search and view the company","Company Searched successsfully");
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and view the company","Company Searched failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Company Searched failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}


	@Given("User search and filter the company")
	public void user_search_and_filter_the_company() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Filter Company");
			F_04_Companies.FilterCompany();
		//	ReportConfig.Givenlogpass("User search and filter the company","Company filtered successsfully");
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and filter the company","Company filtered failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Company filtered failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}


	@Given("User edits a Company from the list")
	public void user_edits_a_company_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Edit Company");
			F_04_Companies.EditCompany();
		//	ReportConfig.Givenlogpass("User edits a Company from the list","Company edited successsfully");
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User edits a Company from the list","Company edit failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Company edit failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}

	@Given("User deletes a Company from the list")
	public void user_deletes_a_company_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Delete Company");
			F_04_Companies.DeleteCompany();
		//	ReportConfig.Givenlogpass("User deletes a Company from the list","Company deleted successsfully");

		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User deletes a Company from the list","Company delete failed because : " + e.getMessage());
			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Company delete failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}

	}

	@Given("User selects all Companies")
	public void user_selects_all_companies() throws Throwable {

		try {
			Wait(2000);
			ReportConfig.ReportCreateScenarioTest("Delete all Companies from the list");
			if(IsElementDisplayed("SelectAll", CompaniesLocators)){
				Click("SelectAll", CompaniesLocators);
				Print("All companies are selected");
				ReportConfig.Givenlogpass("User selects all Companies","All companies are selected");
			}
		} catch (Exception e) {
			PrintError("All companies are not selected");
			ReportConfig.Givenlogfail("User selects all Companies","All companies are not selected because : " + e.getMessage());
			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "All companies are not selected" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}

	}

	@And("User clicks remove button and click yes in company delete popup")
	public void user_clicks_remove_button_and_click_yes_in_company_delete_popup() throws Throwable {

		try {
			if(IsElementDisplayed("RemoveButton", CompaniesLocators)){
				Click("RemoveButton", CompaniesLocators);
				Wait(2000);
				Click("YesDelete", CompaniesLocators);


				Print("Remove button is clicked");
				ReportConfig.Andlogpass("User clicks remove button and click yes in company delete popup","Remove button is clicked");
			}
		} catch (Exception e) {
			PrintError("Remove button is not clicked");
			ReportConfig.Andlogfail("User clicks remove button and click yes in company delete popup","Remove button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Remove button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}

	}


	@Then("All the Companies except parent company is deleted")
	public void all_the_companies_except_parent_company_is_deleted() throws Throwable {



		try {
			int size =	SizeOfTheList("CompanyList", CompaniesLocators);

			if(size<=1) {
				Print("All companies are deleted except parent company");
				ReportConfig.Thenlogpass("All the Companies except parent company is deleted","All companies are deleted except parent company");

			}
			else {
				System.err.println(size);
				ReportConfig.Thenlogfail("All the Companies except parent company is deleted","Companies are not deleted");

			}

		} 

		catch (Exception e) {

			PrintError("All companies are not deleted");
			ReportConfig.Thenlogfail("All the Companies except parent company is deleted","Companies are not deleted because : " + e.getMessage());

			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Companies are not deleted" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}

	}

	@Given("User clicks import multiple button")
	public void user_clicks_import_multiple_button() throws Throwable {
		
		
		try {
			ReportConfig.ReportCreateScenarioTest("Import multiple Companies list");

			if(IsElementDisplayed("ImportMultiple", CompaniesLocators)) {
				Click("ImportMultiple", CompaniesLocators);
				ReportConfig.Givenlogpass("User clicks import multiple button","Click on Import button");

				Print("Click on Import button");
			}
		} catch (Exception e) {
			PrintError("Import button is not clicked");
			ReportConfig.Givenlogfail("User clicks import multiple button","Import button is not clicked because : " + e.getMessage());

			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Import button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	    
	}
	
	@And("User clicks browse files to upload company list")
	public void user_clicks_browse_files_to_upload_company_list() throws Throwable {
		
		try {
			F_04_Companies.BrowseFiles();
			
			if(IsElementDisplayed("BrowseFiles", DFOWLocators)) {

			//	Print(ReadFrom.UploadCompanyFile);
				ReportConfig.Andlogpass("User clicks browse files to upload company list","Click on Browse File button");


			}
		} catch (Exception e) {
			PrintError("Browse files button is not clicked");
			ReportConfig.Andlogfail("User clicks browse files to upload company list","Browse File button is not clicked because : " + e.getMessage());

			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Browse File button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	    
	}

	@And("User selects file to upload to upload company list")
	public void user_selects_file_to_upload_to_upload_company_list() throws Throwable {
		
		try {
			ReportConfig.Andlogpass("User selects file to upload to upload company list","File is selected");

			//F_04_Companies.CompanyBulkUpload();
			//Runtime.getRuntime().exec("C:\\Users\\ajithkumar.j\\Desktop\\FileUpload.exe");



		} catch (Exception e) {
			PrintError("DFOW list excel file is not selected from the system");
			ReportConfig.Andlogfail("User selects file to upload to upload company list","DFOW list excel file is not selected from the system because : " + e.getMessage());

			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "DFOW list excel file is not selected from the system" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	    
	}

	@And("User clicks the done button to upload company list")
	public void user_clicks_the_done_button_to_upload_company_list() throws Throwable {
		
		try {
			Wait(2000);
			if(IsElementDisplayed("DoneButton", DFOWLocators)){
				Click("DoneButton", DFOWLocators);
				ReportConfig.Andlogpass("User clicks the done button to upload company list","Click on done button");


				Print("Click on done button");
				ClickPageDown();
			}
		} catch (Exception e) {
			PrintError("Done button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Done button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}
	    
	}

	@Then("Companies list from the excel should get added")
	public void companies_list_from_the_excel_should_get_added() throws Throwable {
		
		try {

			F_04_Companies.BulkSuccessfullMessage();

			if(IsElementDisplayed("FileUploaded", CompaniesLocators)){
				Print("Companies list added");
		
				ReportConfig.Thenlogpass("User clicks the done button to upload company list","Companies list added");


			}
		} 
		catch (Exception e) {
			PrintError("Companies list not added");
			PrintError(e.getMessage());
			ReportConfig.Thenlogfail("User clicks the done button to upload company list","Companies list not added because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Companies list not added" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}
	    
	@Given("User uploads invalid file")
	public void user_uploads_invalid_file() throws Throwable {
		
		try {
	
			ReportConfig.ReportCreateScenarioTest("User uploads invalid file");
			F_04_Companies.InvalidFileError();
				 
		}
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User uploads invalid file" , "Invalid file upload failed because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "User uploads invalid file" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);

		}

	}
	
	@Given("User adds invalid file in company logo")
	public void user_adds_invalid_file_in_company_logo() throws Throwable {
	
		try {
			
			ReportConfig.ReportCreateScenarioTest("User adds invalid file in company logo");

			F_04_Companies.InvalidImageError();
		} 

		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User adds invalid file in company logo" , "Invalid file upload failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User adds invalid file in company logo" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}
	
	@Given("user adds company name that exceeds maximum length")
	public void user_adds_company_name_that_exceeds_maximum_length() throws Throwable {
	   
		try {

			ReportConfig.ReportCreateScenarioTest("user adds company name that exceeds maximum length");
			F_04_Companies.MaximumCharacterLength();
		} 

		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("user adds company name that exceeds maximum length" , "Add company failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "user adds company name that exceeds maximum length" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			
		}

	}

}
