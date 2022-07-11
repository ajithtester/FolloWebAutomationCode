package com.follo.module.method;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
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

public class F_18_NotificationPreference extends Baseclass {




	public static WebElement InstantList(String locator) throws Throwable {

		return driver.findElement(By.xpath("(//*[text()='" + locator + "']//following::input[@class='custom-control-input'])[1]"));


	}

	public static WebElement DigestList(String locator) throws Throwable {

		return driver.findElement(By.xpath("(//*[text()='" + locator + "']//following::input[@class='custom-control-input'])[2]"));


	}

	public static void SelectInstant() throws Throwable {

		PrintError("Notification preferance update Started");

		ReadFrom.DynamicExcel(ReadFrom.Instant);
		for(int Instant =1; Instant<=ReadFrom.rowcount; Instant++)		{

			Wait(3000);

			String InstantName = 	ReadFrom.Excel(Instant, 0, ReadFrom.Instant) ;
			WebElement CheckBox = 	InstantList(ReadFrom.Excel(Instant, 0, ReadFrom.Instant));
			Wait(2000);
			if (CheckBox.isSelected()) {
				Print("Checkbox: " + InstantName + "is selected already");
			} else {
				JsClick(CheckBox);
			}

			ReportConfig.PassedLogInfo("User selects some instant In-app notifications", InstantName + " : is selected");
			Print(InstantName + " : is selected");

		}
	}

	public static void SelectDigest() throws Throwable {

		PrintError("Notification preferance update Started");

		ReadFrom.DynamicExcel(ReadFrom.Instant);
		for(int Instant =1; Instant<=ReadFrom.rowcount; Instant++)		{

			Wait(3000);

			String DigestName = 	ReadFrom.Excel(Instant, 0, ReadFrom.Instant) ;
			WebElement CheckBox = 	DigestList(ReadFrom.Excel(Instant, 0, ReadFrom.Instant));
			Wait(2000);
			if (CheckBox.isSelected()) {
				Print("Checkbox: " + DigestName + "is selected already");
			} else {
				// Select the checkbox
				JsClick(CheckBox);
			}


			ReportConfig.PassedLogInfo("User selects some instant In-app notifications", DigestName + " : is selected");
			Print(DigestName + " : is selected");

		}
	}

