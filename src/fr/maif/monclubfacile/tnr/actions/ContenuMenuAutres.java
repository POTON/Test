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
public class ContenuMenuAutres {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private ActionAssistance actCol = new ActionAssistance(); 
	
	
	public void ContenuAutres(WebDriver driver, Logger logger) throws Exception {
		actCol.ClickAssistance(logger, driver); 
		actCol.ContenuAssistance(logger, driver); 
		 
	} 
	 
	
}
