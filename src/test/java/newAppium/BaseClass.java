		package newAppium;
		
		import java.io.File;
		import java.net.MalformedURLException;
		import java.net.URL;
		
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.remote.DesiredCapabilities;
		import org.openqa.selenium.support.PageFactory;
		
		import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
		import static io.appium.java_client.touch.TapOptions.tapOptions;
		import static io.appium.java_client.touch.offset.ElementOption.element;
		import static java.time.Duration.ofSeconds;
		
		import io.appium.java_client.TouchAction;
		import io.appium.java_client.android.AndroidDriver;
		import io.appium.java_client.android.AndroidElement;
		import io.appium.java_client.remote.MobileBrowserType;
		import io.appium.java_client.remote.MobileCapabilityType;
		import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
		import io.appium.java_client.TouchAction;
		import io.appium.java_client.android.AndroidDriver;
		import io.appium.java_client.android.AndroidElement;
		import org.openqa.selenium.Dimension;
		 
		import java.time.Duration;
		 
		import static io.appium.java_client.touch.TapOptions.tapOptions;
		import static io.appium.java_client.touch.WaitOptions.waitOptions;
		import static io.appium.java_client.touch.offset.ElementOption.element;
		import static io.appium.java_client.touch.offset.PointOption.point;
		import static java.time.Duration.ofMillis;
		import static java.time.Duration.ofSeconds;
		public abstract class BaseClass  {
		
			public static AndroidDriver<AndroidElement>  driver;
			
			public static AndroidDriver<AndroidElement> chromeBrowserCaps(){
				try {
		
					DesiredCapabilities capabilities =  new DesiredCapabilities();
					capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
					capabilities.setCapability("chromedriverExecutable", "G:\\Java\\WorkspaceNew\\Mobiletest\\chromedriver.exe");
					capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, 	  "Pixel_3a_API_27_8.1"); 
					capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
					driver = new AndroidDriver<AndroidElement>(new  URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return driver;
			}
		
			public static AndroidDriver<AndroidElement> capabilitiesPixel81(){
				try {
		
					File appDir = new File(System.getProperty("user.dir"));
					File app = new File(appDir, "ApiDemos-debug.apk");
					DesiredCapabilities capabilities = new DesiredCapabilities();
		
					capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_27_8.1");
					capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
					driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return driver;
			}
		
			public static AndroidDriver<AndroidElement> amazonCapsPixel81(){
				try {
		
					File appDir = new File(System.getProperty("user.dir"));
					File app = new File(appDir, "com.amazon.mShop.android.shopping.apk");
					DesiredCapabilities capabilities = new DesiredCapabilities();
		
					capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_27_8.1");
					capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
					//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
					driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return driver;
			}
			
			public void swipe(String element1, String element2) {
		
				@SuppressWarnings("rawtypes")
				TouchAction t=new TouchAction(driver);
				//long press //on element// 2 sec// move to another element and you release
				WebElement first= driver.findElementByXPath(element1);
				WebElement second= driver.findElementByXPath(element2);
		
				t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
			}
		
			public void scrollToEleement(String element1, String element2) {
		
				WebElement source=driver.findElementsByClassName(element1).get(0);
				WebElement destination=driver.findElementsByClassName(element2).get(1);
		
				TouchAction t = new TouchAction(driver);
				//longpress(source)/move(destination)//release
				//    t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
				t.longPress(element(source)).moveTo(element(destination)).release().perform();
		
			}
		
			public void tap(String element) {
				TouchAction t=new TouchAction(driver);
				WebElement ele= driver.findElementByXPath(element);
						//driver.findElementByAndroidUIAutomator(element);
						//driver.findElementByXPath(element);
				t.tap(tapOptions().withElement(element(ele))).perform();
			}
			
			public void keyboardHide() {
				driver.hideKeyboard();
			}
		
///////////////////////////////////////
		
				 
		    //Tap to an element for 250 milliseconds
		    public void tapByElement (AndroidElement androidElement) {
		        new TouchAction(driver)
		                .tap(tapOptions().withElement(element(androidElement)))
		                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
		    }
		 
		    //Tap by coordinates
		    public void tapByCoordinates (int x,  int y) {
		        new TouchAction(driver)
		                .tap(point(x,y))
		                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
		    }
		 
		    //Press by element
		    public void pressByElement (AndroidElement element, long seconds) {
		        new TouchAction(driver)
		                .press(element(element))
		                .waitAction(waitOptions(ofSeconds(seconds)))
		                .release()
		                .perform();
		    }
		 
		    //Press by coordinates
		    public void pressByCoordinates (int x, int y, long seconds) {
		        new TouchAction(driver)
		                .press(point(x,y))
		                .waitAction(waitOptions(ofSeconds(seconds)))
		                .release()
		                .perform();
		    }
		 
		    //Horizontal Swipe by percentages
		    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
		        Dimension size = driver.manage().window().getSize();
		        int anchor = (int) (size.height * anchorPercentage);
		        int startPoint = (int) (size.width * startPercentage);
		        int endPoint = (int) (size.width * endPercentage);
		 
		        new TouchAction(driver)
		                .press(point(startPoint, anchor))
		                .waitAction(waitOptions(ofMillis(1000)))
		                .moveTo(point(endPoint, anchor))
		                .release().perform();
		    }
		 
		    //Vertical Swipe by percentages
		    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
		        Dimension size = driver.manage().window().getSize();
		        int anchor = (int) (size.width * anchorPercentage);
		        int startPoint = (int) (size.height * startPercentage);
		        int endPoint = (int) (size.height * endPercentage);
		 
		        new TouchAction(driver)
		                .press(point(anchor, startPoint))
		                .waitAction(waitOptions(ofMillis(1000)))
		                .moveTo(point(anchor, endPoint))
		                .release().perform();
		    }
		 
		    //Swipe by elements
		    @SuppressWarnings("rawtypes")
			public void swipeByElements (AndroidElement startElement, AndroidElement endElement) {
		        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
		 
		        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
		 
		        new TouchAction(driver)
		                .press(point(startX,startY))
		                .waitAction(waitOptions(ofMillis(1000)))
		                .moveTo(point(endX, endY))
		                .release().perform();
		    }
		 
		    //Multitouch action by using an android element
		    @SuppressWarnings("rawtypes")
			public void multiTouchByElement (AndroidElement androidElement) {
		        TouchAction press = new TouchAction(driver)
		                .press(element(androidElement))
		                .waitAction(waitOptions(ofSeconds(1)))
		                .release();
		 
		        new MultiTouchAction(driver)
		                .add(press)
		                .perform();
		    }
		    
		    public void scrollToExactElement(String str) {
		        ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+ str + "\").instance(0))").click();
		    }
		    
		    /////	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Baby diapers\"));");

	public AndroidElement scrollToAnElementByText(/* AppiumDriver<WebElement> driver, */ String text) {
		    
		return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
		                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
		}
		    
	/*
	 * public void swipeUpUntilTextExists(String expectedText, int
	 * howManyTimesToSwipe) { int i = 0; do { swipeUP(); i++; if (i ==
	 * howManyTimesToSwipe) break; } while
	 * (!driver.getPageSource().contains(expectedText)); } swipe method: public void
	 * swipeUP(){ Dimension size = driver.manage().window().getSize();
	 * log.info(size); // calculate coordinates for vertical swipe int
	 * startVerticalY = (int) (size.height * 0.8); int endVerticalY = (int)
	 * (size.height * 0.2); int startVerticalX = (int) (size.width / 2); new
	 * TouchAction(driver).press(point(startVerticalX,
	 * startVerticalY)).waitAction(waitOptions(ofSeconds(3))).moveTo(point(
	 * startVerticalX, endVerticalY)).release().perform(); }
	 * 
	 * or this with uiAutomator:
	 * 
	 * @AndroidFindBy(uiAutomator = “new UiScrollable(new
	 * UiSelector()).scrollIntoView(text(“Tokyo”))”) public MobileElement tokyo;
	 */
		    
		  
		}