package executeClasses;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass{

	@DataProvider(name="successfulLogin")
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "admin", "password" },

		};
	}

	@DataProvider(name="UnSuccessfulLogin")
	public Object[][] dp1() {
		return new Object[][] {
			new Object[] { "admin", "123456" },
			new Object[] { "carol", "password" },
			new Object[] { "carol", "123456" },

		};
	}
}
