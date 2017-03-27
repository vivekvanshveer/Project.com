package Modules;

import Base.Keywords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.DoubleClick;
public class GPJScoreIBM extends Keywords {
	
    //User's Login Button
    @FindBy(name = "login")
    public static WebElement User_Login_btn;

    //click on GPJ SCORE Cost Savings Tab
    @FindBy(linkText = "GPJ SCORE Cost Savings")
    public static WebElement GPJ_SCORE_CostSavingTab;

    //click on New button
    @FindBy(name = "new")
    public static WebElement newBtn;

    //Click on Continue button
    @FindBy(xpath = "//input[@class='btn' and @value='Continue']")
    public static WebElement continueBtn;

    //---------------- Filling GPJ SCORE Cost Savings Details ---------------------------//

    // Enter Entry date 
    @FindBy(xpath = "//label[text()='Entry Date']/following::input[1]")
    public static WebElement entryDate_tf;

    //SCORE Date
    @FindBy(xpath = "//label[text()='SCORE Date']/following::input[1]")
    public static WebElement SCOREDate_tf;

    //Client Region
    @FindBy(xpath = "//label[text()='Client Region']/following::select[1]")
    public static WebElement ClientRegion_picklist;

    //Status Note: getting two matching node.. Need to verify it
    @FindBy(xpath = "//span[text()='Status']/following::td[1]")
    public static WebElement Status_picklist;


    //Client Code
    @FindBy(xpath = "//label[text()='Client Code']/following::select[1]")
    public static WebElement ClientCode_picklist;

    //Savings Type
    @FindBy(xpath = "//label[text()='Savings Type']/following::select[1]")
    public static WebElement SavingsType_picklist;

    //JDE Vendor lookup
    @FindBy(xpath = "//img[@alt='JDE Vendor Lookup (New Window)']")
    public static WebElement JDEVendor_lookUp;

    //JDE Vendor text field
    @FindBy(xpath = "//label[text()='JDE Vendor']/following::span[1]/input")
    public static WebElement JDEVendor_tf;

    //Vendor Type
    @FindBy(xpath = "//label[text()='Vendor Type']/following::select[1]")
    public static WebElement VendorType_piclist;

    //Non BU Specific Sub Program Framework
    @FindBy(xpath = "//label[text()='Non BU Specific Sub Program Framework']/following::select[1]")
    public static WebElement NonBUSpecificSubProgramFramework_picklist;

    //JDE Project # look up
    @FindBy(xpath = "//img[@alt='JDE Project # Lookup (New Window)']")
    public static WebElement JDEProject_lookUp;

    //JDE Project # textfield
    @FindBy(xpath = "//label[text()='JDE Project #']/following::span[1]/input")
    public static WebElement JDEProject_tf;

    //JDE Client Lookup
    @FindBy(xpath = "//img[@alt='JDE Client Lookup (New Window)']")
    public static WebElement JDEClient_lookUp;

    //JDE Client textfield 
    @FindBy(xpath = "//label[text()='JDE Client']/following::span[1]/input")
    public static WebElement JDEClient_tf;

    //Event Start
    @FindBy(xpath = "//label[text()='Event Start']/following::input[1]")
    public static WebElement EventStart_tf;

    //Event Name 
    @FindBy(xpath = "//label[text()='Event Name']/following::input[1]")
    public static WebElement EventName_tf;

    @FindBy(xpath = "//span[text()='Event Name']/following::div[1]")
    public static WebElement EventName_DetailPage;

    //Description of Cost Savings
    @FindBy(xpath = "//label[text()='Description of Cost Savings']/following::textarea [1]")
    public static WebElement DescriptionOfCostSavings_txtArea;

    //Country
    @FindBy(xpath = "//label[text()='Country']/following::select[1]")
    public static WebElement Country_piclist;

    //Estimated Cost (in Local Currency)
    @FindBy(xpath = "//td[text()='Estimated Cost (in Local Currency)']/following::td[1]")
    public static WebElement EstimatedCostInLocalCurrency_tf;

    //Negotiated Cost (in Local Currency)
    @FindBy(xpath = "//td[text()='Negotiated Cost (in Local Currency)']/following::td[1]")
    public static WebElement NegotiatedCostInLocalCurrency_tf;

    //Savings Override (in Local Currency)	
    @FindBy(xpath = "//span[text()='Savings (in Local Currency)']/following::td[1]")
    public static WebElement SavingsOverrideInLocalCurrency_tf;

    //Estimated Cost (in Local Currency)
    @FindBy(xpath = "//label[text()='Estimated Cost (in Local Currency)']/following::input[1]")
    public static WebElement EstimatedCost_tf;

    //Negotiated Cost (in Local Currency)
    @FindBy(xpath = "//label[text()='Negotiated Cost (in Local Currency)']/following::input[1]")
    public static WebElement NegotiatedCost_tf;

    //Savings Override (in Local Currency)
    @FindBy(xpath = "//label[text()='Savings Override (in Local Currency)']/following::input[1]")
    public static WebElement SavingsOverride_tf;

    //Exchange Rate 
    @FindBy(xpath = "//td[text()='Exchange Rate']/following::td[1]")
    public static WebElement ExchangeRate_tf;

    //Estimated Cost (in USD)
    @FindBy(xpath = "//td[text()='Estimated Cost (in USD)']/following::td[1]")
    public static WebElement EstimatedCostInUSD_tf;

    //Negotiated Cost (in USD)
    @FindBy(xpath = "//td[text()='Negotiated Cost (in USD)']/following::td[1]")
    public static WebElement NegotiatedCostInUSD_tf;

