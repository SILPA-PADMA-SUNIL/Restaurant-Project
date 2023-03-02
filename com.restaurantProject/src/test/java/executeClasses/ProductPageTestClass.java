package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import elementRepository.ProductPageClass;
import extendReport.TestListener;
@Listeners(TestListener.class)

public class ProductPageTestClass extends BaseClass {

	LoginPageClass lp;
	ProductPageClass pp;
	String code;

	@Test(priority = 1, groups = {"group-1"})
	public void verifyTheProductPageIsOpenedWhileClickingOnProductTab() throws IOException  {
		TestListener.getTestInstance().get().assignCategory("smoke");
		
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.login();

		pp.clickOnProductTab();

		Boolean actual=pp.isProducttypeTextDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2, groups = {"add"})
	public void verifyToAddNewProduct() throws IOException, InterruptedException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.login();

		pp.clickOnProductTab();
		pp.clickOnAddProduct();
		
		code=pp.enterProductCode();
		System.out.println(code);
		
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

	@Test(priority = 3, groups = {"search"})
	public void verifySearchFunctionalityByUsingProductName() throws IOException, InterruptedException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);
		
		lp.login();

		pp.clickOnProductTab();
		
		code=pp.addProduct();
		
		pp.enterDataInSearch("biriyani");

		String expected="biriyani";
		String actual=pp.getTextOfBiriyani();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4, groups = {"search"})
	public void verifySearchFunctionalityByUsingProductCode() throws IOException, InterruptedException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.login();

		pp.clickOnProductTab();
		code=pp.addProduct();
		
		pp.enterDataInSearch(code);

		String expected=code;
		String actual=pp.getProductCodeOfBiriyani();
		Assert.assertEquals(actual, expected);
	}

	@Test(enabled=false,priority = 5, groups = {"edit"})
	public void verifyTheEditFunctionalityOfTheProduct() throws IOException, InterruptedException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);
		
		lp.login();

		pp.clickOnProductTab();
		code=pp.addProduct();
		
		pp.enterDataInSearch(code);
		
		pp.clickOnEditButton();
		pp.clearTaxColumn();
		pp.enterNewTaxValue("25");
		pp.clickSubmitButtonOnEdit();
		
		pp.enterDataInSearch(code);
		
		String expected=code;
		String actual=pp.getProductCodeOfBiriyani();
		Assert.assertEquals(actual, expected);

	}
	
	@Test(enabled=false,priority = 6, groups = {"delete"})
	public void verifyDeleteFunctinalityOfTheProduct() throws IOException, InterruptedException
	{
		lp=new LoginPageClass(driver);
		pp=new ProductPageClass(driver);

		lp.login();

		pp.clickOnProductTab();
		code=pp.addProduct();
		
		pp.enterDataInSearch(code);
		pp.clickOnDeleteButton();
		pp.clickOnDeleteConfirmationMsg();
		
		Boolean actual=pp.isNoMatchMessageDisplayed();
		Assert.assertTrue(actual);
	}
}
