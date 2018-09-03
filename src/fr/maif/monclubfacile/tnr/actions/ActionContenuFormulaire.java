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
import fr.maif.monclubfacile.tnr.actions.ActionAccueil;
import fr.maif.monclubfacile.tnr.actions.ActionContenuFormulaire;
import fr.maif.monclubfacile.tnr.modules.Accueil;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class ActionContenuFormulaire {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
   	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	
	
	
	
	/*
	public void IdentifConnexion(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - V�rification de l'identifiant de connexion du soc ",logger, driver);
		verif.IdentifConnexion(logger, driver, "IDENTIFIANTS DE CONNEXION", "Email :", "Mot de passe : ");
		Thread.sleep(3000); 
	
	} */
}
