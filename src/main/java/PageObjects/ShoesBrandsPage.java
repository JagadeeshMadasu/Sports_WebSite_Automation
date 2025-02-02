package PageObjects;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestComponents.BaseTest;


public class ShoesBrandsPage extends BaseTest{
	
	WebDriverWait mywait;
	Actions actions;
	JavascriptExecutor js;

	public ShoesBrandsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver; 
	}
	
	
	@FindBy(xpath = "//div[text()='NEW']")
    WebElement newElement;
	
	@FindBy(xpath = "//div[text()='NEW']/parent::div/parent::div/a")
    WebElement newProductElement;
	
	@FindBy(xpath = "//div[@class='swatch-attribute shoe_size']/div/div[text()='7']")
    WebElement sizeElement;
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
    WebElement addToCartElement;
	
	//To click on a NEW labelled product
	public void clickOnNewProduct() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true);",newElement );
		newProductElement.click();
		Thread.sleep(4000);
	}
	
	
	
	
}