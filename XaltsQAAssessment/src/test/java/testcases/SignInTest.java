package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SignInPage;

public class SignInTest extends BaseTest {

	@Test
	public void testSuccessfulSignIn() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickSignIn();
		signInPage.clickalreadyHaveAccount();
		signInPage.enterEmail("teena123@gmail.com");
		signInPage.enterPassword("Teena@123");
		signInPage.clickSignInButton();
	}

	@Test
	public void testSignInWithUnregisteredEmail() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickSignIn();
		signInPage.clickalreadyHaveAccount();
		signInPage.enterEmail("teena1@gmail.com");
		signInPage.enterPassword("Teena@123");
		signInPage.clickSignInButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "User not found");
		alert.accept();
	}

	@Test
	public void testSignInWithIncorrectdPassword() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickSignIn();
		signInPage.clickalreadyHaveAccount();
		signInPage.enterEmail("teena123@gmail.com");
		signInPage.enterPassword("Teena@12");
		signInPage.clickSignInButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "Incorrect E-Mail or Password");
		alert.accept();
	}

	@Test
	public void testSignInWithInvalidEmailFormat() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickSignIn();
		signInPage.clickalreadyHaveAccount();
		signInPage.enterEmail("teena1");
		signInPage.enterPassword("Teena@123");
		boolean isSignInButtonEnabled = signInPage.isSignInButtonEnabled();
		Assert.assertFalse(isSignInButtonEnabled, "Sign-Up button should be disabled for invalid inputs.");
	}

}
