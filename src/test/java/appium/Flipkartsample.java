package appium;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Flipkartsample {
	
	@Test
	public class Test_Case
	{
	 String username;
	 String password;
	 String SearchProduct;
	 String objCommon;
	 Common_Methods _objCommon = new Common_Methods();
	 private static SelendroidLauncher selendroidServer = null;
	 private static WebDriver _driver = null;

	@BeforeClass
	public void setUp() throws FileNotFoundException, IOException
	{
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("PropFile_Flipkart_Ankit.prop"));
	  username = prop.getProperty("UserName");
	  System.out.println(username);
	  password = prop.getProperty("Password");
	  System.out.println(password);
	}

	@Test
	public void test() throws InterruptedException
	{
	  _objCommon.login(_driver, username, password);
	  _objCommon.captureScreenshot(_driver);
	  _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  _objCommon.Search_Product(_driver);
	  _objCommon.captureScreenshot(_driver);
	  _objCommon.addtocart(_driver);
	  _objCommon.captureScreenshot(_driver);
	  _objCommon.add_address(_driver);
	  _objCommon.captureScreenshot(_driver);
	}

	@BeforeClass
	public static void startSelendroidServer() throws Exception
	{
	  if (selendroidServer != null)
	 {
	  selendroidServer.stopSelendroid();
	}
	  SelendroidConfiguration config = new SelendroidConfiguration();
	  config.addSupportedApp("com.flipkart.android:2.5.2");
	  selendroidServer = new SelendroidLauncher(config);
	  selendroidServer.launchSelendroid();
	  SelendroidCapabilities caps = new SelendroidCapabilities("com.flipkart.android:2.5.2");
	  /*caps.setPlatformVersion(DeviceTargetPlatform.ANDROID17);
	  caps.setSerial("QO4417C05204")*/;
	  _driver = new SelendroidDriver(caps);
	}

	@AfterClass
	public static void stopSelendroidServer() throws InterruptedException
	{
	  if (_driver != null)
	 {
	   Thread.sleep(30000);
	   _driver.quit();
	 }
	  if (selendroidServer != null)
	 {
	   selendroidServer.stopSelendroid();
	 }
	  }
	}


}
