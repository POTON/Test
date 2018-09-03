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
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage Prenom", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='maif-esperso-header']/div/div[2]/div/div/div[2]/div[2]/div[2]/a", texte, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Ic�ne MAIF", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='maif-esperso-header']/div/div[2]/div/div/div[1]/a/div", logger);  

			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Lien Mon Avis d'echeance", logger, driver);
			scriptTech.verifTexteById(driver, "liens-utiles-avis-echeance", "AVIS D'�CH�ANCES", logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Lien Attestations", logger, driver);
			scriptTech.verifTexteById(driver, "liens-utiles-mes-attestations", "ATTESTATIONS", logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Pr�sence Filaire Soci�taire", logger, driver);
			scriptTech.isElementExisteById(driver, "maif-esperso-header", logger);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction V�rifiant Home authentification de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteMaqDoc : exemple : MAQUETTES/DOC
	 * @param texteMaq : exemple : Maquettes
	 * @param texteDoc : exemple : Documentation
	 * @param texteCom�aMarche : exemple : Comment �a marche ?
	 * @param texteTarif : exemple : Tarif
	 * @param texteInscription : exemple : Inscription
	 * @param texteConnexion : exemple : Connexion
	 * @throws IOException
	 */
	
	public void HeaderMcf(Logger logger, WebDriver driver, /*String texteMaqDoc,*/ String texteMaq, String texteDoc, String texteCom�aMarche, 
			String texteTarif, String texteInscription, String texteConnexion) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage de l'ic�ne Maif", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "/html/body/header/nav/div[1]/div/div[2]/a/img", logger);
			
			//log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'Maquettes/Doc'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteMaqDoc, logger);
			//scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[1]/a", texteMaqDoc, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Click sur le texte Maquettes/Doc", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='navigation']/ul/li[1]/a", logger); 
			//*[@id="navigation"]/ul/li[1]/a
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte ' Maquettes' au Click sur le texte Maquettes/Doc", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteMaqDoc, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[1]/ul/li[1]/a", texteMaq, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte ' Documentations' au Click sur le texte Maquettes/Doc", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteDoc, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[1]/ul/li[2]/a", texteDoc, logger); 
			 
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'Comment �a Marche'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteCom�aMarche, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[2]/button", texteCom�aMarche, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'Tarif'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteTarif, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[3]/button", texteTarif, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'Inscription'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteInscription, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[4]/button", texteInscription, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'Connexion'", logger, driver);
			//scriptTech.verifTexteById(driver, "navigation", texteConnexion, logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='navigation']/ul/li[5]/button", texteConnexion, logger);	 
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction V�rifiant du Menu 1 : SIMPLIFIEZ LA GESTION ADMINISTRATIVE DE VOTRE CLUB SPORTIF .....
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
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage de l'ic�ne et du texte 'MON CLUB FACILE'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[1]/div/div/div/div[1]/img", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'SIMPLIFIEZ LA GESTION ADMINISTRATIVE DE VOTRE CLUB SPORTIF' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[1]/div/div/div/div[1]/h1[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'Inscription' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[1]/div/div/div/div[2]/button", texteInscription, logger);
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction V�rifiant du Menu 2 : G�rez facilement ... en ligne ; proposez ... esp�ces ;  et Facilitez ....communaut�. 
	 * 
	 * @param logger
	 * @param driver
	 * @param texteGerer : exemple : G�rez facilement vos inscriptions en ligne
	 * @param texteProposez : exemple :Proposez le paiement par CB � vos membres, mais aussi ch�que ou esp�ces. 
	 * @param texteFacilitez : exemple : Facilitez la communication avec votre ca=ommunaut�.
	 * @throws IOException
	 */
	
	public void Menu2 (Logger logger, WebDriver driver/*,String texteGerer, String texteProposez, String texteFacilitez*/) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du picto 'G�rez facilement ... en lignes'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[1]/div/span/div[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'G�rez facilement vos inscriptions en lignes'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[1]/div/span/h2", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification de l'Affichage du picto 'Proposez le paiement ... ou esp�ces'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[2]/div/span/div[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'Proposez le paiement par CB � vos membres, mais aussi ch�que ou esp�ces'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[2]/div/span/h2", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du picto 'Facilitez ... votre communaut�'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[3]/div/span/div[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification Affichage du texte 'Facilitez la communication avec votre communaut�'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[2]/div/div/div[3]/div/span/h2", logger);
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction V�rifiant du Menu 3 : Un outil simple, �volutif et s�curis�.  
	 * 
	 * @param logger
	 * @param driver
	 * @param texteMonClubFacile : exemple : MON CLUB FACILE
	 * @param texteOutilSimple :  exemple : UN OUTIL SIMPLE, �VOLUTIF ET S�CURIS�
	 * @param texteBase : exemple : Une base adh�rents fiable et constitu� automatiquement.
	 * @param texteFormulaire : exemple : Un formulaire d�inscription personnalisable.
	 * @param texteCommunication : exemple : Une communication fluidifi�e : mailing group�, relance...
	 * @param texteUneTresorerie : exemple : Une tr�sorerie imm�diate gr�ce au paiement en ligne.
	 * @param texteUnTableau : exemple : Un tableau de bord personnalisable pour un pilotage opimis�.
	 * @param texteVoirVideo : exemple : VOIR LA VID�O
	 * @param texteLesAvantages : exemple : + LES AVANTAGES
	 * @throws IOException
	 */ 
	
	public void Menu3 (Logger logger, WebDriver driver,String texteMonClubFacile, String texteOutilSimple,/* String texteBase, String texteFormulaire, String texteCommunication, String texteUneTresorerie, 
			String texteUnTableau,*/ String texteVoirVideo, String texteLesAvantages ) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' MON CLUB FACILE'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[3]/div/h3", texteMonClubFacile, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' UN OUTIL SIMPLE, �VOLUTIF ET S�CURIS�'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[3]/div/h4", texteOutilSimple, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' Une base adh�rents fiable et constitu� automatiquement.'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[1]/div[2]/div[2]/p", logger);
			Thread.sleep(2000);
			 
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' Un formulaire d�inscription personnalisable.'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[2]/div[1]/div[2]/p", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' Une communication fluidifi�e : mailing group�, relance...'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[1]/div[3]/div[2]/p", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' Une tr�sorerie imm�diate gr�ce au paiement en ligne.'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[2]/div[2]/div[2]/p", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' Un tableau de bord personnalisable pour un pilotage opimis�.'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[4]/div[2]/div[3]/div[2]/p", logger);
			Thread.sleep(3000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' VOIR LA VID�O'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='advantages-video']/div/section/div/button[1]", texteVoirVideo , logger);
			Thread.sleep(3000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Click sur le texte ' VOIR LA VID�O'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='advantages-video']/div/section/div/button[1]", logger); 
			Thread.sleep(5000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Fermeture de la pr�sentation de vid�o '", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='VideoModal']/div/div/div[1]/div/i", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du texte ' LES AVANTAGES '", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='advantages-video']/div/section/div/button[2]", texteLesAvantages , logger);
			scriptTech.isElementExisteById(driver, "advantages-video", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Click sur le texte '  LES AVANTAGES '", logger, driver);
			scriptTech.clickById(driver, "advantages-video", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - Fermeture de la page Avanatges apr�s le Click sur le texte '  LES AVANTAGES '", logger, driver);
			scriptTech.clickByXpath(driver, "/html/body/header/nav/div[1]/div/div[2]/a/img", logger); 
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	
	
	/**
	 * FOnction V�rifiant du Menu 4 : LA MAIF ET LE SPORT  
	 * 
	 * @param logger
	 * @param driver
	 * @param texteMaifSport : exemple : LA MAIF ET LE SPORT
	 * @param texteMaifPremierAssureur :  exemple : La MAIF, premier assureur des associations, est depuis longtemps investie dans le domaine sportif. Le sport , g�n�rateur de confiance, v�hicule des valeurs proches de celles li�es � l��ducation. Notre priorit� : �tre � l��coute des acteurs du monde sportif pour fournir des solutions adapt�es aux besoins.
	 * @param texteNotreVolonte : exemple : NOTRE VOLONT�
	 * @param texteVousFaire : exemple : Vous faire gagner du temps sur les t�ches administratives et quotidiennes de votre club
	 * @param texteVotreBebefice : exemple : VOTRE B�N�FICE
	 * @param texteConsacrer : exemple : Consacrer plus de temps � vos adh�rents et favoriser le d�veloppement de votre structure
	 * @throws IOException
	 */ 
	
	public void Menu4 (Logger logger, WebDriver driver,String texteMaifSport, String texteMaifPremierAssureur, String texteNotreVolonte, String texteVousFaire, String texteVotreBebefice, String texteConsacrer) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte ' LA MAIF ET LE SPORT'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/h3", texteMaifSport, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte ' La MAIF, premier assureur des associations ... adapt�es aux besoins. '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/p", texteMaifPremierAssureur, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage de l'ic�ne ' notre volont�'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[1]/div/div", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte ' NOTRE VOLONT� '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[1]/div/h4", texteNotreVolonte, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte ' Vous faire gagner du temps sur les t�ches administratives et quotidiennes de votre club '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[1]/div/p", texteVousFaire, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage de l'ic�ne ' votre b�n�fice'", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[2]/div/div", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte ' VOTRE B�N�FICE '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[2]/div/h4", texteVotreBebefice, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Consacrer plus de temps � vos adh�rents et favoriser le d�veloppement de votre structure '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/div[2]/div/div/div/div[2]/div/p", texteConsacrer, logger);
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction V�rifiant du Menu 5 : Les membres 
	 * 
	 * @param logger
	 * @param driver
	 * @param texteNomAges : exemple : DAVID, 49 ANS
	 * @param textePoste :  exemple : PR�SIDENT LES 12-14 NIORT
	 * @param texteslogan : exemple : � La gestion du club devient un jeu d�enfant. �
	 * @throws IOException
	 */ 
	
	public void Menu5 (Logger logger, WebDriver driver,String texteNomAges, String textePoste, String texteslogan, String numdiv) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage de l'image Membre ", logger, driver);  
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/div/img", logger);
			Thread.sleep(2000);
			//*[@id="home"]/section[5]/div/div/div[1]/div/img
			//*[@id="home"]/section[5]/div/div/div[2]/div/img
			//*[@id="home"]/section[5]/div/div/div[3]/div/img
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte 'Nom et �ges du membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[1]", texteNomAges, logger); 
			Thread.sleep(2000);
			//*[@id="home"]/section[5]/div/div/div[1]/span[1]
			//*[@id="home"]/section[5]/div/div/div[2]/span[1]
			//*[@id="home"]/section[5]/div/div/div[3]/span[1] 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte ' Poste/Fonction du membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[2]", textePoste, logger);
			Thread.sleep(2000);
			//*[@id="home"]/section[5]/div/div/div[1]/span[2]
			//*[@id="home"]/section[5]/div/div/div[2]/span[2]
			//*[@id="home"]/section[5]/div/div/div[3]/span[2]
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du 'texte membre ' ", logger, driver);
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
	 * FOnction V�rifiant du Menu 5 : Les membres 
	 * 
	 * @param logger
	 * @param driver
	 * @param texteNomAges : exemple : DAVID, 49 ANS
	 * @param textePoste :  exemple : PR�SIDENT LES 12-14 NIORT
	 * @param texteslogan : exemple : � La gestion du club devient un jeu d�enfant. �
	 * @throws IOException
	 */  
	
	public void Menu5_Suite(Logger logger, WebDriver driver,String texteNomAges, String textePoste, String numdiv) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage de l'image Membre ", logger, driver);  
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/div/img", logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte 'Nom et �ges du membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[1]", texteNomAges, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du texte ' Poste/Fonction du membre ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='home']/section[5]/div/div/div["+numdiv+"]/span[2]", textePoste, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification l'Affichage du 'texte David : � La gestion du club devient un jeu d�enfant. � ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='home']/section[5]/div/div/div[1]/span[3]", logger); 
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	
	
	/**
	 * FOnction V�rifiant du Footer : Footer mon club facile.  
	 * 
	 * @param logger
	 * @param driver
	 * @param texteComme�aMarche : exemple : Comment �a marche ?
	 * @param texteAssistance :  exemple : Assistance
	 * @param texteTarif : exemple : Tarif
	 * @param texteSecurite : exemple : S�curit�
	 * @param texteQuiSommesNous : exemple : Qui sommes nous?
	 * @param texteAvantages : exemple : Avantages
	 * @param texteConditionsGenUtilisation : exemple : Conditions g�n�rales d'utilisation
	 * @param texteMentionsLegales : exemple : Mentions l�gales
	 * @throws IOException
	 */  
	
	public void Footer(Logger logger, WebDriver driver,String texteComme�aMarche, String texteAssistance, String texteTarif, String texteSecurite, String texteQuiSommesNous, String texteAvantages, 
			String texteConditionsGenUtilisation, String texteMentionsLegales) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage de l'ic�ne Maif", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='footer']/footer/div/div/div[1]/div/img", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Comment �a marche ? '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[1]", texteComme�aMarche, logger);
			Thread.sleep(2000);  
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Assistance '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[2]", texteAssistance, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Tarif '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[3]", texteTarif, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' S�curit� '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[4]", texteSecurite, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Qui sommes nous ? '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[1]", texteQuiSommesNous, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Avantages '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[2]", texteAvantages, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Conditions g�n�rales d'utilisation '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[3]", texteConditionsGenUtilisation, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Mentions l�gales '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[4]", texteMentionsLegales, logger);
			Thread.sleep(2000);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction V�rifiant du Footer : Footer mon club facile.  
	 * 
	 * @param logger
	 * @param driver
	 * @param texteComme�aMarche : exemple : Comment �a marche ?
	 * @param texteAssistance :  exemple : Assistance
	 * @param texteTarif : exemple : Tarif
	 * @param texteSecurite : exemple : S�curit�
	 * @param texteQuiSommesNous : exemple : Qui sommes nous?
	 * @param texteAvantages : exemple : Avantages
	 * @param texteConditionsGenUtilisation : exemple : Conditions g�n�rales d'utilisation
	 * @param texteMentionsLegales : exemple : Mentions l�gales
	 * @throws IOException
	 */  
	// Je me permets d'ajouter Footer1 suite � l'�change avec le dev Baghdad, la maquette a deux footer , ie assistance et avantages sont intervertis selon les pages. 
	public void Footer1(Logger logger, WebDriver driver,String texteComme�aMarche, String texteAvantages , String texteTarif, String texteSecurite, String texteQuiSommesNous, String texteAssistance, 
			String texteConditionsGenUtilisation, String texteMentionsLegales) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage de l'ic�ne Maif", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='footer']/footer/div/div/div[1]/div/img", logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Comment �a marche ? '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[1]", texteComme�aMarche, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Avantages '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[2]", texteAvantages, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Tarif '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[3]", texteTarif, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' S�curit� '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[2]/a[4]", texteSecurite, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Qui sommes nous ? '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[1]", texteQuiSommesNous, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Assistance '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[2]", texteAssistance, logger);
			//*[@id="footer"]/footer/div/div/div[2]/a[2]
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Conditions g�n�rales d'utilisation '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[3]", texteConditionsGenUtilisation, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - - V�rification l'Affichage du lien ' Mentions l�gales '", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='footer']/footer/div/div/div[3]/a[4]", texteMentionsLegales, logger);
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	/**
	 * FOnction V�rifiant la page de clique sur Inscription de mon club facile
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
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Inscription'", logger, driver);
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
	 * FOnction V�rifiant la page de clique sur Connexion de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteConnexion : exemple : Inscription
	 * @throws IOException
	 */
	
	public void OuvrirPageConnexion(Logger logger, WebDriver driver,String texteConnexion) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Connexion'", logger, driver);
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
	 * FOnction V�rifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteInscriptionAmonClub : exemple : Inscription
	 * @param texteServiceAccessible : exemple : Mon Club Facile est un service accessible gratuitement aux associations et clubs sportifs.
	 * @param texteVotreClub : exemple : Votre club est-il soci�taire MAIF ?
	 * @param texteOui : exemple : OUI
	 * @param texteNon : exemple : NON
	 * @throws IOException
	 */
	
	public void ChoixOuiNon(Logger logger, WebDriver driver,String texteInscriptionAmonClub, String texteServiceAccessible, String texteVotreClub, 
			String texteOui, String texteNon) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'INSCRIPTION � MON CLUB FACILE'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='formulaires']/section/div/div/div/div/h1", texteInscriptionAmonClub, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Mon Club Facile est un service accessible gratuitement aux associations et clubs sportifs.'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[1]/div/h2", texteServiceAccessible, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Votre club est-il soci�taire MAIF ?'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/label", texteVotreClub, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[2]/label", texteNon, logger); 
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	
	
	
	/**
	 * FOnction V�rifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteClub : exemple : Votre club est-il soci�taire MAIF ?
	 * @param texteChoixOui : exemple : OUI
	 * @param texteChoixNon : exemple : NON
	 * @throws IOException
	 */
	
	public void ChoisirNon(Logger logger, WebDriver driver,String texteClub, String texteChoixOui, String texteChoixNon) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Votre club est-il soci�taire MAIF ?'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/label", texteClub, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[1]/label", texteChoixOui, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'NON'", logger, driver);
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
	 * FOnction V�rifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteVotreClub : exemple : Votre club est-il soci�taire MAIF ?
	 * @param texteOui : exemple : OUI
	 * @param texteNon : exemple : NON
	 * @throws IOException
	 */
	
	public void ChoixOui(Logger logger, WebDriver driver,String texteVotreClub, String texteOui, String texteNon) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Votre club est-il soci�taire MAIF ?'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/label", texteVotreClub, logger); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'NON'", logger, driver);
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
	 * FOnction V�rifiant la page de clique sur Inscription de mon club facile
	 * 
	 * @param logger
	 * @param driver
	 * @param texteCreation : exemple : Inscription
	 * @throws IOException
	 */
	
	public void TexteCreation(Logger logger, WebDriver driver,String texteCreation) throws IOException, InterruptedException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Votre club est-il soci�taire MAIF ?'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]/fieldset/div/label", texteCreation, logger); 
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
	
	
	

	/**
	 * FOnction V�rifiant la page d'inscription , niveau 1 = identit� club/asso
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteIdentite : exemple : IDENTIT� DU CLUB/ASSOCIATION 
	 * @param texteNomClubAsso: exemple : Nom du club/association *
	 * @param texteTelephone : T�l�phone *
	 * @param texteAdresse : exemple : Adresse du club/association *
	 * @param texteEtesVous : exemple : �tes-vous affili� � une f�d�ration ou groupement national ? *
	 * @param texteOui :  exemple : OUI
	 * @param texteNon : exemple :  NON
	 * @param textePrecision : exemple :  Pr�cisez laquelle *
	 * @param texteActiviteSportPratiq : exemple : Activit� sportive pratiqu�e *
	 * @throws IOException
	 */
	public void IdenditeCommune(Logger logger, WebDriver driver ,String texteIdentite, String texteNomClubAsso, String texteTelephone, String texteAdresse, 
			String texteEtesVous, String texteOui, String texteNon, String texteActiviteSportPratiq) throws IOException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'IDENTIT� DU CLUB/ASSOCIATION'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]", texteIdentite, logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Nom du club/association *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/label", texteNomClubAsso, logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'ALATA Ibrahima'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/div/input", "ALATA Ibrahima", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'T�l�phone *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/label", texteTelephone, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du numero de tel'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/div/input", "06 18 65 77 23", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Adresse du club/association *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/label", texteAdresse, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage de l'adresse du club/asso'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/div/input", "12 rue des plantes", logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Code postal/Ville *'", logger, driver);
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du code postale du club/asso : 79000 - Niort'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", "79000", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-2--value']/div/input", Keys.ENTER, logger); 
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", " 79000 - Niort", logger);
			Thread.sleep(4000);
			//scriptTech.sendKeysByXpath(driver, "input.Select-input", Keys.RETURN, logger); 
			//scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", Keys.ENTER, logger); 
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", "79000", logger);
			Thread.sleep(2000); 
			 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte '�tes-vous affili� � une f�d�ration ou groupement national ? *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/label", texteEtesVous, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", texteOui, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Cliquez sur le texte texte 'NON'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", logger); 
			Thread.sleep(2000);
			//log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Pr�cisez laquelle *'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/label", textePrecision, logger);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Activit� sportive pratiqu�e *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/div/label", texteActiviteSportPratiq, logger);
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du type d'activit� sportive'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-3--value']/div[2]/input", " sport automobile", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-3--value']/div/input", Keys.ENTER, logger); 
			Thread.sleep(2000);
			//log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Ajouter Une Activit�'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[7]/div[2]/a", texteAjouterUneActivite, logger);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	

	
	

	/**
	 * FOnction V�rifiant la page d'inscription , niveau 1 = identit� club/asso Pr�-rempli
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteIdentite : exemple : IDENTIT� DU CLUB/ASSOCIATION 
	 * @param texteNomClubAsso: exemple : Nom du club/association *
	 * @param texteTelephone : T�l�phone *
	 * @param texteAdresse : exemple : Adresse du club/association *
	 * @param texteCodePostal : exemple : Code postal/Ville *
	 * @throws IOException
	 */
	public void IdenditeCommuneSocPreRempli(Logger logger, WebDriver driver ,String texteIdentite,  String texteNomClubAsso, String texteTelephone,
			String texteAdresse, String texteCodePostal) throws IOException {
		try {
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'IDENTIT� DU CLUB/ASSOCIATION'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[2]", texteIdentite, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Nom du club/association *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/label", texteNomClubAsso, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'SAPFR'", logger, driver); 
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/div/input", texte1, logger); 
			scriptTech.isElementExisteByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[1]/div/input", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'T�l�phone *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/label", texteTelephone, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du numero de tel : 03 83 28 80 28'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/div/input", texte2, logger); 
			scriptTech.isElementExisteByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[2]/div/input", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Adresse du club/association *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/label", texteAdresse, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage de l'adresse du club/asso :  11 RUE JEAN JAURES'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/div/input", texte3, logger); 
			scriptTech.isElementExisteByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/div/input", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'Code postal/Ville *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[4]/label", texteCodePostal, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du code postale du club/asso : ' 54320 - Max�ville '", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='react-select-2--value']/div/input", logger);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='react-select-2--value']/div[1]", logger); 
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value-item']", "54320 - Max�ville", logger);
			Thread.sleep(2000);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
			
			//////////////////
	/**
	 * FOnction V�rifiant la page d'inscription , niveau 1 = identit� club/asso Reste � remplir au click sur NON � partir de la question �tes-vous affili� � une f�d�ration ou groupement national ? *
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteEtesVous : exemple : �tes-vous affili� � une f�d�ration ou groupement national ? *
	 * @param texteOui :  exemple : OUI
	 * @param texteNon : exemple :  NON
	 * @param texteActiviteSportPratiq : exemple : Activit� sportive pratiqu�e *
	 * @throws IOException
	 */
	public void IdenditeCommuneSocNonRempliClickNon(Logger logger, WebDriver driver , String texteEtesVous, String texteOui, String texteNon/*, String texteActiviteSportPratiq*/) throws IOException {
		try {	
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte '�tes-vous affili� � une f�d�ration ou groupement national ? *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/label", texteEtesVous, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'NON'", logger, driver); 
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo("MCF - Cliquez sur le texte texte 'NON'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", logger); 
			Thread.sleep(2000);
			
		/*	log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'Activit� sportive pratiqu�e *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/div/label", texteActiviteSportPratiq, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du type d'activit� sportive'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-3--value']/div[1]", "sport automobile", logger);
			//*[@id="react-select-3--value"]/div[1] */
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction V�rifiant la page d'inscription , niveau 1 = identit� club/asso Reste � remplir au click sur OUI � partir de la question �tes-vous affili� � une f�d�ration ou groupement national ? *
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteEtesVous : exemple : �tes-vous affili� � une f�d�ration ou groupement national ? *
	 * @param texteOui :  exemple : OUI
	 * @param texteNon : exemple :  NON
	 * @param textePrecision : exemple :  Pr�cisez laquelle *
	 * @param texteActiviteSportPratiq : exemple : Activit� sportive pratiqu�e *
	 * @throws IOException
	 */
	public void IdenditeCommuneSocNonRempliClickOui(Logger logger, WebDriver driver , String texteEtesVous, String texteOui, String texteNon, String textePrecision, String texteActiviteSportPratiq) throws IOException {
		try {	
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte '�tes-vous affili� � une f�d�ration ou groupement national ? *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/label", texteEtesVous, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo("MCF - Cliquez sur le texte texte 'OUI'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'Pr�cisez laquelle *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[6]/label", textePrecision, logger);
			Thread.sleep(4000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage de la r�ponse du texte 'Pr�cisez laquelle *'", logger, driver);
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-5--value']/div[1]", "FF de ski", logger); 
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-4--value']/div/input", "ski", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-4--value']/div/input", Keys.ENTER, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'Activit� sportive pratiqu�e *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[7]/div/label", texteActiviteSportPratiq, logger);
			Thread.sleep(4000);
			
			//log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte : ' Aviron '", logger, driver);
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-3--value']/div[1]", "Aviron", logger);
			//*[@id="react-select-3--value"]/div[1]
			log.reportLogTNRInfo("- MCF - Saisie du type d'activit� sportive'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-3--value']/div/input", "Aviron", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-3--value']/div/input", Keys.ENTER, logger);
			Thread.sleep(2000); 
			
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}

	
	/**
	 * FOnction V�rifiant la page d'inscription , niveau 1 = identit� club/asso , click sur OUI � partir de la question '�tes-vous affili� � une f�d�ration ou groupement national ? *'
	 * 
	 * @param logger
	 * @param texteEtesVous : exemple : �tes-vous affili� � une f�d�ration ou groupement national ? *
	 * @param texteOui :  exemple : OUI
	 * @param texteNon : exemple :  NON
	 * @param textePrecision : exemple :  Pr�cisez laquelle *
	 * @throws IOException
	 */
	public void IdenditeCommuneSocAffilieClickOui(Logger logger, WebDriver driver, String texteEtesVous, String texteOui, String texteNon/*, String textePrecision*/) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte '�tes-vous affili� � une f�d�ration ou groupement national ? *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/label", texteEtesVous, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'OUI'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", texteOui, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo("MCF - Cliquez sur le texte texte 'OUI'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[1]/label", logger); 
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'Pr�cisez laquelle *'", logger, driver);
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
			
			
			log.reportLogTNRInfo("- MCF - V�rification Affichage du texte 'NON'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", texteNon, logger);
			
			log.reportLogTNRInfo(" MCF - Cliquez sur le texte texte 'NON'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[5]/div/div/div[2]/label", logger); 
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	/**
	 * FOnction V�rifiant la page d'inscription , niveau 1 = identit� club/asso
	 * 
	 * @param logger
	 * @param driver2
	 * @param texteCompte : exemple : FINALISER VOTRE COMPTE
	 * @param texteParametrez : exemple : Param�trez les informations qui vous permettront de vous connecter � votre compte Mon Club Facile.
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
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage du texte 'FINALISER VOTRE COMPTE'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[4]", texteCompte, logger);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='subscription_form']/div[4]", logger);
			
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'Param�trez les informations qui vous permettront de vous connecter � votre compte Mon Club Facile.'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[1]", texteParametrez, logger);  
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'Email *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[2]/label", texteEmail, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'adresse mail'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[2]/div/input", mail, logger);
			
			
			  
			log.reportLogTNRInfo(" MCF - V�rification Affichage du texte 'Mot de passe *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[3]/label", texteMotDePasse, logger); 
			
			log.reportLogTNRInfo(" MCF - V�rification la saisie  du mot de passe'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='inputPassword']", "Kolima24@", logger); 
				
			log.reportLogTNRInfo(" MCF - V�rification Affichage du texte 'Confirmer votre mot de passe *'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[4]/label", texteConfirmerMotDePasse, logger); 
			
			log.reportLogTNRInfo(" MCF - V�rification la confirmation de la saisie  du mot de passe'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='inputPasswordConfirm']", "Kolima24@", logger); 
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction V�rifiant la page d'inscription , niveau 1 = identit� club/asso
	 * 
	 * @param logger
	 * @param driver
	 * @param texteCoche : exemple : En cochant cette case, je reconnais avoir pris connaissance des Conditions G�n�rales d'Utilisation du service � Mon Club Facile � et je les accepte.
	 * @param texteValider :  exemple : VALIDEZ
	 * @throws IOException
	 */
	public void CguValid(Logger logger, WebDriver driver , String texteCoche, String texteValider) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'Conditions g�n�rales'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[5]/div/label", texteCoche, logger);
			
			log.reportLogTNRInfo("MCF - Click sur le texte 'Conditions g�n�rales'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[5]/fieldset/div[5]/div/label", logger); 
	
			log.reportLogTNRInfo(" MCF - V�rification Affichage du texte 'Valider'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='subscription_form']/div[5]/div[1]/button", texteValider, logger); 
			
			log.reportLogTNRInfo("MCF - Click sur le texte 'VALIDER'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='subscription_form']/div[5]/div[1]/button", logger); 
			Thread.sleep(3000);
			
			log.reportLogTNRInfo("MCF - Fermeture du Popup Apr�s le Click sur le texte 'VALIDER'", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='creation-sucess']/div/div/div[1]/div/i", logger); 
			Thread.sleep(3000);
			
			
	
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	
	/**
	 * FOnction V�rifiant le pr�nom du soc sur la partie MON COMPTE.
	 * 
	 * @param logger
	 * @param driver
	 * @param textePrenom : exemple : alata
	 * @param texteActivit� :  exemple : Activit�(s) :
	 * @param texteTypeActivite : exemple : rallye automobile,
	 * @throws IOException
	 */
	public void PrenomNom(Logger logger, WebDriver driver , String textePrenom/*, String texteActivit�*/) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - V�rification Affichage du pr�nom ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div[1]", textePrenom, logger);
			
		//	log.reportLogTNRInfo("MCF - V�rification Affichage du texte : 'Activit�(s) :'", logger, driver);
		//	scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div[3]/div", texteActivit�, logger);

			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	/**
	 * FOnction V�rifiant le Profil du soc sur la partie MON COMPTE.
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
			log.reportLogTNRInfo("MCF - V�rification Affichage du Profil ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div[1]/h2", texteProfil, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte : 'Nom du club/association : alata'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[1]/span", texteNomDuClub, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[1]/span", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' Nom de la f�d�ration: FF de jeu de paume'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[2]/span", texteNomFederation, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[2]/span", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'Activit�(s) : rallye automobile,'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[3]/span", texteActivite, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[1]/li[3]/span", logger);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant le contact du soc sur la partie MON COMPTE.
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
			log.reportLogTNRInfo("MCF - V�rification Affichage du Contact ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div[2]/h2", texteContact, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte : 'Adresse : rue des plantes'", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[1]/span", texteAdresse, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[1]/span", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' Code postal/Ville : 79000 Niort'  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[2]/span", texteCodePostalVille, logger);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[2]/span", logger);
			
			log.reportLogTNRInfo(" MCF - V�rification Affichage du texte 'Adresse e-mail : ibrahima.alata@gmail.com'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[3]/span", texteMail, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[3]/span", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'T�l�phone : 06 18 65 77 21'  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[2]/li[4]/span", texteTel, logger);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant l'id de connexion du soc sur la partie MON COMPTE.
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
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte Identifiant de connexion ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div[3]/h2", texteIdConnexion, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage de : Email : ibrahima.alata@gmail.com'", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[3]/li[1]/span[1]", texteEmail, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' Mot de passe :'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[3]/li[2]/span[1]", texteMotDePasse, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/ul[3]/li[2]/span[1]", logger);
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant l'id de connexion du soc sur la partie MON COMPTE.
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
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du logo Carte Bancaire ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte MODULE DE PAIEMENT EN LIGNE ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div/div[2]", texteModuleDePiaementEnLigne, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte : 'Afin de collecter en ligne les cotisations de vos adh�rents *, activez le module de paiement par carte bancaire.''", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div/p", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte 'En savoir plus'  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div[2]/div/div[2]/div/div/div/div[3]/button", texteEnSavoirPlus, logger);
			 
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant l'id de connexion du soc sur la partie MON COMPTE.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteDeconnexion
	 * @throws IOException
	 */
	public void SeDeconnecter(Logger logger, WebDriver driver , String texteDeconnexion) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur le menu d�pliant la page du 'Profil du club' et de la 'D�connexion' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='top-right-menu']/ul/li/a/span[2]", logger); 
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte D�connexion ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='top-right-menu']/ul/li/ul/li[3]/a", texteDeconnexion, logger);
			
			log.reportLogTNRInfo("MCF - Click sur le texte D�connexion ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='top-right-menu']/ul/li/ul/li[3]/a", logger); 
			 
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant le pr�nom Adh�rent dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param textePrenomAdherent : exemple : alata
	 * @throws IOException
	 */
	public void PrenomAdherent(Logger logger, WebDriver driver , String textePrenomAdherent) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - V�rification Affichage du pr�nom ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[1]", textePrenomAdherent, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant du texte Adh�rent dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteAdherent : exemple : ADHERENT
	 * @throws IOException
	 */
	public void Adherent(Logger logger, WebDriver driver , String texteAdherent) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'ic�ne et le nombre d'adh�rents ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[1]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ADHERENT ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[1]/div/div[2]", texteAdherent, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant du texte Command�s dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteCommandes : exemple : COMMAND�S
	 * @throws IOException
	 */
	public void Commandes(Logger logger, WebDriver driver , String texteCommandes) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'ic�ne et la quantit� command�e ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[2]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte COMMAND�S ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[2]/div/div[2]", texteCommandes, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant du texte Pay�s dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param textePayes : exemple : PAY�S
	 * @throws IOException
	 */
	public void Payes(Logger logger, WebDriver driver , String textePayes) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'ic�ne et la la somme pay�e ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[3]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte PAY�S ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[3]/div/div[2]", textePayes, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant du texte 'En attente de r�glement' dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteReglement : exemple : EN ATTENTE DE R�GLEMENT
	 * @param texteVoirCollectes : exemple : VOIR LES COLLECTES
	 * @throws IOException
	 */
	public void Reglement(Logger logger, WebDriver driver , String texteReglement, String texteVoirCollectes) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' EN ATTENTE DE R�GLEMENT' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[1]/div/div[1]", texteReglement, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'ic�ne et la la somme en attente de r�glement ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[1]/div/div[2]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' EN ATTENTE DE R�GLEMENT' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[1]/div/div[2]/div/div[2]/button", texteVoirCollectes, logger);
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant du texte 'Paiement en ligne' dans le tableau de bord de mon club facile.
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
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' PAIEMENT EN LIGNE' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[2]/div/div[1]", textePaiemLigne, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' ACTIVEZ LE MODULE DE PAIEMENT PAR CARTE BANCAIRE ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[2]/div/div[2]/div/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' EN SAVOIR+ ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[2]/div/div[2]/div/div[2]/button", texteEnSavoir, logger); 
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant du texte 'Derniers inscrits' dans le tableau de bord de mon club facile.
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
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' DERNIERS INSCRITS ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[4]/div/div/div[1]", texteDerniersInscrits, logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du picto derniers inscrits ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[4]/div/div/div[2]/div/ul/div", logger);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' IBRAHIM romaric et ALATA ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[4]/div/div/div[2]/div/ul/li", logger);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
	
	
	/**
	 * FOnction V�rifiant le click sur texte Adh�rent dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
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
	 * FOnction V�rifiant le click sur texte Commandes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
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
	 * FOnction V�rifiant le click sur texte Pay�s dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
	 * @throws IOException
	 */
	public void ActionClickPay(Logger logger, WebDriver driver ) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur Pay�s ", logger, driver);
			//scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[2]/div[3]/div/div[2]", logger);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/a/div/div[1]", logger); 
		
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}

	
	
	/**
	 * FOnction V�rifiant le click sur voir les collectes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
	 * @throws IOException
	 */
	public void ActionClickReglmtVoirCollectes(Logger logger, WebDriver driver) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur Voir les collectes dans la partie En attente de R�glement  ", logger, driver);
			//scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div[1]/div/div[2]/div/div[2]/button", logger); 
			scriptTech.clickById(driver, "page-wrapper", logger); 
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction V�rifiant le click sur voir les collectes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
	 * @throws IOException
	 */
	public void ActionClickMesCollectes(Logger logger, WebDriver driver ,/*String texteCreerCollect,*/ String textePub, String texteBrou, String texteTermine, String texteCorb) throws IOException {
		try {
			/*log.reportLogTNRInfo("MCF - Click sur ' Mes collectes ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[2]/a/span", logger); 
			Thread.sleep(5000);*/
			Thread.sleep(5000);
			
			//log.reportLogTNRInfo("MCF - V�rification de l'existnce du menu 'CREER UNE COLLECTE'  ", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[2]/a/button", texteCreerCollect, logger);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[2]/a/button", logger);
			//Thread.sleep(3000); 
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' PUBLI�ES '  ", logger, driver);
            scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[1]", textePub, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' BROUILLONS '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[2]", texteBrou, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' TERMIN�ES '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[3]", texteTermine, logger);  
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' CORBEILLES '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[4]", texteCorb, logger); 
			Thread.sleep(2000);
			
			
			/*log.reportLogTNRInfo("MCF - Click sur ' Mes collectes ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[2]/a/span", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du menu ' CR�ER UNE COLLECTE '  ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[2]/a/button", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' PUBLI�ES '  ", logger, driver);
            scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[1]", textePub, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' BROUILLONS '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[2]", texteBrou, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' TERMIN�ES '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[3]", texteTermine, logger);  
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' CORBEILLES '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[4]", texteCorb, logger); 
			Thread.sleep(2000);*/
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}	
			
	
	/**
	 * FOnction V�rifiant le click sur voir les collectes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
	 * @throws IOException
	 */
	public void ActionClickPubli(Logger logger, WebDriver driver ,String texteAlata, String texteDateAdhesion, String texteBlocAdherent, String texteBlocComm, String texteBlocP, String texteVoirMaPag) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur ' Publi�es ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[1]/div/div[3]/div/div/a[1]", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' ALATA '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[1]/div[1]", texteAlata, logger);
			Thread.sleep(2000); 
			
			log.reportLogTNRInfo("MCF - Click sur ' Nom = ALATA	 ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[1]/div[1]", logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' ADH�SION - fin le 06/08/2022'  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[2]", texteDateAdhesion, logger);
			Thread.sleep(2000); 
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce ' ADH�RENT ' dans le premier bloc ", logger, driver);
            scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[1]/div[2]/div[2]", texteBlocAdherent, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("V�rification de l'existnce ' COMAND� ' dans le second bloc ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[2]/div[2]/div[2]", texteBlocComm, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' PAY�S ' dans le trois�me bloc ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[3]/div[2]/div[2]", texteBlocP, logger);  
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existnce du bloc ' VOIR MA PAGE '  ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[5]/a", texteVoirMaPag, logger); 
			Thread.sleep(2000);
			
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}	
			
	
	
	
	
	
	/**
	 * FOnction V�rifiant le click sur l'onglet Assistance de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
	 * @throws IOException
	 */
	public void ActionClickAssistance(Logger logger, WebDriver driver , String texteTel, String texteEmail, String texteNumTel, /*String texteQuestion,String texteHoraires,  */String texteFormDeCont) throws IOException {
		try {
			log.reportLogTNRInfo("MCF - Click sur ' Assistance ' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[5]/a/span", logger);
			Thread.sleep(6000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existance du logo t�l�phone  ", logger, driver);
			scriptTech.isElementExisteById(driver, "cgu", logger); 
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[1]", logger);  
			Thread.sleep(5000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existance du logo mail  ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[1]/i", logger);
			Thread.sleep(3000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existance du texte ' PAR T�L�PHONE ' ", logger, driver);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[1]", logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[1]", texteTel, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existance du texte ' PAR E-MAIL ' ", logger, driver);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]", logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]", texteEmail, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existance du num�ro de t�l�phone ' 01 84 25 20 01 ' ", logger, driver);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]", logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]", texteNumTel, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existance du num�ro du texte ' Posez votre question au service d'assistance. ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]", logger);
			//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]", texteQuestion, logger);
			Thread.sleep(2000);
		
			log.reportLogTNRInfo("MCF - V�rification de l'existance du num�ro du texte ' Horaires : du lundi au vendredi de 09h00 � 19h00 ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[4]", logger);
			//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[1]/div/div/div/div[2]/div[4]", texteHoraires, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification de l'existance du num�ro de t�l�phone ' FORMULAIRE DE CONTACT ' ", logger, driver);
			//scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[3]/button", logger);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[2]/div/div/div/div[2]/div[3]/button", texteFormDeCont, logger); 
			Thread.sleep(2000);
			
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}	
			
	/**
	 * FOnction V�rifiant le click sur voir les collectes dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
	 * @throws IOException
	 */
	public void ActionClickPubliees(Logger logger, WebDriver driver, String textePub, String texteBrou, String texteTermine, String texteCorb) throws IOException {
		try {	
			
			log.reportLogTNRInfo("MCF - V�rification du texte 'ALATA' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[1]/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification de la date d'adh�sion et du texte 'ADH�SION - fin le 06/08/2022'  ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[2]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification du texte ' ADH�RENT' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[1]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification du texte ' COMMAND�S' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[2]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification du texte ' PAY�S' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[4]/div[3]", logger);
			
			log.reportLogTNRInfo("MCF - V�rification du texte ' VOIR MA PAGE' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[5]/a", logger);
			
			log.reportLogTNRInfo("MCF - Click sur le texte ' VOIR MA PAGE' ", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div/div/div[1]/div[5]/a", logger);  
			
			
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}
		
	}
	
	
	/**
	 * FOnction V�rifiant le click sur texte Paiement en ligne dans le tableau de bord de mon club facile.
	 * 
	 * @param logger
	 * @param driver
	 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
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
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'ic�ne et le nombre d'adh�rents", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div[1]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'ic�ne et la quantit� command�e", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div[2]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'ic�ne et la somme pay�e", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div[3]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage de l'ic�ne et la somme en attente", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[2]/div/div/div[4]", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' Rechercher un adh�rent : ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[1]/div/div/div[1]/div/div/div[1]", texteRechAdherent, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' Recherche par filtres ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='rechfiltre']", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' AJOUTER UN ADH�RENT ' ", logger, driver);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='rechfiltre']", logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' NOM : IBRAHIM ' ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[4]", Nom, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte PR�NOM : ROMARIC", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[6]", Prenom, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte DATE DE NAISSANCE : 12/12/1958", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[7]", DateDeNaissance, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte TARIF ", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[9]/div/div", Tarif, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte MONTANT : 5.00�", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[10]/div", Montant, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte STATUT DE PAIEMENT : CH�QUE", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[11]", Statut, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte MODE DE DE PAIEMENT : EN ATTENTE", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[12]", Mode, logger);
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("MCF - V�rification Affichage du texte CERTIFICAT M�DICAL : NON", logger, driver);
			//scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[13]/div", Certifi, logger);
			scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[13]/div", logger);
			Thread.sleep(2000);
			
		} catch (Exception e) { 
			log.reportLogTNRFatal(e.getMessage(), logger, driver);  
		}

	}
		
		
		
		/**
		 * FOnction V�rifiant du bloc 'En attente de virement ' dans mes virements de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteAdherent : exemple : ADHERENT
		 * @throws IOException
		 */
		public void EnAttenteDeVi(Logger logger, WebDriver driver, String texteAttenteVir, String texteMontantTotalVir, String texteDetailPiaementCB, String texteCB, String texteDetailMontantFrais, String texteFrais) throws IOException {
			try {
				/*log.reportLogTNRInfo("MCF - V�rification Affichage du bloc texte ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[1]", logger); 
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du logo du montant total du menu ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[2]", logger);

				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' soit	0,00 � Paiements par CB ' dans le menu ' EN ATTENTE DE VIREMENT '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[3]", logger);  
			
				log.reportLogTNRInfo("MCF - V�rification Affichage du d�tail du texte ' -0,00 � Frais E-Cotiz' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[4]", logger); */
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du bloc texte ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[1]", texteAttenteVir, logger);  
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du logo du montant total du menu ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[2]", logger);

				log.reportLogTNRInfo("MCF - V�rification Affichage du montant total ' EN ATTENTE DE VIREMENT '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[2]/div[2]", texteMontantTotalVir, logger);  
			
				log.reportLogTNRInfo("MCF - V�rification Affichage du d�tail du montant par carte bancaire EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[3]/div[2]", texteDetailPiaementCB, logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte de la phrase  Paiement par carte bancaire EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[3]/div[3]", texteCB, logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du d�tail du montant par Frais E-Cotiz EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[4]/div[2]", texteDetailMontantFrais, logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte de la phrase  Frais E-Cotiz EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[1]/div/div[4]/div[3]", texteFrais, logger); 
				 
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}

		}
	
		
		/**
		 * FOnction V�rifiant du du bloc prochain virement  dans le mes virements de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteCommandes : exemple : COMMAND�S
		 * @throws IOException
		 */
		public void ProchViremt(Logger logger, WebDriver driver , String texteProchVir, String texteMontantTotalProchVir) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' PROCHAIN VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[2]/div/div[1]", texteProchVir, logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du logo du menu ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[2]/div/div[2]/div[1]", logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du montant total du menu ' EN ATTENTE DE VIREMENT ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[2]/div/div[2]/div/div[2]/div[2]", texteMontantTotalProchVir, logger);  
			
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}

		}
		
		
		/**
		 * FOnction V�rifiant du du bloc historique des virements de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteCommandes : exemple : COMMAND�S
		 * @throws IOException
		 */
		public void HistoVirmt(Logger logger, WebDriver driver , String texteHistoViret, String texteDate, String texteLib, String texteNomCol, String texteMontant) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[1]/a", texteHistoViret, logger);
				
				log.reportLogTNRInfo("MCF - Click sur le texte ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[1]/a", logger); 
				
				log.reportLogTNRInfo("MCF - V�rification Affichage de la ' DATE ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[1]", texteDate, logger); 
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' LIBELL� ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[2]", texteLib, logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' NOM DE LA COLLECTE ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[3]", texteNomCol, logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' MONTANT ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[4]", texteMontant, logger); 
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' AUCUN VIREMENT EFFECTU� SUR VOTRE COMPTE. ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/tbody/tr/td/p", logger);
				
				
				/*log.reportLogTNRInfo("MCF - V�rification Affichage de la ' DATE ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[1]", logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' LIBELL� ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[2]", logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' NOM DE LA COLLECTE ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[3]", logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' MONTANT ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo']/div/div/div/table/thead/tr/th[4]", logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' AUCUN VIREMENT EFFECTU� SUR VOTRE COMPTE. ' dans le menu ' HISTORIQUE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-histo]/div/div/div/table/tbody/tr/td/p", logger);*/
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}

		}
		
		
		/**
		 * FOnction V�rifiant du du bloc Fr�quence des virements de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteCommandes : exemple : COMMAND�S
		 * @throws IOException
		 */
		public void FrequenceVirt(Logger logger, WebDriver driver , String texteFreqViret, String NumeroFreq, String Nom, String Mensuel) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' FR�QUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[2]/a", texteFreqViret, logger);
				
				log.reportLogTNRInfo("MCF - Click sur le texte ' FR�QUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='page-wrapper']/div/div[3]/div/div/ul/li[2]/a", logger); 
				
				log.reportLogTNRInfo("MCF - V�rification Affichage de la ' R�F�RENCE ' dans le menu ' FR�QUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[1]/table/thead/tr/th[1]", logger); 
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' NOM DE LA COLLECTE ' dans le menu ' FR�QUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[1]/table/thead/tr/th[2]", logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' FR�QUENCE ' dans le menu ' FR�QUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[1]/table/thead/tr/th[3]", logger);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' 1754 ' dans le menu 'FR�QUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[2]/table/tbody/tr/td[1]", NumeroFreq, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' ALATA ' dans le menu 'FR�QUENCE DES VIREMENTS ' ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='virement-freq']/div/div/div/div/div[1]/div[2]/table/tbody/tr/td[2]", Nom, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification Affichage du texte ' MENSUELLE ' dans le menu 'FR�QUENCE DES VIREMENTS ' ", logger, driver);
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
			
			log.reportLogTNRInfo("Mon compte MCF - V�rifier la pr�sence du texte ' Nom de l'association * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[1]/label", texteNomAsso, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Mon compte MCF - V�rifier la pr�sence du texte ' Nom ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[2]/label", texteNom, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Saisir le texte 'LAVERROUX'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[2]/div/input", "LAVERROUX", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Mon compte MCF - V�rifier la pr�sence du texte ' Pr�nom ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[3]/label", textePrenom, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Saisir le texte 'Marc'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[3]/div/input", "Marc", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Mon compte MCF - V�rifier la pr�sence du texte ' Email * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[4]/label", texteEmail, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Mon compte MCF - V�rifier la pr�sence du text ' T�l�phone * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[5]/label", texteTel, logger); 
			Thread.sleep(2000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Saisir le texte '06 00 00 00 00'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[5]/div/input", "06 00 00 00 00", logger); 
			Thread.sleep(1000);
			
			log.reportLogTNRInfo("Mon compte MCF - V�rifier la pr�sence du text ' Quel est le motif de votre demande ? * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
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
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification Affichage de l'adresse du club/asso'", logger, driver);
			scriptTech.sendTextByXpath(driver, "//*[@id='subscription_form']/div[3]/fieldset/div[3]/div/input", "12 rue des plantes", logger);
			Thread.sleep(1000);*/
			/*
			scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", "79000", logger);
			Thread.sleep(4000);
			scriptTech.sendKeysByXpath(driver, "//*[@id='react-select-2--value']/div/input", Keys.ENTER, logger); 
			//scriptTech.sendTextByXpath(driver, "//*[@id='react-select-2--value']/div[2]/input", " 79000 - Niort", logger);
			Thread.sleep(4000);*/
			
			log.reportLogTNRInfo("Mon compte MCF - V�rifier la pr�sence du texte ' Messages * ' dans  FORMULAIRE DE CONTACT ",logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[7]/label", texteMessage, logger); 
			Thread.sleep(5000);
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Saisir le texte  dans la case Messages *", logger, driver);
			//scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[5]/div/input", "Bonjour, je suis Mr X , je suis actuellement en vacance, je serai joignable uniquement par t�l�phone (06 00 00 00 00)  entre 10h-11h15. Merci de votre compr�hension.  ", logger); 
			scriptTech.sendTextByXpath(driver, "//*[@id='contact_form']/div[7]/div/textarea", "Bonjour, je suis Mr X , je suis actuellement en vacance, je serai joignable uniquement par t�l�phone (06 00 00 00 00)  entre 10h-11h15. Merci de votre compr�hension.  ", logger); 
			Thread.sleep(5000); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rifier la pr�sence du texte ' ENVOYER VOTRE DEMANDE * ' dans  FORMULAIRE DE CONTACT", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[8]/button", texteEnvoyer, logger);
			Thread.sleep(1000); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification du texte ' ENVOYER VOTRE DEMANDE * ' dans  FORMULAIRE DE CONTACT", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='contact_form']/div[8]/button", texteEnvoyer, logger);
			Thread.sleep(5000); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - Click sur le texte ' ENVOYER VOTRE DEMANDE * ' dans  FORMULAIRE DE CONTACT", logger, driver);
			scriptTech.clickByXpath(driver, "//*[@id='contact_form']/div[8]/button", logger); 
			Thread.sleep(5000); 
			
			log.reportLogTNRInfo("Page d'accueil - MCF - V�rification du texte ' VOTRE DEMANDE A BIEN �T� TRANSMISE AU SERVICE CLIENT MON CLUB FACILE, ELLE SERA TRAIT�E DANS UN D�LAI DE 48H OUVR�ES. ' dans  FORMULAIRE DE CONTACT", logger, driver);
			scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div/div[3]/div/h3", texteDemandeTransmise, logger);
			Thread.sleep(5000);
			
			
		} 
	
		
		
		/**
		 * FOnction V�rifiant le click sur l'onglet Tarif dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
		 * @throws IOException
		 */
		public void ActionTarifBloc1(Logger logger, WebDriver driver , String texteService/* String texteEvenement, String texteMembres, 
				String texteCommunic, String textePaeligne*/) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Click sur ' Tarif ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[1]/a", logger);
				Thread.sleep(4000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' LES SERVICES PROPOS�S '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[1]/div", texteService, logger); 
				Thread.sleep(4000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' GESTION DES �V�NEMENTS '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[1]", logger);  
				//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[1]", texteEvenement, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' GESTION DES MEMBRES '  ", logger, driver);
				//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[2]", texteMembres, logger);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[2]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' OUTILS DE COMMUNICATION '  ", logger, driver);
				//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[3]", texteCommunic, logger); 
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[3]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' PAIEMENT EN LIGNE PAR CB '  ", logger, driver);
				//scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[4]", textePaeligne, logger);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[2]/div/div[4]", logger);
				Thread.sleep(3000);
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		/**
		 * FOnction V�rifiant le click sur l'onglet Tarif dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
		 * @throws IOException
		 */
		public void ActionTarifBloc2(Logger logger, WebDriver driver , String texteSolutionComplete, String texteGerer, String texteSansLimite, String texteSansFrais, 
				String texteSansAbonnement, String texteSansSolu, String texteDesFrais, String texteEnCasDePaiement) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Click sur ' Tarif ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[1]/a", logger);
				Thread.sleep(5000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' UNE SOLUTION COMPL�TE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/div", texteSolutionComplete, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' POUR G�RER VOTRE ASSOCIATION '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[1]", texteGerer, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Sans limite de collecte '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[2]", texteSansLimite, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Sans frais d�installation '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[3]", texteSansFrais, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Sans abonnement '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[4]", texteSansAbonnement, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Sans engagement '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[1]/p[5]", texteSansSolu, logger); 
				Thread.sleep(3000); 
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' DES FRAIS APPLIQU�S UNIQUEMENT '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[2]/div", texteDesFrais, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' EN CAS DE PAIEMENT PAR CB '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[2]/p[1]", texteEnCasDePaiement, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Si vous utilisez le module de paiement en ligne, des frais de 3% sont appliqu�s sur les transactions bancaires (avec un minimum de 1� et un maximum 10�) '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div[3]/div/div[2]/p[2]", logger); 
				Thread.sleep(3000);
				
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		/**
		 * FOnction V�rifiant le click sur l'onglet Comment �a marche  dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
		 * @throws IOException
		 */
		public void ActionCommeCaMarcheBloc1(Logger logger, WebDriver driver) throws IOException {
			try {
				log.reportLogTNRInfo("MCF - Click sur ' Comment �a marche ? ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[2]/a", logger);
				Thread.sleep(3000);
				Thread.sleep(5000);
				log.reportLogTNRInfo("MCF - V�rification de l'existance de l'ic�ne ' MON CLUB FACILE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div[1]/div/div/div[1]/img", logger);
				Thread.sleep(5000); 
				
				log.reportLogTNRInfo("MCF - V�rification de l'existance du texte ' La plateforme vous permet de g�rer facilement vos adh�sions en ligne mais �galement tous vos autres projets : �v�nements, e-boutique, etc... '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div[1]/div/div/div[2]/p[1]", logger);
				Thread.sleep(2000);
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		/**
		 * FOnction V�rifiant le click sur l'onglet Tarif dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
		 * @throws IOException
		 */
		public void ActionCommeCaMarcheBloc2(Logger logger, WebDriver driver , String texteEtapesCles, String texteParam, /*String texteCree,*/ String texteInvite, 
				String texteCollec, String texteGere, String textePercois) throws IOException {
			try {
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du picto ' �tapes '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[1]", logger);
				Thread.sleep(5000); 
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' LES �TAPES CL�S '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[2]", texteEtapesCles, logger); 
				Thread.sleep(3000); 
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Je param�tre mes collectes pour la rentr�e sportive ou tout autre �v�nement '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/p", texteParam, logger); 
				Thread.sleep(3000); 
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce de l'ic�ne ' JE CR�E '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[1]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' JE CR�E '  ", logger, driver);
				//scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[2]", texteCree, logger);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[2]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Je cr�e mon �v�nement en quelques clics'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[1]/div[3]", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce de l'ic�ne ' J'INVITE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[2]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' J'INVITE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[2]/div[2]", texteInvite, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' J'invite mes adh�rents � y participer'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[2]/div[3]", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce de l'ic�ne ' JE COLLECTE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[3]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' JE COLLECTE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[3]/div[2]", texteCollec, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Je collecte les paiements par Carte Bancaire sur mon porte-monnaie �lectronique'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[3]/div[3]/div[3]", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce de l'ic�ne ' JE G�RE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[1]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' JE G�RE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[1]/div[2]", texteGere, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' Je g�re ma base adh�rents et le niveau de compl�tude des inscriptions'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[1]/div[3]", logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce de l'ic�ne ' JE PER�OIS'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[2]/div[1]/img", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' JE PER�OIS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[2]/div[2]", textePercois, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte 'Je per�ois les montants collect�s par virement sur mon compte bancaire.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='menu-commentcamarche']/div/div/div/div[1]/div[4]/div[2]/div[3]", logger); 
				Thread.sleep(3000);
				
				
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		/**
		 * FOnction V�rifiant le click sur l'onglet ActionSecurite dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
		 * @throws IOException
		 */
		public void ActionSecurite(Logger logger, WebDriver driver, String texteUneSolutionEnti, String texteProtocole, String texteHeberge, String textePaiConfiance) throws IOException {
			try {
				/*log.reportLogTNRInfo("MCF - Click sur ' S�curit� ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[3]/a", logger);
				Thread.sleep(5000);  */
				
				Thread.sleep(3000);
				log.reportLogTNRInfo("MCF - V�rification de l'existance du texte ' UNE SOLUTION ENTI�REMENT S�CURIS�E '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[1]/div[1]", texteUneSolutionEnti, logger);  
				Thread.sleep(3000);    
				
				log.reportLogTNRInfo("MCF - V�rification de l'existance de l'ic�ne ' PROTOCOLE HTTPS '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[1]/div[2]/img", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existance du texte ' PROTOCOLE HTTPS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[1]/div[3]/div/div", texteProtocole, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existance du texte ' Sur Mon Club Facile, le protocole HTTPS garantit la confidentialit� et l�int�grit� des donn�es que vous transmettez. Tous les formulaires de paiement de la plateforme comportent �galement le cadenas de s�curit� propre au protocole HTTPS qui vous assure la fiabilit� des transactions bancaires r�alis�es en ligne.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[1]/div[3]/div/p", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existance de l'ic�ne ' H�BERGEMENT DES DONN�ES '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[2]/div[2]/img", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existance du texte ' H�BERGEMENT DES DONN�ES '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[2]/div[1]/div/div", texteHeberge, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existance du texte 'Toutes vos donn�es personnelles (nom, pr�nom, e-mail, coordonn�es bancaires...) sont conserv�es dans un environnement s�curis�, sauvegard�es quotidiennement sur des serveurs en France et ne sont jamais divulgu�es � qui que ce soit.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[2]/div[1]/div/p", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce de l'ic�ne ' PAIEMENT EN TOUTE CONFIANCE '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[3]/div[1]/img", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte ' PAIEMENT EN TOUTE CONFIANCE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/div[3]/div[2]/div/div", textePaiConfiance, logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existnce du texte 'Pour l�ensemble des transactions, Mon Club Facile a int�gr� la solution d�un prestataire agr�� par la Banque de France. L�argent collect� est stock� sur un porte-monnaie �lectronique qui vous appartient. Vous choisissez la fr�quence des virements depuis ce porte-monnaie vers votre compte en banque.'  ", logger, driver);
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
		 * FOnction V�rifiant le click sur l'onglet Mentions l�gales dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
		 * @throws IOException
		 */
		public void ActionMentionsLegales(Logger logger, WebDriver driver, String texteEditeur, String Tel, String Mail, String Adressemail, String NumeroIndiv, String Directeur, 
				String DirecPub, String ResponSite, String texteHebergSite, String Hebergeur, String Propriete, String Partenaire, String Respon) throws IOException {
			try {
				/*log.reportLogTNRInfo("MCF - Click sur ' Mentions l�gales ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[4]/a", logger);*/
				Thread.sleep(5000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' �DITEUR '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[1]", texteEditeur, logger);  
				Thread.sleep(3000);  
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Le site internet Mon club facile, accessible via l�URL www.monclubfacile.maif.fr(ci-apr�s � le Site �) est �dit� par la soci�t� MAIF Horizon - SAS au capital de 12 422 000 � - RCS NIORT 518 016 589 - 200 avenue Salvador Allende 79000 NIORT. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[1]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' T�l�phone :  05 49 73 74 75'  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]/span[1]", Tel, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Mail '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]/span[2]", Mail, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' contact@monclubfacile.fr '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]/a", Adressemail, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Num�ro individuel d�identification � la TVA : FR 72 518 016 589. '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]/span[3]", NumeroIndiv, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' DIRECTEUR DE LA PUBLICATION ET RESPONSABLE DU SITE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[2]", Directeur, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Directeur de publication : Pascal Demurger, Directeur G�n�ral de la MAIF '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[3]", DirecPub, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Responsable du site : Nicolas Boudinet '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[4]", ResponSite, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' H�BERGEUR DU SITE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[3]", texteHebergSite, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Le site est h�berg� par la soci�t� MAIF. '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[5]", Hebergeur, logger); 
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' La Soci�t� MAIF est une soci�t� d�assurance mutuelle ... T�l�phone : 05 49 73 74 75 '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[6]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' PROPRI�T� INTELLECTUELLE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[4]", Propriete, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Les contenus pr�sents sur le site  .... dans le cadre d�une utilisation personnelle. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[7]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Il est rappel� que � Mon Club Facile � est une marque d�pos�e, propri�t� de la MAIF.'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[8]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Toute exploitation non express�ment autoris�e  .... poursuites judiciaires � l�encontre de tout Utilisateur qui n�aurait pas respect� cette interdiction. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[9]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' PARTENAIRES '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[5]", Partenaire, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' L�utilisateur demeure seul responsable du respect .... liens hypertexte. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[10]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Les Services de cr�ation de Porte-monnaie .... ayant son si�ge social � 6 rue Claude Farr�re 75016 Paris. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[11]", logger);
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' RESPONSABILIT�S '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[6]", Respon, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' La consultation du Site ainsi que l�utilisation des informations et des services pr�sent�s par les Partenaires ou les tiers se font sous la seule responsabilit� de l�Utilisateur. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[12]", logger);
				Thread.sleep(3000);
				
				
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		
		/**
		 * FOnction V�rifiant le click sur l'onglet Conditions l�gales dans le menu Autres de mon club facile.
		 * 
		 * @param logger
		 * @param driver
		 * @param texteRechAdherent : exemple : Rechercher un adh�rent :
		 * @throws IOException
		 */
		public void ActionConditionsLegales(Logger logger, WebDriver driver, String textePreambule, String texteObject, String texteIdentifiant, String texteMaifHorizon, String texteLaPlate,
				String texteUtilisateur, String texteTiers, String texteAcceptation, String texteInscription) throws IOException {
			try {
				/*log.reportLogTNRInfo("MCF - Click sur ' Conditions g�n�rales ' ", logger, driver);
				scriptTech.clickByXpath(driver, "//*[@id='sidebar']/ul/li[6]/ul/li[5]/a", logger);*/
				Thread.sleep(5000); 
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte '  PR�AMBULE '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[1]", textePreambule, logger);  
				Thread.sleep(3000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' La soci�t� MAIF Horizon propose un service permettant � chaque club ou association sportive qui s�inscrit (ci-apr�s � Utilisateur �) de centraliser sur une plateforme internet la gestion quotidienne de son club (ci-apr�s � Mon Club Facile �). '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[1]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' � partir de cette plateforme, l�Utilisateur peut b�n�ficier d�outils et de fonctionnalit�s telles que la cr�ation et la diffusion de collecte, la cr�ation d�un porte-monnaie �lectronique, la visualisation de l��tat de la tr�sorerie, la cr�ation d�une base adh�rents, le r�glement des adh�sions, leur organisation, la communication, les relances des cotisations, dans le cadre des prescriptions d�utilisation d�finies dans les pr�sentes Conditions G�n�rales d�Utilisation (ci-apr�s, les � Services �).'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[2]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Les Services Mon Club Facile sont pr�sent�s sur le site internet Mon Club Facile www.monclubfacile.maif.fr (ci-apr�s la � Plateforme internet �) '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[3]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte 'L'acc�s au service est gratuit pour les clubs ou associations sportives, selon les conditions indiqu�es dans les pr�sentes Conditions G�n�rales d�Utilisation (CGU).'  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[4]", logger); 
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte '  OBJET '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[2]", texteObject, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte '  Les Utilisateurs acc�dent � la Plateforme internet et b�n�ficient des Services Mon Club Facile, une fois inscrit, dans le respect des pr�sentes CGU. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[5]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte '  Les Services de Mon Club Facile ont pour principal objet de fournir diff�rentes fonctionnalit�s qui peuvent �tre utilis�es ou non dans l�objectif de faciliter la gestion administrative de ses Utilisateurs. Les outils informatiques mis � sa disposition dans ce cadre leur permettent de prendre, le cas �ch�ant, des d�cisions de mani�re autonome. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[6]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte '  La prestation de MAIF Horizon est limit�e � la seule fourniture des Services Mon Club Facile sans aucune forme de conseil en mati�re de gestion administrative � destination des Associations Sportives. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[7]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte '  IDENTIFICATION DES PARTIES ET DES TIERS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[3]", texteIdentifiant, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte '  Maif Horizon '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h4[1]", texteMaifHorizon, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' La Plateforme internet et les Services Mon Club Facile sont exploit�s par MAIF Horizon. '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[8]", texteLaPlate, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' MAIF Horizon fournit un service permettant � l�Utilisateur de faciliter et automatiser les t�ches li�es � la gestion administrative des Associations Sportives. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[9]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Les CGU peuvent faire l�objet d�une cession totale ou partielle, � titre on�reux ou gracieux, par MAIF Horizon, sans l�accord �crit et pr�alable de l�Utilisateur, d�s lors que le cessionnaire maintient au b�n�fice de l�Utilisateur les droits et les obligations pr�vus aux pr�sentes CGU. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[10]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' L'utilisateur '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h4[2]", texteUtilisateur, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Les Services Mon Club Facile ne peuvent �tre utilis�s que par des Utilisateurs ayant la qualit� de g�rants d�associations sportives. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[11]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Apr�s s��tre inscrit selon les modalit�s vis�es au chapitre 4.1, l�Utilisateur peut acc�der aux Services Mon Club Facile � partir de ses identifiants de connexion constitu�s de son adresse email et codes d�acc�s associ�s. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[12]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Les Tiers '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h4[3]", texteTiers, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Le service de gestion de cotisations en ligne pour les Associations sportives est r�alis�e en s�appuyant sur la solution d�velopp�e par la soci�t� E-Cotiz, Soci�t� par Actions Simplifi�e au capital de 7.725,40 �, inscrite au registre du commerce et des soci�t�s de Paris, sous le num�ro 802 661 678, ayant son si�ge social � 6 rue Claude Farr�re � 75016 PARIS (ci-apr�s 'E-Cotiz') '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[13]", logger); 
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' La soci�t� E-Cotiz a �galement en charge l�h�bergement des donn�es n�cessaires � la cr�ation du porte-monnaie �lectronique et au module de paiement mis � disposition de l�utilisateur par l�interm�diaire de son sous-traitant identifi� dans les mentions l�gales pr�sentes sur la Plateforme Internet. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[14]", logger); 
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' Vous pouvez consulter les CGV de E-Cotizpour le compte de Mon Club Facile ici. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[15]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' La solution s�curis�e de r�glement des cotisations en ligne mise � disposition par E-Cotiz est op�r�e par S-MONEY du Groupe BPCE (S-MONEY, soci�t� par actions simplifi�e au capital de 11.037.000 euros, inscrite au Registre du Commerce et des Soci�t�s de Paris sous le num�ro 501 586 341, dont le si�ge social est sis 28 villa de Lourcine, 75014 Paris (ci-apr�s 'S-MONEY')). '  ", logger, driver);
				//scriptTech.isElementExisteByXpath(driver, xpath, logger);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[16]", logger);
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' S-MONEY est agr��e en France en tant qu�Etablissement de monnaie �lectronique, soumise au contr�le de l�Autorit� de Contr�le Prudentiel et de R�solution (61 rue Taitbout, 75436 Paris Cedex 09) et inscrite sur la liste des �tablissements habilit�s � exercer leurs activit�s en France, telle que publi�e sur le site Internet www.acpr.banque-france.fr. '  ", logger, driver);
				scriptTech.isElementExisteByXpath(driver, "//*[@id='cgu']/div/div/div/div/p[17]", logger); 
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' ACCEPTATION DES CGU ET DE LEURS MODIFICATIONS '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h3[4]", texteAcceptation, logger);  
				Thread.sleep(2000);
				
				log.reportLogTNRInfo("MCF - V�rification de l'existence du texte ' 1 Inscription � Cr�ation D�un Compte Utilisateur '  ", logger, driver);
				scriptTech.verifTextByXpath(driver, "//*[@id='cgu']/div/div/div/div/h4[4]", texteInscription, logger);   
				Thread.sleep(5000);
				
			
			} catch (Exception e) { 
				log.reportLogTNRFatal(e.getMessage(), logger, driver);  
			}
			
		}	
		
		
		
		
		
}


