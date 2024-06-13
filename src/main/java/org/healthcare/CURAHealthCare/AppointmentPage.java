package org.healthcare.CURAHealthCare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPage {
	WebDriver driver;
	public AppointmentPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="combo_facility")
	WebElement facility;
	@FindBy(xpath="//input[@type='radio'][@value=")
	WebElement radio;
	@FindBy(css="#combo_facility option")
	List<WebElement> options;
	@FindBy(xpath="//div//label[@class='radio-inline']//input")
	List<WebElement> hcProgramList;
	@FindBy(id="txt_visit_date")
	WebElement dateMenu;
	@FindBy(css=".datepicker-days thead .datepicker-switch")
	WebElement monthSelect;
	@FindBy(css=".datepicker-days tbody .day")
	List<WebElement> dateSelect;
	@FindBy(id="txt_comment")
	WebElement commentSec;
	@FindBy(id= "btn-book-appointment")
	WebElement bookAppt;
	public void fillDetails(String facilityName, String hcProgram) {
		facility.click();		
		WebElement facilityOption = options.stream().filter(s -> s.getText().equalsIgnoreCase(facilityName)).findFirst().orElse(null);
		System.out.println("Facility Name: "+facilityOption.getText());
		facilityOption.click();
		(hcProgramList.stream().filter(s -> s.getAttribute("value").equalsIgnoreCase(hcProgram)).findFirst().orElse(null)).click();
		
	}
	public void fillDate(String month, String givenDate) throws InterruptedException {
		dateMenu.click();
		String monthSelected =monthSelect.getText();
		while (!monthSelected.equalsIgnoreCase(month)) {
			monthSelected = monthSelect.getText();
			if (!monthSelected.equalsIgnoreCase(month)) {
				driver.findElement(By.cssSelector(".datepicker-days thead .next")).click();
			} 
		}
		WebElement dateSelector = dateSelect.stream().filter(s->s.getText().equalsIgnoreCase(givenDate)).findFirst().orElse(null);
		dateSelector.click();
	}
	public void fillComment(String givenComment) {
		commentSec.click();
		commentSec.sendKeys(givenComment);
	}
	public AppointmentConfirmation bookAppointment(String option1, String healthcareProg,String month, String dayDate,String givenComment) throws InterruptedException {
		fillDetails(option1,healthcareProg);
		fillComment(givenComment);
		fillDate(month, dayDate);
		bookAppt.click();
		AppointmentConfirmation ac = new AppointmentConfirmation(driver);
		return ac;
	}
	public AppointmentConfirmation bookAppt() {
		bookAppt.click();
		AppointmentConfirmation ac = new AppointmentConfirmation(driver);
		return ac;
	}
}
