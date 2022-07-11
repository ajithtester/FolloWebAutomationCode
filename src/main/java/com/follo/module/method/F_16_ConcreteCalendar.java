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

public class F_16_ConcreteCalendar extends Baseclass {
	public static List<WebElement> ConcreteRequestList ;

	public static void AddConcreteRequest() throws Throwable {

		PrintError("Add concrete calendar request Started");
		ReadFrom.DynamicExcel(ReadFrom.AddConcreteCalendar);
		for(int AddConcreteCalendar =1; AddConcreteCalendar<=ReadFrom.rowcount; AddConcreteCalendar++)		{

			String ConcreteName = 	ReadFrom.Excel(AddConcreteCalendar, 0, ReadFrom.AddConcreteCalendar) ;

			Waitfortheelement("Concrete.Add", ConcreteCalendarLocators);

			Wait(3000);

			Click("Concrete.Add", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Click on Add new button");
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


			TypeDataInTheField("Concrete.Description", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 0, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered Description : " + ReadFrom.Excel(AddConcreteCalendar, 0, ReadFrom.AddConcreteCalendar));
			Print("Entered Description : " + ReadFrom.Excel(AddConcreteCalendar, 0, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.Location", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 1, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered Location : " + ReadFrom.Excel(AddConcreteCalendar, 1, ReadFrom.AddConcreteCalendar));
			Print("Entered Location : " + ReadFrom.Excel(AddConcreteCalendar, 1, ReadFrom.AddConcreteCalendar));

			Wait(1000);

			ClickEnter();
			Wait(1000);
			Clear("Concrete.SelectDate", ConcreteCalendarLocators);

			TypeDataInTheField("Concrete.SelectDate", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 2, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered SelectDate : " + ReadFrom.Excel(AddConcreteCalendar, 2, ReadFrom.AddConcreteCalendar));
			Print("Entered SelectDate : " + ReadFrom.Excel(AddConcreteCalendar, 2, ReadFrom.AddConcreteCalendar));

			Wait(2000);
			Clear("Concrete.FromHH", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.FromHH", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 3, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered FromHH : " + ReadFrom.Excel(AddConcreteCalendar, 3, ReadFrom.AddConcreteCalendar));
			Print("Entered FromHH : " + ReadFrom.Excel(AddConcreteCalendar, 3, ReadFrom.AddConcreteCalendar));

			Wait(2000);
			Clear("Concrete.FromMM", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.FromMM", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 4, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered FromMM : " + ReadFrom.Excel(AddConcreteCalendar, 4, ReadFrom.AddConcreteCalendar));
			Print("Entered FromMM : " + ReadFrom.Excel(AddConcreteCalendar, 4, ReadFrom.AddConcreteCalendar));

			Wait(2000);
			String FromMeridian = ReadFrom.Excel(AddConcreteCalendar, 5, ReadFrom.AddConcreteCalendar);

			String Meridian = GetText("Concrete.FromMeridian", ConcreteCalendarLocators);
			Print(Meridian);
			if(IsEqual(Meridian, FromMeridian)) {


			}
			else {
				Click("Concrete.FromMeridian", ConcreteCalendarLocators);
			}

			Wait(2000);
			Clear("Concrete.ToHH", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.ToHH", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 6, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered ToHH : " + ReadFrom.Excel(AddConcreteCalendar, 6, ReadFrom.AddConcreteCalendar));
			Print("Entered ToHH : " + ReadFrom.Excel(AddConcreteCalendar, 6, ReadFrom.AddConcreteCalendar));

			Wait(2000);
			Clear("Concrete.ToMM", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.ToMM", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 7, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered ToMM : " + ReadFrom.Excel(AddConcreteCalendar, 7, ReadFrom.AddConcreteCalendar));
			Print("Entered ToMM : " + ReadFrom.Excel(AddConcreteCalendar, 7, ReadFrom.AddConcreteCalendar));

			Wait(2000);
			String ToMeridian = ReadFrom.Excel(AddConcreteCalendar, 8, ReadFrom.AddConcreteCalendar);

			String ToMeridian2 = GetText("Concrete.ToMeridian", ConcreteCalendarLocators);
			Print(ToMeridian2);
			if(IsEqual(ToMeridian2, ToMeridian)) {


			}
			else {
				Click("Concrete.ToMeridian", ConcreteCalendarLocators);
			}

			Wait(2000);
			//			Click("Concrete.Dropdown", ConcreteCalendarLocators);
			//			Wait(2000);
			//			WebElement Dropdown = 	FindElement(ReadFrom.Excel(AddConcreteCalendar, 9, ReadFrom.AddConcreteCalendar));
			//			Click(Dropdown);

			Wait(2000);
			TypeDataInTheField("Concrete.MixDesign", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered MixDesign : " + ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.AddConcreteCalendar));
			Print("Entered MixDesign : " + ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.AddConcreteCalendar));

			Wait(2000);
			ClickEnter();
			Wait(1000);

			TypeDataInTheField("Concrete.OrderNumber", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered OrderNumber : " + ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.AddConcreteCalendar));
			Print("Entered OrderNumber : " + ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.Slump", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 12, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered Slump : " + ReadFrom.Excel(AddConcreteCalendar, 12, ReadFrom.AddConcreteCalendar));
			Print("Entered Slump : " + ReadFrom.Excel(AddConcreteCalendar, 12, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.TruckSpacingHours", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 13, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered TruckSpacingHours : " + ReadFrom.Excel(AddConcreteCalendar, 13, ReadFrom.AddConcreteCalendar));
			Print("Entered TruckSpacingHours : " + ReadFrom.Excel(AddConcreteCalendar, 13, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.QuantityOrdered", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 14, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered QuantityOrdered : " + ReadFrom.Excel(AddConcreteCalendar, 14, ReadFrom.AddConcreteCalendar));
			Print("Entered QuantityOrdered : " + ReadFrom.Excel(AddConcreteCalendar, 14, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.Primer", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 15, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered Primer : " + ReadFrom.Excel(AddConcreteCalendar, 15, ReadFrom.AddConcreteCalendar));
			Print("Entered Primer : " + ReadFrom.Excel(AddConcreteCalendar, 15, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.Notes", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 17, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered Primer : " + ReadFrom.Excel(AddConcreteCalendar, 17, ReadFrom.AddConcreteCalendar));
			Print("Entered Primer : " + ReadFrom.Excel(AddConcreteCalendar, 17, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			Click("Concrete.Submit", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Click on Submit button");
			Print("Click on Submit button");

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
			String ConcreteRequestAdded =	GetText("Concrete.Toast", ConcreteCalendarLocators);
			if(IfContains(ConcreteRequestAdded, "Concrete Request Created Successfully")) {
				Click("Concrete.Toast", ConcreteCalendarLocators);
				Print("Request added is : " + ConcreteName);
				ReportConfig.Givenlogpass("User add new Concrete request","Request added is : " + ConcreteName);

			}
			else {
				Print("Add Concrete Request failed");
				ReportConfig.Givenlogfail("User add new Concrete request","Add Concrete Request failed");

				String IssueSummary =  ConcreteRequestAdded;
				String Storydescription = "Add Concrete Request failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}
		}

	}


	public static void SearchConcreteRequest() throws Throwable {

		PrintError("Search concrete calendar started");
		ReadFrom.DynamicExcel(ReadFrom.ConcreteCalendar);

		for(int ConcreteCalendar =1; ConcreteCalendar<=ReadFrom.rowcount; ConcreteCalendar++)	{


			SearchMonth(ConcreteCalendar, ReadFrom.ConcreteCalendar);
			SearchYear(ConcreteCalendar, ReadFrom.ConcreteCalendar);

			Wait(3000);

			Wait<WebDriver> SearchIcon = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			SearchIcon.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//*[@id='calendar']/div[1]/div[2]/div/h2"));
				}
			});

			Wait(5000);
			Click("Concrete.SearchIcon", ConcreteCalendarLocators);
			Wait(2000);

			TypeDataInTheField("Concrete.SearchField", ConcreteCalendarLocators, ReadFrom.Excel(ConcreteCalendar, 2, ReadFrom.ConcreteCalendar));
			ReportConfig.Givenlogpass("User search the Concrete request" ,"Searched value : "+ ReadFrom.Excel(ConcreteCalendar, 2, ReadFrom.ConcreteCalendar));
			Print("Searched value : "+ ReadFrom.Excel(ConcreteCalendar, 2, ReadFrom.ConcreteCalendar));

			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});


			List<WebElement> c = 		getElements("Concrete.ConcreteRequest", ConcreteCalendarLocators);
			for (WebElement webElement : c) {
				String ConcreteRequestName = 	GetTextFromTheElement(webElement);

				String Excelvalue = 	ReadFrom.Excel(ConcreteCalendar, 2, ReadFrom.ConcreteCalendar);
				if(IsEqual(Excelvalue, ConcreteRequestName)) {
					Print("Displayed value is : " + ConcreteRequestName );
					ReportConfig.Givenlogpass("User search the Concrete request" ,"Displayed value is : " + ConcreteRequestName );
				}
				else
				{
					PrintError("Searched value is : " + ReadFrom.Excel(ConcreteCalendar, 2, ReadFrom.ConcreteCalendar) + "but displayed value is : " + ConcreteRequestName );
//					ReportConfig.FailedLogInfo("User search the Concrete request" ,"Searched value is : " + ReadFrom.Excel(ConcreteCalendar, 2, ReadFrom.ConcreteCalendar) + "but displayed value is : " + ConcreteRequestName );
//					String IssueSummary = "Searched value is : " + ReadFrom.Excel(ConcreteCalendar, 2, ReadFrom.ConcreteCalendar) + "but displayed value is : " + ConcreteRequestName ;
//					String Storydescription = "Search delivery" ;
//					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				}

			}

			Wait(5000);
			Clear("Concrete.SearchField", ConcreteCalendarLocators);
			Wait(3000);
			JsClick("Concrete.CloseSearch", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("Search concrete calendar request" ,"Click on clear search button");
			Print("Click on clear search button");


		}
	}


	public static void FilterConcreteRequest() throws Throwable {
		PrintError("Filter Concrete request calendar started");
		ReadFrom.DynamicExcel(ReadFrom.ConcreteCalendar);


		for(int FilterConcreteRequest =1; FilterConcreteRequest<=ReadFrom.rowcount; FilterConcreteRequest++)	{

			SearchMonth(FilterConcreteRequest, ReadFrom.ConcreteCalendar);
			SearchYear(FilterConcreteRequest, ReadFrom.ConcreteCalendar);

			JsClick("Concrete.FilterIcon", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User filter the Concrete request in calendar", "Click on Filter icon");
			Print("Click on Filter icon");


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
			TypeDataInTheField("Concrete.FilterDescription", ConcreteCalendarLocators, ReadFrom.Excel(FilterConcreteRequest, 6, ReadFrom.ConcreteCalendar));

			ReportConfig.Givenlogpass("User filter the Concrete request in calendar" , "Entered value:" + ReadFrom.Excel(FilterConcreteRequest, 6, ReadFrom.ConcreteCalendar));
			Print("Entered value:" + ReadFrom.Excel(FilterConcreteRequest, 6, ReadFrom.ConcreteCalendar));

			Wait(2000);

			JsClick("Concrete.FilterApply", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User filter the Concrete request in calendar", "Click on Apply button");
			Print("Click on Apply button");

			try {
				Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait111.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				Wait(7000);

				ConcreteRequestList = 	getElements("Concrete.ConcreteRequest", ConcreteCalendarLocators);

			}
			catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if(IsElementDisplayed("Concrete.ConcreteRequest", ConcreteCalendarLocators)) {
					for (WebElement webElement : ConcreteRequestList) {
						String ConcreteRequestListName = 	GetTextFromTheElement(webElement);

						Print("Displayed value is : " + ConcreteRequestListName);
						ReportConfig.Givenlogpass("User filter the Concrete request in calendar","Displayed value is : " + ConcreteRequestListName);
					}
				}
				else
				{
					PrintError("No request is available");
					ReportConfig.Givenlogfail("User filter the Concrete request in calendar","Displayed value is : " + "No request is available");
				}

			}
			catch (Exception e) {
				// TODO: handle exception
			}

			Wait(2000);
			JsClick("Concrete.FilterIcon", ConcreteCalendarLocators);
			Wait(2000);
			JsClick("Concrete.FilterReset", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User filter the Concrete request in calendar" ,"Click on Reset button");
			Print("Click on Reset button");
		}

	}


	public static void ConcreteCalendarInfo() throws Throwable {
		PrintError("Concrete calendar request info started");

		ReadFrom.DynamicExcel(ReadFrom.ConcreteCalendar);

		for(int ConcreteCalendar =1; ConcreteCalendar<=ReadFrom.rowcount; ConcreteCalendar++)	{


			SearchMonth(ConcreteCalendar, ReadFrom.ConcreteCalendar);
			SearchYear(ConcreteCalendar, ReadFrom.ConcreteCalendar);

			Wait(3000);
			Click("Concrete.SearchIcon", ConcreteCalendarLocators);
			Wait(2000);
			TypeDataInTheField("Concrete.SearchField", ConcreteCalendarLocators, ReadFrom.Excel(ConcreteCalendar, 4, ReadFrom.ConcreteCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});


			String ConcreteName = 	ReadFrom.Excel(ConcreteCalendar, 4, ReadFrom.ConcreteCalendar) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(ConcreteCalendar, 4, ReadFrom.ConcreteCalendar));

			Click(ConcreteRequest);

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
			if(IsElementDisplayed("Concrete.ResponsiblePerson", ConcreteCalendarLocators)) {
				Print(ConcreteName + " : request info is viewed");
				ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,ConcreteName + " : request info is viewed");
			}

			Wait(2000);
			JsClick("Concrete.Attachments", ConcreteCalendarLocators);

			if(IsElementDisplayed("Concrete.Attachments", ConcreteCalendarLocators)) {
				PrintError("Attachment started");

				Wait(2000);
				String upload = ReadFrom.SampleAttachmentPNG;
				String filePath = System.getProperty("user.dir")+ upload;

				WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
				Wait(3000);
				file.sendKeys(filePath);
				Wait(3000);
				JsClick("Concrete.Done", ConcreteCalendarLocators);
				Print("Click on Done button");
				ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Click on Done button");


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
				String AttachmentsUploaded =	GetText("Concrete.Toast", ConcreteCalendarLocators);
				if(IfContains(AttachmentsUploaded, "Uploaded Successfully.")) {
					Click("Concrete.Toast", ConcreteCalendarLocators);
					Print("Attachments added to the request : " + ConcreteName);
					ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Attachment added to the request : " + ConcreteName);

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
			JsClick("Concrete.Comments", ConcreteCalendarLocators);

			if(IsElementDisplayed("Concrete.AddComments", ConcreteCalendarLocators)) {

				PrintError("Add comment started");

				TypeDataInTheField("Concrete.AddComments", ConcreteCalendarLocators, ReadFrom.Excel(ConcreteCalendar, 3, ReadFrom.ConcreteCalendar));
				ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered Comment : " + ReadFrom.Excel(ConcreteCalendar, 3, ReadFrom.ConcreteCalendar));
				Print("Entered Comment : " + ReadFrom.Excel(ConcreteCalendar, 3, ReadFrom.ConcreteCalendar));

				Wait(2000);
				JsClick("Concrete.Submit", ConcreteCalendarLocators);
				Print("Click on Submit button");
				ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Click on Submit button");


				Wait<WebDriver> AddComment = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				AddComment.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@id='toast-container']")); 
					}
				});


				String CommentAdded =	GetText("Concrete.Toast", ConcreteCalendarLocators);
				if(IfContains(CommentAdded, "Concrete Request Comment added successfully")) {
					Click("Concrete.Toast", ConcreteCalendarLocators);
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
			JsClick("Concrete.History", ConcreteCalendarLocators);
			Wait(3000);
			Waitfortheelement("Concrete.HistoryViewed", ConcreteCalendarLocators);
			if(IsElementDisplayed("Concrete.HistoryViewed", ConcreteCalendarLocators)) 
			{
				PrintError("View history started");

				List<WebElement> History = 	getElements("Concrete.HistoryViewed", ConcreteCalendarLocators);

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
			JsClick("Concrete.ClosePopup", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("To view info and history, add comment, add attachment to the Concrete request" ,"Click on Close popup button");
			Print("Click on Close popup button");

			Wait(2000);
			JsClick("Concrete.CloseSearch", ConcreteCalendarLocators);

			//}
		}
	}

	public static void EditConcreteRequest() throws Throwable {

		PrintError("Edit concrete calendar request started");

		ReadFrom.DynamicExcel(ReadFrom.ConcreteCalendar);

		for(int EditConcreteCalendar =1; EditConcreteCalendar<=ReadFrom.rowcount; EditConcreteCalendar++)	{


			SearchMonth(EditConcreteCalendar, ReadFrom.ConcreteCalendar);
			SearchYear(EditConcreteCalendar, ReadFrom.ConcreteCalendar);

			Wait(3000);
			Click("Concrete.SearchIcon", ConcreteCalendarLocators);
			Wait(2000);
			TypeDataInTheField("Concrete.SearchField", ConcreteCalendarLocators, ReadFrom.Excel(EditConcreteCalendar, 2, ReadFrom.ConcreteCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			String ConcreteName = 	ReadFrom.Excel(EditConcreteCalendar, 2, ReadFrom.ConcreteCalendar) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(EditConcreteCalendar, 2, ReadFrom.ConcreteCalendar));

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
			if(IsElementDisplayed("Concrete.ResponsiblePerson", ConcreteCalendarLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,ConcreteName + " : is opened");
			}

			Wait(2000);

			MoveToElement("Concrete.EditButton", ConcreteCalendarLocators);
			Wait(2000);
			Click("Concrete.EditButton", ConcreteCalendarLocators);

			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Click on Edit button");
			Print("Click on Edit button");

			Wait<WebDriver> description = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			description.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@formcontrolname='description']")); 
				}
			});
			Clear("Concrete.Description", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.Description", ConcreteCalendarLocators, ReadFrom.Excel(EditConcreteCalendar, 4, ReadFrom.ConcreteCalendar));
			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Edited Description is : " + ReadFrom.Excel(EditConcreteCalendar, 4, ReadFrom.ConcreteCalendar));
			Print("Edited Description is : " + ReadFrom.Excel(EditConcreteCalendar, 4, ReadFrom.ConcreteCalendar));

			Clear("Concrete.QuantityOrdered", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.QuantityOrdered", ConcreteCalendarLocators, ReadFrom.Excel(EditConcreteCalendar, 5, ReadFrom.ConcreteCalendar));
			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Edited Quantity ordered is : " + ReadFrom.Excel(EditConcreteCalendar, 5, ReadFrom.ConcreteCalendar));
			Print("Edited Quantity ordered is : " + ReadFrom.Excel(EditConcreteCalendar, 5, ReadFrom.ConcreteCalendar));

			Wait(2000);

			Click("Concrete.Submit", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User edit a Concrete request from the calendar" ,"Click on Submit button");
			Print("Click on Submit button");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String RequestUpdated =	GetText("Concrete.Toast", ConcreteCalendarLocators);
			if(IfContains(RequestUpdated, "Concrete Request Updated Successfully")) {
				Click("Concrete.Toast", ConcreteCalendarLocators);
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

			Wait(5000);
			Clear("Concrete.SearchField", ConcreteCalendarLocators);
			Wait(3000);
			JsClick("Concrete.CloseSearch", ConcreteCalendarLocators);


		}
	}

	public static void VoidConcreteRequest() throws Throwable {


		PrintError("Void concrete request started");

		ReadFrom.DynamicExcel(ReadFrom.VoidConcreteCalendar);

		for(int VoidConcreteCalendar =1; VoidConcreteCalendar<=ReadFrom.rowcount; VoidConcreteCalendar++)	{


			SearchMonth(VoidConcreteCalendar, ReadFrom.VoidConcreteCalendar);
			SearchYear(VoidConcreteCalendar, ReadFrom.VoidConcreteCalendar);

			Wait(3000);
			Click("Concrete.SearchIcon", ConcreteCalendarLocators);
			Wait(2000);
			TypeDataInTheField("Concrete.SearchField", ConcreteCalendarLocators, ReadFrom.Excel(VoidConcreteCalendar, 2, ReadFrom.VoidConcreteCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			String ConcreteName = 	ReadFrom.Excel(VoidConcreteCalendar, 2, ReadFrom.VoidConcreteCalendar) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(VoidConcreteCalendar, 2, ReadFrom.VoidConcreteCalendar));

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
			if(IsElementDisplayed("Concrete.ResponsiblePerson", ConcreteCalendarLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User push a Concrete request from the calendar" ,ConcreteName + " : is opened");
			}

			Wait(2000);

			MoveToElement("Concrete.VoidButton", ConcreteCalendarLocators);
			Wait(2000);
			Click("Concrete.VoidButton", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User push a Concrete request from the calendar" ,"Click on Void button");
			Print("Click on Void button");

			Click("Concrete.YesButton", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User push a Concrete request from the calendar" ,"Click on Yes button");
			Print("Click on Yes button");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String Void =	GetText("Concrete.Toast", ConcreteCalendarLocators);
			if(IfContains(Void, "Concrete Request Marked as Void Successfully")) {
				Click("Concrete.Toast", ConcreteCalendarLocators);
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

			Wait(5000);
			Clear("Concrete.SearchField", ConcreteCalendarLocators);
			Wait(3000);
			JsClick("Concrete.CloseSearch", ConcreteCalendarLocators);


		}

	}

	public static void ApproveAndComplete() throws Throwable {

		PrintError("Approve and complete concrete request started");

		ReadFrom.DynamicExcel(ReadFrom.ApproveCompleteConcrete);

		for(int ApproveAndComplete =1; ApproveAndComplete<=ReadFrom.rowcount; ApproveAndComplete++)	{


			SearchMonth(ApproveAndComplete, ReadFrom.ApproveCompleteConcrete);
			SearchYear(ApproveAndComplete, ReadFrom.ApproveCompleteConcrete);

			Wait(3000);
			Click("Concrete.SearchIcon", ConcreteCalendarLocators);
			Wait(2000);
			TypeDataInTheField("Concrete.SearchField", ConcreteCalendarLocators, ReadFrom.Excel(ApproveAndComplete, 2, ReadFrom.ApproveCompleteConcrete));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			String ConcreteName = 	ReadFrom.Excel(ApproveAndComplete, 2, ReadFrom.ApproveCompleteConcrete) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(ApproveAndComplete, 2, ReadFrom.ApproveCompleteConcrete));

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
			if(IsElementDisplayed("Concrete.ResponsiblePerson", ConcreteCalendarLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,ConcreteName + " : is opened");
			}

			Wait(2000);

			MoveToElement("Concrete.EditButton", ConcreteCalendarLocators);
			Wait(2000);
			Click("Concrete.EditButton", ConcreteCalendarLocators);

			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Click on Edit button");
			Print("Click on Edit button");

			Wait<WebDriver> description = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			description.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@formcontrolname='description']")); 
				}
			});

			MoveToElement("Concrete.ConcreteConfirmed", ConcreteCalendarLocators);
			Wait(2000);
			Click("Concrete.ConcreteConfirmed", ConcreteCalendarLocators);
			Wait(2000);

			Click("Concrete.Submit", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Click on Submit button");
			Print("Click on Submit button");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String RequestUpdated =	GetText("Concrete.Toast", ConcreteCalendarLocators);
			if(IfContains(RequestUpdated, "Concrete Request Updated Successfully")) {
				Click("Concrete.Toast", ConcreteCalendarLocators);
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
//						Refresh();
//						
//						SearchMonth(ApproveAndComplete, ReadFrom.ApproveCompleteConcrete);
//						SearchYear(ApproveAndComplete, ReadFrom.ApproveCompleteConcrete);
//						
//						
//						Wait(3000);
//						Click("Concrete.SearchIcon", ConcreteCalendarLocators);
//						Wait(2000);
//						TypeDataInTheField("Concrete.SearchField", ConcreteCalendarLocators, ReadFrom.Excel(ApproveAndComplete, 2, ReadFrom.ApproveCompleteConcrete));
//						Wait(7000);


			Wait<WebDriver> Request = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			Request.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			WebElement CompleteRequest = 	FindElement(ReadFrom.Excel(ApproveAndComplete, 2, ReadFrom.ApproveCompleteConcrete));

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
			if(IsElementDisplayed("Concrete.ResponsiblePerson", ConcreteCalendarLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,ConcreteName + " : is opened");
			}

			MoveToElement("Concrete.MarkComplete", ConcreteCalendarLocators);
			Wait(2000);
			Click("Concrete.MarkComplete", ConcreteCalendarLocators);
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


			SelectFromDropdown("Concrete.HoursToComplete", ConcreteCalendarLocators, ReadFrom.Excel(ApproveAndComplete, 3, ReadFrom.ApproveCompleteConcrete));
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Entered Hours To Complete : " + ReadFrom.Excel(ApproveAndComplete, 3, ReadFrom.ApproveCompleteConcrete));
			Print("Entered Hours To Complete : " + ReadFrom.Excel(ApproveAndComplete, 3, ReadFrom.ApproveCompleteConcrete));
			Wait(2000);

			SelectFromDropdown("Concrete.MinutesToComplete", ConcreteCalendarLocators, ReadFrom.Excel(ApproveAndComplete, 4, ReadFrom.ApproveCompleteConcrete));
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Entered Minutes To Complete : " + ReadFrom.Excel(ApproveAndComplete, 4, ReadFrom.ApproveCompleteConcrete));
			Print("Entered Minutes To Complete : " + ReadFrom.Excel(ApproveAndComplete, 4, ReadFrom.ApproveCompleteConcrete));
			Wait(2000);

			TypeDataInTheField("Concrete.TotalCubic", ConcreteCalendarLocators, ReadFrom.Excel(ApproveAndComplete, 5, ReadFrom.ApproveCompleteConcrete));
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Entered Total Cubic : " + ReadFrom.Excel(ApproveAndComplete, 5, ReadFrom.ApproveCompleteConcrete));
			Print("Entered Total Cubic : " + ReadFrom.Excel(ApproveAndComplete, 5, ReadFrom.ApproveCompleteConcrete));
			Wait(2000);

			JsClick("Concrete.SubmitComplete", ConcreteCalendarLocators);

			Wait<WebDriver> toast = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			toast.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String CompletedSuccessfully =	GetText("Concrete.Toast", ConcreteCalendarLocators);
			if(IfContains(CompletedSuccessfully, "Completed Successfully")) {
				Click("Concrete.Toast", ConcreteCalendarLocators);
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
			JsClick("Concrete.ClosePopup", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User Approve and Complete a concrete request in the calendar" ,"Click on Close popup button");
			Print("Click on Close popup button");


			Wait(5000);
			Clear("Concrete.SearchField", ConcreteCalendarLocators);
			Wait(3000);
			JsClick("Concrete.CloseSearch", ConcreteCalendarLocators);

		}
	}

	public static void AddPump() throws Throwable {

		PrintError("Pump concrete request started");

		ReadFrom.DynamicExcel(ReadFrom.PumpCompleteConcrete);

		for(int PumpConcreteCalendar =1; PumpConcreteCalendar<=ReadFrom.rowcount; PumpConcreteCalendar++)	{


			SearchMonth(PumpConcreteCalendar, ReadFrom.PumpCompleteConcrete);
			SearchYear(PumpConcreteCalendar, ReadFrom.PumpCompleteConcrete);

			Wait(3000);
			Click("Concrete.SearchIcon", ConcreteCalendarLocators);
			Wait(2000);
			TypeDataInTheField("Concrete.SearchField", ConcreteCalendarLocators, ReadFrom.Excel(PumpConcreteCalendar, 2, ReadFrom.PumpCompleteConcrete));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});

			String ConcreteName = 	ReadFrom.Excel(PumpConcreteCalendar, 2, ReadFrom.PumpCompleteConcrete) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(PumpConcreteCalendar, 2, ReadFrom.PumpCompleteConcrete));

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
			if(IsElementDisplayed("Concrete.ResponsiblePerson", ConcreteCalendarLocators)) {
				Print(ConcreteName + " : is opened");
				ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,ConcreteName + " : is opened");
			}

			Wait(2000);

			MoveToElement("Concrete.EditButton", ConcreteCalendarLocators);
			Wait(2000);
			Click("Concrete.EditButton", ConcreteCalendarLocators);

			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Click on Edit button");
			Print("Click on Edit button");

			Wait<WebDriver> description = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			description.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@formcontrolname='description']")); 
				}
			});

			MoveToElement("Concrete.PumpRequired", ConcreteCalendarLocators);
			Wait(2000);
			Click("Concrete.PumpRequired", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Pump required button is clicked");
			Print("Pump required button is clicked");

			Wait(2000);
			MoveToElement("Concrete.Submit", ConcreteCalendarLocators);
			Wait(5000);

			Clear("Concrete.PumpOrdered", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.PumpOrdered", ConcreteCalendarLocators, ReadFrom.Excel(PumpConcreteCalendar, 4, ReadFrom.PumpCompleteConcrete));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Entered Pump ordered : " + ReadFrom.Excel(PumpConcreteCalendar, 4, ReadFrom.PumpCompleteConcrete));
			Print("Entered Pump ordered : " + ReadFrom.Excel(PumpConcreteCalendar, 4, ReadFrom.PumpCompleteConcrete));

			Wait(2000);

			TypeDataInTheField("Concrete.PumpLocation", ConcreteCalendarLocators, ReadFrom.Excel(PumpConcreteCalendar, 5, ReadFrom.PumpCompleteConcrete));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Entered Location : " + ReadFrom.Excel(PumpConcreteCalendar, 5, ReadFrom.PumpCompleteConcrete));
			Print("Entered Location : " + ReadFrom.Excel(PumpConcreteCalendar, 5, ReadFrom.PumpCompleteConcrete));

			Wait(2000);
			Clear("Concrete.PumpFromHH", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.PumpFromHH", ConcreteCalendarLocators, ReadFrom.Excel(PumpConcreteCalendar, 6, ReadFrom.PumpCompleteConcrete));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Entered FromHH : " + ReadFrom.Excel(PumpConcreteCalendar, 6, ReadFrom.PumpCompleteConcrete));
			Print("Entered FromHH : " + ReadFrom.Excel(PumpConcreteCalendar, 6, ReadFrom.PumpCompleteConcrete));

			Wait(2000);
			Clear("Concrete.PumpFromMM", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.PumpFromMM", ConcreteCalendarLocators, ReadFrom.Excel(PumpConcreteCalendar, 7, ReadFrom.PumpCompleteConcrete));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Entered FromMM : " + ReadFrom.Excel(PumpConcreteCalendar, 7, ReadFrom.PumpCompleteConcrete));
			Print("Entered FromMM : " + ReadFrom.Excel(PumpConcreteCalendar, 7, ReadFrom.PumpCompleteConcrete));


			Wait(2000);
			String FromMeridian = ReadFrom.Excel(PumpConcreteCalendar, 8, ReadFrom.PumpCompleteConcrete);

			String Meridian = GetText("Concrete.PumpFromMeridian", ConcreteCalendarLocators);

			if(IsEqual(Meridian, FromMeridian)) {


			}
			else {
				Click("Concrete.PumpFromMeridian", ConcreteCalendarLocators);
			}

			Wait(2000);
			Clear("Concrete.PumpToHH", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.PumpToHH", ConcreteCalendarLocators, ReadFrom.Excel(PumpConcreteCalendar, 9, ReadFrom.PumpCompleteConcrete));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Entered ToHH : " + ReadFrom.Excel(PumpConcreteCalendar, 9, ReadFrom.PumpCompleteConcrete));
			Print("Entered ToHH : " + ReadFrom.Excel(PumpConcreteCalendar, 9, ReadFrom.PumpCompleteConcrete));

			Wait(2000);
			Clear("Concrete.PumpToMM", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.PumpToMM", ConcreteCalendarLocators, ReadFrom.Excel(PumpConcreteCalendar, 10, ReadFrom.PumpCompleteConcrete));
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Entered ToMM : " + ReadFrom.Excel(PumpConcreteCalendar, 10, ReadFrom.PumpCompleteConcrete));
			Print("Entered ToMM : " + ReadFrom.Excel(PumpConcreteCalendar, 10, ReadFrom.PumpCompleteConcrete));

			Wait(2000);
			String ToMeridian = ReadFrom.Excel(PumpConcreteCalendar, 11, ReadFrom.PumpCompleteConcrete);

			String ToMeridian2 = GetText("Concrete.PumpToMeridian", ConcreteCalendarLocators);

			if(IsEqual(ToMeridian2, ToMeridian)) {

			}
			else {
				Click("Concrete.PumpToMeridian", ConcreteCalendarLocators);
			}

			Wait(2000);

			String Pumpconfirm =	ReadFrom.Excel(PumpConcreteCalendar, 12, ReadFrom.PumpCompleteConcrete);
			switch(Pumpconfirm) {
			case "Yes" :
				Click("Concrete.PumpConfirmed", ConcreteCalendarLocators);
				ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Pump confirmed is selected");
				Print("Pump confirmed is selected");

			}

			Wait(2000);
			TypeDataInTheField("Concrete.PumpSize", ConcreteCalendarLocators, ReadFrom.Excel(PumpConcreteCalendar, 3, ReadFrom.PumpCompleteConcrete));
			Wait(2000);
			ClickEnter();
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Edited Pump size is : " + ReadFrom.Excel(PumpConcreteCalendar, 3, ReadFrom.PumpCompleteConcrete));
			Print("Edited Pump size is : " + ReadFrom.Excel(PumpConcreteCalendar, 3, ReadFrom.PumpCompleteConcrete));

			Wait(2000);
			MoveToElement("Concrete.Submit", ConcreteCalendarLocators);
			Wait(2000);
			Click("Concrete.Submit", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Click on Submit button");
			Print("Click on Submit button");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']"));
				}
			});

			String RequestUpdated =	GetText("Concrete.Toast", ConcreteCalendarLocators);
			if(IfContains(RequestUpdated, "Concrete Request Updated Successfully")) {
				Click("Concrete.Toast", ConcreteCalendarLocators);
				Print("Pump added to the request : " + ConcreteName);
				ReportConfig.Givenlogpass("User add pump to the concrete request in concrete calendar" ,"Pump added to the request : " + ConcreteName);

			}
			else {
				PrintError("Pump add failed");
				ReportConfig.Givenlogfail("User add pump to the concrete request in concrete calendar" ,"Pump add failed");
				String IssueSummary =  RequestUpdated;
				String Storydescription = "Pump add failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

			Wait(5000);
			Refresh();
			Wait(5000);
//			Clear("Concrete.SearchField", ConcreteCalendarLocators);
//			Wait(3000);
//			JsClick("Concrete.CloseSearch", ConcreteCalendarLocators);


		}
	}

	public static void SearchMonth(int Row , String Excel) throws Throwable {

		Wait(6000);
		String Date = "False";
		while(Date=="False") {
			WebElement CalendarYear = getElement("Concrete.DateAndMonth", ConcreteCalendarLocators);	
			explicitwaitclickable(CalendarYear);
			String CalendarMonth =  GetText("Concrete.DateAndMonth", ConcreteCalendarLocators);		
			String	MonthValue = CalendarMonth.split(" ")[0];

			String Month = ReadFrom.Excel(Row, 0, Excel);

			if(IsEqual(MonthValue, Month) ) {
				Print("Selected month : " + MonthValue);
				ReportConfig.Givenlogpass("Selected month : " , MonthValue);

				Date = "True"; 

			}
			else {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id='calendar']/div[1]/div[2]/div/h2"));
					}
				});
				JsClick("Concrete.NextMonth", ConcreteCalendarLocators);



				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id='calendar']/div[1]/div[2]/div/h2"));
					}
				});
			}
		}
	} 



	public static void SearchYear(int Row , String Excel) throws Throwable {

		Wait(6000);


		String Date = "False";
		while(Date=="False") {

			String CalendarYear =  GetText("Concrete.DateAndMonth", ConcreteCalendarLocators);		

			String	YearValue = CalendarYear.split(" ", 2)[1];
			String Year = ReadFrom.Excel(Row, 1, Excel);

			int i=Integer.parseInt(YearValue);  
			int k=Integer.parseInt(Year);  

			if(IsEqual(Year, YearValue) ) {
				Print("Selected Year : " + YearValue);
				ReportConfig.Givenlogpass("Selected Year : " , YearValue);
				Date = "True"; 
			}

			else if(i>k) {
				Wait(3000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//span[@class='fc-icon fc-icon-chevrons-left']"));
					}
				});

				JsClick("Concrete.PreviousYear", ConcreteCalendarLocators);


				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id='calendar']/div[1]/div[2]/div/h2"));
					}
				});

			}
			else {
				Wait(3000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//span[@class='fc-icon fc-icon-chevrons-right']"));
					}
				});
				//Waitfortheelement("NextYearCalendar", ConcreteCalendarLocators);
				JsClick("Concrete.NextYear", ConcreteCalendarLocators);

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id='calendar']/div[1]/div[2]/div/h2"));
					}
				});
			}
		}
	}

	public static void NegativeMandatory() throws Throwable {

		PrintError("NegativeMandatory Concrete Calender started");
		Wait(2000);
		ReportConfig.Givenlogpass("User add new Concrete request without filling mandatory field","Add button is clicked");
		JsClick("Concrete.Add", ConcreteCalendarLocators);
		Print("Add button is clicked");
		Wait(2000);
		MoveToElement("Concrete.Submit", ConcreteCalendarLocators);
		JsClick("Concrete.Submit", ConcreteCalendarLocators);
		Print("Click on Submit button");
		ReportConfig.Givenlogpass("User add new Concrete request without filling mandatory field","Click on Submit button");

		String DescriptionRequired = 	GetText("Concrete.DescriptionRequired", ConcreteCalendarLocators);
		ReportConfig.Givenlogpass("Description required Error :", DescriptionRequired);
		PrintError(DescriptionRequired);
		Wait(2000);
		MoveToElement("Concrete.Submit", ConcreteCalendarLocators);
		Wait(2000);
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


	 fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//button[normalize-space()='Cancel']"));
			}
		});

		Click("Concrete.CancelButton", ConcreteCalendarLocators);
		ReportConfig.Givenlogpass("User add new Concrete request without filling mandatory field","Click on Cancel button");
		Wait(2000);
		Click("Concrete.YesButton", ConcreteCalendarLocators);
		Print("Close button is clicked");
		ReportConfig.Givenlogpass("User add new Concrete request without filling mandatory field","Click on Yes button");
	}



	public static void AddInviteDateAndTime() throws Throwable {

		PrintError("Invalid date concrete calendar request Started");
		ReadFrom.DynamicExcel(ReadFrom.AddConcreteCalendar);
		for(int AddConcreteCalendar =1; AddConcreteCalendar<=1; AddConcreteCalendar++)		{

			String ConcreteName = 	ReadFrom.Excel(AddConcreteCalendar, 0, ReadFrom.AddConcreteCalendar) ;

			Waitfortheelement("Concrete.Add", ConcreteCalendarLocators);

			Wait(3000);

			Click("Concrete.Add", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Click on Add new button");
			Print("Add new gate button is clicked");

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

			TypeDataInTheField("Concrete.Description", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 0, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered Description : " + ReadFrom.Excel(AddConcreteCalendar, 0, ReadFrom.AddConcreteCalendar));
			Print("Entered Description : " + ReadFrom.Excel(AddConcreteCalendar, 0, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.Location", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 1, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered Location : " + ReadFrom.Excel(AddConcreteCalendar, 1, ReadFrom.AddConcreteCalendar));
			Print("Entered Location : " + ReadFrom.Excel(AddConcreteCalendar, 1, ReadFrom.AddConcreteCalendar));

			Wait(1000);
			ClickEnter();
			
			Wait(1000);
			Clear("Concrete.SelectDate", ConcreteCalendarLocators);
			String InvalidDate = "02/25/2021" ;
			TypeDataInTheField("Concrete.SelectDate", ConcreteCalendarLocators, InvalidDate);
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered SelectDate : " + InvalidDate);
			Print("Entered SelectDate : " + InvalidDate);


			Wait(2000);
			TypeDataInTheField("Concrete.MixDesign", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered MixDesign : " + ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.AddConcreteCalendar));
			Print("Entered MixDesign : " + ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.AddConcreteCalendar));

			Wait(2000);
			ClickEnter();
			Wait(1000);

			TypeDataInTheField("Concrete.OrderNumber", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered OrderNumber : " + ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.AddConcreteCalendar));
			Print("Entered OrderNumber : " + ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.Slump", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 12, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered Slump : " + ReadFrom.Excel(AddConcreteCalendar, 12, ReadFrom.AddConcreteCalendar));
			Print("Entered Slump : " + ReadFrom.Excel(AddConcreteCalendar, 12, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.TruckSpacingHours", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 13, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered TruckSpacingHours : " + ReadFrom.Excel(AddConcreteCalendar, 13, ReadFrom.AddConcreteCalendar));
			Print("Entered TruckSpacingHours : " + ReadFrom.Excel(AddConcreteCalendar, 13, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.QuantityOrdered", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 14, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered QuantityOrdered : " + ReadFrom.Excel(AddConcreteCalendar, 14, ReadFrom.AddConcreteCalendar));
			Print("Entered QuantityOrdered : " + ReadFrom.Excel(AddConcreteCalendar, 14, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.Primer", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 15, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered Primer : " + ReadFrom.Excel(AddConcreteCalendar, 15, ReadFrom.AddConcreteCalendar));
			Print("Entered Primer : " + ReadFrom.Excel(AddConcreteCalendar, 15, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			TypeDataInTheField("Concrete.Notes", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 17, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered Primer : " + ReadFrom.Excel(AddConcreteCalendar, 17, ReadFrom.AddConcreteCalendar));
			Print("Entered Primer : " + ReadFrom.Excel(AddConcreteCalendar, 17, ReadFrom.AddConcreteCalendar));

			Wait(2000);

			Click("Concrete.Submit", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Click on Submit button");
			Print("Click on Submit button");

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
			String InvalidStartDate =	GetText("Concrete.Toast", ConcreteCalendarLocators);
			if(IfContains(InvalidStartDate, "Please Enter Future Date")) {
				Click("Concrete.Toast", ConcreteCalendarLocators);
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
		
			Clear("Concrete.SelectDate", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.SelectDate", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 2, ReadFrom.AddConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request" ,"Entered SelectDate : " + ReadFrom.Excel(AddConcreteCalendar, 2, ReadFrom.AddConcreteCalendar));
			Print("Entered SelectDate : " + ReadFrom.Excel(AddConcreteCalendar, 2, ReadFrom.AddConcreteCalendar));
			
			Wait(2000);
			Clear("Concrete.FromHH", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.FromHH", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 7, ReadFrom.ConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered FromHH : " + ReadFrom.Excel(AddConcreteCalendar, 7, ReadFrom.ConcreteCalendar));
			Print("Entered FromHH : " + ReadFrom.Excel(AddConcreteCalendar, 7, ReadFrom.ConcreteCalendar));

			Wait(2000);
			Clear("Concrete.FromMM", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.FromMM", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 8, ReadFrom.ConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered FromMM : " + ReadFrom.Excel(AddConcreteCalendar, 8, ReadFrom.ConcreteCalendar));
			Print("Entered FromMM : " + ReadFrom.Excel(AddConcreteCalendar, 8, ReadFrom.ConcreteCalendar));

			Wait(2000);
			String FromMeridian = ReadFrom.Excel(AddConcreteCalendar, 8, ReadFrom.ConcreteCalendar);

			String Meridian = GetText("Concrete.FromMeridian", ConcreteCalendarLocators);
			if(IsEqual(Meridian, FromMeridian)) {


			}
			else {
				Click("Concrete.FromMeridian", ConcreteCalendarLocators);
			}

			Wait(2000);
			Clear("Concrete.ToHH", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.ToHH", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.ConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered ToHH : " + ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.ConcreteCalendar));
			Print("Entered ToHH : " + ReadFrom.Excel(AddConcreteCalendar, 10, ReadFrom.ConcreteCalendar));

			Wait(2000);
			Clear("Concrete.ToMM", ConcreteCalendarLocators);
			TypeDataInTheField("Concrete.ToMM", ConcreteCalendarLocators, ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.ConcreteCalendar));
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Entered ToMM : " + ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.ConcreteCalendar));
			Print("Entered ToMM : " + ReadFrom.Excel(AddConcreteCalendar, 11, ReadFrom.ConcreteCalendar));

			Wait(2000);
			String ToMeridian = ReadFrom.Excel(AddConcreteCalendar, 12, ReadFrom.ConcreteCalendar);

			String ToMeridian2 = GetText("Concrete.ToMeridian", ConcreteCalendarLocators);
			if(IsEqual(ToMeridian2, ToMeridian)) {


			}
			else {
				Click("Concrete.ToMeridian", ConcreteCalendarLocators);
			}
			
			
			Click("Concrete.Submit", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,"Click on Submit button");
			Print("Click on Submit button");
			
			String InvalidTime =	GetText("Concrete.Toast", ConcreteCalendarLocators);
			if(IfContains(InvalidTime, "Please Enter Start time Lesser than End time")) {
				Click("Concrete.Toast", ConcreteCalendarLocators);
				PrintError(InvalidTime);
				ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time" ,InvalidTime);
				Wait(2000);
				Click("Concrete.CancelButton", ConcreteCalendarLocators);
				ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time","Click on Cancel button");
				Wait(2000);
				Click("Concrete.YesButton", ConcreteCalendarLocators);
				Print("Close button is clicked");
				ReportConfig.Givenlogpass("User add new Concrete request with invalid date and time","Click on Yes button");

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

		ReadFrom.DynamicExcel(ReadFrom.ConcreteCalendar);

		for(int ConcreteCalendar =1; ConcreteCalendar<=1; ConcreteCalendar++)	{


			SearchMonth(ConcreteCalendar, ReadFrom.ConcreteCalendar);
			SearchYear(ConcreteCalendar, ReadFrom.ConcreteCalendar);

			Wait(3000);
			Click("Concrete.SearchIcon", ConcreteCalendarLocators);
			Wait(2000);
			TypeDataInTheField("Concrete.SearchField", ConcreteCalendarLocators, ReadFrom.Excel(ConcreteCalendar, 4, ReadFrom.ConcreteCalendar));
			Wait(7000);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
				}
			});


			String ConcreteName = 	ReadFrom.Excel(ConcreteCalendar, 4, ReadFrom.ConcreteCalendar) ;
			WebElement ConcreteRequest = 	FindElement(ReadFrom.Excel(ConcreteCalendar, 4, ReadFrom.ConcreteCalendar));

			Click(ConcreteRequest);

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
			JsClick("Concrete.Attachments", ConcreteCalendarLocators);

			if(IsElementDisplayed("Concrete.Attachments", ConcreteCalendarLocators)) {
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
				String AttachmentsUploaded =	GetText("Concrete.Toast", ConcreteCalendarLocators);
				if(IfContains(AttachmentsUploaded, "Please select a valid file")) {
					Click("Concrete.Toast", ConcreteCalendarLocators);
					Print("Please enter valid file format");
					ReportConfig.Givenlogpass("User add invalid file in Concrete request" ,"Please enter valid file format");

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
			JsClick("Concrete.ClosePopup", ConcreteCalendarLocators);
			ReportConfig.Givenlogpass("User add invalid file in Concrete request" ,"Click on Close popup button");
			Print("Click on Close popup button");

			Wait(2000);
			JsClick("Concrete.CloseSearch", ConcreteCalendarLocators);

			//}
		}
	
		
		
	}
}

