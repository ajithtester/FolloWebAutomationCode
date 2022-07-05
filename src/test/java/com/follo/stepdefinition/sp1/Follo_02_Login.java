package com.follo.stepdefinition.sp1;

import java.io.IOException;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class Follo_02_Login extends Baseclass {



	@Given("User launching the webapp url")
	public void user_launching_the_webapp_url() throws Throwable {


		try {

			//ReportConfig.Reports();
			ReportConfig.ReportCreateFeatureTest("To verify the Login feature");
			ReportConfig.ReportCreateScenarioTest("Launch the app URL and navigate to login page");

			BrowserLaunch.LaunchTheAppURL("URL", AppProperties);

			String ActualTitle =	PageTitle();		
			String ExpectedTitle =	PropertyFile("PageTitle", AppProperties);

			if(IsEqual(ActualTitle, ExpectedTitle)) {

				ReportConfig.Givenlogpass("User launching the web url","Page title verified as : " + PropertyFile("PageTitle", AppProperties));

				Print("Page title verified as : " + PropertyFile("PageTitle", AppProperties));

			}
			else {

				ReportConfig.Givenlogfail("User launching the web url","Page title verified as : " + PropertyFile("PageTitle", AppProperties));

				PrintError("Page title verified as : " + PropertyFile("PageTitle", AppProperties));
				String IssueSummary = "Excepted Page title is : " + ExpectedTitle  + " , But actual page title is : " + ActualTitle ;
				String Storydescription = "Application launched failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}

		} 

		catch (Exception e) {

			ReportConfig.Givenlogfail("User launching the web url","Page title verified as : " + PropertyFile("PageTitle", AppProperties));
			Print(e.getMessage());
			String IssueSummary = e.getMessage();
			String Storydescription = "Application launched failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			Print("Page title verified as : " + PropertyFile("PageTitle", AppProperties) + ": Application launched failed because : " + e.getMessage());
		}

	}


	@And("User clicks the Login button")
	public void user_clicks_the_login_button() throws Throwable {

		try {

			Wait(3000);
			if(IsElementDisplayed("LoginButton", LoginPageLocators)) {

				Click("LoginButton", LoginPageLocators);


				ReportConfig.Andlogpass("User clicks the Login button","Validate Login button click action in homepage");

				Print("Validate Login button click action in homepage");

			}

		} catch (Exception e) {

			Print(e.getMessage());

			ReportConfig.Andlogfail("User clicks the Login button","Login button in homepage is not clicked because : " + e.getMessage());
			PrintError("Login button in homepage is not clicked");
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Login button in homepage is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}


	}

	@Then("User should see login page")
	public void user_should_see_login_page() throws Throwable {

		try {

			Wait(2000);

			if(IsElementDisplayed("Email", LoginPageLocators)) {

				ReportConfig.Thenlogpass("User should see login page","Validate Login page");

				Print("Validate Login page");

			}

			else {

				ReportConfig.Thenlogfail("User should see login page","Login page is not displayed");

				PrintError("Login page is not displayed");

				String IssueSummary = "Login page is not displayed" ;
				String Storydescription = "Login page is not displayed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

			}
		} 

		catch (Exception e) {


			ReportConfig.Thenlogfail("User should see login page","Login page is not displayed because : " + e.getMessage());

			PrintError("Login page is not displayed");

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Login page is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}
	}

	@Given("User tries to login without credentials")
	public void user_tries_to_login_without_credentials() throws Throwable {
		try {

			ReportConfig.ReportCreateScenarioTest("Login Without credentials");

			Wait(1000);
			Click("LoginButton", LoginPageLocators);

			Print("Click on Login Button");
			ReportConfig.Givenlogpass("User tries to login without credentials" ,"Click on Login Button");

			Wait(1000);
			String invalidText =	GetText("NoEmailError", LoginPageLocators);

			Print("No Email Entered Error : " + invalidText);
			ReportConfig.Givenlogpass("User tries to login without credentials" , "No Email Entered Error : " + invalidText);


			String invalidText2 =	GetText("NoPwdError", LoginPageLocators);

			Print("No Password Entered Error : " + invalidText2);
			ReportConfig.Givenlogpass("User tries to login without credentials" , "No Password Entered Error : " + invalidText2);

		} 
		catch (Exception e) {

			PrintError("Email and Password is not filled");
			ReportConfig.Givenlogfail("User tries to login without credentials" ,"Email and Password is not filled because : " + e.getMessage());
			PrintError(e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User tries to login without credentials" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}


	}

	@Given("User gives invalid email format")
	public void user_gives_invalid_email_format() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("Login With invalid email");

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(1, 2 , ReadFrom.Login));
			ReportConfig.Givenlogpass("User gives invalid email format" , "Entered Email id: " + ReadFrom.Excel(1, 2 , ReadFrom.Login));
			Print("Entered Email id: " + ReadFrom.Excel(1, 2 , "Login"));

			TypeDataInTheField("Password", LoginPageLocators, ReadFrom.Excel(1, 3 , "Login"));
			ReportConfig.Givenlogpass("User gives invalid email format" ,"Entered Password: " + ReadFrom.Excel(1, 3 , ReadFrom.Login));
			Print("Entered Password: " + ReadFrom.Excel(1, 3 , "Login"));

			Wait(1000);

			Click("LoginButton", LoginPageLocators);

			Print("Click on Login Button");
			ReportConfig.Givenlogpass("User gives invalid email format" ,"Click on Login Button");

			Wait(1000);
			String invalidText =	GetText("NoValidEmailError", LoginPageLocators);

			Print("Validated with Invalid Email format: " + invalidText);
			ReportConfig.Givenlogpass("User gives invalid email format" ,"Validated with Invalid Email format: " + invalidText);


		} 
		catch (Exception e) {

			PrintError("Email is not in valid format");
			ReportConfig.Givenlogfail("User gives invalid email format" ,"Email is not in valid format because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User gives invalid email format" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}


	}


	@Given("User gives invalid Password")
	public void user_gives_invalid_password() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Invalid Password Error");
			Wait(1000);
			Clear("email", LoginPageLocators);
			Wait(1000);

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(1, 0 , ReadFrom.Login));
			ReportConfig.Givenlogpass("User gives valid email", "Entered Email id: " + ReadFrom.Excel(1, 0, ReadFrom.Login));
			Print("Entered Email id: " + ReadFrom.Excel(1, 0 , "Login"));

			Wait(1000);
			Clear("Password", LoginPageLocators);
			Wait(1000);

			TypeDataInTheField("Password", LoginPageLocators, ReadFrom.Excel(1, 3 , "Login"));
			ReportConfig.Givenlogpass("User gives invalid Password","Entered Password: " + ReadFrom.Excel(1, 3 , ReadFrom.Login));
			Print("Entered Password: " + ReadFrom.Excel(1, 3 , "Login"));

			Wait(1000);

			Click("LoginButton", LoginPageLocators);

			Print("Click on Login Button");
			ReportConfig.Givenlogpass("User gives invalid Password","Click on Login Button");

			Wait(1000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));

			String invalidText =	GetText("InvalidFileAlert", LoginPageLocators);

			Print("Validate with invalid Password: " + invalidText);
			ReportConfig.Givenlogpass("User gives invalid Password","Validate with invalid Password: " + invalidText);


		} 
		catch (Exception e) {

			PrintError("Password is not in valid format");
			ReportConfig.Givenlogfail("User gives invalid Password","Password is not in valid format because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "User gives invalid Password" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}
	}

	@Given("Broken Links in the Login page to be checked")
	public void broken_links_in_the_login_page_to_be_checked() throws Throwable {
		ReportConfig.ReportCreateScenarioTest("User check for Broken Links and images in Login page");

		Print("Validate Broken links in Login page");
		ReportConfig.Givenlogpass("Broken Links in the Login page to be checked" , "Validate Broken links in Login page");


		java.util.List<WebElement> links=driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("href")));
		System.out.println("Number of Links in Login page"+links.size());

		for(int i=0;i<links.size();i++)
		{

			WebElement ele= links.get(i);

			String url2=ele.getAttribute("href");

			verifyLinkActive(url2);

		}

	}

	@Given("Broken images in the Login page to be checked")
	public void broken_images_in_the_login_page_to_be_checked() throws Throwable {
		ReportConfig.ReportCreateScenarioTest("Broken images in the Login page to be checked");


		Print("Validate Broken images in Login Page");
		ReportConfig.Givenlogpass("Broken images in the Login page to be checked" ,"Validate Broken images in Login Page");


		java.util.List<WebElement> links=driver.findElements(By.tagName("img"));
		links.addAll(driver.findElements(By.tagName("src")));

		Print("Number of images in Login page"+links.size());

		for(int i=0;i<links.size();i++)
		{

			WebElement ele= links.get(i);

			String imageSrc=ele.getAttribute("src");
			//				
			verifyImageActive(imageSrc);
			//				

		}


	}

	@Given("User enter mail Id and password")
	public void user_enter_mail_id_and_password() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("User logging in with valid credentials");

			Clear("email", LoginPageLocators);
			String email = ReadFrom.Excel(1, 0 , ReadFrom.Login);
			TypeDataInTheField("email", LoginPageLocators, email);
			Print("Entered Email id: " + email);
			ReportConfig.PassedLogInfo("User logging in with valid credentials" , "Entered mailid is : "+ email);

			Clear("Password", LoginPageLocators);
			String Password = ReadFrom.Excel(1, 1 , ReadFrom.Login);
			TypeDataInTheField("Password", LoginPageLocators, Password);
			Print("Entered Password: " + Password);
			ReportConfig.PassedLogInfo("User logging in with valid credentials", "Entered Password is : "+ Password);


		} 
		catch (Exception e) {

			PrintError("Email and Mobile number is not filled");

			ReportConfig.Givenlogfail("User enter mail Id and password","Email and Mobile number is not filled");
			PrintError(e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Email and Mobile number is not filled" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}


	@And("User clicks the signin button")
	public void user_clicks_the_signin_button() throws Throwable {

		try {

			Wait(3000);

			Click("LoginButton", LoginPageLocators);
			ReportConfig.Andlogpass("User clicks the Login button","Click on Login Button");

			Print("Click on Login Button");


		} catch (Exception e) {

			Print(e.getMessage());

			ReportConfig.Andlogfail("User clicks the Login button","Login button is not clicked");
			PrintError("Login button is not clicked");

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Login button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}


	}



	@Then("User should see the login success message")
	public void user_should_see_the_login_success_message() throws Throwable {



		try {


			F_02_Login.Loginsucces();

			if(IsElementDisplayed("LoginSuccess", LoginPageLocators)) {
				Print("Dashboard is displayed");


				ReportConfig.Thenlogpass("User should see the login success message","Dashboard is displayed");
			}
			else {
				Print("Dashboard is not displayed ");


				ReportConfig.Thenlogfail("User should see the login success message","Dashboard is not displayed");

				String IssueSummary = "User should land in dashboard" ;
				String Storydescription = "" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}

		} 	

		catch (Exception e) {

			ReportConfig.Thenlogfail("User should see the login success message","Dashboard is not displayed");

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Dashboard is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );


		}

	}

	@Given("User selects the project")
	public void user_selects_the_project() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User selects the project");

			Wait(3000);

			JsClick("Login.ProjectDropdown", LoginPageLocators);
			Print("Project dropdown button is clicked");
			ReportConfig.Andlogpass("User selects the project","Project dropdown button is clicked");

			Wait(3000);
			F_02_Login.SelectProject(ReadFrom.Excel(1, 4, ReadFrom.Login));

			Print("Selected Project is: " + ReadFrom.Excel(1, 4, ReadFrom.Login));
			ReportConfig.Andlogpass("User selects the project","Selected Project is: " + ReadFrom.Excel(1, 4, ReadFrom.Login));



		} catch (Exception e) {

			Print(e.getMessage());

			ReportConfig.Andlogfail("User selects the project","Login button is not clicked");
			PrintError("Select project failed");

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Select project failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}


	@Given("User clicks forgot password")
	public void user_clicks_forgot_password() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User opts for forgot password link");
			if(IsElementDisplayed("ForgotPassword", LoginPageLocators)) {
				Click("ForgotPassword", LoginPageLocators);
				Print("Forgot password is dispayed and it is clicked");


				ReportConfig.Givenlogpass("User clicks forgot password","Forgot password is dispayed and it is clicked");
			}

		} 

		catch (Exception e) {

			PrintError("Forgot password is not clicked");

			ReportConfig.Givenlogfail("User clicks forgot password","Forgot password is not clicked");

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Forgot password is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );


		}

	}

	@And("User enters mailId in the email feild")
	public void user_enters_mail_id_in_the_email_feild() throws Throwable {

		try {

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(1, 0 , ReadFrom.Login));
			Print("Entered Email id: " + ReadFrom.Excel(1, 0 , "Login"));
			ReportConfig.PassedLogInfo("Entered Email id: " , ReadFrom.Excel(1, 0 , "Login"));

			ReportConfig.Andlogpass("User enters mailId in the email feild","Mail id is entered");

		} 
		catch (Exception e) {

			PrintError("EmailId is not entered");

			ReportConfig.Andlogfail("User clicks forgot password","EmailId is not entered");

			String IssueSummary = e.getMessage() ;
			String Storydescription = "EmailId is not entered" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}


	}

	@And("User clicks the submit button")
	public void user_clicks_the_submit_button() throws Throwable {


		try {
			if(IsElementDisplayed("SubmitButton", LoginPageLocators)) {
				Click("SubmitButton", LoginPageLocators);
				Print("SubmitButton button is clicked");



				ReportConfig.Andlogpass("User clicks the submit button","Submit button is clicked");

			}
		} catch (Exception e) {
			PrintError("SubmitButton button is not clicked");
			ReportConfig.Andlogfail("User clicks the submit button","Submit button is not clicked");

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Submit button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}

	}

	@Then("User should success message")
	public void user_should_success_message() throws Throwable {

		try {
			WaitForTheElement("MailSentMessage", LoginPageLocators);
			if(IsElementDisplayed("MailSentMessage", LoginPageLocators)) {
				Click("MailSentMessage", LoginPageLocators);
				Print("Mail sent popup is dispayed");



				ReportConfig.Thenlogpass("User should success message","Mail sent popup is dispayed");
			}

		} 

		catch (Exception e) {

			PrintError("Mail sent popup is not dispayed");

			ReportConfig.Thenlogfail("User should success message","Mail sent popup is not dispayed");

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Mail sent popup is not dispayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );


		}
	}

}
