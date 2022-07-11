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

public class F_03_DFOW extends Baseclass  {


	public static void AddDFOW() throws Throwable {

		Wait(3000);
		PrintError("Validate with add option");

		ReadFrom.DynamicExcel(ReadFrom.AddDFOW);
			for(int Rows =1; Rows<=ReadFrom.rowcount; Rows++)		{	
			
				WebElement SpecSec = 	FindElement("SpecificationSectionRow", DFOWLocators, Rows);

				Clear(SpecSec);
				EnterValueInTheElement(SpecSec, ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));

				Print("Entered Specification  : " + ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));
				ReportConfig.PassedLogInfo("User adds DFOW list","Entered Specification : " + ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));

				Wait(3000);

				WebElement dfow =	FindElement("DfowRow", DFOWLocators, Rows);

				Clear(dfow);
				EnterValueInTheElement(dfow, ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));

				Print("Entered Dfow  : " + ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));
				ReportConfig.PassedLogInfo("User adds DFOW list", "Entered Dfow : " + ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));

				Click("AddRow", DFOWLocators);
				Print("Click on Add row button");
				ReportConfig.PassedLogInfo("User adds DFOW list" ,"Click on Add row button");

			}
	}

	public static void SearchDFOW() throws Throwable {

		PrintError("Search Dfow Started");

		ReadFrom.DynamicExcel(ReadFrom.SearchDFOW);

			for(int SearchDfow =1; SearchDfow<=ReadFrom.rowcount; SearchDfow++)	{

				TypeDataInTheField("SearchDfow", DFOWLocators, ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW));
				ReportConfig.PassedLogInfo("User search the dfow", "Entered Dfow  : " + ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW)  );
				ClickEnter();
				Wait(6000);


				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);

				for(int i =1; i<=rowcount; i++)	{

					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, i);

					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW);

					if(IsEqual(DFOWname, SearchedValue)) {

						Wait(2000);
						Print("Searched Dfow: " + DFOWname);
						ReportConfig.PassedLogInfo("User search the dfow", "Searched Dfow: " + DFOWname);
						Wait(3000);

					}
					else {
						PrintError("Searched Value: " + DFOWname);
//						ReportConfig.FailedLogInfo("Searched Value: " , DFOWname);
//						String IssueSummary = "Searched value is : " + ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW) + "but Searched Value: " + DFOWname;
//						String Storydescription = "Search DFOW" ;
//						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
					}


				}
				Clear("SearchDfow", DFOWLocators);
				Wait(3000);
				Click("ClearSearch", DFOWLocators);
				ReportConfig.PassedLogInfo("User search the dfow","Clear search button is clicked");
				Wait(3000);
				//	Clear("SearchDfow", DFOWLocators);

			}
	}


	public static void EditDFOW() throws Throwable {
		PrintError("Validate with Edit DFOW flow");

		ReadFrom.DynamicExcel(ReadFrom.EditDFOW);

			for(int EditDfow =1; EditDfow<=ReadFrom.rowcount; EditDfow++)	{


				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);

				for(int DfowList =1; DfowList<=rowcount; DfowList++)		{

					WebElement SpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, DfowList);

					String Specificaiton = 	GetAttributeFromTheElement(SpecSec);


					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, DfowList);
					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String ToEdit = Specificaiton + DFOWname;


					String EditIt =	ReadFrom.Excel(EditDfow, 0, ReadFrom.EditDFOW)+ReadFrom.Excel(EditDfow, 1, ReadFrom.EditDFOW);


					if(IsEqual(ToEdit, EditIt)) {

						WebElement EditSpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, DfowList);
						Clear(EditSpecSec);
						EnterValueInTheElement(EditSpecSec, ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));

						Print("Edited Value is : " + ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));
						ReportConfig.PassedLogInfo("User edits a DFOW from the list","Edited Value is : " + ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));

						WebElement EditDfowlist =	FindElement("DfowRow", DFOWLocators, DfowList);
						Clear(EditDfowlist);
						EnterValueInTheElement(EditDfowlist, ReadFrom.Excel(EditDfow,3, ReadFrom.EditDFOW));


						Print("Edited Value is : " + ReadFrom.Excel(EditDfow, 3, ReadFrom.EditDFOW));
						ReportConfig.PassedLogInfo("User edits a DFOW from the list", "Edited Value is : " + ReadFrom.Excel(EditDfow, 3, ReadFrom.EditDFOW));

						Wait(5000);
						break;

					}

				}
			}
	}


	public static void DeleteDFOW() throws Throwable {
		PrintError("Validate with Delete DFOW");

		ReadFrom.DynamicExcel(ReadFrom.DeleteDFOW);

			for(int DeleteDfow =1; DeleteDfow<=ReadFrom.rowcount; DeleteDfow++)	{

				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);

				for(int List =1; List<=rowcount; List++)	{

					WebElement SpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, List);

					String Specificaiton = 	GetAttributeFromTheElement(SpecSec);

					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, List);
					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String ToDelete = Specificaiton + DFOWname;


					String DeleteIt =	ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW)+ReadFrom.Excel(DeleteDfow, 1, ReadFrom.DeleteDFOW);



					if(IsEqual(ToDelete, DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement("DeleteDfow" ,DFOWLocators, List);
						Click(Delete);

					

						Wait(2000);

						Click("YesDelete", DFOWLocators);
						ReportConfig.PassedLogInfo("User deletes a DFOW from the list","Click on Yes");
						Print("Click on Yes");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);

						fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Listed Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeleteDfowMessage", DFOWLocators)){
							Print("Deleted DFOW  : " + ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW));
							ReportConfig.PassedLogInfo("User deletes a DFOW from the list", "Deleted DFOW  : " + ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW));
							break;
						}
					}
				}
			}
	}




	public static void DfowBulkUpload() throws Throwable {
		PrintError("Bulk upload is in progress");

		Wait(2000);
		String upload = ReadFrom.UploadDfowFile;
		String filePath = System.getProperty("user.dir")+ upload;
		
		WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
		Wait(3000);
		file.sendKeys(filePath);
		}

	
	public static void DfowUploadWrongFile() throws Throwable {
		PrintError("Dfow Uploading Invalid File");

	
		Wait(2000);
		
		String upload = ReadFrom.UploadCompanyLogo;
		String filePath = System.getProperty("user.dir")+ upload;
		
		WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
		
		Wait(3000);
		file.sendKeys(filePath);
		
		Wait(1000);
		String invalidText =	GetText("InvalidFileAlert", DFOWLocators);

		Print("Please enter valid file format: " + invalidText);
		ReportConfig.Givenlogpass("User uploads invalid DFOW file" ,"Invalid file upload alert: " + invalidText);
		
		Wait(4000);
		
		Click("CloseButton", DFOWLocators);
		
		Print("Click on Close button");
		ReportConfig.Givenlogpass("User uploads invalid DFOW file" ,"Click on Close button");
		

	}


	public static void AddSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Updated Successfully.']"));
			}
		});
	}

	public static void DeleteSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Listed Successfully.']"));
			}
		});
	}

	public static void BulkSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Created Successfully.']"));
			}
		});
	}

	public static void BrowseFiles() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//label[normalize-space()='Click here to browse']"));
			}
		});
	}
}