    //Savings (in USD)
    @FindBy(xpath = "//td[text()='Savings (in USD)']/following::td[1]")
    public static WebElement SavingsInUSD_tf;

    // Save Button .//*[@id='topButtonRow']/input[3]
    @FindBy(xpath = ".//*[@id='topButtonRow']/input[1]")
    public static WebElement SaveBtn;

    // Edit Button 
    @FindBy(xpath = ".//*[@id='topButtonRow']/input[3]")
    public static WebElement EditBtn;

    //delete button 
    @FindBy(name = "del")
    public static WebElement DeleteBtn;


    //Test Cases 1: SCORE_Non_BU_Specific_Required Alert 
    @FindBy(xpath = "//div[@class='errorMsg']")
    public static WebElement clientCodeAlertMsg;

    //Test Cases 3: Estimated_and_Negotiated_Validation
    @FindBy(xpath = ".//*[@id='errorDiv_ep']")
    public static WebElement Estimated_and_Negotiated_Validation_Alert;

    //Test Cases 4: Entry_Date_Validation_Quarter
    @FindBy(xpath = "//div[@class='errorMsg']")
    public static WebElement Entry_Date_Validation_Quarter_Alert;

    //Test Cases 5: SCORE_Date_Validation_Quarter
    @FindBy(xpath = "//div[@class='errorMsg']")
    public static WebElement SCORE_Date_Validation_Quarter_Alert;

    // ******************* Look Up window *********************** //
    @FindBy(name = "lksrch")
    public static WebElement lookUpSearch_tf;

    @FindBy(name = "searchFrame")
    public static WebElement searchFrame;

    @FindBy(id = "resultsFrame")
    public static WebElement resultFrame;

    // ****************** After Submit Approval ***************************//
    @FindBy(name = "submit_approval")
    public static WebElement submitBtn;

    @FindBy(xpath = "//div[@class='messageText']")
    public static WebElement successMsgAftersubmissionApproval;

    @FindBy(xpath = "//input[@class='btn' and @value='Done']")
    public static WebElement doneBtn;

    // *****************List View Elements *********************************//
    @FindBy(name = "fcf")
    public static WebElement selectListView_picklist;

    //Go  btn go
    @FindBy(name = "go")
    public static WebElement go_btn;

    //Select checkbox 
    @FindBy(id = "allBox")
    public static WebElement allCheckbox;

    //List Body 
    @FindBy(id = "ext-gen11")
    public static WebElement listViewBody;

    //Regional Approval btn
    @FindBy(name = "update_regional_approval")
    public static WebElement Regional_Approval_btn;

    //Quarterly Approval btn
    @FindBy(name = "quarterly_approval")
    public static WebElement Quarterly_Approval_btn;

    //Corporate Approval btn
    @FindBy(name = "update_global_approval")
    public static WebElement Corporate_Approval_btn;

    //InsufficientErrorMsg
    @FindBy(xpath = "//span[text()='Insufficient Privileges']")
    public static WebElement InsufficientErrorMsg;

    //ValidationErrorsMsg
    @FindBy(xpath = "//span[text()='Validation Errors While Saving Record(s)']")
    public static WebElement ValidationErrorsMsg;

    //Here Link on Insufficent privileges Page
    @FindBy(linkText = "here")
    public static WebElement here_btn;

    // Header Link
    @FindBy(xpath = "//span[@class='globalHeaderProfilePhoto chatter-avatarSmall chatter-avatar']")
    public static WebElement Header_link;

    //Logout 
    @FindBy(xpath = "//a[@title='Logout' and text()='Logout']")
    public static WebElement logout_btn;

    //Regional Page Elements 
    @FindBy(xpath = "//input[@class='btn' and @value='Approve']")
    public static WebElement Approved_btn;

    //Regional Approval Success Msg
    @FindBy(xpath = "//div[@class='messageText']")
    public static WebElement ReginoalApprovedMsg;

    //Regional Approval Back Button 
    @FindBy(xpath = "//input[@class='btn' and @value='Back']")
    public static WebElement ReginoalApprovedBack_btn;

    //Approval Title 
    @FindBy(xpath = "//div[@class='title']")
    public static WebElement titleApproval;
    //EstimatedCostInUSD = EstimatedCostInLocalCurrency / ExchangeRate
    public static double CalcEstimatedCostInUSD(double EstimatedCostInLocalCurrency, double ExchangeRate) {
        return (EstimatedCostInLocalCurrency / ExchangeRate);
    }

    //NegotiatedCostInUSD = NegotiatedCostInLocalCurrency / ExchangeRate
    public static double CalcNegotiatedCostInUSD(double NegotiatedCostInLocalCurrency, double ExchangeRate) {
        return (NegotiatedCostInLocalCurrency / ExchangeRate);
    }

    //SavingsInUSD = SavingsInLocalCurrency / ExchangeRate
    public static double CalcSavingsInUSD(double SavingsInLocalCurrency, double ExchangeRate) {
        return (SavingsInLocalCurrency / ExchangeRate);
    }

    // Check if pop up dialog bus is present than it should close it.
    public void closeAlert() throws Throwable {
        List < WebElement > alertPop = driver.findElements(By.xpath("//a[@class='dialogClose']"));
        if (!isAlertPresents() && alertPop.size() != 0) {
            driver.findElement(By.xpath("//a[@class='dialogClose']")).sendKeys(Keys.ENTER);

        }
    }

