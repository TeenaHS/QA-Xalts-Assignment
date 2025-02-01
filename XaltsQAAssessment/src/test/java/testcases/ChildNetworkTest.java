package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ChildNetwork;
import pages.SignInPage;

public class ChildNetworkTest extends BaseTest {

	private void signIn(String email, String password) {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickSignIn();
		signInPage.clickalreadyHaveAccount();
		signInPage.enterEmail(email);
		signInPage.enterPassword(password);
		signInPage.clickSignInButton();
	}

	@Test
	public void testSuccessfulChildNetwork() {
		signIn("teena123@gmail.com", "Teena@123");

		ChildNetwork childNetwork = new ChildNetwork(driver);
		childNetwork.clickGetStarted();
		childNetwork.verifyChildNetworkHeader();
		childNetwork.enterNetworkName("Network-1");
		childNetwork.enterWalletAddress("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
		childNetwork.clickNextButton();
		childNetwork.enterNodeID("NodeID-3");
		childNetwork.enterIPAddress("192.168.4.4");
		childNetwork.clickAddNodeButton();
		childNetwork.enterNodeID("NodeID-4");
		childNetwork.enterIPAddress("192.168.4.4");
		childNetwork.clickAddNodeButton();
		childNetwork.clickNextButton();
		childNetwork.clickSubmitButton();
	}

	@Test
	public void testChildNetworkWithInvalidWalletAddress() {
		signIn("teena123@gmail.com", "Teena@123");

		ChildNetwork childNetwork = new ChildNetwork(driver);
		childNetwork.clickGetStarted();
		childNetwork.verifyChildNetworkHeader();
		childNetwork.enterNetworkName("Network-1");
		childNetwork.enterWalletAddress("0x1234567890!");
		boolean isNextButtonEnabled = childNetwork.isNextButtonEnabled();
		Assert.assertFalse(isNextButtonEnabled, "Next button should be disabled for invalid inputs.");
	}

	@Test
	public void testChildNetworkWithoutNetworkName() {
		signIn("teena123@gmail.com", "Teena@123");

		ChildNetwork childNetwork = new ChildNetwork(driver);
		childNetwork.clickGetStarted();
		childNetwork.verifyChildNetworkHeader();
		childNetwork.enterWalletAddress("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
		boolean isNextButtonEnabled = childNetwork.isNextButtonEnabled();
		Assert.assertFalse(isNextButtonEnabled, "Next button should be disabled for invalid inputs.");
	}

	@Test
	public void testChildNetworkWithInvalidNodeID() {
		signIn("teena123@gmail.com", "Teena@123");

		ChildNetwork childNetwork = new ChildNetwork(driver);
		childNetwork.clickGetStarted();
		childNetwork.verifyChildNetworkHeader();
		childNetwork.enterNetworkName("Network-1");
		childNetwork.enterWalletAddress("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
		childNetwork.clickNextButton();
		childNetwork.enterNodeID("Node123");
		childNetwork.enterIPAddress("192.168.4.4");
		boolean isAddNodeButtonEnabled = childNetwork.isAddNodeButtonEnabled();
		Assert.assertFalse(isAddNodeButtonEnabled, "Add-node button should be disabled for invalid inputs.");
		boolean isNextButtonEnabled = childNetwork.isNextButtonEnabled();
		Assert.assertFalse(isNextButtonEnabled, "Next button should be disabled for invalid inputs.");
	}

}
