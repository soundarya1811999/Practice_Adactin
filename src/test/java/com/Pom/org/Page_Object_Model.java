package com.Pom.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Object_Model {
	
	public static WebDriver driver;

	@FindBy(id ="username")
	private WebElement name;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(xpath ="//input[@type='Submit']")
	private WebElement login;

	
	public Page_Object_Model(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	public WebElement getName() {
		return name;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
}
