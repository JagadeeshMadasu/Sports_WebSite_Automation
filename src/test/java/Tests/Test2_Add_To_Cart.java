package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.*;
import TestComponents.BaseTest;


public class Test2_Add_To_Cart extends BaseTest{
	
	HomePage homePage;
	ShoesBrandsPage shoesBrandsPage;
	AddToCartPage addToCartPage;
	MyCartPage myCartPage;
	
	@Test
	public void testAddandRemoveShoes() throws InterruptedException  {
		
		homePage = new HomePage(driver);
		homePage.launchApplication();
		
		homePage.clickOnNikeShoes();
		
		shoesBrandsPage = new ShoesBrandsPage(driver);
		
		shoesBrandsPage.clickOnNewProduct();
		
		addToCartPage = new AddToCartPage(driver);
		
		
		addToCartPage.addToCart();

		myCartPage = new MyCartPage(driver);
		
		String actualText = myCartPage.removeProductFromCart();
		
		String expectedText = "You have no items in your shopping cart.";
		
		Assert.assertEquals(actualText,expectedText); 
		
		myCartPage.clickOnClose();
		
		homePage.goBackToMainPage();
		
		}	
	}