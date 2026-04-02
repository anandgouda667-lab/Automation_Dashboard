package com.SeleniumDashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulShettyAcademy {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
        driver.findElement(By.id("inputUsername")).sendKeys("Anand");
		driver.findElement(By.name("inputPassword")).sendKeys("Admin1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		Thread.sleep(3000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Iphone");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("lenovo@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9864754626");
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		System.out.println(driver.findElement(By.cssSelector("p[class='infoMsg']")).getText());
		Thread.sleep(3000);
		driver.quit();
	}

}
