package org.healthcare.CURAHealthCare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentConfirmation {
	WebDriver driver;
	public AppointmentConfirmation(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="h2")
	WebElement apptConfirmation;
	@FindBy(id="facility")
	WebElement facilityGiven;
	@FindBy(id="program")
	WebElement hcProgramGiven;
	@FindBy(xpath = "//a[contains(text(),'Go to Homepage')]")
	WebElement homePageLink;
	public String getAppointmentStatus(String facilityName, String hcProgram) {
		return apptConfirmation.getText() +", "+  facilityGiven.getText() + ", " +hcProgramGiven.getText();
	}
	public void goToHomePage() {
		homePageLink.click();
	}
}
