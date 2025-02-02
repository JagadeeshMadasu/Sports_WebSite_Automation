package PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestComponents.BaseTest;


public class ProductResultPage extends BaseTest{
	
	WebDriverWait mywait;

	public ProductResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//span[text()='Wilson Tour Premier Balls Can']")
	WebElement productName;
	
	//To verify the product name after searching
	public String validateProductName() {
		mywait.until(ExpectedConditions.elementToBeClickable(productName)) ;
		
		String actualProductName = productName.getText();
		
		return actualProductName;
	}
}