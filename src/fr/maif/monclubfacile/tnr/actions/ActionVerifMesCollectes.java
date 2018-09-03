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
public class ActionVerifMesCollectes {
	
	private WebDriver driver;
	private Logs log = new Logs();
	Logger logger = Logger.getLogger("Test du Projet NomduProjet - TNR");
	ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRENCH);
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private ActionCollect actCol = new ActionCollect(); 
	
	
	public void ContenuMesCollectes(WebDriver driver, Logger logger) throws Exception {
		actCol.ClickMesCol(logger, driver); 
		actCol.ContenuMesCollectes(logger, driver); 
		 
	} 
	
	public void ContenuPubliees(WebDriver driver, Logger logger) throws Exception {
		actCol.ClickPubli(logger, driver); 
		actCol.ContenuPub(logger, driver); 
	} 
	
	public void ContenuBrou(WebDriver driver, Logger logger) throws Exception {
		actCol.ClickBrouil(logger, driver);  
		 
	}
	
	public void ContenuTermi(WebDriver driver, Logger logger) throws Exception {
		actCol.ClickTerm(logger, driver); 
		 
	} 
	
	public void ContenuCorbei(WebDriver driver, Logger logger) throws Exception {
		actCol.ClickCor(logger, driver);
		 
	}
	 
	 
}
