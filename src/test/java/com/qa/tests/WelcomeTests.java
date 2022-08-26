package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.WelcomePage;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class WelcomeTests extends BaseTest{
	WelcomePage welcomePage;
	HomePage homePage;
	JSONObject testdata;
	TestUtils utils = new TestUtils();
	
	  @BeforeClass
	  public void beforeClass() throws Exception {
			InputStream datais = null;
		  try {
			  String dataFileName = "data/testdata.json";
			  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			  JSONTokener tokener = new JSONTokener(datais);
			  testdata = new JSONObject(tokener);
		  } catch(Exception e) {
			  e.printStackTrace();
			  throw e;
		  } finally {
			  if(datais != null) {
				  datais.close();
			  }
		  }
		  closeApp();
		  launchApp();
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
		  welcomePage = new WelcomePage();
		  homePage = new HomePage();
	  }

	  @AfterMethod
	  public void afterMethod() {		  
	  }
	  
	  @Test(priority = 1)
	  public void verifyWelcomeMessage() {
		  welcomePage.pressAllow();
		  String actualErrTxt = welcomePage.getwelcomeTxt();
		  String expectedErrTxt = testdata.getJSONObject("welcome").getString("welcome_message");
		  Assert.assertEquals(actualErrTxt, expectedErrTxt);
	  }
	  
	  @Test(priority = 2)
	  public void verifyExploreWithoutLogin() {
		  welcomePage.pressExplorerBtn();
		  String actualTxt = homePage.getProfiletxt();
		  String expectedTxt = testdata.getJSONObject("welcome").getString("profile_WithoutLogin");
		  Assert.assertEquals(actualTxt, expectedTxt);
	  }
}
