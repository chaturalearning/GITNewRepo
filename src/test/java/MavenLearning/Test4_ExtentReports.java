package MavenLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test4_ExtentReports {
	ExtentReports extent;			//extent reporter is declared globally so that it can be used outside this class
	
@BeforeTest
public void configurations() {
	String path=System.getProperty("user.div")+"\\reports\\index.html";  	//this will get the project directory path with user.div & the reports that are fetched will store in the package reports which is html 
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("Result of tests");
	reporter.config().setReportName("Automation with webdriver results");
 extent=new ExtentReports();
 extent.attachReporter(reporter);		//this will attach the details of reporter into extent class
 extent.setSystemInfo("Tester", "Chatura");
}

@Test
public void demo() {
	ExtentTest test=extent.createTest("Demo test");		//this create test need to be done mandatory as the details of test will be known & stored to/in extent by which the decision will be provided
	System.setProperty("webdriver.chrome.driver","C:\\Users\\v-chatve\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://gmail.com");
	System.out.println(driver.getTitle());
driver.close();
test.addScreenCaptureFromBase64String("capture");		//test object is create where the createTest details will store in some object, we can create that object and use it in the code to tweak the code & capture screens
test.fail("test is not right");		//if report is not reported then it will pass if we kept as failed then the report will fail
	extent.flush(); 		//this will be used to close the test it will not monitor anymore after the test and report will be generated	
}


}
