/**
 * 
 */
package wrappers;

public interface Wrappers {
	
	public void invokeApp(String browser, String url);
	
	public void enterById(String idValue, String data);

	public void enterByName(String nameValue, String data) ;	

	public void enterByXpath(String xpathValue);

	public void verifyTitle(String title);

	public void verifyTextById(String id, String text);
	
	public void verifyTextByXpath(String xpath, String text);
	
	public void verifyTextContainsByXpath(String xpath, String text);

	public void clickById(String id) ;
	
	public void clickByClassName(String classVal);
	
	public void clickByName(String name) ;

	public void clickByLink(String name);
	
	public void clickByLinkNoSnap(String name);
	
	public void clickByXpath(String xpathVal);
	
	public void clickByXpathNoSnap(String xpathVal);

	public String getTextById(String idVal);

	public String getTextByXpath(String xpathVal);

	public void selectVisibileTextById(String id, String value);
	
	public void selectIndexById(String id, int value);
	
	public void switchToParentWindow();
	
	public void switchToLastWindow();
	
	public void acceptAlert();
	
	public void dismissAlert();
	
	public String getAlertText();
	
	public void takeSnap();
	
	public void closeBrowser();
	
	public void closeAllBrowsers();
	
	public void selectVisibeByXPath();
	
	public void keypressbyxpath(String xpath);
 
}

