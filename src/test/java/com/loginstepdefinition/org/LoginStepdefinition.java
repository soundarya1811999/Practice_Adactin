package com.loginstepdefinition.org;

import org.openqa.selenium.WebDriver;

import com.Pom.org.Page_Object_Model;
import com.Runner.org.runner;
import com.login.properties.File_Reader_Manager;
import com.practiceada.org.Base_class;

import cucumber.api.java.en.*;

public class LoginStepdefinition extends Base_class {
	public static WebDriver driver = runner.driver;
	Page_Object_Model p = new Page_Object_Model(driver);

	@Given("^user wants to Login Application$")
	public void user_wants_to_Login_Application() throws Throwable {
      String url =File_Reader_Manager.getInstance().getInstanceCR().geturl();
      geturl(url);
	}

	@When("^user enter username$")
	public void user_enter_username() throws Throwable {
		inputOnElement(p.getName(), "soundaryaharini18");
	}

	@When("^user enter password$")
	public void user_enter_password() throws Throwable {
		inputOnElement(p.getPassword(), "Sun5hin@");
	}

	@Then("^user validate login button$")
	public void user_validate_login_button() throws Throwable {
		clickOnElement(p.getLogin());
	}
}
