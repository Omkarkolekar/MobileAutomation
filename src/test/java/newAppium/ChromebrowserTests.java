	package newAppium;
	
	import java.io.File;
	import java.net.MalformedURLException;
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	import io.appium.java_client.service.local.AppiumDriverLocalService;
	import io.appium.java_client.service.local.AppiumServiceBuilder;
	
	public class ChromebrowserTests extends BaseClass{
	
		@SuppressWarnings("rawtypes")
		static  AppiumDriverLocalService appiumService;
		static  String appiumServiceUrl;
	
		@BeforeMethod(enabled = true)
		public void startAppiumServer() throws MalformedURLException {
			appiumService = AppiumDriverLocalService.buildDefaultService();
			appiumService.start();
			appiumServiceUrl = appiumService.getUrl().toString();
			//	System.out.println("Appium Service Address : - "+ appiumServiceUrl);
	
			/*File folder = new File("log");
			if(!folder.exists()) {
			folder.mkdir();
			}
			File logFile = new File(folder, "UDID" +System.currentTimeMillis()+ ".log");
			appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withLogFile(logFile));
			 */
		}
	
		@AfterMethod(enabled = true)
		public void stopAppiumServer() throws MalformedURLException {
			appiumService.stop();
		}
	
		@Test(enabled = true)
		public void browser() throws MalformedURLException {
	
			/* AndroidDriver<AndroidElement> driver = */chromeBrowserCaps(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			driver.get("http://cricbuzz.com");
			driver.findElementByXPath("//a[@href='#menu']").click();
			driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
			System.out.println(driver.getCurrentUrl());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,480)", "");
			Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
			
			driver.close();
		}
	
	
	}
