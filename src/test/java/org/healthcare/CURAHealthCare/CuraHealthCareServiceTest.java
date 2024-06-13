package org.healthcare.CURAHealthCare;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import org.healthcare.CURAHealthCare.BaseComponent.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CuraHealthCareServiceTest extends BaseTest{
	
	@Test(dependsOnMethods = {"verifyHomepage"}, dataProvider = "getData")
	public void EndToEndTest(HashMap<String, String> input) throws InterruptedException {
		String[] splitDate = input.get("givenDate").split("/");
		String dayDate = splitDate[0];
		Login l = hp.makeAppointment();		
		String pageHeading = l.getHeading();
		Assert.assertEquals(pageHeading,input.get("pageHeading"));
		l.loginInfo(input.get("username"), input.get("password"));
		Thread.sleep(3000);
		AppointmentPage ap = l.loginToPortal();
		AppointmentConfirmation ac = ap.bookAppointment(input.get("option1"),input.get("healthcareProg"),input.get("month"),dayDate,input.get("givenComment"));
		String acStatus=ac.getAppointmentStatus(input.get("option1"), input.get("healthcareProg"));
		String[] apptStatus = acStatus.split(",");
		Assert.assertEquals(apptStatus[0].trim(),input.get("apptStatus"));
		Assert.assertEquals(apptStatus[1].trim(),input.get("option1"));
		Assert.assertEquals(apptStatus[2].trim(),input.get("healthcareProg"));
		ac.goToHomePage();
		Assert.assertEquals(hp.verifyHeading(),input.get("HomePageHeading"));
		List<WebElement> menuListed=hp.verifyMenuBar();
		Assert.assertEquals(menuListed.get(1).getText(),input.get("menuItem1"));
		Assert.assertEquals(menuListed.get(2).getText(),input.get("menuItem2"));
		Assert.assertEquals(menuListed.get(3).getText(),input.get("menuItem3"));
		Assert.assertEquals(menuListed.get(4).getText(),input.get("menuItem4"));
		HistoryPage historyPage = hp.goToHistory();
		Assert.assertEquals("History",historyPage.verifyHistoryPage());
		String historyData = historyPage.verifyDetails();
		String[] historyDetails = historyData.split(",");
		Assert.assertEquals(historyDetails[0].trim(),input.get("option1"));
		Assert.assertEquals(historyDetails[1].trim(),input.get("healthcareProg"));
		Assert.assertEquals(historyDetails[2].trim(),input.get("givenDate"));
		historyPage.goToHomepageFromHistory();		
		hp.openSideMenu();
		hp.logoutFromPortal();
	}
	@Test(groups = {"verification"}, dataProvider = "getData")
	public void verifyHomepage(HashMap<String, String> input1) {
		List<WebElement> menuList=hp.verifyMenuBar();
		Assert.assertEquals(menuList.get(1).getText(),input1.get("menuItem1"));
		Assert.assertEquals(menuList.get(2).getText(),input1.get("menuItem5"));
	}
	@Test(dataProvider = "getData", groups= {"verification"})
	public void checkProfile(HashMap<String, String> input) throws InterruptedException {
		hp.openSideMenu();
		Login l = hp.loginFromHomepage();
		l.loginInfo(input.get("username"), input.get("password"));
		Thread.sleep(3000);
		l.loginToPortal();
		hp.openSideMenu();
		Profile profile =hp.goToProfile();
		Assert.assertEquals(profile.verifyProfileHeading(),input.get("menuItem3"));
		Assert.assertEquals(profile.verifyDetails(),input.get("profilePage"));
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		//HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> data = getJsonToMap(System.getProperty("user.dir")+"//src//test//java//Data//TestData.json");
		return new Object[][] {{data.get(0)}};
	}

}
