package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ProductPageClass {

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();

	public ProductPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="(//*[text()='Product'])[1]")
	WebElement productTab;

	@FindBy(xpath="//label[text()='Product type']")
	WebElement productTypetext;

	@FindBy(xpath="//button[text()='Add Product']")
	WebElement addProductBtn;

	@FindBy(xpath="//input[@id='ProductCode']")
	WebElement productCode;

	@FindBy(xpath="//input[@id='ProductName']")
	WebElement productName;

	@FindBy(xpath="//input[@id='Tax']")
	WebElement tax;

	@FindBy(xpath="//input[@id='Price']")
	WebElement price;

	@FindBy(xpath="(//input[@id='ImageInput'])[1]")
	WebElement chooseFile;

	@FindBy(xpath="(//button[text()='Submit'])[1]")
	WebElement submitBtnFirstAddProduct;

	@FindBy(xpath="(//button[text()='submit'])[2]")
	WebElement submitBtnSecondAddProduct;

	@FindBy(xpath="//input[@type='search']")
	WebElement searchBox;

	@FindBy(xpath="//table[@id='Table']//tbody//tr")
	WebElement biriyaniEntireRow;

	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[2]")
	WebElement biriyaniColumn;

	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement biriyaniProductCode;

	@FindBy(xpath="//a[@class='btn btn-default']/following-sibling::a[2]")
	WebElement editBtn;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtnOnEdit;

	@FindBy(xpath="//a[@class='btn btn-default']/preceding-sibling::a[1]")
	WebElement deleteOption;

	@FindBy(xpath="//a[text()='Yes, delete it!']")
	WebElement deleteconfirmation;

	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement noMatchMsg;

	public void clickOnProductTab()
	{
		gu.clickElement(productTab);
	}
	public boolean isProducttypeTextDisplayed()
	{
		return gu.isDisplayedMethod(productTypetext);
	}
	public void clickOnAddProduct()
	{
		gu.scrollToElement(addProductBtn, driver);
		gu.clickElement(addProductBtn);
	}

	public void enterProductCode(String data)
	{
		gu.typeIntoAnElement(productCode, data);
	}
	public void enterProductName(String name)
	{
		gu.typeIntoAnElement(productName, name);
	}
	public String readProductCode(int row,int col) throws IOException
	{
		return(ExcelReadClass.readStringData(row, col));
	}
	public String readProductName(int row,int col) throws IOException
	{
		return(ExcelReadClass.readStringData(row, col));
	}

	public void enterProductTax(String data)
	{
		gu.typeIntoAnElement(tax, data);
	}
	public void enterProductPrice(String data)
	{
		gu.typeIntoAnElement(price, data);
	}

	public String readProductTax(int row,int col) throws IOException
	{
		return(ExcelReadClass.readIntegerData(row, col));
	}

	public String readProductPrice(int row,int col) throws IOException
	{
		return(ExcelReadClass.readIntegerData(row, col));
	}

	public void insertImageOnChooseFile(String path)
	{
		gu.typeIntoAnElement(chooseFile, path);
	}

	public void clickOnFirstSubmitBtnOnAddProduct()
	{
		gu.clickElement(submitBtnFirstAddProduct);
	}

	public void clickOnSecondSubmitBtnOnAddProduct()
	{
		gu.clickElement(submitBtnSecondAddProduct);
	}

	public void refreshTheProductPage()
	{
		gu.pageRefresh(driver);	
	}

	public void enterDataInSearch(String data)
	{
		ew.presenceOfElementLocatedWaitByXpath(driver, "//input[@type='search']");
		gu.typeIntoAnElement(searchBox,data);
	}

	public boolean isBiriyaniDisplayed()
	{
		return gu.isDisplayedMethod(biriyaniEntireRow);	
	}

	public String getTextOfBiriyani()
	{
		return gu.getTextOfAnElement(biriyaniColumn);
	}

	public String getProductCodeOfBiriyani()
	{
		return gu.getTextOfAnElement(biriyaniProductCode);
	}

	public void clickOnEditButton()
	{
		gu.clickElement(editBtn);
	}

	public void clearTaxColumn()
	{
		gu.clearElement(tax);
	}

	public void enterNewTaxValue(String data)
	{
		gu.typeIntoAnElement(tax, data);
	}

	public void clickSubmitButtonOnEdit()
	{
		gu.clickElement(submitBtnOnEdit);
	}

	public void clickOnDeleteButton()
	{
		gu.clickElement(deleteOption);
	}

	public void clickOnDeleteConfirmationMsg()
	{
		gu.clickElement(deleteconfirmation);	
	}

	public boolean isNoMatchMessageDisplayed()
	{
		return gu.isDisplayedMethod(noMatchMsg);
	}
}


