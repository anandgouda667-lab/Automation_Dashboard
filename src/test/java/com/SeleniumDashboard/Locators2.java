package com.SeleniumDashboard;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Locators2 {
	@Test
	public void loginTest() throws IOException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // important for CI
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {

			driver.get("https://rahulshettyacademy.com/locatorspractice/");

			driver.findElement(By.id("inputUsername")).sendKeys("Anand");
			driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			String message = wait.until(
					ExpectedConditions.visibilityOfElementLocated(
							By.cssSelector("div[class='login-container'] p"))
					).getText();

			System.out.println("Message: " + message);

			Assert.assertEquals(message, "You are successfully logged in.");
		} catch (AssertionError | Exception e) {

			// 📸 Take screenshot if test fails
			takeScreenshot(driver, "loginTest");

			throw e; // rethrow so TestNG marks test as FAILED
		} finally {
			driver.quit(); // always close browser
		}
	}
	public static void takeScreenshot(WebDriver driver, String testName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/" + testName + ".png");
		FileUtils.copyFile(src, dest);
		driver.quit();
	}

}
