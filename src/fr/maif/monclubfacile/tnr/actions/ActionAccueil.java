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
		
		log.reportLogTNRInfo("V�rification du ' Header ' de Mon Club Facile ",logger, driver);
		verif.HeaderMcf(logger, driver,"Maquettes", "Documentation", "COMMENT �A MARCHE ?", "TARIF", "INSCRIPTION", "CONNEXION");
		Thread.sleep(3000);
		
	} 

	public void Menus(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("V�rification du ' V�rification du menu 1 : Simplifiez ... sportif ' de Mon Club Facile ",logger, driver);
		//verif.Menu1(logger, driver, "MON CLUB FACILE",*/ /*"SIMPLIFIEZ LA GESTION ADMINISTRATIVE \n DE VOTRE CLUB SPORTIF", */"INSCRIPTION");
		verif.Menu1(logger, driver, "INSCRIPTION");
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("V�rification du ' V�rification du menu 2 : 'G�rez ... en ligne' ; ' Proposez ... esp�ces ' ; ' Facilitez ... communaut� ' de Mon Club Facile ",logger, driver);
		verif.Menu2(logger, driver); 
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("V�rification du ' V�rification du menu 3 : Un outil simple ... s�curis� ' de Mon Club Facile ",logger, driver);
		verif.Menu3(logger, driver, "MON CLUB FACILE :", "UN OUTIL SIMPLE, �VOLUTIF ET S�CURIS�", "VOIR LA VID�O", " LES AVANTAGES");
		Thread.sleep(3000);
		
		log.reportLogTNRInfo("V�rification du ' V�rification du menu 4 : La Maif et le sport ",logger, driver);
		verif.Menu4(logger, driver, "LA MAIF ET LE SPORT", "La MAIF, premier assureur des associations, est depuis longtemps investie dans le domaine sportif. Le sport , g�n�rateur de confiance, v�hicule des valeurs proches de celles li�es � l��ducation. Notre priorit� : �tre � l��coute des acteurs du monde sportif pour fournir des solutions adapt�es aux besoins.", "NOTRE VOLONT�", "Vous faire gagner du temps sur les t�ches administratives et quotidiennes de votre club", "VOTRE B�N�FICE", "Consacrer plus de temps � vos adh�rents et favoriser le d�veloppement de votre structure");
		Thread.sleep(3000); 
		
		log.reportLogTNRInfo("V�rification du ' V�rification du menu 5 :  membres 1 ",logger, driver);
		verif.Menu5_Suite(logger, driver, "DAVID, 49 ANS", "PR�SIDENT LES 12-14 NIORT", "1"); 
		Thread.sleep(2000); 
		
		log.reportLogTNRInfo("V�rification du ' V�rification du menu 5 :  membres 2 ",logger, driver);
		verif.Menu5(logger, driver, "NATHALIE, 36 ANS", "TR�SORI�RE LES BASKETS EN FOLIE", "� La relance automatique permet de r�cup�rer facilement les certificats m�dicaux. �", "2");
		Thread.sleep(2000); 
		
		log.reportLogTNRInfo("V�rification du ' V�rification du menu 5 :  membres 1 ",logger, driver);
		verif.Menu5(logger, driver, "FEDY, 30 ANS", "ADH�RENT ASSOCIATION OCR 86", "� S�inscrire en ligne c�est pratique, plus besoin de se d�placer. �", "3");
		Thread.sleep(2000); 
		
	}

	public void Footer(Logger logger, WebDriver driver) throws IOException, Exception { 
		log.reportLogTNRInfo("V�rification du ' V�rification du Footer' de Mon Club Facile ",logger, driver);
		verif.Footer(logger, driver, "Comment �a marche ?", "Assistance", "Tarif", "S�curit�", "Qui sommes nous ?", "Avantages", "Conditions g�n�rales d'utilisation", "Mentions l�gales"); 
		Thread.sleep(2000); 
		
	}

}
