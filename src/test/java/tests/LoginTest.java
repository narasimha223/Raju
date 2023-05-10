package tests;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import util.DataUtil;
import util.MyXLSReader;

public class LoginTest extends Base {
	WebDriver driver;
	MyXLSReader excelReader;
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@Test(dataProvider="dataSupplier")
	public void testLogin(HashMap<String, String> hMap) {
		if(!DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			throw new SkipException("Run mose is set to N, hence not executed");
		}
		driver=openBrowserApplicationURL(hMap.get("Browser"));
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccountMenu();
		LoginPage loginPage=homePage.selectLoginOption();
		loginPage.enterEmailAddress(hMap.get("Username"));
		loginPage.enterpassword(hMap.get("Password"));
		AccountPage accountPage=loginPage.clickLoginButton();
		
	
		
		
		String expectedResult=hMap.get("ExpectedResult");
		boolean expectedConvertedResult = false;
		if(expectedResult.equalsIgnoreCase("Success")) {
			expectedConvertedResult=true;
		}else if(expectedResult.equalsIgnoreCase("Failure")) {
			expectedConvertedResult=false;
		}
		boolean actualResult=false;
		actualResult=accountPage.verifyTheDisplayofEditYourAccountInformationOption();
		
			Assert.assertEquals(actualResult, expectedConvertedResult);
		}
		
	
		
	
@DataProvider
public Object [][] dataSupplier() {
	
	Object[][] data=null;
	try {
		 excelReader = new MyXLSReader("src\\test\\resources\\Narasimha.xlsx");
		 data= DataUtil.getTestData(excelReader, "LoginTest", "Data");
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return data;

}
}
