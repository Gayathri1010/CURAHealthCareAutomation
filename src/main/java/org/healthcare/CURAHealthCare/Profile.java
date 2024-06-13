package org.healthcare.CURAHealthCare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
	WebDriver driver;
	public Profile(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="h2")
	WebElement profileHeading;
	@FindBy(xpath="//p[text()='Under construction.']")
	WebElement profileDetails;
	@FindBy(xpath="//p[@class='lead']//a[text()='Logout']")
	WebElement logoutLink;
	public String verifyProfileHeading() {
		return profileHeading.getText();
	}
	public String verifyDetails() {
		return profileDetails.getText();
	}
	public void logoutFromProfile() {
		logoutLink.click();
	}
}
