package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ExpensePageClass;
import elementRepository.LoginPageClass;

public class ExpensePageTestClass extends BaseClass {

	LoginPageClass lp;
	ExpensePageClass ep;

	@Test(priority=1)
	public void verifyTheExpensePageIsOpenedByClickingTheExpenseTab()  throws IOException 
	{
		lp=new LoginPageClass(driver);
		ep=new ExpensePageClass(driver);

		lp.login();
		
		ep.clickOnExpenseTab();
		String expected="Expence";
		String actual=ep.getExpensetext();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=2)
	public void verifyTheAddExpenseButtonIsVisible()  throws IOException 
	{
		lp=new LoginPageClass(driver);
		ep=new ExpensePageClass(driver);
		
		lp.login();

		ep.clickOnExpenseTab();

		boolean actual=ep.isAddExpenceBtnIsDisplayed();
		Assert.assertTrue(actual);
	}
}
