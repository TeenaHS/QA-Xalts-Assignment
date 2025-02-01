package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

	@Test
	public void testSuccessfulSignUp() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickGetStarted();
		signUpPage.enterEmail("teena1234@gmail.com");
		signUpPage.enterPassword("Teena@123");
		signUpPage.enterConfirmPassword("Teena@123");
		signUpPage.clickSignUp();
		Assert.assertTrue(driver.getCurrentUrl().contains("app"));
	}

	@Test
	public void testSignUpWithInvalidEmailPattern() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickGetStarted();
		signUpPage.enterEmail("teena1234");
		signUpPage.enterPassword("Teena@123");
		signUpPage.enterConfirmPassword("Teena@123");
		boolean isSignUpButtonEnabled = signUpPage.isSignUpButtonEnabled();
		Assert.assertFalse(isSignUpButtonEnabled, "Sign-Up button should be disabled for invalid inputs.");
	}

	@Test
	public void testSignUpWithAlreadyRegisteredEmail() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickGetStarted();
		signUpPage.enterEmail("teena1234@gmail.com");
		signUpPage.enterPassword("Teena@123");
		signUpPage.enterConfirmPassword("Teena@123");
		signUpPage.clickSignUp();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "Provided E-Mail is already in use");
		alert.accept();
	}

	@Test
	public void testSignUpWithInvalidPassword() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickGetStarted();
		signUpPage.enterEmail("teena1234@gmail.com");
		signUpPage.enterPassword("Teena@1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(signUpPage.errorMessage));
		System.out.println("Actual Error Message: " + signUpPage.getErrorMessageText());
		String expectedErrorMessage = "Password must contain atelast one lowercase letter, uppercase letter, number and special character and be a minimum of 8 characters in length";
		Assert.assertTrue(signUpPage.isErrorMessageDisplayed(expectedErrorMessage), "Error message does not match!");

	}

	@Test
	public void testSignUpWithoutEmailAndPassword() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickGetStarted();
		boolean isSignUpButtonEnabled = signUpPage.isSignUpButtonEnabled();
		Assert.assertFalse(isSignUpButtonEnabled, "Sign-Up button should be disabled for invalid inputs.");
	}

}
