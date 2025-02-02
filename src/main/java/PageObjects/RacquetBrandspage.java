package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestComponents.BaseTest;


public class RacquetBrandspage extends BaseTest{
	
	WebDriverWait mywait;
	Actions actions;

	public RacquetBrandspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
	}
	
	@FindBy(xpath = "//div[normalize-space()='Length']/span")
    WebElement lengthDropdownElement;
	
	@FindBy(xpath = "//ol[@class='items ln-items-rac_length_filter ']/li/a")
	List<WebElement> elements;
	
	@FindBy(xpath = "//div[@class='col-sm-12']/ol/li")
	WebElement productElement;
	
	@FindBy(xpath = "//a[@title='Add to Compare']")
	WebElement compareElement;
	
	@FindBy(xpath = "//a[@class='product-item-link']/h3")
	WebElement requiredProductName;
	
	@FindBy(xpath = "//span[text()='Clear All']")
    WebElement clearAllElement;
	
	@FindBy(xpath = "//a[text()='comparison list']")
    WebElement comparisionListElement;
	
	double minValue = Double.MAX_VALUE; 
    double maxValue = Double.MIN_VALUE;
    
    //To click on the Length dropdown menu to see minimum and maximum length racquets
	public void clickOnLengthDropDown() throws InterruptedException {
		lengthDropdownElement.click();
		Thread.sleep(1500);
	}
	
	// Select racquet with minimum length
	public void clickOnMinLengthCheckBox() {
		
		int count = 0;
		
		// Iterate over elements to find the one with the minimum value
        for (WebElement element : elements) {
            String text = element.getText().split("\"")[0]; 	
            try {
                double value = Double.parseDouble(text); 
                if (value < minValue) {
                    minValue = value;
                    count = count+1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Skipping non-numeric value: " + text);
            }
        }
        
        // Select the checkbox with the minimum value
        WebElement minLengthCheckBox = driver.findElement(By.xpath("//ol[@class='items ln-items-rac_length_filter ']/li["+count+"]/input"));
        if (count != 0) {   
            minLengthCheckBox.click();
        } else {
            System.out.println("No valid numeric elements found.");  
        }	
	}
	
	// Add racquet to comparision
	public String clickOnaddToCompare() throws InterruptedException {
		mywait.until(ExpectedConditions.elementToBeClickable(productElement));
		actions.moveToElement(productElement).perform();
		mywait.until(ExpectedConditions.elementToBeClickable(compareElement));
		String productName = requiredProductName.getText();
		compareElement.click();
		Thread.sleep(2000);
		return productName;
	}
	
	// To clear all filters
	public void clickOnClearAll() {
		mywait.until(ExpectedConditions.elementToBeClickable(clearAllElement));
		clearAllElement.click();
	}
	
	// Select racquet with minimum length
	public void clickOnMaxLengthCheckBox() {
	
		int count = 0;
        // Iterate over elements to find the one with the maximum value
        for (WebElement element : elements) {
            String text = element.getText().split("\"")[0]; 	
            try {
                double value = Double.parseDouble(text); 
                if (value > maxValue) {
                	maxValue = value;
                    count = count+1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Skipping non-numeric value: " + text);
            }
        }
        
        WebElement maxLengthCheckBox = driver.findElement(By.xpath("//ol[@class='items ln-items-rac_length_filter ']/li["+count+"]/input"));
        
        // Click the element with the maximum value
        if (count != 0) {   
        	maxLengthCheckBox.click();
        } else {
            System.out.println("No valid numeric elements found.");  
        }	
	}
	
	//Go to comparision list
	public void clickOnComparisionListsLink() {
		comparisionListElement.click();
	}
	
	
 }




