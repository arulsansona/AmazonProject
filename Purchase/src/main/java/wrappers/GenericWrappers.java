package wrappers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;



public class GenericWrappers implements Wrappers{
		RemoteWebDriver driver;

		public void invokeApp(String browser, String url) {
			try {
				if (browser.equalsIgnoreCase("chrome")) {
					System.out.println("1111");
					System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
					 driver=new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			}else if (browser.equalsIgnoreCase("ie")) {
					System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				driver.manage().window().maximize();
				driver.get(url);
				System.out.println("The Chrome Browser "+url+" was launched successfully");
			} catch (SessionNotCreatedException e) {
				// TODO Auto-generated catch block
				System.err.println("The Browser "+browser+" not launched due to session not created error");
			}catch (WebDriverException e) {
				// TODO: handle exception
				System.err.println("The Browser "+browser+" got closed due to unknown exection");
			}finally {
				takeSnap();
			}
			
		}

		public void enterById(String idValue, String data) {
			try {
				driver.findElementById(idValue).sendKeys(data);
				System.out.println("The element with ID Value "+idValue+" was entered with value "+data+" successfully");
			} catch (NoSuchElementException e) {
				System.err.println("The element with ID Value "+idValue+" was not found");
			}catch (ElementNotInteractableException e) {
				System.err.println("The element with ID Value"+idValue+" was not interactable");
			}catch (StaleElementReferenceException e) {
				System.err.println("The element "+idValue+" was not stable");
			}catch (WebDriverException e) {
				System.err.println("The browser got closed due to unknow exception");
			}finally {
				takeSnap();
			}
		}
			
		public void enterByName(String nameValue, String data) {
			try{
				driver.findElementByName(nameValue).sendKeys(data);
				System.out.println("The Element with Name Value"+nameValue+" was entered with "+data+"Successfully");
			}catch(NoSuchElementException e){
				System.err.println("The Element with Name Value"+nameValue+"was not found");
			}catch (ElementNotInteractableException e) {
				System.out.println("The Element"+nameValue+"was not Interactable");
			}catch (StaleElementReferenceException e) {
				System.out.println("The Element"+nameValue+"was not Stable");
			}catch (WebDriverException e) {
				System.out.println("The Browser got closed due to unknow Exceptions");
			}finally {
				takeSnap();
			}
			
		}

		public void enterByXpath(String xpathValue, String data) {
			try{
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The Element with XpathValue"+xpathValue+"was enetered with"+data+"Successfully");
			}catch(NoSuchElementException e){
				System.out.println("The Element withCpthaValue"+xpathValue+"was not found");
			}catch (StaleElementReferenceException e) {
				System.out.println("The Element"+xpathValue+"was not stable");
			}catch (WebDriverException e) {
				System.out.println("The Browser got closed due to unknow exceptions ocurred");
			}finally{
				takeSnap();
			}
		}

		public void verifyTitle(String title) {
			try{
				String actualTitle = driver.getTitle();
				if (title.equals(actualTitle)){
					System.out.println("The "+title+"is equal to title");
				}else{
					System.out.println("The "+title+"is not equal to "+title+", ");
			}
			}catch(NoSuchElementException e){
				System.out.println("Actual Title is not available");
			}catch(WebDriverException e){
				System.out.println("browser closed due to unknonw error");
			}
	}
		public void verifyTextById(String id, String text) {
			try{
				driver.findElementById(id).sendKeys(text);
				System.out.println("The ID was "+id+" is verified with"+text+"Successfully");
			}catch(NoSuchElementException e){
				System.out.println("The "+id+" is not found as per "+text+" also");
			}catch(StaleElementReferenceException e) {
				System.out.println("This "+id+" is not stable");
			}catch(WebDriverException e){
				System.err.print("Browser closed due to unknow error");
			}
			
		}

		public void verifyTextByXpath(String xpath, String text) {
			try{
				driver.findElementById(xpath).sendKeys(text);
				System.out.println("The ID was "+xpath+" is verified with"+text+"Successfully");
			}catch(NoSuchElementException e){
				System.out.println("The "+xpath+" is not found as per "+text+" also");
			}catch(StaleElementReferenceException e) {
				System.out.println("This "+xpath+" is not stable");
			}catch(WebDriverException e){
				System.err.print("Browser closed due to unknow error");
			}
		}

		public void verifyTextContainsByXpath(String xpath, String text) {
			try{
				driver.findElementById(xpath).sendKeys(text);
				System.out.println("The ID was "+xpath+" is verified with"+text+"Successfully");
			}catch(NoSuchElementException e){
				System.out.println("The "+xpath+" is not found as per "+text+" also");
			}catch(StaleElementReferenceException e) {
				System.out.println("This "+xpath+" is not stable");
			}catch(WebDriverException e){
				System.err.print("Browser closed due to unknow error");
			}
		}

		public void clickById(String id) {
			try{
				driver.findElementById(id).click();
				System.out.println("The ID was "+id+" is clicked");
			}catch(NoSuchElementException s){
				System.out.println("The ID is "+id+" is not found");
			}catch(StaleElementReferenceException s){
				System.out.println("ID is "+id+" id Duplicate or Not Stable");
			}catch (WebDriverException e) {
				System.out.println("Browser Closed Due to unknow Exception");
			}
			
		}

		public void clickByClassName(String classVal) {
			try{
				driver.findElementById(classVal).click();
				System.out.println("The classVal was "+classVal+" is clicked");
			}catch(NoSuchElementException s){
				System.out.println("The classVal is "+classVal+" is not found");
			}catch(StaleElementReferenceException s){
				System.out.println("classVal is "+classVal+"Duplicate or Not Stable");
			}catch (WebDriverException e) {
				System.out.println("Browser Closed Due to unknow Exception");
			}
		}

		public void clickByName(String name) {
			try{
				driver.findElementByXPath(name).click();
				System.out.println("The Element with Name"+name+"was clicked Successfully");
			}catch(NoSuchElementException e){
				System.out.println("The Element with Name"+name+"is not found");
			}catch (StaleElementReferenceException e) {
				System.out.println("The Element with Name"+name+"is not Stable");
			}catch (WebDriverException e) {
				System.out.println("WebDriver is closed due to unknown Exception");
			}finally{
				takeSnap();
			}
		}

		public void clickByLink(String name) {
			try{
				driver.findElementByXPath(name).click();
				System.out.println("The Link Name"+name+"was clicked Successfully");
			}catch(NoSuchElementException e){
				System.out.println("The Link Name"+name+"is not found");
			}catch (StaleElementReferenceException e) {
				System.out.println("The Link Name"+name+"is not Stable");
			}catch (WebDriverException e) {
				System.out.println("WebDriver is closed due to unknown Exception");
			}finally{
				takeSnap();
			}
		}

		public void clickByLinkNoSnap(String name) {
			try{
				driver.findElementByXPath(name).click();
				System.out.println("The Click xpath "+name+"was clicked Successfully");
			}catch(NoSuchElementException e){
				System.out.println("The Link xpath"+name+"is not found");
			}catch (StaleElementReferenceException e) {
				System.out.println("The Link xpath"+name+"is not Stable");
			}catch (WebDriverException e) {
				System.out.println("WebDriver is closed due to unknown Exception");
			}finally{
				takeSnap();
			}
		}

		public void clickByXpath(String xpathVal) {
			try{
				driver.findElementByXPath(xpathVal).click();
				System.out.println("The Element with XpathValue"+xpathVal+"was clicked Successfully");
			}catch(NoSuchElementException e){
				System.out.println("The Element with XpathValue"+xpathVal+"is not found");
			}catch (StaleElementReferenceException e) {
				System.out.println("The Element with XpathVAlue"+xpathVal+"is not Stable");
			}catch (WebDriverException e) {
				System.out.println("WebDriver is closed due to unknown Exception");
			}finally{
				takeSnap();
			}
			
		}

		public void clickByXpathNoSnap(String xpathVal) {
			// TODO Auto-generated method stub
			
		}

		public String getTextById(String idVal) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getTextByXpath(String xpathVal) {
			// TODO Auto-generated method stub
			return null;
		}

		public void selectVisibileTextById(String id, String value) {
			try{
				driver.findElementById(id).sendKeys(value);
				System.out.println("The Element with"+id+"is entered  successfully");
			}catch(NoSuchElementException e){
				System.out.println("The Element with"+id+" is not found");
			}catch (ElementNotVisibleException e) {
				System.out.println("ID "+id+"is not Visible");
			}catch (WebDriverException e ) {
				System.out.println("Browser got closed due to unknown exception");
			}
			
		}
		
		public void selectVisibeByXPath(String xpathVal, String data){
			try{
				WebElement objst = driver.findElementByXPath(xpathVal);
				Select obj1 = new Select(objst);
				obj1.selectByVisibleText(data);
			
				System.out.println("The Element with"+xpathVal+"is entered  successfully");
			}catch(NoSuchElementException e){
				System.out.println("The Element with"+xpathVal+" is not found");
			}catch (ElementNotVisibleException e) {
				System.out.println("ID "+xpathVal+"is not Visible");
			}catch (WebDriverException e ) {
				System.out.println("Browser got closed due to unknown exception");
			}
			
		}

		public void selectIndexById(String id, int value) {
			// TODO Auto-generated method stub
			
		}

		public void switchToParentWindow() {
			try {
				Set<String>cc=driver.getWindowHandles();
				for (String lastwin : cc) {
					driver.switchTo().window(lastwin);
					break;
				}
				System.out.println("Now it is in parent window");
			}catch(NoSuchWindowException e){
				System.err.println("No window Found");
			}catch (SessionNotCreatedException e) {
				System.err.println("Session not created this time");
			}catch (WebDriverException e) {
				System.err.println("Browser closed due to unknown session");
			}finally {
				takeSnap();
			}
			
		}

		public void switchToLastWindow() {
			try {
				Set<String>allWinId=driver.getWindowHandles();
				for (String lastwin : allWinId) {
					driver.switchTo().window(lastwin);
				}
				System.out.println("Now it is in Last window");
			}catch(NoSuchWindowException e){
				System.out.println("No window Found");
			}catch (SessionNotCreatedException e) {
				System.out.println("Session not created this time");
			}catch (WebDriverException e) {
				System.err.println("Browser closed due to unknown session");
			}finally {
				takeSnap();
			}
		}

		public void acceptAlert() {
			try{
				driver.switchTo().alert().accept();
				System.out.println("Alert Accepted");
			} catch (NoAlertPresentException e) { // Alert not present
		        e.printStackTrace();
		    }finally {
				driver.close();
			}
			
		}

		public void dismissAlert() {
			try{
				driver.switchTo().alert().dismiss();
				System.out.println("Alert Rejected");
			}catch(StaleElementReferenceException e){
				System.out.println("Alert is not stable");
			}catch (NoAlertPresentException e) {
				System.out.println("No Alert Present in this method");
			}
			finally {
				driver.close();
			}
		}

		public String getAlertText() {
			// TODO Auto-generated method stub
			return null;
		}

		public void takeSnap(){
			try{
				File temp = driver.getScreenshotAs(OutputType.FILE);
				File desti = new File("./Screenshot/Arul.png");
				FileUtils.copyFile(temp, desti);	
			}catch(FileNotFoundException e){
				System.out.println("File Not Found in this Path");
			} catch (IOException e) {
				System.out.println("Screenshot is not available in this path");
				e.printStackTrace();
			}catch (WebDriverException e) {
				System.err.println("browser got closed automatiocally due to unknown Exception");
			}
		}

		public void closeBrowser() {
			try{
				driver.close();
				System.out.println("Broswer got closed Successfully");
			}catch(WebDriverException e){
				System.err.println("Browser got closed automatically due to unknown Exception");
			}
		}

		public void closeAllBrowsers() {
			try{
				driver.quit();
				System.out.println("Broswer got closed Successfully");
			}catch(WebDriverException e){
				System.out.println("Browser closed due unknow Error");
			}
			
		}

		public void enterByXpath(String xpathValue) {
			// TODO Auto-generated method stub
			
		}
		public void keypressbyxpath(String xpath) {
			// TODO Auto-generated method stub
			driver.findElementByXPath(xpath).sendKeys(Keys.TAB);
		}
		public void threadSleepWait() throws InterruptedException{
			Thread.sleep(5000);
		
		}

		public void selectVisibeByXPath() {
			// TODO Auto-generated method stub
			
		}
		
		}
