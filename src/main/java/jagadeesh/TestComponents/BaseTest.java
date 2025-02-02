package jagadeesh.TestComponents;

import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import jagadeesh.PageObjects.*;
import org.apache.commons.io.FileUtils;
import java.util.Date;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

public class BaseTest {

	public WebDriver driver;
	
	public HomePage homePage;
	
	public static ExtentReports extent;
    public static ExtentTest test;

	public WebDriver initializeDriver() 

	{
		ChromeOptions options = new ChromeOptions();

		// To enable the cookies for seamless web performance
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.cookies", 1);
        prefs.put("profile.cookie_controls_mode", 1);

        options.setExperimentalOption("prefs", prefs);
        
        //Initialize and maximize the driver with Chrome driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		return driver;
	}
	

	@BeforeMethod
    public void setup(Method method) {
        driver = initializeDriver();
        //To log the test results in extent test reports
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
    	//Logs passed and failed tests along with screenshot
    	if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot(result.getName());
            Media screenshot = MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();
			test.fail("Test Failed: " + result.getThrowable().getMessage(), screenshot);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        }
        driver.quit();
    }
    
    @BeforeSuite
    public void setupExtentReports() {
    	
    	//Find or create folder to save reports
    	File reportDir = new File(System.getProperty("user.dir") + "/test-output");
        if (!reportDir.exists()) {
            reportDir.mkdir(); 
        }
        
    	String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
    	
    	//To handle visualization of generated reports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Functional Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);

        //Initialize reports generation
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    
    @AfterSuite
    public void getReports() {
    	//Generate the reports
        extent.flush(); 
    }
    
    public String captureScreenshot(String testName) {
    	//Capture failed test screenshot
    	File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	
    	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    	String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + "_" + timestamp + ".png"; 
    	File destFile = new File(screenshotPath);
        
        try {
        	FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return screenshotPath;
    }
}
