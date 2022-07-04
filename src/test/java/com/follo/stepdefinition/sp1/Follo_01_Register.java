package com.follo.stepdefinition.sp1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.follo.baseclass.Baseclass;
import com.follo.browser.launch.BrowserLaunch;
import com.follo.module.method.*;
import com.follo.excel.read.ReadFrom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_01_Register extends Baseclass {




	@Given("User launching the web url")
	public void user_launching_the_web_url() throws Throwable {


		try {

			ReportConfig.Reports();
			ReportConfig.ReportCreateFeatureTest("To verify the Register feature");
			ReportConfig.ReportCreateScenarioTest("Launch the app URL and navigate to register popup");

			BrowserLaunch.LaunchTheAppURL("URL", AppProperties);

			String ActualTitle =	PageTitle();		
			String ExpectedTitle =	PropertyFile("PageTitle", AppProperties);

			if(IsEqual(ActualTitle, ExpectedTitle)) {

				ReportConfig.reportStepPass("Application test");
				ReportConfig.Givenlogpass("User launching the web url","Entered URL is : " + PropertyFile("URL", AppProperties) + ": Application launched successfully");

				Print("Page title is : " + PropertyFile("PageTitle", AppProperties) + ": Application launched successfully");

			}
			else {

				ReportConfig.Givenlogfail("User launching the web url","Entered URL is : " + PropertyFile("PageTitle", AppProperties) + ": Application launched failed");

				PrintError("Page title is : " + PropertyFile("PageTitle", AppProperties) + ": Application launched failed");
				String IssueSummary = "Excepted Page title is : " + ExpectedTitle  + " , But actual page title is : " + ActualTitle ;
				String Storydescription = "Application launched failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}

		} 

		catch (Exception e) {

			ReportConfig.Givenlogfail("User launching the web url","Entered URL is : " + PropertyFile("PageTitle", AppProperties) + ": Application launched failed");
			Print(e.getMessage());
			String IssueSummary = e.getMessage();
			String Storydescription = "Application launched failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			Print("Page title is : " + PropertyFile("PageTitle", AppProperties) + ": Application launched failed because : " + e.getMessage());
		}

	}

	@And("User clicks the get-started button")
	public void user_clicks_the_get_started_button() throws Throwable {

		try {
			if(IsElementDisplayed("GetStarted", RegisterPageLocators)){

				Click("GetStarted", RegisterPageLocators);
				Print("Get Started button is clicked");

				ReportConfig.Andlogpass("User clicks the get-started button","Get Started button is clicked");

			}

		} catch (Exception e) {
			PrintError("Get Started button is not clicked");


			ReportConfig.Andlogfail("User clicks the get-started button","Get Started button is not clicked because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Get Started button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}
	}

	@Then("User should see welcome popup")
	public void user_should_see_welcome_popup() throws Throwable {


		try {

			if(IsElementDisplayed("EmailId", RegisterPageLocators)) {
				Print("Welcome popup opened");

				ReportConfig.Thenlogpass("User should see welcome popup","Welcome popup opened");


			}
		} 
		catch (Exception e) {
			PrintError("Welcome popup not opened");

			ReportConfig.Thenlogfail("User should see welcome popup","Welcome popup not opened because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Welcome popup not opened" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}
	}

	@Given("User enter mail Id and Phone number")
	public void user_enter_mail_id_and_phone_number() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Filling the mailId and phone number");
			TypeDataInTheField("EmailId", RegisterPageLocators, ReadFrom.Excel(0, 1, ReadFrom.Register));
			Print("EmailId is entered as : " + ReadFrom.Excel(0, 1, ReadFrom.Register));
			ReportConfig.PassedLogInfo("EmailId is entered as : " ,ReadFrom.Excel(0, 1, ReadFrom.Register));

			SelectFromDropdown("PhoneCode", RegisterPageLocators, ReadFrom.Excel(1, 1, ReadFrom.Register));
			Print("Phonecode is selected as : " + ReadFrom.Excel(1, 1, ReadFrom.Register));
			ReportConfig.PassedLogInfo("Phonecode is selected as : " , ReadFrom.Excel(1, 1, ReadFrom.Register));

			TypeDataInTheField("Mobile", RegisterPageLocators, ReadFrom.Excel(2, 1, ReadFrom.Register));
			Print("Mobile number is entered as : " + ReadFrom.Excel(2, 1, ReadFrom.Register));
			ReportConfig.PassedLogInfo("Mobile number is entered as : " , ReadFrom.Excel(2, 1, ReadFrom.Register));


			ReportConfig.Givenlogpass("User enter mail Id and Phone number","Email and Mobile number is filled");

		} 
		catch (Exception e) {

			PrintError("Email and Mobile number is not filled");

			ReportConfig.Givenlogfail("User enter mail Id and Phone number","Email and Mobile number is not filled because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Email and Mobile number is not filled" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@And("User Clicks the continue button")
	public void user_clicks_the_continue_button() throws Throwable {

		try {
			if(IsElementDisplayed("ContinueButton", RegisterPageLocators)) {
				Click("ContinueButton", RegisterPageLocators);

				Print("Continue button is clicked");

				ReportConfig.Andlogpass("User Clicks the continue button","Continue button is clicked");

			}
		}	
		catch (Exception e) {
			PrintError("Continue button is not clicked");

			ReportConfig.Andlogfail("User Clicks the continue button","Continue button is not clicked because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Continue button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}
	}

	@Then("User should see the basic details popup")
	public void user_should_see_the_basic_details_popup() throws Throwable {

		try {
			Wait(3000);
			WaitForTheElement("FirstName", RegisterPageLocators);
			if(IsElementDisplayed("FirstName", RegisterPageLocators)) {
				Print("Basic details popup is displayed");
				ReportConfig.Thenlogpass("User should see the basic details popup","Basic details popup is displayed");

			}

		} 	

		catch (Exception e) {
			PrintError("Basic details popup is not displayed");
			ReportConfig.Thenlogfail("User should see the basic details popup","Basic details popup is not displayed because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Basic details popup is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

	}

	@Given("User fills the basic details and clicks continue button")
	public void user_fills_the_basic_details_and_clicks_continue_button() throws Throwable {



		try {
			ReportConfig.ReportCreateScenarioTest("Filling the basic details");
			Wait(2000);
			Waitfortheelement("FirstName", RegisterPageLocators);


			TypeDataInTheField("FirstName", RegisterPageLocators, ReadFrom.Excel(3, 1 , ReadFrom.Register));

			Print("First name is entered as : " + ReadFrom.Excel(3, 1 , ReadFrom.Register));
			ReportConfig.PassedLogInfo("First name is entered as : " , ReadFrom.Excel(3, 1 , ReadFrom.Register));



			Waitfortheelement("LastName", RegisterPageLocators);
			TypeDataInTheField("LastName", RegisterPageLocators, ReadFrom.Excel(4, 1 , ReadFrom.Register));

			Print("Last name is entered as : " + ReadFrom.Excel(4, 1 , ReadFrom.Register));
			ReportConfig.PassedLogInfo("Last name is entered as : " , ReadFrom.Excel(4, 1 , ReadFrom.Register));


			ScrollDown();



			Click("ContinueButton", RegisterPageLocators);

			Print("Continue button is clicked");
			ReportConfig.Givenlogpass("User fills the basic details and clicks continue button","Basic details are filled");

		}


		catch (Exception e) {
			PrintError("Basic details are not filled");
			ReportConfig.Givenlogfail("User fills the basic details and clicks continue button","Basic details are not filled because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Basic details are not filled" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

		try {

			if(IsElementDisplayed("Autofill", RegisterPageLocators)) {
				Print("Error message : Mandatory feilds to be filled : is displayed");


				MoveToElement("CompanyName", RegisterPageLocators);

				TypeDataInTheField("CompanyName", RegisterPageLocators, ReadFrom.Excel(7, 1 , ReadFrom.Register));
				Print("Company name is entered as : " + ReadFrom.Excel(7, 1 , ReadFrom.Register));
				ReportConfig.PassedLogInfo("Company name is entered as : " , ReadFrom.Excel(7, 1 , ReadFrom.Register));


				//////////
				TypeDataInTheField("City", RegisterPageLocators, ReadFrom.Excel(10, 1 , ReadFrom.Register));
				Print("City is entered as : " + ReadFrom.Excel(10, 1 , ReadFrom.Register));
				ReportConfig.PassedLogInfo("City is entered as : " , ReadFrom.Excel(10, 1 , ReadFrom.Register));



				TypeDataInTheField("State", RegisterPageLocators, ReadFrom.Excel(11, 1 , ReadFrom.Register));
				Print("State is entered as : " + ReadFrom.Excel(11, 1 , ReadFrom.Register));
				ReportConfig.PassedLogInfo("State is entered as : " , ReadFrom.Excel(11, 1 , ReadFrom.Register));



				TypeDataInTheField("Country", RegisterPageLocators, ReadFrom.Excel(12, 1 , ReadFrom.Register));
				Print("Country is entered as : " + ReadFrom.Excel(12, 1 , ReadFrom.Register));
				ReportConfig.PassedLogInfo("Country is entered as : " , ReadFrom.Excel(12, 1 , ReadFrom.Register));




				TypeDataInTheField("Website", RegisterPageLocators, ReadFrom.Excel(14, 1 , ReadFrom.Register));
				Print("Website is entered as : " + ReadFrom.Excel(14, 1 , ReadFrom.Register));
				ReportConfig.PassedLogInfo("Website is entered as : " , ReadFrom.Excel(14, 1 , ReadFrom.Register));


				TypeDataInTheField("CompanyAddress", RegisterPageLocators, ReadFrom.Excel(8, 1 , ReadFrom.Register));
				Print("Company address is entered as : " + ReadFrom.Excel(8, 1 , ReadFrom.Register));
				ReportConfig.PassedLogInfo("Company address is entered as : " , ReadFrom.Excel(8, 1 , ReadFrom.Register));

				ClickEnter();

				ScrollDown();
				Print("Scrolled down to continue button");

				Wait(2000);
				TypeDataInTheField("ZipCode", RegisterPageLocators, ReadFrom.Excel(13, 1 , ReadFrom.Register));
				Print("ZipCode is entered as : " + ReadFrom.Excel(13, 1 , ReadFrom.Register));
				ReportConfig.PassedLogInfo("ZipCode is entered as : " , ReadFrom.Excel(13, 1 , ReadFrom.Register));


				Click("ContinueButton", RegisterPageLocators);
				Print("Continue button is clicked");
				ReportConfig.PassedLogInfo("User fills the basic details and clicks continue button" ,"ZContinue button is clicked");


			}


		} catch (Exception e) {
			PrintError("Company address Auto-Filled");

		}

	}

	@Then("User should see the project details popup")
	public void user_should_see_the_project_details_popup() throws Throwable {
		try {

			WaitForTheElement("ProjectDetailsPopup", RegisterPageLocators);
			if(IsElementDisplayed("ProjectDetailsPopup", RegisterPageLocators)) {
				Print("Project details popup is displayed");
				ReportConfig.Thenlogpass("User should see the project details popup","Project details popup is displayed");


			}

		} catch (Exception e) {

			PrintError("Project details popup is not displayed");

			ReportConfig.Thenlogfail("User should see the project details popup","Project details popup is not displayed because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Project details popup is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}
	}


	@Given("User fills the project name and address")
	public void user_fills_the_project_name_and_address() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest(" Filling the project details");

			TypeDataInTheField("ProjectName", RegisterPageLocators, ReadFrom.Excel(5, 1 , ReadFrom.Register));
			Print("Project name is entered as : " + ReadFrom.Excel(5, 1 , ReadFrom.Register));
			ReportConfig.PassedLogInfo("Project name is entered as : " , ReadFrom.Excel(5, 1 , ReadFrom.Register));


			Clear("ProjectAddress", RegisterPageLocators);

			TypeDataInTheField("ProjectAddress", RegisterPageLocators, ReadFrom.Excel(6, 1 , ReadFrom.Register));
			Print("Project address is entered as : " + ReadFrom.Excel(6, 1 , ReadFrom.Register));
			ReportConfig.PassedLogInfo("Project address is entered as : " , ReadFrom.Excel(6, 1 , ReadFrom.Register));

		//	ClickEnter();
			Wait(2000);
			Click("ProjectName", RegisterPageLocators);
			Wait(2000);

			ReportConfig.Givenlogpass("User fills the project name and address","Project details are filled");



		} catch (Exception e) {
			PrintError("Project details are not filled");
			ReportConfig.Givenlogfail("User fills the project name and address","Project details are not filled because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Project details are not filled" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}


	}

	@And("User click next button")
	public void user_click_next_button() throws Throwable {


		try {

			Waitfortheelement("NextButton", RegisterPageLocators);
			Click("NextButton", RegisterPageLocators);

			Print("Next button is clicked");
			ReportConfig.Andlogpass("User click next button","Next button is clicked");


		}
		catch (Exception e) {
			PrintError("Next button is not clicked");
			ReportConfig.Andlogfail("User click next button","Next button is not clicked because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Next button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}
	}

	@Then("User should see the subscription plan page")
	public void user_should_see_the_subscription_plan_page() throws Throwable {


		try {


			Wait(2000);

			WaitForTheElement("SubcriptionPage", RegisterPageLocators);
			if(IsElementDisplayed("SubcriptionPage", RegisterPageLocators)) {
				Print("Subcription page is displayed");
				ReportConfig.Thenlogpass("User should see the subscription plan page","Subcription page is displayed");



			}

		}
		catch (Exception e) {
			PrintError("Subcription page is not displayed");
			ReportConfig.Thenlogfail("User should see the subscription plan page","Subcription page is not displayed because : " + e.getMessage());
		
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Subcription page is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

	}

	@Given("User selects the subscription plan")
	public void user_selects_the_subscription_plan() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User selects the subscription plan");

			ScrollDown();
			F_01_Registeration.SelectPlan(ReadFrom.Excel(17, 0, ReadFrom.Register));
			ReportConfig.Givenlogpass("User selects the subscription plan","Selected plan is : " + ReadFrom.Excel(17, 0, ReadFrom.Register));

		}
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User selects the subscription plan","Plan not selected because : " + e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Subcription Plan not selected" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}



	}

	@Then("User should redirected to the login page")
	public void user_should_redirected_to_the_login_page() throws Throwable {

		try {

			if(IsElementDisplayed("Email", RegisterPageLocators)) {
				Print("User redirected to the login page after selecting the plan");
				ReportConfig.Givenlogpass("User should redirected to the login page","User redirected to the login page after selecting the plan");

			}

		} 

		catch (Exception e) {

			PrintError("User not redirected to the login page");
			ReportConfig.Givenlogfail("User should redirected to the login page","User not redirected to the login page because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User not redirected to the login page" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );


		}
		//	ReportConfig.ReportCooldown();
	}


	@Given("User tries to register without credentials in register")
	public void user_tries_to_register_without_credentials_in_register() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User tries to register without credentials in register");

			Wait(1000);
			Click("ContinueButton", RegisterPageLocators);

			Print("Continue button is clicked");
			ReportConfig.Givenlogpass("User tries to register without credentials in register" ,"Continue button is clicked");

			Wait(1000);
			String invalidText =	GetText("NoEmailError", RegisterPageLocators);

			Print("No Email Entered Error : " + invalidText);
			ReportConfig.Givenlogpass("User tries to register without credentials in register" , "No Email Entered Error : " + invalidText);


			String invalidText2 =	GetText("NoPhoneError", RegisterPageLocators);

			Print("No Password Entered Error : " + invalidText2);
			ReportConfig.Givenlogpass("User tries to register without credentials in register", "No Phone number Entered Error : " + invalidText2);

		} 
		catch (Exception e) {

			PrintError("Email and Ph.no is not filled");
			ReportConfig.Givenlogfail("User tries to register without credentials in register" , "Email and Ph.no is not filled because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User tries to register without credentials in register" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}
	}

	@Given("User gives invalid email format in register")
	public void user_gives_invalid_email_format_in_register() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("Invalid Email Format Error in register");

			TypeDataInTheField("EmailId", RegisterPageLocators, ReadFrom.Excel(1, 2, ReadFrom.Login));
			ReportConfig.Givenlogpass("Invalid Email Format Error in register" ,"EmailId is entered as : " + ReadFrom.Excel(1, 2, ReadFrom.Login));
			Print("EmailId is entered as : " + ReadFrom.Excel(1, 2, ReadFrom.Login));


			SelectFromDropdown("PhoneCode", RegisterPageLocators, ReadFrom.Excel(1, 1, ReadFrom.Register));
			ReportConfig.Givenlogpass("Invalid Email Format Error in register", "Phonecode is selected as : " + ReadFrom.Excel(1, 1, ReadFrom.Register));
			Print("Phonecode is selected as : " + ReadFrom.Excel(1, 1, ReadFrom.Register));

			TypeDataInTheField("Mobile", RegisterPageLocators, ReadFrom.Excel(2, 1, ReadFrom.Register));
			ReportConfig.Givenlogpass("Invalid Email Format Error in register", "Mobile number is entered as : " + ReadFrom.Excel(2, 1, ReadFrom.Register));
			Print("Mobile number is entered as : " + ReadFrom.Excel(2, 1, ReadFrom.Register));

			Wait(1000);
			Click("ContinueButton", RegisterPageLocators);

			Print("Continue button is clicked");
			ReportConfig.Givenlogpass("Invalid Email Format Error in register" ,"Continue button is clicked");

			Wait(1000);
			String invalidText =	GetText("NoValidEmailError", RegisterPageLocators);

			Print("No Valid Email format Entered Error : " + invalidText);
			ReportConfig.Givenlogpass("Invalid Email Format Error in register", "No valid Email format Entered Error : " + invalidText);


		} 
		catch (Exception e) {

			PrintError("Email is not in valid format");
			ReportConfig.Givenlogfail("Invalid Email Format Error in register", "Email is not in valid format because : " + e.getMessage());
			PrintError(e.getMessage());
			
			String IssueSummary = e.getMessage() ;
			String Storydescription = "User gives invalid email format in register" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}



	}

	@Given("User enters already used mail Id and Phone number")
	public void user_enters_already_used_mail_id_and_phone_number() throws Throwable {


		try {

			ReportConfig.ReportCreateScenarioTest("Already used mailId and phone number");
			Wait(1000);
			Clear("EmailId", RegisterPageLocators);
			Wait(1000);

			TypeDataInTheField("EmailId", RegisterPageLocators, ReadFrom.Excel(1, 0, ReadFrom.Login));
			ReportConfig.Givenlogpass("User enters already used mail Id and Phone number" ,"EmailId is entered as : " + ReadFrom.Excel(1, 0, ReadFrom.Login));
			Print("EmailId is entered as : " + ReadFrom.Excel(1, 0, ReadFrom.Login));

			SelectFromDropdown("PhoneCode", RegisterPageLocators, ReadFrom.Excel(1, 1, ReadFrom.Register));
			ReportConfig.Givenlogpass("User enters already used mail Id and Phone number" ,"Phonecode is selected as : " + ReadFrom.Excel(1, 1, ReadFrom.Register));
			Print("Phonecode is selected as : " + ReadFrom.Excel(1, 1, ReadFrom.Register));

			TypeDataInTheField("Mobile", RegisterPageLocators, ReadFrom.Excel(2, 1, ReadFrom.Register));
			ReportConfig.Givenlogpass("User enters already used mail Id and Phone number" ,"Mobile number is entered as : " + ReadFrom.Excel(2, 1, ReadFrom.Register));
			Print("Mobile number is entered as : " + ReadFrom.Excel(2, 1, ReadFrom.Register));

			Wait(1000);
			Click("ContinueButton", RegisterPageLocators);

			Print("Continue button is clicked");
			ReportConfig.Givenlogpass("User enters already used mail Id and Phone number" ,"Continue button is clicked");

			Wait(2000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));

			String invalidText =	GetText("InvalidFileAlert", RegisterPageLocators);

			Print("Already used Email and ph.no Entered Error : " + invalidText);
			ReportConfig.Givenlogpass("User enters already used mail Id and Phone number" ,"Already used Email and ph.no Entered Error : " + invalidText);

			Wait(4000);

			Click("CloseButton", CompaniesLocators);
			Print("Close button is clicked");

			ReportConfig.Givenlogpass("User enters already used mail Id and Phone number" ,"Close button is clicked");
			Wait(2000);
			Click("GetStarted", RegisterPageLocators);
			//			Wait(2000);
			//			Click("GetStarted", RegisterPageLocators);
		} 
		catch (Exception e) {

			PrintError("Email and Mobile number is not filled");
			ReportConfig.Givenlogfail("User enters already used mail Id and Phone number" ,"Email and Mobile number is not filled because : " + e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "User enters already used mail Id and Phone number" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}

	}



}
