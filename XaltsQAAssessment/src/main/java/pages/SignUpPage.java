package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver driver;

	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement getStarted;

	@FindBy(xpath = "(//input[@id='outlined-basic'])[1]")
	private WebElement emailField;

	@FindBy(css = "input[type='password'][aria-invalid='true']")
	private WebElement passwordField;

	@FindBy(css = "input[type='password'][aria-invalid='true']")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement signUpButton;

	@FindBy(xpath = "//p[contains(text(),'Password must contain atelast one lowercase')]")
	public WebElement errorMessage;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickGetStarted() {
		getStarted.click();
	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}

	public boolean isSignUpButtonEnabled() {
		return signUpButton.isEnabled();
	}

	public void clickSignUp() {
		signUpButton.click();
	}

	public String getErrorMessageText() {
        return errorMessage.getText().trim();
    }

    public boolean isErrorMessageDisplayed(String expectedMessage) {
        return getErrorMessageText().equals(expectedMessage.trim());
    }

}
