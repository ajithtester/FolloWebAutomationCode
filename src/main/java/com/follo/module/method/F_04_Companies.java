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

public class F_04_Companies extends Baseclass {




	public static void AddDCompany() throws Throwable {
		PrintError("Add Company Started");
		ReadFrom.DynamicExcel(ReadFrom.AddCompany);


		for(int AddCompany =1; AddCompany<=ReadFrom.rowcount; AddCompany++)		{	
			Wait(2000);
			Click("NewCompany", CompaniesLocators);
			ReportConfig.PassedLogInfo("To add new companies" ,"Click on New company button");
			Print("Click on New company button");

			Wait(5000);
			if(IsElementDisplayed("Dfow", CompaniesLocators)) {

				String upload = ReadFrom.UploadCompanyLogo;
				String imagePath = System.getProperty("user.dir")+ upload;

				WebElement logo = driver.findElement(By.xpath("//label[@for='file-input']//following::input[@id='file-input']"));

				Wait(3000);
				logo.sendKeys(imagePath);

				Wait(2000);
				TypeDataInTheField("CompanyName", CompaniesLocators, ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies", "Entered Company name  : " + ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
				Print("Entered Company name  : " +ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));


				Wait(2000);
				TypeDataInTheField("AddressLine1", CompaniesLocators, ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies", "Entered Address line1 : " + ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));
				Print("Entered Address line1 : " +ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));

				Wait(2000);
				ClickEnter();

				Wait(2000);
				TypeDataInTheField("AddressLine2", CompaniesLocators, ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies", "Entered Address line 2 : " + ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));
				Print("Entered Address line 2 : " +ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("City", CompaniesLocators, ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies", "Entered City : " + ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));
				Print("Entered City : " +ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("State", CompaniesLocators, ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies", "Entered State : " + ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));
				Print("Entered State : " +ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("Zipcode", CompaniesLocators, ReadFrom.Excel(AddCompany, 6, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies", "Entered Zipcode : " + ReadFrom.Excel(AddCompany,6, ReadFrom.AddCompany));
				Print("Entered Zipcode : " +ReadFrom.Excel(AddCompany,6, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("Country", CompaniesLocators, ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies", "Entered Country : " + ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));
				Print("Entered Country : " +ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("Website", CompaniesLocators, ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies","Entered Website : " + ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));
				Print("Entered Website : " +ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));

				Wait(2000);
				TypeDataInTheField("AdditionalNotes", CompaniesLocators, ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));
				ReportConfig.PassedLogInfo("User add new companies", "Entered Additional notes : " + ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));
				Print("Entered Additional notes : " +ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));

				Wait(2000);
				Click("Dfow", CompaniesLocators);
				ReportConfig.PassedLogInfo("User add new companies", "Click on Dfow dropdown");

				//	ReadFrom.DynamicExcel(ReadFrom.AddCompanyDfow);

				//	for(int AddCompanyDfow =1; AddCompanyDfow<=ReadFrom.rowcount; AddCompanyDfow++)		{	
				String DfowInExcel = ReadFrom.Excel(AddCompany, 1,ReadFrom.AddCompany);

				int rowcountofthelist = 	SizeOfTheList("DfowList", CompaniesLocators);

				for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
					WebElement Dfow = 	FindElement("DfowInDropdown", CompaniesLocators, DropdownValues);
					String DfowInDropdown = 	GetTextFromTheElement(Dfow);


					if(IsEqual(DfowInDropdown, DfowInExcel)){
						Click(Dfow);

						ReportConfig.PassedLogInfo("User add new companies","Selected Dfow  : " + DfowInDropdown );
						Print("Selected Dfow  : " + DfowInDropdown );
						break;
					}
					else {
						PrintError("Not matched");
					}
				}


				Wait(2000);

				Click("SubmitButton", CompaniesLocators);
				ReportConfig.PassedLogInfo("To add new companies" , "Click on Submit button");
				Wait(5000);

				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@aria-label='Company Created Successfully.']"));
					}
				});

				if(IsElementDisplayed("CompanyAdded", CompaniesLocators)){
					Print("Company added is : " + ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("User add new companies", "Company added is : " + ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));

				}else {
					PrintError("Company not added");
					ReportConfig.FailedLogInfo("To add new companies" ,"Company not added");
					String IssueSummary = "Company added success popup is not displayed";
					String Storydescription = "Add company" ;
					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				}
			}
		}

	}


	public static void SearchCompany() throws Throwable {
		PrintError("Search company Started");

		ReadFrom.DynamicExcel(ReadFrom.SearchCompany);

		Click("Search", CompaniesLocators);
		for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

			ReportConfig.PassedLogInfo("User search and view the company" , "Click on search button");

			TypeDataInTheField("SearchCompany", CompaniesLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany));
			ReportConfig.PassedLogInfo("User search and view the company" , "Searched Value : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany));
			Print("Searched Value : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany));

			ClickEnter();
			Wait(6000);

			int rowcount = 	SizeOfTheList("CompanyList", CompaniesLocators);

			for(int i =1; i<=rowcount; i++)	{

				WebElement Company =	FindElement("CompanyListed" ,CompaniesLocators, i);
				String CompanyName =	GetTextFromTheElement(Company);

				Wait(2000);

				String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany);


				if(IsEqual(CompanyName, SearchedValue)) {

					Wait(2000);
					Print("Displayed value : " + CompanyName);
					ReportConfig.PassedLogInfo("User search and view the company" , "Displayed value : " + CompanyName);

					Wait(3000);

				}
//				else {
//					PrintError("Displayed value is : " + CompanyName);
//					
////					String IssueSummary = "Searched value is : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany) + "but displayed value is : " + CompanyName ;
////					String Storydescription = "Search company" ;
////					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
//					
//					
//				}


			}
			Wait(3000);
			Clear("SearchDfow", DFOWLocators);
			Wait(3000);
			Click("ClearSearch", CompaniesLocators);
			ReportConfig.PassedLogInfo("User search and view the company" , "Click on Clear search button");
			Print("Click on Clear search button");
			Wait(3000);


		}
		Clear("SearchDfow", DFOWLocators);
	}


	public static void FilterCompany() throws Throwable {
		PrintError("Filter company Started");

		ReadFrom.DynamicExcel(ReadFrom.FilterCompany);


		for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{
			Click("FilterIcon", CompaniesLocators);
			ReportConfig.PassedLogInfo("Filter Company","Click on Filter icon");
			Print("Click on Filter icon");

			TypeDataInTheField("FilterCompanyName", CompaniesLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany));
			ReportConfig.PassedLogInfo("Filter Company", "Filter value : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany));
			Print( "Filtered value : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany));


			Wait(2000);
			Click("FilterApply", CompaniesLocators);
			ReportConfig.PassedLogInfo("Filter Company","Click on Filter apply button");
			Print("Click on Filter apply button");
			Wait(6000);

			int rowcount = 	SizeOfTheList("CompanyList", CompaniesLocators);

			for(int i =1; i<=rowcount; i++)	{

				WebElement Company =	FindElement("CompanyListed" ,CompaniesLocators, i);
				String CompanyName =	GetTextFromTheElement(Company);

				Wait(2000);

				String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany);


				if(	IsEqual(CompanyName, FilteredValue)) {

					Wait(2000);
					Print("Displayed value: " + CompanyName);
					ReportConfig.PassedLogInfo("Filter Company", "Displayed value : " + CompanyName);

					Wait(3000);

				}
//				else {
//					PrintError("Displayed value is : " + CompanyName);
//				}


			}
			Click("FilterIcon", CompaniesLocators);
			ReportConfig.PassedLogInfo("Filter Company","Click on Filter icon");
			Print("Click on Filter icon");

			Click("FilterReset", CompaniesLocators);
			ReportConfig.PassedLogInfo("Filter Company","Click on Filter Reset button");
			Print("Click on Filter Reset button");
			Wait(3000);
			//	Clear("SearchDfow", DFOWLocators);



		}
	}

	public static void DeleteCompany() throws Throwable {

		PrintError("Delete company Started");

		ReadFrom.DynamicExcel(ReadFrom.DeleteCompany);

		for(int DeleteCompany =1; DeleteCompany<=ReadFrom.rowcount; DeleteCompany++)	{


			int rowcount = SizeOfTheList("CompanyList", CompaniesLocators);

			for(int DeleteButton =2; DeleteButton<=rowcount; DeleteButton++)	{

				WebElement CompanyNames =	FindElement("CompanyListed" ,CompaniesLocators, DeleteButton);

				String CompanyNamesList = 	GetTextFromTheElement(CompanyNames);

				String DeleteIt =	ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany);



				if(IsEqual(CompanyNamesList, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteCompany" , CompaniesLocators, DeleteButton-1);
					Click(Delete);


					Wait(2000);

					Click("YesDelete", CompaniesLocators);
					ReportConfig.PassedLogInfo("Delete Company" ,"Click on delete button");
					Print("Click on delete button");

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);

					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Company Deleted Successfully.']"));
						}
					});

					if(IsElementDisplayed("CompanyDeleted", CompaniesLocators)){
						Print("Deleted company  : " + ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany));
						ReportConfig.PassedLogInfo("Deleted company  : " , ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany));
						break;
					}else {
						PrintError("Company not deleted");
						ReportConfig.FailedLogInfo("Delete Company" ,"Company not deleted");
						
						String IssueSummary = "Company Deleted Successfull popup is not displayed";
						String Storydescription = "Delete company" ;
						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

						Wait(3000);
					}
				}

			}
		}
	}


	public static void EditCompany() throws Throwable {

		PrintError("Edit company Started");
		ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);

		for(int EditCompanyDetails =1; EditCompanyDetails<=ReadFrom.rowcount; EditCompanyDetails++)	{


			int rowcount = SizeOfTheList("CompanyList", CompaniesLocators);

			for(int CompanyList =1; CompanyList<=rowcount; CompanyList++)	{

				WebElement CompanyNames =	FindElement("CompanyListed" ,CompaniesLocators, CompanyList);

				String CompanyNamesList = 	GetTextFromTheElement(CompanyNames);


				String EditIt =	ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails);


				if(IsEqual(CompanyNamesList, EditIt)) {

					Wait(2000);

					WebElement EditButton =	FindElement("EditCompany" ,CompaniesLocators,  CompanyList);
					Click(EditButton);
					ReportConfig.PassedLogInfo("Edit Company", "Click on Edit button");
					Print("Click on Edit button");
					/////////////////////////////////////////////////////////////////////////////////

					//						ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);
					//						Print("eXCEL EditCompanyDetails : " + ReadFrom.rowcount);
					//for(int EditCompanyDetails =1; EditCompanyDetails<=ReadFrom.rowcount; EditCompanyDetails++)		{	


					Wait(3000);
					if(IsElementDisplayed("DropdownList", CompaniesLocators)) {

						Wait(2000);
						Clear("CompanyName", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"Company name is cleared");
//						Print("Company name is cleared");

						TypeDataInTheField("CompanyName", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" , "Edited Company name is : " + ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));
						Print("Edited Company name : " + ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));


						Wait(2000);
						Clear("AddressLine1", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"AddressLine1 is cleared");
//						Print("AddressLine1 is cleared");

						TypeDataInTheField("AddressLine1", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" , "Edited AddressLine1 is : " + ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));
						Print("Edited AddressLine1  : " + ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));

						Wait(2000);
						ClickEnter();

						Wait(2000);
						Clear("AddressLine2", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"AddressLine2 is cleared");
//						Print("AddressLine2 is cleared");

						TypeDataInTheField("AddressLine2", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" , "Edited AddressLine2 is : " + ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));
						Print("Edited AddressLine2 : " + ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));

						Wait(2000);
						Clear("City", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"City is cleared");
//						Print("City is cleared");

						TypeDataInTheField("City", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" ,"Edited City is : " + ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));
						Print("Edited City : " + ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));

						Wait(2000);
						Clear("State", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"State is cleared");
//						Print("State is cleared");

						TypeDataInTheField("State", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" , "Edited State is : " + ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));
						Print("Edited State : " + ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));

						Wait(2000);
						Clear("Zipcode", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"Zipcode is cleared");
//						Print("Zipcode is cleared");

						TypeDataInTheField("Zipcode", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" , "Edited Zipcode is : " + ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));
						Print("Edited Zipcode is : " + ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));

						Wait(2000);
						Clear("Country", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"Country is cleared");
//						Print("Country is cleared");

						TypeDataInTheField("Country", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" , "Edited Country is : " + ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));
						Print("Edited Country is : " + ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));

						Wait(2000);
						Clear("Website", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"Website is cleared");
//						Print("Website is cleared");

						TypeDataInTheField("Website", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" ,"Edited Website is : " + ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));
						Print("Edited Website is : " + ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));

						Wait(2000);
						Clear("AdditionalNotes", CompaniesLocators);
//						ReportConfig.PassedLogInfo("Edit Company" ,"AdditionalNotes is cleared");
//						Print("AdditionalNotes is cleared");

						TypeDataInTheField("AdditionalNotes", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Edit Company" , "Edited AdditionalNotes is : " + ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));
						Print("Edited AdditionalNotes is : " + ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));


						Wait(2000);

						Click("DropdownList", CompaniesLocators);
						ReportConfig.PassedLogInfo("Edit Company" ,"Click on Dropdown");
						Print("Click on Dropdown ");

						Click("SelectAllInDropdown", CompaniesLocators);

						Click("UnSelectAllInDropdown", CompaniesLocators);
						//ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);

						//	for(int AddCompanyDfow =1; AddCompanyDfow<=ReadFrom.rowcount; AddCompanyDfow++)		{	
						String DfowInExcel = ReadFrom.Excel(EditCompanyDetails, 2,ReadFrom.EditCompanyDetails);


						int rowcountofthelist = 	SizeOfTheList("DfowList", CompaniesLocators);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	

							WebElement Dfow = 	FindElement("DfowInDropdown", CompaniesLocators, DropdownValues);
							String DfowInDropdown = 	GetTextFromTheElement(Dfow);

							if(DfowInDropdown.equalsIgnoreCase(DfowInExcel)){
								Click(Dfow);
								ReportConfig.PassedLogInfo("Edit Company" ,"Select Dfow: " + DfowInDropdown);
								Print("Select Dfow: " + DfowInDropdown);
								break;
							}
							else {
								PrintError("Not matched");
							}
							//}
							//} 
						}

						Wait(2000);
						Click("SubmitButton", CompaniesLocators);
						ReportConfig.PassedLogInfo("Edit Company" ,"Click on Submit button");
						Print("Click on Submit button");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Company Updated Successfully.']"));
							}
						});

						if(IsElementDisplayed("CompanyEdited", CompaniesLocators)){
							Print( "Company edited is : " + ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails));
							ReportConfig.PassedLogInfo("Edit Company" , "Company edited is : " + ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails));
							break;
						}else {
							PrintError("Company not edited");
							ReportConfig.FailedLogInfo("Edit Company","Company not edited");
							String IssueSummary = "Company Updated Successfull popup is not displayed";
							String Storydescription = "Edit company" ;
							pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

						}

					}

					//	}
					break;
				}
			}
		}

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



	public static void BulkSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Company File uploaded.!']"));
			}
		});
	}

	public static void InvalidFileError() throws Throwable {
		PrintError("Company InvalidFileError started");

		Wait(2000);

		Click("ImportMultiple", CompaniesLocators);

		Print("Click on Import Multiple button");
		ReportConfig.Givenlogpass("User uploads invalid file" ,"Click on Import Multiple button");

		Wait(2000);

		String upload = ReadFrom.UploadCompanyLogo;
		String filePath = System.getProperty("user.dir")+ upload;

		WebElement file = driver.findElement(By.xpath("//input[@type='file']"));

		Wait(3000);
		file.sendKeys(filePath);

		Wait(1000);
		String invalidText =	GetText("InvalidFileAlert", CompaniesLocators);

		Print("Please enter valid file format. : " + invalidText);
		ReportConfig.Givenlogpass("User uploads invalid file" ,"Please enter valid file format.: " + invalidText);

		Wait(7000);

		Click("CloseButton", CompaniesLocators);

		Print("Click on Close button");
		ReportConfig.Givenlogpass("User uploads invalid file" ,"Click on Close button");

	}

	public static void InvalidImageError() throws Throwable {
		PrintError("Company InvalidImageError started");
		Wait(2000);
		Click("NewCompany", CompaniesLocators);
		ReportConfig.Givenlogpass("User adds invalid file in company logo", "Click on New company button");
		Print("Click on New company button");


		Wait(2000);

		String upload = ReadFrom.UploadDfowFile;
		String imagePath = System.getProperty("user.dir")+ upload;

		WebElement logo = driver.findElement(By.xpath("//label[@for='file-input']//following::input[@id='file-input']"));

		Wait(3000);
		logo.sendKeys(imagePath);

		Print("Invalid Image file is uploaded");
		ReportConfig.Givenlogpass("User adds invalid file in company logo","Invalid Image file is uploaded");


		Wait(1000);
		String InvalidImage =	GetText("InvalidImage", CompaniesLocators);

		Print("Please enter valid file format. : " + InvalidImage);
		ReportConfig.Givenlogpass("User adds invalid file in company logo","Please enter valid file format.: " + InvalidImage);


		Wait(4000);

		Click("CloseButton", CompaniesLocators);

		Print("Click on Close button");
		ReportConfig.Givenlogpass("User adds invalid file in company logo","Click on Close button");	


	}

	public static void MaximumCharacterLength() throws Throwable {
		PrintError("Company MaximumCharacterLength started");
	//	ReadFrom.DynamicExcel(ReadFrom.NegativeAddCompany);

		for(int AddCompany =1; AddCompany<=1; AddCompany++) {

			Wait(2000);
			Click("NewCompany", CompaniesLocators);
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Click on New company button");
			Print("Click on New company button");


			Wait(2000);



			Wait(3000);

			String shortName = "dc";

			TypeDataInTheField("CompanyName", CompaniesLocators, shortName);

			Wait(2000);
			try {
				Click("Dfow", CompaniesLocators);
				ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" , "Click on Dropdown");

				String DfowInExcel = ReadFrom.Excel(AddCompany, 1,ReadFrom.AddCompany);

				int rowcountofthelist = 	SizeOfTheList("DfowList", CompaniesLocators);

				for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
					WebElement Dfow = 	FindElement("DfowInDropdown", CompaniesLocators, DropdownValues);
					String DfowInDropdown = 	GetTextFromTheElement(Dfow);


					if(IsEqual(DfowInDropdown, DfowInExcel)){
						Click(Dfow);

						ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Selected Dfow  : " + DfowInDropdown );
						Print("Selected Dfow  : " + DfowInDropdown );
						break;
					}
					else {
						PrintError("Not matched");
					}
				}
			}
			catch (Exception e) {
				PrintError(e.getMessage());
			}


			Wait(2000);
			TypeDataInTheField("AddressLine1", CompaniesLocators, ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Entered Address line1 : " +ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));
			Print("Entered Address line1 : " +ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));

			Wait(2000);
			TypeDataInTheField("City", CompaniesLocators, ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Entered City : " +ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));
			Print("Entered City : " +ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));

			Wait(2000);
			TypeDataInTheField("State", CompaniesLocators, ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Entered State : " +ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));
			Print("Entered State : " +ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));

			Wait(2000);
			TypeDataInTheField("Zipcode", CompaniesLocators, ReadFrom.Excel(AddCompany, 6, ReadFrom.AddCompany));
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Entered Zipcode : " +ReadFrom.Excel(AddCompany,6, ReadFrom.AddCompany));
			Print("Entered Zipcode : " +ReadFrom.Excel(AddCompany,6, ReadFrom.AddCompany));

			Wait(2000);
			TypeDataInTheField("Country", CompaniesLocators, ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Entered Country : " +ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));
			Print("Entered Country : " +ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));


			Wait(2000);
			Click("SubmitButton", CompaniesLocators);

			//Wait(3000);

			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));

			String MinimumCharacters =	GetText("MinimumCharacters", CompaniesLocators);


			Print("Minimum charcter length needed error : " + MinimumCharacters);
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Minimum charcter length needed error: " + MinimumCharacters);

			String name = RandomStringUtils.randomAlphabetic(300);

			Wait(2000);

			Clear("CompanyName", CompaniesLocators);
			Wait(2000);

			TypeDataInTheField("CompanyName", CompaniesLocators, name);


			Wait(2000);

			Click("SubmitButton", CompaniesLocators);

			//Wait(64000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));
			String MaximumCharacters =	GetText("MaximumCharacters", CompaniesLocators);


			Print("Maximum charcter exceeds error : " + MaximumCharacters);
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Maximum charcter exceeds error: " + MaximumCharacters);

			Wait(4000);

			Click("CloseButton", CompaniesLocators);
			Print("Click on Close button");

			Wait(3000);

			Click("Yes", CompaniesLocators);

			Print("Yes button is clicked");
			ReportConfig.Givenlogpass("user adds company name that exceeds maximum length" ,"Click on Close button");


		}

	}

}
