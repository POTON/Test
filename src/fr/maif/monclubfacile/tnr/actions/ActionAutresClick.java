package fr.maif.monclubfacile.tnr.actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
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
import fr.maif.monclubfacile.tnr.actions.ActionAutresClick;
import fr.maif.monclubfacile.tnr.modules.Accueil;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;
import static org.testng.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class ActionAutresClick {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
  	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
public void ClickSurAutres(Logger logger, WebDriver driver) throws IOException, Exception {
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu ' Autres ' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/a/span", logger); 
		Thread.sleep(4000);  
	} 
	
public void ClickTarif(Logger logger, WebDriver driver) throws IOException, Exception {
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu ' Tarif ' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[1]/a", logger); 
		Thread.sleep(4000);  
	} 

public void ContenuTarif(Logger logger, WebDriver driver) throws IOException, Exception {
	 
	log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu du menu 1  ' Tarif ' ",logger, driver);
	//verif.ActionTarifBloc1(logger, driver, "LES SERVICES PROPOSÉS", "GESTION DES ÉVÈNEMENTS", "GESTION DES MEMBRES", "OUTILS DE COMMUNICATION", "PAIEMENT EN LIGNE PAR CB"); 
	verif.ActionTarifBloc1(logger, driver, "LES SERVICES PROPOSÉS");  
	Thread.sleep(5000);
	
	log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu du menu 2' Tarif ' ",logger, driver);
	verif.ActionTarifBloc2(logger, driver, "UNE SOLUTION COMPLÈTE", "POUR GÉRER VOTRE ASSOCIATION", "Sans limite de collecte", "Sans frais d’installation", "Sans abonnement", "Sans engagement", "DES FRAIS APPLIQUÉS UNIQUEMENT", "EN CAS DE PAIEMENT PAR CB");
	Thread.sleep(5000);  
	
} 


public void ClickCommentCaMarche(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu ' Comment ça Marche ? ' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[2]/a", logger); 
	Thread.sleep(5000);  
}


public void ContenuCommentCaMarche(Logger logger, WebDriver driver) throws IOException, Exception { 
	 
	log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu du menu 1  ' Comment ça marche ? ' ",logger, driver); 
	verif.ActionCommeCaMarcheBloc1(logger, driver);  
	Thread.sleep(5000);
	
	log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu du menu 2' Comment ça marche ? ' ",logger, driver);
	verif.ActionCommeCaMarcheBloc2(logger, driver, "LES ÉTAPES CLÉS", "Je paramètre mes collectes pour la rentrée sportive ou tout autre évènement",/* "JE CRÉE",*/ "J'INVITE", "JE COLLECTE", "JE GÈRE", "JE PERÇOIS");
	Thread.sleep(3000);   
	
} 

public void ClickSecurite(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu ' Sécurité ' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[3]/a", logger); 
	Thread.sleep(5000);  
}

public void ContenuSecurite(Logger logger, WebDriver driver) throws IOException, Exception { 
	 
	log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu du menu  ' Sécurité ' ",logger, driver); 
	verif.ActionSecurite(logger, driver, "UNE SOLUTION ENTIÈREMENT SÉCURISÉE", "PROTOCOLE HTTPS", "HÉBERGEMENT DES DONNÉES", "PAIEMENT EN TOUTE CONFIANCE"); 
	Thread.sleep(3000);

} 


public void ClickMentionsLegales(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu ' Mentions légales ' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[4]/a", logger); 
	Thread.sleep(5000);  
}


public void ContenuMentionsLegales(Logger logger, WebDriver driver) throws IOException, Exception { 
	 
	log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu du menu  ' Mentions légales ' ",logger, driver); 
	verif.ActionMentionsLegales(logger, driver, "ÉDITEUR", "Téléphone :", "Mail :", "contact@monclubfacile.fr", "Numéro individuel d’identification à la TVA :", "DIRECTEUR DE LA PUBLICATION ET RESPONSABLE DU SITE", "Directeur de publication : Pascal Demurger, Directeur Général de la MAIF", "Responsable du site : Nicolas Boudinet", "HÉBERGEUR DU SITE", "Le site est hébergé par la société MAIF.", "PROPRIÉTÉ INTELLECTUELLE", "PARTENAIRES", "RESPONSABILITÉS"); 
	Thread.sleep(5000);
 
} 


public void ContenuConditionsGenerales(Logger logger, WebDriver driver) throws IOException, Exception { 
	 
	log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu du menu  ' Conditions générales ' ",logger, driver); 
	verif.ActionConditionsLegales(logger, driver,"1. PRÉAMBULE", "2. OBJET", "3. IDENTIFICATION DES PARTIES ET DES TIERS", "3.1 Maif Horizon", "La Plateforme internet et les Services Mon Club Facile sont exploités par MAIF Horizon.", "3.2 L'utilisateur", "3.3 Les Tiers", "4. ACCEPTATION DES CGU ET DE LEURS MODIFICATIONS", "4.1 Inscription – Création D’un Compte Utilisateur");
	Thread.sleep(3000);
 
} 


public void ClickConditionsGenerales(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu ' Conditions générégales ' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[5]/a", logger); 
	Thread.sleep(5000);  
}

public void ClickMaquettes(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu ' Maquettes ' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[6]/a", logger); 
	Thread.sleep(5000);  
}

public void Fermeture(Logger logger, Logs log, WebDriver driver) throws InterruptedException{
	
	Set<String> windowIds = driver.getWindowHandles();
    Iterator<String> iter = windowIds.iterator();
    String mainWindow = iter.next();
    String childWindow = iter.next();		
    driver.switchTo().window(childWindow);
    System.out.println("le titre de la fenetre enfant est :" +driver.getTitle());
    driver.close();
    Thread.sleep(3000);
    driver.switchTo().window(mainWindow);
    Thread.sleep(5000);
}

public void ClickDocumentation(Logger logger, WebDriver driver) throws IOException, Exception {
	
	log.reportLogTNRInfo("Mon compte MCF - Click sur le menu ' Documentation ' du soc ",logger, driver);
	scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[7]/a", logger); 
	Thread.sleep(5000);   
}


}
