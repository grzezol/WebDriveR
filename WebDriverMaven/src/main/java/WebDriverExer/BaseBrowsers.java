package WebDriverExer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// WedDrivera(WebDriver object) zawsze tworzyc jako global level variable, driver jest tworzony raz i pozniej z niego korzystamy
public class BaseBrowsers {
	public WebDriver driver;
	public Properties prop; //jezli tutaj zdefinujemy prop jako publiczne to bedzie mozna korzystac np do url lub innych rzeczy do zaczytywania z pliku

	public WebDriver initializeWebDriver() throws IOException

	{

		 prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Kasia&Przemek\\WebDriverMaven\\src\\main\\java\\WebDriverExer\\data.properties");
		// sciezka do pliku tego data.properties

		prop.load(file); // connection data.prop file with BaseBrowser
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {  //z propertis porownania zawsze equals
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kasia&Przemek\\Desktop\\Nauka\\chromedriver.exe");
			driver = new ChromeDriver(); // dlatego tak bo driver jest jako globalna zmiennne
			// executein chrome driver
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kasia&Przemek\\Desktop\\Nauka\\geckodriver.exe");
			driver = new FirefoxDriver();
			// execute ff driver
		} else if (browserName.equals("IE")) {
			// execute IE driver
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// jak wyjdzie driver z if to wtedy ustawimy timeout na weszystkie TC
		return driver; // zwracamy z naszej metody drivera
	}

}
