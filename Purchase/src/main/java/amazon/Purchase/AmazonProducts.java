package amazon.Purchase;

import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Enter;
import wrappers.GenericWrappers;

public class AmazonProducts extends GenericWrappers{
	
	public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
	Thread.sleep(5000);
	
	driver.findElementByXPath("//*[@id='twotabsearchtextbox']").sendKeys("Apple iPhone XR (64GB) - Yellow");
	
	Thread.sleep(5000);
	driver.findElementByXPath("//*[@id='nav-search']/form/div[2]/div/input").click();
	Thread.sleep(5000);
	driver.findElementByXPath("//*[@id='search']/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a").click();
	
	
	Thread.sleep(5000);
	
	String amazon_price = driver.findElementByXPath("//*[@id='priceblock_dealprice_row']").getText();
	
    
    System.out.println(amazon_price);
    //System.out.println(flipcart_price);
    
    driver.get("https://www.flipkart.com/");
    driver.manage().window().maximize();
	Thread.sleep(5000);
	
	driver.findElementByXPath("/html/body/div[2]/div/div/button").click();
	
	driver.findElementByXPath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input").sendKeys("Apple iPhone XR (64GB) - Yellow");
	
	Thread.sleep(5000);
	driver.findElementByXPath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/button").click();
	
	Thread.sleep(5000);
	String flipcart_price = driver.findElementByXPath("//*[@id='container']/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div/div/div").getText();

    String amazon_price_removecurrencysymbol = amazon_price.substring(1,amazon_price.length());
    String flipcart_price_removecurrencysymbol = flipcart_price.substring(1,flipcart_price.length());


   System.out.println(amazon_price_removecurrencysymbol);
   System.out.println(flipcart_price_removecurrencysymbol);

   int difference = Integer.parseInt(amazon_price_removecurrencysymbol) -Integer.parseInt(flipcart_price_removecurrencysymbol);
   System.out.println("Difference is:"+difference);
	}
}
