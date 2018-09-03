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
public class ActionVerifMesVirements {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	//private String baseUrl = "https://monclubfacile.preprod.opunmaif.fr/";
	//private ActionMonCompte actCompte = new ActionMonCompte(); 
	
	
	private ActionMesVirementsMenu actVirementVerif = new ActionMesVirementsMenu();   
	//private ActionModuleReglement actReglement = new ActionModuleReglement(); 
	//private ActionModulePaiementLigne actPaiLigne = new ActionModulePaiementLigne(); 
	
	public void MenuEnAttenteDeViremt(WebDriver driver, Logger logger) throws Exception {
		actVirementVerif.ClickMesVirements(logger, driver); 
		actVirementVerif.EnAttente(logger, driver);

	}  
	 
	public void MenuProchainVirement(WebDriver driver, Logger logger) throws Exception { 
		actVirementVerif.ClickMesVirements(logger, driver); 
		actVirementVerif.ProchainVir(logger, driver);  
	}
	
	public void MenuHistoVirement(WebDriver driver, Logger logger) throws Exception { 
		actVirementVerif.ClickMesVirements(logger, driver); 
		actVirementVerif.ClickHistoDesVirements(logger, driver); 
		actVirementVerif.HistoVir(logger, driver);   
		
	} 
	
	public void MenuFrequenceVirement(WebDriver driver, Logger logger) throws Exception { 
		actVirementVerif.ClickMesVirements(logger, driver); 
		actVirementVerif.FreqVirement(logger, driver);    
		
	}  
	
}
