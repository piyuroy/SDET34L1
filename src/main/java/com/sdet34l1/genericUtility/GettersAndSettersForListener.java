package com.sdet34l1.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

public class GettersAndSettersForListener {
	public WebDriver driver;
	public String browser;
	public String username;
	public String password;
	public long longTimeOut;
	public int randomnumber;
	public LoginPage login;
	public HomePage homepage;
	public WebDriverUtilities webdriverutilities;
	public WebDriverWait wait;
	public Actions action;
	public WebDriver getDriver() {
		return driver;
	}
	public String getBrowser() {
		return browser;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public long getLongTimeOut() {
		return longTimeOut;
	}
	public int getRandomnumber() {
		return randomnumber;
	}
	public LoginPage getLogin() {
		return login;
	}
	public HomePage getHomepage() {
		return homepage;
	}
	public WebDriverUtilities getWebdriverutilities() {
		return webdriverutilities;
	}
	public WebDriverWait getWait() {
		return wait;
	}
	public Actions getAction() {
		return action;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setLongTimeOut(long longTimeOut) {
		this.longTimeOut = longTimeOut;
	}
	public void setRandomnumber(int randomnumber) {
		this.randomnumber = randomnumber;
	}
	public void setLogin(LoginPage login) {
		this.login = login;
	}
	public void setHomepage(HomePage homepage) {
		this.homepage = homepage;
	}
	public void setWebdriverutilities(WebDriverUtilities webdriverutilities) {
		this.webdriverutilities = webdriverutilities;
	}
	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
	public void setAction(Actions action) {
		this.action = action;
	}
	

}
