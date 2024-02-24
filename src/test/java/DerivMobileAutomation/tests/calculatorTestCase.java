package DerivMobileAutomation.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


import DerivMobileAutomation.TestUtils.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class calculatorTestCase extends BaseTest{
	
	@Test
	public void additionOperation() throws InterruptedException
	{
		cp.performadd(generateRandomNumber(),generateRandomNumber());
		
	}
	
	@Test
	public void subtractionOperation() throws InterruptedException
	{
		cp.performsubtract(generateRandomNumber51to100(),generateRandomNumber1to50());
		
	}
	
	@Test
	public void multiplicationOperation() throws InterruptedException
	{
		cp.performmultiply(generateRandomNumber(),generateRandomNumber());
		
	}
	
	@Test
	public void divisonOperation() throws InterruptedException
	{
		cp.performdivide(generateRandomNumber(),generateRandomNumber());
		
	}
	

}
