package jagadeesh.PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jagadeesh.TestComponents.BaseTest;

public class CompareProductsPage extends BaseTest{
	
	JavascriptExecutor js;
	WebDriverWait mywait;
	
	public CompareProductsPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        this.mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	@FindBy(xpath = "//strong[@class='product-item-name']/a")
	List<WebElement> actualProductsElements;
	
	@FindBy(xpath = "//table[@id='product-comparison']/thead/tr/td[1]/a")
    WebElement removeElement;
	
	
	@FindBy(xpath = "//div[contains(text(),'Are you sure')]")
    WebElement confirmationElement;
	
	
	@FindBy(xpath = "//button/span[text()='OK']")
    WebElement okElement;
	
	// Scroll to compare the products
	public List<String> scrollAndCompare() {
		
		js.executeScript("window.scrollBy(0,200)");
		
		List<String> actualProducts = new ArrayList<>();
		
		for (WebElement element : actualProductsElements) {
            actualProducts.add(element.getText());
        }
		return actualProducts;
	}
	
	public void clickOnRemoveProduct() {
		removeElement.click();
		mywait.until(ExpectedConditions.elementToBeClickable(confirmationElement));
	}
	
	public void clickOnOk() {
		okElement.click();
	}
	
	public void removeProducts() {
		
		clickOnRemoveProduct();
		clickOnOk();
		
	}
	
	//Remove all products from comparision list
	public void removeAllProducts(int size) {
		for(int i=0;i<size;i++) {
			removeProducts();
		}
	}
}