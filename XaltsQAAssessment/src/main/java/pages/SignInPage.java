package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signIn;

	@FindBy(xpath = "//button[contains(text(),'Already have an account? Click here to sign in.')]")
	private WebElement alreadyHaveAccount;

	@FindBy(xpath = "(//input[@id='outlined-basic'])[1]")
	private WebElement emailField;

	@FindBy(css = "input[type='password'][aria-invalid='true']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSignIn() {
		signIn.click();
	}

	public void clickalreadyHaveAccount() {
		alreadyHaveAccount.click();
	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public boolean isSignInButtonEnabled() {
		return signInButton.isEnabled();
	}

	public void clickSignInButton() {
		signInButton.click();
	}

}
