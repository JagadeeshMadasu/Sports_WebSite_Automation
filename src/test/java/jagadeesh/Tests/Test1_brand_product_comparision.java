package jagadeesh.Tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import jagadeesh.TestComponents.BaseTest;
import jagadeesh.PageObjects.*;


public class Test1_brand_product_comparision extends BaseTest{
	
	HomePage homePage;
	RacquetBrandspage racquetBrandsPage;
	CompareProductsPage compareProductsPage;
	@Test
	public void testBrandProductComparison() throws InterruptedException {

		homePage = new HomePage(driver);
		homePage.launchApplication();
		homePage.hoverOverRacquets();
		homePage.clickOnBabolatBrand();
		
		racquetBrandsPage = new RacquetBrandspage(driver);
		racquetBrandsPage.clickOnLengthDropDown();
		
		racquetBrandsPage.clickOnMinLengthCheckBox();

        String firstProductName = racquetBrandsPage.clickOnaddToCompare();
        
        racquetBrandsPage.clickOnClearAll();
        
        Thread.sleep(5000);

        racquetBrandsPage.clickOnLengthDropDown();
        
        
        racquetBrandsPage.clickOnMaxLengthCheckBox();
        
        String secondProductName = racquetBrandsPage.clickOnaddToCompare();
        
        List<String> expectedProducts = Arrays.asList(firstProductName, secondProductName);
        
        racquetBrandsPage.clickOnComparisionListsLink();
        
        compareProductsPage = new CompareProductsPage(driver);
        
        List<String> actualProducts = compareProductsPage.scrollAndCompare();
        
        Assert.assertEquals(expectedProducts, actualProducts);
        
        compareProductsPage.removeAllProducts(actualProducts.size());
        
        homePage.goBackToMainPage();
		
	}

}
