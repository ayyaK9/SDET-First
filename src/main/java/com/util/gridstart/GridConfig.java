package com.util.gridstart;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridConfig {

	public void startGrid() throws IOException, InterruptedException {
		
		String userDir = System.getProperty("user.dir");
		String execPath = userDir + "/cmdForGrid";

		Process proc = Runtime.getRuntime().exec("/usr/bin/open -a Terminal " + execPath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}

		proc.waitFor();

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		GridConfig obj = new GridConfig();
		obj.startGrid();
	}
}
