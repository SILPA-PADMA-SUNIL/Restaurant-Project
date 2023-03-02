package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import elementRepository.SalesPageClass;

public class SalesPageTestClass extends BaseClass {

	LoginPageClass lp;
	SalesPageClass sl;

	@Test(priority = 1)
	public void verifyTheSalesPageIsVisibleByClickingOnSalesTab() throws IOException {

		lp=new LoginPageClass(driver);
		sl=new SalesPageClass(driver);

		lp.login();

		sl.clickOnSalestab();

		Boolean actual=sl.isSalesTitleDisplayed();
		Assert.assertTrue(actual);

	}
}
