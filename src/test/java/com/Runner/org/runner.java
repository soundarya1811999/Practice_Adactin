package com.Runner.org;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.login.properties.File_Reader_Manager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features  = "src\\test\\java\\com\\practiceada\\org\\Practice.feature",
                   glue    = "com\\loginstepdefinition\\org",
              monochrome   = true)
                        
public class runner {
	public static WebDriver driver;
	@BeforeClass
	public static void setup() throws Throwable {
		  String browser =File_Reader_Manager.getInstance().getInstanceCR().getbrowser();
          driver =com.practiceada.org.Base_class.getBrowser(browser);
	}
	


}
