package fr.maif.library;


import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;



public class Logs {
	
	public boolean reportLogTNRInfo(String msg2, Logger logger, WebDriver driver) throws IOException {
		Status status = new Status();
		status.setMessage(msg2);
		status.setStatus(Statut.INFO);
		logStepExecTNR(status, logger, driver);
		return true;
	}

	public boolean reportLogTNRError(String msg2, Logger logger, WebDriver driver) throws IOException {
		Status status = new Status();
		status.setMessage(msg2);
		status.setStatus(Statut.ERROR);
		logStepExecTNR(status, logger, driver);
		return true;
	}

	public boolean reportLogTNRWarning(String msg2, Logger logger, WebDriver driver) throws IOException {
		Status status = new Status();
		status.setMessage(msg2);
		status.setStatus(Statut.WARNING);
		logStepExecTNR(status, logger, driver);
		return true;
	}
	
	public boolean reportLogTNRFatal(String msg2, Logger logger, WebDriver driver) throws IOException {
		Status status = new Status();
		status.setMessage(msg2);
		status.setStatus(Statut.FATAL);
		logStepExecTNR(status, logger, driver);
		return true;
	}
	

	/**
	 * Fonction logguant les tests
	 * 
	 * @param logger
	 * @param selenium
	 * @throws IOException
	 */

	private void logStepExecTNR(Status status, Logger logger, WebDriver driver) throws IOException {

		// date
		String format_write = "dd-MM-yyyy-H-mm-ss.SSS";

		java.text.SimpleDateFormat formater_write = new java.text.SimpleDateFormat(format_write);
		java.util.Date date = new java.util.Date();

		String time_write = formater_write.format(date);
		
		String message="";

		if (status.getStatus().equals(Statut.FATAL)) {
			message="FATAL_" + time_write + "_screenshot";
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
			.withTitle("FATAL_" + time_write + "_screenshot").withName(message)
			.withThumbnail(0.7)
			.save("log/");

			String msg = status.getMessage() + "<br /><a href='"+message+".png'' target='_blank'>Screenshot</a>";
			logger.warn(msg);

		} else if (status.getStatus().equals(Statut.ERROR)) {
			message="ERROR_" + time_write + "_screenshot";
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
					.withTitle("ERROR_" + time_write + "_screenshot").withName(message)
					.save("log/");

			String msg = status.getMessage() + "<br /><a href='"+message+".png'' target='_blank'>Screenshot</a>";
			logger.error(msg);
		} else if (status.getStatus().equals(Statut.WARNING)) {
			message="WARNING_" + time_write + "_screenshot";
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
					.withTitle("WARNING_" + time_write + "_screenshot")
					.withName(message).save("log/");

			String msg = status.getMessage() + "<br /><a href='"+message+".png'' target='_blank'>Screenshot</a>";
			logger.warn(msg);

		} else if (status.getStatus().equals(Statut.INFO)) {
			logger.info(status.getMessage());
			
		} else if (status.getStatus().equals(Statut.FINVERIF)) {
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).withTitle(status.getMessage())
					.withName(status.getMessage()).save("log/");
			String msg = status.getMessage() + "<br /><a href='"+status.getMessage()+".png' targe='_blank'>Screenshot</a>";
			logger.info(msg);
		}

	}

}
