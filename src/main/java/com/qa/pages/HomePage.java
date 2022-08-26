package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BaseTest {

	TestUtils utils = new TestUtils();
	@AndroidFindBy (id = "com.scaler.app:id/tvName")
	@iOSXCUITFindBy (id = "com.scaler.app:id/tvName")
	private MobileElement profileTitle;

	@AndroidFindBy (xpath = "//*[@resource-id='com.scaler.app:id/rvCollection']/*[@resource-id='com.scaler.app:id/item_collection'][1]//*[@resource-id='com.scaler.app:id/secondary_cta']")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private MobileElement linkAll;


public String getProfiletxt() {
	String welcome_message = getText(profileTitle, "profile name");
	return welcome_message;
}

	public void pressAll() {
		click(linkAll, "press All button");
	}

}
