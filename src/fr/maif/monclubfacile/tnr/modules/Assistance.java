package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionDeconnexion;
import fr.maif.monclubfacile.tnr.actions.ActionVerifMesAssistance;
import fr.maif.monclubfacile.tnr.actions.ClickActAssistance;

@SuppressWarnings("unused")
public class Assistance {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	 
	private ActionVerifMesAssistance actVerifMesCol = new ActionVerifMesAssistance();
	private ActionDeconnexion actDeconnex = new ActionDeconnexion();
	private ClickActAssistance clickActAssistance = new ClickActAssistance(); 

	
	public void VerifAssistance(WebDriver driver, Logger logger) throws Exception {
		actVerifMesCol.ContenuAssistance(driver, logger); 
		    
	}
	
	public void ClickFormDeContact(WebDriver driver, Logger logger) throws Exception {
		clickActAssistance.ContenuFormuDeContact(driver, logger); 
		    
	}
	 
/*	public void Deconnexion(WebDriver driver, Logger logger) throws Exception { 
		actDeconnex.ClickDeconnexion(driver, logger); 
		
	} */
	
}
