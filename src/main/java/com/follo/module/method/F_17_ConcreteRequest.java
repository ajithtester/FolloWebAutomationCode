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

public class F_17_ConcreteRequest extends Baseclass {
	public static List<WebElement> ConcreteRequestList;
	
	public static WebElement DeleteElement(String locator) throws Throwable {


		return driver.findElement(By.xpath("//*[contains(text(),'" + locator + "')]//following::img[@alt='edit'][2]"));
}

	public static void AddConcreteRequest() throws Throwable {

		PrintError("Add concrete request Started");

		ReadFrom.DynamicExcel(ReadFrom.AddConcreteRequest);
		for(int AddConcreteRequest =1; AddConcreteRequest<=ReadFrom.rowcount; AddConcreteRequest++)		{

			String ConcreteName = 	ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest) ;

			Waitfortheelement("ConcreteRequest.CreateNew", ConcreteRequestLocators);

			Wait(3000);

			Click("ConcreteRequest.CreateNew", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Add new concrete calendar button is clicked");
			Print("Add new button is clicked");

			Wait(3000);
			Wait<WebDriver> Description = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Description.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@formcontrolname='description']")); 
				}
			});


			TypeDataInTheField("ConcreteRequest.Description", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Description is entered as : " + ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest));
			Print("Description is entered as : " + ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Location", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Location is entered as : " + ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));
			Print("Location is entered as : " + ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));

			Wait(1000);

			ClickEnter();
			Wait(1000);
			Clear("ConcreteRequest.SelectDate", ConcreteRequestLocators);

			TypeDataInTheField("ConcreteRequest.SelectDate", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"SelectDate is entered as : " + ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));
			Print("SelectDate is entered as : " + ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.FromHH", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.FromHH", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 3, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"FromHH is entered as : " + ReadFrom.Excel(AddConcreteRequest, 3, ReadFrom.AddConcreteRequest));
			Print("FromHH is entered as : " + ReadFrom.Excel(AddConcreteRequest, 3, ReadFrom.AddConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.FromMM", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.FromMM", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 4, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"FromMM is entered as : " + ReadFrom.Excel(AddConcreteRequest, 4, ReadFrom.AddConcreteRequest));
			Print("FromMM is entered as : " + ReadFrom.Excel(AddConcreteRequest, 4, ReadFrom.AddConcreteRequest));

			Wait(2000);
			String FromMeridian = ReadFrom.Excel(AddConcreteRequest, 5, ReadFrom.AddConcreteRequest);

			String Meridian = GetText("ConcreteRequest.FromMeridian", ConcreteRequestLocators);
			Print(Meridian);
			if(IsEqual(Meridian, FromMeridian)) {


			}
			else {
				Click("ConcreteRequest.FromMeridian", ConcreteRequestLocators);
			}

			Wait(2000);
			Clear("ConcreteRequest.ToHH", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.ToHH", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 6, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"ToHH is entered as : " + ReadFrom.Excel(AddConcreteRequest, 6, ReadFrom.AddConcreteRequest));
			Print("ToHH is entered as : " + ReadFrom.Excel(AddConcreteRequest, 6, ReadFrom.AddConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.ToMM", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.ToMM", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 7, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"ToMM is entered as : " + ReadFrom.Excel(AddConcreteRequest, 7, ReadFrom.AddConcreteRequest));
			Print("ToMM is entered as : " + ReadFrom.Excel(AddConcreteRequest, 7, ReadFrom.AddConcreteRequest));

			Wait(2000);
			String ToMeridian = ReadFrom.Excel(AddConcreteRequest, 8, ReadFrom.AddConcreteRequest);

			String ToMeridian2 = GetText("ConcreteRequest.ToMeridian", ConcreteRequestLocators);
			Print(ToMeridian2);
			if(IsEqual(ToMeridian2, ToMeridian)) {


			}
			else {
				Click("ConcreteRequest.ToMeridian", ConcreteRequestLocators);
			}

			Wait(2000);
			//			Click("ConcreteRequest.Dropdown", ConcreteRequestLocators);
			//			Wait(2000);
			//			WebElement Dropdown = 	FindElement(ReadFrom.Excel(AddConcreteRequest, 9, ReadFrom.AddConcreteRequest));
			//			Click(Dropdown);

			Wait(2000);
			TypeDataInTheField("ConcreteRequest.MixDesign", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"MixDesign is entered as : " + ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));
			Print("MixDesign is entered as : " + ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));

			Wait(2000);
			ClickEnter();
			Wait(1000);

			TypeDataInTheField("ConcreteRequest.OrderNumber", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"OrderNumber is entered as : " + ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));
			Print("OrderNumber is entered as : " + ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Slump", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Slump is entered as : " + ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));
			Print("Slump is entered as : " + ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.TruckSpacingHours", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"TruckSpacingHours is entered as : " + ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));
			Print("TruckSpacingHours is entered as : " + ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.QuantityOrdered", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"QuantityOrdered is entered as : " + ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));
			Print("QuantityOrdered is entered as : " + ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Primer", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Primer is entered as : " + ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));
			Print("Primer is entered as : " + ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Notes", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Primer is entered as : " + ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));
			Print("Primer is entered as : " + ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));

			Wait(2000);

			Click("ConcreteRequest.Submit", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Submit button is clicked");
			Print("Submit button is clicked");

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
			String ConcreteRequestAdded =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(ConcreteRequestAdded, "Concrete Request Created Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Request added is : " + ConcreteName);
				ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Request added is : " + ConcreteName);

			}
			else {
				Print("Add Concrete Request failed");
				ReportConfig.Givenlogfail("To view info and history, add comment, add attachment to the Concrete request" ,"Add Concrete Request failed");

				String IssueSummary =  ConcreteRequestAdded;
				String Storydescription = "Add Concrete Request failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}
		}

	}

	public static void SearchConcreteRequest() throws Throwable {


		PrintError("Search concrete request started");

		ReadFrom.DynamicExcel(ReadFrom.ConcreteRequest);

		for(int ConcreteRequest =1; ConcreteRequest<=ReadFrom.rowcount; ConcreteRequest++)	{

			Wait(5000);
			Click("ConcreteRequest.SearchIcon", ConcreteRequestLocators);
			Wait(2000);

			TypeDataInTheField("ConcreteRequest.SearchField", ConcreteRequestLocators, ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest));
			ReportConfig.Givenlogpass("User search the Concrete request" ,ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest) + " is entered in the search bar");
			Print(ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest) + " is entered in the search bar");

			Wait(7000);

			List<WebElement> c = 		getElements("ConcreteRequest.ConcreteRequest", ConcreteRequestLocators);
			for (WebElement webElement : c) {
				String ConcreteRequestName = 	GetTextFromTheElement(webElement);

				String Excelvalue = 	ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest);
				if(IsEqual(Excelvalue, ConcreteRequestName)) {
					Print("Searched value is : " + ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest) + " and displayed value is : " + ConcreteRequestName );
					ReportConfig.Givenlogpass("User search the Concrete request" ,"Searched value is : " + ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest) + "and displayed value is : " + ConcreteRequestName );
				}
				else
				{
					PrintError("Searched value is : " + ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest) + "but displayed value is : " + ConcreteRequestName );
