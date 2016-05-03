import org.openqa.selenium.server.*;
import com.thoughtworks.selenium.*;
public class MyFile {
	static String Url="http://127.0.0.1";
	static String Un="Cheese";
	
	public static void main(String args[])throws Exception
	{
		//SeleniumServer objserver=new SeleniumServer();
		Selenium objselenium=new DefaultSelenium("localhost",4444,"*firefox",Url);
	//objserver.start();
		objselenium.start();
		objselenium.windowMaximize();
		
		objselenium.open("http://google.com");
		objselenium.waitForPageToLoad("150000");
		if(objselenium.getTitle().equalsIgnoreCase("Google"))
		{
			System.out.println("Home page Displayed Successfuly");
			objselenium.type("q", Un);
			
			objselenium.click("btnK");
			objselenium.waitForPageToLoad("80000");
		}
		else
		{
			System.out.println("page not Displayed");
		}
	
			objselenium.stop();
		//objserver.stop();
		
	}
		
	}
