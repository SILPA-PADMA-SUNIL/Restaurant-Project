package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SalesPageClass {

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();

	public SalesPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//*[text()='Sales']")
	WebElement salesTab;

	@FindBy(xpath="//h3[text()='Sales']")
	WebElement salesTitle;

	public void clickOnSalestab()
	{
		gu.clickElement(salesTab);
	}

	public boolean isSalesTitleDisplayed()
	{
		return gu.isDisplayedMethod(salesTitle);
	}

}
