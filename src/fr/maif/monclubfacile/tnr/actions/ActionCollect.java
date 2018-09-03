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
import fr.maif.monclubfacile.tnr.actions.ActionCollect;
import fr.maif.monclubfacile.tnr.modules.Accueil;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class ActionCollect {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
  	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();

	
	
	
	public void ClickMesCol(Logger logger, WebDriver driver) throws IOException, Exception {
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'Mes collectes' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[2]/a/span", logger); 
		Thread.sleep(4000);
	} 
	
	
	public void ContenuMesCollectes(Logger logger, WebDriver driver) throws IOException, Exception {
		 
		log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu de la page ' Mes collectes ' ",logger, driver);
		verif.ActionClickMesCollectes(logger, driver,/* "CREER UNE COLLECTE",*/ "PUBLIÉES [1]", "BROUILLONS [0]", "TERMINÉES [0]", "CORBEILLE [0]");  
		Thread.sleep(3000);  
		
	} 
	
public void ClickPubli(Logger logger, WebDriver driver) throws IOException, Exception {
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'Publiées' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[1]", logger); 
		Thread.sleep(4000);
	} 
	
public void ContenuPub(Logger logger, WebDriver driver) throws IOException, Exception {
	 
	log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu de la page ' Mes collectes ' ",logger, driver);
	verif.ActionClickPubli(logger, driver, "ALATA", "ADHÉSION - fin le 06/08/2022", "ADHÉRENT", "COMMANDÉS", "PAYÉS", "VOIR MA PAGE"); 
	Thread.sleep(3000);  
	
} 


public void ClickBrouil(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'BROUILLONS' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[2]", logger); 
	Thread.sleep(2000);
} 

public void ClickTerm(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'TERMINÉES' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[3]", logger); 
	Thread.sleep(2000);
} 


public void ClickCor(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'CORBEILLES' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[4]", logger); 
	Thread.sleep(2000);
} 


	/*
	public void IdentifConnexion(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Vérification de l'identifiant de connexion du soc ",logger, driver);
		verif.IdentifConnexion(logger, driver, "IDENTIFIANTS DE CONNEXION", "Email :", "Mot de passe : ");
		Thread.sleep(3000); 
	
	} */
}
