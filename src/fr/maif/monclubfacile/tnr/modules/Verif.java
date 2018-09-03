package fr.maif.monclubfacile.tnr.modules;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import fr.maif.library.Logs;
import fr.maif.library.ScriptsTechniquesStandard;


public class Verif {
	
	private ScriptsTechniquesStandard scriptTech = new ScriptsTechniquesStandard();
	private Logs log = new Logs();

	public void Header(Logger logger, WebDriver driver, String texte) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage Prenom", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='maif-esperso-header']/div/div[2]/div/div/div[2]/div[2]/div[2]/a", texte, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Icône MAIF", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='maif-esperso-header']/div/div[2]/div/div/div[1]/a/div", logger);  

			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Lien Mon Avis d'echeance", logger, driver);
			scriptTech.verifTexteById(driver, "liens-utiles-avis-echeance", "AVIS D'ÉCHÉANCES", logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Lien Attestations", logger, driver);
			scriptTech.verifTexteById(driver, "liens-utiles-mes-attestations", "ATTESTATIONS", logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Présence Filaire Sociétaire", logger, driver);
			scriptTech.isElementExisteById(driver, "maif-esperso-header", logger);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant Home authentification de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteMaqDoc : exemple : MAQUETTES/DOC
	 * @param texteMaq : exemple : Maquettes
	 * @param texteDoc : exemple : Documentation
	 * @param texteComçaMarche : exemple : Comment ça marche ?
	 * @param texteTarif : exemple : Tarif
	 * @param texteInscription : exemple : Inscription
	 * @param texteConnexion : exemple : Connexion
	 * @throws IOException
	 */
	
	public void HeaderMcf(Logger logger, WebDriver driver, /*String texteMaqDoc,*/ String texteMaq, String texteDoc, String texteComçaMarche, 
			String texteTarif, String texteInscription, String texteConnexion) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage de l'icône Maif", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "/html/body/header/nav/div[1]/div/div[2]/a/img", logger);
			
			//log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Maquettes/Doc'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteMaqDoc, logger);
			//scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[1]/a", texteMaqDoc, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Click sur le texte Maquettes/Doc", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='navigation']/ul/li[1]/a", logger); 
			//*[@id="navigation"]/ul/li[1]/a
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte ' Maquettes' au Click sur le texte Maquettes/Doc", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteMaqDoc, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[1]/ul/li[1]/a", texteMaq, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte ' Documentations' au Click sur le texte Maquettes/Doc", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteDoc, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[1]/ul/li[2]/a", texteDoc, logger); 
			 
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Comment ça Marche'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteComçaMarche, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[2]/button", texteComçaMarche, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Tarif'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteTarif, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[3]/button", texteTarif, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Inscription'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteInscription, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[4]/button", texteInscription, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Connexion'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteConnexion, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[5]/button", texteConnexion, logger);	 
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant du Menu 1 : SIMPLIFIEZ LA GESTION ADMINISTRATIVE DE VOTRE CLUB SPORTIF .....
	 * 
	 * @param logger
	 * @param driver
	 * @param texteMonClubFacile : exemple : Mon Club Facule
	 * @param texteSimplifiez : exemple : SIMPLIFIEZ LA GESTION ADMINISTRATIVE DE VOTRE CLUB SPORTIF
	 * @param texteInscription : exemple : Inscription
	 * @throws IOException
	 */
	
	public void Menu1(Logger logger, WebDriver driver,/* String texteMonClubFacile, String texteSimplifiez, */String texteInscription) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage de l'icône et du texte 'MON CLUB FACILE'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[1]/div/div/div/div[1]/img", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'SIMPLIFIEZ LA GESTION ADMINISTRATIVE DE VOTRE CLUB SPORTIF' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[1]/div/div/div/div[1]/h1[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Inscription' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[1]/div/div/div/div[2]/button", texteInscription, logger);
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant du Menu 2 : Gérez facilement ... en ligne ; proposez ... espèces ;  et Facilitez ....communauté. 
	 * 
	 * @param logger
	 * @param driver
	 * @param texteGerer : exemple : Gérez facilement vos inscriptions en ligne
	 * @param texteProposez : exemple :Proposez le paiement par CB à vos membres, mais aussi chèque ou espèces. 
	 * @param texteFacilitez : exemple : Facilitez la communication avec votre ca=ommunauté.
	 * @throws IOException
	 */
	
	public void Menu2 (Logger logger, WebDriver driver/*,String texteGerer, String texteProposez, String texteFacilitez*/) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du picto 'Gérez facilement ... en lignes'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[1]/div/span/div[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Gérez facilement vos inscriptions en lignes'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[1]/div/span/h2", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification de l'Affichage du picto 'Proposez le paiement ... ou espèces'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[2]/div/span/div[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Proposez le paiement par CB à vos membres, mais aussi chèque ou espèces'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[2]/div/span/h2", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du picto 'Facilitez ... votre communauté'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[3]/div/span/div[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification Affichage du texte 'Facilitez la communication avec votre communauté'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[3]/div/span/h2", logger);
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant du Menu 3 : Un outil simple, évolutif et sécurisé.  
	 * 
	 * @param logger
	 * @param driver
	 * @param texteMonClubFacile : exemple : MON CLUB FACILE
	 * @param texteOutilSimple :  exemple : UN OUTIL SIMPLE, ÉVOLUTIF ET SÉCURISÉ
	 * @param texteBase : exemple : Une base adhérents fiable et constitué automatiquement.
	 * @param texteFormulaire : exemple : Un formulaire d’inscription personnalisable.
	 * @param texteCommunication : exemple : Une communication fluidifiée : mailing groupé, relance...
	 * @param texteUneTresorerie : exemple : Une trésorerie immédiate grâce au paiement en ligne.
	 * @param texteUnTableau : exemple : Un tableau de bord personnalisable pour un pilotage opimisé.
	 * @param texteVoirVideo : exemple : VOIR LA VIDÉO
	 * @param texteLesAvantages : exemple : + LES AVANTAGES
	 * @throws IOException
	 */ 
	
	public void Menu3 (Logger logger, WebDriver driver,String texteMonClubFacile, String texteOutilSimple,/* String texteBase, String texteFormulaire, String texteCommunication, String texteUneTresorerie, 
			String texteUnTableau,*/ String texteVoirVideo, String texteLesAvantages ) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' MON CLUB FACILE'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[3]/div/h3", texteMonClubFacile, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' UN OUTIL SIMPLE, ÉVOLUTIF ET SÉCURISÉ'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[3]/div/h4", texteOutilSimple, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' Une base adhérents fiable et constitué automatiquement.'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[1]/div[2]/div[2]/p", logger);
			Thread.sleep(2000);
			 
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' Un formulaire d’inscription personnalisable.'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[2]/div[1]/div[2]/p", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' Une communication fluidifiée : mailing groupé, relance...'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[1]/div[3]/div[2]/p", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' Une trésorerie immédiate grâce au paiement en ligne.'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[2]/div[2]/div[2]/p", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' Un tableau de bord personnalisable pour un pilotage opimisé.'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[2]/div[3]/div[2]/p", logger);
			Thread.sleep(3000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' VOIR LA VIDÉO'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='advantages-video']/div/section/div/button[1]", texteVoirVideo , logger);
			Thread.sleep(3000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Click sur le texte ' VOIR LA VIDÉO'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='advantages-video']/div/section/div/button[1]", logger); 
			Thread.sleep(5000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Fermeture de la présentation de vidéo '", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='VideoModal']/div/div/div[1]/div/i", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du texte ' LES AVANTAGES '", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='advantages-video']/div/section/div/button[2]", texteLesAvantages , logger);
			scriptTech.isElementExisteById(driver, "advantages-video", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Click sur le texte '  LES AVANTAGES '", logger, driver);
			scriptTech.clickById(driver, "advantages-video", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Fermeture de la page Avanatges après le Click sur le texte '  LES AVANTAGES '", logger, driver);
			scriptTech.clickByXpath(driver, "/html/body/header/nav/div[1]/div/div[2]/a/img", logger); 
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	
	
	/**
	 * FOnction Vérifiant du Menu 4 : LA MAIF ET LE SPORT  
	 * 
	 * @param logger
	 * @param driver
	 * @param texteMaifSport : exemple : LA MAIF ET LE SPORT
	 * @param texteMaifPremierAssureur :  exemple : La MAIF, premier assureur des associations, est depuis longtemps investie dans le domaine sportif. Le sport , générateur de confiance, véhicule des valeurs proches de celles liées à l’éducation. Notre priorité : être à l’écoute des acteurs du monde sportif pour fournir des solutions adaptées aux besoins.
	 * @param texteNotreVolonte : exemple : NOTRE VOLONTÉ
	 * @param texteVousFaire : exemple : Vous faire gagner du temps sur les tâches administratives et quotidiennes de votre club
	 * @param texteVotreBebefice : exemple : VOTRE BÉNÉFICE
	 * @param texteConsacrer : exemple : Consacrer plus de temps à vos adhérents et favoriser le développement de votre structure
	 * @throws IOException
	 */ 
	
	public void Menu4 (Logger logger, WebDriver driver,String texteMaifSport, String texteMaifPremierAssureur, String texteNotreVolonte, String texteVousFaire, String texteVotreBebefice, String texteConsacrer) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte ' LA MAIF ET LE SPORT'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/h3", texteMaifSport, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte ' La MAIF, premier assureur des associations ... adaptées aux besoins. '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/p", texteMaifPremierAssureur, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage de l'icône ' notre volonté'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[1]/div/div", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte ' NOTRE VOLONTÉ '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[1]/div/h4", texteNotreVolonte, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte ' Vous faire gagner du temps sur les tâches administratives et quotidiennes de votre club '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[1]/div/p", texteVousFaire, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage de l'icône ' votre bénéfice'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[2]/div/div", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte ' VOTRE BÉNÉFICE '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[2]/div/h4", texteVotreBebefice, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Consacrer plus de temps à vos adhérents et favoriser le développement de votre structure '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[2]/div/p", texteConsacrer, logger);
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant du Menu 5 : Les membres 
	 * 
	 * @param logger
	 * @param driver
	 * @param texteNomAges : exemple : DAVID, 49 ANS
	 * @param textePoste :  exemple : PRÉSIDENT LES 12-14 NIORT
	 * @param texteslogan : exemple : « La gestion du club devient un jeu d’enfant. »
	 * @throws IOException
	 */ 
	
	public void Menu5 (Logger logger, WebDriver driver,String texteNomAges, String textePoste, String texteslogan, String numdiv) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage de l'image Membre ", logger, driver);  
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/div/img", logger);
			Thread.sleep(2000);
			//*[@id="home"]/section[5]/div/div/div[1]/div/img
			//*[@id="home"]/section[5]/div/div/div[2]/div/img
			//*[@id="home"]/section[5]/div/div/div[3]/div/img
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte 'Nom et âges du membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[1]", texteNomAges, logger); 
			Thread.sleep(2000);
			//*[@id="home"]/section[5]/div/div/div[1]/span[1]
			//*[@id="home"]/section[5]/div/div/div[2]/span[1]
			//*[@id="home"]/section[5]/div/div/div[3]/span[1] 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte ' Poste/Fonction du membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[2]", textePoste, logger);
			Thread.sleep(2000);
			//*[@id="home"]/section[5]/div/div/div[1]/span[2]
			//*[@id="home"]/section[5]/div/div/div[2]/span[2]
			//*[@id="home"]/section[5]/div/div/div[3]/span[2]
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du 'texte membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[3]", texteslogan, logger); 
			Thread.sleep(2000);
			//*[@id="home"]/section[5]/div/div/div[1]/span[3]
			//*[@id="home"]/section[5]/div/div/div[2]/span[3]
			//*[@id="home"]/section[5]/div/div/div[3]/span[3]
				
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant du Menu 5 : Les membres 
	 * 
	 * @param logger
	 * @param driver
	 * @param texteNomAges : exemple : DAVID, 49 ANS
	 * @param textePoste :  exemple : PRÉSIDENT LES 12-14 NIORT
	 * @param texteslogan : exemple : « La gestion du club devient un jeu d’enfant. »
	 * @throws IOException
	 */  
	
	public void Menu5_Suite(Logger logger, WebDriver driver,String texteNomAges, String textePoste, String numdiv) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage de l'image Membre ", logger, driver);  
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/div/img", logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte 'Nom et âges du membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[1]", texteNomAges, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du texte ' Poste/Fonction du membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[2]", textePoste, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification l'Affichage du 'texte David : « La gestion du club devient un jeu d’enfant. » ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[5]/div/div/div[1]/span[3]", logger); 
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	
	
	/**
	 * FOnction Vérifiant du Footer : Footer mon club facile.  
	 * 
	 * @param logger
	 * @param driver
	 * @param texteCommeçaMarche : exemple : Comment ça marche ?
	 * @param texteAssistance :  exemple : Assistance
	 * @param texteTarif : exemple : Tarif
	 * @param texteSecurite : exemple : Sécurité
	 * @param texteQuiSommesNous : exemple : Qui sommes nous?
	 * @param texteAvantages : exemple : Avantages
	 * @param texteConditionsGenUtilisation : exemple : Conditions générales d'utilisation
	 * @param texteMentionsLegales : exemple : Mentions légales
	 * @throws IOException
	 */  
	
	public void Footer(Logger logger, WebDriver driver,String texteCommeçaMarche, String texteAssistance, String texteTarif, String texteSecurite, String texteQuiSommesNous, String texteAvantages, 
			String texteConditionsGenUtilisation, String texteMentionsLegales) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage de l'icône Maif", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='footer']/footer/div/div/div[1]/div/img", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Comment ça marche ? '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[1]", texteCommeçaMarche, logger);
			Thread.sleep(2000);  
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Assistance '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[2]", texteAssistance, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Tarif '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[3]", texteTarif, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Sécurité '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[4]", texteSecurite, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Qui sommes nous ? '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[1]", texteQuiSommesNous, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Avantages '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[2]", texteAvantages, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Conditions générales d'utilisation '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[3]", texteConditionsGenUtilisation, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Mentions légales '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[4]", texteMentionsLegales, logger);
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant du Footer : Footer mon club facile.  
	 * 
	 * @param logger
	 * @param driver
	 * @param texteCommeçaMarche : exemple : Comment ça marche ?
	 * @param texteAssistance :  exemple : Assistance
	 * @param texteTarif : exemple : Tarif
	 * @param texteSecurite : exemple : Sécurité
	 * @param texteQuiSommesNous : exemple : Qui sommes nous?
	 * @param texteAvantages : exemple : Avantages
	 * @param texteConditionsGenUtilisation : exemple : Conditions générales d'utilisation
	 * @param texteMentionsLegales : exemple : Mentions légales
	 * @throws IOException
	 */  
	// Je me permets d'ajouter Footer1 suite à l'échange avec le dev Baghdad, la maquette a deux footer , ie assistance et avantages sont intervertis selon les pages. 
	public void Footer1(Logger logger, WebDriver driver,String texteCommeçaMarche, String texteAvantages , String texteTarif, String texteSecurite, String texteQuiSommesNous, String texteAssistance, 
			String texteConditionsGenUtilisation, String texteMentionsLegales) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage de l'icône Maif", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='footer']/footer/div/div/div[1]/div/img", logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Comment ça marche ? '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[1]", texteCommeçaMarche, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Avantages '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[2]", texteAvantages, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Tarif '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[3]", texteTarif, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Sécurité '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[4]", texteSecurite, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Qui sommes nous ? '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[1]", texteQuiSommesNous, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Assistance '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[2]", texteAssistance, logger);
			//*[@id="footer"]/footer/div/div/div[2]/a[2]
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Conditions générales d'utilisation '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[3]", texteConditionsGenUtilisation, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Vérification l'Affichage du lien ' Mentions légales '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[4]", texteMentionsLegales, logger);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteInscription : exemple : Inscription
	 * @throws IOException
	 */
	
	public void OuvrirPageInscription(Logger logger, WebDriver driver,String texteInscription) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Mon compte MCF - Click sur '  CValide les cookies ' du soc ",logger, driver);
			scriptTech.clickByXpath(driver,"/html/body/div[1]/div/a", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Inscription'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[4]/button", texteInscription, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Click sur le texte 'Inscription'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='navigation']/ul/li[4]/button", logger); 
			
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	
	/**
	 * FOnction Vérifiant la page de clique sur Connexion de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteConnexion : exemple : Inscription
	 * @throws IOException
	 */
	
	public void OuvrirPageConnexion(Logger logger, WebDriver driver,String texteConnexion) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Connexion'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[5]/button", texteConnexion, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Click sur le texte 'Connexion'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='navigation']/ul/li[5]/button", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Mon compte MCF - Click sur '  CValide les cookies ' du soc ",logger, driver);
			scriptTech.clickByXpath(driver,"/html/body/div[1]/div/a", logger);
			Thread.sleep(2000);
			
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	
	
	
	/**
	 * FOnction Vérifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteInscriptionAmonClub : exemple : Inscription
	 * @param texteServiceAccessible : exemple : Mon Club Facile est un service accessible gratuitement aux associations et clubs sportifs.
	 * @param texteVotreClub : exemple : Votre club est-il sociétaire MAIF ?
	 * @param texteOui : exemple : OUI
	 * @param texteNon : exemple : NON
	 * @throws IOException
	 */
	
	public void ChoixOuiNon(Logger logger, WebDriver driver,String texteInscriptionAmonClub, String texteServiceAccessible, String texteVotreClub, 
			String texteOui, String texteNon) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'INSCRIPTION À MON CLUB FACILE'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='formulaires']/section/div/div/div/div/h1", texteInscriptionAmonClub, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Mon Club Facile est un service accessible gratuitement aux associations et clubs sportifs.'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[1]/div/h2", texteServiceAccessible, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Votre club est-il sociétaire MAIF ?'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/label", texteVotreClub, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[2]/label", texteNon, logger); 
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	
	
	
	/**
	 * FOnction Vérifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteClub : exemple : Votre club est-il sociétaire MAIF ?
	 * @param texteChoixOui : exemple : OUI
	 * @param texteChoixNon : exemple : NON
	 * @throws IOException
	 */
	
	public void ChoisirNon(Logger logger, WebDriver driver,String texteClub, String texteChoixOui, String texteChoixNon) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Votre club est-il sociétaire MAIF ?'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/label", texteClub, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[1]/label", texteChoixOui, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[2]/label", texteChoixNon, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Click sur 'NON'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[2]/label", logger); 
				
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteVotreClub : exemple : Votre club est-il sociétaire MAIF ?
	 * @param texteOui : exemple : OUI
	 * @param texteNon : exemple : NON
	 * @throws IOException
	 */
	
	public void ChoixOui(Logger logger, WebDriver driver,String texteVotreClub, String texteOui, String texteNon) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Votre club est-il sociétaire MAIF ?'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/label", texteVotreClub, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Click sur 'OUI'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[1]/label", logger); 
				
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction Vérifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteCreation : exemple : Inscription
	 * @throws IOException
	 */
	
	public void TexteCreation(Logger logger, WebDriver driver,String texteCreation) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Votre club est-il sociétaire MAIF ?'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/label", texteCreation, logger); 
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	

	/**
	 * FOnction Vérifiant la page d'inscription , niveau 1 = identité club/asso
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteIdentite : exemple : IDENTITÉ DU CLUB/ASSOCIATION 
	 * @param texteNomClubAsso: exemple : Nom du club/association *
	 * @param texteTelephone : Téléphone *
	 * @param texteAdresse : exemple : Adresse du club/association *
	 * @param texteEtesVous : exemple : Êtes-vous affilié à une fédération ou groupement national ? *
	 * @param texteOui :  exemple : OUI
	 * @param texteNon : exemple :  NON
	 * @param textePrecision : exemple :  Précisez laquelle *
	 * @param texteActiviteSportPratiq : exemple : Activité sportive pratiquée *
	 * @throws IOException
	 */
	public void IdenditeCommune(Logger logger, WebDriver driver ,String texteIdentite, String texteNomClubAsso, String texteTelephone, String texteAdresse, 
			String texteEtesVous, String texteOui, String texteNon, String texteActiviteSportPratiq) throws IOException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'IDENTITÉ DU CLUB/ASSOCIATION'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]", texteIdentite, logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Nom du club/association *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/label", texteNomClubAsso, logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'ALATA Ibrahima'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/div/input", "ALATA Ibrahima", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Téléphone *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/label", texteTelephone, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du numero de tel'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/div/input", "06 18 65 77 23", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Adresse du club/association *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/label", texteAdresse, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage de l'adresse du club/asso'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/div/input", "12 rue des plantes", logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Code postal/Ville *'", logger, driver);
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du code postale du club/asso : 79000 - Niort'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", "79000", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-2--value']/div/input", Keys.ENTER, logger); 
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", " 79000 - Niort", logger);
			Thread.sleep(4000);
			//scriptTech.sendKeysByXpath(driver, "input.Select-input", Keys.RETURN, logger); 
			//scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", Keys.ENTER, logger); 
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", "79000", logger);
			Thread.sleep(2000); 
			 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Êtes-vous affilié à une fédération ou groupement national ? *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/label", texteEtesVous, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", texteOui, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Cliquez sur le texte texte 'NON'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", logger); 
			Thread.sleep(2000);
			//log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Précisez laquelle *'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/label", textePrecision, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Activité sportive pratiquée *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/div/label", texteActiviteSportPratiq, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du type d'activité sportive'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-3--value']/div[2]/input", " sport automobile", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-3--value']/div/input", Keys.ENTER, logger); 
			Thread.sleep(2000);
			//log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Ajouter Une Activité'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[7]/div[2]/a", texteAjouterUneActivite, logger);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	

	
	

	/**
	 * FOnction Vérifiant la page d'inscription , niveau 1 = identité club/asso Pré-rempli
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteIdentite : exemple : IDENTITÉ DU CLUB/ASSOCIATION 
	 * @param texteNomClubAsso: exemple : Nom du club/association *
	 * @param texteTelephone : Téléphone *
	 * @param texteAdresse : exemple : Adresse du club/association *
	 * @param texteCodePostal : exemple : Code postal/Ville *
	 * @throws IOException
	 */
	public void IdenditeCommuneSocPreRempli(Logger logger, WebDriver driver ,String texteIdentite,  String texteNomClubAsso, String texteTelephone,
			String texteAdresse, String texteCodePostal) throws IOException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'IDENTITÉ DU CLUB/ASSOCIATION'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]", texteIdentite, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Nom du club/association *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/label", texteNomClubAsso, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'SAPFR'", logger, driver); 
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/div/input", texte1, logger); 
			scriptTech.isElementExisteByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/div/input", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Téléphone *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/label", texteTelephone, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du numero de tel : 03 83 28 80 28'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/div/input", texte2, logger); 
			scriptTech.isElementExisteByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/div/input", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Adresse du club/association *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/label", texteAdresse, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage de l'adresse du club/asso :  11 RUE JEAN JAURES'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/div/input", texte3, logger); 
			scriptTech.isElementExisteByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/div/input", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'Code postal/Ville *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[4]/label", texteCodePostal, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du code postale du club/asso : ' 54320 - Maxéville '", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='react-select-2--value']/div/input", logger);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='react-select-2--value']/div[1]", logger); 
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value-item']", "54320 - Maxéville", logger);
			Thread.sleep(2000);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
			
			//////////////////
	/**
	 * FOnction Vérifiant la page d'inscription , niveau 1 = identité club/asso Reste à remplir au click sur NON à partir de la question Êtes-vous affilié à une fédération ou groupement national ? *
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteEtesVous : exemple : Êtes-vous affilié à une fédération ou groupement national ? *
	 * @param texteOui :  exemple : OUI
	 * @param texteNon : exemple :  NON
	 * @param texteActiviteSportPratiq : exemple : Activité sportive pratiquée *
	 * @throws IOException
	 */
	public void IdenditeCommuneSocNonRempliClickNon(Logger logger, WebDriver driver , String texteEtesVous, String texteOui, String texteNon/*, String texteActiviteSportPratiq*/) throws IOException {
		try {	
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Êtes-vous affilié à une fédération ou groupement national ? *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/label", texteEtesVous, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'NON'", logger, driver); 
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo("MCF - Cliquez sur le texte texte 'NON'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", logger); 
			Thread.sleep(2000);
			
		/*	log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Activité sportive pratiquée *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/div/label", texteActiviteSportPratiq, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du type d'activité sportive'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-3--value']/div[1]", "sport automobile", logger);
			//*[@id="react-select-3--value"]/div[1] */
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction Vérifiant la page d'inscription , niveau 1 = identité club/asso Reste à remplir au click sur OUI à partir de la question Êtes-vous affilié à une fédération ou groupement national ? *
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteEtesVous : exemple : Êtes-vous affilié à une fédération ou groupement national ? *
	 * @param texteOui :  exemple : OUI
	 * @param texteNon : exemple :  NON
	 * @param textePrecision : exemple :  Précisez laquelle *
	 * @param texteActiviteSportPratiq : exemple : Activité sportive pratiquée *
	 * @throws IOException
	 */
	public void IdenditeCommuneSocNonRempliClickOui(Logger logger, WebDriver driver , String texteEtesVous, String texteOui, String texteNon, String textePrecision, String texteActiviteSportPratiq) throws IOException {
		try {	
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Êtes-vous affilié à une fédération ou groupement national ? *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/label", texteEtesVous, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo("MCF - Cliquez sur le texte texte 'OUI'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Précisez laquelle *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/label", textePrecision, logger);
			Thread.sleep(4000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage de la réponse du texte 'Précisez laquelle *'", logger, driver);
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-5--value']/div[1]", "FF de ski", logger); 
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-4--value']/div/input", "ski", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-4--value']/div/input", Keys.ENTER, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Activité sportive pratiquée *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[7]/div/label", texteActiviteSportPratiq, logger);
			Thread.sleep(4000);
			
			//log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte : ' Aviron '", logger, driver);
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-3--value']/div[1]", "Aviron", logger);
			//*[@id="react-select-3--value"]/div[1]
			log.reportLogTNRInfo("- MCF - Saisie du type d'activité sportive'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-3--value']/div/input", "Aviron", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-3--value']/div/input", Keys.ENTER, logger);
			Thread.sleep(2000); 
			
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}

	
	/**
	 * FOnction Vérifiant la page d'inscription , niveau 1 = identité club/asso , click sur OUI à partir de la question 'Êtes-vous affilié à une fédération ou groupement national ? *'
	 * 
	 * @param logger
	 * @param texteEtesVous : exemple : Êtes-vous affilié à une fédération ou groupement national ? *
	 * @param texteOui :  exemple : OUI
	 * @param texteNon : exemple :  NON
	 * @param textePrecision : exemple :  Précisez laquelle *
	 * @throws IOException
	 */
	public void IdenditeCommuneSocAffilieClickOui(Logger logger, WebDriver driver, String texteEtesVous, String texteOui, String texteNon/*, String textePrecision*/) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Êtes-vous affilié à une fédération ou groupement national ? *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/label", texteEtesVous, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo("MCF - Cliquez sur le texte texte 'OUI'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", logger); 
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Précisez laquelle *'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/label", textePrecision, logger);
			
			log.reportLogTNRInfo("MCF - Saisie du texte 'FF de ski'", logger, driver);
			//scriptTech.clickByXpath(driver, "//*[@id='react-select-6--value']/div[1]", logger);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-6--value']/div[1]", "FF de ski", logger);
			driver.findElement(By.xpath("//input[@value='FF de ski']")).sendKeys(Keys.ENTER);
			
			//*[@id="react-select-6--value-item"]
			//driver.findElement(By.id("Value")).sendKeys(Keys.RETURN);
			//driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
			//driver.findElement(By.xpath("//input[@value='FF de ski']")).clear();
		    //driver.findElement(By.xpath("//input[@value='FF de ski']")).sendKeys("FF de ski");
			
			
			log.reportLogTNRInfo("- MCF - Vérification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo(" MCF - Cliquez sur le texte texte 'NON'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", logger); 
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	/**
	 * FOnction Vérifiant la page d'inscription , niveau 1 = identité club/asso
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteCompte : exemple : FINALISER VOTRE COMPTE
	 * @param texteParametrez : exemple : Paramétrez les informations qui vous permettront de vous connecter à votre compte Mon Club Facile.
	 * @param texteEmail : exemple :  Email *
	 * @param texteMotDePasse : exemple : Mot de passe *
	 * @param texteConfirmerMotDePasse : exemple : Confirmer votre mot de passe *
	 * @throws IOException
	 */
	public void FinaliserCompte(Logger logger, WebDriver driver ,String texteCompte, String texteParametrez, String texteEmail, String texteMotDePasse, 
			
			String texteConfirmerMotDePasse) throws IOException {
				Random rand = new Random();
				int n = rand.nextInt() +1;
				String mail = "ibrahima."+n +"alata@gmail.com";
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage du texte 'FINALISER VOTRE COMPTE'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[4]", texteCompte, logger);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='subscription_form']/div[4]", logger);
			
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Paramétrez les informations qui vous permettront de vous connecter à votre compte Mon Club Facile.'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[1]", texteParametrez, logger);  
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Email *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[2]/label", texteEmail, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'adresse mail'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[2]/div/input", mail, logger);
			
			
			  
			log.reportLogTNRInfo(" MCF - Vérification Affichage du texte 'Mot de passe *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[3]/label", texteMotDePasse, logger); 
			
			log.reportLogTNRInfo(" MCF - Vérification la saisie  du mot de passe'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='inputPassword']", "Kolima24@", logger); 
				
			log.reportLogTNRInfo(" MCF - Vérification Affichage du texte 'Confirmer votre mot de passe *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[4]/label", texteConfirmerMotDePasse, logger); 
			
			log.reportLogTNRInfo(" MCF - Vérification la confirmation de la saisie  du mot de passe'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='inputPasswordConfirm']", "Kolima24@", logger); 
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction Vérifiant la page d'inscription , niveau 1 = identité club/asso
	 * 
	 * @param logger
	 * @param driver
	 * @param texteCoche : exemple : En cochant cette case, je reconnais avoir pris connaissance des Conditions Générales d'Utilisation du service « Mon Club Facile » et je les accepte.
	 * @param texteValider :  exemple : VALIDEZ
	 * @throws IOException
	 */
	public void CguValid(Logger logger, WebDriver driver , String texteCoche, String texteValider) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Conditions générales'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[5]/div/label", texteCoche, logger);
			
			log.reportLogTNRInfo("MCF - Click sur le texte 'Conditions générales'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[5]/div/label", logger); 
	
			log.reportLogTNRInfo(" MCF - Vérification Affichage du texte 'Valider'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/div[1]/button", texteValider, logger); 
			
			log.reportLogTNRInfo("MCF - Click sur le texte 'VALIDER'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[5]/div[1]/button", logger); 
			Thread.sleep(3000);
			
			log.reportLogTNRInfo("MCF - Fermeture du Popup Après le Click sur le texte 'VALIDER'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='creation-sucess']/div/div/div[1]/div/i", logger); 
			Thread.sleep(3000);
			
			
	
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	
	/**
	 * FOnction Vérifiant le prénom du soc sur la partie MON COMPTE.
	 * 
	 * @param logger
	 * @param driver
	 * @param textePrenom : exemple : alata
	 * @param texteActivité :  exemple : Activité(s) :
	 * @param texteTypeActivite : exemple : rallye automobile,
	 * @throws IOException
	 */
	public void PrenomNom(Logger logger, WebDriver driver , String textePrenom/*, String texteActivité*/) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du prénom ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div[1]", textePrenom, logger);
			
		//	log.reportLogTNRInfo("MCF - Vérification Affichage du texte : 'Activité(s) :'", logger, driver);
		//	scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div[3]/div", texteActivité, logger);

			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	/**
	 * FOnction Vérifiant le Profil du soc sur la partie MON COMPTE.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteProfil : exemple : Profil
	 * @param texteNomDuClub :  
	 * @param RepNomClub : 
	 * @param texteNomFederation
	 * @param RepNomFed
	 * @param texteActivite
	 * @param RepActivite
	 * @throws IOException
	 */
	public void Profil(Logger logger, WebDriver driver , String texteProfil/*, String texteNomDuClub, String texteNomFederation, String texteActivite*/) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du Profil ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div[1]/h2", texteProfil, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte : 'Nom du club/association : alata'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[1]/span", texteNomDuClub, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[1]/span", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' Nom de la fédération: FF de jeu de paume'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[2]/span", texteNomFederation, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[2]/span", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Activité(s) : rallye automobile,'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[3]/span", texteActivite, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[3]/span", logger);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant le contact du soc sur la partie MON COMPTE.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteContact : exemple : Profil
	 * @param texteAdresse :  
	 * @param texteCodePostalVille: 
	 * @param texteMail
	 * @param texteTel
	 * @throws IOException
	 */
	public void Contact(Logger logger, WebDriver driver , String texteContact,/* String texteAdresse,*/ String texteCodePostalVille,/* String texteMail,*/ String texteTel) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du Contact ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div[2]/h2", texteContact, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte : 'Adresse : rue des plantes'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[1]/span", texteAdresse, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[1]/span", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' Code postal/Ville : 79000 Niort'  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[2]/span", texteCodePostalVille, logger);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[2]/span", logger);
			
			log.reportLogTNRInfo(" MCF - Vérification Affichage du texte 'Adresse e-mail : ibrahima.alata@gmail.com'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[3]/span", texteMail, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[3]/span", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'Téléphone : 06 18 65 77 21'  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[4]/span", texteTel, logger);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant l'id de connexion du soc sur la partie MON COMPTE.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteIdConnexion
	 * @param texteEmail
	 * @param texteMotDePasse
	 * @throws IOException
	 */
	public void IdentifConnexion(Logger logger, WebDriver driver , String texteIdConnexion, String texteEmail, String texteMotDePasse) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte Identifiant de connexion ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div[3]/h2", texteIdConnexion, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage de : Email : ibrahima.alata@gmail.com'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[3]/li[1]/span[1]", texteEmail, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' Mot de passe :'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[3]/li[2]/span[1]", texteMotDePasse, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[3]/li[2]/span[1]", logger);
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant l'id de connexion du soc sur la partie MON COMPTE.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteModuleDePiaementEnLigne
	 * @param texteAfinDeCollecter
	 * @param texteEnSavoirPlus
	 * @throws IOException
	 */
	public void PaiementEnLigne(Logger logger, WebDriver driver , String texteModuleDePiaementEnLigne, String texteEnSavoirPlus) throws IOException {
		try {
			log.reportLogTNRInfo("MCF -Click sur le texte 'MODULE DE PAIEMENT EN LIGNE' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[1]/div/a[2]/span", logger); 
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du logo Carte Bancaire ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte MODULE DE PAIEMENT EN LIGNE ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div/div[2]", texteModuleDePiaementEnLigne, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte : 'Afin de collecter en ligne les cotisations de vos adhérents *, activez le module de paiement par carte bancaire.''", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div/p", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte 'En savoir plus'  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div/div[3]/button", texteEnSavoirPlus, logger);
			 
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant l'id de connexion du soc sur la partie MON COMPTE.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteDeconnexion
	 * @throws IOException
	 */
	public void SeDeconnecter(Logger logger, WebDriver driver , String texteDeconnexion) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur le menu dépliant la page du 'Profil du club' et de la 'Déconnexion' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='top-right-menu']/ul/li/a/span[2]", logger); 
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte Déconnexion ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='top-right-menu']/ul/li/ul/li[3]/a", texteDeconnexion, logger);
			
			log.reportLogTNRInfo("MCF - Click sur le texte Déconnexion ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='top-right-menu']/ul/li/ul/li[3]/a", logger); 
			 
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant le prénom Adhérent dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param textePrenomAdherent : exemple : alata
	 * @throws IOException
	 */
	public void PrenomAdherent(Logger logger, WebDriver driver , String textePrenomAdherent) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du prénom ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[1]", textePrenomAdherent, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant du texte Adhérent dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteAdherent : exemple : ADHERENT
	 * @throws IOException
	 */
	public void Adherent(Logger logger, WebDriver driver , String texteAdherent) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'icône et le nombre d'adhérents ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[1]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ADHERENT ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[1]/div/div[2]", texteAdherent, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant du texte Commandés dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteCommandes : exemple : COMMANDÉS
	 * @throws IOException
	 */
	public void Commandes(Logger logger, WebDriver driver , String texteCommandes) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'icône et la quantité commandée ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[2]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte COMMANDÉS ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[2]/div/div[2]", texteCommandes, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant du texte Payés dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param textePayes : exemple : PAYÉS
	 * @throws IOException
	 */
	public void Payes(Logger logger, WebDriver driver , String textePayes) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'icône et la la somme payée ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[3]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte PAYÉS ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[3]/div/div[2]", textePayes, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant du texte 'En attente de règlement' dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteReglement : exemple : EN ATTENTE DE RÈGLEMENT
	 * @param texteVoirCollectes : exemple : VOIR LES COLLECTES
	 * @throws IOException
	 */
	public void Reglement(Logger logger, WebDriver driver , String texteReglement, String texteVoirCollectes) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' EN ATTENTE DE RÈGLEMENT' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[1]/div/div[1]", texteReglement, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'icône et la la somme en attente de règlement ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[1]/div/div[2]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' EN ATTENTE DE RÈGLEMENT' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[1]/div/div[2]/div/div[2]/button", texteVoirCollectes, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant du texte 'Paiement en ligne' dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param textePaiemLigne : exemple : PAIEMENT EN LIGNE
	 * @param texteActivez :  exemple : ACTIVEZ LE MODULE DE PAIEMENT PAR CARTE BANCAIRE
	 * @param texteEnSavoir : exemple : EN SAVOIR+
	 * @throws IOException
	 */
	public void PaiementLigne(Logger logger, WebDriver driver , String textePaiemLigne, String texteEnSavoir) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' PAIEMENT EN LIGNE' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[2]/div/div[1]", textePaiemLigne, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' ACTIVEZ LE MODULE DE PAIEMENT PAR CARTE BANCAIRE ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[2]/div/div[2]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' EN SAVOIR+ ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[2]/div/div[2]/div/div[2]/button", texteEnSavoir, logger); 
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant du texte 'Derniers inscrits' dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteDerniersInscrits : exemple : DERNIERS INSCRITS
	 * @param texteNomPren :  exemple : IBRAHIM romaric
	 * @param texteAsso : exemple : ALATA
	 * @throws IOException
	 */
	public void DerniersInscrits(Logger logger, WebDriver driver , String texteDerniersInscrits) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' DERNIERS INSCRITS ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[4]/div/div/div[1]", texteDerniersInscrits, logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du picto derniers inscrits ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[4]/div/div/div[2]/div/ul/div", logger);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' IBRAHIM romaric et ALATA ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[4]/div/div/div[2]/div/ul/li", logger);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction Vérifiant le click sur texte Adhérent dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickAdhe(Logger logger, WebDriver driver ) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur ADHERENTS ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[1]/div", logger); 
			Thread.sleep(2000);
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
	}
	
	
	/**
	 * FOnction Vérifiant le click sur texte Commandes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickComma(Logger logger, WebDriver driver ) throws IOException {
		try {
			Thread.sleep(3000);
			log.reportLogTNRInfo(" MCF - Click sur COMMANDES ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[1]", logger);
			//*[@id="page-wrapper"]/div/div[2]/div/a/div/div[2]/div[2]/div/div[2]
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction Vérifiant le click sur texte Payés dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickPay(Logger logger, WebDriver driver ) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur Payés ", logger, driver);
			//scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[3]/div/div[2]", logger);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[1]", logger); 
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}

	
	
	/**
	 * FOnction Vérifiant le click sur voir les collectes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickReglmtVoirCollectes(Logger logger, WebDriver driver) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur Voir les collectes dans la partie En attente de Règlement  ", logger, driver);
			//scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[1]/div/div[2]/div/div[2]/button", logger); 
			scriptTech.clickById(driver, "page-wrapper", logger); 
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction Vérifiant le click sur voir les collectes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickMesCollectes(Logger logger, WebDriver driver ,/*String texteCreerCollect,*/ String textePub, String texteBrou, String texteTermine, String texteCorb) throws IOException {
		try {
			/*log.reportLogTNRInfo("MCF - Click sur ' Mes collectes ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[2]/a/span", logger); 
			Thread.sleep(5000);*/
			Thread.sleep(5000);
			
			//log.reportLogTNRInfo("MCF - Vérification de l'existnce du menu 'CREER UNE COLLECTE'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[2]/a/button", texteCreerCollect, logger);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[2]/a/button", logger);
			//Thread.sleep(3000); 
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' PUBLIÉES '  ", logger, driver);
            scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[1]", textePub, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' BROUILLONS '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[2]", texteBrou, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' TERMINÉES '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[3]", texteTermine, logger);  
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' CORBEILLES '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[4]", texteCorb, logger); 
			Thread.sleep(2000);
			
			
			/*log.reportLogTNRInfo("MCF - Click sur ' Mes collectes ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[2]/a/span", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du menu ' CRÉER UNE COLLECTE '  ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[2]/a/button", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' PUBLIÉES '  ", logger, driver);
            scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[1]", textePub, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' BROUILLONS '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[2]", texteBrou, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' TERMINÉES '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[3]", texteTermine, logger);  
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' CORBEILLES '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[4]", texteCorb, logger); 
			Thread.sleep(2000);*/
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}	
			
	
	/**
	 * FOnction Vérifiant le click sur voir les collectes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickPubli(Logger logger, WebDriver driver ,String texteAlata, String texteDateAdhesion, String texteBlocAdherent, String texteBlocComm, String texteBlocP, String texteVoirMaPag) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur ' Publiées ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[1]", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' ALATA '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[1]/div[1]", texteAlata, logger);
			Thread.sleep(2000); 
			
			log.reportLogTNRInfo("MCF - Click sur ' Nom = ALATA	 ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[1]/div[1]", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' ADHÉSION - fin le 06/08/2022'  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[2]", texteDateAdhesion, logger);
			Thread.sleep(2000); 
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce ' ADHÉRENT ' dans le premier bloc ", logger, driver);
            scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div[2]/div[2]", texteBlocAdherent, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Vérification de l'existnce ' COMANDÉ ' dans le second bloc ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[2]/div[2]/div[2]", texteBlocComm, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' PAYÉS ' dans le troisème bloc ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[3]/div[2]/div[2]", texteBlocP, logger);  
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existnce du bloc ' VOIR MA PAGE '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[5]/a", texteVoirMaPag, logger); 
			Thread.sleep(2000);
			
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}	
			
	
	
	
	
	
	/**
	 * FOnction Vérifiant le click sur l'onglet Assistance de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickAssistance(Logger logger, WebDriver driver , String texteTel, String texteEmail, String texteNumTel, /*String texteQuestion,String texteHoraires,  */String texteFormDeCont) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur ' Assistance ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[5]/a/span", logger);
			Thread.sleep(6000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existance du logo téléphone  ", logger, driver);
			scriptTech.isElementExisteById(driver, "cgu", logger); 
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[1]", logger);  
			Thread.sleep(5000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existance du logo mail  ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[1]/i", logger);
			Thread.sleep(3000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existance du texte ' PAR TÉLÉPHONE ' ", logger, driver);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[1]", logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[1]", texteTel, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existance du texte ' PAR E-MAIL ' ", logger, driver);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]", logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]", texteEmail, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existance du numéro de téléphone ' 01 84 25 20 01 ' ", logger, driver);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]", logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]", texteNumTel, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existance du numéro du texte ' Posez votre question au service d'assistance. ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]", logger);
			//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]", texteQuestion, logger);
			Thread.sleep(2000);
		
			log.reportLogTNRInfo("MCF - Vérification de l'existance du numéro du texte ' Horaires : du lundi au vendredi de 09h00 à 19h00 ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[4]", logger);
			//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[4]", texteHoraires, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification de l'existance du numéro de téléphone ' FORMULAIRE DE CONTACT ' ", logger, driver);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[3]/button", logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[3]/button", texteFormDeCont, logger); 
			Thread.sleep(2000);
			
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}	
			
	/**
	 * FOnction Vérifiant le click sur voir les collectes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickPubliees(Logger logger, WebDriver driver, String textePub, String texteBrou, String texteTermine, String texteCorb) throws IOException {
		try {	
			
			log.reportLogTNRInfo("MCF - Vérification du texte 'ALATA' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[1]/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification de la date d'adhésion et du texte 'ADHÉSION - fin le 06/08/2022'  ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[2]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification du texte ' ADHÉRENT' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification du texte ' COMMANDÉS' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[2]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification du texte ' PAYÉS' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[3]", logger);
			
			log.reportLogTNRInfo("MCF - Vérification du texte ' VOIR MA PAGE' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[5]/a", logger);
			
			log.reportLogTNRInfo("MCF - Click sur le texte ' VOIR MA PAGE' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[5]/a", logger);  
			
			
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction Vérifiant le click sur texte Paiement en ligne dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adhérent :
	 * @throws IOException
	 */
	public void ActionClickPaiementLignEnSavoirPlus(Logger logger, WebDriver driver ) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur VEn savoir +  dans la partie Paiement en ligne  ", logger, driver);
			//scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[2]/div/div[2]/div/div[2]/button", logger); 
			scriptTech.clickById(driver, "page-wrapper", logger); 
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	
		public void ActionClick(Logger logger, WebDriver driver , String texteRechAdherent, String Nom, String Prenom, String DateDeNaissance, String Tarif, 
				String Montant, String Statut, String Mode/*, String Certifi*/) throws IOException {
			try {
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'icône et le nombre d'adhérents", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'icône et la quantité commandée", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div[2]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'icône et la somme payée", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div[3]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage de l'icône et la somme en attente", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div[4]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' Rechercher un adhérent : ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[1]/div/div/div[1]/div/div/div[1]", texteRechAdherent, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' Recherche par filtres ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='rechfiltre']", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' AJOUTER UN ADHÉRENT ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='rechfiltre']", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' NOM : IBRAHIM ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[4]", Nom, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte PRÉNOM : ROMARIC", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[6]", Prenom, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte DATE DE NAISSANCE : 12/12/1958", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[7]", DateDeNaissance, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte TARIF ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[9]/div/div", Tarif, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte MONTANT : 5.00€", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[10]/div", Montant, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte STATUT DE PAIEMENT : CHÈQUE", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[11]", Statut, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte MODE DE DE PAIEMENT : EN ATTENTE", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[12]", Mode, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - Vérification Affichage du texte CERTIFICAT MÉDICAL : NON", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[13]/div", Certifi, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[13]/div", logger);
			Thread.sleep(2000);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
		
		
		
		/**
		 * FOnction Vérifiant du bloc 'En attente de virement ' dans mes virements de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteAdherent : exemple : ADHERENT
		 * @throws IOException
		 */
		public void EnAttenteDeVi(Logger logger, WebDriver driver, String texteAttenteVir, String texteMontantTotalVir, String texteDetailPiaementCB, String texteCB, String texteDetailMontantFrais, String texteFrais) throws IOException {
			try {
				/*log.reportLogTNRInfo("MCF - Vérification Affichage du bloc texte ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[1]", logger); 
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du logo du montant total du menu ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[2]", logger);

				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' soit	0,00 € Paiements par CB ' dans le menu ' EN ATTENTE DE VIREMENT '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[3]", logger);  
			
				log.reportLogTNRInfo("MCF - Vérification Affichage du détail du texte ' -0,00 € Frais E-Cotiz' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[4]", logger); */
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du bloc texte ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[1]", texteAttenteVir, logger);  
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du logo du montant total du menu ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[2]", logger);

				log.reportLogTNRInfo("MCF - Vérification Affichage du montant total ' EN ATTENTE DE VIREMENT '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[2]/div[2]", texteMontantTotalVir, logger);  
			
				log.reportLogTNRInfo("MCF - Vérification Affichage du détail du montant par carte bancaire EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[3]/div[2]", texteDetailPiaementCB, logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte de la phrase  Paiement par carte bancaire EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[3]/div[3]", texteCB, logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du détail du montant par Frais E-Cotiz EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[4]/div[2]", texteDetailMontantFrais, logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte de la phrase  Frais E-Cotiz EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[4]/div[3]", texteFrais, logger); 
				 
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}

		}
	
		
		/**
		 * FOnction Vérifiant du du bloc prochain virement  dans le mes virements de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteCommandes : exemple : COMMANDÉS
		 * @throws IOException
		 */
		public void ProchViremt(Logger logger, WebDriver driver , String texteProchVir, String texteMontantTotalProchVir) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' PROCHAIN VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[2]/div/div[1]", texteProchVir, logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du logo du menu ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[2]/div/div[2]/div[1]", logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du montant total du menu ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[2]/div/div[2]/div[2]", texteMontantTotalProchVir, logger);  
			
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}

		}
		
		
		/**
		 * FOnction Vérifiant du du bloc historique des virements de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteCommandes : exemple : COMMANDÉS
		 * @throws IOException
		 */
		public void HistoVirmt(Logger logger, WebDriver driver , String texteHistoViret, String texteDate, String texteLib, String texteNomCol, String texteMontant) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[1]/a", texteHistoViret, logger);
				
				log.reportLogTNRInfo("MCF - Click sur le texte ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[1]/a", logger); 
				
				log.reportLogTNRInfo("MCF - Vérification Affichage de la ' DATE ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[1]", texteDate, logger); 
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' LIBELLÉ ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[2]", texteLib, logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' NOM DE LA COLLECTE ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[3]", texteNomCol, logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' MONTANT ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[4]", texteMontant, logger); 
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' AUCUN VIREMENT EFFECTUÉ SUR VOTRE COMPTE. ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/tbody/tr/td/p", logger);
				
				
				/*log.reportLogTNRInfo("MCF - Vérification Affichage de la ' DATE ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[1]", logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' LIBELLÉ ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[2]", logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' NOM DE LA COLLECTE ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[3]", logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' MONTANT ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[4]", logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' AUCUN VIREMENT EFFECTUÉ SUR VOTRE COMPTE. ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo]/div/div/div/table/tbody/tr/td/p", logger);*/
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}

		}
		
		
		/**
		 * FOnction Vérifiant du du bloc Fréquence des virements de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteCommandes : exemple : COMMANDÉS
		 * @throws IOException
		 */
		public void FrequenceVirt(Logger logger, WebDriver driver , String texteFreqViret, String NumeroFreq, String Nom, String Mensuel) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' FRÉQUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[2]/a", texteFreqViret, logger);
				
				log.reportLogTNRInfo("MCF - Click sur le texte ' FRÉQUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[2]/a", logger); 
				
				log.reportLogTNRInfo("MCF - Vérification Affichage de la ' RÉFÉRENCE ' dans le menu ' FRÉQUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[1]/table/thead/tr/th[1]", logger); 
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' NOM DE LA COLLECTE ' dans le menu ' FRÉQUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[1]/table/thead/tr/th[2]", logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' FRÉQUENCE ' dans le menu ' FRÉQUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[1]/table/thead/tr/th[3]", logger);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' 1754 ' dans le menu 'FRÉQUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[2]/table/tbody/tr/td[1]", NumeroFreq, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' ALATA ' dans le menu 'FRÉQUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[2]/table/tbody/tr/td[2]", Nom, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification Affichage du texte ' MENSUELLE ' dans le menu 'FRÉQUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[2]/table/tbody/tr/td[3]/div", Mensuel, logger);
				Thread.sleep(2000);
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}

		}
		
		
		public void ContenuAssFormu(Logger logger, WebDriver driver, String texteNomAsso, String texteNom, String textePrenom, String texteEmail, 
				String texteTel, String texteMotif, String texteMessage, String texteEnvoyer, String texteDemandeTransmise) throws IOException, Exception {
			
			//log.reportLogTNRInfo("Mon compte MCF - Click sur '  CValide les cookies ' du soc ",logger, driver);
			//scriptTech.clickByXpath(driver,"/html/body/div[1]/div/a", logger);
			//Thread.sleep(3000);
			 
			log.reportLogTNRInfo("Mon compte MCF - Mon Club Facile - Clique sur Assistance ",logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[5]/a/span", logger);
			Thread.sleep(5000);
			
			log.reportLogTNRInfo("Mon compte MCF - Mon Club Facile - Clique sur Formulaire de contact ",logger, driver);
			//scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[3]/button", logger);
			scriptTech.clickByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[3]/button", logger);
			Thread.sleep(4000);
			
			log.reportLogTNRInfo("Mon compte MCF - Vérifier la présence du texte ' Nom de l'association * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[1]/label", texteNomAsso, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Mon compte MCF - Vérifier la présence du texte ' Nom ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[2]/label", texteNom, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Saisir le texte 'LAVERROUX'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[2]/div/input", "LAVERROUX", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Mon compte MCF - Vérifier la présence du texte ' Prénom ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[3]/label", textePrenom, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Saisir le texte 'Marc'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[3]/div/input", "Marc", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Mon compte MCF - Vérifier la présence du texte ' Email * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[4]/label", texteEmail, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Mon compte MCF - Vérifier la présence du text ' Téléphone * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[5]/label", texteTel, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Saisir le texte '06 00 00 00 00'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[5]/div/input", "06 00 00 00 00", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Mon compte MCF - Vérifier la présence du text ' Quel est le motif de votre demande ? * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[6]/div/label", texteMotif, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Choix du motif de la demande", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='contact_form']/div[6]/div/div/div[1]/div", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Click sur le choix 1 : 'Probleme techenique'", logger, driver); 
			scriptTech.clickByXpath(driver, "//*[@id='contact_form']/div[6]/div/div/div[1]/ul/li[1]", logger); 
			Thread.sleep(2000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='contact_form']/div[6]/div/div/div[1]/ul/li[1]", Keys.ENTER, logger);
			Thread.sleep(4000);
		
			/*
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification Affichage de l'adresse du club/asso'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/div/input", "12 rue des plantes", logger);
			Thread.sleep(1000);*/
			/*
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", "79000", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-2--value']/div/input", Keys.ENTER, logger); 
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", " 79000 - Niort", logger);
			Thread.sleep(4000);*/
			
			log.reportLogTNRInfo("Mon compte MCF - Vérifier la présence du texte ' Messages * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[7]/label", texteMessage, logger); 
			Thread.sleep(5000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Saisir le texte  dans la case Messages *", logger, driver);
			//scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[5]/div/input", "Bonjour, je suis Mr X , je suis actuellement en vacance, je serai joignable uniquement par téléphone (06 00 00 00 00)  entre 10h-11h15. Merci de votre compréhension.  ", logger); 
			scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[7]/div/textarea", "Bonjour, je suis Mr X , je suis actuellement en vacance, je serai joignable uniquement par téléphone (06 00 00 00 00)  entre 10h-11h15. Merci de votre compréhension.  ", logger); 
			Thread.sleep(5000); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérifier la présence du texte ' ENVOYER VOTRE DEMANDE * ' dans  FORMULAIRE DE CONTACT", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[8]/button", texteEnvoyer, logger);
			Thread.sleep(1000); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification du texte ' ENVOYER VOTRE DEMANDE * ' dans  FORMULAIRE DE CONTACT", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[8]/button", texteEnvoyer, logger);
			Thread.sleep(5000); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Click sur le texte ' ENVOYER VOTRE DEMANDE * ' dans  FORMULAIRE DE CONTACT", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='contact_form']/div[8]/button", logger); 
			Thread.sleep(5000); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Vérification du texte ' VOTRE DEMANDE A BIEN ÉTÉ TRANSMISE AU SERVICE CLIENT MON CLUB FACILE, ELLE SERA TRAITÉE DANS UN DÉLAI DE 48H OUVRÉES. ' dans  FORMULAIRE DE CONTACT", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[3]/div/h3", texteDemandeTransmise, logger);
			Thread.sleep(5000);
			
			
		} 
	
		
		
		/**
		 * FOnction Vérifiant le click sur l'onglet Tarif dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adhérent :
		 * @throws IOException
		 */
		public void ActionTarifBloc1(Logger logger, WebDriver driver , String texteService/* String texteEvenement, String texteMembres, 
				String texteCommunic, String textePaeligne*/) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Click sur ' Tarif ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[1]/a", logger);
				Thread.sleep(4000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' LES SERVICES PROPOSÉS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[1]/div", texteService, logger); 
				Thread.sleep(4000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' GESTION DES ÉVÈNEMENTS '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[1]", logger);  
				//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[1]", texteEvenement, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' GESTION DES MEMBRES '  ", logger, driver);
				//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[2]", texteMembres, logger);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[2]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' OUTILS DE COMMUNICATION '  ", logger, driver);
				//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[3]", texteCommunic, logger); 
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[3]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' PAIEMENT EN LIGNE PAR CB '  ", logger, driver);
				//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[4]", textePaeligne, logger);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[4]", logger);
				Thread.sleep(3000);
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		/**
		 * FOnction Vérifiant le click sur l'onglet Tarif dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adhérent :
		 * @throws IOException
		 */
		public void ActionTarifBloc2(Logger logger, WebDriver driver , String texteSolutionComplete, String texteGerer, String texteSansLimite, String texteSansFrais, 
				String texteSansAbonnement, String texteSansSolu, String texteDesFrais, String texteEnCasDePaiement) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Click sur ' Tarif ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[1]/a", logger);
				Thread.sleep(5000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' UNE SOLUTION COMPLÈTE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/div", texteSolutionComplete, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' POUR GÉRER VOTRE ASSOCIATION '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[1]", texteGerer, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Sans limite de collecte '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[2]", texteSansLimite, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Sans frais d’installation '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[3]", texteSansFrais, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Sans abonnement '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[4]", texteSansAbonnement, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Sans engagement '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[5]", texteSansSolu, logger); 
				Thread.sleep(3000); 
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' DES FRAIS APPLIQUÉS UNIQUEMENT '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[2]/div", texteDesFrais, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' EN CAS DE PAIEMENT PAR CB '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[2]/p[1]", texteEnCasDePaiement, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Si vous utilisez le module de paiement en ligne, des frais de 3% sont appliqués sur les transactions bancaires (avec un minimum de 1€ et un maximum 10€) '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[2]/p[2]", logger); 
				Thread.sleep(3000);
				
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		/**
		 * FOnction Vérifiant le click sur l'onglet Comment ça marche  dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adhérent :
		 * @throws IOException
		 */
		public void ActionCommeCaMarcheBloc1(Logger logger, WebDriver driver) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Click sur ' Comment ça marche ? ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[2]/a", logger);
				Thread.sleep(3000);
				Thread.sleep(5000);
				log.reportLogTNRInfo("MCF - Vérification de l'existance de l'icône ' MON CLUB FACILE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div[1]/div/div/div[1]/img", logger);
				Thread.sleep(5000); 
				
				log.reportLogTNRInfo("MCF - Vérification de l'existance du texte ' La plateforme vous permet de gérer facilement vos adhésions en ligne mais également tous vos autres projets : évènements, e-boutique, etc... '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div[1]/div/div/div[2]/p[1]", logger);
				Thread.sleep(2000);
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		/**
		 * FOnction Vérifiant le click sur l'onglet Tarif dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adhérent :
		 * @throws IOException
		 */
		public void ActionCommeCaMarcheBloc2(Logger logger, WebDriver driver , String texteEtapesCles, String texteParam, /*String texteCree,*/ String texteInvite, 
				String texteCollec, String texteGere, String textePercois) throws IOException {
			try {
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du picto ' étapes '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[1]", logger);
				Thread.sleep(5000); 
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' LES ÉTAPES CLÉS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[2]", texteEtapesCles, logger); 
				Thread.sleep(3000); 
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Je paramètre mes collectes pour la rentrée sportive ou tout autre évènement '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/p", texteParam, logger); 
				Thread.sleep(3000); 
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce de l'icône ' JE CRÉE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[1]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' JE CRÉE '  ", logger, driver);
				//scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[2]", texteCree, logger);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[2]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Je crée mon évènement en quelques clics'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[1]/div[3]", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce de l'icône ' J'INVITE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[2]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' J'INVITE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[2]/div[2]", texteInvite, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' J'invite mes adhérents à y participer'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[2]/div[3]", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce de l'icône ' JE COLLECTE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[3]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' JE COLLECTE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[3]/div[2]", texteCollec, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Je collecte les paiements par Carte Bancaire sur mon porte-monnaie électronique'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[3]/div[3]", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce de l'icône ' JE GÈRE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[1]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' JE GÈRE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[1]/div[2]", texteGere, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' Je gère ma base adhérents et le niveau de complétude des inscriptions'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[1]/div[3]", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce de l'icône ' JE PERÇOIS'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[2]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' JE PERÇOIS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[2]/div[2]", textePercois, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte 'Je perçois les montants collectés par virement sur mon compte bancaire.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[2]/div[3]", logger); 
				Thread.sleep(3000);
				
				
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		/**
		 * FOnction Vérifiant le click sur l'onglet ActionSecurite dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adhérent :
		 * @throws IOException
		 */
		public void ActionSecurite(Logger logger, WebDriver driver, String texteUneSolutionEnti, String texteProtocole, String texteHeberge, String textePaiConfiance) throws IOException {
			try {
				/*log.reportLogTNRInfo("MCF - Click sur ' Sécurité ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[3]/a", logger);
				Thread.sleep(5000);  */
				
				Thread.sleep(3000);
				log.reportLogTNRInfo("MCF - Vérification de l'existance du texte ' UNE SOLUTION ENTIÈREMENT SÉCURISÉE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[1]/div[1]", texteUneSolutionEnti, logger);  
				Thread.sleep(3000);    
				
				log.reportLogTNRInfo("MCF - Vérification de l'existance de l'icône ' PROTOCOLE HTTPS '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[1]/div[2]/img", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existance du texte ' PROTOCOLE HTTPS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[1]/div[3]/div/div", texteProtocole, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existance du texte ' Sur Mon Club Facile, le protocole HTTPS garantit la confidentialité et l’intégrité des données que vous transmettez. Tous les formulaires de paiement de la plateforme comportent également le cadenas de sécurité propre au protocole HTTPS qui vous assure la fiabilité des transactions bancaires réalisées en ligne.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[1]/div[3]/div/p", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existance de l'icône ' HÉBERGEMENT DES DONNÉES '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[2]/div[2]/img", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existance du texte ' HÉBERGEMENT DES DONNÉES '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[2]/div[1]/div/div", texteHeberge, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existance du texte 'Toutes vos données personnelles (nom, prénom, e-mail, coordonnées bancaires...) sont conservées dans un environnement sécurisé, sauvegardées quotidiennement sur des serveurs en France et ne sont jamais divulguées à qui que ce soit.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[2]/div[1]/div/p", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce de l'icône ' PAIEMENT EN TOUTE CONFIANCE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[3]/div[1]/img", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte ' PAIEMENT EN TOUTE CONFIANCE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[3]/div[2]/div/div", textePaiConfiance, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existnce du texte 'Pour l’ensemble des transactions, Mon Club Facile a intégré la solution d’un prestataire agréé par la Banque de France. L’argent collecté est stocké sur un porte-monnaie électronique qui vous appartient. Vous choisissez la fréquence des virements depuis ce porte-monnaie vers votre compte en banque.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[3]/div[2]/div/p", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Click sur le texte ' Plus d'infos '  ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[3]/div[2]/div/p/a", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Fermer la pop-up qui s'ouvre au click sur texte ' Plus d'infos '  ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='creation-sucess']/div/div/div[1]/div/i", logger); 
				Thread.sleep(3000);
				
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		
		
		
		/**
		 * FOnction Vérifiant le click sur l'onglet Mentions légales dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adhérent :
		 * @throws IOException
		 */
		public void ActionMentionsLegales(Logger logger, WebDriver driver, String texteEditeur, String Tel, String Mail, String Adressemail, String NumeroIndiv, String Directeur, 
				String DirecPub, String ResponSite, String texteHebergSite, String Hebergeur, String Propriete, String Partenaire, String Respon) throws IOException {
			try {
				/*log.reportLogTNRInfo("MCF - Click sur ' Mentions légales ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[4]/a", logger);*/
				Thread.sleep(5000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' ÉDITEUR '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[1]", texteEditeur, logger);  
				Thread.sleep(3000);  
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Le site internet Mon club facile, accessible via l’URL www.monclubfacile.maif.fr(ci-après « le Site ») est édité par la société MAIF Horizon - SAS au capital de 12 422 000 € - RCS NIORT 518 016 589 - 200 avenue Salvador Allende 79000 NIORT. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[1]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Téléphone :  05 49 73 74 75'  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]/span[1]", Tel, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Mail '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]/span[2]", Mail, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' contact@monclubfacile.fr '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]/a", Adressemail, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Numéro individuel d’identification à la TVA : FR 72 518 016 589. '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]/span[3]", NumeroIndiv, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' DIRECTEUR DE LA PUBLICATION ET RESPONSABLE DU SITE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[2]", Directeur, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Directeur de publication : Pascal Demurger, Directeur Général de la MAIF '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[3]", DirecPub, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Responsable du site : Nicolas Boudinet '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[4]", ResponSite, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' HÉBERGEUR DU SITE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[3]", texteHebergSite, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Le site est hébergé par la société MAIF. '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[5]", Hebergeur, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' La Société MAIF est une société d’assurance mutuelle ... Téléphone : 05 49 73 74 75 '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[6]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' PROPRIÉTÉ INTELLECTUELLE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[4]", Propriete, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Les contenus présents sur le site  .... dans le cadre d’une utilisation personnelle. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[7]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Il est rappelé que « Mon Club Facile » est une marque déposée, propriété de la MAIF.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[8]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Toute exploitation non expressément autorisée  .... poursuites judiciaires à l’encontre de tout Utilisateur qui n’aurait pas respecté cette interdiction. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[9]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' PARTENAIRES '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[5]", Partenaire, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' L’utilisateur demeure seul responsable du respect .... liens hypertexte. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[10]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Les Services de création de Porte-monnaie .... ayant son siège social à 6 rue Claude Farrère 75016 Paris. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[11]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' RESPONSABILITÉS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[6]", Respon, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' La consultation du Site ainsi que l’utilisation des informations et des services présentés par les Partenaires ou les tiers se font sous la seule responsabilité de l’Utilisateur. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[12]", logger);
				Thread.sleep(3000);
				
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		
		/**
		 * FOnction Vérifiant le click sur l'onglet Conditions légales dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adhérent :
		 * @throws IOException
		 */
		public void ActionConditionsLegales(Logger logger, WebDriver driver, String textePreambule, String texteObject, String texteIdentifiant, String texteMaifHorizon, String texteLaPlate,
				String texteUtilisateur, String texteTiers, String texteAcceptation, String texteInscription) throws IOException {
			try {
				/*log.reportLogTNRInfo("MCF - Click sur ' Conditions générales ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[5]/a", logger);*/
				Thread.sleep(5000); 
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte '  PRÉAMBULE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[1]", textePreambule, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' La société MAIF Horizon propose un service permettant à chaque club ou association sportive qui s’inscrit (ci-après « Utilisateur ») de centraliser sur une plateforme internet la gestion quotidienne de son club (ci-après « Mon Club Facile »). '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[1]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' À partir de cette plateforme, l’Utilisateur peut bénéficier d’outils et de fonctionnalités telles que la création et la diffusion de collecte, la création d’un porte-monnaie électronique, la visualisation de l’état de la trésorerie, la création d’une base adhérents, le règlement des adhésions, leur organisation, la communication, les relances des cotisations, dans le cadre des prescriptions d’utilisation définies dans les présentes Conditions Générales d’Utilisation (ci-après, les « Services »).'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Les Services Mon Club Facile sont présentés sur le site internet Mon Club Facile www.monclubfacile.maif.fr (ci-après la « Plateforme internet ») '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[3]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte 'L'accès au service est gratuit pour les clubs ou associations sportives, selon les conditions indiquées dans les présentes Conditions Générales d’Utilisation (CGU).'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[4]", logger); 
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte '  OBJET '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[2]", texteObject, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte '  Les Utilisateurs accèdent à la Plateforme internet et bénéficient des Services Mon Club Facile, une fois inscrit, dans le respect des présentes CGU. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[5]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte '  Les Services de Mon Club Facile ont pour principal objet de fournir différentes fonctionnalités qui peuvent être utilisées ou non dans l’objectif de faciliter la gestion administrative de ses Utilisateurs. Les outils informatiques mis à sa disposition dans ce cadre leur permettent de prendre, le cas échéant, des décisions de manière autonome. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[6]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte '  La prestation de MAIF Horizon est limitée à la seule fourniture des Services Mon Club Facile sans aucune forme de conseil en matière de gestion administrative à destination des Associations Sportives. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[7]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte '  IDENTIFICATION DES PARTIES ET DES TIERS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[3]", texteIdentifiant, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte '  Maif Horizon '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h4[1]", texteMaifHorizon, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' La Plateforme internet et les Services Mon Club Facile sont exploités par MAIF Horizon. '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[8]", texteLaPlate, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' MAIF Horizon fournit un service permettant à l’Utilisateur de faciliter et automatiser les tâches liées à la gestion administrative des Associations Sportives. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[9]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Les CGU peuvent faire l’objet d’une cession totale ou partielle, à titre onéreux ou gracieux, par MAIF Horizon, sans l’accord écrit et préalable de l’Utilisateur, dès lors que le cessionnaire maintient au bénéfice de l’Utilisateur les droits et les obligations prévus aux présentes CGU. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[10]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' L'utilisateur '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h4[2]", texteUtilisateur, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Les Services Mon Club Facile ne peuvent être utilisés que par des Utilisateurs ayant la qualité de gérants d’associations sportives. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[11]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Après s’être inscrit selon les modalités visées au chapitre 4.1, l’Utilisateur peut accéder aux Services Mon Club Facile à partir de ses identifiants de connexion constitués de son adresse email et codes d’accès associés. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[12]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Les Tiers '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h4[3]", texteTiers, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Le service de gestion de cotisations en ligne pour les Associations sportives est réalisée en s’appuyant sur la solution développée par la société E-Cotiz, Société par Actions Simplifiée au capital de 7.725,40 €, inscrite au registre du commerce et des sociétés de Paris, sous le numéro 802 661 678, ayant son siège social à 6 rue Claude Farrère – 75016 PARIS (ci-après 'E-Cotiz') '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[13]", logger); 
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' La société E-Cotiz a également en charge l’hébergement des données nécessaires à la création du porte-monnaie électronique et au module de paiement mis à disposition de l’utilisateur par l’intermédiaire de son sous-traitant identifié dans les mentions légales présentes sur la Plateforme Internet. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[14]", logger); 
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' Vous pouvez consulter les CGV de E-Cotizpour le compte de Mon Club Facile ici. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[15]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' La solution sécurisée de règlement des cotisations en ligne mise à disposition par E-Cotiz est opérée par S-MONEY du Groupe BPCE (S-MONEY, société par actions simplifiée au capital de 11.037.000 euros, inscrite au Registre du Commerce et des Sociétés de Paris sous le numéro 501 586 341, dont le siège social est sis 28 villa de Lourcine, 75014 Paris (ci-après 'S-MONEY')). '  ", logger, driver);
				//scriptTech.isElementExisteByXpath(driver, xpath, logger);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[16]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' S-MONEY est agréée en France en tant qu’Etablissement de monnaie électronique, soumise au contrôle de l’Autorité de Contrôle Prudentiel et de Résolution (61 rue Taitbout, 75436 Paris Cedex 09) et inscrite sur la liste des établissements habilités à exercer leurs activités en France, telle que publiée sur le site Internet www.acpr.banque-france.fr. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[17]", logger); 
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' ACCEPTATION DES CGU ET DE LEURS MODIFICATIONS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[4]", texteAcceptation, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - Vérification de l'existence du texte ' 1 Inscription – Création D’un Compte Utilisateur '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h4[4]", texteInscription, logger);   
				Thread.sleep(5000);
				
			
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		
		
}


