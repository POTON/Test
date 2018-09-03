package fr.maif.monclubfacile.tnr.actions;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;

@SuppressWarnings("unused")
public class ClickAutresContenu {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	private ActionAutresClick actAutres = new ActionAutresClick();
	
 
	public void ContenuAutres(WebDriver driver, Logger logger) throws Exception {
		actAutres.ClickSurAutres(logger, driver); 
		Thread.sleep(2000);
	} 
	
	public void ContenuAutres0(WebDriver driver, Logger logger) throws Exception { 
		actAutres.ClickTarif(logger, driver); 
		actAutres.ContenuTarif(logger, driver); 
		Thread.sleep(2000);
	} 
	
	public void ContenuAutres1(WebDriver driver, Logger logger) throws Exception { 
		actAutres.ClickCommentCaMarche(logger, driver); 
		actAutres.ContenuCommentCaMarche(logger, driver); 
		Thread.sleep(2000); 
	} 
	
	public void ContenuAutres2(WebDriver driver, Logger logger) throws Exception { 
		actAutres.ClickSecurite(logger, driver); 
		actAutres.ContenuSecurite(logger, driver); 
		Thread.sleep(2000); 
	}
	
	public void ContenuAutres3(WebDriver driver, Logger logger) throws Exception { 
		actAutres.ClickMentionsLegales(logger, driver); 
		actAutres.ContenuMentionsLegales(logger, driver); 
		Thread.sleep(2000); 
	}
	
	public void ContenuAutres4(WebDriver driver, Logger logger) throws Exception { 
		actAutres.ClickConditionsGenerales(logger, driver); 
		actAutres.ContenuConditionsGenerales(logger, driver); 
		Thread.sleep(2000);
	}
	
	public void ContenuAutres5(WebDriver driver, Logger logger) throws Exception { 
		actAutres.ClickMaquettes(logger, driver);
		Thread.sleep(5000);
		//actAutres.ContenuMaquettes(logger, driver);
		actAutres.Fermeture(logger, log, driver); 
		Thread.sleep(5000);
		 
	}
	
	public void ContenuAutres6(WebDriver driver, Logger logger) throws Exception { 
		actAutres.ClickDocumentation(logger, driver); 
		//actAutres.ContenuDocumentation(logger, driver); 
		actAutres.Fermeture(logger, log, driver);  
	}
	
}
