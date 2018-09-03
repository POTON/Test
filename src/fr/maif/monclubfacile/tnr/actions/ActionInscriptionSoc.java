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
import fr.maif.monclubfacile.tnr.actions.ActionInscriptionSoc;
import fr.maif.monclubfacile.tnr.modules.Accueil;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class ActionInscriptionSoc {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
    private Login connectEpMcf = new Login();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();

	
	
	public void ClubSocChoix(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur '  CValide les cookies ' du soc ",logger, driver);
		scriptTech.clickByXpath(driver,"/html/body/div[1]/div/a", logger);
		Thread.sleep(2000);
		
		log.reportLogTNRInfo("INSCRIPTION DU CLUB - SOCIETAIRE - MON CLUB FACILE - ",logger, driver);
		verif.OuvrirPageInscription(logger, driver, "INSCRIPTION");  
		Thread.sleep(2000);
		
	} 
	
	public void InscriptionSocMCF(Logger logger, WebDriver driver) throws IOException, Exception { 
		
		log.reportLogTNRInfo("Click sur 'OUI' sur la page d'inscription de Mon Club Facile ",logger, driver);
		verif.ChoixOui(logger, driver, "Votre club est-il sociétaire MAIF ?", "OUI", "NON");  
		Thread.sleep(2000);
		
	}

	public void IdenditeClubSoc(Logger logger, WebDriver driver) throws IOException, Exception {  
		log.reportLogTNRInfo("Click sur 'Oui' sur la page d'inscription de Mon Club Facile ",logger, driver);
		verif.ChoixOui(logger, driver, "Votre club est-il sociétaire MAIF ?", "OUI", "NON");
		Thread.sleep(2000);
		
		// ********  APPELER LA PAGE LOGIN ******
		log.reportLogTNRInfo(" Au Click sur 'Oui' On est dirigé vers la page d'authentification de Mon Club Facile ",logger, driver);
		connectEpMcf.loginEpMCF(logger, driver, "Adresse e-mail ou identifiant *", "3067230R", "Mot de passe *", "Maif1234", "IDENTIFIANT OU MOT DE PASSE OUBLIÉ ?", "SE CONNECTER");
		Thread.sleep(2000);
		
		log.reportLogTNRInfo("Vérification du header de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.HeaderMcf(logger, driver,"Maquettes", "Documentation", "COMMENT ÇA MARCHE ?", "TARIF", "INSCRIPTION", "CONNEXION");
		Thread.sleep(2000);
			
	}
	
	public void IdenditeCommune(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("PARTI PRE-REMPLI - INSCRIPTION DU CLUB SOCIETAIRE - Vérification de la colonne 'IDENTITÉ DU CLUB/ASSOCIATION ' de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.IdenditeCommuneSocPreRempli(logger, driver, "IDENTITÉ DU CLUB/ASSOCIATION", "Nom du club/association *", "Téléphone *", "Adresse du club/association *", "Code postal/Ville *"); 
		//verif.IdenditeCommuneSocPreRempli(logger, driver, "IDENTITÉ DU CLUB/ASSOCIATION", "Nom du club/association *",/* "SAPFR",*/ "Téléphone *", "03 83 28 80 28", "Adresse du club/association *", "11 RUE JEAN JAURES", "Code postal/Ville *");
		Thread.sleep(3000);
		 
		// Cas 1: IDENTITÉ DU CLUB/ASSOCIATION - PARTI NON PRE-REMPLI - Click sur 'NON' à partir de la question  'Êtes-vous affilié
		log.reportLogTNRInfo(" 'IDENTITÉ DU CLUB/ASSOCIATION - PARTI NON PRE-REMPLI - Click sur 'NON' à partir de la question  'Êtes-vous affilié à une fédération ou groupement national ? *' de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.IdenditeCommuneSocNonRempliClickNon(logger, driver, "Êtes-vous affilié à une fédération ou groupement national ? *", "OUI", "NON"/*, "Activité sportive pratiquée *"*/); 
		Thread.sleep(3000);

		
		//Cas 2 : IDENTITÉ DU CLUB/ASSOCIATION - PARTI NON PRE-REMPLI - Click sur 'OUI' à partir de la question  'Êtes-vous affilié
		log.reportLogTNRInfo(" 'IDENTITÉ DU CLUB/ASSOCIATION - PARTI NON PRE-REMPLI - Click sur 'OUI' à partir de la question  'Êtes-vous affilié à une fédération ou groupement national ? *' de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.IdenditeCommuneSocNonRempliClickOui(logger, driver, "Êtes-vous affilié à une fédération ou groupement national ? *", "OUI", "NON", "Précisez laquelle *", "Activité sportive pratiquée *"); 
		Thread.sleep(3000);
		
		
	}

	public void FinaliserCompte(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("Vérification de la colonne ' FINALISER VOTRE COMPTE ' de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.FinaliserCompte(logger, driver, "FINALISER VOTRE COMPTE", "Paramétrez les informations qui vous permettront de vous connecter à votre compte Mon Club Facile.", "Email *", "Mot de passe *", "Confirmer votre mot de passe *");
		Thread.sleep(3000);
			
	}
	
	public void CguValid(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("Vérification de la colonne ' Conditions générales et Valider ' de la page d'inscription de Mon Club Facile ",logger, driver);
		verif.CguValid(logger, driver, "En cochant cette case, je reconnais avoir pris connaissance des Conditions Générales d'Utilisation du service « Mon Club Facile » et je les accepte.", "VALIDER");
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("Vérification du footer de la page d'inscription de Mon Club Facile",logger, driver);
		verif.Footer(logger, driver, "Comment ça marche ?", "Assistance", "Tarif", "Sécurité", "Qui sommes nous ?", "Avantages", "Conditions générales d'utilisation", "Mentions légales"); 
		Thread.sleep(2000);
		
	}
	
}
