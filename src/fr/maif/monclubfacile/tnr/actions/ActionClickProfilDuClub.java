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
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings("unused")
public class ActionClickProfilDuClub {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private ActionMonCompte actCompte = new ActionMonCompte(); 
	private ActionModulePaiement actPaiement = new ActionModulePaiement();  
	
	public void MonCompteOuProfilClub(WebDriver driver, Logger logger) throws Exception {
		actCompte.ClickMenuDepli(logger, driver); 
		actCompte.PrenomNom(logger, driver);  
		actCompte.Profil(logger, driver); 
		actCompte.Contact(logger, driver);
		actCompte.IdentifConnexion(logger, driver); 
	}
	 
	public void ModulePaiementEnLigne(WebDriver driver, Logger logger) throws Exception { 
		actPaiement.PaiementEnLigne(logger, driver);  
		
	} 
	
}
