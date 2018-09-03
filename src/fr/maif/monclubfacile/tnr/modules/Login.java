package fr.maif.monclubfacile.tnr.modules;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.ScriptsTechniquesStandard;



public class Login {

	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
	private Logs log = new Logs();

	/**
	 * Fonction permettant de se connecter à l'espace personnel de Mon Club Facile
	 * (Mire de l'EP de Mon Club Facile / Page de connexion - mcf)
	 * @param logger
	 * @param driver
	 * @param texteAdresseMail
	 * @param texteMotDePasse
	 * @param numeroSoc
	 * @param password
	 * @param texteOubliIdentif
	 * @param texteSeConnecter
	 * @return
	 * @throws IOException 
	 */

	public boolean loginEpMCF(Logger logger, WebDriver driver, String texteAdresseMail, String numeroSoc, String texteMotDePasse,  String password, String texteOubliIdentif, String texteSeConnecter) throws IOException {
		try {
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification de l'icône MCF", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='content']/div/div/div/div[1]/img", logger);
			Thread.sleep(1000);
				
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du filaire sociétaire", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='j_spring_security_check']/div/div/div[1]/div", logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' Adresse e-mail ou identifiant *' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='j_spring_security_check']/div/div/div[2]/label", texteAdresseMail, logger); 
			
			log.reportLogTNRInfo("Entrez du numero de societaire", logger, driver);
			scriptTech.clickById(driver, "j_username", logger);
			scriptTech.sendTextById(driver, "j_username", numeroSoc, logger);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' Mot de passe *' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='j_spring_security_check']/div/div/div[3]/label", texteMotDePasse, logger); 
			
