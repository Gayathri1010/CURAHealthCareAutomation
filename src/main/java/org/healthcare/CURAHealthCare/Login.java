package org.healthcare.CURAHealthCare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".row h2")
	WebElement loginHeading;
	@FindBy(id="txt-username")
	WebElement username;
	@FindBy(id="txt-password")
	WebElement password;
	@FindBy(id="btn-login")
	WebElement loginBtn;
	@FindBy(xpath="//p[@class='lead text-danger']")
	WebElement loginErrorMsg;
	public String getHeading() {
		return driver.findElement(By.cssSelector(".row h2")).getText();	
	}
	public void loginInfo(String name, String pass) {
		username.sendKeys(name);
		password.sendKeys(pass);
	}
	public AppointmentPage loginToPortal() {
		loginBtn.click();
		AppointmentPage ap = new AppointmentPage(driver);
		return ap;
	}
	public String verifyLoginErrorMsg() {
		return loginErrorMsg.getText();
	}
	
}
