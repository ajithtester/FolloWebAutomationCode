package com.follo.module.method;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

import report.ReportConfig;

public class F_14_CraneRequest extends Baseclass{

	public static void AddCraneRequest() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.AddCraneRequest);
		PrintError("Add Crane request Started");
		for(int AddCraneRequest =1; AddCraneRequest<=ReadFrom.rowcount; AddCraneRequest++)		{	

			Wait(4000);

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//button[normalize-space()='Create New']"));
				}
			});

			if(IsElementDisplayed("CreateNew", CraneRequestLocators)){
				JsClick("CreateNew", CraneRequestLocators);
				Print("Click on Create new button");
				ReportConfig.PassedLogInfo("User add new Crane request","Click on Create new button");

			}
			else
			{
				PrintError("Create new button is not clicked");
				ReportConfig.FailedLogInfo("User add new Crane request","Create new button is not clicked");
				
				String IssueSummary = "Create new button is not clicked" ;
				String Storydescription = "Add crane request" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}


			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait1.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
				}
			});

			if(IsElementDisplayed("Description", CraneRequestLocators)) {
				Print("Delivery popup is opened");
				ReportConfig.PassedLogInfo("User add new Crane request","Delivery popup is opened");
			}

			TypeDataInTheField("Description", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 0, ReadFrom.AddCraneRequest));
			Print("Entered Description : " + ReadFrom.Excel(AddCraneRequest, 0, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered Description : " + ReadFrom.Excel(AddCraneRequest, 0, ReadFrom.AddCraneRequest));


			Click("Company", CraneRequestLocators);
			ReportConfig.PassedLogInfo("User add new Crane request","Click on Company dropdown");

			String CompanyInExcel = ReadFrom.Excel(AddCraneRequest, 1, ReadFrom.AddCraneRequest);

			int countofthelist = 	SizeOfTheList("CompanyAdd", CraneRequestLocators);

			for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	

				WebElement Company = 	FindElement("CompanyAddList", CraneRequestLocators, DropdownValues);
				String CompanyInDropdown = 	GetTextFromTheElement(Company);

				if(IsEqual(CompanyInDropdown, CompanyInExcel)){
					Click(Company);

					ReportConfig.PassedLogInfo("User add new Crane request",CompanyInDropdown + " is selected from the dropdown");
					Print(CompanyInDropdown + " is selected from the dropdown");
					break;
				}
			}	
			///////////////////////

			Click("Dfow", CraneRequestLocators);
			ReportConfig.PassedLogInfo("User add new Crane request","Click on Dfow dropdown");

			String DfowInExcel = ReadFrom.Excel(AddCraneRequest, 2,ReadFrom.AddCraneRequest);

			int rowcountofthelist = 	SizeOfTheList("DfowAdd", CraneRequestLocators);

			for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
				WebElement Dfow = 	FindElement("DfowAddList", CraneRequestLocators, DropdownValues);
				String DfowInDropdown = 	GetTextFromTheElement(Dfow);


				if(IsEqual(DfowInDropdown, DfowInExcel)){
					Click(Dfow);
					ReportConfig.PassedLogInfo("User add new Crane request",DfowInDropdown + " is selected from the dropdown");
					Print("Selected DFOW : " + DfowInDropdown );
					break;
				}
			}	

			/////////////////////////////////////

			SelectFromVisibleText("EquipmentDropdown", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 10, ReadFrom.AddCraneRequest));
			Print("Selected Equipment dropdown  : " + ReadFrom.Excel(AddCraneRequest, 10, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Selected Equipment dropdown  : " + ReadFrom.Excel(AddCraneRequest, 10, ReadFrom.AddCraneRequest));


			Clear("DeliveryDate", CraneRequestLocators);
			TypeDataInTheField("DeliveryDate", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 3, ReadFrom.AddCraneRequest));
			Print("Entered Start date : " + ReadFrom.Excel(AddCraneRequest, 3, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered Start date : " + ReadFrom.Excel(AddCraneRequest, 3, ReadFrom.AddCraneRequest));

			///////

			Wait(2000);
			Clear("FromHrs", CraneRequestLocators);
			TypeDataInTheField("FromHrs", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 4, ReadFrom.AddCraneRequest));
			Print("Entered From hrs : " + ReadFrom.Excel(AddCraneRequest, 4, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered From hrs : " + ReadFrom.Excel(AddCraneRequest, 4, ReadFrom.AddCraneRequest));

			Wait(2000);
			Clear("FromMin", CraneRequestLocators);
			TypeDataInTheField("FromMin", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 5, ReadFrom.AddCraneRequest));
			Print("Entered From min : " + ReadFrom.Excel(AddCraneRequest, 5, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered From min : " + ReadFrom.Excel(AddCraneRequest, 5, ReadFrom.AddCraneRequest));

			Wait(2000);
			String ExcelMeridian = ReadFrom.Excel(AddCraneRequest, 6, ReadFrom.AddCraneRequest);
			String Meridian = GetText("FromMeridian", CraneRequestLocators);
			if(IsEqual(Meridian, ExcelMeridian)) {

			}
			else {
				Click("FromMeridian", CraneRequestLocators);
			}

			Wait(2000);
			Clear("ToHrs", CraneRequestLocators);
			TypeDataInTheField("ToHrs", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 7, ReadFrom.AddCraneRequest));
			Print("Entered to hrs : " + ReadFrom.Excel(AddCraneRequest, 7, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered to hrs : " + ReadFrom.Excel(AddCraneRequest, 7, ReadFrom.AddCraneRequest));

			Wait(2000);
			Clear("ToMin", CraneRequestLocators);
			TypeDataInTheField("ToMin", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 8, ReadFrom.AddCraneRequest));
			Print("Entered to min : " + ReadFrom.Excel(AddCraneRequest, 8, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered to min : " + ReadFrom.Excel(AddCraneRequest, 8, ReadFrom.AddCraneRequest));

			Wait(2000);
			String ExcelMeridian1 = ReadFrom.Excel(AddCraneRequest, 9, ReadFrom.AddCraneRequest);
			String Meridian1 = GetText("ToMeridian", CraneRequestLocators);
			if(IsEqual(Meridian1, ExcelMeridian1)) {


			}
			else {
				Click("ToMeridian", CraneRequestLocators);
			}


			Wait(2000);
			Clear("PickingFrom", CraneRequestLocators);
			TypeDataInTheField("PickingFrom", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 11, ReadFrom.AddCraneRequest));
			Print("Entered Picking from : " + ReadFrom.Excel(AddCraneRequest, 11, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered Picking from : " + ReadFrom.Excel(AddCraneRequest, 11, ReadFrom.AddCraneRequest));

			Wait(2000);
			Clear("PickingTo", CraneRequestLocators);
			TypeDataInTheField("PickingTo", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 12, ReadFrom.AddCraneRequest));
			Print("Entered Picking to : " + ReadFrom.Excel(AddCraneRequest, 12, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered Picking to : " + ReadFrom.Excel(AddCraneRequest, 12, ReadFrom.AddCraneRequest));

			Wait(2000);
			MoveToElement("AdditionalText", CraneRequestLocators);
			Clear("AdditionalText", CraneRequestLocators);
			TypeDataInTheField("AdditionalText", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 13, ReadFrom.AddCraneRequest));
			Print("Entered Additional text : " + ReadFrom.Excel(AddCraneRequest, 13, ReadFrom.AddCraneRequest));
			ReportConfig.PassedLogInfo("User add new Crane request","Entered Additional text : " + ReadFrom.Excel(AddCraneRequest, 13, ReadFrom.AddCraneRequest));

			Wait(4000);	

			MoveToElement("SubmitButton", CraneRequestLocators);

			Click("SubmitButton", CraneRequestLocators);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@aria-label='Crane Request Created Successfully.']"));
				}
			});

			if(IsElementDisplayed("DeliveryAdded", CraneRequestLocators)) {
				Click("DeliveryAdded", CraneRequestLocators);
				Print("Crane request added");
				ReportConfig.PassedLogInfo("User add new Crane request","Crane request added");

			}
			else {
				PrintError("Delivery not added");
				ReportConfig.FailedLogInfo("User add new Crane request","Crane request not added");
			}
			Wait(3000);
		}


	}

	public static void NegativeMandatory() throws Throwable {

		PrintError("NegativeMandatory Crane request Started");


		Wait(2000);
		ReportConfig.PassedLogInfo("User add a Crane request without mandatory feild","Click on Create new button");
		JsClick("CreateNew", CraneRequestLocators);
		Wait(2000);
		MoveToElement("SubmitButton", CraneRequestLocators);
		JsClick("SubmitButton", CraneRequestLocators);
		ReportConfig.PassedLogInfo("User add new crane request","Click on Submit button");

		String DescriptionRequired = 	GetText("DescriptionRequired", CraneRequestLocators);
		String EquipmentRequired = 		GetText("EquipmentRequired", CraneRequestLocators);
		String PickingFromRequired = 	GetText("PickingFromRequired", CraneRequestLocators);
		String PickingToRequired = 		GetText("PickingToRequired", CraneRequestLocators);

		ReportConfig.Givenlogpass("Description required Error :", DescriptionRequired);
		ReportConfig.Givenlogpass("Equipment required Error :", EquipmentRequired);
		ReportConfig.Givenlogpass("Picking from Error :", PickingFromRequired);
		ReportConfig.Givenlogpass("Picking to Error :", PickingToRequired);

		Wait(2000);
		Click("CancelButton", CraneRequestLocators);
		ReportConfig.PassedLogInfo("User add a Crane request without mandatory feild","Cancel button is clicked");
		Click("Yes", CraneRequestLocators);
		ReportConfig.PassedLogInfo("User add a Crane request without mandatory feild","Click on Yes button");



	}

	public static void InValidTime() throws Throwable {
		PrintError("InValidTime Crane request Started");
		ReadFrom.DynamicExcel(ReadFrom.NegativeCraneCalendar);

		for(int CraneCalendar =1; CraneCalendar<=ReadFrom.rowcount; CraneCalendar++)		{	

			Wait(4000);
			PrintError("Add Crane Calendar Started");
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//button[normalize-space()='Create New']"));
				}
			});

			if(IsElementDisplayed("CreateNew", CraneRequestLocators)){
				JsClick("CreateNew", CraneRequestLocators);
				Print("Click on Create new button");
				ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Click on Create new button");

			}
			else
			{
				PrintError("Create new button is not clicked");
				ReportConfig.FailedLogInfo("User gives invalid time in Crane calendar","Create new button is not clicked");
			
			
				String IssueSummary = "Create new button is not clicked" ;
				String Storydescription = "InValid Time Crane request" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				
			}


			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait1.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
				}
			});

			if(IsElementDisplayed("Description", CraneRequestLocators)) {
				Print("Delivery popup is opened");
				ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Delivery popup is opened");
			}

			TypeDataInTheField("Description", CraneRequestLocators, ReadFrom.Excel(CraneCalendar, 0, ReadFrom.NegativeCraneCalendar));
			Print("Entered Description : " + ReadFrom.Excel(CraneCalendar, 0, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Entered Description : " + ReadFrom.Excel(CraneCalendar, 0, ReadFrom.NegativeCraneCalendar));


			///////////////////////

			/////////////////////////////////////

			SelectFromVisibleText("EquipmentDropdown", CraneRequestLocators, ReadFrom.Excel(CraneCalendar, 10, ReadFrom.NegativeCraneCalendar));
			Print("Selected Equipment dropdown  : " + ReadFrom.Excel(CraneCalendar, 10, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Selected Equipment dropdown  : " + ReadFrom.Excel(CraneCalendar, 10, ReadFrom.NegativeCraneCalendar));

			///////

			Wait(2000);
			Clear("FromHrs", CraneRequestLocators);
			TypeDataInTheField("FromHrs", CraneRequestLocators, ReadFrom.Excel(CraneCalendar, 4, ReadFrom.NegativeCraneCalendar));
			Print("Entered From hrs : " + ReadFrom.Excel(CraneCalendar, 4, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Entered From hrs : " + ReadFrom.Excel(CraneCalendar, 4, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			Clear("FromMin", CraneRequestLocators);
			TypeDataInTheField("FromMin", CraneRequestLocators, ReadFrom.Excel(CraneCalendar, 5, ReadFrom.NegativeCraneCalendar));
			Print("Entered From min : " + ReadFrom.Excel(CraneCalendar, 5, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Entered From min : " + ReadFrom.Excel(CraneCalendar, 5, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			String ExcelMeridian = ReadFrom.Excel(CraneCalendar, 6, ReadFrom.NegativeCraneCalendar);
			String Meridian = GetText("FromMeridian", CraneRequestLocators);
			if(IsEqual(Meridian, ExcelMeridian)) {


			}
			else {
				Click("FromMeridian", CraneRequestLocators);
			}

			Wait(2000);
			Clear("ToHrs", CraneRequestLocators);
			TypeDataInTheField("ToHrs", CraneRequestLocators, ReadFrom.Excel(CraneCalendar, 7, ReadFrom.NegativeCraneCalendar));
			Print("Entered to hrs : " + ReadFrom.Excel(CraneCalendar, 7, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Entered to hrs : " + ReadFrom.Excel(CraneCalendar, 7, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			Clear("ToMin", CraneRequestLocators);
			TypeDataInTheField("ToMin", CraneRequestLocators, ReadFrom.Excel(CraneCalendar, 8, ReadFrom.NegativeCraneCalendar));
			Print("Entered to min : " + ReadFrom.Excel(CraneCalendar, 8, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Entered to min : " + ReadFrom.Excel(CraneCalendar, 8, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			String ExcelMeridian1 = ReadFrom.Excel(CraneCalendar, 9, ReadFrom.NegativeCraneCalendar);
			String Meridian1 = GetText("ToMeridian", CraneRequestLocators);
			if(IsEqual(Meridian1, ExcelMeridian1)) {


			}
			else {
				Click("ToMeridian", CraneRequestLocators);
			}


			Wait(2000);
			Clear("PickingFrom", CraneRequestLocators);
			TypeDataInTheField("PickingFrom", CraneRequestLocators, ReadFrom.Excel(CraneCalendar, 11, ReadFrom.NegativeCraneCalendar));
			Print("Entered Picking from : " + ReadFrom.Excel(CraneCalendar, 11, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Entered Picking from : " + ReadFrom.Excel(CraneCalendar, 11, ReadFrom.NegativeCraneCalendar));

			Wait(2000);
			Clear("PickingTo", CraneRequestLocators);
			TypeDataInTheField("PickingTo", CraneRequestLocators, ReadFrom.Excel(CraneCalendar, 12, ReadFrom.NegativeCraneCalendar));
			Print("Entered Picking to : " + ReadFrom.Excel(CraneCalendar, 12, ReadFrom.NegativeCraneCalendar));
			ReportConfig.PassedLogInfo("User gives invalid time in Crane calendar","Entered Picking to : " + ReadFrom.Excel(CraneCalendar, 12, ReadFrom.NegativeCraneCalendar));

			Wait(2000);

			MoveToElement("SubmitButton", CraneRequestLocators);

			Click("SubmitButton", CraneRequestLocators);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@aria-label='Please Enter Start time Lesser than End time']"));
				}
			});

			String EnterTime =	GetText("EnterTime", CraneRequestLocators);
			if(IsElementDisplayed("EnterTime", CraneRequestLocators)) {
				Click("EnterTime", CraneRequestLocators);
				ReportConfig.Givenlogpass("User gives invalid time in Crane calendar","Time error : " + EnterTime);
				Wait(2000);
				Click("CancelButton", CraneRequestLocators);
				ReportConfig.PassedLogInfo("User add new crane request","Cancel button is clicked");
				Click("Yes", CraneRequestLocators);
				ReportConfig.PassedLogInfo("User add new crane request","Click on Yes button");

			}
			else {
				PrintError("Delivery not added");
				ReportConfig.FailedLogInfo("User gives invalid time in Crane calendar","Error message didn't displayed");

			}
			Wait(3000);
		}
	}


	public static void EditWithoutCompany_Negative() throws Throwable {
		
		PrintError("EditWithoutCompany_Negative crane request started");
		ReadFrom.DynamicExcel(ReadFrom.NegativeCraneCalendar);

		for(int EditCraneRequest =1; EditCraneRequest<=ReadFrom.rowcount; EditCraneRequest++)	{


			int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

			for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


				WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String EditIt =	ReadFrom.Excel(EditCraneRequest, 0, ReadFrom.AddCraneRequest);


				if(IsEqual(DeliveryName, EditIt)) {

					WebElement EditButton =	FindElement("EditCraneRequest", CraneRequestLocators, DeliveryLists);

					JsClick(EditButton);

					ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane request","Edit button is clicked");
					Print("Edit button is clicked");


					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					fluentWait1.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
						}
					});

					if(IsElementDisplayed("Description", CraneRequestLocators)) {
						Print("Delivery popup is opened");
						ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane request","Delivery popup is opened");
					}

					/////////////////////////////////////
					JsClick("CompanyEdit", CraneRequestLocators);

					ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane request","Click on Company dropdown");
					Print("Click on Company dropdown");

					Click("UnselectAll", CraneRequestLocators);
					Wait(2000);
					Click("UnselectAll", CraneRequestLocators);
					Wait(2000);

					MoveToElement("SubmitButton", CraneRequestLocators);

					Click("SubmitButton", CraneRequestLocators);

					Wait<WebDriver> Responsible = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					Responsible.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Responsible Company is required']"));
						}
					});

					String CompanyRequired =	GetText("CompanyRequired", CraneRequestLocators);

					if(IsElementDisplayed("CompanyRequired", CraneRequestLocators)) {

						Click("CompanyRequired", CraneRequestLocators);
						ReportConfig.Givenlogpass("User edit and save a crane request without company in Crane request","Error : " + CompanyRequired);
						Wait(2000);
						Click("CancelButton", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane request","Cancel button is clicked");
						Click("Yes", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane request","Click on Yes button");

						ReportConfig.PassedLogInfo("User edit and save a crane request without company in Crane request","Crane request updated");

						break;

					}
				}
			}
		}
	}
	
	public static void EditWithoutDFOW_Negative() throws Throwable {
	
		PrintError("EditWithoutDFOW_Negative crane request started");
	ReadFrom.DynamicExcel(ReadFrom.NegativeCraneCalendar);

	for(int EditCraneRequest =1; EditCraneRequest<=ReadFrom.rowcount; EditCraneRequest++)	{


		int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

		for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


			WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

			String DeliveryName = 	GetTextFromTheElement(Delivery);

			String EditIt =	ReadFrom.Excel(EditCraneRequest, 0, ReadFrom.AddCraneRequest);


			if(IsEqual(DeliveryName, EditIt)) {

				WebElement EditButton =	FindElement("EditCraneRequest", CraneRequestLocators, DeliveryLists);

				JsClick(EditButton);

				ReportConfig.PassedLogInfo("User edit and save a crane request without DFOW in Crane request","Edit button is clicked");
				Print("Edit button is clicked");


				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
					}
				});

				if(IsElementDisplayed("Description", CraneRequestLocators)) {
					Print("Delivery popup is opened");
					ReportConfig.PassedLogInfo("User edit and save a crane request without DFOW in Crane request","Delivery popup is opened");
				}

				/////////////////////////////////////
				ReportConfig.PassedLogInfo("User edit and save a crane request without DFOW in Crane request","Click on Company dropdown");
				JsClick("DfowEdit", CraneRequestLocators);

				ReportConfig.PassedLogInfo("User edit and save a crane request without DFOW in Crane request","Click on Dfow dropdown");

				Click("SelectAll", CraneRequestLocators);
				Wait(2000);
				Click("SelectAll", CraneRequestLocators);
				Wait(2000);

				MoveToElement("SubmitButton", CraneRequestLocators);

				Click("SubmitButton", CraneRequestLocators);

				Wait<WebDriver> Responsible = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				Responsible.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@aria-label='Definable Feature Of Work is required']"));
					}
				});

				String DFOWRequired =	GetText("DFOWRequired", CraneRequestLocators);

				if(IsElementDisplayed("DFOWRequired", CraneRequestLocators)) {

					Click("DFOWRequired", CraneRequestLocators);
					ReportConfig.Givenlogpass("User edit and save a crane request without DFOW in Crane request","Error : " + DFOWRequired);
					Wait(2000);
					Click("CancelButton", CraneRequestLocators);
					ReportConfig.PassedLogInfo("User edit and save a crane request without DFOW in Crane request","Cancel button is clicked");
					Click("Yes", CraneRequestLocators);
					ReportConfig.PassedLogInfo("User edit and save a crane request without DFOW in Crane request","Click on Yes button");

					ReportConfig.PassedLogInfo("User edit and save a crane request without DFOW in Crane request","Crane request updated");

					break;

				}
			}
		}
	}

}
		public static void ViewCraneRequestInfo() throws Throwable {

			PrintError("View CraneRequest Info started");
			ReadFrom.DynamicExcel(ReadFrom.ViewCraneRequest);

			Wait(3000);
			for(int ViewCraneRequest =1; ViewCraneRequest<=ReadFrom.rowcount; ViewCraneRequest++)	{
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//div/table/tbody/tr/td[2]/span/u)"));
					}
				});

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(ViewCraneRequest, 0, ReadFrom.ViewCraneRequest);

					if(IsEqual(DeliveryName, EditIt)) {

						JsClick(Delivery);

						ReportConfig.PassedLogInfo("User view the Crane request information",DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");

						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Crane Request Status']"));
							}
						});

						ReportConfig.PassedLogInfo("User view the Crane request information",DeliveryName + " : info viewed");
						Print(DeliveryName + " : info viewed");

						if(IsElementDisplayed("ViewDetails", CraneRequestLocators)) {
							Waitfortheelement("ClosePopup", CraneRequestLocators);

							JsClick("ClosePopup", CraneRequestLocators);

							ReportConfig.PassedLogInfo("User view the Crane request information","Click on Close popup button");
							Print("Click on Close popup button");
							Wait(2000);
						}
					}
				}
			}
		}


		public static void EditCraneRequest() throws Throwable {
			PrintError("Edit CraneRequest started");
			ReadFrom.DynamicExcel(ReadFrom.EditCraneRequest);

			for(int EditCraneRequest =1; EditCraneRequest<=ReadFrom.rowcount; EditCraneRequest++)	{


				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(EditCraneRequest, 0, ReadFrom.EditCraneRequest);


					if(IsEqual(DeliveryName, EditIt)) {

						WebElement EditButton =	FindElement("EditCraneRequest", CraneRequestLocators, DeliveryLists);

						JsClick(EditButton);

						ReportConfig.PassedLogInfo("User edit a crane request from the list","Edit button is clicked");
						Print("Edit button is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
							}
						});

						if(IsElementDisplayed("Description", CraneRequestLocators)) {
							Print("Delivery popup is opened");
							ReportConfig.PassedLogInfo("User edit a crane request from the list","Delivery popup is opened");
						}

						Clear("Description", CraneRequestLocators);
						TypeDataInTheField("Description", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 1, ReadFrom.EditCraneRequest));
						Print("Entered Description : " + ReadFrom.Excel(EditCraneRequest, 1, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered Description : " + ReadFrom.Excel(EditCraneRequest, 1, ReadFrom.EditCraneRequest));

						SelectFromVisibleText("EquipmentDropdown", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 2, ReadFrom.EditCraneRequest));
						Print("Selected Equipment dropdown  : " + ReadFrom.Excel(EditCraneRequest, 2, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Selected Equipment dropdown  : " + ReadFrom.Excel(EditCraneRequest, 2, ReadFrom.EditCraneRequest));

						Wait(2000);

						Clear("PickingFrom", CraneRequestLocators);
						TypeDataInTheField("PickingFrom", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 13, ReadFrom.EditCraneRequest));
						Print("Entered Picking from : " + ReadFrom.Excel(EditCraneRequest, 13, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered Picking from : " + ReadFrom.Excel(EditCraneRequest, 13, ReadFrom.EditCraneRequest));

						Wait(2000);
						Clear("PickingTo", CraneRequestLocators);
						TypeDataInTheField("PickingTo", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 14, ReadFrom.EditCraneRequest));
						Print("Entered Picking to : " + ReadFrom.Excel(EditCraneRequest, 14, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered Picking to : " + ReadFrom.Excel(EditCraneRequest, 14, ReadFrom.EditCraneRequest));


						Wait(2000);
						MoveToElement("AdditionalText", CraneRequestLocators);
						Clear("AdditionalText", CraneRequestLocators);
						TypeDataInTheField("AdditionalText", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 3, ReadFrom.EditCraneRequest));
						Print("Entered Additional text : " + ReadFrom.Excel(EditCraneRequest, 3, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered Additional text : " + ReadFrom.Excel(EditCraneRequest, 3, ReadFrom.EditCraneRequest));

						Clear("DeliveryDate", CraneRequestLocators);
						TypeDataInTheField("DeliveryDate", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 4, ReadFrom.EditCraneRequest));
						Print("Entered Start date : " + ReadFrom.Excel(EditCraneRequest, 4, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered Start date : " + ReadFrom.Excel(EditCraneRequest, 4, ReadFrom.EditCraneRequest));

						Wait(3000);

						///////////////////////

						JsClick("DfowEdit", CraneRequestLocators);

						ReportConfig.PassedLogInfo("User edit a crane request from the list","Click on Dfow dropdown");

						Click("SelectAll", CraneRequestLocators);
						Wait(2000);
						Click("SelectAll", CraneRequestLocators);
						Wait(2000);


						String DfowInExcel = ReadFrom.Excel(EditCraneRequest, 5, ReadFrom.EditCraneRequest);


						int rowcountofthelist = 	SizeOfTheList("DfowListEdit", CraneRequestLocators);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowListEdits", CraneRequestLocators, DropdownValues);
							String DfowInDropdown = 	GetTextFromTheElement(Dfow);

							if(IsEqual(DfowInDropdown, DfowInExcel)){
								Click(Dfow);

								ReportConfig.PassedLogInfo("User edit a crane request from the list","Selected DFOW : " + DfowInDropdown );
								Print("Selected DFOW : " + DfowInDropdown );
								break;
							}
							else {
								PrintError("Not matched");

							}
						}	

						/////////////////////////////////////
						JsClick("CompanyEdit", CraneRequestLocators);

						ReportConfig.PassedLogInfo("User edit a crane request from the list","Click on Company dropdown");
						Print("Click on Company dropdown");

						Click("UnselectAll", CraneRequestLocators);
						Wait(2000);
						Click("UnselectAll", CraneRequestLocators);
						Wait(2000);


						String CompanyInExcel = ReadFrom.Excel(EditCraneRequest, 6, ReadFrom.EditCraneRequest);


						int countofthelist = 	SizeOfTheList("CompanyListEdit", CraneRequestLocators);

						for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	
							WebElement Company = 	FindElement("CompanyListEdits", CraneRequestLocators, DropdownValues);
							String CompanyInDropdown = 	GetTextFromTheElement(Company);

							if(IsEqual(CompanyInDropdown, CompanyInExcel)){
								Click(Company);

								ReportConfig.PassedLogInfo("User edit a crane request from the list","Selected Company  : " + CompanyInDropdown );
								Print("Selected Company  : " + CompanyInDropdown );
								break;
							}
							else {
								PrintError("Not matched");

							}
						}	

						Wait(2000);
						Clear("FromHrs", CraneRequestLocators);
						TypeDataInTheField("FromHrs", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 7, ReadFrom.EditCraneRequest));
						Print("Entered From hrs : " + ReadFrom.Excel(EditCraneRequest, 7, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered From hrs : " + ReadFrom.Excel(EditCraneRequest, 7, ReadFrom.EditCraneRequest));

						Wait(2000);
						Clear("FromMin", CraneRequestLocators);
						TypeDataInTheField("FromMin", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 8, ReadFrom.EditCraneRequest));
						Print("Entered From min : " + ReadFrom.Excel(EditCraneRequest, 8, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered From min : " + ReadFrom.Excel(EditCraneRequest, 8, ReadFrom.EditCraneRequest));

						Wait(2000);
						String ExcelMeridian = ReadFrom.Excel(EditCraneRequest, 9, ReadFrom.EditCraneRequest);

						String Meridian = GetText("FromMeridian", CraneRequestLocators);

						if(IsEqual(Meridian, ExcelMeridian)) {


						}
						else {
							Click("FromMeridian", CraneRequestLocators);
						}

						Wait(2000);
						Clear("ToHrs", CraneRequestLocators);
						TypeDataInTheField("ToHrs", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 10, ReadFrom.EditCraneRequest));
						Print("Entered to hrs : " + ReadFrom.Excel(EditCraneRequest, 10, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered to hrs : " + ReadFrom.Excel(EditCraneRequest, 10, ReadFrom.EditCraneRequest));

						Wait(2000);
						Clear("ToMin", CraneRequestLocators);
						TypeDataInTheField("ToMin", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 11, ReadFrom.EditCraneRequest));
						Print("Entered to min : " + ReadFrom.Excel(EditCraneRequest, 11, ReadFrom.EditCraneRequest));
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Entered to min : " + ReadFrom.Excel(EditCraneRequest, 11, ReadFrom.EditCraneRequest));

						Wait(2000);
						String ExcelMeridian1 = ReadFrom.Excel(EditCraneRequest, 12, ReadFrom.EditCraneRequest);
						String Meridian1 = GetText("ToMeridian", CraneRequestLocators);
						if(IsEqual(Meridian1, ExcelMeridian1)) {


						}
						else {
							Click("ToMeridian", CraneRequestLocators);

						}

						MoveToElement("SubmitButton", CraneRequestLocators);

						Click("SubmitButton", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Click on Submit button");
						Print("Click on Submit button");

						Print("Crane request updated");
						ReportConfig.PassedLogInfo("User edit a crane request from the list","Crane request updated");

						//					Wait<WebDriver> CraneRequestUpdated = new FluentWait<WebDriver>(driver)
						//							.withTimeout(Duration.ofSeconds(120))
						//							.pollingEvery(Duration.ofSeconds(5))
						//							.ignoring(NoSuchElementException.class);
						//
						//
						//					CraneRequestUpdated.until(new Function<WebDriver, WebElement>() {
						//						public WebElement apply(WebDriver driver) {
						//							return driver.findElement(By.xpath("//div[@aria-label='Crane Request Updated Successfully.']"));
						//						}
						//					});
						//
						//					
						//					if(IsElementDisplayed("CraneRequestUpdated", CraneRequestLocators)) {
						//						Click("CraneRequestUpdated", CraneRequestLocators);
						//						Print("Crane request updated");
						//						ReportConfig.PassedLogInfo("User edit a crane request from the list","Crane request updated");
						//
						//					}
						//					
						//					else if(IsElementDisplayed("DeliveryRequestUpdated", CraneRequestLocators)) {
						//						Click("DeliveryRequestUpdated", CraneRequestLocators);
						//						Print("Delivery request updated");
						//						ReportConfig.PassedLogInfo("User edit a Delivery request from the list","Delivery request updated");
						//					}
						//					else {
						//						PrintError("Request update failed");
						//						ReportConfig.FailedLogInfo("User edit a crane request from the list","Request update failed");
						//					}	

						Wait(5000);
						break;

					}
				}
			}
		}

		public static void FilterCraneRequest() throws Throwable {


			ReadFrom.DynamicExcel(ReadFrom.FilterCraneRequest);
			Print("Filter Crane Request started");

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{

				Click("FilterIcon", CraneRequestLocators);
				ReportConfig.PassedLogInfo("User filter crane request from the list","Click on Filter icon button");
				Print("Click on Filter icon button");
				Wait(6000);


				SelectFromVisibleText("EquipmentInFilter", CraneRequestLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterCraneRequest));
				ReportConfig.PassedLogInfo("User filter crane request from the list","Selected Equipment  : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterCraneRequest));
				Print("Selected Equipment  : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterCraneRequest));

				Click("FilterApply", CraneRequestLocators);
				ReportConfig.PassedLogInfo("User filter crane request from the list","Click on Filter apply button");
				Print("Click on Filter apply button");
				Wait(3000);

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);


				for(int RequestLists =1; RequestLists<=rowcount; RequestLists++)	{

					WebElement Equipment =	FindElement("Equip" , CraneRequestLocators, RequestLists );
					String EquipmentName =	GetTextFromTheElement(Equipment);

					Wait(2000);

					WebElement Request =	FindElement("CraneRequestList" , CraneRequestLocators, RequestLists );
					String RequestName =	GetTextFromTheElement(Request);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterCraneRequest);


					if(	IsEqual(EquipmentName, FilteredValue)) {

						Wait(2000);
						Print("Filtered Equipment is : " + FilteredValue + " : Request name is : " + RequestName);
						ReportConfig.PassedLogInfo("User filter crane request from the list","Filtered Equipment is : " + FilteredValue + " : Request name is : " + RequestName);
						Wait(3000);
						//ScreenShots(null);

					}
					else {
						PrintError("Filtered Equipment is : " + FilteredValue + " : Request name is : " + RequestName);
						ReportConfig.FailedLogInfo("User filter crane request from the list","Filtered Equipment is : " + FilteredValue + " : Request name is : " + RequestName);
					}


				}
				JsClick("FilterIcon", CraneRequestLocators);
				ReportConfig.PassedLogInfo("User filter crane request from the list","Click on Filter icon button");
				Print("Click on Filter icon button");

				Wait(3000);
				JsClick("FilterReset" , CraneRequestLocators);
				ReportConfig.PassedLogInfo("User filter crane request from the list","Click on Filter reset button");
				Print("Click on Filter reset button");

				Wait(3000);
				//	Clear("SearchDfow", DFOWLocators);

			}
		}

		public static void SearchCraneRequest() throws Throwable {
			Print("Search Crane Request started");

			ReadFrom.DynamicExcel(ReadFrom.SearchCraneRequest);

			Click("SearchIcon", CraneRequestLocators);

			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

				Wait(2000);

				TypeDataInTheField("Search", CraneRequestLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest));
				ReportConfig.PassedLogInfo("User search and view the crane request from the list",ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest) + " is entered in the search bar");
				Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest) + " is entered in the search bar");

				Wait(5000);


				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int Searchedrequest =1; Searchedrequest<=rowcount; Searchedrequest++)	{

					WebElement Request =	FindElement("CraneRequestList", CraneRequestLocators, Searchedrequest);
					String Requestname =	GetTextFromTheElement(Request);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest);

					if(IsEqual(Requestname, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + Requestname);
						ReportConfig.PassedLogInfo("User search and view the crane request from the list","Displayed value is : " + Requestname);

						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + Requestname);
