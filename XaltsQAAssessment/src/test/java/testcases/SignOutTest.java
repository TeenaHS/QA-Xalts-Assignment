package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.SignInPage;
import pages.SignOutPage;

public class SignOutTest extends BaseTest {

	private void signIn(String email, String password) {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickSignIn();
		signInPage.clickalreadyHaveAccount();
		signInPage.enterEmail(email);
		signInPage.enterPassword(password);
		signInPage.clickSignInButton();
	}

	@Test
	public void testSuccessfulSignOut() {
		signIn("teena123@gmail.com", "Teena@123");

		SignOutPage signOutPage = new SignOutPage(driver);
		signOutPage.clickSignOut();
	}

}
