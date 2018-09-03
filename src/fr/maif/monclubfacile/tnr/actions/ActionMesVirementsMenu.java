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
public class ActionMesVirementsMenu {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();

	
	
	
	public void ClickMesVirements(Logger logger, WebDriver driver) throws IOException, Exception {
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'Mes  virements' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[4]/a/span", logger); 
		Thread.sleep(3000);
	} 
	
	
	
	public void EnAttente(Logger logger, WebDriver driver) throws IOException, Exception {
		 
		log.reportLogTNRInfo("Mon compte MCF - Vérification du contenu du bloc ' EN ATTENTE DE VIREMENT ' ",logger, driver);
		verif.EnAttenteDeVi(logger, driver, "EN ATTENTE DE VIREMENT", "0,00 €", "0,00 €", "Paiements par CB", "-0,00 €", "Frais E-Cotiz"); 
		Thread.sleep(3000);
		
	} 
	
	public void ProchainVir(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF -Vérification du contenu du bloc ' PROCHAIN VIREMENT ' ",logger, driver);
		verif.ProchViremt(logger, driver, "PROCHAIN VIREMENT", "0,00 €"); 
		Thread.sleep(3000);
	} 
	
	public void ClickHistoDesVirements(Logger logger, WebDriver driver) throws IOException, Exception {
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'Historique des  virements' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[1]/a", logger);  
		Thread.sleep(3000);
	} 
	
	public void HistoVir(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Vérification du texte ' Historique des virements ' ",logger, driver);
		verif.HistoVirmt(logger, driver, "HISTORIQUE DES VIREMENTS", "DATE", "LIBELLÉ", "NOM DE LA COLLECTE", "MONTANT"); 
		Thread.sleep(3000);
		
	} 
	
	public void FreqVirement(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Vérification du texte ' Fréquence de virements ' ",logger, driver);
		verif.FrequenceVirt(logger, driver, "FRÉQUENCE DES VIREMENTS", "1754", "ALATA", "MENSUELLE");   
		Thread.sleep(3000);
		
	}
	
	
	/*
	public void IdentifConnexion(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Vérification de l'identifiant de connexion du soc ",logger, driver);
		verif.IdentifConnexion(logger, driver, "IDENTIFIANTS DE CONNEXION", "Email :", "Mot de passe : ");
		Thread.sleep(3000); 
	
	} */
}
