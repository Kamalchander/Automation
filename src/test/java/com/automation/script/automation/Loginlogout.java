package com.automation.script.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginlogout {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.botpenguin.com/authentication");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("developer@botpenguin.com");
		driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).click();
		driver.findElement(By.xpath("//*[@id='mat-input-1']")).sendKeys("BotPenguin@2012");
		driver.findElement(By.xpath("/html/body/app-root/div[1]/div/app-new-signup/div[2]/div/div/form/div[4]/button")).click();

		//driver.close();
	}

}
