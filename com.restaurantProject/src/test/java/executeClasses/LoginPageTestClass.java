package executeClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageClass;

public class LoginPageTestClass extends BaseClass {

	LoginPageClass lp;

	@Test(priority=1, groups = {"group-1"})
	public void varifyTheLoginPageIsDisplayedByHittingTheUrl() throws InterruptedException 
	{
		lp=new LoginPageClass(driver);

		Boolean actual=lp.isLoginTextDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority=2, groups = {"group-1"})
	public void varifyTheRestaurantLogoIsDisplayed() 
	{
		lp=new LoginPageClass(driver);

		Boolean actual=lp.isLogoDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority=3,dataProvider="successfulLogin",dataProviderClass=DataProviderClass.class, groups = {"login-1"})
	public void varifySuccessfulLogin(String uname,String pwd) 
	{
		lp=new LoginPageClass(driver);

		lp.enterUserName(uname);
		lp.enterpassword(pwd);
		lp.clickOnLoginButton();

		String expected="  admin Doe";
		String actual=lp.getTextOfAdminName();
		Assert.assertEquals(actual,expected);


	}

	@Test(priority=4,dataProvider="UnSuccessfulLogin",dataProviderClass=DataProviderClass.class, groups = {"login-1"})
	public void varifyUnSuccessfulLogin(String uname,String pwd) throws InterruptedException 
	{
		lp=new LoginPageClass(driver);

		lp.enterUserName(uname);
		lp.enterpassword(pwd);
		lp.clickOnLoginButton();

		Boolean actual=lp.isLoginTextDisplayed();
		Assert.assertTrue(actual);


	}


}
