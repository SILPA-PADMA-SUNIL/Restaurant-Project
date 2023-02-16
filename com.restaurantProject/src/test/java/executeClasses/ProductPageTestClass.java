package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import elementRepository.ProductPageClass;

public class ProductPageTestClass extends BaseClass {

	LoginPageClass lp;
	ProductPageClass pp;

	@Test(priority = 1)
	public void verifyTheProductPageIsOpenedWhileClickingOnProductTab() throws IOException  {
		
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickOnProductTab();

		Boolean actual=pp.isProducttypeTextDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2)
	public void verifyToAddNewProduct() throws IOException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();


		pp.clickOnProductTab();
		pp.clickOnAddProduct();
		
		pp.enterProductCode(pp.readProductCode(2, 1));
		pp.enterProductName(pp.readProductName(3, 1));
		pp.enterProductTax(pp.readProductTax(4, 1));
		pp.enterProductPrice(pp.readProductPrice(5, 1));
		pp.insertImageOnChooseFile(System.getProperty("user.dir")+"\\src\\main\\resources\\biriyani.jpg");
		pp.clickOnFirstSubmitBtnOnAddProduct();
		pp.clickOnSecondSubmitBtnOnAddProduct();
		
		pp.refreshTheProductPage();
		
		pp.enterDataInSearch("biriyani");

		Boolean actual=pp.isBiriyaniDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 3)
	public void verifySearchFunctionalityByUsingProductName() throws IOException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickOnProductTab();
		
		pp.enterDataInSearch("biriyani");

		String expected="biriyani";
		String actual=pp.getTextOfBiriyani();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void verifySearchFunctionalityByUsingProductCode() throws IOException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();


		pp.clickOnProductTab();
		
		pp.enterDataInSearch("pr467");

		String expected="pr467";
		String actual=pp.getProductCodeOfBiriyani();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void verifyTheEditFunctionalityOfTheProduct() throws IOException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickOnProductTab();
		
		pp.enterDataInSearch("biriyani");
		
		pp.clickOnEditButton();
		pp.clearTaxColumn();
		pp.enterNewTaxValue("25");
		pp.clickSubmitButtonOnEdit();
		
		pp.enterDataInSearch("biriyani");

		Boolean actual=pp.isBiriyaniDisplayed();
		Assert.assertTrue(actual);

	}
	
	@Test(priority = 6)
	public void verifyDeleteFunctinalityOfTheProduct() throws IOException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickOnProductTab();
		
		pp.enterDataInSearch("biriyani");
		pp.clickOnDeleteButton();
		pp.clickOnDeleteConfirmationMsg();
		
		Boolean actual=pp.isNoMatchMessageDisplayed();
		Assert.assertTrue(actual);
	}
}
