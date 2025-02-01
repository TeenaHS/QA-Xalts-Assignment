package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignOutPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//button[text()='Sign Out']")
	private WebElement signOutButton;

	public SignOutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void clickSignOut() {
		wait.until(ExpectedConditions.visibilityOf(signOutButton));
		signOutButton.click();
	}
}