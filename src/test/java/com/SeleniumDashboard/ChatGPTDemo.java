package com.SeleniumDashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChatGPTDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://chatgpt.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// launch the Chatgpt
		WebElement prompt = driver.findElement(By.id("prompt-textarea"));
		prompt.sendKeys("Hey ChatGPT How are you!");
		prompt.submit();
		String message ="Hey ChatGPT How are you!";
		System.out.println(message);
		driver.quit();
	}

}
