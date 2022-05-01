package com.ui.sel;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FFStandaloneTest {
	public static void main(String[] args) throws MalformedURLException {
		RemoteWebDriver r_driver;

		String remote_url_ff = "http://localhost:4445/wd/hub";

		FirefoxOptions options = new FirefoxOptions();

		r_driver = new RemoteWebDriver(new URL(remote_url_ff), options);

		r_driver.get("https://www.google.com/");
		System.out.println(r_driver.getTitle());
	}
}
