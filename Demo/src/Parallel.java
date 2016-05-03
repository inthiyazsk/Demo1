import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel{

 private  WebDriver driver=null;

 @Parameters ({"BROWSER"})
 @BeforeTest

 public void setup(String BROWSER){
  System.out.println("Browser: " + BROWSER);
  if (BROWSER.equals("FF")) {
	   System.out.println(BROWSER+" is selected");
	   driver = new FirefoxDriver();

		 driver.get("https://ood.mmbresearch.com/testlink/login.php?");
		 
	  } else if (BROWSER.equals("IE")) {
		   System.out.println("IE Browser is selected");
		  System.setProperty("webdriver.ie.driver","C:\\Selenium\\IEDriverServer.exe");
		   DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		      capabilities.setCapability("initialBrowserUrl","https://ood.mmbresearch.com/testlink/login.php?");
		  driver = new InternetExplorerDriver(capabilities); 
		  
	  } else if (BROWSER.equals("CH")){
	 
		  System.setProperty("webdriver.ie.driver", "C:\\Selenium\\chromedriver.exe");
	   System.out.println("Google chrome is selected");
	    driver = new ChromeDriver();

		 driver.get("https://ood.mmbresearch.com/testlink/login.php?");
	   
	  }
	  else if (BROWSER.equals("SF")){  
		   System.out.println("Safari is selected");
		   driver = new SafariDriver();

			 driver.get("https://ood.mmbresearch.com/testlink/login.php?");
		   
		  }
	 }
 
 
 @Test
 public  void testParallel()throws Exception{
	 //PSI_Application.waitForElementPresent(driver.getTitle(),5000);
	  if(driver.getTitle().equalsIgnoreCase("TestLink"))
       {
       // Find the text input element by its type
        
       driver.findElement(By.xpath("//input[@type='text']")).sendKeys("primesoft");
       Thread.sleep(5000);
      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("primesoft123");
      Thread.sleep(5000);
      Thread.sleep(5000);
      Thread.sleep(5000);
      Thread.sleep(5000);
     driver.findElement(By.xpath("//*[@type='submit']")).click();
     if(driver.getTitle().equalsIgnoreCase("TestLink 1.9.9(Lone Ranger)"))
     {
   	 System.out.println("Waiting for page to load fully...");
   	Thread.sleep(3000);  
     }
    else
      {
      	System.out.println("Not able to find the page");
      	
      }
    
       }
       else
       {
       	System.out.println("Not able to find the page");
       	
       }
     
	Thread.sleep(5000);
	Thread.sleep(5000);
  driver.quit();

 }
}
