package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionDeconnexion;
import fr.maif.monclubfacile.tnr.actions.BroullonAction1;

@SuppressWarnings("unused")
public class BroullonModule {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	private BroullonAction1 actClickProfilClub = new BroullonAction1();
	private ActionDeconnexion actDeconnex = new ActionDeconnexion();

	
	public void ProfilDuClub(WebDriver driver, Logger logger) throws Exception {
		actClickProfilClub.MonCompteOuProfilClub(driver, logger);
		actClickProfilClub.ModulePaiementEnLigne(driver, logger); 
		   
	}
	 
	public void Deconnexion(WebDriver driver, Logger logger) throws Exception { 
		actDeconnex.ClickDeconnexion(driver, logger); 
		
	}
	
}
