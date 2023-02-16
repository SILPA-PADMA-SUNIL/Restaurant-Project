package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;


public class CustomersPageClass {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public CustomersPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//*[text()='People']")
	WebElement peopleTab;
	
	@FindBy(xpath="//*[text()='Customers']")
	WebElement customersTab;
	
	@FindBy(xpath="//table[@id='Table']//thead//tr//th[1]")
	WebElement customerNameDisplayed;
	
	@FindBy(xpath="//button[contains(text(),'Add Customer')]")
	WebElement addcustomerBtn;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement customerName;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement customerPhone;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement nameDivya;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[2]")
	WebElement phoneDivya;
		
	public void clickPeopleTab()
	{
		gu.clickElement(peopleTab);
	}
	
	public void clickCustomersTab()
	{
		gu.clickElement(customersTab);
	}
	
	public boolean isCustomerNameDisplayed()
	{
		return gu.isDisplayedMethod(customerNameDisplayed);
	}
	
	public boolean isAddcustomerBtnVisible()
	{
		gu.scrollToElement(addcustomerBtn, driver);
		return gu.isDisplayedMethod(addcustomerBtn);
	}
	
	public void clickAddcustomer()
	{
		gu.clickElement(addcustomerBtn);
	}
	
	public void enterCustomerName(String name)
	{
		gu.typeIntoAnElement(customerName, name);
	}
	
	public void enterCustomerPhone(String number)
	{
		gu.typeIntoAnElement(customerPhone, number);
	}
	
	public void clickOnSubmitButton()
	{
		gu.clickElement(submitBtn);
	}
	
	public void enterSearchValue(String data)
	{
		gu.typeIntoAnElement(searchField, data);
	}
	
	public boolean isSearchedNameDivyaDisplayed()
	{
		return gu.isDisplayedMethod(nameDivya);
	}
	
	public String getTextOfPhoneDivya()
	{
		return gu.getTextOfAnElement(phoneDivya);
	}
	
	

}
