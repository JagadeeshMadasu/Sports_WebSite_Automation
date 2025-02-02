package PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestComponents.BaseTest;


public class AddToCartPage extends BaseTest{
	
	WebDriverWait mywait;

	public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
	
	}
	
	@FindBy(xpath = "//div[@class='swatch-option text'][1]")
    WebElement sizeElement;
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
    WebElement addToCartElement;
	
	//Add shoe product to cart
	public void addToCart() {
		sizeElement.click();
		addToCartElement.click();
	}
	
	
	
	
}