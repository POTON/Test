package fr.maif.monclubfacile.tnr.scenarii;

import static org.testng.Assert.fail;

import java.net.MalformedURLException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.modules.Connexion;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.ProfilClubSocietaire;
import fr.maif.monclubfacile.tnr.modules.Verif;

@SuppressWarnings("unused")
public class ProfilClubEtDeconnexion { 
	
	
	
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
	
	private Connexion connex = new Connexion(); 
	private ProfilClubSocietaire profClub = new ProfilClubSocietaire();

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
		connex.OuvrirPageConnexion(driver, logger); 
		connex.SeConnecter(driver, logger);   
		
		profClub.ProfilDuClub(driver, logger); 
		profClub.Deconnexion(driver, logger);   
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

