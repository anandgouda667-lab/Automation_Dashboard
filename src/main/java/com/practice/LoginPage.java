package com.practice;
	import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage {

		WebDriver driver;
		WebDriverWait wait;

		// constructor 
		LoginPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		}

		// Locators
		@FindBy(name = "username")
		WebElement username;

		@FindBy(name = "password")
		WebElement password;

		@FindBy(xpath = "//button[normalize-space()='Login']")
		WebElement loginBtn;

		@FindBy(xpath = "//span[normalize-space()='Dashboard']")
		WebElement dashboardText;
		// Click PIM menu
		@FindBy(xpath = "//span[text()='PIM']")
		WebElement pimMenu;

		// Input field
		@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
		WebElement employeeNameInput;

		// Actions
		public void login(String user, String pass) {
			wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
			password.sendKeys(pass);
			loginBtn.click();
		}

		public String getDashboardText() {
			wait.until(ExpectedConditions.visibilityOf(dashboardText));
			return dashboardText.getText();
		}
		// Click PIM
		public void clickPIM() {
			wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
		}

		// Get input field value
		public String getEmployeeNameText() {
			wait.until(ExpectedConditions.visibilityOf(employeeNameInput));
			return employeeNameInput.getText();



		}
	}






