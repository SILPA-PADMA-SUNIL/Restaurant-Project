package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import elementRepository.WaitersPageClass;

public class WaitersPageTestClass extends BaseClass {

	LoginPageClass lp;
	WaitersPageClass wp;

	@Test(priority = 1)
	public void verifyTheWaiterPageIsVisibleByClickingOnWaiterUnderPeopleTab() throws IOException {

		lp=new LoginPageClass(driver);
		wp=new WaitersPageClass(driver);

		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaiters();

		Boolean actual=wp.isWaiterNameDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2)
	public void verifyTheAddWaiterButtonIsVisible() throws IOException
	{
		lp=new LoginPageClass(driver);
		wp=new WaitersPageClass(driver);

		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaiters();

		Boolean actual=wp.isAddWaiterButtonDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 3)
	public void verifyToAddANewWaiter() throws IOException
	{
		lp=new LoginPageClass(driver);
		wp=new WaitersPageClass(driver);
		
		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaiters();
		wp.clickOnAddWaiterButton();
		wp.enterWaiterName("David");
		wp.enterPhoneNumber("9080765530");
		wp.clickOnSubmitButton();
		wp.enterDataOnSearchBox("David");

		Boolean actual=wp.isDavidDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 4)  
	public void verifyToSearchAWaiterUsingName() throws IOException
	{
		lp=new LoginPageClass(driver);
		wp=new WaitersPageClass(driver);

		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaiters();
		wp.enterDataOnSearchBox("David");

		String expected="David";
		String actual=wp.getTextOfDavid();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 5)  
	public void verifyToSearchAWaiterUsingMobileNumber() throws IOException
	{
		lp=new LoginPageClass(driver);
		wp=new WaitersPageClass(driver);

		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaiters();
		wp.enterDataOnSearchBox("9080765530");

		String expected="9080765530";
		String actual=wp.getTextOfPhoneDavid();
		Assert.assertEquals(actual, expected);
	}
}
