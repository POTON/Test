package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionClickTableauDeBord;
import fr.maif.monclubfacile.tnr.actions.ActionDeconnexion;
import fr.maif.monclubfacile.tnr.actions.ActionVerifTbaleauDeBord;

@SuppressWarnings("unused")
public class TableauDeBord {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	
	
	//private BroullonAction1 actClickProfilClub = new BroullonAction1();
	private ActionVerifTbaleauDeBord actVerifTab = new ActionVerifTbaleauDeBord();
	private ActionClickTableauDeBord actClickTab = new ActionClickTableauDeBord();
	private ActionDeconnexion actDeconnex = new ActionDeconnexion();

	
	public void VerifTableauBord(WebDriver driver, Logger logger) throws Exception {
		actVerifTab.MenuAdherentCommandesPaye(driver, logger);
		actVerifTab.MenuReglement(driver, logger);
		actVerifTab.ModulePaiementEnLigne(driver, logger);
		actVerifTab.ModuleDerniersInscrits(driver, logger); 
		    
	}
	
	public void ClickTableauBord(WebDriver driver, Logger logger) throws Exception { 
		actClickTab.MenuAdherenOuMenuCommandesOuMenuPayes(driver, logger);
	//	actClickTab.MenuAdheren(driver, logger);
	//	actClickTab.MenuCommandes(driver, logger);
	//	actClickTab.MenuPayes(driver, logger);
		actClickTab.MenuReglement(driver, logger);
		actClickTab.ModulePaiementEnLigne(driver, logger);		   
	}
	 
/*	public void Deconnexion(WebDriver driver, Logger logger) throws Exception { 
		actDeconnex.ClickDeconnexion(driver, logger); 
		
	} */
	
}
