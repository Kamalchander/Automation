package com.automation.script.automation;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginlogout {

	private WebDriver driver;
	private WebDriverWait wait;

	// Constant for URL, Locators, Fields etc..
	private static final String URL = "https://stage-hrm.relinns.in/login";
	private static final String USERNAME = "admin@relinns.com";
	private static final String PASSWORD = "12345678";
	private static final By EMAIL_FIELD = By.name("email");
	private static final By PASSWORD_FIELD = By.name("password");
	private static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/form/button");
	private static final By PROFILE_SECTION = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div[2]");
	private static final By LOGOUT_BUTTON = By.xpath("//*[@id=\"logout-icon\"]/div[2]/span");
	private static final By CONFIRM_LOGOUT_BUTTON = By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div/button[2]");

	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(URL);
	}

	// Login into ATS
	public void login(String username, String password) {
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD));
		emailField.sendKeys(username);

		WebElement passwordField = driver.findElement(PASSWORD_FIELD);
		passwordField.sendKeys(password);

		WebElement loginButton = driver.findElement(LOGIN_BUTTON);
		loginButton.click();
	}

	// Logout from ATS
	public void logout() {
		try {
			WebElement profileDropdown = wait.until(ExpectedConditions.elementToBeClickable(PROFILE_SECTION));
			profileDropdown.click();

			WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON));
			logoutButton.click();

			WebElement confirmLogoutButton = wait.until(ExpectedConditions.elementToBeClickable(CONFIRM_LOGOUT_BUTTON));
			confirmLogoutButton.click();
		} catch (Exception e) {
			System.out.println("Error during Logout" + e.getMessage());
		}

	}

	// Close the browser
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		// Create an instance of the class
		Loginlogout script = new Loginlogout();

		// Call the setup method to initialize and open the browser
		script.setup();

		// Call the login method to perform the login action
		script.login(USERNAME, PASSWORD);

		// Call the Logout method to perform the logout action
		script.logout();

		// Call the TearSown Method
		script.tearDown();
	}
}
