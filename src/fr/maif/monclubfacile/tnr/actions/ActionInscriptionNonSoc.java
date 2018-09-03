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
public class ActionInscriptionNonSoc {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
 	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	
	public void ClubNonSocChoix(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("INSCRIPTION DU CLUB NON SOCIETAIRE - MON CLUB FACILE - ",logger, driver);
		verif.OuvrirPageInscription(logger, driver, "INSCRIPTION");  
		Thread.sleep(3000);
		
	}
	
	public void IdenditeClubNonSoc(Logger logger, WebDriver driver) throws IOException, Exception { 
		
		log.reportLogTNRInfo("Click sur 'Non' sur la page d'inscription de Mon Club Facile ",logger, driver);
		verif.ChoisirNon(logger, driver, "Votre club est-il soci�taire MAIF ?", "OUI", "NON"); 
		Thread.sleep(1000);
		//
		log.reportLogTNRInfo("INSCRIPTION DU CLUB NON SOCIETAIRE - MON CLUB FACILE - ",logger, driver);
		Thread.sleep(1000);
		
		log.reportLogTNRInfo("V�rification du header de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.HeaderMcf(logger, driver,"Maquettes", "Documentation", "COMMENT �A MARCHE ?", "TARIF", "INSCRIPTION", "CONNEXION");
		Thread.sleep(3000);
				
	}

	public void IdenditeCommune(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("V�rification de la colonne 'IDENTIT� DU CLUB/ASSOCIATION ' de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.IdenditeCommune(logger, driver, "IDENTIT� DU CLUB/ASSOCIATION", "Nom du club/association *", "T�l�phone *", "Adresse du club/association *", "�tes-vous affili� � une f�d�ration ou groupement national ? *", "OUI", "NON", "Activit� sportive pratiqu�e *");
		Thread.sleep(3000);
			
	}
	
	public void FinaliserCompte(Logger logger, WebDriver driver) throws IOException, Exception { 

		log.reportLogTNRInfo("V�rification de la colonne ' FINALISER VOTRE COMPTE ' de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.FinaliserCompte(logger, driver, "FINALISER VOTRE COMPTE", "Param�trez les informations qui vous permettront de vous connecter � votre compte Mon Club Facile.", "Email *", "Mot de passe *", "Confirmer votre mot de passe *");
		Thread.sleep(3000);	
		
	}
	
	public void CguValid(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("V�rification de la colonne ' Conditions g�n�rales et Valider ' de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.CguValid(logger, driver, "En cochant cette case, je reconnais avoir pris connaissance des Conditions G�n�rales d'Utilisation du service � Mon Club Facile � et je les accepte.", "VALIDER");
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("V�rification du footer de la page d'inscription de Mon Club Facile",logger, driver);
		verif.Footer(logger, driver, "Comment �a marche ?", "Assistance", "Tarif", "S�curit�", "Qui sommes nous ?", "Avantages", "Conditions g�n�rales d'utilisation", "Mentions l�gales"); 
		Thread.sleep(2000);
		
	}

}
