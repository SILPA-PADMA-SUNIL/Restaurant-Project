package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class StorePageClass {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public StorePageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[text()='Stores']")
	WebElement storesTab;
	
	@FindBy(xpath="//table[@id='Table']//tr//th[1]")
	WebElement storeName;
	
	@FindBy(xpath="//button[contains(text(),'Add Store')]")
	WebElement addStore;
	
	@FindBy(id="StoreName")
	WebElement addStoreName;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement storeSearch;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement azStore;
	
	public void ClickStoresTab()
	{
		gu.clickElement(storesTab);
	}
	 public boolean isStoreNameDisplayed()
	 {
		 return gu.isDisplayedMethod(storeName);
	 }
	 public void clickAddStore()
	 {
		 gu.scrollToElement(addStore, driver);
		 gu.clickElement(addStore);
	 }
	 public void enterStoreName(String sname)
	 {
		 gu.typeIntoAnElement(addStoreName, sname);
	 }

	 public String readStoreName(int row,int col) throws IOException
		{
			return(ExcelReadClass.readStringData(row, col));
		}
	 
	 public void clickOnSubmit() throws InterruptedException
	 {
		 gu.addThreadSleep();
		 gu.clickElement(submitBtn);
	 }
	 public void enterValueToSearch(String data) 
	 {
		 gu.typeIntoAnElement(storeSearch,data);
		 
	 }
	 public boolean isAzStoreDisplayed()
	 {
		 return gu.isDisplayedMethod(azStore);
	 }
	 public boolean isAddStorebuttonDisplayed()
	 {
		 gu.scrollToElement(addStore, driver);
		 return gu.isDisplayedMethod(addStore);
	 }
	

}
