package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionInscriptionSoc;

@SuppressWarnings("unused")
public class InscriptionSocietaire {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private ActionInscriptionSoc actInsc = new ActionInscriptionSoc();
	
	public void ClubSoc(WebDriver driver, Logger logger) throws Exception {
		actInsc.ClubSocChoix(logger, driver);  
	}
	 
	public void InscripSoc(WebDriver driver, Logger logger) throws Exception { 
		actInsc.IdenditeClubSoc(logger, driver); 
		actInsc.IdenditeCommune(logger, driver); 
		actInsc.FinaliserCompte(logger, driver);
		actInsc.CguValid(logger, driver);
	}
	
}
