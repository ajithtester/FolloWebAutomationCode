package com.follo.module.method;

import java.time.Duration;
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

public class F_05_Members extends Baseclass {




	public static void InviteMembers() throws Throwable {

		Wait(3000);
		PrintError("Invite members Started");
		ReadFrom.DynamicExcel(ReadFrom.InviteMembers);
		for(int invite =1; invite<=ReadFrom.rowcount; invite++)		{	

			Wait(3000);
			TypeDataInTheField("EnterMailId", MembersLocators, ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers));


			Wait(2000);
			ClickEnter();


			Wait(2000);
			WebElement Email =	FindElement("EnteredMailList" , MembersLocators, invite) ;

			String EnteredEmail = Email.getText();


			if(IsEqual(EnteredEmail, ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers))) {
				Print("Entered mail id : " + ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers) );
				ReportConfig.PassedLogInfo("User enters members mailid", "Entered mail id : " + ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers));
			}
			else {

				PrintError("Email id not entered");
				ReportConfig.FailedLogInfo("User enters members mailid", "Email id not entered");
				
				String IssueSummary = "Email id not entered in the invite box";
				String Storydescription = "Invite Members" ;
				pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			}
		}


	}
	public static void NegativeInviteMembers() throws Throwable {
		
		PrintError("Negative Invite members Started");


		Wait(3000);
		Click("InviteMembers", MembersLocators);
		Print("Click on Invite members button");
		ReportConfig.Givenlogpass("User invites already invited member","Click on Invite members button");

		ReadFrom.DynamicExcel(ReadFrom.InviteMembers);
		for(int invite =1; invite<=1; invite++)		{	

			Wait(7000);
			TypeDataInTheField("EnterMailId", MembersLocators, ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers));
			ReportConfig.Givenlogpass("User invites already invited member", "Entered Email id : " + ReadFrom.Excel(invite, 0, ReadFrom.InviteMembers));

			Wait(2000);
			ClickEnter();
			Wait(1000);

			String InviteError =	GetText("InviteError", MembersLocators);

			Print("Invalid Image upload alert : " + InviteError);
			ReportConfig.Givenlogpass("User invites already invited member", "Invalid Image upload alert: " + InviteError);

			Click("CancelButton", MembersLocators);

			Print("Click on Cancel button");


			Wait(2000);

			Click("Yes", MembersLocators);

			Print("Yes button is clicked");
			ReportConfig.Givenlogpass("User invites already invited member" ,"Click on Close button");
		}

	}

	public static void SelectCompany() throws Throwable {

		Wait(3000);
		PrintError("Select company in members Started");
		ReadFrom.DynamicExcel(ReadFrom.InviteMembers);

		for(int invite =1; invite<=ReadFrom.rowcount; invite++)		{	
			String CompanyInExcel = ReadFrom.Excel(invite, 1,ReadFrom.InviteMembers);


			WebElement Email =	FindElement("EnteredMailList" , MembersLocators, invite) ;

			String EnteredEmail = GetTextFromTheElement(Email);

			WebElement	SelectCompany =	FindElement("SelectComanyDropdown" , MembersLocators, invite);
			Click(SelectCompany);
			ReportConfig.PassedLogInfo("User assign company and role to the member","Click on company dropdown");
			Print("Click on company dropdown");
			Wait(3000);

			List<WebElement> CompanyList = getElements("CompanyListInDropdown", MembersLocators);
			for(WebElement Value:CompanyList) {
				String	CompanyName = GetTextFromTheElement(Value);

				if(IsEqual(CompanyName, CompanyInExcel)){
					Wait(2000);
					Click(Value);

					Print("Company assigned to the member is : " + EnteredEmail + " : " + CompanyInExcel);
					ReportConfig.PassedLogInfo("User assign company and role to the member", "Company assigned to the member is : " + CompanyInExcel);
					Wait(3000);
					break;
				}
			}


			String RoleInExcel = ReadFrom.Excel(invite, 2,ReadFrom.InviteMembers);


			WebElement	SelectRole =	FindElement("SelectRoleDropdown" , MembersLocators, invite);
			Click(SelectRole);
			ReportConfig.PassedLogInfo("User assign company and role to the member","Click on role dropdown");
			Print("Click on role dropdown");
			Wait(3000);

			List<WebElement> RoleList = getElements("RoleListInDropdown", MembersLocators);
			for(WebElement Value :RoleList) {
				String	RoleName = GetTextFromTheElement(Value);


				if(IsEqual(RoleName, RoleInExcel)){
					Wait(2000);
					Click(Value);

					Print("Role assigned to the member is : " + EnteredEmail + " : " + RoleInExcel);
					ReportConfig.PassedLogInfo("User assign company and role to the member", "Role assigned to the member is : "  + RoleInExcel);
					Wait(3000);
					break;
				}
			}
		}
	}



	public static void SelectRole() throws Throwable {

		Wait(3000);
		PrintError("Select role in members Started");
		ReadFrom.DynamicExcel(ReadFrom.InviteMembers);
		try {
			for(int invite =1; invite<=ReadFrom.rowcount; invite++)		{	
				String RoleInExcel = ReadFrom.Excel(invite, 2,ReadFrom.InviteMembers);

				WebElement	SelectRole =	FindElement("SelectRoleDropdown" , MembersLocators, invite);
				Click(SelectRole);
				//	ReportConfig.PassedLogInfo("Click on role dropdown");
				Print("Click on role dropdown");
				Wait(3000);

				List<WebElement> RoleList = getElements("RoleListInDropdown", MembersLocators);
				for(WebElement Value :RoleList) {
					String	RoleName = GetTextFromTheElement(Value);

					if(IsEqual(RoleName, RoleInExcel)){
						Wait(2000);
						Click(Value);

						Print("Selected Role is : " + RoleInExcel);
						//			ReportConfig.PassedLogInfo("Role selected is : " + RoleInExcel);
						Wait(3000);
						break;
					}
				}
			}


		}
		catch (Exception e) {
			PrintError(e.getMessage());
			String IssueSummary = e.getMessage();
			String Storydescription = "Select role for Members" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
		}
	}

	public static void InviteSentPopup() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Invites sent Successfully.']"));
			}
		});

	}


	public static void ReInviteMembers() throws Throwable {

		Wait(3000);

		PrintError("ReInvite members Started");

		int rowcountofthelist = SizeOfTheList("StatusList", MembersLocators);

		for(int reinvite =1; reinvite<=rowcountofthelist; reinvite++)		{	
			WebElement Status =	FindElement("StatusOfMember",MembersLocators,  reinvite);

			String StatusText = GetTextFromTheElement(Status);


			if(IsEqual(StatusText, "Pending")) {

				WebElement Resend =	FindElement("ResendInvite", MembersLocators, reinvite);
				Click(Resend);
				ReportConfig.PassedLogInfo("User send reinvites to the pending members","Click on Resend invite button ");
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@aria-label='Resend Invite Link sent Successfully.']"));
					}
				});

				if(IsElementDisplayed("ResendMessagePopup", MembersLocators)) {
					Click("ResendMessagePopup", MembersLocators);
					WebElement EmailId =	FindElement("EmailIdList", MembersLocators, reinvite);

					String Member =	GetTextFromTheElement(EmailId);

					Print("Invite sent to the account : " + Member );
					ReportConfig.PassedLogInfo("User send reinvites to the pending members" , "Invite sent to the account : " + Member );
					Wait(3000);

				}
				else {
					PrintError("Resent invite failed");
					ReportConfig.FailedLogInfo("User send reinvites to the pending members","Resent invite failed");
					String IssueSummary = "Resent invite failed for the pending memebers";
					String Storydescription = "Resent invite" ;
					pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
				}
			}

			else {
				PrintError("Account status is : " + StatusText);

			}
		}
	}

	public static void SearchMember() throws Throwable {

		PrintError("Search member Started");
		ReadFrom.DynamicExcel(ReadFrom.SearchMembers);

		Click("Search", MembersLocators);
		for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

			TypeDataInTheField("SearchMember", MembersLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchMembers));
			ReportConfig.PassedLogInfo("User search and view the members","Searched value : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchMembers));
			Print("Searched value : " + ReadFrom.Excel(Search, 0, ReadFrom.SearchMembers));

			Wait(5000);


			int rowcount = 	SizeOfTheList("EmailList", MembersLocators);

			for(int MembersCount =1; MembersCount<=rowcount; MembersCount++)	{

				WebElement Members =	FindElement("EmailIdList", MembersLocators, MembersCount);
				String MembersEmailId =	GetTextFromTheElement(Members);

				Wait(2000);

				String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchMembers);



				if(IsEqual(MembersEmailId, SearchedValue)) {

					Wait(2000);
					Print("Displayed value : " + MembersEmailId);
					ReportConfig.PassedLogInfo("User search and view the members", "Displayed value : " + MembersEmailId);
					Wait(7000);

				}
				else {
					PrintError("Displayed value is : " + MembersEmailId);
				}


			}
			//Wait(2000);
			//Click("ClearSearch", MembersLocators);
			ReportConfig.PassedLogInfo("User search and view the members","Click on clear button");
			Wait(3000);
			Clear("SearchDfow", DFOWLocators);
			ReportConfig.PassedLogInfo("User search and view the members","Search bar is cleared");
			PrintError("Search bar is cleared");
			Wait(3000);
			Click("ClearSearch", MembersLocators);
			Wait(2000);
		}
	}


	public static void FilterMemberOnRole() throws Throwable {

		PrintError("Filter member Started");
		ReadFrom.DynamicExcel(ReadFrom.FilterMembers);

		for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{

			Click("FilterIcon", MembersLocators);
			ReportConfig.PassedLogInfo("User search and filter the company based on role", "Click on Filter icon");
			Print("Click on Filter icon");
			Wait(3000);
			//Click("RoleDropdown", MembersLocators);


			SelectFromDropdown("RoleDropdown", MembersLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterMembers));
			ReportConfig.PassedLogInfo("User search and filter the company based on role","Value selected from the role dropdown is : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterMembers));
			Print("Value selected from the role dropdown is : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterMembers));

			Click("FilterApply", MembersLocators);
			ReportConfig.PassedLogInfo("User search and filter the company based on role","Click on filter apply");
			Print("Click on filter apply");
			Wait(3000);


			int rowcount = 	SizeOfTheList("RoleNameList", MembersLocators);


			for(int RoleList =1; RoleList<=rowcount; RoleList++)	{

				WebElement Role =	FindElement("RoleList" , MembersLocators, RoleList );
				String RoleName =	GetTextFromTheElement(Role);

				Wait(2000);

				String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterMembers);


				if(	IsEqual(RoleName, FilteredValue)) {

					Wait(2000);
					Print("Displayed value : " + FilteredValue + " : Displayed value : " + RoleName);
					ReportConfig.PassedLogInfo("User search and filter the company based on role","Displayed value : " + FilteredValue + " : Displayed value is : " + RoleName);
					Wait(3000);

				}
				else {
					PrintError("Displayed value : " + FilteredValue + " : Displayed value is : " + RoleName);
					ReportConfig.PassedLogInfo("User search and filter the company based on role","Displayed value : " + FilteredValue + " : Displayed value is : " + RoleName);

				}


			}
			Click("FilterIcon", MembersLocators);
			ReportConfig.PassedLogInfo("User search and filter the company based on role","Click on Filter icon");
			Print("Click on Filter icon");

			Wait(3000);
			Click("FilterReset", MembersLocators);
			ReportConfig.PassedLogInfo("User search and filter the company based on role","Click on Filter reset");
			Print("Click on Filter reset");

			Wait(3000);
			//	Clear("SearchDfow", DFOWLocators);

		}
	}


	//	public static void FilterMemberOnCompany() throws Throwable {
	//
	//		PrintError("Add Company Started");
	//		ReadFrom.DynamicExcel(ReadFrom.FilterMembers);
	//		try {
	//
	//			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{
	//
	//
	//
	//				Click("FilterIcon", MembersLocators);
	//				ReportConfig.PassedLogInfo("Click on Filter icon");
	//				Print("Click on Filter icon");
	//				
	//				Wait(2000);
	//				
	//				Click("CompanyInFilter", MembersLocators);
	//				
	//				ReportConfig.PassedLogInfo("Company dropdown is clicked");
	//				Print("Company dropdown is clicked");
	//
	//				Wait(3000);
	//
	//				String CompanyInExcel = ReadFrom.Excel(Filter, 1, ReadFrom.FilterMembers);
	//				List<WebElement> CompanyList = getElements("FilterCompany", MembersLocators);
	//				int count =	CompanyList.size();
	//				for(int list = 1 ; list<=count ; list++) {
	//					for(WebElement Value :CompanyList) {
	//						String	RoleName = GetTextFromTheElement(Value);
	//						Print(RoleName);
	//
	//						if(IsEqual(RoleName, CompanyInExcel)){
	//							Wait(2000);
	//							Click(Value);
	//
	//							Print("Company selected is : " + CompanyInExcel);
	//							ReportConfig.PassedLogInfo("Company selected is : " + CompanyInExcel);
	//							Wait(3000);
	//							break;
	//						}
	//
	//					}
	//				}
	//				//Click("Name", MembersLocators);
	//				//Wait(2000);
	//				//SelectFromDropdown("RoleDropdown", MembersLocators, "3");
	//				//ClickTab();
	//				
	//			//	ClickTab();
	//				//Wait(3000);
	//			//	ClickEnter();
	////				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	////						.withTimeout(Duration.ofSeconds(120))
	////						.pollingEvery(Duration.ofSeconds(5))
	////						.ignoring(NoSuchElementException.class);
	////
	////
	////				WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
	////					public WebElement apply(WebDriver driver) {
	////						return driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
	////					}
	////				});
	////				/WaitForTheElement("FilterApply2", MembersLocators);
	//				//WebElement apply =  getElement("FilterApply", MembersLocators);
	////			/	explicitwaitclickable(apply);
	//				//Click(apply);
	//				
	//				//doubleClick(FilterApply);
	//				//FilterApply.click();
	//				//Click("FilterApply", MembersLocators);
	//				Click("FilterReset", MembersLocators);
	//				ReportConfig.PassedLogInfo("Click on filter apply");
	//				Print("Click on filter apply");
	//				//	Click("FilterApply", MembersLocators);
	//				Wait(3000);
	//
	//
	//				int rowcount = 	SizeOfTheList("CompanyNameList", MembersLocators);
	//				Print("No of companies displayed : " + rowcount);
	//
	//
	//				for(int CompanyListed =1; CompanyListed<=rowcount; CompanyListed++)	{
	//
	//					WebElement Company =	FindElement("CompanyList" , MembersLocators, CompanyListed );
	//					String CompanyName =	GetTextFromTheElement(Company);
	//
	//					Wait(2000);
	//
	//					String FilteredValue = ReadFrom.Excel(Filter, 1, ReadFrom.FilterMembers);
	//
	//
	//					if(IsEqual(CompanyName, FilteredValue)) {
	//
	//						Wait(2000);
	//						Print("Displayed value : " + FilteredValue + " Displayed value is : " + CompanyName);
	//						ReportConfig.PassedLogInfo("Displayed value : " + FilteredValue + " Displayed value is : " + CompanyName);
	//						Wait(3000);
	//
	//					}
	//					else {
	//						PrintError("Displayed value : " + FilteredValue + " Displayed value is : " + CompanyName);
	//						ReportConfig.PassedLogInfo("Displayed value : " + FilteredValue + " Displayed value is : " + CompanyName);
	//					}
	//
	//
	//				}
	//				
	//				
	//				Click("FilterIcon", MembersLocators);
	//				ReportConfig.PassedLogInfo("Click on Filter icon");
	//				Print("Click on Filter icon");
	//				Wait(3000);
	//
	//				Click("FilterReset", MembersLocators);
	//				ReportConfig.PassedLogInfo("Click on Filter reset ");
	//				Print("Click on Filter reset ");
	//				Wait(3000);
	//				//	Clear("SearchDfow", DFOWLocators);
	//
	//			}
	//
	//		}
	//		catch (Exception e) {
	//			PrintError(e.getMessage());
	//			ReportConfig.PassedLogInfo(e.getMessage());
	//		}
	//	}


	public static void DeleteMembers() throws Throwable {
		PrintError("Delete members Started");

		ReadFrom.DynamicExcel(ReadFrom.DeleteMembers);

		for(int DeleteMembers =1; DeleteMembers<=ReadFrom.rowcount; DeleteMembers++)	{
			int rowcount = 	SizeOfTheList("CompanyNameList", MembersLocators);

			for(int TotalMembers =1; TotalMembers<=rowcount; TotalMembers++)	{

				WebElement EmailIdList =	FindElement("EmailIdList" ,MembersLocators, TotalMembers);

				String EmailIds = 	GetTextFromTheElement(EmailIdList);

				String DeleteIt =	ReadFrom.Excel(DeleteMembers, 0, ReadFrom.DeleteMembers);

				if(IsEqual(EmailIds, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteButton" , MembersLocators ,TotalMembers);
					Click(Delete);

					ReportConfig.PassedLogInfo("User deletes a member from the list", "Click on Delete button");
					Print("Click on Delete button");
					Wait(2000);

					Click("YesDelete", MembersLocators);
					ReportConfig.PassedLogInfo("User deletes a member from the list", "Click on Yes button");
					Print("Click on Yes button");

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);

					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Member Deleted Successfully.']"));
						}
					});

					if(IsElementDisplayed("DeleteMessageSuccessfully", MembersLocators)){

						Print("Deleted member : " + ReadFrom.Excel(DeleteMembers, 0, ReadFrom.DeleteMembers));
						ReportConfig.PassedLogInfo("User deletes a member from the list", "Deleted member : " + ReadFrom.Excel(DeleteMembers, 0, ReadFrom.DeleteMembers));
						break;
					}else {
						PrintError("Member not deleted");
						ReportConfig.FailedLogInfo("User deletes a member from the list","Member not deleted");

						String IssueSummary = "Member Deleted Successfully popup is not displayed" ;
						String Storydescription = "Delete members" ;
						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
						Wait(5000);
						break;

					}
				}
			}
		}
	}

	public static void EditMembers() throws Throwable {
		PrintError("Edit members Started");
		ReadFrom.DynamicExcel(ReadFrom.EditMembers);

		for(int EditMemberDetails =1; EditMemberDetails<=ReadFrom.rowcount; EditMemberDetails++)	{


			int rowcount = SizeOfTheList("CompanyNameList", MembersLocators);

			for(int MemberList =1; MemberList<=rowcount; MemberList++)	{

				WebElement MemberNames =	FindElement("EmailIdList" , MembersLocators , MemberList);

				String MemberNamesList = 	GetTextFromTheElement(MemberNames);


				String EditIt =	ReadFrom.Excel(EditMemberDetails, 0, ReadFrom.EditMembers);


				if(IsEqual(MemberNamesList, EditIt)) {

					WebElement Status =			FindElement("StatusOfMember" , MembersLocators , MemberList);
					String StatusOfMember = GetTextFromTheElement(Status);

					if(IsEqual(StatusOfMember, "Completed")) {

						Wait(2000);
						WebElement	EditMember = 		FindElement("EditMembers" , MembersLocators , 1);
						Click(EditMember);
						ReportConfig.PassedLogInfo("User edit a member from the list","Click on Edit button");
						Print("Click on Edit button");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//input[@placeholder='First Name']"));
							}
						});

						Wait(2000);
						Clear("FirstName", MembersLocators);
						TypeDataInTheField("FirstName", MembersLocators, ReadFrom.Excel(EditMemberDetails, 1, ReadFrom.EditMembers));
						ReportConfig.PassedLogInfo("User edit a member from the list", "Edited  Firstname is : " + ReadFrom.Excel(EditMemberDetails, 1, ReadFrom.EditMembers));
						Print("Edited  Firstname is : " + ReadFrom.Excel(EditMemberDetails, 1, ReadFrom.EditMembers));

						Wait(2000);
						Clear("LastName", MembersLocators);
						TypeDataInTheField("LastName", MembersLocators, ReadFrom.Excel(EditMemberDetails, 2, ReadFrom.EditMembers));
						ReportConfig.PassedLogInfo("User edit a member from the list", "Edited Lastname is : " + ReadFrom.Excel(EditMemberDetails, 2, ReadFrom.EditMembers));
						Print("Edited Lastname is : " +ReadFrom.Excel(EditMemberDetails, 2, ReadFrom.EditMembers));

						Wait(2000);
						SelectFromDropdown("PhoneCode", MembersLocators, ReadFrom.Excel(EditMemberDetails, 3, ReadFrom.EditMembers));
						ReportConfig.PassedLogInfo("User edit a member from the list", "Edited Phonecode is : " + ReadFrom.Excel(EditMemberDetails, 3, ReadFrom.EditMembers));
						Print("Edited Phonecode is : " + ReadFrom.Excel(EditMemberDetails, 3, ReadFrom.EditMembers));

						Wait(2000);
						Clear("MobileNumber", MembersLocators);
						TypeDataInTheField("MobileNumber", MembersLocators, ReadFrom.Excel(EditMemberDetails, 4, ReadFrom.EditMembers));
						ReportConfig.PassedLogInfo("User edit a member from the list", "Edited Mobile number is : " +  ReadFrom.Excel(EditMemberDetails, 4, ReadFrom.EditMembers));
						Print("Edited Mobile number is : " + ReadFrom.Excel(EditMemberDetails, 4, ReadFrom.EditMembers));

						Wait(2000);
						Click("SubmitButton", MembersLocators);
						ReportConfig.PassedLogInfo("User edit a member from the list","Click on Submit  button");
						Print("Click on Submit  button");

						Wait<WebDriver> MemberUpdated = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						MemberUpdated.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Member Updated Successfully.']"));
							}
						});

						if(IsElementDisplayed("MemberUpdated", MembersLocators)) {
							Click("MemberUpdated", MembersLocators);

							Print("Member updated : " + MemberNamesList );
							ReportConfig.PassedLogInfo("User edit a member from the list", "Member updated : " + MemberNamesList );
						}

					}

					else {
						PrintError("Status of the member is : " + StatusOfMember + " : Thus this member can't be edited");
						ReportConfig.PassedLogInfo("User edit a member from the list", "Status of the member " + MemberNamesList +  " is : " + StatusOfMember + " : Thus this member can't be edited");
						String IssueSummary = "Member Updated Successfully popup is not displayed" ;
						String Storydescription = "Update members" ;
						pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
					}
				} 
			}
		}
	}

	public static void RemoveAll() throws Throwable {
		PrintError("Remove all members Started");


		int size =	SizeOfTheList("CompanyList", MembersLocators);

		if(size<=1) {
			WebElement MemberNames =	FindElement("EmailIdList" , MembersLocators , size);

			String MemberNamesList = 	GetTextFromTheElement(MemberNames);
			if(MemberNamesList.equalsIgnoreCase(ReadFrom.Excel(0, 1 , ReadFrom.Login))) {
				Print("All members are deleted except origin member : " + MemberNamesList);
				ReportConfig.PassedLogInfo("All members are deleted except origin member : " , MemberNamesList);
			}
		}
		else {

			PrintError("All members are not deleted");
			ReportConfig.FailedLogInfo("All the members except origin member should be deleted","All members are not deleted");
			
			String IssueSummary = "Remove all memebers failed" ;
			String Storydescription = "Delete all members" ;
			pt_Integration.CreateStory.post_Story(Storydescription , IssueSummary );
			
		}


	}
}

