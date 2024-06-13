package org.healthcare.CURAHealthCare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="menu-toggle")
	WebElement sideMenu;
	@FindBy(css="#sidebar-wrapper ul li")
	List<WebElement> menuItems;
	@FindBy(id="btn-make-appointment")
	WebElement makeAppt;
	@FindBy(xpath="//li//a[contains(text(),'History')]")
	WebElement historyLink;
	@FindBy(xpath="//li//a[contains(text(),'Profile')]")
	WebElement profileLink;;
	@FindBy(xpath="//li//a[contains(text(),'Logout')]")
	WebElement logoutLink;
	@FindBy(css="h1")
	WebElement headingHome;
	@FindBy(xpath="//li//a[contains(text(),'Login')]")
	WebElement loginLink;
	public void openSideMenu() {
		sideMenu.click();
	}
	public List<WebElement> verifyMenuBar() {
		openSideMenu();
		List<WebElement> menuList = menuItems ;
		return menuList;
	}
	public Login makeAppointment() {
		makeAppt.click();
		Login l = new Login(driver);
		return l;
	}
	public String verifyHeading() {
		return headingHome.getText();
	}
	public HistoryPage goToHistory() {
		historyLink.click();
		HistoryPage historyPage = new HistoryPage(driver);
		return historyPage;
	}
	public Login loginFromHomepage() {
		loginLink.click();
		Login l = new Login(driver);
		return l;
	}
	public Profile goToProfile() {
		profileLink.click();
		Profile profile = new Profile(driver);
		return profile;
	}

	public void logoutFromPortal() {
		logoutLink.click();
	}
	public void goToUrl() {
		driver.get("https://katalon-demo-cura.herokuapp.com/");
	}
	
}
