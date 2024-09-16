package com.automation.script.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginlogout {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://stage-hrm.relinns.in/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("admin@relinns.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("12345678");	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button")).click();

		driver.wait(2000);
		driver.close();
	}

}
