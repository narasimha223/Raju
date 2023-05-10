package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(id="input-email")
private WebElement emailAddressField;

@FindBy(id="input-password")
private WebElement passwordField;

@FindBy(xpath="//input[@value='Login']")
private WebElement loginButton;

public void enterEmailAddress(String emailText) {
	emailAddressField.sendKeys(emailText);
}
public void enterpassword(String passwordText) {
	passwordField.sendKeys(passwordText);
}
public AccountPage clickLoginButton() {
	loginButton.click();
	return new AccountPage(driver);
}
}
