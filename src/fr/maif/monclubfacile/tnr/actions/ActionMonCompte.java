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
public class ActionMonCompte {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();

	
	
	
public void ClickMenuDepli(Logger logger, WebDriver driver) throws IOException, Exception {
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu dépliant le 'Profil et la déconnexion' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='top-right-menu']/ul/li/a/span[2]", logger); 
		Thread.sleep(2000);
		
		log.reportLogTNRInfo("Mon compte MCF - Click sur le menu 'Profil du club ' du soc ",logger, driver);
		scriptTech.clickByXpath(driver, "//*[@id='top-right-menu']/ul/li/ul/li[1]/a", logger); 	
		Thread.sleep(2000);
	} 
	
	
	public void PrenomNom(Logger logger, WebDriver driver) throws IOException, Exception {
		 
		log.reportLogTNRInfo("Mon compte MCF - Vérification du prénom du soc ",logger, driver);
		verif.PrenomNom(logger, driver, "alata"/*, "Activité(s) :*/); 
		Thread.sleep(3000);
		
	} 
	
	public void Profil(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Vérification du profil du soc ",logger, driver);
		verif.Profil(logger, driver, "PROFIL"); 
		Thread.sleep(3000);
	} 
	
	public void Contact(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Vérification du contact du soc ",logger, driver);
		verif.Contact(logger, driver, "CONTACT",/* "Adresse : ",*/ "Code Postal / Ville :", /*"Adresse e-mail : ", */"Téléphone :"); 
		Thread.sleep(3000);
		
	} 

	public void IdentifConnexion(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Vérification de l'identifiant de connexion du soc ",logger, driver);
		verif.IdentifConnexion(logger, driver, "IDENTIFIANTS DE CONNEXION", "Email :", "Mot de passe : ");
		Thread.sleep(3000); 
	
	} 
}
