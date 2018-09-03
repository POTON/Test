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
import fr.maif.monclubfacile.tnr.actions.ActionInscriptionNonSoc;
import fr.maif.monclubfacile.tnr.modules.Accueil;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class ActionAccueil {
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
    private Login connectEpMcf = new Login();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	
	public void Header(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur '  CValide les cookies ' du soc ",logger, driver);
		scriptTech.clickByXpath(driver,"/html/body/div[1]/div/a", logger);
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("Vérification du ' Header ' de Mon Club Facile ",logger, driver);
		verif.HeaderMcf(logger, driver,"Maquettes", "Documentation", "COMMENT ÇA MARCHE ?", "TARIF", "INSCRIPTION", "CONNEXION");
		Thread.sleep(3000);
		
	} 

	public void Menus(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("Vérification du ' Vérification du menu 1 : Simplifiez ... sportif ' de Mon Club Facile ",logger, driver);
		//verif.Menu1(logger, driver, "MON CLUB FACILE",*/ /*"SIMPLIFIEZ LA GESTION ADMINISTRATIVE \n DE VOTRE CLUB SPORTIF", */"INSCRIPTION");
		verif.Menu1(logger, driver, "INSCRIPTION");
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("Vérification du ' Vérification du menu 2 : 'Gérez ... en ligne' ; ' Proposez ... espèces ' ; ' Facilitez ... communauté ' de Mon Club Facile ",logger, driver);
		verif.Menu2(logger, driver); 
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("Vérification du ' Vérification du menu 3 : Un outil simple ... sécurisé ' de Mon Club Facile ",logger, driver);
		verif.Menu3(logger, driver, "MON CLUB FACILE :", "UN OUTIL SIMPLE, ÉVOLUTIF ET SÉCURISÉ", "VOIR LA VIDÉO", " LES AVANTAGES");
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("Vérification du ' Vérification du menu 4 : La Maif et le sport ",logger, driver);
		verif.Menu4(logger, driver, "LA MAIF ET LE SPORT", "La MAIF, premier assureur des associations, est depuis longtemps investie dans le domaine sportif. Le sport , générateur de confiance, véhicule des valeurs proches de celles liées à l’éducation. Notre priorité : être à l’écoute des acteurs du monde sportif pour fournir des solutions adaptées aux besoins.", "NOTRE VOLONTÉ", "Vous faire gagner du temps sur les tâches administratives et quotidiennes de votre club", "VOTRE BÉNÉFICE", "Consacrer plus de temps à vos adhérents et favoriser le développement de votre structure");
		Thread.sleep(3000); 
		
		log.reportLogTNRInfo("Vérification du ' Vérification du menu 5 :  membres 1 ",logger, driver);
		verif.Menu5_Suite(logger, driver, "DAVID, 49 ANS", "PRÉSIDENT LES 12-14 NIORT", "1"); 
		Thread.sleep(2000); 
		
		log.reportLogTNRInfo("Vérification du ' Vérification du menu 5 :  membres 2 ",logger, driver);
		verif.Menu5(logger, driver, "NATHALIE, 36 ANS", "TRÉSORIÈRE LES BASKETS EN FOLIE", "« La relance automatique permet de récupérer facilement les certificats médicaux. »", "2");
		Thread.sleep(2000); 
		
		log.reportLogTNRInfo("Vérification du ' Vérification du menu 5 :  membres 1 ",logger, driver);
		verif.Menu5(logger, driver, "FEDY, 30 ANS", "ADHÉRENT ASSOCIATION OCR 86", "« S’inscrire en ligne c’est pratique, plus besoin de se déplacer. »", "3");
		Thread.sleep(2000); 
		
	}

	public void Footer(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("Vérification du ' Vérification du Footer' de Mon Club Facile ",logger, driver);
		verif.Footer(logger, driver, "Comment ça marche ?", "Assistance", "Tarif", "Sécurité", "Qui sommes nous ?", "Avantages", "Conditions générales d'utilisation", "Mentions légales"); 
		Thread.sleep(2000); 
		
	}

}
