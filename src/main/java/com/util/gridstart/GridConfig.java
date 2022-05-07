package com.util.gridstart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import junit.framework.Assert;

public class GridConfig {
	String userDir = System.getProperty("user.dir");
	String execPath = userDir + "/cmdForStartGrid";
	String scaleGrid = userDir + "/cmdForscaleGrid";
	String stopGrid = userDir + "/cmdForstopGrid";
	String logFileDocker = userDir + "/dockerGridLog.txt";
	String logLineToConform = null;

	public enum GridOperations {
		STARTGRID, SCALECHROME, STOPGRID
	};

	public void performGridoperations(GridOperations option) throws IOException, InterruptedException {

		if (option.equals(GridOperations.STARTGRID) || option.equals(GridOperations.STOPGRID)) {
			boolean flagGrid = false;
			Calendar cal = Calendar.getInstance();
			if (option.equals(GridOperations.STARTGRID)) {
				Runtime.getRuntime().exec("/usr/bin/open -a Terminal " + execPath);
				logLineToConform = "Started Selenium node 4.1.4 (revision 535d840ee2): ";
			} else {
				Runtime.getRuntime().exec("/usr/bin/open -a Terminal " + stopGrid);
				logLineToConform = "Shutdown complete";
			}
			cal.add(Calendar.SECOND, 30);
			long stopnow = cal.getTimeInMillis();
			Thread.sleep(3000);
			while (System.currentTimeMillis() < stopnow) {

				BufferedReader reader = new BufferedReader(new FileReader(logFileDocker));

				String line = "";
				while (((line = reader.readLine()) != null) && !flagGrid) {
					if (line.contains(logLineToConform)) {
						System.out.println("LOG LINE FOUND : " + logLineToConform);
						flagGrid = true;
						break;
					} else {
						System.out.println("----------WAITING FOR GRID----------");
					}
				}

				reader.close();
			}
			Assert.assertTrue(flagGrid);

		} else if (option.equals(GridOperations.SCALECHROME)) {

			Runtime.getRuntime().exec("/usr/bin/open -a Terminal " + scaleGrid);
			Thread.sleep(30000);
			System.out.println("CHROME IS SCALED UP TO 5 INSTANCES");

		}

	}

}
