package newAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.android.nativekey.AndroidKey;

import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import static io.appium.java_client.touch.TapOptions.tapOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static java.time.Duration.ofSeconds;

import java.io.File;

public class ecommerceTcs extends BaseClass {

	public static AndroidDriver<AndroidElement> driver;

	@SuppressWarnings("rawtypes")
	static AppiumDriverLocalService appiumService;
	static String appiumServiceUrl;
	// public static CentralObjects elements = new CentralObjects(driver);

	@BeforeMethod()
	public void startAppiumServer() throws MalformedURLException {
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
		System.out.println("Appium Service Address : - " + appiumServiceUrl);

		/*
		 * File folder = new File("log"); if(!folder.exists()) { folder.mkdir(); } File
		 * logFile = new File(folder, "UDID" +System.currentTimeMillis()+ ".log");
		 * appiumService = AppiumDriverLocalService.buildService(new
		 * AppiumServiceBuilder().withLogFile(logFile));
		 */
	}

	@AfterMethod()
	public void stopAppiumServer() throws MalformedURLException {
		appiumService.stop();
	}

	@Test(enabled = true)
	public void amazontest() throws MalformedURLException, InterruptedException {

		File appDir = new File(System.getProperty("user.dir"));
//		File app = new File(appDir, "Amazon.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_27_8.1");
//		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.micron.StartupActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		driver.installApp("G:\\Java\\WorkspaceNew\\Mobiletest\\Amazon.apk");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
	
		driver.findElementByAndroidUIAutomator("text(\"Skip sign in\")").click();
		//driver.findElement(By.xpath("android.widget.Button[@text='Skip sign in']")).click();
		//driver.findElement(By.id("in.amazon.mShop.android.shopping:id/search_bar_plate")).click();
		//driver.findElement(By.id("in.amazon.mShop.android.shopping:id/search_auto_text")).sendKeys("Huggies diaper");
		Thread.sleep(2000);
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/action_bar_burger_icon")).click();
		//driver.findElementByAndroidUIAutomator("in.amazon.mShop.android.shopping:id/action_bar_burger_icon").click();
		Thread.sleep(2000);
		driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		
		Assert.assertEquals(driver.findElementByAndroidUIAutomator("text(\"Shop by Category\")").getText().toString(), "Shop by Category");
		driver.findElementByAndroidUIAutomator("text(\"Shop by Category\")").click();
	
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//android.view.View[@text='TV, Appliances, Electronics']/..")).getText().toString(), "TV, Appliances, Electronics");
		driver.findElement(By.xpath("//android.view.View[@text='TV, Appliances, Electronics']/..")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//android.view.View[@text='Televisions']")).getText().toString(), "Televisions");
		driver.findElement(By.xpath("//android.view.View[@text='Televisions']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.FrameLayout[1][@text='Vu(32)HD Ready Smart TV']")).click();
		
		
		/*
		 * @SuppressWarnings("unchecked") List<AndroidElement> optionsToSelect =
		 * driver.findElements(By.xpath("//android.widget.FrameLayout[1]"));
		 * 
		 * System.out.println("size==="+optionsToSelect.size());
		 * 
		 * for(AndroidElement option : optionsToSelect){ // // //
		 * 
		 * System.out.println("Trying to select: "+option.toString()); //
		 *  }
		 */
		 
		 
		
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Huggies diaper\"));").click();
		
		
		//AndroidElement autoOptions = driver.findElementByAndroidUIAutomator("android.widget.LinearLayout");
		//driver.findElementByAndroidUIAutomator("text(\"Huggies diapers\")").click();
		//*[@text='Huggies diapers'] 
		
		//tap("//android.widget.LinearLayout[@text='Huggies diapers']");
		
		
		//driver.pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
		//driver.pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(2000);
		
		/*
		 * AndroidElement ele = scrollToAnElementByText("Huggies diapers"); ele.click();
		 */
		
		//driver.findElementByAndroidUIAutomator("text(\"Huggies diaper\")").click();
		
		/*
		 * @SuppressWarnings("unchecked") List<AndroidElement> optionsToSelect =
		 * (List<AndroidElement>)
		 * driver.findElementByAndroidUIAutomator("text(\"Huggies diaper\")");
		 * 
		 * System.out.println("size==="+optionsToSelect.size());
		 * 
		 * for(AndroidElement option : optionsToSelect){ // // //
		 * if(option.getText().equals(textToSelect)) {
		 * System.out.println("Trying to select: "+option.toString()); //
		 * //option.click(); // break; } //tap(""); }
		 */
		 
		}

	@Test(enabled = false)
	public void test() throws MalformedURLException, InterruptedException {

		// AndroidDriver<AndroidElement> driver = capabilitiesPixel81();
		try {

			File appDir = new File(System.getProperty("user.dir"));
			File app = new File(appDir, "original.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_27_8.1");
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

			driver.hideKeyboard();

			driver.findElement(By.xpath("//*[@text='Female']")).click();

			driver.findElement(By.id("android:id/text1")).click();

			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

			// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
			// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
			// UiSelector().textMatches(\"" + containedText + "\").instance(0))"));

			driver.findElement(By.xpath("//*[@text='Argentina']")).click();

			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

			Thread.sleep(4000);

			// Mobile Gestures

			WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));

			TouchAction t = new TouchAction(driver);

			t.tap(tapOptions().withElement(element(checkbox))).perform();

			driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

			Thread.sleep(7000);

			Set<String> contexts = driver.getContextHandles();

			for (String contextName : contexts)

			{

				System.out.println(contextName);

			}

			driver.context("WEBVIEW_com.androidsample.generalstore");

			driver.findElement(By.name("q")).sendKeys("hello");

			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

			driver.pressKey(new KeyEvent(AndroidKey.BACK));

			driver.context("NATIVE_APP");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
