package newAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TempTest {
	
	public static AndroidDriver<AndroidElement> driver;
	
	@SuppressWarnings("unlikely-arg-type")
	@Test(enabled = true)
	public void amazontest() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_27_8.1");
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.micron.StartupActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		
		
		  if(driver.getOrientation().equals("PORTRAIT")) {
			  System.out.println("Current screen orientation is : " + driver.getOrientation());  
			  driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		  }else {
			driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		  }
		 
		   
		
	
		driver.findElementByAndroidUIAutomator("text(\"Skip sign in\")").click();
		Thread.sleep(2000);
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/action_bar_burger_icon")).click();

		Thread.sleep(2000);
		
		
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
		
		
		 
		
	}

}
