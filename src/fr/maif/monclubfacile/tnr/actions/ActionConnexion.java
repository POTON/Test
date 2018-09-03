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
//import fr.maif.nomduprojet.tnr.modules.Inscription;
import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.Statut;
import fr.maif.monclubfacile.tnr.actions.ActionAccueil;
import fr.maif.monclubfacile.tnr.actions.ActionConnexion;
import fr.maif.monclubfacile.tnr.modules.Accueil;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class ActionConnexion {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private Login connectEpMcf = new Login();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	//private String baseUrl = "https://monclubfacile.preprod.opunmaif.fr/";
	
	public void OuvPageConnex(Logger logger, WebDriver driver) throws IOException, Exception { 
		
		log.reportLogTNRInfo("CONNEXION - MON CLUB FACILE - ",logger, driver);
		verif.OuvrirPageConnexion(logger, driver, "CONNEXION");  
		Thread.sleep(2000);
	
	}
	
	
	public void AppelerLogin(Logger logger, WebDriver driver) throws IOException, Exception { 
		
		log.reportLogTNRInfo(" Au Click sur 'Oui' On est dirigé vers la page d'authentification de Mon Club Facile ",logger, driver);
		connectEpMcf.loginConEpSocMCF(logger, driver, "ACCÉDER À MON COMPTE", "Adresse e-mail", "ibrahima.alata@gmail.com", "Mot de passe", "Kolima24@", "SE CONNECTER", "> Mot de passe oublié?");
		Thread.sleep(2000);
		
		
		
	}

}
