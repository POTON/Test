package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionAccueil;

@SuppressWarnings("unused")
public class Accueil {
	private WebDriver driver; 
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	
private ActionAccueil actAccueil = new ActionAccueil();
	
	
	public void VerificationAccueil(Logger logger, WebDriver driver) throws Exception { 
		actAccueil.Header(logger, driver); 
		actAccueil.Menus(logger, driver);
		actAccueil.Footer(logger, driver);  
	}

}