//						ReportConfig.FailedLogInfo("User search and view the crane request from the list","Displayed value is : " + Requestname);
//					
//						String IssueSummary = "Searched value is : " +  ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest) + "but displayed value is : " + Requestname ;
//						String Storydescription = "Search Crane request" ;
//						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
						}


				}
				Wait(3000);
				Clear("Search", CraneRequestLocators);
				Wait(3000);
				Click("CloseSearch", CraneRequestLocators);
				ReportConfig.PassedLogInfo("User search and view the crane request from the list","Click on Clear search button");
				Print("Click on Clear search button");

			}
		}

		public static void CranePushToVoid() throws Throwable {
			PrintError("Push Crane Request started");
			ReadFrom.DynamicExcel(ReadFrom.VoidCraneRequest);

			for(int VoidCraneRequest =1; VoidCraneRequest<=ReadFrom.rowcount; VoidCraneRequest++)	{

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(VoidCraneRequest, 0, ReadFrom.VoidCraneRequest);


					if(IsEqual(DeliveryName, EditIt)) {

						JsClick(Delivery);
						ReportConfig.PassedLogInfo("User push a crane request to void",DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");

						Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(10))
								.ignoring(NoSuchElementException.class);


						CompanyInFilter.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//button[normalize-space()='Void']"));
							}
						});

						JsClick("VoidButton", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User push a crane request to void","Void button is clicked");
						Print("Void button is clicked");

						Wait(2000);
						Click("VoidYes", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User push a crane request to void","Click on Yes button");
						Print("Click on Yes button");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Crane Request Marked as Void Successfully.']"));
							}
						});

						if(IsElementDisplayed("CraneVoidSuccessfull", CraneRequestLocators)) {
							Click("CraneVoidSuccessfull", CraneRequestLocators);
							Print(DeliveryName + " : is pushed to void");
							ReportConfig.PassedLogInfo("User push a crane request to void",DeliveryName + " : is pushed to void");

							Wait(3000);
						}
						else {
							PrintError("Void push is failed");
							ReportConfig.FailedLogInfo("User push a crane request to void","Void push is failed");
							
							String IssueSummary = "Crane Request Marked as Void Successfully is not displayed" ;
							String Storydescription = "Crane Push To Void" ;
							pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
						}	

						Wait(5000);
						break;
					}

				}
			}
		}

		public static void CompleteRequest() throws Throwable {

			PrintError("Complete Crane Request started");
			ReadFrom.DynamicExcel(ReadFrom.CompleteCrane);

			for(int CompleteCrane =1; CompleteCrane<=ReadFrom.rowcount; CompleteCrane++)	{

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);
					String DeliveryName = 	GetTextFromTheElement(Delivery);
					String EditIt =	ReadFrom.Excel(CompleteCrane, 0, ReadFrom.CompleteCrane);
					if(IsEqual(DeliveryName, EditIt)) {
						JsClick(Delivery);
						ReportConfig.PassedLogInfo("User complete the request",DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");

						Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(10))
								.ignoring(NoSuchElementException.class);
						CompanyInFilter.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//label[normalize-space()='Completed']"));
							}
						});

						JsClick("CompletedButton", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User complete the request","Completed button is clicked");
						Print("Completed button is clicked");
						Wait(2000);

						JsClick("Save", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User complete the request","Click on Save button");
						Print("Click on Save button");

						Wait(2000);
						Click("CompleteYes", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User complete the request","Click on Yes button");
						Print("Click on Yes button");
						//	break;
						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Completed Successfully.']"));
							}
						});
						//	if(IsElementDisplayed("CompletedSuccessfully", CraneRequestLocators)) {
						//Click("CompletedSuccessfully", CraneRequestLocators);
						Print(DeliveryName + " : is marked completed");
						ReportConfig.PassedLogInfo("User complete the request",DeliveryName + " : is marked completed");

						Wait(3000);
						Click("ClosePopup", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User complete the request","Close button is clicked");
						Print("Close button is clicked");
						//	}
						//else {
						//PrintError("Complete is failed");
						//ReportConfig.FailedLogInfo("User complete the request","Complete is failed");
						//}
						break;
					}
				}
			}
		}



		public static void CraneApproveReject() throws Throwable {

			PrintError("Approve Or Reject Crane Request started");
			ReadFrom.DynamicExcel(ReadFrom.CraneApproveReject);

			for(int CraneApproveReject =1; CraneApproveReject<=ReadFrom.rowcount; CraneApproveReject++)	{

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int Request =1; Request<=rowcount; Request++)	{
					WebElement CraneReq =	FindElement("CraneRequestList", CraneRequestLocators, Request);
					String CraneReqName = 	GetTextFromTheElement(CraneReq);
					String FromExcel = ReadFrom.Excel(CraneApproveReject, 0, ReadFrom.CraneApproveReject);
					if(IsEqual(CraneReqName, FromExcel)) {

						WebElement EditButton =	FindElement("EditCraneRequest", CraneRequestLocators, Request);

						JsClick(EditButton);

						ReportConfig.PassedLogInfo("User approve or reject the crane request","Edit button is clicked");
						Print("Edit button is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
							}
						});

						if(IsElementDisplayed("Description", CraneRequestLocators)) {
							Print("Delivery popup is opened");
							ReportConfig.PassedLogInfo("User approve or reject the crane request","Delivery popup is opened");
						}

						Clear("Description", CraneRequestLocators);
						TypeDataInTheField("Description", CraneRequestLocators, ReadFrom.Excel(CraneApproveReject, 0, ReadFrom.CraneApproveReject));
						Print("Entered Description : " + ReadFrom.Excel(CraneApproveReject, 0, ReadFrom.CraneApproveReject));
						ReportConfig.PassedLogInfo("User approve or reject the crane request","Entered Description : " + ReadFrom.Excel(CraneApproveReject, 0, ReadFrom.CraneApproveReject));


						MoveToElement("SubmitButton", CraneRequestLocators);

						Click("SubmitButton", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User approve or reject the crane request","Click on Submit button");
						Print("Click on Submit button");

						//					Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
						//							.withTimeout(Duration.ofSeconds(120))
						//							.pollingEvery(Duration.ofSeconds(5))
						//							.ignoring(NoSuchElementException.class);
						//
						//
						//					fluentWait1111.until(new Function<WebDriver, WebElement>() {
						//						public WebElement apply(WebDriver driver) {
						//							return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Updated Successfully.']"));
						//						}
						//					});


						Wait(3000);
						List<WebElement> Text =		getElements("CraneRequestLists", CraneRequestLocators);
						for (WebElement webElement : Text) {
							String Name = GetTextFromTheElement(webElement);
							String EditName =	ReadFrom.Excel(CraneApproveReject, 0, ReadFrom.CraneApproveReject);

							Wait(2000);

							if(IsEqual(Name, EditName)) {		
								JsClick(webElement);
								ReportConfig.PassedLogInfo("User approve or reject the crane request",Name + " : is clicked");
								Print(Name + " : is clicked");
							}

						}
						Wait(5000);
						SelectFromVisibleText("SelectStatus", CraneRequestLocators, ReadFrom.Excel(CraneApproveReject, 1, ReadFrom.CraneApproveReject));
						Print("Status is selected as : " + ReadFrom.Excel(CraneApproveReject, 1, ReadFrom.CraneApproveReject));
						ReportConfig.PassedLogInfo("User approve or reject the crane request","Status is selected as : " + ReadFrom.Excel(CraneApproveReject, 1, ReadFrom.CraneApproveReject));

						Wait(2000);
						JsClick("SaveStatus", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User approve or reject the crane request","Click on Save button");
						Print("Click on Save button");


						String Status = ReadFrom.Excel(CraneApproveReject, 1, ReadFrom.CraneApproveReject);

						if (IsEqual(Status, "Approved")) {

							ReportConfig.PassedLogInfo("User approve or reject the crane request","Delivery request is approved");
							Print("Delivery request is approved");
							Wait(3000);
							JsClick("ClosePopup", CraneRequestLocators);
							ReportConfig.PassedLogInfo("User approve or reject the crane request","Click on Close popup button");
							Print("Click on Close popup button");

						}
						else if(IsEqual(Status, "Declined")) {

							ReportConfig.PassedLogInfo("User approve or reject the crane request","Delivery request is declined");
							Print("Delivery request is declined");
							Wait(3000);
							JsClick("ClosePopup", CraneRequestLocators);
							ReportConfig.PassedLogInfo("User approve or reject the crane request","Click on Close popup button");
							Print("Click on Close popup button");
							break;
						}

					}
				}
			}
		}

		public static void Comment() throws Throwable {


			PrintError("Add comment Crane Request started");
			ReadFrom.DynamicExcel(ReadFrom.CraneComment);


			for(int Comments =1; Comments<=ReadFrom.rowcount; Comments++)	{


				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String AddComment =	ReadFrom.Excel(Comments, 0, ReadFrom.CraneComment);

					if(IsEqual(DeliveryName, AddComment)) {

						JsClick(Delivery);

						ReportConfig.PassedLogInfo("User add a comment to a crane request",DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']"));
							}
						});

						Wait(3000);

						//	Stale("ViewDetails", CraneRequestLocators);
						Waitfortheelement("ViewDetails", CraneRequestLocators);
						//if(IsElementDisplayed("ViewDetails", CraneRequestLocators)) {

						Waitfortheelement("Comments", CraneRequestLocators);
						JsClick("Comments", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User add a comment to a crane request","Comment button is clicked");
						Print("Comment button is clicked");

						TypeDataInTheField("AddComment", CraneRequestLocators, ReadFrom.Excel(Comments, 1, ReadFrom.CraneComment));
						Print("Comment is entered as : " + ReadFrom.Excel(Comments, 1, ReadFrom.CraneComment));
						ReportConfig.PassedLogInfo("User add a comment to a crane request","Entered Description : " + ReadFrom.Excel(Comments, 1, ReadFrom.CraneComment));

						Wait(2000);
						MoveToElement("SubmitButton", CraneRequestLocators);
						JsClick("SubmitButton", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User add a comment to a crane request","Click on Submit button");
						Print("Click on Submit button");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Crane Request Comment added successfully.']"));
							}
						});

						if(IsElementDisplayed("CommentaddedSuccessfully", CraneRequestLocators)) {
							Waitfortheelement("CommentaddedSuccessfully", CraneRequestLocators);
							JsClick("CommentaddedSuccessfully", CraneRequestLocators);
							Print("Comment added Successfully");
							ReportConfig.PassedLogInfo("User add a comment to a crane request","Comment added Successfully");

							JsClick("ClosePopup", CraneRequestLocators);
							ReportConfig.PassedLogInfo("User add a comment to a crane request","Click on Close popup button");
							Print("Click on Close popup button");
						}
						//	}
					}
				}
			}
		}

		public static void Attachment() throws Throwable {


			PrintError("Attachment in Crane Request started");
			ReadFrom.DynamicExcel(ReadFrom.AttachmentCraneRequest);
			for(int Attachment =1; Attachment<=ReadFrom.rowcount; Attachment++)	{

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String Attach =	ReadFrom.Excel(Attachment, 0, ReadFrom.AttachmentCraneRequest);

					if(IsEqual(DeliveryName, Attach)) {

						JsClick(Delivery);

						ReportConfig.PassedLogInfo("User add attachment to the crane request",DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//span[normalize-space()='Attachments']"));
							}
						});
						Wait(2000);
						Waitfortheelement("Attachments", CraneRequestLocators);
						JsClick("Attachments", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User add attachment to the crane request","Click on Attachments button");
						Print("Click on Attachments button");

						Wait<WebDriver> s = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						s.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//label[normalize-space()='Click here to browse']"));
							}
						});

						if(IsElementDisplayed("BrowseFiles", CraneRequestLocators)) {

							Wait(2000);
							String upload = ReadFrom.SampleAttachmentPNG;
							String filePath = System.getProperty("user.dir")+ upload;

							WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
							Wait(3000);
							file.sendKeys(filePath);

							Wait<WebDriver> Done = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(120))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);


							Done.until(new Function<WebDriver, WebElement>() {
								public WebElement apply(WebDriver driver) {
									return driver.findElement(By.xpath("//button[normalize-space()='Done']"));
								}
							});

							JsClick("DoneButton", CraneRequestLocators);

							Wait<WebDriver> Uploaded = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(120))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);


							Uploaded.until(new Function<WebDriver, WebElement>() {
								public WebElement apply(WebDriver driver) {
									return driver.findElement(By.xpath("//div[@aria-label='Uploaded Successfully.']"));
								}
							});


							if(IsElementDisplayed("UploadedSuccessfully", CraneRequestLocators)) {
								Print("Attachment is added");
								ReportConfig.PassedLogInfo("User add attachment to the crane request", "Attachment added successfully to the " + DeliveryName);

								JsClick("ClosePopup", CraneRequestLocators);
								ReportConfig.PassedLogInfo("User add attachment to the crane request","Click on Close popup button");
								Print("Click on Close popup button");

							}
						}
					}
				}
			}
		}
		

		public static void NegativeAttachment() throws Throwable {

		PrintError("Negative Attachment Crane Request started");
		ReadFrom.DynamicExcel(ReadFrom.NegativeCraneCalendar);
		for(int Attachment =1; Attachment<=ReadFrom.rowcount; Attachment++)	{

			int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

			for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


				WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

				String DeliveryName = 	GetTextFromTheElement(Delivery);

				String Attach =	ReadFrom.Excel(Attachment, 0, ReadFrom.AddCraneRequest);

				if(IsEqual(DeliveryName, Attach)) {

					JsClick(Delivery);

					ReportConfig.PassedLogInfo("User upload a invalid file in attachment in Crane request",DeliveryName + " : is clicked");
					Print(DeliveryName + " : is clicked");


					Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					fluentWait1.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//span[normalize-space()='Attachments']"));
						}
					});
					Wait(2000);
					Waitfortheelement("Attachments", CraneRequestLocators);
					JsClick("Attachments", CraneRequestLocators);
					ReportConfig.PassedLogInfo("User upload a invalid file in attachment in Crane request","Click on Attachments button");
					Print("Click on Attachments button");

					Wait<WebDriver> s = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					s.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//label[normalize-space()='Click here to browse']"));
						}
					});

					if(IsElementDisplayed("BrowseFiles", CraneRequestLocators)) {

						Wait(2000);
						String upload = ReadFrom.InvalidFile;
						String filePath = System.getProperty("user.dir")+ upload;

						WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
						Wait(3000);
						file.sendKeys(filePath);

						Wait<WebDriver> Uploaded = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						Uploaded.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Please select a valid file. Supported file format (.jpg,.jpeg,.png,.pdf,.doc)']"));
							}
						});
						String InvalidFile =	GetText("InvalidFile", CraneRequestLocators);

						if(IsElementDisplayed("InvalidFile", CraneRequestLocators)) {
							ReportConfig.Givenlogpass("User upload a invalid file in attachment in Crane request", "Error : " + InvalidFile);

							JsClick("ClosePopup", CraneRequestLocators);
							ReportConfig.PassedLogInfo("User upload a invalid file in attachment in Crane request","Click on Close popup button");
							Print("Click on Close popup button");

						}
					}
				}
			}
		}
	
}

		public static void ViewHistoryInfo() throws Throwable {
			PrintError("View history info Crane Request started");
			ReadFrom.DynamicExcel(ReadFrom.HistoryCraneRequest);
			for(int ViewRequest =1; ViewRequest<=ReadFrom.rowcount; ViewRequest++)	{

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(ViewRequest, 0, ReadFrom.HistoryCraneRequest);

					if(IsEqual(DeliveryName, EditIt)) {

						JsClick(Delivery);

						ReportConfig.PassedLogInfo("User view the history of the crane request",DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//span[normalize-space()='History']"));
							}
						});
						Wait(2000);
						Waitfortheelement("History", CraneRequestLocators);
						JsClick("History", CraneRequestLocators);
						ReportConfig.PassedLogInfo("User view the history of the crane request","History button is clicked");
						Print("History button is clicked");

						Wait<WebDriver> s = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						s.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div/ul/li[1]/p[3]"));
							}
						});

						if(IsElementDisplayed("HistoryPage", CraneRequestLocators)) {

							Print(DeliveryName + " : History page is viewed");
							List<WebElement>	ElementNames= 	getElements("HistoryPage", CraneRequestLocators);
							int History =	GetSize(ElementNames);
							Print("Total no of histories available : " + History);
							ReportConfig.PassedLogInfo("User view the history of the crane request",DeliveryName + " : History page is viewed");

							JsClick("ClosePopup", CraneRequestLocators);
							ReportConfig.PassedLogInfo("User view the history of the crane request","Click on Close popup button");
							Print("Click on Close popup button");
						}
					}
				}
			}
		}

	}


