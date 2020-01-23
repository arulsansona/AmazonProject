package wrappers;

import org.junit.Before;

public class ProjectWrappers extends GenericWrappers{
	
	@Before
	public void launchIRTC(){
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
	}
	
	/*@AfterTest
	public void closeIRTC(){
	closeAllBrowsers();
	}*/
}