	public static void AddConcreteRequest() throws Throwable {

		PrintError("Add concrete request for notification Started");

		ReadFrom.DynamicExcel(ReadFrom.AddConcreteRequest);
		Wait(2000);
		Click("ConcreteRequest.AllRequests", ConcreteRequestLocators);

		Wait(2000);
		Click("ConcreteRequest.Requests", ConcreteRequestLocators);

		for(int AddConcreteRequest =1; AddConcreteRequest<=1; AddConcreteRequest++)		{

			String ConcreteName = 	ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest) ;

			Waitfortheelement("ConcreteRequest.CreateNew", ConcreteRequestLocators);

			Wait(3000);

			Click("ConcreteRequest.CreateNew", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("Member adds a request" ,"Click on Add new button");
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
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered Description : " + ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest));
			Print("Entered Description : " + ReadFrom.Excel(AddConcreteRequest, 0, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Location", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered Location : " + ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));
			Print("Entered Location : " + ReadFrom.Excel(AddConcreteRequest, 1, ReadFrom.AddConcreteRequest));

			Wait(1000);

			ClickEnter();
			Wait(1000);
			Clear("ConcreteRequest.SelectDate", ConcreteRequestLocators);

			TypeDataInTheField("ConcreteRequest.SelectDate", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered SelectDate : " + ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));
			Print("Entered SelectDate : " + ReadFrom.Excel(AddConcreteRequest, 2, ReadFrom.AddConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.FromHH", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.FromHH", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 3, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered FromHH : " + ReadFrom.Excel(AddConcreteRequest, 3, ReadFrom.AddConcreteRequest));
			Print("Entered FromHH : " + ReadFrom.Excel(AddConcreteRequest, 3, ReadFrom.AddConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.FromMM", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.FromMM", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 4, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered FromMM : " + ReadFrom.Excel(AddConcreteRequest, 4, ReadFrom.AddConcreteRequest));
			Print("Entered FromMM : " + ReadFrom.Excel(AddConcreteRequest, 4, ReadFrom.AddConcreteRequest));

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
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered ToHH : " + ReadFrom.Excel(AddConcreteRequest, 6, ReadFrom.AddConcreteRequest));
			Print("Entered ToHH : " + ReadFrom.Excel(AddConcreteRequest, 6, ReadFrom.AddConcreteRequest));

			Wait(2000);
			Clear("ConcreteRequest.ToMM", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.ToMM", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 7, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered ToMM : " + ReadFrom.Excel(AddConcreteRequest, 7, ReadFrom.AddConcreteRequest));
			Print("Entered ToMM : " + ReadFrom.Excel(AddConcreteRequest, 7, ReadFrom.AddConcreteRequest));

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
			TypeDataInTheField("ConcreteRequest.MixDesign", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered MixDesign : " + ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));
			Print("Entered MixDesign : " + ReadFrom.Excel(AddConcreteRequest, 10, ReadFrom.AddConcreteRequest));

			Wait(2000);
			ClickEnter();
			Wait(1000);

			TypeDataInTheField("ConcreteRequest.OrderNumber", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered OrderNumber : " + ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));
			Print("Entered OrderNumber : " + ReadFrom.Excel(AddConcreteRequest, 11, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Slump", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered Slump : " + ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));
			Print("Entered Slump : " + ReadFrom.Excel(AddConcreteRequest, 12, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.TruckSpacingHours", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered TruckSpacingHours : " + ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));
			Print("Entered TruckSpacingHours : " + ReadFrom.Excel(AddConcreteRequest, 13, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.QuantityOrdered", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered QuantityOrdered : " + ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));
			Print("Entered QuantityOrdered : " + ReadFrom.Excel(AddConcreteRequest, 14, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Primer", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered Primer : " + ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));
			Print("Entered Primer : " + ReadFrom.Excel(AddConcreteRequest, 15, ReadFrom.AddConcreteRequest));

			Wait(2000);

			TypeDataInTheField("ConcreteRequest.Notes", ConcreteRequestLocators, ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));
			ReportConfig.Givenlogpass("Member adds a request" ,"Entered notes : " + ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));
			Print("Entered notes : " + ReadFrom.Excel(AddConcreteRequest, 17, ReadFrom.AddConcreteRequest));



			Wait(2000);
			Click("ConcreteRequest.SelectCompany", ConcreteRequestLocators);
			Wait(2000);
			String	locator = ReadFrom.Excel(AddConcreteRequest, 18, ReadFrom.AddConcreteRequest);
			WebElement Dropdown = driver.findElement(By.xpath("//li[@class='multiselect-item-checkbox ng-star-inserted']//div[text()='"+locator+"']"));

			JsClick(Dropdown);

			Wait(2000);
			Click("ConcreteRequest.Submit", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("Member adds a request" ,"Click on Submit button");
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
			String ConcreteRequestAdded =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(ConcreteRequestAdded, "Concrete Request Created Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Request added is : " + ConcreteName);
				ReportConfig.Givenlogpass("Member adds a request" ,"Request added is : " + ConcreteName);

			}
			else {
				Print("Add Concrete Request failed");
				ReportConfig.Givenlogfail("Member adds a request" ,"Add Concrete Request failed");

				String IssueSummary =  ConcreteRequestAdded;
				String Storydescription = "Add Concrete Request failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}
		}

	}

	public static void RequestUpdate() throws Throwable {

		PrintError("Concrete request update for notification started");

		ReadFrom.DynamicExcel(ReadFrom.ConcreteRequest);

		for(int ConcreteRequest =1; ConcreteRequest<=1; ConcreteRequest++)	{

			Wait(3000);

			String ConcreteName = 	ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest) ;
			WebElement ConcreteRequestName = 	FindElement(ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest));

			Click(ConcreteRequestName);

			ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" , ConcreteName + " : is clicked");
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
				ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,ConcreteName + " : request info is viewed");
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
				Print("Click on Done button");
				ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Click on Done button");


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
					ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Attachment edded to the request : " + ConcreteName);

				}
				else {
					Print("Add attachment to the request failed");
					ReportConfig.Givenlogfail("Member perform attach, delete, comment, edit and status update a request" ,"Add attachment to the request failed");

					String IssueSummary =  AttachmentsUploaded;
					String Storydescription = "Add attachment to the request failed" ;
					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
				}

			}

			Wait<WebDriver> delete = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			delete.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//img[@alt='delete']")); 
				}
			});

