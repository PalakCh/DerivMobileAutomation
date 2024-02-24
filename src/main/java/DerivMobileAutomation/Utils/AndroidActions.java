package DerivMobileAutomation.Utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidActions extends AppiumUtils{
	
AndroidDriver driver;
	
	public AndroidActions (AndroidDriver driver)
	{
		
		this.driver=driver;
	}
	
	
	public void longpress(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()),"duration",2000);
	}
	
	public void swipeleft(WebElement element)
	{		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				
			    "direction", "left",
			    "percent", 0.25
			));
	}
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}
		while(canScrollMore);
	}
	
	public void scrolltoText(String textstring)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+textstring+"\"));"));
	}
	
	public void dragdrop(WebElement ele, int x, int y)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", x,
			    "endY", y
			));
	}
	

	

}
