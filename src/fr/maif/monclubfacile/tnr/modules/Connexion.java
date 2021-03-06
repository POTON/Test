package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionConnexion;

@SuppressWarnings("unused")
public class Connexion {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private ActionConnexion actConnex = new ActionConnexion();
	
	public void OuvrirPageConnexion(WebDriver driver, Logger logger) throws Exception {
		actConnex.OuvPageConnex(logger, driver);  
	}
	 
	public void SeConnecter(WebDriver driver, Logger logger) throws Exception { 
		actConnex.AppelerLogin(logger, driver); 
		
	} 
	
}
