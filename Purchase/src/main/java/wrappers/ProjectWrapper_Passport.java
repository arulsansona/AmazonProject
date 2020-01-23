package wrappers;

import org.junit.Before;

public class ProjectWrapper_Passport extends GenericWrappers{		
		@Before
		public void launchIRTC(){
			invokeApp("chrome", "https://indianfrro.gov.in/frro/FormC/menuuserreg.jsp");
		}
		
		/*@AfterTest
		public void closeIRTC(){
		closeAllBrowsers();
		}*/
}
