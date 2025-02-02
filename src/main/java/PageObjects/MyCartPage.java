package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestComponents.BaseTest;


public class MyCartPage extends BaseTest{
	
	WebDriverWait mywait;

	public MyCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//div[@id='ui-id-2']")
    WebElement myCartElement;
	
	@FindBy(xpath = "//a[@title='Remove']")
    WebElement removeLogoElement;
	
	@FindBy(xpath = "//div[@id='modal-content-41']")
    WebElement confirmationElement;
	
	@FindBy(xpath = "//button[@class='action-primary action-accept']")
    WebElement acceptElement;
	
	@FindBy(xpath = "//strong[@class='subtitle empty']")
    WebElement emptyCartElement;
	
	@FindBy(xpath = "//*[local-name()='g'][@id='cross']")
    WebElement crossElement;
	
	//Remove product from cart
	public String removeProductFromCart() {
		mywait.until(ExpectedConditions.elementToBeClickable(myCartElement)) ;
		
		mywait.until(ExpectedConditions.elementToBeClickable(removeLogoElement)) ;
		
		removeLogoElement.click();
		
		mywait.until(ExpectedConditions.elementToBeClickable(acceptElement)) ;
		
		acceptElement.click();
		
		mywait.until(ExpectedConditions.elementToBeClickable(emptyCartElement)) ;
		
		return emptyCartElement.getText().toString();
	}
	
	//Click on close
	public void clickOnClose() {
		crossElement.click();
	}
	
	}