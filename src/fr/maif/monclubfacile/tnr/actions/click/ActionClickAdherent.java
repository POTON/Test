package fr.maif.monclubfacile.tnr.actions.click;

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
public class ActionClickAdherent { 
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	public void ActionClickTabl(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'Tableau De Bord' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[1]/a/span", logger); 
		Thread.sleep(4000);
	} 
	
	public void ActionClickMesCollectes(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'Mes collectes' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[2]/a/span", logger); 
		Thread.sleep(3000);
	}
	
	
	public void MenuAdherenOuMenuCommandesOuMenuPayes(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur adhérent ",logger, driver);
		verif.ActionClickAdhe(logger, driver);
		verif.ActionClick(logger, driver, "Rechercher un adhérent :", "IBRAHIM", "ROMARIC", "12/12/1958", "COURS DE JAVA", "5.00 €", "EN ATTENTE", "CHÈQUE"); 
		Thread.sleep(5000);
	} 
	
	
	public void ActionClickAdhe(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur adhérent ",logger, driver);
		verif.ActionClickAdhe(logger, driver);
		verif.ActionClick(logger, driver, "Rechercher un adhérent :", "IBRAHIM", "ROMARIC", "12/12/1958", "COURS DE JAVA", "5.00 €", "EN ATTENTE", "CHÈQUE"); 
		Thread.sleep(5000);
	} 
	
	public void ActionClickCommandes(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur Commandés ",logger, driver);
		verif.ActionClickComma(logger, driver); 
		Thread.sleep(3000);
		verif.ActionClick(logger, driver, "Rechercher un adhérent :", "IBRAHIM", "ROMARIC", "12/12/1958", "COURS DE JAVA", "5.00 €", "EN ATTENTE", "CHÈQUE"); 
		Thread.sleep(5000);
	} 
	  
	
	public void ActionClickPayes(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur Payés ",logger, driver);
		verif.ActionClickPay(logger, driver);
		Thread.sleep(3000);
		verif.ActionClick(logger, driver, "Rechercher un adhérent :", "IBRAHIM", "ROMARIC", "12/12/1958", "COURS DE JAVA", "5.00 €", "EN ATTENTE", "CHÈQUE"); 
		Thread.sleep(3000);
	} 
	
	public void ActionClickCollectes(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur Voir les collectes ",logger, driver);
		verif.ActionClickReglmtVoirCollectes(logger, driver); 
		Thread.sleep(3000);
	}  
	 
	
	public void ActionClickEnSavoirPlus(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Click sur Paiement en ligne ",logger, driver);
		verif.ActionClickPaiementLignEnSavoirPlus(logger, driver); 
		Thread.sleep(3000);
	} 
	
	
	public void IdentifConnexion(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Vérification de l'identifiant de connexion du soc ",logger, driver);
		verif.IdentifConnexion(logger, driver, "IDENTIFIANTS DE CONNEXION", "Email :", "Mot de passe : ");
		Thread.sleep(3000); 
	
	} 
}
