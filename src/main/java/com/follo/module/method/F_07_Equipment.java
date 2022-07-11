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

public class F_07_Equipment extends Baseclass {

	public static void AddEquipment() throws Throwable {

		Wait(3000);
		PrintError("Add equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.AddEquipment);

		for(int AddEquipment =1; AddEquipment<=ReadFrom.rowcount; AddEquipment++)		{	

			Click("AddNewEquipment", EquipmentLocators);
			ReportConfig.PassedLogInfo("User adds new equipment","Click on Add new button");
			Print("Click on Add new button");
			Wait(5000);
			WaitForTheElement("EquipmentName", EquipmentLocators);
			if(IsElementDisplayed("EquipmentName", EquipmentLocators)) {

				TypeDataInTheField("EquipmentName", EquipmentLocators, ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
				ReportConfig.PassedLogInfo("User adds new equipment", "Entered Equipment name : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
				Print("Entered Equipment name : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));

				Wait(2000);

				SelectFromVisibleText("EquipmentType" , EquipmentLocators, ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));
				ReportConfig.PassedLogInfo("User adds new equipment", "Entered Equipment type : " + ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));
				Print("Entered Equipment type : " + ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));

				Wait(2000);

				SelectFromVisibleText("ContactPerson" , EquipmentLocators, ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));
				ReportConfig.PassedLogInfo("User adds new equipment", "Entered Contact person : " + ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));
				Print("Entered Contact person : " + ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));

				Click("SubmitButton", EquipmentLocators);
				ReportConfig.PassedLogInfo("User adds new equipment", "Click on Submit button");
				Print("Click on Submit button");
			}
			else {
				ReportConfig.FailedLogInfo("User adds new equipment", "Add equipment popup is not opened");
				Print("Equipment popup is not opened button is clicked");
				
				String IssueSummary = "Add equipment popup is not opened" ;
				String Storydescription = "Add equipments" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

			}
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@aria-label='Equipment added successfully.']"));
				}
			});

			if(IsElementDisplayed("EquipmentAdded", EquipmentLocators)) {
				Click("EquipmentAdded", EquipmentLocators);
				Print("Equipment added is : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
				ReportConfig.PassedLogInfo("User adds new equipment", "Equipment added is : " +  ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
			}
			else {

				PrintError("Equipment is not added");
				ReportConfig.FailedLogInfo("User adds new equipment","Equipment is not added");
				
				String IssueSummary = "Equipment added successfully is not displayed" ;
				String Storydescription = "Add equipments" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}
		}
	}

	public static void EditEquipment() throws Throwable {

		PrintError("Edit equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.EditEquipment);

		for(int EditEquipmentDetails =1; EditEquipmentDetails<=ReadFrom.rowcount; EditEquipmentDetails++)	{


			int rowcount = SizeOfTheList("EditButtonLocator", EquipmentLocators);


			for(int EditButton =1; EditButton<=rowcount; EditButton++)	{

				WebElement EquipmentList =	FindElement("EquipmentList" , EquipmentLocators , EditButton);

				String EquipmentListList = 	GetTextFromTheElement(EquipmentList);


				String EditIt =	ReadFrom.Excel(EditEquipmentDetails, 0, ReadFrom.EditEquipment);


				if(IsEqual(EquipmentListList, EditIt)) {

					Wait(2000);

					WebElement Edit =	FindElement("EditButton" ,EquipmentLocators, EditButton);
					Click(Edit);
					Wait(2000);

					Clear("EquipmentName", EquipmentLocators);

					TypeDataInTheField("EquipmentName", EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));
					ReportConfig.PassedLogInfo("User edit a equipment from the list", "Edited Equipment name is : " + ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));
					Print("Edited Equipment name is : " + ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));

					Wait(2000);

					SelectFromVisibleText("EquipmentType" , EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));
					ReportConfig.PassedLogInfo("User edit a equipment from the list", "Edited Equipment type is : " + ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));
					Print("Edited Equipment type is : " + ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));


					Wait(2000);

					SelectFromVisibleText("ContactPerson" , EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));
					ReportConfig.PassedLogInfo("User edit a equipment from the list", "Edited Contact person is : " + ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));
					Print("Edited Contact person is : " + ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));

					Wait(2000);
					Click("SubmitButton", EquipmentLocators);

					Wait<WebDriver> MemberUpdated = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					MemberUpdated.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Equipment updated successfully.']"));
						}
					});

					if(IsElementDisplayed("EquipmentEdit", EquipmentLocators)) {

						Print("Updated equipment is : " + EquipmentListList );
						ReportConfig.PassedLogInfo("User edit a equipment from the list", "Updated equipment is : " + EquipmentListList );
					}
					else {
						
						String IssueSummary = "Equipment updated successfully is not displayed" ;
						String Storydescription = "Update equipments" ;
						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
					}
				}
			} 
		}
	}

	public static void SearchEquipment() throws Throwable {

		PrintError("Search equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.SearchEquipment);

		for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{
			Click("SearchButton", EquipmentLocators);
			Wait(2000);

			TypeDataInTheField("Search", EquipmentLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment));
			ReportConfig.PassedLogInfo("User search and view the equipment","Searched value :" +ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment));
			Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment) + " is entered in the search bar");

			Wait(5000);


			int rowcount = 	SizeOfTheList("EquipmentLists", EquipmentLocators);

			for(int SearchedEquipment =1; SearchedEquipment<=rowcount; SearchedEquipment++)	{

				WebElement Equipment =	FindElement("EquipmentList", EquipmentLocators, SearchedEquipment);
				String EquipmentName =	GetTextFromTheElement(Equipment);

				Wait(2000);

				String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment);

				if(IsEqual(EquipmentName, SearchedValue)) {

					Wait(2000);
					Print("Displayed value is : " + EquipmentName);
					ReportConfig.PassedLogInfo("User search and view the equipment","Displayed value is : " + EquipmentName);

					Wait(3000);
					break;

				}
				else {
					PrintError("Displayed value is : " + EquipmentName);
//					ReportConfig.FailedLogInfo("Displayed value is : " ,  EquipmentName);
//					
//					String IssueSummary = "Searched value is : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment) + "but displayed value is : " + EquipmentName ;
//					String Storydescription = "Search equipment" ;
//					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				}
			}

			Wait(5000);
			Clear("Search", EquipmentLocators);
			Wait(3000);
			Click("ClearSearch", EquipmentLocators);
			ReportConfig.PassedLogInfo("To search equipments","Click on Clear search button");
			Print("Click on Clear search button");
		}
	}


	public static void DeleteEquipment() throws Throwable {

		PrintError("Delete equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.DeleteEquipment);

		for(int DeleteEquipment =1; DeleteEquipment<=ReadFrom.rowcount; DeleteEquipment++)	{


			int rowcount = 	SizeOfTheList("DeleteButtonLocator", EquipmentLocators);

			for(int DeleteButton =1; DeleteButton<=rowcount; DeleteButton++)	{

				WebElement Equipment =	FindElement("EquipmentList", EquipmentLocators, DeleteButton);

				String EquipmentName = 	GetTextFromTheElement(Equipment);

				String DeleteIt =	ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment);


				if(IsEqual(EquipmentName, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteButton" ,EquipmentLocators, DeleteButton);
					Click(Delete);
					Wait(2000);

					Click("YesDelete", EquipmentLocators);
					ReportConfig.PassedLogInfo("User delete a equipment from the list", "Click on delete button");
					Print("Click on delete button");

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);

					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Equipment deleted successfully.']"));
						}
					});

					if(IsElementDisplayed("EquipmentDeleted", EquipmentLocators)){
						Click("EquipmentDeleted", EquipmentLocators);
						Print("Equipment deleted is : " + ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment));
						ReportConfig.PassedLogInfo("User delete a equipment from the list", "Equipment deleted is : " + ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment));
						break;
					}else {
						PrintError("Equipment not deleted");
						ReportConfig.FailedLogInfo("User delete a equipment from the list", "Equipment not deleted");
						
						String IssueSummary = "Equipment deleted successfully is not displayed" ;
						String Storydescription = "Deleted equipments" ;
						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

						Wait(3000);

						break;

					}
				}
			}
		}
	}

	public static void FilterEquipment() throws Throwable {

		PrintError("Filter equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.FilterEquipment);

		for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{

			Click("FilterIcon", EquipmentLocators);
			ReportConfig.PassedLogInfo("To filter equipments" ,"Filter icon is clicked");
			Print("Filter icon is clicked");
			Wait(6000);



			TypeDataInTheField("EquipmentNameInFilter", EquipmentLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));
			ReportConfig.PassedLogInfo("User filter the company based on equipment name", "Entered Equipment name : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));
			Print("Entered Equipment name : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));

			Click("FilterApply", EquipmentLocators);
			ReportConfig.PassedLogInfo("User filter the company based on equipment name", "Click on Filter apply button");
			Print("Click on Filter apply button");
			Wait(3000);

			int rowcount = 	SizeOfTheList("EquipmentLists", EquipmentLocators);

			for(int EquipmentLists =1; EquipmentLists<=rowcount; EquipmentLists++)	{

				WebElement Equipment =	FindElement("EquipmentList" , EquipmentLocators, EquipmentLists );
				String EquipmentName =	GetTextFromTheElement(Equipment);

				Wait(2000);

				String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment);

				if(	IsEqual(EquipmentName, FilteredValue)) {

					Wait(2000);
					Print("Filtered value is : " + FilteredValue + " : Displayed value is : " + EquipmentName);
					ReportConfig.PassedLogInfo("Filtered value is : " , FilteredValue + " : Displayed value is : " + EquipmentName);
					Wait(3000);

				}
				else {
					PrintError("Filtered value is : " + FilteredValue + " : Displayed value is : " + EquipmentName);
					ReportConfig.FailedLogInfo("Filtered value is : ", FilteredValue + " : Displayed value is : " + EquipmentName);
				}


			}
			Click("FilterIcon", EquipmentLocators);
			ReportConfig.PassedLogInfo("User filter the company based on equipment name", "Click on Filter icon button");
			Print("Click on Filter icon button");

			Wait(3000);
			Click("FilterReset", EquipmentLocators);
			ReportConfig.PassedLogInfo("User filter the company based on equipment name", "Click on Filter reset button");
			Print("Click on Filter reset button");

			Wait(3000);
			//	Clear("SearchDfow", DFOWLocators);

		}
	}

	public static void MaximumCharacterLength() throws Throwable {

		Wait(3000);
		PrintError("MaximumCharacterLength equipment Started");

		for(int AddEquipment =1; AddEquipment<=1; AddEquipment++)		{	

			Click("AddNewEquipment", EquipmentLocators);
			ReportConfig.Givenlogpass("user adds equipment name that exceeds maximum length","Click on Add new button");
			Print("Click on Add new button");
			Wait(4000);
			WaitForTheElement("EquipmentName", EquipmentLocators);
			if(IsElementDisplayed("EquipmentName", EquipmentLocators)) {

				Wait(3000);

				String shortName = "dc";

				TypeDataInTheField("EquipmentName", EquipmentLocators, shortName);

				Wait(2000);

				SelectFromVisibleText("EquipmentType" , EquipmentLocators, ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));
				ReportConfig.Givenlogpass("user adds equipment name that exceeds maximum length","Entered Equipment type : " + ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));
				Print("Entered Equipment type : " + ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));

				Wait(2000);

				SelectFromVisibleText("ContactPerson" , EquipmentLocators, ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));
				ReportConfig.Givenlogpass("user adds equipment name that exceeds maximum length","Entered Contact person : " + ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));
				Print("Entered Contact person : " + ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));

				Click("SubmitButton", EquipmentLocators);
				ReportConfig.Givenlogpass("user adds equipment name that exceeds maximum length","Click on Submit button");
				Print("Click on Submit button");


				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));

				String MinimumCharacters =	GetText("MinimumCharacters", EquipmentLocators);


				Print("Minimum charcter length needed error : " + MinimumCharacters);
				ReportConfig.Givenlogpass("user adds equipment name with two characters","Minimum character length needed error: " + MinimumCharacters);

				String name = RandomStringUtils.randomAlphabetic(300);

				Wait(2000);

				Clear("EquipmentName", EquipmentLocators);
				Wait(2000);

				TypeDataInTheField("EquipmentName", EquipmentLocators, name);


				Wait(2000);

				Click("SubmitButton", EquipmentLocators);
				ReportConfig.Givenlogpass("user adds equipment name that exceeds maximum length","Click on Submit button");
				Print("Click on Submit button");


				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));
				String MaximumCharacters =	GetText("MaximumCharacters", EquipmentLocators);


				Print("Maximum charcter exceeds error : " + MaximumCharacters);
				ReportConfig.Givenlogpass("user adds equipment name that exceeds maximum length","Maximum character exceeds error: " + MaximumCharacters);
		

				Click("CancelButton", EquipmentLocators);
				Print("Cancel button is clicked");

				Wait(3000);

				Click("Yes", EquipmentLocators);

				Print("Yes button is clicked");
				ReportConfig.Givenlogpass("user adds equipment name that exceeds maximum length","Close button is clicked");

			}
			else {
				ReportConfig.Givenlogpass("user adds equipment name that exceeds maximum length","Equipment accepts more than 255 characters");
				
				Print("Equipment popup is not opened button is clicked");
				
				String IssueSummary = "Equipment popup is not opened button is clicked" ;
				String Storydescription = "user adds equipment name that exceeds maximum length" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );

			}

		}

	}


}