//					ReportConfig.FailedLogInfo("User search the Concrete request" ,"Searched value is : " + ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest) + "but displayed value is : " + ConcreteRequestName );
//					String IssueSummary = "Searched value is : " + ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest) + "but displayed value is : " + ConcreteRequestName ;
//					String Storydescription = "Search concrete request failed" ;
//					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				}

			}

			Wait(5000);
			Clear("ConcreteRequest.SearchField", ConcreteRequestLocators);
			Wait(3000);
			JsClick("ConcreteRequest.CloseSearch", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("Search delivery request" ,"Clear search button is clicked");
			Print("Clear search button is clicked");

		}
	}

	public static void EditConcreteRequest() throws Throwable {

		PrintError("Edit concrete  request started");

		ReadFrom.DynamicExcel(ReadFrom.ConcreteRequest);

		for(int EditConcreteRequest =1; EditConcreteRequest<=ReadFrom.rowcount; EditConcreteRequest++)	{

			Wait(3000);
			String ConcreteName = 	ReadFrom.Excel(EditConcreteRequest, 0, ReadFrom.ConcreteRequest) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(EditConcreteRequest, 0, ReadFrom.ConcreteRequest));

			Click(ConcreteRequest);

			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" , ConcreteName + " : is clicked");
			Print(ConcreteName + " : is clicked");

			Wait<WebDriver> Responsible = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Responsible.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']")); 
				}
			});


			//	Wait(7000);
			if(IsElementDisplayed("ConcreteRequest.ResponsiblePerson", ConcreteRequestLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,ConcreteName + " : is opened");
			}

			Wait(2000);

			MoveToElement("ConcreteRequest.EditButton", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.EditButton", ConcreteRequestLocators);

			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Edit button is clicked");
			Print("Edit button is clicked");

			Wait<WebDriver> description = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			description.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@formcontrolname='description']")); 
				}
			});
			Clear("ConcreteRequest.Description", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.Description", ConcreteRequestLocators, ReadFrom.Excel(EditConcreteRequest, 2, ReadFrom.ConcreteRequest));
			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Description is edited as : " + ReadFrom.Excel(EditConcreteRequest, 2, ReadFrom.ConcreteRequest));
			Print("Description is edited as : " + ReadFrom.Excel(EditConcreteRequest, 2, ReadFrom.ConcreteRequest));

			Clear("ConcreteRequest.QuantityOrdered", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.QuantityOrdered", ConcreteRequestLocators, ReadFrom.Excel(EditConcreteRequest, 3, ReadFrom.ConcreteRequest));
			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Quantity ordered is edited as : " + ReadFrom.Excel(EditConcreteRequest, 3, ReadFrom.ConcreteRequest));
			Print("Quantity ordered is edited as : " + ReadFrom.Excel(EditConcreteRequest, 3, ReadFrom.ConcreteRequest));

			Wait(2000);

			Click("ConcreteRequest.Submit", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Submit button is clicked");
			Print("Submit button is clicked");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String RequestUpdated =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(RequestUpdated, "Concrete Request Updated Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Request updated is : " + ConcreteName);
				ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Request updated is : " + ConcreteName);

			}
			else {
				PrintError("User edit a Concrete request from the calendar");
				ReportConfig.Givenlogfail("User edit a Concrete request from the calendar" ,"Request updated to the request failed");
				String IssueSummary =  RequestUpdated;
				String Storydescription = "Request updated to the request failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

		}
	}

	public static void FilterConcreteRequest() throws Throwable {


		PrintError("Filter Concrete request started");
		ReadFrom.DynamicExcel(ReadFrom.ConcreteRequest);


		for(int FilterConcreteRequest =1; FilterConcreteRequest<=ReadFrom.rowcount; FilterConcreteRequest++)	{

			JsClick("ConcreteRequest.FilterIcon", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User filter the Concrete request", "Filter icon is clicked");
			Print("Filter icon is clicked");


			Wait<WebDriver> Filter = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Filter.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//input[@placeholder='Description']"));
				}
			});
			Wait(7000);
			TypeDataInTheField("ConcreteRequest.FilterDescription", ConcreteRequestLocators, ReadFrom.Excel(FilterConcreteRequest, 4, ReadFrom.ConcreteRequest));

			ReportConfig.Givenlogpass("User filter the Concrete request" , ReadFrom.Excel(FilterConcreteRequest, 4, ReadFrom.ConcreteRequest) + " is entered in the filter description");
			Print(ReadFrom.Excel(FilterConcreteRequest, 4, ReadFrom.ConcreteRequest) + " is entered in the filter description");

			Wait(2000);

			JsClick("ConcreteRequest.FilterApply", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User filter the Concrete request", "Apply button is clicked");
			Print("Apply button is clicked");

			Wait(7000);

			ConcreteRequestList = 	getElements("ConcreteRequest.ConcreteRequest", ConcreteRequestLocators);
			try {
				if(IsElementDisplayed("ConcreteRequest.ConcreteRequest", ConcreteRequestLocators)) {
					for (WebElement webElement : ConcreteRequestList) {
						String ConcreteRequestListName = 	GetTextFromTheElement(webElement);

						Print("Displayed value is : " + ConcreteRequestListName);
						ReportConfig.Givenlogpass("User filter the Concrete request" ,"Displayed value is : " + ConcreteRequestListName);
					}
				}
				else
				{
					PrintError("No request is available");
					ReportConfig.Givenlogfail("User filter the Concrete request" ,"Displayed value is : " + "No request is available");
				}

			}
			catch (Exception e) {
				// TODO: handle exception
			}

			Wait(2000);
			JsClick("ConcreteRequest.FilterIcon", ConcreteRequestLocators);
			Wait(2000);
			JsClick("ConcreteRequest.FilterReset", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User filter the Concrete request" ,"Reset button is clicked");
			Print("Reset button is clicked");
		}


	}

	public static void ConcreteRequestInfo() throws Throwable {

		PrintError("Concrete request info started");

		ReadFrom.DynamicExcel(ReadFrom.ConcreteRequest);

		for(int ConcreteRequest =1; ConcreteRequest<=ReadFrom.rowcount; ConcreteRequest++)	{

			Wait(3000);

			String ConcreteName = 	ReadFrom.Excel(ConcreteRequest, 2, ReadFrom.ConcreteRequest) ;
			WebElement ConcreteRequestName = 	FindElement(ReadFrom.Excel(ConcreteRequest, 2, ReadFrom.ConcreteRequest));

			Click(ConcreteRequestName);

			ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" , ConcreteName + " : is clicked");
			Print(ConcreteName + " : is clicked");

			Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			CompanyInFilter.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']")); 
				}
			});


			//	Wait(7000);
			if(IsElementDisplayed("ConcreteRequest.ResponsiblePerson", ConcreteRequestLocators)) {
				Print(ConcreteName + " : request info is viewed");
				ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,ConcreteName + " : request info is viewed");
			}

			Wait(2000);
			JsClick("ConcreteRequest.Attachments", ConcreteRequestLocators);

			if(IsElementDisplayed("ConcreteRequest.Attachments", ConcreteRequestLocators)) {
				PrintError("Attachment started");

				Wait(2000);
				String upload = ReadFrom.SampleAttachmentPNG;
				String filePath = System.getProperty("user.dir")+ upload;

				WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
				Wait(3000);
				file.sendKeys(filePath);
				Wait(3000);
				JsClick("ConcreteRequest.Done", ConcreteRequestLocators);
				Print("Done button is clicked");
				ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Done button is clicked");


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
				String AttachmentsUploaded =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
				if(IfContains(AttachmentsUploaded, "Uploaded Successfully.")) {
					Click("ConcreteRequest.Toast", ConcreteRequestLocators);
					Print("Attachments added to the request : " + ConcreteName);
					ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Add attachment to the request : " + ConcreteName);

				}
				else {
					Print("Add attachment to the request failed");
					ReportConfig.Givenlogfail("To view info and history, add comment, add attachment to the Concrete request" ,"Add attachment to the request failed");

					String IssueSummary =  AttachmentsUploaded;
					String Storydescription = "Add attachment to the request failed" ;
					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
				}

			}

			Wait(2000);
			JsClick("ConcreteRequest.Comments", ConcreteRequestLocators);

			if(IsElementDisplayed("ConcreteRequest.AddComments", ConcreteRequestLocators)) {

				PrintError("Add comment started");

				TypeDataInTheField("ConcreteRequest.AddComments", ConcreteRequestLocators, ReadFrom.Excel(ConcreteRequest, 1, ReadFrom.ConcreteRequest));
				ReportConfig.Givenlogpass("User add new Concrete request" ,"Comment added is : " + ReadFrom.Excel(ConcreteRequest, 1, ReadFrom.ConcreteRequest));
				Print("Comment added is : " + ReadFrom.Excel(ConcreteRequest, 1, ReadFrom.ConcreteRequest));

				Wait(2000);
				JsClick("ConcreteRequest.Submit", ConcreteRequestLocators);
				Print("Submit button is clicked");
				ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Submit button is clicked");


				Wait<WebDriver> AddComment = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				AddComment.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@id='toast-container']")); 
					}
				});


				String CommentAdded =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
				if(IfContains(CommentAdded, "Concrete Request Comment added successfully")) {
					Click("ConcreteRequest.Toast", ConcreteRequestLocators);
					Print("Comment added to the request : " + ConcreteName);
					ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Comment added to the request : " + ConcreteName);

				}
				else {
					Print("Add comment to the request failed");
					ReportConfig.Givenlogfail("To view info and history, add comment, add attachment to the Concrete request" ,"Add comment to the request failed");
					String IssueSummary =  CommentAdded;
					String Storydescription = "Add comment to the request failed" ;
					pt_Integration.CreateStory.post_Story(Storydescription , CommentAdded);
				}
			}

			Wait(2000);
			JsClick("ConcreteRequest.History", ConcreteRequestLocators);
			Wait(3000);
			Waitfortheelement("ConcreteRequest.HistoryViewed", ConcreteRequestLocators);
			if(IsElementDisplayed("ConcreteRequest.HistoryViewed", ConcreteRequestLocators)) 
			{
				PrintError("View history started");

				List<WebElement> History = 	getElements("ConcreteRequest.HistoryViewed", ConcreteRequestLocators);

				int HistoryCount = GetSize(History);

				ReportConfig.Givenlogpass("User add new Concrete request" ,"No of histories displayed in : " + ConcreteName + " is :" + HistoryCount);
				Print("No of histories displayed in : " + ConcreteName + " is :" + HistoryCount);

			}

			else {
				PrintError("History page not displayed");
				ReportConfig.Givenlogfail("To view info and history, add comment, add attachment to the Concrete request" ,"History page not displayed");
				String IssueSummary =  "User is not redirected to the history page";
				String Storydescription = "History page not displayed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

			Wait(2000);
			JsClick("ConcreteRequest.ClosePopup", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Close popup button is clicked");
			Print("Close popup button is clicked");

		}

	}

	public static void ApproveAndComplete() throws Throwable {

		PrintError("Approve and complete concrete request started");

		ReadFrom.DynamicExcel(ReadFrom.ApproveConcreteRequest);

		for(int ApproveAndComplete =1; ApproveAndComplete<=ReadFrom.rowcount; ApproveAndComplete++)	{


			Wait(2000);

			String ConcreteName = 	ReadFrom.Excel(ApproveAndComplete, 0, ReadFrom.ApproveConcreteRequest) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(ApproveAndComplete, 0, ReadFrom.ApproveConcreteRequest));

			Click(ConcreteRequest);

			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" , ConcreteName + " : is clicked");
			Print(ConcreteName + " : is clicked");

			Wait<WebDriver> Responsible = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Responsible.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']")); 
				}
			});


			//	Wait(7000);
			if(IsElementDisplayed("ConcreteRequest.ResponsiblePerson", ConcreteRequestLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,ConcreteName + " : is opened");
			}

			Wait(2000);

			MoveToElement("ConcreteRequest.EditButton", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.EditButton", ConcreteRequestLocators);

			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Edit button is clicked");
			Print("Edit button is clicked");

			Wait<WebDriver> description = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			description.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@formcontrolname='description']")); 
				}
			});

			MoveToElement("ConcreteRequest.ConcreteConfirmed", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.ConcreteConfirmed", ConcreteRequestLocators);
			Wait(2000);

			Click("ConcreteRequest.Submit", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Submit button is clicked");
			Print("Submit button is clicked");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String RequestUpdated =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(RequestUpdated, "Concrete Request Updated Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Request approved is : " + ConcreteName);
				ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Request approved is : " + ConcreteName);

			}
			else {
				PrintError("Request approve failed");
				ReportConfig.Givenlogfail("User Approve and Complete a concrete request in the calendar" ,"Request approve failed");
				String IssueSummary =  RequestUpdated;
				String Storydescription = "Request approve failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

			Wait(3000);

			WebElement CompleteRequest = 	FindElement(ReadFrom.Excel(ApproveAndComplete, 0, ReadFrom.ApproveConcreteRequest));

			JsClick(CompleteRequest);

			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" , ConcreteName + " : is clicked");
			Print(ConcreteName + " : is clicked");

			Wait<WebDriver> ResponsiblePerson = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			ResponsiblePerson.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']")); 
				}
			});


			//	Wait(7000);
			if(IsElementDisplayed("ConcreteRequest.ResponsiblePerson", ConcreteRequestLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,ConcreteName + " : is opened");
			}

			MoveToElement("ConcreteRequest.MarkComplete", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.MarkComplete", ConcreteRequestLocators);
			Wait(2000);

			Wait<WebDriver> hoursToCompletePlacement = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			hoursToCompletePlacement.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//select[@formcontrolname='hoursToCompletePlacement']")); 
				}
			});


			SelectFromDropdown("ConcreteRequest.HoursToComplete", ConcreteRequestLocators, ReadFrom.Excel(ApproveAndComplete, 1, ReadFrom.ApproveConcreteRequest));
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Hours To Complete is selected as : " + ReadFrom.Excel(ApproveAndComplete, 1, ReadFrom.ApproveConcreteRequest));
			Print("Hours To Complete is selected as : " + ReadFrom.Excel(ApproveAndComplete, 1, ReadFrom.ApproveConcreteRequest));
			Wait(2000);

			SelectFromDropdown("ConcreteRequest.MinutesToComplete", ConcreteRequestLocators, ReadFrom.Excel(ApproveAndComplete, 2, ReadFrom.ApproveConcreteRequest));
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Minutes To Complete is selected as : " + ReadFrom.Excel(ApproveAndComplete, 2, ReadFrom.ApproveConcreteRequest));
			Print("Minutes To Complete is selected as : " + ReadFrom.Excel(ApproveAndComplete, 2, ReadFrom.ApproveConcreteRequest));
			Wait(2000);

			TypeDataInTheField("ConcreteRequest.TotalCubic", ConcreteRequestLocators, ReadFrom.Excel(ApproveAndComplete, 3, ReadFrom.ApproveConcreteRequest));
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Total Cubic is entered as : " + ReadFrom.Excel(ApproveAndComplete, 3, ReadFrom.ApproveConcreteRequest));
			Print("Total Cubic is entered as : " + ReadFrom.Excel(ApproveAndComplete, 3, ReadFrom.ApproveConcreteRequest));
			Wait(2000);

			JsClick("ConcreteRequest.SubmitComplete", ConcreteRequestLocators);

			Wait<WebDriver> toast = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			toast.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String CompletedSuccessfully =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(CompletedSuccessfully, "Completed Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Request completed is : " + ConcreteName);
				ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Request completed is : " + ConcreteName);

			}
			else {
				PrintError("Request complete failed");
				ReportConfig.Givenlogfail("User Approve and Complete a concrete request in the calendar" ,"Request completed failed");
				String IssueSummary =  CompletedSuccessfully;
				String Storydescription = "Request completed failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

			Wait(2000);
			JsClick("ConcreteRequest.ClosePopup", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Close popup button is clicked");
			Print("Close popup button is clicked");

		}

	}

	public static void AddPump() throws Throwable {

		PrintError("Pump concrete request started");

		ReadFrom.DynamicExcel(ReadFrom.PumpConcreteRequest);

		for(int PumpConcreteRequest =1; PumpConcreteRequest<=ReadFrom.rowcount; PumpConcreteRequest++)	{

			Wait(2000);
			
			Wait<WebDriver> Request = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Request.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//div/table/tbody/tr/td[2]/p)")); 
				}
			});

			String ConcreteName = 	ReadFrom.Excel(PumpConcreteRequest, 0, ReadFrom.PumpConcreteRequest) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(PumpConcreteRequest, 0, ReadFrom.PumpConcreteRequest));

			Click(ConcreteRequest);

			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" , ConcreteName + " : is clicked");
			Print(ConcreteName + " : is clicked");

			Wait<WebDriver> Responsible = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Responsible.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']")); 
				}
			});


			//	Wait(7000);
			if(IsElementDisplayed("ConcreteRequest.ResponsiblePerson", ConcreteRequestLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,ConcreteName + " : is opened");
			}

			Wait(2000);

			MoveToElement("ConcreteRequest.EditButton", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.EditButton", ConcreteRequestLocators);

			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Edit button is clicked");
			Print("Edit button is clicked");

			Wait<WebDriver> description = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			description.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@formcontrolname='description']")); 
				}
			});

			MoveToElement("ConcreteRequest.PumpRequired", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.PumpRequired", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Pump required button is clicked");
			Print("Pump required button is clicked");

			Wait(2000);
			MoveToElement("ConcreteRequest.Submit", ConcreteRequestLocators);
			Wait(5000);

			Clear("ConcreteRequest.PumpOrdered", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.PumpOrdered", ConcreteRequestLocators, ReadFrom.Excel(PumpConcreteRequest, 2, ReadFrom.PumpConcreteRequest));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Pump ordered is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 2, ReadFrom.PumpConcreteRequest));
			Print("Pump ordered is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 2, ReadFrom.PumpConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.PumpLocation", ConcreteRequestLocators, ReadFrom.Excel(PumpConcreteRequest, 3, ReadFrom.PumpConcreteRequest));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Pump location is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 3, ReadFrom.PumpConcreteRequest));
			Print("Pump location is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 3, ReadFrom.PumpConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.PumpFromHH", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.PumpFromHH", ConcreteRequestLocators, ReadFrom.Excel(PumpConcreteRequest, 4, ReadFrom.PumpConcreteRequest));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"PumpFromHH is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 4, ReadFrom.PumpConcreteRequest));
			Print("PumpFromHH is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 4, ReadFrom.PumpConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.PumpFromMM", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.PumpFromMM", ConcreteRequestLocators, ReadFrom.Excel(PumpConcreteRequest, 5, ReadFrom.PumpConcreteRequest));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"PumpFromMM is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 5, ReadFrom.PumpConcreteRequest));
			Print("PumpFromMM is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 5, ReadFrom.PumpConcreteRequest));

			Wait(2000);
			String FromMeridian = ReadFrom.Excel(PumpConcreteRequest, 6, ReadFrom.PumpConcreteRequest);

			String Meridian = GetText("ConcreteRequest.PumpFromMeridian", ConcreteRequestLocators);

			if(IsEqual(Meridian, FromMeridian)) {

			}
			else {
				Click("ConcreteRequest.PumpFromMeridian", ConcreteRequestLocators);
			}

			Wait(2000);
			Clear("ConcreteRequest.PumpToHH", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.PumpToHH", ConcreteRequestLocators, ReadFrom.Excel(PumpConcreteRequest, 7, ReadFrom.PumpConcreteRequest));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"PumpToHH is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 7, ReadFrom.PumpConcreteRequest));
			Print("PumpToHH is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 7, ReadFrom.PumpConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.PumpToMM", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.PumpToMM", ConcreteRequestLocators, ReadFrom.Excel(PumpConcreteRequest, 8, ReadFrom.PumpConcreteRequest));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"PumpToMM is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 8, ReadFrom.PumpConcreteRequest));
			Print("PumpToMM is entered as : " + ReadFrom.Excel(PumpConcreteRequest, 8, ReadFrom.PumpConcreteRequest));

			Wait(2000);
			String ToMeridian = ReadFrom.Excel(PumpConcreteRequest, 9, ReadFrom.PumpConcreteRequest);

			String ToMeridian2 = GetText("ConcreteRequest.PumpToMeridian", ConcreteRequestLocators);

			if(IsEqual(ToMeridian2, ToMeridian)) {

			}
			else {
				Click("ConcreteRequest.PumpToMeridian", ConcreteRequestLocators);
			}

			Wait(2000);

			String Pumpconfirm =	ReadFrom.Excel(PumpConcreteRequest, 10, ReadFrom.PumpConcreteRequest);
			switch(Pumpconfirm) {
			case "Yes" :
				Click("ConcreteRequest.PumpConfirmed", ConcreteRequestLocators);
				ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Pump is confirmed");
				Print("Pump is confirmed");

			}

			Wait(2000);
			TypeDataInTheField("ConcreteRequest.PumpSize", ConcreteRequestLocators, ReadFrom.Excel(PumpConcreteRequest, 1, ReadFrom.PumpConcreteRequest));
			Wait(2000);
			ClickEnter();
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Pump size is edited as : " + ReadFrom.Excel(PumpConcreteRequest, 1, ReadFrom.PumpConcreteRequest));
			Print("Pump size is edited as : " + ReadFrom.Excel(PumpConcreteRequest, 1, ReadFrom.PumpConcreteRequest));

			Wait(2000);
			MoveToElement("ConcreteRequest.Submit", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.Submit", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Submit button is clicked");
			Print("Submit button is clicked");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String RequestUpdated =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(RequestUpdated, "Concrete Request Updated Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Pump added to the request : " + ConcreteName);
				ReportConfig.Givenlogpass("User add pump to the concrete request in concrete request" ,"Pump added to the request : " + ConcreteName);

			}
			else {
				PrintError("Pump add failed");
				ReportConfig.Givenlogfail("User add pump to the concrete request in concrete request" ,"Pump add failed");
				String IssueSummary =  RequestUpdated;
				String Storydescription = "Pump add failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

		}
	}

	public static void VoidConcreteRequest() throws Throwable {

		PrintError("Void concrete request started");

		ReadFrom.DynamicExcel(ReadFrom.VoidConcreteRequest);

		for(int VoidConcreteRequest =1; VoidConcreteRequest<=ReadFrom.rowcount; VoidConcreteRequest++)	{

			Wait(2000);


			String ConcreteName = 	ReadFrom.Excel(VoidConcreteRequest, 0, ReadFrom.VoidConcreteRequest) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(VoidConcreteRequest, 0, ReadFrom.VoidConcreteRequest));

			Click(ConcreteRequest);

			ReportConfig.Givenlogpass("User push a Concrete request from the calendar" , ConcreteName + " : is clicked");
			Print(ConcreteName + " : is clicked");

			Wait<WebDriver> Responsible = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Responsible.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']")); 
				}
			});


			//	Wait(7000);
			if(IsElementDisplayed("ConcreteRequest.ResponsiblePerson", ConcreteRequestLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User push a Concrete request from the calendar" ,ConcreteName + " : is opened");
			}

			Wait(2000);

			MoveToElement("ConcreteRequest.VoidButton", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.VoidButton", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User push a Concrete request from the calendar" ,"Void button is clicked");
			Print("Void button is clicked");

			Click("ConcreteRequest.YesButton", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User push a Concrete request from the calendar" ,"Yes button is clicked");
			Print("Yes button is clicked");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String Void =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(Void, "Concrete Request Marked as Void Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Request pushed to void is : " + ConcreteName);
				ReportConfig.Givenlogpass("User push a Concrete request from the calendar" ,"Request pushed to void is : " + ConcreteName);

			}
			else {
				PrintError("Request push to void is failed");
				ReportConfig.Givenlogfail("User push a Concrete request from the calendar" ,"Request push to void is failed");
				String IssueSummary =  Void;
				String Storydescription = "Request push to void is failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

		}
	}

	public static void NegativeMandatory() throws Throwable {

		PrintError("NegativeMandatory Concrete Calender started");
		Wait(2000);
		JsClick("ConcreteRequest.CreateNew", ConcreteRequestLocators);
		Print("Create New button is clicked");
		ReportConfig.Givenlogpass("User add new Concrete request without filling mandatory field","Create New button is clicked");

		Wait(2000);
		MoveToElement("ConcreteRequest.Submit", ConcreteRequestLocators);
		JsClick("ConcreteRequest.Submit", ConcreteRequestLocators);
		Print("Submit button is clicked");
		ReportConfig.Givenlogpass("User add new Concrete request without filling mandatory field","Submit button is clicked");

		String DescriptionRequired = 	GetText("ConcreteRequest.DescriptionRequired", ConcreteRequestLocators);
		ReportConfig.Givenlogpass("Description required Error :", DescriptionRequired);
		PrintError(DescriptionRequired);
		Wait(2000);
		MoveToElement("ConcreteRequest.Submit", ConcreteRequestLocators);
		Wait(2000);
		Click("ConcreteRequest.CancelButton", ConcreteRequestLocators);
		ReportConfig.Givenlogpass("User add new Concrete request without filling mandatory field","Cancel button is clicked");
		Wait(2000);
		Click("ConcreteRequest.YesButton", ConcreteRequestLocators);
		Print("Close button is clicked");
		ReportConfig.Givenlogpass("User add new Concrete request without filling mandatory field","Yes button is clicked");
	}


	public static void AddInviteDateAndTime() throws Throwable {

		PrintError("Invalid date concrete request Started");
		ReadFrom.DynamicExcel(ReadFrom.AddConcreteRequest);
		for(int AddConcreteRequest =1; AddConcreteRequest<=1; AddConcreteRequest++)		{

			String ConcreteName = 	ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest) ;

			Waitfortheelement("ConcreteRequest.CreateNew", ConcreteRequestLocators);

			Wait(3000);

			Click("ConcreteRequest.CreateNew", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Create new concrete calendar button is clicked");
			Print("Create new button is clicked");

			Wait(3000);
			Wait<WebDriver> Description = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Description.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@formcontrolname='description']")); 
				}
			});

			TypeDataInTheField("ConcreteRequest.Description", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Description is entered as : " + ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest));
			Print("Description is entered as : " + ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Location", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Location is entered as : " + ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));
			Print("Location is entered as : " + ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));

			Wait(1000);
			ClickEnter();

			Wait(1000);
			Clear("ConcreteRequest.SelectDate", ConcreteRequestLocators);
			String InvalidDate = "02/25/2021" ;
			TypeDataInTheField("ConcreteRequest.SelectDate", ConcreteRequestLocators, InvalidDate);
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"SelectDate is entered as : " + InvalidDate);
			Print("SelectDate is entered as : " + InvalidDate);


			Wait(2000);
			TypeDataInTheField("ConcreteRequest.MixDesign", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"MixDesign is entered as : " + ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));
			Print("MixDesign is entered as : " + ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));

			Wait(2000);
			ClickEnter();
			Wait(1000);

			TypeDataInTheField("ConcreteRequest.OrderNumber", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"OrderNumber is entered as : " + ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));
			Print("OrderNumber is entered as : " + ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Slump", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Slump is entered as : " + ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));
			Print("Slump is entered as : " + ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.TruckSpacingHours", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"TruckSpacingHours is entered as : " + ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));
			Print("TruckSpacingHours is entered as : " + ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.QuantityOrdered", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"QuantityOrdered is entered as : " + ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));
			Print("QuantityOrdered is entered as : " + ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Primer", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Primer is entered as : " + ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));
			Print("Primer is entered as : " + ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Notes", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Primer is entered as : " + ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));
			Print("Primer is entered as : " + ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));

			Wait(2000);

			Click("ConcreteRequest.Submit", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Submit button is clicked");
			Print("Submit button is clicked");

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
			String InvalidStartDate =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(InvalidStartDate, "Please Enter Future Date")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				PrintError(InvalidStartDate);
				ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,InvalidStartDate);

			}
			else {
				Print("Request added is : " + ConcreteName);
				ReportConfig.Givenlogfail("User add new Concrete request with invalid date and time" ,"Request added is : " + ConcreteName);

				String IssueSummary =  "Concrete Request added with invalid date";
				String Storydescription = "Concrete Request added" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

			Clear("ConcreteRequest.SelectDate", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.SelectDate", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"SelectDate is entered as : " + ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));
			Print("SelectDate is entered as : " + ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.FromHH", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.FromHH", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 5, ReadFrom.ConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"FromHH is entered as : " + ReadFrom.Excel(AddConcreteRequest, 5, ReadFrom.ConcreteRequest));
			Print("FromHH is entered as : " + ReadFrom.Excel(AddConcreteRequest, 5, ReadFrom.ConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.FromMM", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.FromMM", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 6, ReadFrom.ConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"FromMM is entered as : " + ReadFrom.Excel(AddConcreteRequest, 6, ReadFrom.ConcreteRequest));
			Print("FromMM is entered as : " + ReadFrom.Excel(AddConcreteRequest, 6, ReadFrom.ConcreteRequest));

			Wait(2000);
			String FromMeridian = ReadFrom.Excel(AddConcreteRequest, 7, ReadFrom.ConcreteRequest);

			String Meridian = GetText("ConcreteRequest.FromMeridian", ConcreteRequestLocators);
			Print(Meridian);
			if(IsEqual(Meridian, FromMeridian)) {


			}
			else {
				Click("ConcreteRequest.FromMeridian", ConcreteRequestLocators);
			}

			Wait(2000);
			Clear("ConcreteRequest.ToHH", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.ToHH", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 8, ReadFrom.ConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"ToHH is entered as : " + ReadFrom.Excel(AddConcreteRequest, 8, ReadFrom.ConcreteRequest));
			Print("ToHH is entered as : " + ReadFrom.Excel(AddConcreteRequest, 8, ReadFrom.ConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.ToMM", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.ToMM", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 9, ReadFrom.ConcreteRequest));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"ToMM is entered as : " + ReadFrom.Excel(AddConcreteRequest, 9, ReadFrom.ConcreteRequest));
			Print("ToMM is entered as : " + ReadFrom.Excel(AddConcreteRequest, 9, ReadFrom.ConcreteRequest));

			Wait(2000);
			String ToMeridian = ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.ConcreteRequest);

			String ToMeridian2 = GetText("ConcreteRequest.ToMeridian", ConcreteRequestLocators);
			Print(ToMeridian2);
			if(IsEqual(ToMeridian2, ToMeridian)) {


			}
			else {
				Click("ConcreteRequest.ToMeridian", ConcreteRequestLocators);
			}


			Click("ConcreteRequest.Submit", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Submit button is clicked");
			Print("Submit button is clicked");

			String InvalidTime =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(InvalidTime, "Please Enter Start time Lesser than End time")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				PrintError(InvalidTime);
				ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,InvalidTime);
				Wait(2000);
				Click("ConcreteRequest.CancelButton", ConcreteRequestLocators);
				ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time","Cancel button is clicked");
				Wait(2000);
				Click("ConcreteRequest.YesButton", ConcreteRequestLocators);
				Print("Close button is clicked");
				ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time","Yes button is clicked");

			}
			else {
				Print("Request added is : " + ConcreteName);
				ReportConfig.Givenlogfail("User add new Concrete request with invalid date and time" ,"Request added is : " + ConcreteName);

				String IssueSummary =  "Concrete Request added accpets invalid time";
				String Storydescription = "Concrete Request added with invalid time" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}


		}

	}

	public static void InvalidFile() throws Throwable {


		PrintError("InvalidFile Concrete calendar request info started");

		ReadFrom.DynamicExcel(ReadFrom.ConcreteRequest);

		for(int ConcreteRequest =1; ConcreteRequest<=1; ConcreteRequest++)	{

			Wait(2000);

			String ConcreteName = 	ReadFrom.Excel(ConcreteRequest, 2, ReadFrom.ConcreteRequest) ;
			WebElement ConcreteRequestName = 	FindElement(ReadFrom.Excel(ConcreteRequest, 2, ReadFrom.ConcreteRequest));

			Click(ConcreteRequestName);

			ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" , ConcreteName + " : is clicked");
			Print(ConcreteName + " : is clicked");

			Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			CompanyInFilter.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//h4[normalize-space()='Responsible Person']")); 
				}
			});

			Wait(2000);
			JsClick("ConcreteRequest.Attachments", ConcreteRequestLocators);

			if(IsElementDisplayed("ConcreteRequest.Attachments", ConcreteRequestLocators)) {
				PrintError("Attachment started");

				Wait(2000);
				String upload = ReadFrom.InvalidFile;
				String filePath = System.getProperty("user.dir")+ upload;

				WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
				Wait(3000);
				file.sendKeys(filePath);

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
				String AttachmentsUploaded =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
				if(IfContains(AttachmentsUploaded, "Please select a valid file")) {
					Click("ConcreteRequest.Toast", ConcreteRequestLocators);
					Print("Invalid file is not accepted");
					ReportConfig.Givenlogpass("User add invalid file in Concrete request" ,"Invalid file is not accepted");

				}
				else {
					Print("Invalid file is added as an attachment");
					ReportConfig.Givenlogfail("User add invalid file in Concrete request" ,"Invalid file is added as an attachment");

					String IssueSummary =  AttachmentsUploaded;
					String Storydescription = "Invalid file is added as an attachment" ;
					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
				}

			}

			Wait(2000);
			JsClick("ConcreteRequest.ClosePopup", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("User add invalid file in Concrete request" ,"Close popup button is clicked");
			Print("Close popup button is clicked");

		}
	}

	public static void DeleteConcreteRequest() throws Throwable {


		PrintError("Delete concrete request Started");

		ReadFrom.DynamicExcel(ReadFrom.DeleteConcreteRequest);

		for(int DeleteConcreteRequest =1; DeleteConcreteRequest<=ReadFrom.rowcount; DeleteConcreteRequest++)	{

			Wait(2000);

			String ConcreteName = 	ReadFrom.Excel(DeleteConcreteRequest, 0, ReadFrom.DeleteConcreteRequest) ;
			WebElement DeleteRequest = 	DeleteElement(ReadFrom.Excel(DeleteConcreteRequest, 0, ReadFrom.DeleteConcreteRequest));
			Click(DeleteRequest);
			ReportConfig.PassedLogInfo("User delete Concrete request", "Delete button is clicked");
			Print("Delete button is clicked");
			Wait(2000);

			Click("ConcreteRequest.YesButton", ConcreteRequestLocators);

			ReportConfig.PassedLogInfo("User delete Concrete request", "Yes delete button is clicked");
			Print("Yes delete button is clicked");

			Wait<WebDriver> Delete = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			Delete.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']")); 
				}
			});

			String DeletePopup =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(DeletePopup, "Concrete Request Deleted Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Request deleted is : " + ConcreteName);
				ReportConfig.Givenlogpass("User delete Concrete request" ,"Request deleted is : " + ConcreteName);

			}
			else {
				Print("Delete concrete request failed");
				ReportConfig.Givenlogfail("User delete Concrete request" ,"Delete concrete request failed");

				String IssueSummary =  DeletePopup;
				String Storydescription = "Delete concrete request failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

		}
	}

}
