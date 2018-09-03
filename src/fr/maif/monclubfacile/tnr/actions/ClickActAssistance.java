package fr.maif.monclubfacile.tnr.actions;

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
public class ClickActAssistance {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	
	private ActionAssistance actCol = new ActionAssistance();
	private ActionContenuFormulaire actContFormulaire = new ActionContenuFormulaire();
	
	
	public void ContenuFormuDeContact(WebDriver driver, Logger logger) throws Exception {
		//verif.ContenuAssFormu(logger, driver, "Nom de l'association *", "Nom", "Prénom", "Email *", "Téléphone", "Quel est le motif de votre demande ? *", "Message *", "ENVOYER VOTRE DEMANDE");
		verif.ContenuAssFormu(logger, driver, "Nom de l'association *", "Nom", "Prénom", "Email *", "Téléphone", "Quel est le motif de votre demande ? *", "Message *", "ENVOYER VOTRE DEMANDE", "VOTRE DEMANDE A BIEN ÉTÉ TRANSMISE AU SERVICE CLIENT MON CLUB FACILE, ELLE SERA TRAITÉE DANS UN DÉLAI DE 48H OUVRÉES."); 
	} 
	 
	
}
