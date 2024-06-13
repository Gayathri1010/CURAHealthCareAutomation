package org.healthcare.CURAHealthCare;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.healthcare.CURAHealthCare.BaseComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import freemarker.ext.beans.HashAdapter;

public class ErrorValidation extends BaseTest{

	@Test(retryAnalyzer=org.healthcare.CURAHealthCare.BaseComponent.Retry.class, groups = {"verification"},dataProvider = "getErrorValidationData")
	public void verifyLoginError(HashMap<String, String> input) throws InterruptedException {
		hp.openSideMenu();
		Login l = hp.loginFromHomepage();
		l.loginInfo(input.get("username"), input.get("password"));
		Thread.sleep(3000);  
		l.loginToPortal();
		Thread.sleep(5000);
		Assert.assertEquals(l.verifyLoginErrorMsg(),"Login failed! Please ensure the username and password are valid.");
		
	}
	@Test(groups = {"verification"}, dataProvider = "getInvalidDateData")
	public void invalidDateField(HashMap<String, String> input) throws InterruptedException {
		hp.openSideMenu();
		Login l = hp.loginFromHomepage();
		l.loginInfo(input.get("username"), input.get("password"));
		AppointmentPage ap = l.loginToPortal();
		ap.bookAppt();
		
	}
	@DataProvider
	public Object[][] getErrorValidationData() throws IOException {
		List<HashMap<String, String>> data =getJsonToMap(System.getProperty("user.dir")+"//src//test//java//Data//ErrorValidationTestData.json");
		return new Object[][] {{data.get(0)}};
		
	}
	@DataProvider
	public Object[][] getInvalidDateData() throws IOException {
		List<HashMap<String, String>> data =getJsonToMap(System.getProperty("user.dir")+"//src//test//java//Data//InvalidDateFieldTestData.json");
		return new Object[][] {{data.get(0)}};
		
	}

}
