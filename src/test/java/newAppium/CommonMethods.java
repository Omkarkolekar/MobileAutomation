package newAppium;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonMethods {

	public static AndroidDriver<AndroidElement>  driver;
	
	public CommonMethods(AndroidDriver<AndroidElement> driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }   
	  
	public void swipe(String element1, String element2) {

			@SuppressWarnings("rawtypes")
			TouchAction t=new TouchAction(driver);
			//long press //on element// 2 sec// move to another element and you release
			WebElement first= driver.findElementByXPath(element1);
			WebElement second= driver.findElementByXPath(element2);

			t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		}
		
	public void tap(String element1) {
			TouchAction t=new TouchAction(driver);
			WebElement ele=driver.findElementByXPath(element1);
			t.tap(tapOptions().withElement(element(ele))).perform();
		}
	  
	/*
	 * public void findElement(AndroidElement element) {
	 * 
	 * driver.findElement((By) ); }
	 */
}
