package fr.maif.monclubfacile.tnr.scenarii;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.Statut;
import fr.maif.monclubfacile.tnr.actions.ActionInscriptionNonSoc;
import fr.maif.monclubfacile.tnr.modules.InscriptionNonSocietaire;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings("unused")
public class NonSocietaire { 
	
	private InscriptionNonSocietaire insc = new InscriptionNonSocietaire();
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
    private Login connectEpMcf = new Login();
	private OpenWebSite opensite = new OpenWebSite();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	//private String baseUrl = "https://monclubfacile.preprod.opunmaif.fr/";
	


	@Parameters({ "platform", "browser", "version", "baseUrl" })
	
	@BeforeTest(alwaysRun = true)
	  
	/**	
	 * Lancement Machine distante
	 * 
	 * @param platform
	 * @param browser
	 * @param version
	 * @param baseUrl
	 * @throws Exception
	 */
	
	public void setUp(String platform, String browser, String version, String baseUrl) throws Exception {
		PropertyConfigurator.configure(bundle.getString("filelog4jTNR"));
		try {
			driver = opensite.openLocal(platform, browser, version, baseUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lancement en local
	 * ok 
	 * @throws Exception
	 */


	@Test
	public void TestMCF() throws Exception {
		try {
			LaunchTest();
		} catch (TimeoutException eTime) {
			LaunchTest();
		}
	}
	
	private void LaunchTest() throws Exception {
		insc.ClubNonSocMaif(driver, logger); 
		insc.InscriptionNonSocMCF(driver, logger);  
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

}