			log.reportLogTNRInfo("Entrez du mot de passe societaire", logger, driver);
			scriptTech.clickById(driver, "j_password", logger);
			scriptTech.sendTextById(driver, "j_password", password, logger);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' IDENTIFIANT OU MOT DE PASSE OUBLIÉ ?' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='j_spring_security_check']/div/div/a", texteOubliIdentif, logger);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' SE CONNECTER' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='j_spring_security_check']/div/div/button", texteSeConnecter, logger);
			
			log.reportLogTNRInfo("Click sur se connecter", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='j_spring_security_check']/div/div/button", logger);
			Thread.sleep(3000);
			
			return true;
		} catch (Exception e) {
			log.reportLogTNRFatal(e.getMessage(), logger, driver);
			return false;
		}
	}
	
	
	/**
	 * Fonction permettant de se connecter à l'espace personnel de Mon Club Facile
	 * (Mire de l'EP de Mon Club Facile / Page de connexion - mcf)
	 * @param logger
	 * @param driver
	 * @param texteAcceder
	 * @param texteAdresseMail
	 * @param texteMotDePasse
	 * @param numeroSoc
	 * @param password
	 * @param texteOubliMotDePasse
	 * @param texteSeConnecter
	 * @return
	 * @throws IOException 
	 */

	public boolean loginConEpSocMCF(Logger logger, WebDriver driver, String texteAcceder, String texteAdresseMail, String numeroSoc, String texteMotDePasse,  String password, String texteSeConnecter, String texteOubliMotDePasse) throws IOException {
		try {
			log.reportLogTNRInfo("Page d'authentification Sociétaire - Mon club facile - Vérification du du texte ' Adresse e-mail ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[1]/label", texteAdresseMail, logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Entrez du numero de societaire", logger, driver);
			scriptTech.clickById(driver, "login-username", logger);
			scriptTech.sendTextById(driver, "login-username", numeroSoc, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'authentification Sociétaire - Mon club facile - Vérification du du texte ' Mot de passe ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[2]/label", texteMotDePasse, logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Entrez du mot de passe societaire", logger, driver);
			scriptTech.clickById(driver, "login-password", logger);
			scriptTech.sendTextById(driver, "login-password", password, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' SE CONNECTER' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[3]/button", texteSeConnecter, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' Mot de passe oublié? ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[3]/div/a", texteOubliMotDePasse, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' SE CONNECTER' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[3]/button", texteSeConnecter, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Click sur SE CONNECTER ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='login_form']/div[3]/button", logger);
			Thread.sleep(1000);
			
			return true;
		} catch (Exception e) {
			log.reportLogTNRFatal(e.getMessage(), logger, driver);
			return false;
		}
	}
	
	
	
	/**
	 * Fonction permettant de récuperer le mot de passe de son compte Mon Club Facile
	 * (Mire de l'EP de Mon Club Facile / Page d'oublie de mot de passe -  mcf)
	 * @param logger
	 * @param driver
	 * @param texteAcceder
	 * @param texteAdresseMail
	 * @param texteMotDePasse
	 * @param numeroSoc
	 * @param password
	 * @param texteOubliMotDePasse
	 * @param texteSeConnecter
	 * @param texteMailOuMotDePasseInvalide : exemple : Email ou mot de passe invalide 
	 * @param texteMdpOubli :  exemple : MOT DE PASSE OUBLIÉ
	 * @param texteSiVousAvezOublie :  exemple : Si vous avez oublié votre mot de passe, veuillez renseigner votre adresse e-mail afin de choisir un nouveau mot de passe.
	 * @parama texteEmail : exemple : Adresse Email
	 * @param texteValider :  exemple : VALIDER
	 * @param texteMerci :  exemple : Merci, si votre e-mail est valide vous allez recevoir un nouveau mot de passe.
	 * @param texteFermer : exemple : FERMER
	 * @return
	 * @throws IOException 
	 */

	public boolean OublieMotDePasse(Logger logger, WebDriver driver, String texteAcceder, String texteAdresseMail, String numeroSoc, String texteMotDePasse,  String password, 
			String texteSeConnecter, String texteOubliMotDePasse, String texteMdpOubli, String texteSiVousAvezOublie, String texteEmail, String mailSoc, String texteValider) throws IOException {
		try {
			log.reportLogTNRInfo("Page d'authentification Sociétaire - Mon club facile - Vérification du du texte ' Adresse e-mail ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[1]/label", texteAdresseMail, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Entrez du numero de societaire", logger, driver);
			scriptTech.clickById(driver, "login-username", logger);
			scriptTech.sendTextById(driver, "login-username", numeroSoc, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'authentification Sociétaire - Mon club facile - Vérification du du texte ' Mot de passe ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[2]/label", texteMotDePasse, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Entrez du mot de passe societaire", logger, driver);
			scriptTech.clickById(driver, "login-password", logger);
			scriptTech.sendTextById(driver, "login-password", password, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' SE CONNECTER' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[3]/button", texteSeConnecter, logger);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' Mot de passe oublié? ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[3]/div/a", texteOubliMotDePasse, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' SE CONNECTER' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='login_form']/div[3]/button", texteSeConnecter, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Click sur le lien ' Mot de passe oublié? '  ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='login_form']/div[3]/div/a", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'authentification Sociétaire - Mon club facile - Vérification du du texte ' MOT DE PASSE OUBLIÉ ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='mdp-oublier']/div/div/div/div/div/div[1]", texteMdpOubli, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'authentification Sociétaire - Mon club facile - Vérification du du texte ' Si vous avez oublié votre mot de passe, veuillez renseigner votre adresse e-mail afin de choisir un nouveau mot de passe. ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='mdp-oublier']/div/div/div/div/div/div[2]", texteSiVousAvezOublie, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'authentification Sociétaire - Mon club facile - Vérification du du texte ' Adresse Email ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='mdp-oublier']/div/div/div/div/div/form/div[1]/label", texteEmail, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Entrez Adresse Email de societaire", logger, driver);
			scriptTech.clickById(driver, "login-username", logger);
			scriptTech.sendTextById(driver, "login-username", mailSoc, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte ' VALIDER' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='mdp-oublier']/div/div/div/div/div/form/div[2]/button", texteValider, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Click sur VALIDER ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='mdp-oublier']/div/div/div/div/div/form/div[2]/button", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'authentification de mon club facile - Vérification du du texte 'Merci, si votre e-mail est valide vous allez recevoir un nouveau mot de passe.' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='mdp-oublier']/div/div/div/div/div/div[2]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Click sur FERMER ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='mdp-oublier']/div/div/div/div/div/form/div/button", logger);
			Thread.sleep(2000);

			return true;
		} catch (Exception e) {
			log.reportLogTNRFatal(e.getMessage(), logger, driver);
			return false;
		}
	}
	
	
	
	
	
}

	
