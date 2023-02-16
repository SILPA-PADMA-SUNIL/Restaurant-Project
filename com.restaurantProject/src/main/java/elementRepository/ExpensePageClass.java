package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ExpensePageClass {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	

	public ExpensePageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//*[text()='Expense'])[1]")
	WebElement expenseTab;
	
	@FindBy(xpath="//h3[text()='Expence']")
	WebElement expenseTitle;
	
	@FindBy(xpath="//button[contains(text(),'Add Expence')]")
	WebElement addExpenseBtn;
	
	public void clickOnExpenseTab()
	{
		gu.clickElement(expenseTab);
	}
	
	public String getExpensetext()
	{
		return gu.getTextOfAnElement(expenseTitle);
	}
	
	public boolean isAddExpenceBtnIsDisplayed()
	{
		gu.scrollToElement(addExpenseBtn, driver);
		return gu.isDisplayedMethod(addExpenseBtn);
	}
	

}
