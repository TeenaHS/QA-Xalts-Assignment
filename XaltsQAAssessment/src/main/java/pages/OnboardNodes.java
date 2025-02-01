package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnboardNodes {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement getStarted;

	@FindBy(xpath = "//div/h2[contains(text(),'Onboard OCN Node')]")
	private WebElement onboardNode;

	@FindBy(xpath = "(//input[@id='outlined-basic'])[1]")
	private WebElement node;

	@FindBy(xpath = "(//input[@id='outlined-basic'])[2]")
	private WebElement ip;

	@FindBy(xpath = "//button[contains(text(),'Add Node')]")
	private WebElement addNodeButton;

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButton;

	@FindBy(css = "input[type='text']")
	private WebElement walletAddress;

	@FindBy(xpath = "//div[@id='node-type-select']")
	private WebElement dropdown;

	@FindBy(xpath = "//li[@data-value='TRANSACTION_SUBMIT']")
	private WebElement transactionSubmitOption;

	@FindBy(xpath = "//button[text()=' + Add Wallet ']")
	private WebElement addWallet;

	@FindBy(xpath = "//li[@data-value='CONTRACT_DEPLOY']")
	WebElement contractDeploymentOption;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitButton;

	public OnboardNodes(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void clickGetStarted() {
		wait.until(ExpectedConditions.visibilityOf(getStarted));
		getStarted.click();
	}

	public void verifyOnboardNodeHeader() {
		wait.until(ExpectedConditions.visibilityOf(onboardNode));
		onboardNode.click();
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

	public void clickNextButton() {
		nextButton.click();
	}

	public void enterWalletAddress(String address) {
		walletAddress.sendKeys(address);
	}

	public void selectTransactionSubmitOption() {
		dropdown.click();
		wait.until(ExpectedConditions.visibilityOf(transactionSubmitOption));
		transactionSubmitOption.click();
	}

	public void clickAddWalletButton() {
		addWallet.click();
	}

	public void selectContractDeploymentOption() {
		dropdown.click();
		wait.until(ExpectedConditions.visibilityOf(contractDeploymentOption));
		contractDeploymentOption.click();
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
