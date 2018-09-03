package fr.maif.monclubfacile.tnr.actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.Statut;
import fr.maif.monclubfacile.tnr.actions.ActionInscriptionNonSoc;
import fr.maif.monclubfacile.tnr.actions.ActionInscriptionSoc;
import fr.maif.monclubfacile.tnr.actions.click.ActionClickAdherent;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings("unused")
public class ActionClickTableauDeBord {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
  	private StringBuffer verificationErrors = new StringBuffer();
	//private String baseUrl = "https://monclubfacile.preprod.opunmaif.fr/";
	//private ActionMonCompte actCompte = new ActionMonCompte(); 
	
	private ActionClickAdherent actClickTable = new ActionClickAdherent(); 
	private ActionTabMenu actTable = new ActionTabMenu();
	private ActionMesCollectes actMesCol = new ActionMesCollectes();
	//private ActionModuleReglement actReglement = new ActionModuleReglement(); 
	//private ActionModulePaiementLigne actPaiLigne = new ActionModulePaiementLigne(); 
	
	public void MenuAdherenOuMenuCommandesOuMenuPayes(WebDriver driver, Logger logger) throws Exception {
		actClickTable.ActionClickTabl(logger, driver); 
		actClickTable.ActionClickAdhe(logger, driver);	 
	} 
	
	/*public void MenuAdheren(WebDriver driver, Logger logger) throws Exception {
		actClickTable.ActionClickTabl(logger, driver); 
		actClickTable.ActionClickAdhe(logger, driver);	 
	} 
	
	public void MenuCommandes(WebDriver driver, Logger logger) throws Exception {
		actClickTable.ActionClickTabl(logger, driver);  
		actClickTable.ActionClickCommandes(logger, driver); 
	}
	
	public void MenuPayes(WebDriver driver, Logger logger) throws Exception { 
		actClickTable.ActionClickTabl(logger, driver);  
		actClickTable.ActionClickPayes(logger, driver);   
		
	} */
	 
	public void MenuReglement(WebDriver driver, Logger logger) throws Exception {
		actClickTable.ActionClickTabl(logger, driver); 
		actClickTable.ActionClickCollectes(logger, driver);  
	}
	
	public void ModulePaiementEnLigne(WebDriver driver, Logger logger) throws Exception { 
		actClickTable.ActionClickTabl(logger, driver);  
		actClickTable.ActionClickEnSavoirPlus(logger, driver);    
		
	} 
	
	
}
