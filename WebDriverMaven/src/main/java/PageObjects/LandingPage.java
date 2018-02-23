package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver; 

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	
	PageFactory.initElements(driver, this);
	}

	//By signIn = By.cssSelector("a[href*='sign_in']");
	//By titleText = By.cssSelector(".text-center>h2");
	//By navbarRight = By.cssSelector("ul[class='nav navbar-nav navbar-right']");

	@FindBy(css="a[href*='sign_in']")
	WebElement signIn;
	
	@FindBy(css=".text-center>h2")
	WebElement titleText;
	
	@FindBy(css="ul[class='nav navbar-nav navbar-right']")
	WebElement navbarRight;
	
	
	public WebElement getLogin() {
		return signIn;
	}

	public WebElement getLandingPageTitle() {
		return titleText;
	}

	public WebElement getNavbarRight() {
		return navbarRight;
	}
}
