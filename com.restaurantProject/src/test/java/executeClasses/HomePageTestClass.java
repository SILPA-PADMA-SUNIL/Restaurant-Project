package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePageClass;
import elementRepository.LoginPageClass;

public class HomePageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;


	@Test(priority = 1, groups = {"group-1"})
	public void varifyProductTabIsDisplayed() throws IOException 
	{
		lp=new LoginPageClass(driver);
		hp=new HomePageClass(driver);

		lp.login();

		Boolean actual=hp.isProductTabDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2, groups = {"group-1"})
	public void varifyD4StoreIsDisplayed() throws IOException 
	{

		lp=new LoginPageClass(driver);
		hp=new HomePageClass(driver);

		lp.login();
		
		Boolean actual=hp.isD4StoreDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority = 3, groups = {"functional"})
	public void varifyLogoutButtonIsWorking() throws IOException, InterruptedException 
	{

		lp=new LoginPageClass(driver);
		hp=new HomePageClass(driver);

		lp.login();

		hp.clickOnlogoutButton();

		Boolean actual=lp.isLoginTextDisplayed();
		Assert.assertTrue(actual);
	}
}
