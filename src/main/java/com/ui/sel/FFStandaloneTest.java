package com.ui.sel;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FFStandaloneTest {
	
	@Test
	public void FFTest() throws MalformedURLException
	{
		RemoteWebDriver r_driver;

		String remote_url_ff = "http://localhost:4444/wd/hub";

		FirefoxOptions options = new FirefoxOptions();

		r_driver = new RemoteWebDriver(new URL(remote_url_ff), options);

		r_driver.get("https://www.google.com/");
		System.out.println("Grid 4: Fire fox "+r_driver.getTitle());
	}
	
}
