package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.*;
import TestComponents.BaseTest;


public class Test3_Product_Search extends BaseTest{
	
	HomePage homePage;
	ProductResultPage productResultPage;

	@Test
	public void testSearchFunctionality() {

		String searchText = "WILSON TOUR PREMIER BALLS CAN";
		
		homePage = new HomePage(driver);
		homePage.launchApplication();
		
		homePage.typeInputInSearch(searchText);
		
		productResultPage = new ProductResultPage(driver);
		
		String actualProductName = productResultPage.validateProductName();
		
		Assert.assertEquals(actualProductName, searchText);
		
		homePage.goBackToMainPage();
		
	}
}