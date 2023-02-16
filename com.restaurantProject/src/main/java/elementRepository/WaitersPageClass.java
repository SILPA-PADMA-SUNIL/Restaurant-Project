package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class WaitersPageClass {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public WaitersPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='People']")
	WebElement peopleTab;
	
	@FindBy(xpath="//*[text()='Waiters']")
	WebElement waiters;
	
	@FindBy(xpath="//table[@id='Table']//thead//tr//th[1]")
	WebElement waiterName;
	
	@FindBy(xpath="//button[contains(text(),'Add Waiter')]")
	WebElement addWaiterBtn;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement waiterNameOnAddWaiter; 
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phone;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBox;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement david;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[2]")
	WebElement phoneDavid;
	
	public void clickOnPeopleTab()
	{
		gu.clickElement(peopleTab);
	}
	
	public void clickOnWaiters()
	{
		gu.clickElement(waiters);
	}
	
	public Boolean isWaiterNameDisplayed()
	{
		return gu.isDisplayedMethod(waiterName);
	}
	
	public Boolean isAddWaiterButtonDisplayed()
	{
		gu.scrollToElement(addWaiterBtn, driver);
		return gu.isDisplayedMethod(addWaiterBtn);
	}
	
	public void clickOnAddWaiterButton()
	{
		gu.scrollToElement(addWaiterBtn, driver);
		gu.clickElement(addWaiterBtn);
	}
	
	public void enterWaiterName(String name)
	{
		gu.typeIntoAnElement(waiterNameOnAddWaiter, name);
	}
	
	public void enterPhoneNumber(String data)
	{
		gu.typeIntoAnElement(phone, data);
	}
	
	public void clickOnSubmitButton()
	{
		gu.clickElement(submitBtn);
	}
	
	public void enterDataOnSearchBox(String data)
	{
		gu.typeIntoAnElement(searchBox, data);
	}
	
	public Boolean isDavidDisplayed()
	{
		return gu.isDisplayedMethod(david);
	}
	
	public String getTextOfDavid()
	{
		return gu.getTextOfAnElement(david);
	}
	
	public String getTextOfPhoneDavid()
	{
		return gu.getTextOfAnElement(phoneDavid);
	}
	
	


}
