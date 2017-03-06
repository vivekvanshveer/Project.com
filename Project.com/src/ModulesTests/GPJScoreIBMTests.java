package ModulesTests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Base.Keywords;
import Modules.GPJScoreIBM;

public class GPJScoreIBMTests extends Keywords{
	
	@BeforeSuite(description = "Initialize the Property files. After that open browser and navigate to Base URL. Login to IBM Score")
    public void init() throws Exception {
        initialize();
        openBrowser();
        navigate("Base_URL");
        login();
        reports = new ExtentReports(System.getProperty("user.dir")+"//demo.html");
    }
	
	@Test(priority = 0, description = "To verify SCORE_Non_BU_Specific_Required when we select Non BU when Client Code = 1208- IBM")
    public void ClientCodeFunctionalityTest() throws InterruptedException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.ClientCodeFunctionality();
    }


    @Test(priority = 1, description = "To Verify Estimated and Negotiated Validation ")
    public void Estimated_and_Negotiated_ValidationTest() throws InterruptedException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Estimated_and_Negotiated_Validation();
    }

    //To check for Regional Officer user's privileges [Note: Some validations are left to configure So I commented it.]
    @Test(priority = 2, description = "To check Cost Calculation of Estimate Cost, Negotiated Cost & Savings in USD ")
    public void CostCalculationInUSDTest() throws InterruptedException, IOException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.CostCalculationInUSD();
    }

    @Test(priority = 3, description = "To Verify Entry_Date_Validation_Quarter ")
    public void Entry_Date_Validation_QuarterTest() throws InterruptedException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Entry_Date_Validation_Quarter();
    }

    @Test(priority = 4, description = "To Verify SCORE_Date_Validation_Quarter ")
    public void SCORE_Date_Validation_QuarterTest() throws InterruptedException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.SCORE_Date_Validation_Quarter();
    }
    @Test(priority = 5, description = "To Verify after selecting JDE Project, its Event details are getting populate or not ")
    public void JDE_Project_FunctionalityTest() throws InterruptedException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.JDE_Project_Functionality();
    }

    @Test(priority = 6, description = "To Check, Non BU Specific Sub Program picklist value is not mandatory if Client Code is other than 1208- IBM ")
    public void otherClientCodeFunctionalityTest() throws InterruptedException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.OtherClientCodeFunctionality();
    }

    @Test(priority = 7, description = "To Verify after submitting Score Cost Saving Record, its Status getting changed to 'Submitted' or NOT ")
    public void GPJSCORECostSavingRecordSubmissionTest() throws InterruptedException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.GPJSCORECostSavingRecordSubmission();
    }

    //To check for Field Officer user's privileges
    @Test(priority = 8, description = "To check for Field Officer user's privileges i.e. Shoudn't grant to access Regional, Quarterly Approval & Corporate Aprrovals ")
    public void Field_Officer_FunctionalityTest() throws Throwable {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Field_Officer_Functionality();

    }

    //To check for Regional Officer user's privileges
    @Test(priority = 9, description = "To check for Regional Officer user's privileges i.e. Shoudn't grant to access Corporate Aprrovals ")
    public void Regional_Officer_FunctionalityTest() throws Throwable {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Regional_Officer_Functionality();
    }

    //To check for Corporate Officer user's privileges 
    @Test(priority = 10, description = "To check for Corporate Officer user's privileges i.e. Shoud grant to access all aprrovals like Submission, Regional, Quarterly & Corporate Aprrovals ")
    public void Corporate_Officer_FunctionalityTest() throws Throwable {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Corporate_Officer_Functionality();
    }

    //To check for Corporate Officer user's privileges 
    @Test(priority = 11, description = "To verify while approving 'Draft' Score, getting proper error message or not using Regional User credentials. ")
    public void Verify_Draft_SCORE_All_Aprroval_For_RegionalUserTest() throws InterruptedException, IOException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Verify_Draft_SCORE_All_Aprroval_For_RegionalUser();
    }
    
    //To check Only Record Owner Allowed To Submit Score 
    @Test(priority = 12, description = "To verify Only Record Owner Allowed To Submit Score ")
    public void Only_RecordOwner_Allowed_To_Submit_ScoreTest() throws InterruptedException, IOException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Only_RecordOwner_Allowed_To_Submit_Score();
    }
    
    //To check Corporate Approval Not Deleted By Field and Regional Users Summition_Of_SavingsInUSD_OnApprovalPage
    @Test(priority = 13, description = "To check Corporate Approval Not Deleted By Field and Regional Users")
    public void Corporate_Approval_Not_Deleted_By_FieldandRegionalUsersTest() throws Throwable {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Corporate_Approval_Not_Deleted_By_FieldandRegionalUsers();
    }
    
  //To calculate & verify Score Saving Values with Title's value
    @Test(priority = 14, description = "To calculate & verify Score Saving Values with Title's value")
    public void Summition_Of_SavingsInUSD_OnApprovalPageTest() throws InterruptedException, IOException {
        GPJScoreIBM IBMScoreObject = PageFactory.initElements(driver, GPJScoreIBM.class);
        IBMScoreObject.Summition_Of_SavingsInUSD_OnApprovalPage();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception{
     if(result.getStatus()==ITestResult.FAILURE)
     {
      String screenshot_path = captureScreenShot(driver, result.getName());
      System.out.println(screenshot_path);
      String image = logger.addScreenCapture(screenshot_path);
      System.out.println(image);
      logger.log(LogStatus.FAIL, "Title Verification", image);
     }
     reports.endTest(logger);
     reports.flush();
     
    }


    @AfterSuite
    public void tearDown() {
        try {
            Thread.sleep(2000);
            closeBrowser();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
