package DerivMobileAutomation.Utils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	
	public AppiumDriverLocalService service;
	

	
	public AppiumDriverLocalService startAppiumService(String ipaddress, int port)
	{
		service= new AppiumServiceBuilder().withAppiumJS(new File("C://Users//DELL//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipaddress).usingPort(port).build();
		service.start();
		return service;
				
	}
	
	public void waitForElementToAppear(WebElement we1, AppiumDriver driver)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(we1));
	}
	
	public String takeScreenshort(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot s=(TakesScreenshot)driver;
		File source=s.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		
		FileHandler.copy(source, destination);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
		
	}
	
	public String generateRandomNumber()
	{
		Random r = new Random();
		float random=1 + r.nextFloat() * (100 - 1);
		return String.format("%.02f", random);
	}
	
	public String generateRandomNumber1to50()
	{
		Random r = new Random();
		float random=1 + r.nextFloat() * (50 - 1);
		return String.format("%.02f", random);
	}
	
	public String generateRandomNumber51to100()
	{
		Random r = new Random();
		float random=51 + r.nextFloat() * (100 - 51);
		return String.format("%.02f", random);
	}

	public float convertstringtofloat (String s)
	{
		Float num=Float.parseFloat(s);
		return num;
		/*
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		String s2=df.format(num);
		return Float.parseFloat(s2);*/
	}
	
	public float roundofffloat(float num)
	{
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		String s2=df.format(num);
		return Float.parseFloat(s2);
	}
}
