package fr.maif.monclubfacile.tnr.actions;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;

@SuppressWarnings("unused")
public class ActionTabMenu {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();

	
	
	
	public void ClickTableauDeBo(Logger logger, WebDriver driver) throws IOException, Exception {
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'TABLEAU DE BORD' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[1]/a/span", logger); 
		Thread.sleep(3000);
	} 
	
	
	public void PrenomAdherent(Logger logger, WebDriver driver) throws IOException, Exception {
		 
		log.reportLogTNRInfo("Mon compte MCF - V�rification du pr�nom de l'adh�rent ",logger, driver);
		verif.PrenomAdherent(logger, driver, "ALATA"); 
		Thread.sleep(3000);
		
	} 
	
	public void Adherent(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - V�rification du texte Adh�rent ",logger, driver);
		verif.Adherent(logger, driver, "ADHERENT"); 
		Thread.sleep(3000);
	} 
	
	public void Commandes(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - V�rification du texte ' COMMAND�S ' ",logger, driver);
		verif.Commandes(logger, driver, "COMMAND�S");
		Thread.sleep(3000);
		
	} 
	
	public void Payes(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - V�rification du texte ' PAY�S ' ",logger, driver);
		verif.Payes(logger, driver, "PAY�S"); 
		Thread.sleep(3000);
		
	}
	
	public void Reglement(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - V�rification du texte ' EN ATTENTE DE R�GLEMENT ' ",logger, driver);
		verif.Reglement(logger, driver, "EN ATTENTE DE R�GLEMENT", "VOIR LES COLLECTES"); 
		Thread.sleep(3000);
		
	}
	
	public void PaiementEnLigne(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - V�rification du texte ' PAIEMENT EN LIGNE ' ",logger, driver);
		verif.PaiementLigne(logger, driver, "PAIEMENT EN LIGNE", "EN SAVOIR +"); 
		Thread.sleep(3000);
		
	}
	
	public void DerniersInscrits(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - V�rification du texte ' DERNIERS INSCRITS ' ",logger, driver);
		verif.DerniersInscrits(logger, driver, "DERNIERS INSCRITS"); 
		Thread.sleep(3000);
		
	} 
	
	/*
	public void IdentifConnexion(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - V�rification de l'identifiant de connexion du soc ",logger, driver);
		verif.IdentifConnexion(logger, driver, "IDENTIFIANTS DE CONNEXION", "Email :", "Mot de passe : ");
		Thread.sleep(3000); 
	
	} */
}
