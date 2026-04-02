package com.SeleniumDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTubeAutomation {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	   // launch application
		driver.get("https://www.youtube.com/");
		
		// verify the URl
		String url = driver.getCurrentUrl();
		System.out.println("Verify the url is: "+ url);
		
		// search name
		WebElement drop = driver.findElement(By.name("search_query"));
		
		Select select = new Select(drop);
		
		select.selectByIndex(1);
		
		Thread.sleep(3000);
		
		// scroll down window
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement text = driver.findElement(By.id("text"));
		text.click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[text()='Videos'])[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("video-title")).click();
		
		Thread.sleep(90000);
		
		
		
	}

}
