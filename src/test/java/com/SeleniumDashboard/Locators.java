package com.SeleniumDashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {
	public static void main(String[] args) {

		// 🔹 headless Setup (CI/CD friendly)
		ChromeOptions options = new ChromeOptions();
		options.addArguments("===headless=new");
		options.addArguments("======no-sandox");
		options.addArguments("====disable-dev-shm-usage");

		WebDriver driver = new ChromeDriver(options);

		// 🔹 Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// 🔹 Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();

		// 🔹 login attempt
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername"))).sendKeys("Anand");
		driver.findElement(By.name("inputPassword")).sendKeys("Admin1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// 🔹 Capture error message
		String errormsg = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error"))).getText();
		System.out.println(errormsg);

		// 🔹 click forget password
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Forgot your password?"))).click();

		// 🔹 Fill reset form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Name']")))
		.sendKeys("Iphone");

		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("lenovo@gmail.com");


		//Clear and re-enter email
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Email']")))
		.clear();

		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9864754626");

		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();


		// 🔹 Capture success message
		String infoMsg = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.infoMsg"))
				).getText();
		System.out.println(infoMsg);

		// 🔹 Close browser
		driver.quit();
	}
}
