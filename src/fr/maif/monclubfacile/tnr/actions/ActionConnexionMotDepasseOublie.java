package fr.maif.monclubfacile.tnr.actions;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
//import fr.maif.nomduprojet.tnr.modules.Inscription;
import fr.maif.monclubfacile.tnr.modules.Login;
import fr.maif.monclubfacile.tnr.modules.Verif;

@SuppressWarnings("unused")
public class ActionConnexionMotDepasseOublie {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private Login connectEpMcf = new Login();
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	
	public void OuvPageConnex(Logger logger, WebDriver driver) throws IOException, Exception { 
		
		log.reportLogTNRInfo("CONNEXION - MON CLUB FACILE - ",logger, driver);
		verif.OuvrirPageConnexion(logger, driver, "CONNEXION");  
		Thread.sleep(3000);
	
	} 
	
	
	public void OublieMotDePasse(Logger logger, WebDriver driver) throws IOException, Exception { 
		
		log.reportLogTNRInfo(" Oublie de mot de passe sur la page d'authentification de Mon Club Facile ",logger, driver);
		connectEpMcf.OublieMotDePasse(logger, driver, "ACCÉDER À MON COMPTE", "Adresse e-mail", "ibrahima.alata@gmail.com", "Mot de passe", "Kolima", "SE CONNECTER", "> Mot de passe oublié?", "MOT DE PASSE OUBLIÉ", "Si vous avez oublié votre mot de passe, veuillez renseigner votre adresse e-mail afin de choisir un nouveau mot de passe.", "Adresse Email", "ibra@gmail.com", "VALIDER");
		Thread.sleep(5000);	
	}

}
