package appium;

public class SSS {


	Locator can be termed as an address that identifies a web element uniquely within the webpage. Thus, to identify web elements accurately and precisely we have different types of locators in Selenium:

		Id
		Name
		LinkText
		Partial LinkText
		Tag Name
		Class name
		CSS
		xPath

		What is WebDriver backed selenium?
				WebDriver backed Selenium is an API that enables running Selenium 1.0 tests in WebDriver.

				What is Absolute and Relative xPath?
						Absolute xPath: Writing the complete path of a specified element using single forward slash (‘/’) is known as Absolute xPath. It is time consuming and lengthy. Here the single slash (‘/’) represents immediate child.

						Example: html/body/div[7]/div[3]/div/div[2]/div[1]/span

						Relative xPath: Writing the path of a specific element using double forward slash (‘//’) is known as Relative xPath. Here the double slash (‘//’) represents any child also called as Descendants.

Example: //table[@class='dataTable']/tbody/tr[1]

//
How do you open a site using chrome browser?
		public class ChromeBrowser{
	public static void main(String args[]){

		//Set System property for chrome driver
System.setProperty("webdriver.chrome.driver", "D://Jars//chromedriver.exe");
WebDriver driver=new ChromeDriver(); 
driver.get("http://www.google.com/"); 
	}
}
////
How do you maximize the browser?
		To maximize a web browser, WebDriver providers a built-in method and here is the syntax:

			WebDriver driver = new FirefoxDriver();
//to maximize the browser
driver.manage().window().maximize()
//////////////
Write a code to read the text box value?
		By using, getAttribute() method we can get the value of the text box.

		String strText = driver.findElement(By.name("txtboxname")).getAttribute("value");
//to print the text
System.out.println(strText);
///////////////////////////////////

How can you find if an element in displayed on the screen?
		The visibility of the WebElements can find using the following methods:

			isDisplayed()
			isSelected()
			isEnabled()

			Sample Code:

				isDisplayed():

					boolean btnPresence = driver.findElement(By.id(“test”)).isDisplayed();
				isSelected():

					boolean btnSelected = driver.findElement(By.id(“test”)).isSelected();
				isEnabled():

					boolean btnEnabled = driver.findElement(By.id(“test”)).isEnabled();

				////////////////
How do you handle dropdowns?
		WebDriver driver=new FirefoxDriver();
driver.get("http://www.facebook.com");
driver.manage().window().maximize();

//name attribute to select dropdown
WebElement element=driver.findElement(By.name("birthday_month"));

List lists=element.findElements(By.tagName("option"));

for(WebElement dd_names : lists){
	String strName=dd_names.getText();
	System.out.println(strName);
}

Thread.sleep(3000);

//to select any value in dropdown
//method 1 - select by index
WebElement ele=driver.findElement(By.name("birthday_month"));
Select se=new Select(ele);
se.selectByIndex(8);

//method 2 - selectByVisibleText
se.selectByVisibleText("Feb");

////////////////

How do you get Width & Height of a text box?
		public class Width_Height{

	public static void main(String[] args){

		WebDriver driver=new FirefoxDriver();
		driver.get("http://wwww.google.com");
WebElement element=driver.findElement(By.xpath("xpath of a textbox"));

		int wdth=element.getSize().getWidth();
		int ht=element.getSize().getHeight();

		System.out.println(wdth);
		System.out.println(ht);
	}
}
///////////

How to check all checkboxes in a page?
		public class Check_all_checkbox{

	public static void main(String[] args){
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.echoecho.com/htmlforms09.htm");

List allchkBox=driver.findElements(By.xpath("//input[@type='checkbox']"));

		for(int i=0; i < allchkBox.size(); i++){

			allchkBox.get(i).click();
		}
	}
}
////////////////////
What is the use of getOptions() method?
		getOptions() is used to get the selected options from the dropdown list.
		////////////////
How to capture screenshot in WebDriver for a failed case?
		To get screenshot on test failure, we should put the entire code in try-catch block. In the catch block make sure to copy the above screenshot code.

		public class TakeScreenshot{

			WebDriver driver; 

			@BeforeTest 
			public void start(){
				driver=new FirefoxDriver(); 
			}

			@Test 
			public void Test() throws IOException{
				try{
					driver.get("https://google.com/"); 
//find the element with wrong xpath, so control moves to catch block
driver.findElement(By.xpath("Wrong Xpath")).sendKeys("Testing"); 

}catch(Exception e){
	//Takes the Screenshot and saves in the path mentioned when test fails 
File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
FileUtils.copyFile(scrFile, new File("D:\\Test.png")); 

		}
	}
}

///////////////////////////////
How to refresh a web page using WebDriver?
		The following are the various methods available in WebDriver to refresh the page:

			1. Using refresh() method:

				driver.get("https://google.com/");
driver.navigate().refresh();2. Using to() method:

	driver.get("https://google.com/");
driver.navigate().to(driver.getCurrentUrl());3. Using get() method:

	driver.get("https://google.com/");
driver.get(driver.getCurrentUrl());4. Using SendKeys method:

	driver.get("https://google.com/");
driver.findElement(By.xpath("xpath")).sendKeys(Keys.F5);

//////////////////////////////////////

How do you navigate browser back and forward?
		//Navigate - Forward
driver.navigate().forward();

//Navigate - Back
driver.navigate().back();

/////////////////
How do you handle alert pop-up?
		By using “Alert” class you can handle pop-up’s. First move control to alert pop-up’s, then move back control to main window.

		The Sample code is:

			WebDriver driver=new FirefoxDriver();
driver.get("http://xyz.com");

//Move control to alert pop up
Alert alt=driver.switchTo().alert();
//to click "Ok"
alt.accept();
//Or
//to click "Cancel"
alt.dismiss();

//Then move control back to main window
driver.switchTo().window("main window");

/////////////////////
How to perform right click using WebDriver?
		Method 1: Using Actions class

		// the element on which the right click to be performed
WebElement element=driver.findElement(By.xpath("//a[@href='username']"));
Actions oAction=new Actions(driver);
oAction.moveToElement(Webelement);
//this will perform right click
oAction.contextClick(Webelement).build().perform();
Method 2: Using ContextClick()

WebElement element=driver.findElement(By.xpath("//a[@href='username']"));
// Initialize Actions class object
Actions builder=new Actions(driver);
//ContextClick() is a method to right click 
builder.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
/////////////////////////////////

How do you perform drag and drop using WebDriver?
		Method 1:

			Actions act=new Actions(driver);
WebElement source=driver.findElement(By.xpath("source xpath"));
WebElement target=driver.findElement(By.xpath("target xpath"));
act.dragAndDrop(source, target).perform();
Method 2:

	act.clickAndHold(source).build().perform();
act.moveToElement(target).build().perform();
act.release(target).build().perform();
Method 3:

	act.dragAndDropBy(source, xoffset, yoffset).perform();
/////////////////////////////////////
WebDriver?
		Write a code to upload a file?
				//Syntax - sendKeys(“file to be uploaded”);
driver.findElement(By.xpath("xpath")).sendKeys(“D:\\test.txt”);
/////////////////////////////
What is the difference between driver.get() and driver.navigate() methods?
		driver.get():

			driver.get() method is generally used to open the url.
			It will till the whole page gets loaded.
			driver.navigate():

				driver.navigate() method is generally used to navigate to url.
				It supports back, forward, and page refresh.
				It will just navigate to the page but will not wait till the whole page gets loaded.
				////////////////////////////////
How do you handle iframes in selenium?
		public class iframes{

	public static void main(String[] args){

		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.rediff.com");

//Find no of iframes in a page
List iframeCount=driver.findElements(By.tagName("iframe"));
System.out.println("The total number of iframes are: " + iframeCount.size());

//Method 1 - Switch to Frames by Index
//Index of iFrame starts from 0.
//Pass the frame number as parameter
driver.switchTo().frame(0);

//Method 2 - Switch to Frames by Name
//Pass the frame name (String) as parameter
driver.switchTo().frame("iframe2");

//Method 3 - Switch to Frame by ID
//Pass the ID as parameter
driver.switchTo().frame("ID3");

//Method 4 - Switch to Frame by WebElement
//Pass web element as parameter
driver.switchTo().frame(element4);

//Switch control back to main window
		driver.switchTo().defaultContent();

	}
}

////////////////////////////////
How do you simulate scroll down action?
		public class Scroll_Down{

	public static void main(String[] args){

		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
driver.manage().window().maximize();

//Method 1 - Using JavaScript to scroll down
//Scroll Down
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,2000)", "");

//Scroll Up
js.executeScript("window.scrollBy(2000,0)", "");

//Method 2 - Using sendKeys
driver.findElement(By.xpath("xpath")).sendKeys(Keys.PAGE_DOWN);

//Method 3 - Scroll to specific element
WebElement element=driver.findElement(By.xpath("xpath"));
		Coordinates co=((Locatable)element).getCoordinates();
		co.inViewPort();

	}
}
///////////////////////////
How to get colour of a text?
		String clr = driver.findElement(By.xpath("//a[text()='facebook']")).getCssValue("color");
System.out.println(clr);
//////////////
How to hover the mouse on an element?
		By using Actions class, you can move cursor to a particular element.

