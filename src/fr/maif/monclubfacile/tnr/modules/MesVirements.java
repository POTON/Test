package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionDeconnexion;
import fr.maif.monclubfacile.tnr.actions.ActionVerifMesVirements;

@SuppressWarnings("unused")
public class MesVirements {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private ActionDeconnexion actDeconnex = new ActionDeconnexion();
	private ActionVerifMesVirements actVerifVir = new ActionVerifMesVirements();

	
	public void VerifMesVirements(WebDriver driver, Logger logger) throws Exception {
		actVerifVir.MenuEnAttenteDeViremt(driver, logger); 
		actVerifVir.MenuProchainVirement(driver, logger);
		actVerifVir.MenuHistoVirement(driver, logger);
		actVerifVir.MenuFrequenceVirement(driver, logger); 
		    
	}
	
	/*public void ClickTableauBord(WebDriver driver, Logger logger) throws Exception { 
		actClickTab.MenuAdheren(driver, logger);
		actClickTab.MenuCommandes(driver, logger);
		actClickTab.MenuPayes(driver, logger);
		actClickTab.MenuReglement(driver, logger);
		actClickTab.ModulePaiementEnLigne(driver, logger);		   
	}*/
	 
/*	public void Deconnexion(WebDriver driver, Logger logger) throws Exception { 
		actDeconnex.ClickDeconnexion(driver, logger); 
		
	} */
	
}
