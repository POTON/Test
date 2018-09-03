package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionDeconnexion;
import fr.maif.monclubfacile.tnr.actions.ActionVerifMesCollectes;

@SuppressWarnings("unused")
public class MesCollectes {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private ActionVerifMesCollectes actVerifMesCol = new ActionVerifMesCollectes();
	private ActionDeconnexion actDeconnex = new ActionDeconnexion();

	
	public void VerifMesCollectes(WebDriver driver, Logger logger) throws Exception {
		actVerifMesCol.ContenuMesCollectes(driver, logger);	    
	}
	
	public void ClickPub(WebDriver driver, Logger logger) throws Exception {
		actVerifMesCol.ContenuPubliees(driver, logger);
	    
	}
	
	public void ClickBrou(WebDriver driver, Logger logger) throws Exception {
		actVerifMesCol.ContenuBrou(driver, logger);
	    
	}
	
	public void ClickTermine(WebDriver driver, Logger logger) throws Exception {
		actVerifMesCol.ContenuTermi(driver, logger);
	    
	}
	
	public void ClickCorb(WebDriver driver, Logger logger) throws Exception {
		actVerifMesCol.ContenuCorbei(driver, logger);
	    
	}
	 
	public void Deconnexion(WebDriver driver, Logger logger) throws Exception { 
		actDeconnex.ClickDeconnexion(driver, logger); 
		
	} 
	
}
