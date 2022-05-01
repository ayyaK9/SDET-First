package com.ui.sel;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandaloneTest {

	public static void main(String[] args) throws MalformedURLException {

		RemoteWebDriver r_driver;
		String remote_url_chrome = "http://localhost:4444/wd/hub";
		

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);	
		r_driver = new RemoteWebDriver(new URL(remote_url_chrome), chromeOptions);
		r_driver.get("https://www.google.com/");
		System.out.println(r_driver.getTitle());

	}
}
