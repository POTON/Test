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
public class ActionVerifTbaleauDeBord {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	//private ActionMonCompte actCompte = new ActionMonCompte(); 
	
	private ActionTabMenu actTable = new ActionTabMenu(); 
	//private ActionModuleReglement actReglement = new ActionModuleReglement(); 
	//private ActionModulePaiementLigne actPaiLigne = new ActionModulePaiementLigne(); 
	
	public void MenuAdherentCommandesPaye(WebDriver driver, Logger logger) throws Exception {
		actTable.ClickTableauDeBo(logger, driver); 
		actTable.PrenomAdherent(logger, driver);
		actTable.Adherent(logger, driver); 
		actTable.Commandes(logger, driver);  
		actTable.Payes(logger, driver); 
	} 
	 
	public void MenuReglement(WebDriver driver, Logger logger) throws Exception {
		actTable.Reglement(logger, driver); 
	}
	
	public void ModulePaiementEnLigne(WebDriver driver, Logger logger) throws Exception { 
		actTable.PaiementEnLigne(logger, driver);   
		
	} 
	
	public void ModuleDerniersInscrits(WebDriver driver, Logger logger) throws Exception { 
		actTable.DerniersInscrits(logger, driver);   
		
	} 
	
}