		WebElement element=driver.findElement(By.xpath("xpath of a element"));
Actions act=new Actions(driver);
//hover
act.moveToElement(element);
////////////////////////////
Write a code to handle https website error in selenium?
		//Create ff profile
		FirefoxProfile fp=new FirefoxProfile();
fp.setAcceptUntrustedCertificates(true);
fp.setAssumeUntrustedCertificateIssuer(false);

//pass ff profile as constructor
WebDriver driver=new FirefoxDriver(fp);
driver.get("https://www.xyz.com");
///////////////

Write a code to login into any site showing any authentication popup for username and password?
		//Pass Username and Password in URL itself
driver.get("http://username:password@www.xyz.com");
/////////////////////////
How do you send ENTER Key?
		WebDriver driver=new FirefoxDriver();
driver.get("https://www.xyz.com");

//Enter Key
driver.findElement(By.xpath("xpath")).sendKeys(Keys.ENTER);

// Tab Key
driver.findElement(By.xpath("xpath")).sendKeys(Keys.TAB);
///////////////
How to perform double click using WebDriver?
		WebDriver driver=new FirefoxDriver();
driver.get("https://www.xyz.com");

//button to be double clicked
WebElement element=driver.findElement(By.xpath("xpath"));
Actions act=new Actions(driver);

//double click
act.doubleClick(element);
//////////////
How to press Shift+Tab?
		String keys = Keys.chord(Keys.SHIFT, Keys.ENTER);
driver.findElement(By.xpath("xpath")).sendKeys(keys);
////////////////

Write a code to print the number of links in a page?
		public class Link_Count{

