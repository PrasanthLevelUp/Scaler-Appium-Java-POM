package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WelcomePage extends BaseTest {

	TestUtils utils = new TestUtils();
	@AndroidFindBy (id = "com.scaler.app:id/btnExploreApp")
	@iOSXCUITFindBy (id = "com.scaler.app:id/btnExploreApp")
	private MobileElement btnExplore;

	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Welcome to Scaler']")
	@iOSXCUITFindBy (id = "test-Password")
	private MobileElement txtWelcome;

	@AndroidFindBy (id = "com.android.permissioncontroller:id/permission_allow_button")
	@iOSXCUITFindBy (id = "test-Password")
	private MobileElement btnAllow;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private MobileElement errTxt;


	public void pressAllow() {
		click(btnAllow, "press Allow button");
	}

public HomePage pressExplorerBtn() {
	click(btnExplore, "press Explore button");
	return new HomePage();
}

public String getwelcomeTxt() {
	String welcome_message = getText(txtWelcome, "welcome message");
	return welcome_message;
}

}
