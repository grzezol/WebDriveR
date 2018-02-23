package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//By emailAdress = By.xpath("//input[@id = 'user_email']");
	//By password = By.xpath("//input[@id = 'user_password']");
	//By loginButton = By.xpath("//input[@name = 'commit']");
	//By errorMessage = By.xpath("//div[@class='alert alert-danger']");

	@FindBy(xpath = "//input[@id = 'user_email']")
	WebElement emailAdress;
	
	@FindBy(xpath = "//input[@id = 'user_password']" )
	WebElement password;
	
	@FindBy(xpath = "//input[@name = 'commit']" )
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']" )
	WebElement errorMessage;
	
	@FindBy(xpath = "//a[contains(@href,'password/new')]")
	WebElement forgotPassLink;
	
	@FindBy(xpath = "//*[contains(text(), 'Reset Password')]")
	WebElement resetPassText;
	
	public WebElement getEmail() {
		return emailAdress;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}
	public WebElement getForgotPassLink()
	{
		return forgotPassLink;
	}
	public WebElement getResetPassText()
	{
		return resetPassText;
	}

}
