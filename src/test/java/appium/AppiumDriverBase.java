package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumDriverBase {
 
    @SuppressWarnings("rawtypes")
	protected AndroidDriver driver;
    protected WebDriverWait wait;
    MobileElement quizeButton;
    //before Test Annotation makes a java function to run every time before a TestNG test case
    @SuppressWarnings("rawtypes")
	@BeforeTest
    protected void createAppiumDriver() throws MalformedURLException, InterruptedException {
 
    //relative path to apk file
    final File classpathRoot = new File(System.getProperty("user.dir"));
    final File appDir = new File(classpathRoot, "");
  //  final File app = new File(appDir, "ApiDemos-debug.apk");
   // final File app = new File(appDir, "com.quikr.apk");
    final File app = new File(appDir, "com-flipkart-android-6-17_SOFTSTRIBE.apk");
    
 
    //setting up desired capability
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(CapabilityType.BROWSER_NAME, "");
    caps.setCapability("automationName", "UiAutomator2");
    caps.setCapability("udid","4200111f9610740d");
    caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
    caps.setCapability("appPackage", "com.flipkart.android");
    caps.setCapability("appActivity", "com.flipkart.android.SplashActivity");
    caps.setCapability("platformVersion", "8.1.0");
    caps.setCapability("deviceName", "Galaxy J7 Max");
    caps.setCapability("app", app.getAbsolutePath());
 
    //initializing driver object
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
 
		
		  //initializing explicit wait object wait = new WebDriverWait(driver, 10);
		/*
		 * quizeButton =
		 * (MobileElement)(driver.findElement(By.xpath("//*[@text='Accessibility']")));
		 * quizeButton.click();
		 * 
		 * quizeButton = (MobileElement)(driver.findElement(By.
		 * xpath("//*[@text='Accessibility Node Querying']"))); quizeButton.click();
		 * 
		 * List<MobileElement> elements =
		 * driver.findElements(By.className("android.widget.LinearLayout"));
		 * 
		 * System.out.println("aaaaaaaaaaa==="+elements.size()); for(int i=0;
		 * i<elements.size(); i++) { if(i ==1) { elements.get(i).click(); } }
		 */
		/*
		 * for(MobileElement element : elements) {
		 * if(element.getAttribute("contentDescription").equals("Search")) {
		 * 
		 * element.click(); break; } }
		 */
		 
    
    }
 
    //After Test Annotation makes a java function to run every time after a TestNG test case
    @AfterTest
    public void afterTest(){
 
    //quit the driver
  //  driver.quit();
    }
 
}