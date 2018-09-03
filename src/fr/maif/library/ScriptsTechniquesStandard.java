package fr.maif.library;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ScriptsTechniquesStandard {

	Logs log = new Logs();

	/**
	 * Verfie la presence d'un texte via un Id
	 * @param driver
	 * @param id
	 * @param texte
	 * @param logger
	 * @throws IOException
	 */
	public void verifTexteById(WebDriver driver, String id, String texte, Logger logger) throws IOException {
		try {
			assertEquals(driver.findElement(By.id(id)).getText(), texte);
		} catch (Error e) {
			log.reportLogTNRWarning(e.toString(), logger, driver);
		}
	}

	/**
	 * Verifie la presence d'un element via le xpath
	 * 
	 * @param driver
	 * @param xpath
	 * @param logger
	 * @throws IOException
	 */
	public boolean isElementExisteByXpath(WebDriver driver, String xpath, Logger logger) throws IOException {
		try {
			assertTrue(isElementPresent(By.xpath(xpath), driver));
			return true;
		} catch (Error e) {
			log.reportLogTNRWarning(e.toString(), logger, driver);
			return false;
		}
	}

	/**
	 * Verifie la presence d'un element via le Id
	 * 
	 * @param driver
	 * @param xpath
	 * @param logger
	 * @throws IOException
	 */
	public void isElementExisteById(WebDriver driver, String id, Logger logger) throws IOException {
		try {
			assertTrue(isElementPresent(By.id(id), driver));
		} catch (Error e) {
			log.reportLogTNRWarning(e.toString(), logger, driver);
		}
	}
	
	// J'ai ajoute cette partie qui verifie la presence d'un element via son css.
	/**
	 * Verifie la presence d'un element via le css
	 * 
	 * @param driver
	 * @param xpath
	 * @param logger
	 * @throws IOException
	 */
	public void isElementExisteBycssSelector(WebDriver driver, String css, Logger logger) throws IOException {
		try {
			assertTrue(isElementPresent(By.cssSelector(css), driver));
		} catch (Error e) {
			log.reportLogTNRWarning(e.toString(), logger, driver);
		}
	}
	
	//J'ai aussi ajoute cette partie qui verifie la presence d'un Texte via son css.
	/**
	 * Verfie la presence d'un texte via un css
	 * @param driver
	 * @param id
	 * @param texte
	 * @param logger
	 * @throws IOException
	 */
	public void verifTexteBycssSelector(WebDriver driver, String css, String texte, Logger logger) throws IOException {
		try {
			assertEquals(driver.findElement(By.cssSelector(css)).getText(), texte);
		} catch (Error e) {
			log.reportLogTNRWarning(e.toString(), logger, driver);
		}
	}

	/**
	 * Click sur une balise href via le texte
	 * 
	 * @param driver
	 * @param TexteCss
	 * @param logger
	 * @throws IOException
	 */
	public void clickByLinkText(WebDriver driver, String TexteLink, Logger logger) throws IOException {
		try {
			driver.findElement(By.linkText(TexteLink)).click();
			log.reportLogTNRInfo("Element trouve byLinkText =" + TexteLink, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve byLinkText =" + TexteLink + "/" + e.getMessage(), logger, driver);
		}

	}

	/**
	 * Click element par class css
	 * 
	 * @param driver
	 * @param TexteCss
	 * @param logger
	 * @throws IOException
	 */
	public void clickByCss(WebDriver driver, String TexteCss, Logger logger) throws IOException {
		try {
			driver.findElement(By.cssSelector(TexteCss)).click();
			log.reportLogTNRInfo("Element trouve byCss =" + TexteCss, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve byCss =" + TexteCss + "/" + e.getMessage(), logger, driver);
		}

	}

	/**
	 * Mise e Zero d'un champ texte by Css
	 * 
	 * @param driver
	 * @param TexteCss
	 * @param logger
	 * @throws IOException
	 */
	public void clearByCss(WebDriver driver, String TexteCss, Logger logger) throws IOException {
		try {
			driver.findElement(By.cssSelector(TexteCss)).clear();
			log.reportLogTNRInfo("Element trouve byCss =" + TexteCss, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve byCss =" + TexteCss + "/" + e.getMessage(), logger, driver);
		}

	}

	/**
	 * Mise e Zero champ text by Name
	 * 
	 * @param driver
	 * @param nom
	 * @param logger
	 * @throws IOException
	 */
	public void clearByName(WebDriver driver, String nom, Logger logger) throws IOException {
		try {
			driver.findElement(By.cssSelector(nom)).clear();
			log.reportLogTNRInfo("Element trouve by Name =" + nom, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Name =" + nom + "/" + e.getMessage(), logger, driver);
		}

	}

	/**
	 * Mise e Zero by Id
	 * 
	 * @param driver
	 * @param string
	 * @param logger
	 * @throws IOException
	 */
	public void clearById(WebDriver driver, String string, Logger logger) throws IOException {
		try {
			driver.findElement(By.id(string)).clear();
			log.reportLogTNRInfo("Element trouve by Id =" + string, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Id =" + string + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Click element par Id
	 * 
	 * @param driver
	 * @param id
	 * @param logger
	 * @throws IOException
	 */
	public void clickById(WebDriver driver, String id, Logger logger) throws IOException {
		try {
			driver.findElement(By.id(id)).click();
			log.reportLogTNRInfo("Element trouve by Id =" + id, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Id =" + id + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * click element par Name
	 * 
	 * @param driver
	 * @param name
	 * @param logger
	 * @throws IOException
	 */
	public void clickByName(WebDriver driver, String name, Logger logger) throws IOException {
		try {
			driver.findElement(By.name(name)).click();
			log.reportLogTNRInfo("Element trouve by Name =" + name, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Name =" + name + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Click By Xpath
	 * 
	 * @param driver
	 * @param xpath
	 * @param logger
	 * @throws IOException
	 */
	public void clickByXpath(WebDriver driver, String xpath, Logger logger) throws IOException {
		try {
//			driver.findElement(By.xpath(xpath)).click();
			WebElement element = driver.findElement(By.xpath(xpath));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			log.reportLogTNRInfo("Element trouve by Xpath =" + xpath, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Xpath =" + xpath + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Renseigne un champ avec du texte by Xpath
	 * 
	 * @param driver
	 * @param xpath
	 *            : chemin du champ
	 * @param texte
	 *            : texte e renseigner dans le champ
	 * @param logger
	 * @throws IOException
	 */
	public void sendTextByXpath(WebDriver driver, String xpath, String texte, Logger logger) throws IOException {
		try {
			driver.findElement(By.xpath(xpath)).sendKeys(texte);
			log.reportLogTNRInfo("Element trouve by Xpath =" + xpath, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Xpath =" + xpath + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Renseigne un champ avec du texte by Name
	 * 
	 * @param driver
	 * @param nom
	 * @param texte
	 * @param logger
	 * @throws IOException
	 */
	public void sendTextByName(WebDriver driver, String nom, String texte, Logger logger) throws IOException {
		try {
			driver.findElement(By.name(nom)).sendKeys(texte);
			log.reportLogTNRInfo("Element trouve by Xpath =" + nom, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Xpath =" + nom + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Selectionner un element dans une liste
	 * 
	 * @param driver
	 * @param name
	 *            : nom de la liste
	 * @param text
	 *            : texte e selectionner
	 * @param logger
	 * @throws IOException
	 */
	public void selectElementListByText(WebDriver driver, String name, String text, Logger logger) throws IOException {
		try {
			new Select(driver.findElement(By.name(name))).selectByVisibleText(text);
			log.reportLogTNRInfo("Element trouve by Name et Texte =" + name + "/" + text, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Name et Texte =" + name + "/" + text + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Envoi d'une commande clavier by Xpath
	 * 
	 * @param driver
	 * @param xpath
	 * @param arrowDown
	 * @param logger
	 * @throws IOException
	 */
	public void sendKeysByXpath(WebDriver driver, String xpath, Keys arrowDown, Logger logger) throws IOException {
		try {
			driver.findElement(By.xpath(xpath)).sendKeys(arrowDown);
			log.reportLogTNRInfo("Element trouve by Xpath =" + xpath, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Xpath =" + xpath + "/" + e.getMessage(), logger, driver);
		}
	}

	public void sendKeysById(WebDriver driver, String id, Keys arrowDown, Logger logger) throws IOException {
		try {
			driver.findElement(By.id(id)).sendKeys(arrowDown);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Xpath =" + id + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Renseigne un champ texte By Id
	 * 
	 * @param driver
	 * @param string
	 * @param string2
	 * @param logger
	 * @throws IOException
	 */
	public void sendTextById(WebDriver driver, String id, String texte, Logger logger) throws IOException {
		try {
//			WebElement el = driver.findElement(By.id(id));
//			String character = "";
//
//			String[] result = texte.split("\\s");
//			for (int x = 0; x < result.length; x++) {
//				el.sendKeys(result[x] + " ");
//				Thread.sleep(1000);
//			}
			driver.findElement(By.id(id)).sendKeys(texte);
			log.reportLogTNRInfo("Element trouve by Id =" + texte, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Id =" + texte + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Simule une frappe sur le clavier by Name A utiliser dans le cas de liste
	 * dynamique par exemple
	 * 
	 * @param driver
	 * @param string
	 * @param numpad3
	 * @param logger
	 * @throws IOException
	 */
	public void sendKeysByName(WebDriver driver, String string, Keys numpad3, Logger logger) throws IOException {
		try {
			driver.findElement(By.name(string)).sendKeys(numpad3);
			log.reportLogTNRInfo("Element trouve by Xpath =" + string, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Xpath =" + string + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Simule une entree clavier by Css A utiliser dans le cas de liste
	 * dynamique par exemple
	 * 
	 * @param driver
	 * @param css
	 * @param numpad3
	 * @param logger
	 * @throws IOException
	 */
	public void sendKeysByCss(WebDriver driver, String css, Keys numpad3, Logger logger) throws IOException {
		try {
			driver.findElement(By.cssSelector(css)).sendKeys(numpad3);
			log.reportLogTNRInfo("Element trouve by cssSelector =" + css, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by cssSelector =" + css + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Envoi du texte via Css
	 * 
	 * @param driver
	 * @param css
	 * @param adresseConducteur
	 * @param logger
	 * @throws IOException
	 */
	public void sendTextByCss(WebDriver driver, String css, String texte, Logger logger) throws IOException {
		try {
			WebElement el = driver.findElement(By.cssSelector(css));
			String character = "";

			String[] result = texte.split("\\s");
			for (int x = 0; x < result.length; x++) {
				el.sendKeys(result[x] + " ");
				Thread.sleep(1000);
			}

			log.reportLogTNRInfo("Element trouve by Css =" + css, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Element non trouve by Css =" + css + "/" + e.getMessage(), logger, driver);
		}

	}

	/**
	 * Recherche un texte via le xpath
	 * 
	 * @param driver
	 * @param xpath
	 * @param texte
	 * @param logger
	 * @throws IOException
	 */
	public void verifTextByXpath(WebDriver driver, String xpath, String texte, Logger logger) throws IOException {
		try {
			assertEquals(driver.findElement(By.xpath(xpath)).getText(), texte);
			log.reportLogTNRInfo("Le texte a ete trouve =" + texte, logger, driver);
		} catch (Exception e) {
			log.reportLogTNRError("Texte introuvable =" + texte + "/" + e.getMessage(), logger, driver);
		}
	}

	/**
	 * Met en surbrillance un element A utiliser dans le cas d'un debug visuel
	 * Est utiliser dans le cas des logs en erreurs
	 * 
	 * @param driver
	 * @param elem
	 */
	public void highLight(WebDriver driver, WebElement elem) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		}
	}

	
	
	
	
	private boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
