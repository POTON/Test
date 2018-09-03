package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionInscriptionNonSoc;

@SuppressWarnings("unused")
public class InscriptionNonSocietaire {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	private ActionInscriptionNonSoc actInsc = new ActionInscriptionNonSoc();
	
	public void ClubNonSocMaif(WebDriver driver, Logger logger) throws Exception {
		actInsc.ClubNonSocChoix(logger, driver);  
	}
	 
	public void InscriptionNonSocMCF(WebDriver driver, Logger logger) throws Exception { 
		actInsc.IdenditeClubNonSoc(logger, driver); 
		actInsc.IdenditeCommune(logger, driver); 
		actInsc.FinaliserCompte(logger, driver);
		actInsc.CguValid(logger, driver);
	}
	
}