    public static void clickScoreLink_OnRegionalPage() {
        ////div[@class='sub-title ']/table/tbody/tr/td[1]
        List < WebElement > outerRegionalScoreList = driver.findElements(By.xpath("//div[@class='main accordion']/div"));
        List < WebElement > ScoreLink1 = driver.findElements(By.xpath("//div[@class='main accordion']/div/table/tbody/tr/td[1]"));
        for (int i = 0; i < 1; i++) {
            outerRegionalScoreList.get(i).click();
            for (WebElement match: ScoreLink1) {
                try {

                    if (match.isDisplayed() && match.getSize() != null) {
                        //doubleClick(match);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", match);
                        doubleClick(match);
                        match.submit();
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println(match.getText());
                break;
            }

        }
    }

    //***************************** Mandatory Fields Filling in Cost Saving Object *********************************//
	public static void enterDate(){
		entryDate_tf.clear();
        write(entryDate_tf, "3/23/2017");
		logger.log(LogStatus.INFO, "Entered Entry Date ");
        write(SCOREDate_tf, "1/1/2017");
		logger.log(LogStatus.INFO, "Entered Score Date ");
	}
    public static void CostSavingMandatoryFields() throws InterruptedException {
    	logger.log(LogStatus.INFO, "Creating Score Saving Record !!!");
        click(GPJ_SCORE_CostSavingTab);
        click(newBtn);
        click(continueBtn);
        //Select Client Region
        selectByVisibleText(ClientRegion_picklist, "International");
        //Select Savings Type
        selectByVisibleText(SavingsType_picklist, "Efficiencies");
        //Send JDE Vendor
        write(JDEVendor_tf, "Te Papa Tongarewa (NZ) - 666649");

        //Select JDE Project
        write(JDEProject_tf, "35GAR12500");

        //Select Vendor Type
        selectByVisibleText(VendorType_piclist, "IBM Preferred");
        //Description of Cost Savings
        write(DescriptionOfCostSavings_txtArea, "Description of Cost Savings");
        //Country
        selectByVisibleText(Country_piclist, "India / South Asia");
        //Estimate Cost
        write(EstimatedCost_tf, "1500");
        //Negotiated Cost
        write(NegotiatedCost_tf, "500");

    }


    //@Function: Used to Check whether alert is displayed if we didn't select Non BU when Client Code = 1208- IBM
    public void ClientCodeFunctionality() throws InterruptedException {
    	
    	logger = reports.startTest("TestClientCodeFunctionalityVerification");
        CostSavingMandatoryFields();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        enterDate();
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 1208 - IBM");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
        Assert.assertEquals(clientCodeAlertMsg.getText(), "Error: Please select a value. Required when Client Code = 1208 - IBM", "Error message is not displayed");
        logger.log(LogStatus.PASS, "Displayd error message ");
    }

    public void GPJSCORECostSavingRecordSubmission() throws InterruptedException {
    	logger = reports.startTest("TestGPJSCORECostSavingRecordSubmission");
        CostSavingMandatoryFields();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        enterDate();
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
        click(submitBtn);
		logger.log(LogStatus.INFO, "Clicked SUBMIT button");
        successSubmissionMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "Score Has been Submitted Successfully.");
        Assert.assertEquals(successSubmissionMsg, true);
		logger.log(LogStatus.PASS, "Displayd Success message i.e. Score Has been Submitted Successfully.");
        click(doneBtn);
		logger.log(LogStatus.INFO, "Clicked Done button to navigate details page");
        Assert.assertEquals(Status_picklist.getText(), "Submitted", "Status is not changed");
		logger.log(LogStatus.PASS, "Verified Status Changed to 'Submitted' !!!");
    }

    public void Estimated_and_Negotiated_Validation() throws InterruptedException {
    	logger = reports.startTest("TestEstimated_and_Negotiated_Validation");
        CostSavingMandatoryFields();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        enterDate();
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. Non BU Specific - Hrs Ovr Rtr");
        write(SavingsOverride_tf, "500");
		logger.log(LogStatus.INFO, "Entered Saving Override value");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
        //Check for when entering the Savings Override to check that Estimated and Negotiated costs are blank  -- 
        Assert.assertEquals(Estimated_and_Negotiated_Validation_Alert.getText().contains("Estimated Cost and Negotiated Cost must be blank when using the Savings Override."), true, "Didn't display Alert i.e. ==> Estimated Cost and Negotiated Cost must be blank when using the Savings Override.");
		logger.log(LogStatus.PASS, "Alert message is displayed i.e. Estimated Cost and Negotiated Cost must be blank when using the Savings Override. ");
    }

    public void CostCalculationInUSD() throws InterruptedException {
    	logger = reports.startTest("TestCostCalculationInUSD");
        CostSavingMandatoryFields();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        enterDate();
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
		scrollDown();
		logger.log(LogStatus.INFO, "Scroll down");
        //Get values Of  Local Currency for calculations
        EstimatedCostInLocal = EstimatedCostInLocalCurrency_tf.getText().replaceAll(",", "");
        NegotiatedCostInLocal = NegotiatedCostInLocalCurrency_tf.getText().replaceAll(",", "");
        SavingsInLocal = SavingsOverrideInLocalCurrency_tf.getText().replaceAll(",", "");

        //Get Exchnage Rate
        ExchangeRate = ExchangeRate_tf.getText().replace(",", "");

        //Get Actual Values of USD for comparison
        actual_EstimatedCostInUSD = EstimatedCostInUSD_tf.getText().replaceAll(" ", "");
        actual_NegotiatedCostInUSD = NegotiatedCostInUSD_tf.getText().replaceAll(" ", "");
        actual_SavingsInUSD = SavingsInUSD_tf.getText().replaceAll(" ", "");

        //Calculated Expected Values in USD using Local values    
        expected_EstimatedCostInUSD = CalcEstimatedCostInUSD(Double.valueOf(EstimatedCostInLocal), Double.valueOf(ExchangeRate));
        expected_NegotiatedCostInUSD = CalcNegotiatedCostInUSD(Double.valueOf(NegotiatedCostInLocal), Double.valueOf(ExchangeRate));
        expected_SavingsInUSD = CalcSavingsInUSD(Double.valueOf(SavingsInLocal), Double.valueOf(ExchangeRate));

        Assert.assertEquals(actual_EstimatedCostInUSD, f.format(expected_EstimatedCostInUSD), "");
		logger.log(LogStatus.PASS, "Verified 'Estimated Cost In USD' is calculated as per expected.");
        Assert.assertEquals(actual_NegotiatedCostInUSD, f.format(expected_NegotiatedCostInUSD), "");
		logger.log(LogStatus.PASS, "Verified 'Negotiated Cost In USD' is calculated as per expected.");
        Assert.assertEquals(actual_SavingsInUSD, f.format(expected_SavingsInUSD), "");
		logger.log(LogStatus.PASS, "Verified 'Savings Cost In USD' is calculated as per expected.");

    }
    // Note:For below Test Cases Verification, You Need to pass wrong input for Entry Date field
    public void Entry_Date_Validation_Quarter() throws InterruptedException {
    	logger = reports.startTest("TestEntry_Date_Validation_Quarter");
        CostSavingMandatoryFields();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        entryDate_tf.clear();
        write(entryDate_tf, "12/1/2015");
		logger.log(LogStatus.INFO, "Entered Entry Date ");
        write(SCOREDate_tf, "1/3/2017");
		logger.log(LogStatus.INFO, "Entered Score Date ");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
        //Check Validation i.e. Entry Date must be in the current quarter and any date lesser than today.   - 
        Assert.assertEquals(Entry_Date_Validation_Quarter_Alert.getText().contains("Error: Entry Date must be in the current quarter and any date lesser than today."), true, "Didn't get alert ==> Error: Entry Date must be in the current quarter and any date lesser than today.");
		logger.log(LogStatus.PASS, "Verified 'Entry Date'is in the current quarter and any date lesser than today.");
    }

    // Note:For below Test Cases Verification, You Need to pass wrong input for Score Date field 
    public void SCORE_Date_Validation_Quarter() throws InterruptedException {
    	logger = reports.startTest("TestSCORE_Date_Validation_Quarter");
        CostSavingMandatoryFields();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        entryDate_tf.clear();
        write(entryDate_tf, "3/22/2017");
		logger.log(LogStatus.INFO, "Entered Entry Date ");
        write(SCOREDate_tf, "7/12/2017");
		logger.log(LogStatus.INFO, "Entered Score Date ");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
        //Check Validation i.e. The Data entry will be accepted for the current quarter and previous quarter. Older data is frozen - 
        Assert.assertEquals(SCORE_Date_Validation_Quarter_Alert.getText().contains("Error: Sorry. SCORE Date must be in the current or previous quarter only."), true, "Didn't get alert ==> Error: Sorry. SCORE Date must be in the current or previous quarter only.");
		logger.log(LogStatus.PASS, "Verified 'Score Date'is accepted for the current quarter and previous quarter. Older data is frozen");
    }

    //check after selecting JDE Project, its Event details are getting populate or not 
    public void JDE_Project_Functionality() throws InterruptedException {
    	logger = reports.startTest("TestJDE_Project_Functionality");
        CostSavingMandatoryFields();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        enterDate();
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
        //Edit same record for verification 
        click(EditBtn);
		logger.log(LogStatus.INFO, "Now Clicked Edit button");
        //Update Event Name

        EventName_tf.clear();
        write(EventName_tf, "Test Event Name");
		logger.log(LogStatus.INFO, "Updated Event Name i.e. Test Event Name");

        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button tosave the changes.");
        //Check Event Name was same as updated
        Assert.assertEquals(EventName_DetailPage.getText(), "Test Event Name", "Couldn't update Event Name");
		logger.log(LogStatus.PASS, "Verified 'Event Name' is updated...");
        // *******************Again Chnaged JDE Project Name 103968500 *********************** //
        click(EditBtn);
		logger.log(LogStatus.INFO, "Clicked Edit button for updating JDE  Project value");
        JDEProject_tf.clear();
        write(JDEProject_tf, "103968500");
		logger.log(LogStatus.INFO, "Selected 'JDE Project' i.e. 103968500");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
        //Verification that updated Event Name is override on previous Event Name
        Assert.assertNotEquals(EventName_DetailPage.getText(), "Test Event Name", "Couldn't Override Event Name");
		logger.log(LogStatus.PASS, "Verified 'Event Name' is successfully override against Event Name field");
    }

    //@Function: Used to Check Non BU Specific Sub Program Framework is not mandatory if Client Code is other than 1208- IBM
    public void OtherClientCodeFunctionality() throws InterruptedException {
    	logger = reports.startTest("TestOtherClientCodeFunctionality");
        CostSavingMandatoryFields();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        enterDate();
        selectByVisibleText(ClientCode_picklist, "224895 - IBM Non Marketing");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 224895 - IBM Non Marketing");
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button");
        Assert.assertEquals(driver.getTitle().contains("GPJ SCORE Cost Saving"), true, "Record doesn't save");
		logger.log(LogStatus.PASS, "Verified 'Non BU Specific Sub Program Framework' is not mandatory if Client Code is other than 1208-IBM  ");
    }

    //To check for Field Officer user's privileges 
    public void Field_Officer_Functionality() throws Throwable {
    	logger = reports.startTest("TestField_Officer_Functionality");
        //Login with Field Officer Usr i.e. Julie Priebe
        navigate("Field_Officer");
        isLoggedIn = true;
        //click LogIn button
        click(User_Login_btn);
		logger.log(LogStatus.INFO, "Logged In with Field Officer user's  i.e. Julie Priebe");

        GPJSCORECostSavingRecordSubmission();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab");
        //Select APAC - 2. Pending Regional Approval from View PickList 
        //selectByTextUsingJavaScript(selectListView_picklist, "APAC - 2. Pending Regional Approval");
        clickDropdownElement(selectListView_picklist, "option", "CQ - 2. Pending Regional Approval");
		logger.log(LogStatus.INFO, "Selected 'CQ - 2. Pending Regional Approval' ...");
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button");
        Assert.assertEquals("CQ - 2. Pending Regional Approval", getSelectedOption(selectListView_picklist), "Selected Value is not displayed");
		logger.log(LogStatus.PASS, "Verified Selected Value is displayed" );
		
        //Check records are available on List View 
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        //checkCheckBox(allCheckbox);
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Recoed selected for Reginoal Approval");

        //Click Regional Approval
        click(Regional_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked 'Regional Approval' button ...");
        //Verify Filed Officer Privileges For regional Approval 
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Field Officer couldn't perform Reginoal Approval");
		logger.log(LogStatus.PASS, "Verified Insufficient Privileges message is displayed" );
        // Go back to list View Page by clicking on Here Link
        click(here_btn);
		logger.log(LogStatus.INFO, "Clicked here button" );
		
        // ************** Check for Quarterly Approval *************************//
        //Select APAC - 3. Pending Quarterly Approval from View PickList 
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 3. Pending Quarterly Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 3. Pending Quarterly Approval' ..." );
        //click Go
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        checkCheckBox(allCheckbox);
		logger.log(LogStatus.INFO, "Checked all checkbox" );
        //click Quarterly Approval 
        click(Quarterly_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked 'Quarterly Approval' button ...");
		
        //Verify Filed Officer Privileges For Quarterly Approval 
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Field Officer couldn't perform Quarterly Approval");
		logger.log(LogStatus.PASS, "Verified Insufficient Privileges message is displayed" );
        // Go back to list View Page by clicking on Here Link
        click(here_btn);
		logger.log(LogStatus.INFO, "Clicked here button" );
        // ***************** Corporate Approval ************************ //
        //Select APAC - 4. Pending Corporate Approval from View PickList 
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 4. Pending Corporate Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 3. Pending Corporate Approval' ..." );
        //click Go
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );

        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        checkCheckBox(allCheckbox);
		logger.log(LogStatus.INFO, "Checked all checkbox" );


        //click Quarterly Approval 
        click(Corporate_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked 'Corporate Approval' button ...");
		
        //Verify Filed Officer Privileges For regional Approval 
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Field Officer couldn't perform Corporate Approval");
		logger.log(LogStatus.PASS, "Verified Insufficient Privileges message is displayed" );
        // Go back to list View Page by clicking on Here Link
        click(here_btn);
		logger.log(LogStatus.INFO, "Clicked here button" );
        //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;
    }

    //To check for Regional Officer user's privileges 
    public void Regional_Officer_Functionality() throws Throwable {
    	logger = reports.startTest("TestRegional_Officer_Functionality");
        if (!isLoggedIn) {
            //Login with Field Officer Usr i.e. Ying wen  APAC - 2. Pending Regional Approval
            navigate("Regional_Officer");
			logger.log(LogStatus.INFO, "Navigated to Reginoal Officer" );
        } else {
            click(Header_link);
			logger.log(LogStatus.INFO, "Clicked Header button" );
            Logout(logout_btn);
			logger.log(LogStatus.INFO, "Clicked Logout button" );
            isLoggedIn = false;
            navigate("Regional_Officer");
			logger.log(LogStatus.INFO, "Navigated to Reginoal Officer" );

        }
        //click LogIn button
        click(User_Login_btn);
		logger.log(LogStatus.INFO, "Logged In with Reginoal Officer user's  i.e. Ying wen");
        isLoggedIn = true;


        GPJSCORECostSavingRecordSubmission();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
		
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        //Select Pending Regional Approval
        //selectByTextUsingJavaScript(selectListView_picklist, "APAC - 2. Pending Regional Approval");
        clickDropdownElement(selectListView_picklist, "option", "APAC - 2. Pending Regional Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 3. Pending Reginoal Approval' ..." );
	
        Assert.assertEquals("APAC - 2. Pending Regional Approval", getSelectedOption(selectListView_picklist), "Selected Value not displaying");
		logger.log(LogStatus.PASS, "Verified Selected Value is displayed" );
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        //Check records are available on List View 
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );	
        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Selectd Record for Regional Approval.." );
        //Click Regional Approval
        click(Regional_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Regional Approval button .." );

        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
        //Get Success message
        successRegionalApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");
        //Verify
        Assert.assertEquals(successRegionalApprovalMsg, true, "Didn't get Success message while Regional Approval");
		logger.log(LogStatus.PASS, "Verified success message is displayed" );
        // Click on Back button
        click(ReginoalApprovedBack_btn);
		logger.log(LogStatus.INFO, "Clicked Back button" );
		
        //Select APAC - 3. Pending Quarterly Approval 
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 3. Pending Quarterly Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 3. Pending Quarterly Approval' ..." );
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        //Check records are available on List View
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemQCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemQCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );

        click(Quarterly_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Quarterly Approval button .." );



        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
        //Get Success message of Quarterly Approval
        successQuarterlyApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");

        //Verify
        Assert.assertEquals(successRegionalApprovalMsg, true, "Didn't get Success message while Quarterly Approval");
		logger.log(LogStatus.PASS, "Verified success message is displayed" );
        // Click on Back button 
        click(ReginoalApprovedBack_btn);
		logger.log(LogStatus.INFO, "Clicked Back button" );
        //Select APAC - 3. Pending Corporate Approval 
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 4. Pending Corporate Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 3. Pending Corporate Approval' ..." );	
        //click Go
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );

        click(Corporate_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Corporate Approval button .." );

        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
		
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Regional Officer couldn't perform Corporate Approval");
		logger.log(LogStatus.PASS, "Verified Insufficient Privileges message is displayed" );
        // Click on Back button APAC - 4. Pending Corporate Approval
        click(here_btn);
		logger.log(LogStatus.INFO, "Clicked here button" );
        //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;

    }

    public void Corporate_Officer_Functionality() throws Throwable {
    	logger = reports.startTest("TestCorporate_Officer_Functionality");
        if (!isLoggedIn) {
            //Login with Corporate Officer User i.e. Scott Hart 
            navigate("Corporate_Officer");
			logger.log(LogStatus.INFO, "Logged In with Corporate Officer user's  i.e. Scott Hart");
        } else {
            click(Header_link);
			logger.log(LogStatus.INFO, "Clicked Header button" );
            Logout(logout_btn);
			logger.log(LogStatus.INFO, "Clicked Logout button" );
            isLoggedIn = false;
            navigate("Corporate_Officer");
			logger.log(LogStatus.INFO, "Logged In with Corporate Officer user's  i.e. Scott Hart");

        }
        //Login with Corporate Officer User i.e.  Scott Hart  APAC - 2. Pending Regional Approval
        //click LogIn button
        click(User_Login_btn);
		logger.log(LogStatus.INFO, "Logged In with Reginoal Officer user's  i.e. Ying wen");
        isLoggedIn = true;


        GPJSCORECostSavingRecordSubmission();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");
	
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        //Select Pending Regional Approval
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 2. Pending Regional Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 3. Pending Reginoal Approval' ..." );

        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        //Check records are available on List View 
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );
		
        //Click Regional Approval
        click(Regional_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Regional Approval button .." );

        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
		
        //Get Success message
        successRegionalApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");
        //Verify
        Assert.assertEquals(successRegionalApprovalMsg, true, "Didn't get Success message while Regional Approval");
		logger.log(LogStatus.PASS, "Verified success message is displayed" );
		
        // Click on Back button
        click(ReginoalApprovedBack_btn);
		logger.log(LogStatus.INFO, "Clicked Back button" );
		
        //Select APAC - 3. Pending Quarterly Approval 
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 3. Pending Quarterly Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 3. Pending Quarterly Approval' ..." );
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        //Check records are available on List View
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemQCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemQCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );

        click(Quarterly_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Quarterly Approval button .." );


        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
		
        //Get Success message of Quarterly Approval
        successQuarterlyApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");

        //Verify
        Assert.assertEquals(successQuarterlyApprovalMsg, true, "Didn't get Success message while Quarterly Approval");
		logger.log(LogStatus.PASS, "Verified success message is displayed" );

        // Click on Back button 
        click(ReginoalApprovedBack_btn);
		logger.log(LogStatus.INFO, "Clicked Back button" );
		
        //Select APAC - 3. Pending Corporate Approval 
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 4. Pending Corporate Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 3. Pending Corporate Approval' ..." );
        //click Go
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );

        click(Corporate_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Corporate Approval button .." );

        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
		
        //Get Success message of Quarterly Approval
        successCorporateApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");

        //Verify
        Assert.assertEquals(successCorporateApprovalMsg, true, "Didn't get Success message while Quarterly Approval");
		logger.log(LogStatus.PASS, "Verified success message is displayed" );

        // Click on Back button 
        click(ReginoalApprovedBack_btn);
		logger.log(LogStatus.INFO, "Clicked Back button" );
        //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;

    }

    public void Verify_Draft_SCORE_All_Aprroval_For_RegionalUser() throws InterruptedException {
    	logger = reports.startTest("TestVerify_Draft_SCORE_All_Aprroval_For_RegionalUser");
    	
        if (!isLoggedIn) {
            //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
            navigate("Regional_Officer");
			logger.log(LogStatus.INFO, "Logged In with Reginoal Officer user's  i.e. Ying wen");
        } else {
           //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;
            navigate("Regional_Officer");
			logger.log(LogStatus.INFO, "Logged In with Reginoal Officer user's  i.e. Ying wen");

        }
        //click LogIn button
        click(User_Login_btn);
		logger.log(LogStatus.INFO, "Logged In with Field Officer user's  i.e. Julie Priebe" );
        isLoggedIn = true;


        GPJSCORECostSavingRecordSubmission();
		logger.log(LogStatus.INFO, "GPJ Score Record is created");

        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        //Select Pending Submission
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 1. Pending Submission");
		logger.log(LogStatus.INFO, "Selected 'APAC - 1. Pending Submission' ..." );

        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        //Check records are available on List View 
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );
		
        //Click Regional Approval
        click(Regional_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Regional Approval button .." );

        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
        //Get Success message
        //successRegionalApprovalMsg = successMsgAftersubmissionApproval.getText().contains("No records are available for Regional Approval");
		
        //Verify
        Assert.assertEquals(successMsgAftersubmissionApproval.getText(), "No records are available for Regional Approval", "Didn't get alert message while approving drafted Score to Regional");
		logger.log(LogStatus.PASS, "Verified alert message is displayed" );
        // Click on Back button
        click(ReginoalApprovedBack_btn);
		logger.log(LogStatus.INFO, "Clicked Back button" );
        //Select APAC - 3. Pending Quarterly Approval 
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 1. Pending Submission");
		logger.log(LogStatus.INFO, "Selected 'APAC - 1. Pending Submission' ..." );

        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        //Check records are available on List View
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemQCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemQCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );

        click(Quarterly_Approval_btn);

		logger.log(LogStatus.INFO, "Clicked Quarterly Approval button .." );

        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
        //Get Success message of Quarterly Approval
        //successRegionalApprovalMsg = successMsgAftersubmissionApproval.getText().contains("No records are available for Quarterly Approval");

        //Verify
        Assert.assertEquals(successMsgAftersubmissionApproval.getText(), "No records are available for Quarterly Approval", "Didn't get alert message while approving drafted Score to Regional");
		logger.log(LogStatus.PASS, "Verified alert message is displayed" );
		
        // Click on Back button 
        click(ReginoalApprovedBack_btn);
		logger.log(LogStatus.INFO, "Clicked Back button" );
        //Select APAC - 3. Pending Corporate Approval 
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );


        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 1. Pending Submission");
		logger.log(LogStatus.INFO, "Selected 'APAC - 1. Pending Submission' ..." );
        //click Go
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );

        click(Corporate_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Corporate Approval button .." );

        //Click Approve Button
        click(Approved_btn);
		logger.log(LogStatus.INFO, "Clicked Approved button" );
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Regional Officer couldn't perform Corporate Approval");
		logger.log(LogStatus.PASS, "Verified Insufficient Privileges message is displayed" );
        // Click on Back button APAC - 4. Pending Corporate Approval
        click(here_btn);
		logger.log(LogStatus.INFO, "Clicked here button" );

        //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;

    }

    public void Only_RecordOwner_Allowed_To_Submit_Score() throws InterruptedException {
    	logger = reports.startTest("TestOnly_RecordOwner_Allowed_To_Submit_Score");
        if (!isLoggedIn) {
            //Login with Field Officer User i.e. Julie  
            navigate("Field_Officer");
			logger.log(LogStatus.INFO, "Login with field Level Officer i.e. " );
        } else {
            //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;
            navigate("Field_Officer");
			logger.log(LogStatus.INFO, "Login with field Level Officer i.e. Julie priebe" );

        }
        //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
        //navigate("Corporate_Officer");

        //click LogIn button
        click(User_Login_btn);
		logger.log(LogStatus.INFO, "Logged In with Field Officer user's  i.e. Julie Priebe" );
        isLoggedIn = true;


        // Create Score Record
        CostSavingMandatoryFields();
        enterDate();
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. 1208 - IBM" );
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
		logger.log(LogStatus.INFO, "Selected Client Code i.e. Non BU Specific - Hrs Ovr Rtr" );
        click(SaveBtn);
		logger.log(LogStatus.INFO, "Clicked Save button" );
        recordURL = driver.getCurrentUrl();
		logger.log(LogStatus.INFO, "Copy GPJ Score current URL and stored in recordURL vareiable successfully " );

        //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;

        //now Login with Regional User
        if (!isLoggedIn) {
            //Login with Reginoal Officer User i.e. Ying Wen  
            navigate("Regional_Officer");
			logger.log(LogStatus.INFO, "Login with Reginoal  Officer i.e. Ying Wen" );
        } else {
            //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;
            navigate("Regional_Officer");
			logger.log(LogStatus.INFO, "Login with Reginoal  Officer i.e. Ying Wen" );

        }
        //click LogIn button
        click(User_Login_btn);
		logger.log(LogStatus.INFO, "Logged In with Regional Officer user's  i.e. Ying Wen" );
        isLoggedIn = true;


        //Navigate to created record URL
        driver.get(recordURL);
		logger.log(LogStatus.INFO, "Navigated to current record URL which is stored in var recordURL" );

        // click on Submit button
        click(submitBtn);
		logger.log(LogStatus.INFO, "Clicked Submit button" );
		
        //Verify
        Assert.assertEquals(successMsgAftersubmissionApproval.getText(), "Only Record Owner is allowed to Submit the SCORE.", "Alert message i.e. 'Only Record Owner is allowed to Submit the SCORE.' not displayed while submitting the Score." + recordURL);
		logger.log(LogStatus.PASS, "Verified alert message is displayed" );
		
        //click on done button
        click(doneBtn);

        //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;
    }

    public void Corporate_Approval_Not_Deleted_By_FieldandRegionalUsers() throws Throwable {
    	logger = reports.startTest("TestCorporate_Approval_Not_Deleted_By_FieldAndRegionalUsers");
        if (!isLoggedIn) {
            //Login with Field Level Officer User i.e. Julie Priebe
            navigate("Field_Officer");
			logger.log(LogStatus.INFO, "Navigated to Field Level User URL i.e. Login with Field Level  Officer i.e. Julie Priebe" );
        } else {
            //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;
            navigate("Field_Officer");
			logger.log(LogStatus.INFO, "Login with Field Level Officer i.e. Julie Priebe Navigated to Field Level User URL i.e. Login with Field Level  Officer i.e. Julie Priebe" );


        }
        
        //click LogIn button
        click(User_Login_btn);
		logger.log(LogStatus.INFO, "Logged In with Field Level Officer user's  i.e. Julie Priebe " );
        isLoggedIn = true;
        
        //click on Tab
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        // select APAC - 5. Corporate Approved
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 5. Corporate Approved");
		logger.log(LogStatus.INFO, "Selected 'APAC - 5. Corporate Approved' ..." );

		// click go
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
		
		closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
				
        // click top record and open in tab
        List < WebElement > elemCCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-NAME']"));
        for (int j = 0; j < 1; j++) {
            elemCCheckbox.get(j).click();
        }

		logger.log(LogStatus.INFO, "Successfully Clicked on Record Name" );
		
		//click delete button
        click(DeleteBtn);
        logger.log(LogStatus.INFO, "Clicked Delete button" );
        if (isAlertPresents()) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
        
        logger.log(LogStatus.INFO, "Closed pop up alert." );

        //Verify Filed Officer Privileges For regional Approval 
        Assert.assertEquals(ValidationErrorsMsg.getText().contains("Validation Errors While Saving Record(s)"), true, "Failed: It should display 'Validation Errors While Saving Record(s)' Error message As Corporate Approval Not Deleted By Field Users");

        logger.log(LogStatus.PASS, "Display 'Validation Errors While Saving Record(s)' Error message As Corporate Approval Not Deleted By Field Users" );
        
        click(here_btn);
		logger.log(LogStatus.INFO, "Clicked here button" );
        //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;


        //now Login with Regional User
        if (!isLoggedIn) {
            //Login with Regional Officer User i.e. Ying wen
            navigate("Regional_Officer");
			logger.log(LogStatus.INFO, "Login with Regional  Officer i.e. Ying Wen" );
        } else {
            //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;
            navigate("Regional_Officer");
			logger.log(LogStatus.INFO, "Navigated to Regional Officer's URl i.e. Login with Reginoal  Officer i.e. Ying Wen" );

        }
        //click LogIn button
        click(User_Login_btn);
		logger.log(LogStatus.INFO, "Clicked Login button" );
        isLoggedIn = true;
        //click on Tab
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        // select APAC - 5. Corporate Approved
        selectByTextUsingJavaScript(selectListView_picklist, "All");
		logger.log(LogStatus.INFO, "Selected 'All' ..." );

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 5. Corporate Approved");
		logger.log(LogStatus.INFO, "Selected 'APAC - 5. Corporate Approved' ..." );

        // click go
        if (driver.findElements(By.name("go")).size() != 0) {
            click(go_btn);
			logger.log(LogStatus.INFO, "Clicked Go button" );
        }

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
		
		closeAlert();
		logger.log(LogStatus.INFO, "Pop-up Alert is closed" );
		
        // click top record and open in tab
        List < WebElement > elemCCheckbox1 = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-NAME']"));
        for (int k = 0; k < 1; k++) {
            elemCCheckbox1.get(k).click();
        }
        logger.log(LogStatus.INFO, "Successfully Clicked on Record Name" );


        //click delete button
        click(DeleteBtn);
        logger.log(LogStatus.INFO, "Clicked delete button" );
        if (isAlertPresents()) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
		logger.log(LogStatus.INFO, "Closed pop up alert." );
        //Verify Filed Officer Privileges For regional Approval 
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Validation Errors While Saving Record(s)' Error message As Corporate Approval Not Deleted By Regional Users");
		logger.log(LogStatus.PASS, "Verified Insufficient Privileges message is displayed" );
        click(here_btn);
		logger.log(LogStatus.INFO, "Clicked here button" );
        //Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;

    }

    public void Summition_Of_SavingsInUSD_OnApprovalPage() throws InterruptedException {
		logger = reports.startTest("TestSummition_Of_SavingsInUSD_OnApprovalPage");
		
		if(isLoggedIn){
		//Logout
        click(Header_link);
		logger.log(LogStatus.INFO, "Clicked Header button" );
        Logout(logout_btn);
		logger.log(LogStatus.INFO, "Clicked Logout button" );
        isLoggedIn = false;
		}else {
        //click on Tab
        click(GPJ_SCORE_CostSavingTab);
		logger.log(LogStatus.INFO, "Clicked GPJ Score Tab" );
        // select APAC - 5. Corporate Approved
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 2. Pending Regional Approval");
		logger.log(LogStatus.INFO, "Selected 'APAC - 2. Pending Regional Approval' ..." );

        // click go
        click(go_btn);
		logger.log(LogStatus.INFO, "Clicked Go button" );
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
		logger.log(LogStatus.PASS, "Verified Data is available for selection" );
        // click top record and open in tab
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 5; j++) {
            elemCheckbox.get(j).click();
        }
		logger.log(LogStatus.INFO, "Record Selected" );


        //Click Regional Approval
        click(Regional_Approval_btn);
		logger.log(LogStatus.INFO, "Clicked Regional Approval button .." );

        //Get Title Value
        Title = Double.valueOf(titleApproval.getText().substring(titleApproval.getText().indexOf("$") + 1, titleApproval.getText().indexOf("(") - 1));
        List < Double > scoreTotalList = new ArrayList < Double > ();
        List < WebElement > totalList = driver.findElements(By.xpath("//h3[@class='accordion-head maincont']"));
        for (WebElement match: totalList) {
            match.click();
            //System.out.println(match.getText());
            //System.out.println(match.getText().substring(match.getText().indexOf("$") + 1, match.getText().indexOf("(") - 1));
            scoreTotalList.add(Double.parseDouble(match.getText().substring(match.getText().indexOf("$") + 1, match.getText().indexOf("(") - 1)));

        }
        logger.log(LogStatus.INFO, "Expanded Score lists and get score total value" );
        for (Double sum: scoreTotalList) {
            scoreSum += sum;

        }
        logger.log(LogStatus.INFO, "Summition of Total Score value and stored in Scoresum variable." );
        Assert.assertEquals(Title, scoreSum, scoreSum + " is not equall to Header's value i.e. " + Title);
		logger.log(LogStatus.PASS, "Verified Score Title's value is matched with Summition of Score Savings in USD" );


		}
	
    }
}