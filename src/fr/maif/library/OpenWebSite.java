package fr.maif.library;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenWebSite {

	public WebDriver driver;

	/**
	 * Fonction d'initialisation des tests en Local
	 * Nota : avoir chromium portable /firefox portable. La fonction considère qu'ils sont dans le chemin suivant :
	 * D:\AppPortable\Chromium et D:\AppPortable\Firefox
	 * Dézipper le fichier AppPortable présent dans le fichier src à la racine du lecteur D: 
	 * @param platform --> indiquez dans le fichier XML
	 * @param browser --> indiquez dans le fichier XML
	 * @param version --> indiquez dans le fichier XML
	 * @param baseUrl --> indiquez dans le fichier XML
	 * @return
	 * @throws MalformedURLException
	 */
	public WebDriver openLocal(String platform, String browser, String version, String baseUrl) throws MalformedURLException {

		if (browser.equals(Browser.chrome.toString())) {
			System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(ChromeOptions.CAPABILITY,options);
			driver = new ChromeDriver(cap);
		}
		if (browser.equals(Browser.firefox.toString())) {
			System.setProperty("webdriver.gecko.driver", "src/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browser.equals(Browser.edge.toString())) {
			System.setProperty("webdriver.edge.driver", "src/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		if (browser.equals(Browser.ie.toString())) {
			System.setProperty("webdriver.ie.driver", "src/IEDriver.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get(baseUrl);

		return driver;
	}
	
	/**
	 * Fonction d'initialisation du lancement du test à distance sur PWF10343
	 * @param platform : le système d'exploitation --> indiquez dans le fichier XML
	 * @param browser --> indiquez dans le fichier XML
	 * @param version --> indiquez dans le fichier XML
	 * @param baseUrl --> indiquez dans le fichier XML
	 * @return
	 * @throws MalformedURLException
	 */
	public WebDriver openRemote(String platform, String browser, String version, String baseUrl) throws MalformedURLException {

		if (browser.equals(Browser.chrome.toString())) {
			System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(ChromeOptions.CAPABILITY,options);
			driver = new ChromeDriver(cap);
		}
		if (browser.equals(Browser.firefox.toString())) {
			System.setProperty("webdriver.gecko.driver", "src/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browser.equals(Browser.edge.toString())) {
			System.setProperty("webdriver.edge.driver", "src/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		if (browser.equals(Browser.ie.toString())) {
			System.setProperty("webdriver.ie.driver", "src/IEDriver.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get(baseUrl);

		return driver;
	}

}