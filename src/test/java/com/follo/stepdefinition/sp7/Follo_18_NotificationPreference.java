package com.follo.stepdefinition.sp7;

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
import com.follo.browser.launch.BrowserLaunch;
import com.follo.excel.read.ReadFrom;
import com.follo.module.method.F_17_ConcreteRequest;
import com.follo.module.method.F_18_NotificationPreference;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_18_NotificationPreference extends Baseclass {

	@Given("User launching the follo web")
	public void user_launching_the_follo_web() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User login existing account to verify notification feature");

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

	@Given("User login existing account")
	public void user_login_existing_account() throws Throwable {
		try {

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//button[normalize-space()='Login']"));
				}
			});

			Click("LoginButton", LoginPageLocators);

			Wait(4000);

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(0, 1 , ReadFrom.NotificationLogin));
			String email = ReadFrom.Excel(0, 1 , ReadFrom.Login);
			Print("EmailId is entered as : " + ReadFrom.Excel(0, 1 , ReadFrom.NotificationLogin));
			ReportConfig.PassedLogInfo("User login existing account to verify notification feature", "Entered mailid is : " + email);

			Wait(2000);
			TypeDataInTheField("Password", LoginPageLocators, ReadFrom.Excel(1, 1 , ReadFrom.NotificationLogin));
			String Password = ReadFrom.Excel(1, 1 , ReadFrom.Login);
			Print("Password is entered as : " + ReadFrom.Excel(1, 1 , ReadFrom.NotificationLogin));
			ReportConfig.PassedLogInfo("User login existing account to verify notification feature" ,"Entered Password is : "+ Password);

			Wait(2000);
			Click("LoginButton", LoginPageLocators);

		} 
		catch (Exception e) {

			PrintError("Login failed");

			ReportConfig.Givenlogfail("User login existing account to verify notification feature","Login failed");
			PrintError(e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Login failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}
	}



	@Given("User clicks notification preference from the menu")
	public void user_clicks_notification_preference_from_the_menu() throws Throwable {

		try {

			ReportConfig.ReportCreateFeatureTest("To verify Notification preference feature");

			ReportConfig.ReportCreateScenarioTest("User clicks Notifications preference button");
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//span[contains(text(),'Settings')])[1]"));
				}
			});

			Wait(2000);
			Click("Notifications.SettingsButton", NotificationLocators);
			Wait(2000);
			ClickPageDown();
			Wait(2000);
			Click("Notifications.NotificationsPreference", NotificationLocators);

			Print("Click on Notifications preference button button");
			ReportConfig.Givenlogpass("User click on settings button","Click on Notifications preference button button");

		} 
		catch (Exception e) {

			PrintError("Notifications preference button is not clicked");
			ReportConfig.Givenlogfail("User clicks Notifications preference button","Notifications preference button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Notifications preference button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}

	}


	@Then("Notification preference page should be displayed")
	public void notification_preference_page_should_be_displayed() throws Throwable  {

		try {

			Wait(3000);
			if(IsElementDisplayed("Notifications.Instant", NotificationLocators)) {

				Print("Validate Notifications preference Page");
				ReportConfig.Andlogpass("User clicks Notifications preference button","Validate Notifications preference Page");
				ClickPageDown();
			}


		} 
		catch (Exception e) {

			PrintError("Notifications preference is not displayed");
			ReportConfig.Givenlogfail("User clicks Notifications preference button","Notifications preference is not displayed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Notifications preference is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}

	}


	@Given("User selects instant In-app notifications")
	public void user_selects_instant_in_app_notifications() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User select instant preference");
			Wait(3000);

			F_18_NotificationPreference.SelectInstant();

		} 
		catch (Exception e) {

			PrintError("Instant list is not selected");
			ReportConfig.Givenlogfail("User select instant preference","Instant list is not selected because : " + e.getMessage());
			PrintError(e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Instant list is not selected" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}

	}



	@Given("User selects digest In-app notifications")
	public void user_selects_digest_in_app_notifications() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("User select digest preference");
			Wait(3000);

			F_18_NotificationPreference.SelectDigest();

		} 
		catch (Exception e) {

			PrintError("Digest list is not selected");
			ReportConfig.Givenlogfail("User select digest preference","Digest list is not selected because : " + e.getMessage());
			PrintError(e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Digest list is not selected" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}


	@Given("Clicks save changes button")
	public void clicks_save_changes_button() throws Throwable {

		try {

			Wait(3000);
			MoveToElement("Notifications.SaveChanges", NotificationLocators);
			Wait(2000);
			Click("Notifications.SaveChanges", NotificationLocators);

			Wait<WebDriver> Uploaded = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Uploaded.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']")); 
				}
			});

			//	Wait(1000);
			String NotificationPreference =	GetText("Notifications.Toast", NotificationLocators);
			if(IfContains(NotificationPreference, "Notification Preference Updated Successfully")) {
				Click("Notifications.Toast", NotificationLocators);
				Print("Notification preference updated successfully");
				ReportConfig.Givenlogpass("User updates Notification preference" ,"Notification preference updated successfully");

			}
			else {
				Print("Notification preference update failed");
				ReportConfig.Givenlogfail("User updates Notification preference" ,"Notification preference update failed");

				String IssueSummary =  NotificationPreference;
				String Storydescription = "Notification preference update failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}


		} 
		catch (Exception e) {

			Print("Notification preference update failed");
			ReportConfig.Givenlogfail("User updates Notification preference" ,"Notification preference update failed");

			String IssueSummary =  e.getMessage();
			String Storydescription = "Notification preference update failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}

	}

	@Given("User login existing member account")
	public void user_login_existing_member_account() throws Throwable {

		try {

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//button[normalize-space()='Login']"));
				}
			});

			Click("LoginButton", LoginPageLocators);

			Wait(4000);

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(0, 2 , ReadFrom.NotificationLogin));
			String email = ReadFrom.Excel(0, 2 , ReadFrom.NotificationLogin);
			Print("EmailId is entered as : " + ReadFrom.Excel(0, 2 , ReadFrom.NotificationLogin));
			ReportConfig.PassedLogInfo("User login existing account to verify notification feature", "Entered mailid is : " + email);

			Wait(2000);
			TypeDataInTheField("Password", LoginPageLocators, ReadFrom.Excel(1, 2 , ReadFrom.NotificationLogin));
			String Password = ReadFrom.Excel(1, 2 , ReadFrom.NotificationLogin);
			Print("Password is entered as : " + ReadFrom.Excel(1, 2 , ReadFrom.NotificationLogin));
			ReportConfig.PassedLogInfo("User login existing account to verify notification feature" ,"Entered Password is : "+ Password);

			Wait(2000);
			Click("LoginButton", LoginPageLocators);

		} 
		catch (Exception e) {

			PrintError("Login failed");

			ReportConfig.Givenlogfail("User login existing account to verify notification feature","Login failed");
			PrintError(e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Login failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

		}


	}

	@Given("Member adds a request")
	public void member_adds_a_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Member adds a request");

			Wait(2000);

			F_18_NotificationPreference.AddConcreteRequest();	

		//	ReportConfig.Givenlogpass("Member adds a request","Concrete request is added successfully");

		} 
		catch (Exception e) {

			PrintError("Add concrete request for notification is failed");
			ReportConfig.Givenlogfail("User add new Concrete request","Add concrete request for notification is failed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Add concrete request for notification is failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}

	@And("Member perform attach, delete, comment, edit and status update a request")
	public void member_perform_attach_delete_comment_edit_and_status_update_a_request() throws Throwable {

		try {

			ReportConfig.ReportCreateScenarioTest("Member perform attach, delete, comment, edit and status update a request");
			Wait(3000);

			F_18_NotificationPreference.RequestUpdate();

		} 
		catch (Exception e) {

			PrintError("Request update for notification failed");
			ReportConfig.Givenlogfail("Member perform attach, delete, comment, edit and status update a request","Request update for notification failed because : " + e.getMessage());
			PrintError(e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Request update for notification failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}


	@Given("Clicks notification from menu")
	public void clicks_notification_from_menu() throws Throwable {

		try {

			Wait(3000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//span[contains(text(),'Notifications')])[1]"));
				}
			});
			
			Click("Notifications.Notifications", NotificationLocators);


			Print("Click on Notifications button");
			ReportConfig.Andlogpass("Clicks notification from menu","Click on Notifications button");
			ClickPageDown();


		} 
		catch (Exception e) {

			PrintError("Notifications button is not clicked");
			ReportConfig.Givenlogfail("Clicks notification from menu","Notifications button is not clicked because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Notifications button is not clicked" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}
	@Then("Notification page should displayed")
	public void notification_page_should_displayed() throws Throwable {

		try {

			Wait(3000);
			if(IsElementDisplayed("Notifications.NotificationPage", NotificationLocators)) {

				Print("Notifications page is displayed");
				ReportConfig.Andlogpass("Notification page should displayed","Notifications page is displayed");
				ClickPageDown();
			}


		} 
		catch (Exception e) {

			PrintError("Notifications page is not displayed");
			ReportConfig.Givenlogfail("Notification page should displayed","Notifications page is not displayed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Notifications page is not displayed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
	}

	@Given("User verify the notification list")
	public void user_verify_the_notification_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User verify the notification list");

			Wait(3000);
			String NotificationName = GetText("Notifications.FirstNotification", NotificationLocators);
			Print("Notifications received : " + NotificationName);
			ReportConfig.Andlogpass("User verify the notification list","Notifications received : " + NotificationName);
			Wait(3000);
			Click("Notifications.FirstNotification", NotificationLocators);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']"));
				}
			});
			
			Print("Validate Notifications");
			ReportConfig.Andlogpass("User verify the notification list","Validate Notifications");
			Wait(3000);
			Click("Notifications.ClosePopup",NotificationLocators);
			Print("Click on Close popup button");
			ReportConfig.Andlogpass("User verify the notification list","Click on Close popup button");

		} 
		catch (Exception e) {

			PrintError("Notifications is not viewed");
			ReportConfig.Givenlogfail("User verify the notification list","Notifications is not viewed because : " + e.getMessage());

			String IssueSummary = e.getMessage() ;
			String Storydescription = "Notifications is not viewed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}
	@Given("Search the notification")
	public void search_the_notification() throws Throwable {
		
		try {

			ReportConfig.ReportCreateScenarioTest("Search the notification");
			Wait(3000);

			F_18_NotificationPreference.SearchNotification();

		} 
		catch (Exception e) {

			PrintError("Search notification failed");
			ReportConfig.Givenlogfail("Search the notification","Search notification failed because : " + e.getMessage());
			PrintError(e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Search notification failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}
		


	}
	@Given("Filter the notification")
	public void filter_the_notification() throws Throwable {
		
		try {

			ReportConfig.ReportCreateScenarioTest("Filter the notification");
			Wait(3000);

			F_18_NotificationPreference.FilterNotification();

		} 
		catch (Exception e) {

			PrintError("Filter notification failed");
			ReportConfig.Givenlogfail("Filter the notification","Filter notification failed because : " + e.getMessage());
			PrintError(e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Filter notification failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}
	
	@Then("Delete the notification")
	public void delete_the_notification() throws Throwable {
		
		try {

			ReportConfig.ReportCreateScenarioTest("Delete the notification");
			Wait(3000);

			Click("Notifications.DeleteNotification", NotificationLocators);
			Print("Click on delete button");
			ReportConfig.Givenlogpass("Delete the notification" ,"Click on delete button");
			Wait(3000);
			Click("Notifications.YesDelete", NotificationLocators);
			Print("Click on Yes button");
			ReportConfig.Givenlogpass("Delete the notification" ,"Click on Yes button");
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


		 fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});
		 
			String NotificationDeleted =	GetText("Notifications.Toast", NotificationLocators);
			if(IfContains(NotificationDeleted, "Notification Deleted Successfully")) {
				Click("Notifications.Toast", NotificationLocators);
				Print("Notification deleted Successfully");
				ReportConfig.Givenlogpass("Delete the notification" ,"Notification deleted Successfully");

			}
			else {
				Print("Notification delete failed");
				ReportConfig.Givenlogfail("Delete the notification" ,"Notification delete failed");
				String IssueSummary =  NotificationDeleted;
				String Storydescription = "Notification delete failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

		} 
		catch (Exception e) {

			PrintError("Notification delete failed");
			ReportConfig.Givenlogfail("Delete the notification","Notification delete failed because : " + e.getMessage());
			PrintError(e.getMessage());
			String IssueSummary = e.getMessage() ;
			String Storydescription = "Notification delete failed" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
		}


	}

}
