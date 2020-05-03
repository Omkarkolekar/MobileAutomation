package newAppium;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class Apidemos extends BaseClass{


	/*
	 * public Apidemos(AndroidDriver driver) { super(driver); // TODO Auto-generated
	 * constructor stub }
	 */

	public static void main (String args[]) throws Exception{ 
		try {
			capabilitiesPixel81(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
			//  Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

			//  Thread.sleep(10000); //boolean a
			driver.findElementById("android:id/checkbox").isDisplayed();//click();
			//System.out.println("aaaa==="+a);

			//driver.findElementByAndroidUIAutomator("resource-id(\"android:id/checkbox\")").click();

			// driver.findElementByAndroidUIAutomator("text(\"Views\")").click();


			// driver.findElementById("android:id/checkbox").click(); 
			//  Thread.sleep(3000);
			driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
			Thread.sleep(3000);
			driver.findElementByClassName("android.widget.EditText").sendKeys("hello");

			Thread.sleep(3000);
			driver.findElementsByClassName("android.widget.Button").get(1).click();

			/*
			 * driver.findElementByAndroidUIAutomator("text(\"Views\")").click(); //
			 * driver.findElementByAndroidUIAutomator("text(\"Views\")").click(); //
			 * Validate clickable feature for all options 
			 * // driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
			 * System.out.println(driver.
			 * findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
			 */			  



		}catch(Exception a) {
			a.printStackTrace();
		}
	}

}

//*[@class='android.widget.TextView'][1]
//*[@text='Accessibility Node Querying']

//android.widget.TextView[contains(@text='Accessibility Node Querying')]