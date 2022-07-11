package com.follo.module.method;

import java.time.Duration;
import java.util.function.Function;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

import report.ReportConfig;

public class F_06_Gate extends Baseclass{


	public static void AddGate() throws Throwable {

		Wait(3000);
		PrintError("Add Gate Started");
		ReadFrom.DynamicExcel(ReadFrom.AddGates);

		for(int AddGate =1; AddGate<=ReadFrom.rowcount; AddGate++)		{	

			Click("AddNewGate", GateLocators);
			ReportConfig.PassedLogInfo("User adds new gate","Click on Add new gate button");
			Print("Click on Add new gate button");

			TypeDataInTheField("GateName", GateLocators, ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));
			ReportConfig.PassedLogInfo("User adds new gate", "Entered Gate name : " + ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));
			Print("Entered Gate name : " + ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));

			Wait(2000);

			Click("SubmitButton", GateLocators);
			ReportConfig.PassedLogInfo("User adds new gate","Click on Submit button");
			Print("Click on Submit button");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@aria-label='Gate added successfully.']"));
				}
			});

			if(IsElementDisplayed("GateAdded", GateLocators)) {
				Click("GateAdded", GateLocators);
				Print("Gate added : " + ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));
				ReportConfig.PassedLogInfo("User adds new gate", "Gate added : " + ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));
			}
			else {

				PrintError("Gate is not added");
				ReportConfig.FailedLogInfo("User adds new gate","Gate is not added");
				String IssueSummary = "Gate added successfully is not displayed" ;
				String Storydescription = "Add gates" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}
		}
	}

	public static void EditGate() throws Throwable {
		PrintError("Edit Gate Started");
		ReadFrom.DynamicExcel(ReadFrom.EditGates);

		for(int EditGate = 1; EditGate<=ReadFrom.rowcount; EditGate++)	{


			int rowcount = 		SizeOfTheList("GateListLocator", GateLocators);

			for(int GateList =1; GateList<=rowcount; GateList++)		{

				WebElement Gate =	FindElement("GateList", GateLocators, GateList);

				String GateName = 	GetTextFromTheElement(Gate);

				String EditIt =	ReadFrom.Excel(EditGate, 0, ReadFrom.EditGates);

				if(IsEqual(GateName, EditIt)) {

					WebElement EditButton =	FindElement("EditButtons", GateLocators, GateList);
					Click(EditButton);


					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//input[@placeholder='Gate Name*']"));
						}
					});

					Clear("GateName", GateLocators);
					TypeDataInTheField("GateName", GateLocators, ReadFrom.Excel(EditGate, 1, ReadFrom.EditGates));
					ReportConfig.PassedLogInfo("User edit a gate from the list", "Edited Gate name is : " + ReadFrom.Excel(EditGate, 1, ReadFrom.EditGates));
					Print("Edited Gate name is : " + ReadFrom.Excel(EditGate, 1, ReadFrom.EditGates));

					Wait(2000);

					Click("UpdateButton", GateLocators);
					ReportConfig.PassedLogInfo("User edit a gate from the list","Click on Update button");
					Print("Click on Update button");

					Wait<WebDriver> UpdateButton = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					UpdateButton.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Gate Updated successfully.']"));
						}
					});

					if(IsElementDisplayed("GateUpdated", GateLocators)) {
						Click("GateUpdated", GateLocators);
						Print("updated Gate is : " + ReadFrom.Excel(EditGate, 0, ReadFrom.AddGates));
						ReportConfig.PassedLogInfo("updated Gate is : " , ReadFrom.Excel(EditGate, 0, ReadFrom.AddGates));
					}
					else {

						PrintError("Gate is not updated");
						ReportConfig.FailedLogInfo("To edit gates" ,"Gate is not updated");
						String IssueSummary = "Gate Updated successfully is not displayed" ;
						String Storydescription = "Update gates" ;
						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
					}
				}
				Wait(5000);
			}
		}
	}

	public static void DeleteGate() throws Throwable {
		PrintError("Delete gate Started");
		ReadFrom.DynamicExcel(ReadFrom.DeleteGates);

		for(int DeleteGate =1; DeleteGate<=ReadFrom.rowcount; DeleteGate++)	{


			int rowcount = 	SizeOfTheList("DeleteButtonsLocator", GateLocators);

			for(int DeleteButton =1; DeleteButton<=rowcount; DeleteButton++)	{

				WebElement Gate =	FindElement("GateList", GateLocators, DeleteButton);

				String GateName = 	GetTextFromTheElement(Gate);

				String DeleteIt =	ReadFrom.Excel(DeleteGate, 0, ReadFrom.DeleteGates);


				if(IsEqual(GateName, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteButtons" ,GateLocators, DeleteButton);
					Click(Delete);
					Wait(2000);

					Click("YesDelete", GateLocators);
					ReportConfig.PassedLogInfo("User delete a gate from the list","Click on delete button");
					Print("Click on delete button");

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);

					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Gate deleted successfully.']"));
						}
					});

					if(IsElementDisplayed("GateDeleted", GateLocators)){
						Click("GateDeleted", GateLocators);
						Print("Deleted gate is : " + ReadFrom.Excel(DeleteGate, 0, ReadFrom.DeleteGates));
						ReportConfig.PassedLogInfo("User delete a gate from the list", "Deleted gate is : " + ReadFrom.Excel(DeleteGate, 0, ReadFrom.DeleteGates));
						break;
					}else {
						PrintError("Gate not deleted");
						ReportConfig.FailedLogInfo("User delete a gate from the list","Gate not deleted");

						String IssueSummary = "Gate deleted successfully is not displayed" ;
						String Storydescription = "Delete gates" ;
						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

						Wait(3000);

						break;

					}
				}
			}
		}
	}

	public static void SearchGates() throws Throwable {

		PrintError("Search gates Started");
		ReadFrom.DynamicExcel(ReadFrom.SearchGates);

		Click("SearchButton", GateLocators);
		for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

			Wait(2000);

			TypeDataInTheField("Search", GateLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchGates));
			ReportConfig.PassedLogInfo("User search and view the gates", "Searched value :" + ReadFrom.Excel(Search, 0, ReadFrom.SearchGates));
			Print("Searched value :" + ReadFrom.Excel(Search, 0, ReadFrom.SearchGates));

			Wait(5000);


			int rowcount = 	SizeOfTheList("GateListLocator", GateLocators);

			for(int SearchedGates =1; SearchedGates<=rowcount; SearchedGates++)	{

				WebElement Gate =	FindElement("GateList", GateLocators, SearchedGates);
				String Gatename =	GetTextFromTheElement(Gate);

				Wait(2000);

				String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchGates);



				if(IsEqual(Gatename, SearchedValue)) {

					Wait(2000);
					Print("Displayed value is : " + Gatename);
					ReportConfig.PassedLogInfo("User search and view the gates", "Displayed value is : " + Gatename);

					Wait(7000);

				}
				else {
					PrintError("Displayed value is : " + Gatename);
//					ReportConfig.FailedLogInfo("Displayed value is : " , Gatename);
//					String IssueSummary = "Searched value is : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchGates) + "but displayed value is : " + Gatename ;
//					String Storydescription = "Search gates" ;
//					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				}


			}
			Wait(3000);
			Clear("Search", GateLocators);
			Wait(3000);
			Click("ClearSearch", GateLocators);
			ReportConfig.PassedLogInfo("Search gate" ,"Click on Clear search button");
			Print("Click on Clear search button");


		}

	}

	public static void MaximumCharacterLength() throws Throwable {

		Wait(3000);
		PrintError("MaximumCharacterLength Gate Started");

		for(int AddGate =1; AddGate<=1; AddGate++)		{	

			Click("AddNewGate", GateLocators);
			ReportConfig.Givenlogpass("user adds gate name that exceeds maximum length" ,"Click on Add new gate button");
			Print("Click on Add new gate button");

			Wait(3000);

			String shortName = "dc";

			TypeDataInTheField("GateName", GateLocators, shortName);


			Wait(2000);

			Click("SubmitButton", GateLocators);
			ReportConfig.Givenlogpass("user adds gate name that exceeds maximum length" ,"Click on Submit button");
			Print("Click on Submit button");


			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));

			String MinimumCharacters =	GetText("MinimumCharacters", GateLocators);


			Print("Minimum charcter length needed error : " + MinimumCharacters);
			ReportConfig.Givenlogpass("user adds gate name that exceeds maximum length" ,"Minimum charcter length needed error: " + MinimumCharacters);

			String name = RandomStringUtils.randomAlphabetic(300);

			Wait(2000);

			Clear("GateName", GateLocators);
			Wait(2000);

			TypeDataInTheField("GateName", GateLocators, name);


			Wait(2000);

			Click("SubmitButton", GateLocators);
			ReportConfig.Givenlogpass("user adds gate name that exceeds maximum length" ,"Click on Submit button");
			Print("Click on Submit button");


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));
			String MaximumCharacters =	GetText("MaximumCharacters", GateLocators);


			Print("Maximum charcter exceeds error : " + MaximumCharacters);
			ReportConfig.Givenlogpass("user adds gate name that exceeds maximum length" ,"Maximum charcter exceeds error: " + MaximumCharacters);

			Wait(7000);

			Click("CancelButton", GateLocators);
			Print("Click on Cancel button");

			Wait(3000);

			Click("Yes", GateLocators);

			Print("Yes button is clicked");
			ReportConfig.Givenlogpass("user adds gate name that exceeds maximum length" ,"Click on Close button");

		}
	}
}