	public static void main(String[] args){

		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");

//find links by anchor tag
List element=driver.findElements(By.tagName("a"));
//print the number of links
		System.out.println(element.size());

	}
}
//////////////////////////
How to find broken images in a page using Selenium WebDriver?
		public class Broken_Images{

	public static void main(String[] args) throws IOException{

		WebDriver driver=new FirefoxDriver();
		EventFiringWebDriver eventFiringWebDriver=new EventFiringWebDriver (driver);
		driver.get("http://www.gmail.com");

// Storing all the image element in the variable allImages
List allImages=eventFiringWebDriver.findElements(By.tagName("img"));
int countBrokenImages=0;

// Declaring a dynamic string of array which will store src of all the broken images
List BrokenimageUrl=new ArrayList();

String script="return (typeof arguments[0].naturalWidth!="undefined" &&arguments[0].naturalWidth>0)";

for (WebElement image : allImages){
	Object imgStatus=eventFiringWebDriver.executeScript(script, image); 
	if(imgStatus.equals(false)){
		String currentImageUrl=image.getAttribute("src");
		String imageUrl=currentImageUrl ;
		BrokenimageUrl.add(imageUrl);
		countBrokenImages++;
	}
}

// Printing the src of the broken images if any
System.out.println("Number of broken images found in the page : " +countBrokenImages);
		for (String z : BrokenimageUrl){
			System.out.println(z);
		}
	}
}
////////////////////

How to disable cookies in browser?
		public class Disable_Cookies{

