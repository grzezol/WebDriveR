package WebDriverExer;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;

public class HomePage extends BaseBrowsers {


	String emailAddress;
	String password1;

	@Before
	public void setup() throws IOException {
		driver = initializeWebDriver(); // metoda initialize zwraca drivera
		driver.get(prop.getProperty("url"));
		emailAddress = "pidzi@wp.pl";
		password1 = "pas12345";

	}

	@Test
	public void pageNavigationcheck() throws IOException {

		LandingPage landP = new LandingPage(driver); 
		//TC Home page check title and NaviBar
		Assert.assertEquals(landP.driver.getTitle(),"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
		Assert.assertEquals(landP.getLandingPageTitle().getText(), "FEATURED COURSES");
		Assert.assertTrue(landP.getNavbarRight().isDisplayed());
		landP.getLogin().click();

		//TC login page, incorrect value and reset password
		LoginPage logP = new LoginPage(driver);
		Assert.assertEquals(logP.driver.getTitle(), prop.getProperty("loginPageTitle"));
		logP.getEmail().sendKeys(emailAddress);
		logP.getPassword().sendKeys(password1);
		logP.getLoginButton().click();
		Assert.assertEquals(logP.getErrorMessage().getText(), "Invalid email or password");
		
		logP.getForgotPassLink().click();
		Assert.assertTrue(logP.getResetPassText().isDisplayed());
	
		
		
	}

	@After
	public void teardown() {
		driver.close();
	}
}
