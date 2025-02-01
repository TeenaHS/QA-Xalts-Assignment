package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChildNetwork {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement getStarted;

	@FindBy(xpath = "//div/h2[text()='Launch OCN Child Network']")
	private WebElement childNetwork;

	@FindBy(xpath = "(//input[@aria-invalid='true'])[1]")
	private WebElement network;

	@FindBy(xpath = "(//input[@id='outlined-basic'])[2]")
	private WebElement walletAddress;

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButton;

	@FindBy(xpath = "(//input[@id='outlined-basic'])[1]")
	private WebElement node;

	@FindBy(xpath = "(//input[@id='outlined-basic'])[2]")
	private WebElement ip;

	@FindBy(xpath = "//button[contains(text(),'Add Node')]")
	private WebElement addNodeButton;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitButton;

	public ChildNetwork(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void clickGetStarted() {
		wait.until(ExpectedConditions.visibilityOf(getStarted));
		getStarted.click();
	}

	public void verifyChildNetworkHeader() {
		childNetwork.click();
	}

	public void enterNetworkName(String networkName) {
		network.sendKeys(networkName);
	}

	public void enterWalletAddress(String address) {
		walletAddress.sendKeys(address);
	}

	public void clickNextButton() {
		nextButton.click();
	}

	public void enterNodeID(String nodeID) {
		node.sendKeys(nodeID);
	}

	public void enterIPAddress(String ipAddress) {
		ip.sendKeys(ipAddress);
	}

	public void clickAddNodeButton() {
		addNodeButton.click();
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public boolean isAddNodeButtonEnabled() {
		return addNodeButton.isEnabled();
	}

	public boolean isNextButtonEnabled() {
		return nextButton.isEnabled();
	}
}