	public static void main(String[] args){

		//disable cookies in firefox
//create firefox profile 
FirefoxProfile fp=new FirefoxProfile();
//disable cookies
fp.setPreference("network.cookie.cookieBehavior", 2);
WebDriver driver=new FirefoxDriver(fp);
driver.get("http://www.google.com");

//disable cookies in chrome
ChromeOptions options=new ChromeOptions(); 
Map prefs=new HashMap(); 
prefs.put("profile.default_content_settings.cookies", 2); 
options.setExperimentalOption("prefs", prefs); driver=new ChromeDriver(options); 

	}
}
////////////////////
Write a code to set browser width and height?
		public class Browser_Height{

	public static void main(String[] args){

		WebDriver driver=new FirefoxDriver();

		//set browser height=500 and width=500
		Dimension d=new Dimension(500, 500);
		driver.manage().window().setSize(d);

	}
}
//////////////////////////
How do you load data from Properties files?
		public class Prop_File{

	@Test
	public void propfile() throws IOException{

		//create the properties object
Properties prop=new Properties();
FileInputStream fp=new FileInputStream("D:\\config.properties");

//load the file
prop.load(fp);

WebDriver driver=new FirefoxDriver();
//load url from the properties file
driver.get(prop.getProperty("URL"));
	}
}
//////////////
How do you create a text file?
		public class Text_File{

	@Test
	public void propfile() throws IOException{

		//create file object
File f=new File("D:\\temp.txt");

//create new file in D:
f.createNewFile();

//to write into the text file, create file-writer object
FileWriter w=new FileWriter("D:\\temp.txt");
BufferedWriter out=new BufferedWriter(w);
out.write("hello world");
out.newLine();
out.write("hello world again");
out.flush();

//to read the text file create file-reader object
FileReader r=new FileReader("D:\\temp.txt");
BufferedReader br=new BufferedReader(r);

String x="";

		while((x=br.readLine())!=null){
			System.out.println(x); 
		}
	}
}
////////////
How do you download a file using selenium WebDriver?
		public class FileDownload{

	public static void main(String[] args){

		FirefoxProfile fp=new FirefoxProfile();
		//the browser will not ask for save location & mime type of the file to be downloaded - text file here 
fp.setPreference("browser.helperApps.neverAsk.SaveToDisk", "text/plain");

WebDriver driver=new FirefoxDriver();
driver.get("http://www.xyz.com");
//click download link & file will automatically saved into system
driver.findElement(By.xpath("xpath")).click();
	}
}
/////////////////
How will you click a sub menu?
		public class SubMenu{