			Wait(2000);
			JsClick("Notifications.DeleteButton", NotificationLocators);


			Wait<WebDriver> deletetoast = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);


			deletetoast.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@id='toast-container']")); 
				}
			});

			//	Wait(1000);
			String AttachmentsDeleted =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(AttachmentsDeleted, "Concrete Request Attachment Deleted Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Attachments deleted from the request : " + ConcreteName);
				ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Attachments deleted from the request : " + ConcreteName);

			}
			else {
				Print("Delete Attachments from the request failed");
				ReportConfig.Givenlogfail("Member perform attach, delete, comment, edit and status update a request" ,"Delete Attachments from the request failed");

				String IssueSummary =  AttachmentsDeleted;
				String Storydescription = "Add attachment to the request failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}


			Wait(3000);
			JsClick("ConcreteRequest.Comments", ConcreteRequestLocators);
			Wait(3000);
			if(IsElementDisplayed("ConcreteRequest.AddComments", ConcreteRequestLocators)) {

				PrintError("Add comment started");

				TypeDataInTheField("ConcreteRequest.AddComments", ConcreteRequestLocators, ReadFrom.Excel(ConcreteRequest, 1, ReadFrom.ConcreteRequest));
				ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Comment added is : " + ReadFrom.Excel(ConcreteRequest, 1, ReadFrom.ConcreteRequest));
				Print("Comment added is : " + ReadFrom.Excel(ConcreteRequest, 1, ReadFrom.ConcreteRequest));

				Wait(2000);
				JsClick("ConcreteRequest.Submit", ConcreteRequestLocators);
				Print("Click on Submit button");
				ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Click on Submit button");


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
					ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Comment added to the request : " + ConcreteName);

				}
				else {
					Print("Add comment to the request failed");
					ReportConfig.Givenlogfail("Member perform attach, delete, comment, edit and status update a request" ,"Add comment to the request failed");
					String IssueSummary =  CommentAdded;
					String Storydescription = "Add comment to the request failed" ;
					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
				}
			}

			Wait(2000);
			MoveToElement("ConcreteRequest.EditButton", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.EditButton", ConcreteRequestLocators);

			ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Click on Edit button");
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
			Clear("ConcreteRequest.Description", ConcreteRequestLocators);
			TypeDataInTheField("ConcreteRequest.Description", ConcreteRequestLocators, ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest));
			ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Edited Description is : " + ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest));
			Print("Edited Description is : " + ReadFrom.Excel(ConcreteRequest, 0, ReadFrom.ConcreteRequest));

			MoveToElement("ConcreteRequest.ConcreteConfirmed", ConcreteRequestLocators);
			Wait(2000);
			Click("ConcreteRequest.ConcreteConfirmed", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Click on Concrete Confirmed");
			Print("Click on Concrete Confirmed");

			Wait(2000);

			Click("ConcreteRequest.Submit", ConcreteRequestLocators);
			ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Click on Submit button");
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

			String RequestUpdated =	GetText("ConcreteRequest.Toast", ConcreteRequestLocators);
			if(IfContains(RequestUpdated, "Concrete Request Updated Successfully")) {
				Click("ConcreteRequest.Toast", ConcreteRequestLocators);
				Print("Request updated is : " + ConcreteName);
				ReportConfig.Givenlogpass("Member perform attach, delete, comment, edit and status update a request" ,"Request updated is : " + ConcreteName);

			}
			else {
				PrintError("Member perform attach, delete, comment, edit and status update a request");
				ReportConfig.Givenlogfail("Member perform attach, delete, comment, edit and status update a request" ,"Request updated to the request failed");
				String IssueSummary =  RequestUpdated;
				String Storydescription = "Request updated to the request failed" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary);
			}

		}
	}


	public static void SearchNotification() throws Throwable {

		PrintError("Search notification Started");
		ReadFrom.DynamicExcel(ReadFrom.SearchNoti);

		Click("Notifications.SearchIcon", NotificationLocators);
		for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

			Wait(2000);

			TypeDataInTheField("Notifications.SearchField", NotificationLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchNoti));
			ReportConfig.PassedLogInfo("Search the notification" ,ReadFrom.Excel(Search, 0, ReadFrom.SearchNoti) + " is entered in the search bar");
			Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchNoti) + " is entered in the search bar");

			Wait(5000);
			int rowcount = 	SizeOfTheList("Notifications.NotificationList", NotificationLocators);
			Print("No of notification displayed : " + rowcount);

			List<WebElement> Notifications =	getElements("Notifications.NotificationList", NotificationLocators);

			Wait(2000);
			for (WebElement NotificationsNames : Notifications) {
				String Names =	GetTextFromTheElement(NotificationsNames);
				Print("Displayed values are : " +Names);
				ReportConfig.PassedLogInfo("Search the notification" , "Displayed values are : " +Names);

			}

			Wait(3000);
			Clear("Notifications.SearchField", NotificationLocators);
			Wait(3000);
			Click("Notifications.CloseSearch", NotificationLocators);
			ReportConfig.PassedLogInfo("Search the notification" , "Click on Clear search");
			Print("Click on Clear search");
		}
	}

	public static void FilterNotification() throws Throwable {

		PrintError("Filter Notification Started");
		ReadFrom.DynamicExcel(ReadFrom.FilterNoti);

		for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{

			Click("Notifications.FilterIcon", NotificationLocators);
			ReportConfig.PassedLogInfo("Filter the notification", "Click on Filter icon");
			Print("Click on Filter icon Confirmed");
			Wait(6000);


			SelectFromVisibleText("Notifications.FilterProject", NotificationLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterNoti));
			ReportConfig.PassedLogInfo("Filter the notification","Project is selected as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterNoti));
			Print("Project is selected as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterNoti));

			Click("Notifications.FilterApply", NotificationLocators);
			ReportConfig.PassedLogInfo("Filter the notification","Click on Filter apply");
			Print("Click on Filter apply");
			Wait(3000);


				String Projectname =	GetText("Notifications.Projectname", NotificationLocators);

				Wait(2000);

				String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterNoti);


				if(	IsEqual(Projectname, FilteredValue)) {

					Wait(2000);
					Print("Displayed value is : " + Projectname);
					ReportConfig.PassedLogInfo("Filter the notification","Displayed value is : " + Projectname);
					Wait(3000);

				}
				else {
					PrintError("Filtered value is : " + FilteredValue + " : but Displayed value is : " + Projectname);
					ReportConfig.PassedLogInfo("Filter the notification","Filtered value is : " + FilteredValue + " : but Displayed value is : " + Projectname);
				}
			}
			JsClick("Notifications.FilterIcon", NotificationLocators);
			ReportConfig.PassedLogInfo("Filter the notification","Click on Filter icon");
			Print("Click on Filter icon");

			Wait(3000);
			JsClick("Notifications.FilterReset", NotificationLocators);
			ReportConfig.PassedLogInfo("Filter the notification","Click on Filter reset");
			Print("Click on Filter reset");

			Wait(3000);

		}
}
