package com.practiceada.org;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_class {

	public static WebDriver driver;
	public static WebDriver  getBrowser(String browser) {
		try {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+("\\Driver\\chromedriver.exe"));
			 driver =new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", 
					System.getProperty("user.dir")+("\\Driver\\msedgedriver.exe"));
			driver =new EdgeDriver();
		}else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver",
					System.getProperty("user.dir")+("\\Driver\\operadriver.exe"));
			driver=new OperaDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}
 	public static void geturl(String value) {
		driver.get(value);
	}
	public static void inputOnElement(WebElement element,String value) {
	element.sendKeys(value);
	}
    public static void clickOnElement(WebElement element) {
	 element.click();
    }
	 public static void clearOnElement(WebElement element) {
	 element.clear();
     }  
     public static void close(WebDriver element){
    	 element.close();
     }
     public static void quit(WebDriver driver){
    	 driver.quit();
     }
     public static void navigateTo(WebDriver driver,String value) {
	driver.navigate().to(value);
     }
     public static void navigateBack(WebDriver driver) {
     driver.navigate().back();
     }
     public static void navigateForward(WebDriver driver) {
    	 driver.navigate().forward();
     }
     public static void navigateRefresh(WebDriver driver) {
    	 driver.navigate().refresh();
     }

     public static void getTitle(WebDriver driver) {
    	 driver.getTitle();
     }
     public static void getClass(WebDriver driver) {
    	 driver.getClass();
     }
     public static void getSize(WebElement element) {
    	 element.getSize();
     }
     public static void getText(WebElement element) {
    	 element.getText();
     }
     public static void getscreenshotas(WebElement element) {
    	 element.getScreenshotAs(OutputType.FILE);
     }
  
     public static void getPageSource(WebDriver driver) {
    	 driver.getPageSource();
     }
     public static void WindowsHandle(WebDriver driver) {
    	 driver.getWindowHandle();
     }
     public static void WindowsHandles(WebDriver driver) {
    	 driver.getWindowHandles();
     }
     public static void getAttributes(WebElement element,String value) {
    element.getAttribute(value);
     }
     public static void isEnabled(WebElement element) {
    	System.out.println(element.isEnabled());
     }
     public static void isSelected(WebElement element) {
    	 System.out.println(element.isSelected());
     }
     public static void isDisplayed(WebElement element) {
    	System.out.println(element.isDisplayed());
     }
     public static void framestring(WebDriver driver,String value) {
    	 driver.switchTo().frame(value);
     }
     public static void frameint(WebDriver driver) {
    	 driver.switchTo().frame(0);
     }
     public static void frameweb(WebDriver driver,String value) {
    	 driver.switchTo().frame(value);
     }
     public static void parentFrame(WebDriver driver) {
    	 driver.switchTo().parentFrame();
     }
     public static void defaultcontent(WebDriver driver) {
    	 driver.switchTo().defaultContent();
     }
     public static void alertaccept(WebDriver driver) {
    	 driver.switchTo().alert().accept();
     }
     public static void alertdismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
     
    //select
	 public static void dropDown(WebElement element,String Options,String Value ) {
	Select s =new Select(element);
	try {
		if(Options.equalsIgnoreCase("byIndex")) {
			int parseInt =Integer.parseInt(Value);
			s.selectByIndex(parseInt);
		}
		else if (Options.equalsIgnoreCase("byValue")) {
			s.selectByValue(Value);
		}
		else if (Options.equalsIgnoreCase("byVisibleText")) {
			s.selectByVisibleText(Value);
		}else if (Options.equalsIgnoreCase("deselect")) {
			s.deselectAll();
		}
		else if (Options.equalsIgnoreCase("deselectByIndex")) {
			s.deselectByIndex(0);
		}
        else if (Options.equalsIgnoreCase("deselectByIndex")) {
			s.deselectByValue(Value);
		}
        else if (Options.equalsIgnoreCase("deselectByVisibleText")) {
			s.deselectByVisibleText(Value);
		}
        else if (Options.equalsIgnoreCase("getAllSelectedOptions")) {
			s.getAllSelectedOptions();
		}
        else if (Options.equalsIgnoreCase("getFirstSelectedOption")) {
			s.getFirstSelectedOption();
		}
        else if (Options.equalsIgnoreCase("isMultiple")) {
			s.isMultiple();
		}
		else {
			System.out.println("Invalid Selection");
		}	
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}
	 }
	//Action
     public static void action(WebElement element , String  value , String Options ) {
     Actions ac =new Actions(driver);
     try {
     if (Options.equalsIgnoreCase("moveToElement")) {
		ac.moveToElement(element).build().perform();
	} 
     else if (Options.equalsIgnoreCase("doubleClick")) {
		ac.doubleClick(element).build().perform();
	}
     else if (Options.equalsIgnoreCase("contextClick")) {
		ac.contextClick(element);
	}
     else if (Options.equalsIgnoreCase("dragAndDrop")) {
 		ac.dragAndDrop(element, element);
	}
     else {
    System.out.println("invalid actions");
	}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
     }
     
   public static void scrollupdown(WebDriver driver,String value) {
	   JavascriptExecutor js=(JavascriptExecutor) Base_class.driver;
	   js.executeScript("arguments[0].scrollIntoView", driver);
   }
   public static void implicityWait(WebDriver driver) {
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
   public static void explicitywait(WebElement element) {
	   WebDriverWait explicitywait =new WebDriverWait(driver, 5);
	   explicitywait.until(ExpectedConditions.visibilityOf(element));
	   
   }
	
}