	public static void main(String[] args) throws InterruptedException{

		WebDriver driver=new FirefoxDriver();
		WebElement mainmenu=driver.findElement(By.xpath("xpath of main menu"));
WebElement submenu=driver.findElement(By.xpath("xpath of sub menu"));
Actions act=new Actions(driver);

//Method 1
//move cursor to main menu
act.moveToElement(mainmenu).build().perform();
Thread.sleep(2000);
//click sub menu
submenu.click();

//Method 2
act.moveToElement(mainmenu).perform();
Thread.sleep(2000);
//click sub menu
	act.click(submenu).perform();
}
////////////

How do you connect db using WebDriver?
		public class DB_Connection{

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		//Connection URL
String dbUrl="jdbc:mysql://localhost:3306/userdb";

//DB username and password
String Username="root";
String Password="root";

//Query to be used
String query="select username from table_name;";

//Load my sql jdbc driver
Class.forName("com.mysql.jdbc.Driver");

//Connect DB
Connection con=DriverManager.getConnection(dbUrl,Username,Password);

//Create Statement Object
Statement st=con.createStatement();

//Send Query to DB
ResultSet rs=st.executeQuery(query);

//while loop to print the result
while(rs.next()){
	String u_name=rs.getString(1);
	//prints the username
	System.out.println(u_name);
}

//close db connection
		con.close();
	}
}
//////////////////
How do you get X and Y coordinates of a WebElement?
		//Get the co-ordinates
Point p=driver.findElement(By.xpath("xpath of a webelement")).getLocation();
//Print the co-ordinates
System.out.println(p.x);
System.out.println(p.y);
/////////////////////
How will you get data from WebTable?
		public class WebTable{

	public static void main(String[] args){

		/***
consider a webtable of 4 rows and 3 columns
xPath to get all rows of a webtable - //table[@class='dataTable']/tbody/tr
xPath to get 1st row of a webtable - //table[@class='dataTable']/tbody/tr[1]
xPath to get all columns of a webtable - //table[@class='dataTable']/tbody/tr[4]/td
xPath to get 2nd column of a webtable - //table[@class='dataTable']/tbody/tr/td[2]
																								 ***/

//code to print 1st row
List rows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]"));
//print row size
System.out.println("Rows Size "+rows.size());

//for loop to get the content of the row
		for(int i=0; i < rows.size(); i++){
			System.out.println(rows.get(i).getText());
		}
	}
}
//////////////////
How do you handle cookies?
		public class Cookies{

	public static void main(String[] args){

		WebDriver driver=new FirefoxDriver();
		driver.get("http://gmail.com");

Set cc=driver.manage().getCookies();
//print cookie size
System.out.println(cc.size());

Iterator it=cc.iterator();

while(it.hasNext()){
	Cookie c=it.next();

	//print the domain
System.out.println(c.getDomain());
//print the expire detail
System.out.println(c.getExpiry());
//print the cookie name
			System.out.println(c.getName());
		}
	}
}
//////////////
Write a code to delete all the cookies of a browser?
		driver.manage().deleteAllCookies();
/////////////////////////How do you access the Firefox profiles in WebDriver?
public class FF_Profile{

	public static void main(String[] args){

		//create object of profiles Ini class which holds all the profile of ff
ProfilesIni prof=new ProfilesIni();
//get the profile you want (from already existing one)
FirefoxProfile p=prof.getProfile("user1");

//pass the desired profile object as constructor
WebDriver driver=new FirefoxDriver(p);
//driver will open the url by using the user1 profile
driver.get("http://gmail.com");
	}
}

///////////////////////////////////
How to Zoom In and Zoom Out in WebDriver?
		//To Zoom in
WebElement element=driver.findElement(By.tagName("html"));
element.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));

//To Zoom out to normal page
element.sendKeys(Keys.chord(Keys.CONTROL, "0"));
//////////////////////////////////////////////
What is the difference between xPath and DOM (Document Object Model)?
		DOM:
			The Document Object Model (DOM) is a cross-platform and language-independent convention for representing and interacting with objects in HTML, XHTML and XML documents. Objects in the DOM tree may be addressed and manipulated by using methods on the objects.

			Example:

				var element = document.getElementById("intro");
XPATH:
	xPath, the XML Path Language, is a query language for selecting nodes from an XML document. In addition, xPath may be used to compute values (e.g., strings, numbers, or Boolean values) from the content of an XML document.

	Example:

		//input[@id=”txtbox”]
///////////////////////

