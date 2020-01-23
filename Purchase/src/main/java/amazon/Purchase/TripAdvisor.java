package amazon.Purchase;

import org.openqa.selenium.chrome.ChromeDriver;

import wrappers.GenericWrappers;

public class TripAdvisor extends GenericWrappers{
	
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.tripadvisor.in/");
	Thread.sleep(5000);
	driver.manage().window().maximize();	 
	
	driver.findElementByXPath("//*[@id='component_13']/div/div/div/div[2]/div/div[3]/div[5]/div").click();
	
	Thread.sleep(5000);
	driver.findElementByXPath("//*[@id='component_4']/div/div/form/input[1]").sendKeys("Club Mahindra");
	driver.findElementByXPath("//*[@id='SEARCH_BUTTON']").click();
	
	//*[@id="SEARCH_BUTTON_CONTENT"]/div
	
	}

}