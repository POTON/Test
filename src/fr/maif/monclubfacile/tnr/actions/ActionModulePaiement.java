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
public class ActionModulePaiement {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();

	
	
	public void PaiementEnLigne(Logger logger, WebDriver driver) throws IOException, Exception {
		log.reportLogTNRInfo("Mon compte MCF - Paiement en ligne - soc MCF ",logger, driver);
		verif.PaiementEnLigne(logger, driver, "MODULE DE PAIEMENT EN LIGNE", "EN SAVOIR PLUS"); 
		Thread.sleep(3000);
		
	} 
	
}