What is HTML UnitDriver?
		HtmlUnit Driver

		This is currently the fastest and most lightweight implementation of WebDriver. As the name suggests, this is based on HtmlUnit.

		Pros

		Fastest implementation of WebDriver
		A pure Java solution and so it is platform independent.
		Supports Javascript
		Cons

		Emulates other browser's JS behaviour.

////////////////////

How do you enable JavaScript in HTML UnitDriver?
		HtmlUnitDriver driver = new HtmlUnitDriver();
driver.setJavascriptEnabled(true);
Or

HtmlUnitDriver driver = new HtmlUnitDriver(true);
/////////////////////////
How to retrieve css properties of an element?
		The values of the css properties can be retrieved using a getCssValue () method.

		Syntax:

			driver.findElement(By.id(“id“)).getCssValue(“name of css attribute”);
		driver.findElement(By.id(“id“)).getCssValue(“font-size”);
		/////
What is the difference between POI and JXL?
		S.No	JXL	POI API
		1	JXL supports only “.xls” format. (Excel 2003)	POI jar supports all excel formats
		2	JXL API doesn’t support rich text formatting	POI API supports rich text formatting
		3	JXL API is faster than POI API	POI API is slower than JXL API

		/////////////
What is the difference between Assert and Verify?
		Verify command will not stop execution of test case if verification fails. It will log an error and proceed with execution of rest of the test case.

		Assert command will stop execution of test case if verification fails. It will log an error and will not proceed with execution of rest of the test case. We use assertions in scenarios where there is no point proceeding further if expected output is not matched.

		Use assertions when you want to stop execution of a test case if expected output is not matched and use verification when you still want to proceed execution of a test case if expected output is not matched.

		///////////////
Give the example for method overloading in WebDriver?
		frame(string), frame(int), frame(WebElement)

		/////////////////

What are the different types of exception we get in WebDriver?
		Exception	Description
		ElementNotVisibleException	Element is present but not visible and can not be interacted with.
		NoSuchElementException	Element not present in DOM. Thrown by findElement(By by) & findElements(By by).
		StaleElementReferenceException	The reference to the element is now stale. It is no longer appears on the DOM of the page.
		TimeoutException	Exception thrown when a comand does not complete in enough time.
		InvalidCoordinatesException	The co-ordinates provided to the interactions operation are not valid.
		MoveTargetOutOfBoundsException	The target provided to the action move() method is invalid - outside of the size of the window.
		NoAlertPresentException	When user tries to access alert when it is not present.
		NoSuchFrameException	Exception thrown when accessing the frame which is not present. (WebDriver.SwitchTo().frame())
		NoSuchSessionException	Thrown by any command being called after WebDriver.quit().
		NoSuchWindowException	Thrown when accessing the window which is not present (Thrown by WebDriver.SwitchTo().window()).
		NoSuchContextException	Thrown by WebDriver.SwitchTo().context().
		InvalidCookieDomainException	Thrown when attempting to add a cookie under a different domain than the current url.
		UnableToSetCookieException	Thrown when a driver fails to set cookie.
		UnhandledAlertException	Alert is present due to which the operation cannot be performed.
		UnreachableBrowserException	Problem with connection to browser due to closing of browser, invalid remote server address.
		ConnectionClosedException	Exception thrown when the connection to the SafariDriver is lost.
		UnsupportedCommandException	Used to indicate that a command used by the remote webdriver is unsupported
		//////////////////////////////

		What are the different types Waits in WebDriver?
				Waiting provides some time interval between actions performed; mostly locating an element or any other operations to be performed on the element.

