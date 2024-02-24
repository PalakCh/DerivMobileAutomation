package DerivMobileAutomation.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import DerivMobileAutomation.PageObjects.Android.CalculatorPage;
import DerivMobileAutomation.Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends AppiumUtils{
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public CalculatorPage cp;

	@BeforeClass(alwaysRun=true)
	public CalculatorPage congifureAppium() throws URISyntaxException, IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//DerivMobileAutomation//resources//data.properties");
		prop.load(fis);
		
		//Start Appium Service
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		
		service= startAppiumService(ipAddress,Integer.parseInt(port));
				
		//Connect to emulator and app
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName")); //emulator
		options.setApp(System.getProperty("user.dir")+"//src//test//java//DerivMobileAutomation//apkfiles//calculator-8-4-1-520193683.apk");
				
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cp = new CalculatorPage(driver);
		return cp;
	}
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		//stop server
		driver.quit();
		service.stop();
	}
}
