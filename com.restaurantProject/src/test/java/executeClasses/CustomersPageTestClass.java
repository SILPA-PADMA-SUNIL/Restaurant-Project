package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.CustomersPageClass;
import elementRepository.LoginPageClass;

public class CustomersPageTestClass extends BaseClass{

	LoginPageClass lp;
	CustomersPageClass cp;

	@Test(priority = 1)
	public void verifyThecustomerPageIsVisibleByClickingOncustomersunderPeopleTab() throws IOException {

		lp=new LoginPageClass(driver);
		cp=new CustomersPageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();
		
		cp.clickPeopleTab();
		cp.clickCustomersTab();

		Boolean actual=cp.isCustomerNameDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority=2)
	public void verifyTheAddcustomerButtonIsVisibleOrNot() throws IOException 
	{
		lp=new LoginPageClass(driver);
		cp=new CustomersPageClass(driver);
		
		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();

		boolean actual=cp.isAddcustomerBtnVisible();
		Assert.assertTrue(actual);
	}
	@Test(priority=3)
	public void veriytoAddaNewcustomer() throws IOException 
	{
		lp=new LoginPageClass(driver);
		cp=new CustomersPageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();
		
		cp.clickAddcustomer();
		cp.enterCustomerName("divya");
		cp.enterCustomerPhone("7998096589");

		cp.clickOnSubmitButton();
		Boolean actual=cp.isSearchedNameDivyaDisplayed();
		Assert.assertTrue(actual);

	}
	@Test(priority=4)
	public void verifytoSearchACustomerByUsingName() throws IOException, InterruptedException 
	{
		lp=new LoginPageClass(driver);
		cp=new CustomersPageClass(driver);


		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();
		
		cp.enterSearchValue("divya");
		
		Boolean actual=cp.isSearchedNameDivyaDisplayed();
		Assert.assertTrue(actual);

		
	}
	@Test(priority=5)
	public void verifytoSearchACustomerByUsingMobileNumber() throws IOException, InterruptedException 
	{
		lp=new LoginPageClass(driver);
		cp=new CustomersPageClass(driver);


		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		cp.clickPeopleTab();
		cp.clickCustomersTab();
		
		cp.enterSearchValue("7998096589");
		
		String expected="7998096589";
		String actual=cp.getTextOfPhoneDivya();
		Assert.assertEquals(actual, expected);



	}

}