Implicit Wait:

	Implicit wait tells Selenium instance to wait for specified amount of time before throwing an exception. If WebDriver cannot find an element, it will wait for specified amount of time. During this time, no attempt is made to find the element. After completion of specified time, WebDriver will try to find the element. If the element is not found then we get an exception.

	Implicit wait can be implemented by using the code below:

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Explicit Wait:

				You can define to wait for a certain condition to occur before proceeding further test code execution.

				Explicit wait can be implemented by using the code below:

					WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='gbqfq']")));
	Fluent Wait:

		Each FluentWait instance defines the maximum amount of time to wait for a condition, as well as the frequency with which to check the condition. And you can ignore specific types of exceptions whilst waiting, such as NoSuchElement Exceptions when searching for an element on the page.

		Fluent wait can be implemented by using the code below:

			Wait wait = new FluentWait(driver)
			.withTimeout(30, SECONDS)
			.pollingEvery(5, SECONDS)
			.ignoring(NoSuchElementException.class);

	//////////////////////////
	What is actions class in WebDriver?
			Actions class is used to control the actions of mouse and complex user gestures.
			///////////////////
			What are desired capabilities?
					Desired Capabilities help to set properties for the WebDriver. A typical use case would be to set the path for the Firefox Driver if your local installation doesn’t correspond to the default settings.
					/////////
					Explain how can you use recovery scenario with Selenium?
							You can use recovery scenario depends upon the programming language you use. If you are using Java then you can use exception handling. By using “Try Catch Block” within your Selenium WebDriver Java tests, you can handle exceptions.
							/////////////////////

							How can you create html test report?
									To create html test report there are three ways:

										TestNG: Using inbuilt default.html to get the HTML report. Also XLST reports from ANT, Selenium, TestNG combination
										JUnit: With the help of ANT
										Using our own customized reports by using XSL jar for converting XML content to HTML

										//////////////

										What is EventFiringWebDriver?
												To create html test report there are three ways:

													WebDriverEventListener: It’s an interface containing all unimplemented methods related to different events of WebDriver.

													AbstractWebDriverEventListener: It’s an abstract class which implements WebDriverEventListener interface and provides empty implementation of all the methods defined in interface.

													EventFiringWebDriver: It’s a class which implements WebDriver interface.

													It has two important methods:

														a. Register (WebDriverEventListener eventListener) : The method is used to bind our WebDriver instance with custom WebDriverEventListener class to handle different events.
														b. Unregister (WebDriverEventListener eventListener) : The method is used to isolate the WebDriver instance from WebDriverEventListener class

														//////////////
														What is TestNG listener and How to implement in Selenium?
																In TestNG we can generate logs with the help of Listeners. Listeners implement the interface "org.testng.ITestListener". There are methods which gives you real time information.

																You can either extend 'TestListenerAdapter' or implement Interface 'ITestListener' which is a listener for test running.

																By using TestNG listeners 'ITestListener' or 'TestListenerAdapter' we can change the default behaviour write our own implementation when a Test fails or Skips etc.
																/////////////////
																What is difference between WebDriver listener and TestNg listener?
																		TestNG Listeners are triggered at test level such as before starting the test, after the test or when test fails etc;

																		Whereas WebDriver Listener are triggered at component level such as before click, after click etc.
																		/////////////

																		How to Zip a folder using WebDriver?
																				import java.io.File;
																		import java.io.IOException;
	import org.openqa.selenium.io.Zip;

	public class Zip_File {

		public static void main(String[] args) {

			Zip zipFolder=new Zip();
			//Folder to be zipped (Source)
			File sourceFile=new File("D:\\Test\\Source");

			//Zip file Destination location and Zipfile name
			File destinationFile=new File("D:\\Test\\Result.zip");

			//Unzip location

			File unzipLocation=new File("D:\\Test\\Destination");

			try {
				if(destinationFile.isFile())
					destinationFile.delete();

				//Creates a zip file
				zipFolder.zip(sourceFile,destinationFile);

				//UnZip a file
				zipFolder.unzip(destinationFile, unzipLocation);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/////////////
	How to encode or encrypt password in WebDriver?
			import org.apache.commons.codec.binary.Base64;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	public class Encrypt_PWD {

		//Create a 'data.properties' file and store password to be used
		//Download Base64 jar file and add jar file in project as external jar.
		/*Base64: Base64 is a group of similar binary-to-text encoding schemes
		 * that represent binary data in an ASCII string format
		 * by translating it into a radix-64 representation.
		 * The term Base64 originates from a specific MIME content transfer encoding.*/

		public static void main(String[] arg) throws IOException {

			// Create FileInputStream Object
			FileInputStream fileInput = new FileInputStream(new File("D:\\data.properties"));
			// Create Properties object
			Properties prop = new Properties();
			//load properties file
			prop.load(fileInput);

			// create Firebox object
			WebDriver driver = new FirefoxDriver();
			//Go to URL
			driver.get("http://www.facebook.com");
			//Maximize browser window
			driver.manage().window().maximize();
			//Set timeout
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));

			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(new String(Base64.encodeBase64(prop.getProperty("password").getBytes())));

			driver.findElement((By.id("boginbutton"))).click();

			//Print Encrypted Password
			System.out.println("Encrypted Password =: " + new String(Base64.encodeBase64(prop.getProperty("password").getBytes())));
			//Print Decrypted Password
			System.out.println("Decrypted Password =: " + new String(Base64.decodeBase64(Base64.encodeBase64(prop.getProperty("password").getBytes()))));

			//close firefox browser
			driver.close();
		}
	}

	////////////////////////////
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.TimeZone;


	public class Date_Time {

		public static void main(String[] args) {

			// Local date and time
			Date date = new Date(); 
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm a");

			// Get US/Eastern time
			formatter.setTimeZone(TimeZone.getTimeZone("US/Eastern")); 
			// Prints the date in the US timezone 
			System.out.println("US/Eastern date & time : " +formatter.format(date)); 


			// Set the formatter to use a different timezone 
			formatter.setTimeZone(TimeZone.getTimeZone("IST")); 
			// Prints the date in the IST timezone 
			System.out.println("India date & time : " +formatter.format(date));

			// To get all available Time-zones
			String[] allTimeZones = TimeZone.getAvailableIDs(); 
			for (int i = 0; i < allTimeZones.length; i++) 
			{ 
				System.out.println(allTimeZones[i]); 
			}

		}

	}  

	/////////////////////
	How to highlight elements Selenium Webdriver using JavaScript?
			public class Element_Highlight {


		public static void main(String []args){

			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Jars\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.facebook.com");

			// Find the element
			WebElement username= driver.findElement(By.id("email"));

			// Call Element highlighter method
			highLightElement(driver,username);

		}

		// Element highlighter method
		public static void highLightElement(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;

			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {

				System.out.println(e.getMessage());
			}

			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
		}

	}
	/////////////////////////////////

	How to select date from datepicker using Selenium WebDriver?
			public class Date_Picker {

		public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Jars\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://jqueryui.com/datepicker/");
			driver.switchTo().frame(0);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			//Click on textbox so that datepicker will come
			driver.findElement(By.id("datepicker")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			//Click on next so that we will be in next month
			driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();

			/*DatePicker is a table.So navigate to each cell
			 * If a particular cell matches value 13 then select it
			 */
			WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
			Listrows=dateWidget.findElements(By.tagName("tr"));
			Listcolumns=dateWidget.findElements(By.tagName("td"));

			for (WebElement cell: columns){
				//Select 6th Date
				if (cell.getText().equals("6")){
					cell.findElement(By.linkText("6")).click();
					break;
				}
			}
		}
	}

	////////////////////////
	The solution to the above problem is to specify the location of FireFox in your script.
	Here is a sample code:


		WebDriver driver=new FirefoxDriver();
	driver.get("http://www.cricinfo.com");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

	String pageSrc = driver.getPageSource();

	String textToCheck = "cricket";

	boolean isTextPresent = pageSrc.contains(textToCheck);

	//result will be true if the text is present in the page
	System.out.println("Result = " + isTextPresent);

	////////////////////////

}
