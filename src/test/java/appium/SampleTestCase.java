package appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;


public class SampleTestCase extends AppiumDriverBase{
 
    //Test Annotation changes any java function to TestNG test case
    @Test
    public void sampeTest() throws InterruptedException{
 
		/*
		 * //click on Accessibility link
		 * wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
		 * AccessibilityId("Accessibility")));
		 * driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
		 * 
		 * //click on 'Accessibility Node Querying' link
		 * wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
		 * AccessibilityId("Accessibility Node Querying")));
		 * driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).
		 * click();
		 */
 
    	Thread.sleep(3000);
		/*
		 * quizeButton = (MobileElement)(driver.findElement(By.
		 * xpath("//android.widget.EditText[@content-desc='Phone Number']")));
		 * quizeButton.sendKeys("India (IND)");
		 */
    	Thread.sleep(4000);
    	  quizeButton =	  (MobileElement)(driver.findElement(By.id("com.flipkart.android:id/tv_right_cta")));
    	  quizeButton.click();
    	  
    	  Thread.sleep(4000); 
    	  quizeButton =	  (MobileElement)(driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email ID']")));
    	  quizeButton.sendKeys("kolekar.oms16@gmail.com");
    	  
    	  Thread.sleep(4000); 
    	  quizeButton =	  (MobileElement)(driver.findElement(By.id("com.flipkart.android:id/bottom_bar_container")));
    	  quizeButton.click();
    	 
    	  Thread.sleep(4000); 
    	  quizeButton =	  (MobileElement)(driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password']")));
    	  quizeButton.sendKeys("omkar123");
    		
    	  Thread.sleep(4000); 
    	  quizeButton =	  (MobileElement)(driver.findElement(By.id("com.flipkart.android:id/button")));
    	  quizeButton.click();
    	  
    	  					/* * quizeButton = (MobileElement)(driver.findElement(By.
							 * xpath("//android.widget.ImageButton[@content-desc=\"Back Button\"]")));
							 * quizeButton.click();
							 */
    	  
    	  Thread.sleep(3000);
    	  quizeButton =	  (MobileElement)(driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Search on flipkart']/android.widget.TextView")));
    	 System.out.println("aaaaaaaaaa"+quizeButton.isDisplayed());
    	 
    	  quizeButton.click();
    	 
    	 quizeButton.sendKeys("iphone xr");
    	 
    	  quizeButton =	  (MobileElement)(driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Search grocery products in Supermart']")));
    	  quizeButton.sendKeys("iphone xr");
    	

    	  
		  
		/*
		 * quizeButton = (MobileElement)(driver.findElement(By.
		 * xpath("//*[@text='Accessibility Node Querying']"))); quizeButton.click();
		 */  
		/*
		 * @SuppressWarnings("unchecked") List<MobileElement> elements =
		 * driver.findElements(By.className("android.widget.LinearLayout"));
		 * 
		 * System.out.println("aaaaaaaaaaa==="+elements.size()); for(int i=0;
		 * i<elements.size(); i++) { if(i ==3) {
		 * 
		 * @SuppressWarnings("unchecked") MobileElement ch = elements.get(i);
		 * List<MobileElement> child =
		 * ch.findElements(By.className("android.widget.LinearLayout"));
		 * System.out.println("bbbbbbbbbbbb==="+child.size());
		 * 
		 * } } //back driver.navigate().back();
		 * 
		 * //back driver.navigate().back();
		 */
    
    }
 
}