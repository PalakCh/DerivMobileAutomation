package DerivMobileAutomation.PageObjects.Android;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import DerivMobileAutomation.Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculatorPage extends AndroidActions{
	
	AndroidDriver driver;
	private static Logger log = LogManager.getLogger(CalculatorPage.class.getName());
	
	public CalculatorPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="clear")
	private WebElement clearbutton;
	
	@AndroidFindBy(accessibility="divide")
	private WebElement dividebutton;
	
	@AndroidFindBy(accessibility="multiply")
	private WebElement multiplybutton;
	
	@AndroidFindBy(accessibility="plus")
	private WebElement addbutton;
	
	@AndroidFindBy(accessibility="minus")
	private WebElement subtractbutton;
	
	@AndroidFindBy(accessibility="equals")
	private WebElement equalsbutton;
	
	@AndroidFindBy(id="com.google.android.calculator:id/result_final")
	private WebElement resultele;
	
	@AndroidFindBy(id="com.google.android.calculator:id/formula")
	private WebElement numberenetered;
	
	public void numberclick(String x)
	{
		for(int i=0;i<x.length();i++)
		{
			if(x.substring(i, i+1).contains("."))
			{
			driver.findElement(AppiumBy.accessibilityId("point")).click();
			}
			else
			driver.findElement(AppiumBy.accessibilityId(x.substring(i,i+1))).click();
		}
	}
	
	public void performadd(String x, String y) throws InterruptedException
	{
		numberclick(x);
		addbutton.click();
		numberclick(y);
		equalsbutton.click();
		
		float result=Float.parseFloat(resultele.getText());
		float expected=convertstringtofloat(x)+convertstringtofloat(y);
		
		Assert.assertEquals(result, expected);
		System.out.println("The calculated actual add amount result is"+result);
		System.out.println("The calculated expected add amount result is"+expected);
		log.info("Expected amount is equal to the actual amount");
		
		clearbutton.click();
	}
	
	public void performsubtract(String x, String y) throws InterruptedException
	{
		
		numberclick(x);	
		subtractbutton.click();
		numberclick(y);
		equalsbutton.click();

		float result=Float.parseFloat(resultele.getText());
		
		float expected=convertstringtofloat(x)-convertstringtofloat(y);
		
		Assert.assertEquals(result, expected);
		System.out.println("The calculated actual subtract amount result is"+result);
		System.out.println("The calculated expected subtract amount result is"+expected);
		log.info("Expected amount is equal to the actual amount");
		clearbutton.click();
	}
	
	public void performmultiply(String x, String y) throws InterruptedException
	{
		
		numberclick(x);	
		multiplybutton.click();
		numberclick(y);
		
		equalsbutton.click();
		
		float result=roundofffloat(Float.parseFloat(resultele.getText()));
		float expected=roundofffloat(convertstringtofloat(x)*convertstringtofloat(y));
		
		Assert.assertEquals(result, expected);
		System.out.println("The calculated actual multiply amount result is"+result);
		System.out.println("The calculated expected multiply amount result is"+expected);
		log.info("Expected amount is equal to the actual amount");
		clearbutton.click();
	}
	
	public void performdivide(String x, String y) throws InterruptedException
	{
		
		numberclick(x);
		dividebutton.click();
		numberclick(y);
		
		equalsbutton.click();
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.format(Float.parseFloat(resultele.getText()));
		float result=roundofffloat(Float.parseFloat(resultele.getText()));
		float expected=roundofffloat(convertstringtofloat(x)/convertstringtofloat(y));
		
		Assert.assertEquals(result, expected);
		System.out.println("The calculated actual divide amount result is"+result);
		System.out.println("The calculated expected divide amount result is"+expected);
		log.info("Expected amount is equal to the actual amount");
		clearbutton.click();
	}
	
		
	}
	
	
	
	

