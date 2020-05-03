package appium;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumBrowserTestDemo {
	static AppiumDriver<MobileElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();

	@Test
	public void mobileTest() throws Exception {
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,cap);
		driver.get("https://rideally.com/https://www.google.com/");
		String ss = driver.findElement(By.xpath("//*[@id=\'footermain\']/div[1]/div/div/div[5]/label")).getText();
		System.out.println("Appium Test Started====="+ss);
		String title = driver.getTitle();
		System.out.println("Title is- " + title);
	}

	@BeforeMethod
	public void beforeMethod() {
		final File classpathRoot = new File(System.getProperty("user.dir"));
		final File appDir = new File(classpathRoot, "");
		final File app = new File(appDir, "com.android.chrome.apk");
		cap = new DesiredCapabilities();							
		cap.setCapability("deviceName", "Galaxy J7 Max");
		cap.setCapability("udid","4200111f9610740d");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		//cap.setCapability("appActivity", "com.google.ar.core.InstallActivity");

		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("app", app.getAbsolutePath());
	}

	
	  @AfterMethod public void afterMethod() { 
		  driver.close(); 
		  }
	 
}