package newAppium;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CentralObjects {
	
	

	public CentralObjects(AndroidDriver<AndroidElement> driver) {
		//super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Views']")
	public static AndroidElement views;

	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Date Widgets']")
	public AndroidElement viewsDateWidgets;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Preference']")
	public AndroidElement preference;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Expandable Lists']")
	public AndroidElement expandableLists;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='1. Custom Adapter']")
	public AndroidElement customAdapter;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='People Names']")
	public AndroidElement peopleNames;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Date Widgets']")
	public AndroidElement dateWidgets;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='2. Inline']")
	public AndroidElement inline;
	
	///types of xpath
	
	/*
	 * Xpath=//*[contains(@type,'sub')]
	 * Xpath=//*[@class='featured-box']//*[text()='Testing']
	 * Xpath=//*[contains(text(),'here')] 
	 * Xpath=//*[contains(@href,'guru99.com')]
	 * Xpath=//*[contains(@id,'message')] 
	 * Xpath=//*[@type='submit'or @name='btnReset']
	 * Xpath=//input[@type='submit' and @name='btnLogin']
	 * Xpath=//input[@type='submit' and @name='btnLogin']
	 * Xpath=//td[text()='UserID'] 
	 * Xpath=//*[@type='text']//following::input
	 * Xpath=//*[text()='Enterprise Testing']//ancestor::div[1]
	 * Xpath=//*[@id='java_technologies']//child::li[1]
	 * Xpath=//*[@type='submit']//preceding::input
	 * xpath=//*[@type='submit']//following-sibling::input
	 * Xpath=//*[@id='rt-feature']//parent::div 
	 * Xpath=//*[@type='password']//self::input
	 * Xpath=//*[@id='rt-feature']//descendant::a[1]
	 *
	 */
	
}
