package com.SeleniumDashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMLoginTest {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		// step 1: launch browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// step 2 : open OrangeHRM login page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// step 3: Explicit wait steps
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// step 4: wait for userName filed and enter value
		WebElement  username = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.name("username"))
		);
		username.sendKeys("Admin");
		
		// step 5: wait for password filed and enter value
		WebElement password = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.name("password"))
		);
		password.sendKeys("admin123");
		
		// step 6: wait for login button filed and click.
		WebElement loginBtn = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Login ']"))
		);
		loginBtn.click();
		
		// step 7: validate Dashboard  (after login)
		WebElement dashboard = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']"))
		);
		if(dashboard.isDisplayed()) {
		System.out.println("Login sunccessful - dashboard is visible");
		}
		else {
			System.out.println("Login failed");
		}
		
		// step 8 close browser
		driver.quit();
	}

}
