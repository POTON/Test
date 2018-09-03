package fr.maif.monclubfacile.tnr.modules;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.OpenWebSite;
import fr.maif.library.ScriptsTechniquesStandard;
import fr.maif.monclubfacile.tnr.actions.ActionDeconnexion;
import fr.maif.monclubfacile.tnr.actions.ActionVerifMesAssistance;
import fr.maif.monclubfacile.tnr.actions.ClickActAssistance;
import fr.maif.monclubfacile.tnr.actions.ClickAutresContenu;

@SuppressWarnings("unused")
public class ContenuAutres {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private Verif verif = new Verif();
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	 
	private ActionDeconnexion actDeconnex = new ActionDeconnexion(); 
	private ClickAutresContenu clickAutres = new ClickAutresContenu(); 
	
	
	/*public void ClickAutres(WebDriver driver, Logger logger) throws Exception {
		clickAutres.ContenuAutres(driver, logger); 
		clickAutres.ContenuAutres1(driver, logger); 
		clickAutres.ContenuAutres2(driver, logger);
		clickAutres.ContenuAutres3(driver, logger);
		clickAutres.ContenuAutres4(driver, logger);
		clickAutres.ContenuAutres5(driver, logger);
		clickAutres.ContenuAutres6(driver, logger);
	} */
	
	public void ClickAutres(WebDriver driver, Logger logger) throws Exception {
		clickAutres.ContenuAutres(driver, logger); 
	
	} 
	
	public void ClickTarif(WebDriver driver, Logger logger) throws Exception {
		clickAutres.ContenuAutres0(driver, logger); 
	} 
	
	public void ClickComment(WebDriver driver, Logger logger) throws Exception {
		clickAutres.ContenuAutres1(driver, logger); 
	} 
	
	public void ClickSecu(WebDriver driver, Logger logger) throws Exception { 
		clickAutres.ContenuAutres2(driver, logger);
	} 
	
	public void ClickMentionsLega(WebDriver driver, Logger logger) throws Exception { 
		clickAutres.ContenuAutres3(driver, logger);
	} 

	public void ClickConditGen(WebDriver driver, Logger logger) throws Exception { 
		clickAutres.ContenuAutres4(driver, logger);
	} 
	
	public void ClickMaquet(WebDriver driver, Logger logger) throws Exception { 
		clickAutres.ContenuAutres5(driver, logger);
	} 
	
	public void ClickDocum(WebDriver driver, Logger logger) throws Exception { 
		clickAutres.ContenuAutres6(driver, logger);  
	} 
	
	 
	public void Deconnexion(WebDriver driver, Logger logger) throws Exception { 
		actDeconnex.ClickDeconnexion(driver, logger); 
		
	} 
	
}
