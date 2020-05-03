	package newAppium;
	
	import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
	import static io.appium.java_client.touch.TapOptions.tapOptions;
	import static io.appium.java_client.touch.offset.ElementOption.element;
	import static java.time.Duration.ofSeconds;
	
	import java.net.MalformedURLException;
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
	
	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
	public class Gestures extends BaseClass{
	
	/*
	 * public Gestures(AndroidDriver<AndroidElement> driver) {
	 * 
	 * super(driver); // TODO Auto-generated constructor stub }
	 */

		@SuppressWarnings("rawtypes")
		static  AppiumDriverLocalService appiumService;
		static  String appiumServiceUrl;
		//public static CentralObjects elements = new CentralObjects(driver);
		
		@BeforeMethod()
		public void startAppiumServer() throws MalformedURLException {
			appiumService = AppiumDriverLocalService.buildDefaultService();
			appiumService.start();
			appiumServiceUrl = appiumService.getUrl().toString();
			System.out.println("Appium Service Address : - "+ appiumServiceUrl);
			
			/*File folder = new File("log");
			if(!folder.exists()) {
			folder.mkdir();
			}
			File logFile = new File(folder, "UDID" +System.currentTimeMillis()+ ".log");
			appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withLogFile(logFile));
			*/
		}
		
		@AfterMethod()
		public void stopAppiumServer() throws MalformedURLException {
			  appiumService.stop();
		}
	
		@SuppressWarnings("rawtypes")
	
		@Test(enabled = true)
		public void gestures() throws MalformedURLException {
			
			
			/* AndroidDriver<AndroidElement> driver = */capabilitiesPixel81(); 
			CentralObjects elements = new CentralObjects(driver);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			elements.views.click();

			TouchAction t =new TouchAction(driver);
			WebElement expandList=	elements.expandableLists;
			t.tap(tapOptions().withElement(element(expandList))).perform();
			elements.customAdapter.click();
			
			WebElement pn=	elements.peopleNames;
			t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
			//Thread.sleep(2000);
			System.out.println(driver.findElementById("android:id/title").isDisplayed());
	
	
		}
	
	
		/*
		 * @Test public void onetest() throws MalformedURLException,
		 * InterruptedException { AndroidDriver<AndroidElement> driver =
		 * capabilities("ApiDemos-debug.apk", "Pixel_3a_API_27_8.1" );
		 * 
		 * System.out.println(driver.isDeviceLocked());//LOcked condition
		 * System.out.println(driver.getContext()); List<AndroidElement>
		 * abc=driver.findElements(By.className("android.widget.TextView"));
		 * 
		 * @SuppressWarnings("rawtypes") TouchAction t=new TouchAction(driver);
		 * //t.tap(abc.get(2)).perform(); //TouchAction t1=new
		 * TouchAction(driver).longPress(el);
		 * 
		 * 
		 * 
		 * //driver.installApp(""); driver.closeApp();
		 * 
		 * //driver.currentActivity(); //driver.context(name) //driver.zoom(el); }
		 */
		
		@Test (enabled = true)
	
		public void swipe() throws MalformedURLException, InterruptedException {
	
			/* AndroidDriver<AndroidElement> driver = */capabilitiesPixel81(); 
	
			CentralObjects elements = new CentralObjects(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			elements.views.click();
			elements.dateWidgets.click();
			elements.inline.click();

			//driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
			Thread.sleep(3000);
			//driver.findElementByXPath("//*[@content-desc='9']").click();
	
			tap("//*[@content-desc='9']");
	
			swipe("//*[@content-desc='15']","//*[@content-desc='45']" );
	
			/*
			 * driver.findElementById("com.calculator:id/EditText01").sendKeys("50");
			 * driver.sendKeyEvent(AndroidKeyCode.HOME);
			 * driver.findElementById("com.calculator:id/EditText02").sendKeys("50");
			 * 
			 * driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Multiply\")")
			 * .click();
			 * System.out.println(driver.findElementById("com.calculator:id/TextView01").
			 * getText());
			 */
	
	
		}
		@Test (enabled = false)
		public void test() throws MalformedURLException {
	
			capabilitiesPixel81(); 
	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	
			TouchAction t =new TouchAction(driver);
			WebElement expandList=	driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
	
			t.tap(tapOptions().withElement(element(expandList))).perform();
			driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
			WebElement pn=	driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
	
			t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
			//Thread.sleep(2000);
			System.out.println(driver.findElementById("android:id/title").isDisplayed());
	
	
		}
	
		@Test (enabled = false)
		public void dragAndDrop() throws MalformedURLException {
	
			capabilitiesPixel81(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
			
			scrollToEleement("android.view.View", "android.view.View");
		//	driver.pressKeyCode(AndroidKeyCode.BACK);
			
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));
		}
		}
