package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePageClass;
import elementRepository.LoginPageClass;

public class HomePageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;


	@Test(priority = 1)
	public void varifyProductTabIsDisplayedOrNot() throws IOException 
	{
		lp=new LoginPageClass(driver);
		hp=new HomePageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		Boolean actual=hp.isProductTabDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2)
	public void varifyD4StoreIsDisplayedOrNot() throws IOException 
	{

		lp=new LoginPageClass(driver);
		hp=new HomePageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		Boolean actual=hp.isD4StoreDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority = 3)
	public void varifyLogoutButtonIsWorkingOrNot() throws IOException, InterruptedException 
	{

		lp=new LoginPageClass(driver);
		hp=new HomePageClass(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterpassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		hp.clickOnlogoutButton();

		Boolean actual=lp.isLoginTextDisplayed();
		Assert.assertTrue(actual);
	}
}
