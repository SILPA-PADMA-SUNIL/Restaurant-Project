package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitClass {

	Wait<WebDriver> fWait;

	public void elementToBeClickableFWait(WebElement element,WebDriver driver)
	{
		fWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		fWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void presenceOfElementLocatedWaitByName(WebDriver driver,String locator)
	{
		fWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		fWait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
	}
}
