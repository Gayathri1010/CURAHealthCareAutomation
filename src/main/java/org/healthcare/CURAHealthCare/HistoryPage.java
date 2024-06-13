package org.healthcare.CURAHealthCare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {
	WebDriver driver;
	public HistoryPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="h2")
	WebElement historyHeading;
	@FindBy(id="facility")
	WebElement facName;
	@FindBy(id="program")
	WebElement program;
	@FindBy(css=".panel-heading")
	WebElement dateGiven;
	@FindBy(xpath="//a[contains(text(),'Go to Homepage')]")
	WebElement homepageLink;
	public String verifyHistoryPage() {
		return historyHeading.getText();
	}
	public String verifyDetails() {
		return facName.getText() +", "+ program.getText()+", "+dateGiven.getText();
	}
	public void goToHomepageFromHistory() {
		homepageLink.click();
	}
}
