package jagadeesh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jagadeesh.TestComponents.BaseTest;


public class HomePage extends BaseTest{

	WebDriver driver;
	Actions actions;
	
	public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.actions = new Actions(driver); // Initialize Actions here
	 }
		
	
	@FindBy(xpath = "//a[@title='Racquets']")
    WebElement racquetElement;
	
	@FindBy(xpath = "//div[@class='flex-containers racquets']/div/ul/li/a[text()='Babolat']")
    WebElement babolatBrandElement;
	
	@FindBy(xpath = "//a[@title='Shoes']")
    WebElement shoesElement;
	
	@FindBy(xpath = "//a[text()='Nike' and @href = 'https://tennisoutlet.in/shoes/nike.html']")
    WebElement nikeElement;
	
	@FindBy(xpath = "//input[@id='search']")
    WebElement searchInputElement;
	
	@FindBy(xpath = "//a[@title='Tennisoutlet']")
	WebElement homePageLinkElement;
	
	public void hoverOverRacquets() {
        actions.moveToElement(racquetElement).perform();
    }
    
	public void clickOnBabolatBrand() {
		babolatBrandElement.click();
	}
	
	//To launch the web url in browser
	public void launchApplication() {
		driver.get("https://tennisoutlet.in/");
	};
	
	//Click on Nike Shoes
	public void clickOnNikeShoes() 
	{
		actions.moveToElement(shoesElement).perform();
		nikeElement.click();
	}
	
	//Enter text in search input box 
	public void typeInputInSearch(String searchText) {
		searchInputElement.sendKeys(searchText);
	}
	
	//Go back to Main page
	public void goBackToMainPage() {
		homePageLinkElement.click();
	}
	
}
