package fr.maif.monclubfacile.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.Transform;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/**
 * This HTML Log Formatter is a simple replacement for the standard Log4J
 * HTMLLayout formatter and replaces the default timestamp (milliseconds,
 * relative to the start of the log) with a more readable timestamp (an example
 * of the default format is 2008-11-21-18:35:21.472-0800).
 */

public class MyLayout extends org.apache.log4j.HTMLLayout

{

	@SuppressWarnings("unused")
	private static final String rxTimestamp = "\\s*<\\s*tr\\s*>\\s*<\\s*td\\s*>\\s*(\\d*)\\s*<\\s*/td\\s*>";
	private String timestampFormat = "yyyy-MM-dd-HH:mm:ss.SZ"; // Default
																// format.
																// Example:
																// 2008-11-21-18:35:21.472-0800
	private SimpleDateFormat sdf = new SimpleDateFormat(timestampFormat);
	
	private StringBuffer sbuf = new StringBuffer(BUF_SIZE);
	static String TRACE_PREFIX = "<br>&nbsp;&nbsp;&nbsp;&nbsp;";

	public MyLayout() {
		super();
	}

	/** Override HTMLLayout's format() method */

	public String format(LoggingEvent event) {
		
		if(sbuf.capacity() > MAX_CAPACITY) {
		      sbuf = new StringBuffer(BUF_SIZE);
		    } else {
		      sbuf.setLength(0);
		    }

		    sbuf.append(Layout.LINE_SEP + "<tr>" + Layout.LINE_SEP);

		    sbuf.append("<td>");
		    sbuf.append(sdf.format(new Date(event.timeStamp - LoggingEvent.getStartTime())));
		    sbuf.append("</td>" + Layout.LINE_SEP);

		    String escapedThread = Transform.escapeTags(event.getThreadName());
		    sbuf.append("<td title=\"" + escapedThread + " thread\">");
		    sbuf.append(escapedThread);
		    sbuf.append("</td>" + Layout.LINE_SEP);

		    sbuf.append("<td title=\"Level\"");
		    if (event.getLevel().equals(Level.DEBUG)) {
		      sbuf.append("bgcolor=\"#339933\" >");
		      sbuf.append("<font color=\"#000000\">");
		      sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
		      sbuf.append("</font>");
		    }
		    else if(event.getLevel().equals(Level.ERROR)) {
			      sbuf.append("bgcolor=\"#FFFF00\" >");
			      sbuf.append("<font color=\"#000000\">");
			      sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
			      sbuf.append("</font>");
		    }else if(event.getLevel().equals(Level.FATAL)) {
			      sbuf.append("bgcolor=\"#FF3300\" >");
			      sbuf.append("<font color=\"#000000\">");
			      sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
			      sbuf.append("</font>");
		    }
		    else if(event.getLevel().equals(Level.INFO)) {
			      sbuf.append("bgcolor=\"#339933\" >");
			      sbuf.append("<font color=\"#000000\">");
			      sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
			      sbuf.append("</font>");
		    }
		    else if(event.getLevel().equals(Level.WARN)) {
		      sbuf.append("bgcolor=\"#CC6600\" >");
		      sbuf.append("<font color=\"#993300\"><strong>");
		      sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
		      sbuf.append("</strong></font>");
		    } else {
		      sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
		    }
		    sbuf.append("</td>" + Layout.LINE_SEP);

		    String escapedLogger = Transform.escapeTags(event.getLoggerName());
		    sbuf.append("<td title=\"" + escapedLogger + " category\">");
		    sbuf.append(escapedLogger);
		    sbuf.append("</td>" + Layout.LINE_SEP);

		    if(getLocationInfo()) {
		      LocationInfo locInfo = event.getLocationInformation();
		      sbuf.append("<td>");
		      sbuf.append(Transform.escapeTags(locInfo.getFileName()));
		      sbuf.append(':');
		      sbuf.append(locInfo.getLineNumber());
		      sbuf.append("</td>" + Layout.LINE_SEP);
		    }

		    sbuf.append("<td title=\"Message\">");
		    sbuf.append(event.getRenderedMessage());
		    sbuf.append("</td>" + Layout.LINE_SEP);
		    sbuf.append("</tr>" + Layout.LINE_SEP);

		    if (event.getNDC() != null) {
		      sbuf.append("<tr><td bgcolor=\"#EEEEEE\" style=\"font-size : xx-small;\" colspan=\"6\" title=\"Nested Diagnostic Context\">");
		      sbuf.append("NDC: " + Transform.escapeTags(event.getNDC()));
		      sbuf.append("</td></tr>" + Layout.LINE_SEP);
		    }

		    String[] s = event.getThrowableStrRep();
		    if(s != null) {
		      sbuf.append("<tr><td bgcolor=\"#993300\" style=\"color:White; font-size : xx-small;\" colspan=\"6\">");
		      appendThrowableAsHTML(s, sbuf);
		      sbuf.append("</td></tr>" + Layout.LINE_SEP);
		    }

		    return sbuf.toString();

	
	}

	/**
	 * Setter for timestamp format. Called if log4j.appender.
	 * <category>.layout.TimestampFormat property is specfied
	 */

	public void setTimestampFormat(String format) {
		this.timestampFormat = format;
		this.sdf = new SimpleDateFormat(format); // Use the format specified by
													// the TimestampFormat
													// property
	}

	/** Getter for timestamp format being used. */

	public String getTimestampFormat() {
		return this.timestampFormat;
	}
	
	void appendThrowableAsHTML(String[] s, StringBuffer sbuf) {
    if(s != null) {
      int len = s.length;
      if(len == 0)
	return;
      sbuf.append(Transform.escapeTags(s[0]));
      sbuf.append(Layout.LINE_SEP);
      for(int i = 1; i < len; i++) {
	sbuf.append(TRACE_PREFIX);
	sbuf.append(Transform.escapeTags(s[i]));
	sbuf.append(Layout.LINE_SEP);
      }
    }
  }

}