package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import elementRepository.StorePageClass;



public class StorePageTestClass extends BaseClass {
	
	LoginPageClass lp;
	StorePageClass sp;
	
	@Test(priority = 1)
	  public void verifyTheStoresPageIsVisibleByClickingOnStoresTab()  throws IOException  {
		  
		  lp=new LoginPageClass(driver);
		  sp=new StorePageClass(driver);
		  
		  lp.enterUserName(lp.readUserName(0, 1));
			lp.enterpassword(lp.readPassword(1, 1));
			lp.clickOnLoginButton();
			
			sp.ClickStoresTab();
			
			Boolean actual=sp.isStoreNameDisplayed();
			Assert.assertTrue(actual);
	  }
	  
	  @Test(priority = 2)
	  public void verifyToCreateANewStore()  throws IOException, InterruptedException 
	  {
		  lp=new LoginPageClass(driver);
		  sp=new StorePageClass(driver);
		  
		  lp.enterUserName(lp.readUserName(0, 1));
			lp.enterpassword(lp.readPassword(1, 1));
			lp.clickOnLoginButton();

			
			sp.ClickStoresTab();
			sp.clickAddStore();
			sp.enterStoreName(sp.readStoreName(6, 1));
			
			sp.clickOnSubmit();
			sp.enterValueToSearch("Azstore");
			
			Boolean actual=sp.isAzStoreDisplayed();
			Assert.assertTrue(actual);
	  }
	  
	  @Test(priority=3)
	  public void verifyStoreNameSearchByUsingStoreName()  throws IOException  
	  {

		  lp=new LoginPageClass(driver);
		  sp=new StorePageClass(driver);
		  
		  lp.enterUserName(lp.readUserName(0, 1));
			lp.enterpassword(lp.readPassword(1, 1));
			lp.clickOnLoginButton();

		  
		  sp.ClickStoresTab();
		  sp.enterValueToSearch("Azstore");
		  
		  boolean actual=sp.isAzStoreDisplayed();
		  Assert.assertTrue(actual);
		  
		  
	  }
	  @Test(priority=4)
	  public void verifyTheAddStoreButtonIsVisible()  throws IOException 
	  {

		  lp=new LoginPageClass(driver);
		  sp=new StorePageClass(driver);
		  
		  lp.enterUserName(lp.readUserName(0, 1));
			lp.enterpassword(lp.readPassword(1, 1));
			lp.clickOnLoginButton();

		  
		  sp.ClickStoresTab();
		  Boolean actual=sp.isAddStorebuttonDisplayed();
		  Assert.assertTrue(actual);
		  
	  }
}
