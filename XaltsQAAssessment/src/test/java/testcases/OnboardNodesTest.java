package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.OnboardNodes;
import pages.SignInPage;

public class OnboardNodesTest extends BaseTest {

	private void signIn(String email, String password) {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickSignIn();
		signInPage.clickalreadyHaveAccount();
		signInPage.enterEmail(email);
		signInPage.enterPassword(password);
		signInPage.clickSignInButton();
	}

	@Test
	public void testSuccessfulOnboardNode() {
		signIn("teena123@gmail.com", "Teena@123");

		OnboardNodes onboard = new OnboardNodes(driver);
		onboard.clickGetStarted();
		onboard.verifyOnboardNodeHeader();
		onboard.enterNodeID("NodeID-1");
		onboard.enterIPAddress("192.168.1.1");
		onboard.clickAddNodeButton();
		onboard.clickNextButton();
		onboard.enterWalletAddress("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
		onboard.selectTransactionSubmitOption();
		onboard.clickAddWalletButton();
		onboard.clickNextButton();
		onboard.clickSubmitButton();
	}

	@Test
	public void testSuccessfulMultipleOnboardNode() {
		signIn("teena123@gmail.com", "Teena@123");

		OnboardNodes onboard = new OnboardNodes(driver);
		onboard.clickGetStarted();
		onboard.verifyOnboardNodeHeader();
		onboard.enterNodeID("NodeID-1");
		onboard.enterIPAddress("192.168.1.1");
		onboard.clickAddNodeButton();
		onboard.enterNodeID("NodeID-2");
		onboard.enterIPAddress("192.168.1.2");
		onboard.clickAddNodeButton();
		onboard.clickNextButton();
		onboard.enterWalletAddress("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
		onboard.selectTransactionSubmitOption();
		onboard.clickAddWalletButton();
		onboard.enterWalletAddress("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
		onboard.selectContractDeploymentOption();
		onboard.clickAddWalletButton();
		onboard.clickNextButton();
		onboard.clickSubmitButton();
	}

	@Test
	public void testSuccessfulDuplicateOnboardNode() {
		signIn("teena123@gmail.com", "Teena@123");

		OnboardNodes onboard = new OnboardNodes(driver);
		onboard.clickGetStarted();
		onboard.verifyOnboardNodeHeader();
		onboard.enterNodeID("NodeID-1");
		onboard.enterIPAddress("192.168.1.1");
		onboard.clickAddNodeButton();
		onboard.enterNodeID("NodeID-2");
		onboard.enterIPAddress("192.168.1.1");
		onboard.clickAddNodeButton();
		onboard.clickNextButton();
		onboard.enterWalletAddress("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
		onboard.selectTransactionSubmitOption();
		onboard.clickAddWalletButton();
		onboard.enterWalletAddress("0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb");
		onboard.selectContractDeploymentOption();
		onboard.clickAddWalletButton();
		onboard.clickNextButton();
		onboard.clickSubmitButton();
	}

	@Test
	public void testOnboardNodeWithInvalidIP() {
		signIn("teena123@gmail.com", "Teena@123");

		OnboardNodes onboard = new OnboardNodes(driver);
		onboard.clickGetStarted();
		onboard.verifyOnboardNodeHeader();
		onboard.enterNodeID("NodeID-1");
		onboard.enterIPAddress("192.168.1");
		boolean isAddNodeButtonEnabled = onboard.isAddNodeButtonEnabled();
		Assert.assertFalse(isAddNodeButtonEnabled, "Add-node button should be disabled for invalid inputs.");
		boolean isNextButtonEnabled = onboard.isNextButtonEnabled();
		Assert.assertFalse(isNextButtonEnabled, "Next button should be disabled for invalid inputs.");

	}

	@Test
	public void testOnboardNodeWithInvalidNodeID() {
		signIn("teena123@gmail.com", "Teena@123");

		OnboardNodes onboard = new OnboardNodes(driver);
		onboard.clickGetStarted();
		onboard.verifyOnboardNodeHeader();
		onboard.enterNodeID("Node123");
		onboard.enterIPAddress("192.168.1.1");
		boolean isAddNodeButtonEnabled = onboard.isAddNodeButtonEnabled();
		Assert.assertFalse(isAddNodeButtonEnabled, "Add-node button should be disabled for invalid inputs.");
		boolean isNextButtonEnabled = onboard.isNextButtonEnabled();
		Assert.assertFalse(isNextButtonEnabled, "Next button should be disabled for invalid inputs.");

	}

	@Test
	public void testOnboardNodeWithoutNodeAndIP() {
		signIn("teena123@gmail.com", "Teena@123");

		OnboardNodes onboard = new OnboardNodes(driver);
		onboard.clickGetStarted();
		onboard.verifyOnboardNodeHeader();
		boolean isNextButtonEnabled = onboard.isNextButtonEnabled();
		Assert.assertFalse(isNextButtonEnabled, "Next button should be disabled for invalid inputs.");
	}
}
