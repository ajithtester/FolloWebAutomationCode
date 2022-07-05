package com.follo.module.method;

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

import report.ReportConfig;


public class F_01_Registeration extends Baseclass {

	public static void SelectPlan(String Plan) throws Throwable {

		switch (Plan) {
		case "Trial Plan":

			Click("TrailPlan", RegisterPageLocators);
		
		ReportConfig.Givenlogpass("User selects the subscription plan", "Trail Plan is clicked");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


		 fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
				}
			});

			if(IsElementDisplayed("CloseButton", RegisterPageLocators)) {
				Print("Selected plan is: Trial plan");

				ReportConfig.PassedLogInfo("User selects the subscription plan", "Plan selection popup is displayed : Selected plan is: Trial plan");

				Click("CloseButton", RegisterPageLocators);
				ReportConfig.PassedLogInfo("User selects the subscription plan", "Click on Close button");

			}
			else {
				PrintError("Trial plan is not selected successfully");
				ReportConfig.FailedLogInfo("User selects the subscription plan", "Trial plan is not selected successfully");
				String IssueSummary = "Trial plan popup message is not displayed" ;
				String Storydescription = "Subcription Plan not selected" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				
			}
			break;

		case "Project Plan":

			Click("ProjectPlan", RegisterPageLocators);
			//WebElement ProjectPlan =  WaitForTheElement("ProjectPlan", RegisterPageLocators);

			//	ProjectPlan.click();
			ReportConfig.PassedLogInfo("User selects the subscription plan","Project Plan is clicked");

			if(IsElementDisplayed("PaymentPage", RegisterPageLocators)) {
				ReportConfig.PassedLogInfo("User selects the subscription plan","Validate Payment Page");
				Print("Validate Payment Page");

				SelectFromDropdown("MonthorYear", RegisterPageLocators, ReadFrom.Excel(22, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("User selects the subscription plan", "Selected : " + ReadFrom.Excel(22, 1, ReadFrom.Register));

				if(IsEqual(ReadFrom.Excel(22, 1, ReadFrom.Register),("year"))){
					Wait(2000);
					ScrollDown();
					Wait(2000);
					//Click("ProjectPlan", RegisterPageLocators);

				}
				TypeDataInTheField("NameOnTheCard", RegisterPageLocators, ReadFrom.Excel(23, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Entered Card name : " , ReadFrom.Excel(23, 1, ReadFrom.Register));

				TypeDataInTheField("CardNumber", RegisterPageLocators, ReadFrom.Excel(24, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Entered Card number  : " , ReadFrom.Excel(24, 1, ReadFrom.Register));


				SelectFromDropdown("ExpiryMonth", RegisterPageLocators, ReadFrom.Excel(25, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Entered Expiry month : " , ReadFrom.Excel(25, 1, ReadFrom.Register));

				SelectFromDropdown("ExpiryYear", RegisterPageLocators, ReadFrom.Excel(26, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Entered Expiry year : " , ReadFrom.Excel(26, 1, ReadFrom.Register));


				TypeDataInTheField("Cvc", RegisterPageLocators, ReadFrom.Excel(27, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Entered CVC : " , ReadFrom.Excel(27, 1, ReadFrom.Register));

				Wait(2000);
				SelectFromDropdown("PaymentCountry", RegisterPageLocators, ReadFrom.Excel(28, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Selected Payment country : " , ReadFrom.Excel(28, 1, ReadFrom.Register));


				TypeDataInTheField("PaymentzipCode", RegisterPageLocators, ReadFrom.Excel(29, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Entered ZipCode  : " , ReadFrom.Excel(29, 1, ReadFrom.Register));

				Click("Pay", RegisterPageLocators);
				ReportConfig.PassedLogInfo("User selects the subscription plan", "Click on Pay Button");

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				  fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
					}
				});


				if(getElement("CloseButton", RegisterPageLocators).isDisplayed()) {
					Print("Selected plan is: Project plan");
					ReportConfig.PassedLogInfo("User selects the subscription plan","Plan selection popup is displayed : Selected plan is: Project plan");

					Click("CloseButton", RegisterPageLocators);
					ReportConfig.PassedLogInfo("User selects the subscription plan","Close button is clicked");
				}
				else {
					PrintError("Project plan is not selected successfully");
					ReportConfig.FailedLogInfo("User selects the subscription plan","Project plan is not selected successfully");
					String IssueSummary = "Project plan popup message is not displayed" ;
					String Storydescription = "Subcription Plan not selected" ;
					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				}


			}
			break;

		case "Enterprise Plan":
			Click("EnterprisePlan", RegisterPageLocators);
			//WebElement EnterprisePlan =  WaitForTheElement("EnterprisePlan", RegisterPageLocators);


			//EnterprisePlan.click();
			ReportConfig.PassedLogInfo("User selects the subscription plan","Enterprise Plan is clicked");

			if(IsElementDisplayed("EnterprisePlanMessage", RegisterPageLocators)) {
				Print("Selected plan is: Enterprise plan");
				ReportConfig.PassedLogInfo("User selects the subscription plan","Plan selection popup is displayed : Selected plan is: Enterprise plan");
			}
			else {
				PrintError("Enterprise plan is not selected successfully");
				ReportConfig.FailedLogInfo("User selects the subscription plan","Enterprise plan is not selected successfully");
				String IssueSummary = "Enterprise plan popup message is not displayed" ;
				String Storydescription = "Subcription Plan not selected" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}

			break;
		default:
			PrintError("Please select the correct plan");
			ReportConfig.PassedLogInfo("User selects the subscription plan","Please select the correct plan");

		}
	}



}
