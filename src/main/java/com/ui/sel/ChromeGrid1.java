package com.ui.sel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.util.gridstart.GridConfig;
import com.util.gridstart.GridConfig.GridOperations;

public class ChromeGrid1 {

	@BeforeTest
	public void BeforeTest() throws IOException, InterruptedException
	{
		GridConfig.performGridoperations(GridOperations.STARTGRID);
		GridConfig.performGridoperations(GridOperations.SCALECHROME);
	}
	
	@AfterTest
	public void AfterTest() throws IOException, InterruptedException
	{
		GridConfig.performGridoperations(GridOperations.STOPGRID);
		GridConfig.performGridoperations(GridOperations.CLEARLOGFILE);
	}
	
	
	@Test
	void Test1() throws MalformedURLException {

		RemoteWebDriver r_driver;
		String remote_url_chrome = "http://localhost:4444/wd/hub";

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		r_driver = new RemoteWebDriver(new URL(remote_url_chrome), chromeOptions);
		r_driver.get("https://www.google.com/");
		System.out.println("GRID 1 : " + r_driver.getTitle());

	}

}
