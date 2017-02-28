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

import com.thoughtworks.selenium.webdriven.commands.DoubleClick;
public class IBMScore extends Keywords {

    public IBMScore() {
        // TODO Auto-generated constructor stub
        navigate(CONFIG.getProperty("Base_URL"));
    }
    
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

    //JDE Vendor
    @FindBy(xpath = "//img[@alt='JDE Vendor Lookup (New Window)']")
    public static WebElement JDEVendor_lookUp;

    //Vendor Type
    @FindBy(xpath = "//label[text()='Vendor Type']/following::select[1]")
    public static WebElement VendorType_piclist;

    //Non BU Specific Sub Program Framework
    @FindBy(xpath = "//label[text()='Non BU Specific Sub Program Framework']/following::select[1]")
    public static WebElement NonBUSpecificSubProgramFramework_picklist;

    //JDE Project #
    @FindBy(xpath = "//img[@alt='JDE Project # Lookup (New Window)']")
    public static WebElement JDEProject_lookUp;

    //JDE Client
    @FindBy(xpath = "//img[@alt='JDE Client Lookup (New Window)']")
    public static WebElement JDEClient_lookUp;

    //Event Start
    @FindBy(xpath="//label[text()='Event Start']/following::input[1]")
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
    @FindBy(xpath="//div[@class='title']")
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
    public void closeAlert() throws Throwable{
    	List<WebElement> alertPop = driver.findElements(By.xpath("//a[@class='dialogClose']"));
    if(!isAlertPresents() && alertPop.size()!=0){ 
    	driver.findElement(By.xpath("//a[@class='dialogClose']")).sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
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
                    Thread.sleep(2000);
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
    public static void CostSavingMandatoryFields() throws InterruptedException {
        click(GPJ_SCORE_CostSavingTab);
        click(newBtn);
        click(continueBtn);
        //Select Client Region
        selectByVisibleText(ClientRegion_picklist, "International");
        //Select Savings Type
        selectByVisibleText(SavingsType_picklist, "Efficiencies");
        //Select JDE Vendor
        click(JDEVendor_lookUp);
        // ******************* JDE Vendor Look Up window *********************** //
        switchToWindow(driver);
        switchToIframe(searchFrame);
        Thread.sleep(6000);
        write(lookUpSearch_tf, "Te Papa Tongarewa (NZ) - 666649");
        lookUpSearch_tf.submit();
        driver.switchTo().defaultContent();
        switchToIframe(resultFrame);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Te Papa Tongarewa (NZ) - 666649")).click();
        driver.switchTo().window(parentWindow);
        //*************************************************************************//	
        Thread.sleep(2000);
        // ******************* JDE #Project Look Up window *********************** //
        click(JDEProject_lookUp);
        switchToWindow(driver);
        switchToIframe(searchFrame);
        Thread.sleep(6000);
        write(lookUpSearch_tf, "35GAR12500");
        lookUpSearch_tf.submit();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        switchToIframe(resultFrame);
        Thread.sleep(2000);
        driver.findElement(By.linkText("35GAR12500")).click();
        driver.switchTo().window(parentWindow);

        //***********************************************************//
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
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "1/5/2017");
        write(SCOREDate_tf, "1/15/2017");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
        click(SaveBtn);
        Assert.assertEquals(clientCodeAlertMsg.getText(), "Error: Please select a value. Required when Client Code = 1208 - IBM", "Alert message is not displayed");
        //verifyText(clientCodeAlertMsg, "");

    }

    public void GPJSCORECostSavingRecordSubmission() throws InterruptedException {
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "1/5/2017");
        write(SCOREDate_tf, "1/15/2017");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
        Thread.sleep(2000);
        click(submitBtn);
        Thread.sleep(2000);
        successSubmissionMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "Score Has been Submitted Successfully.");
        Assert.assertEquals(successSubmissionMsg, true);
        click(doneBtn);
        Assert.assertEquals(Status_picklist.getText(), "Submitted", "Status is not changed");

    }

    public void Estimated_and_Negotiated_Validation() throws InterruptedException {
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "1/5/2017");
        write(SCOREDate_tf, "1/15/2017");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
        write(SavingsOverride_tf, "500");
        click(SaveBtn);
        //Check for when entering the Savings Override to check that Estimated and Negotiated costs are blank  -- 
        Assert.assertEquals(Estimated_and_Negotiated_Validation_Alert.getText().contains("Estimated Cost and Negotiated Cost must be blank when using the Savings Override."), true, "Didn't display Alert i.e. ==> Estimated Cost and Negotiated Cost must be blank when using the Savings Override.");

    }

    public void CostCalculationInUSD() throws InterruptedException {
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "1/27/2017");
        write(SCOREDate_tf, "1/15/2017");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);

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
        Assert.assertEquals(actual_NegotiatedCostInUSD, f.format(expected_NegotiatedCostInUSD), "");
        Assert.assertEquals(actual_SavingsInUSD, f.format(expected_SavingsInUSD), "");



    }
    // Note:For below Test Cases Verification, You Need to pass wrong input for Entry Date field
    public void Entry_Date_Validation_Quarter() throws InterruptedException {
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "5/5/2017");
        write(SCOREDate_tf, "1/15/2017");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
        //Check Validation i.e. Entry Date must be in the current quarter and any date lesser than today.   - 
        Assert.assertEquals(Entry_Date_Validation_Quarter_Alert.getText().contains("Error: Entry Date must be in the current quarter and any date lesser than today."), true, "Didn't get alert ==> Error: Entry Date must be in the current quarter and any date lesser than today.");
    }

    // Note:For below Test Cases Verification, You Need to pass wrong input for Score Date field 
    public void SCORE_Date_Validation_Quarter() throws InterruptedException {
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "1/5/2017");
        write(SCOREDate_tf, "7/15/2017");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
        //Check Validation i.e. The Data entry will be accepted for the current quarter and previous quarter. Older data is frozen - 
        Assert.assertEquals(SCORE_Date_Validation_Quarter_Alert.getText().contains("Error: Sorry. SCORE Date must be in the current or previous quarter only."), true, "Didn't get alert ==> Error: Sorry. SCORE Date must be in the current or previous quarter only.");
    }

    //check after selecting JDE Project, its Event details are getting populate or not 
    public void JDE_Project_Functionality() throws InterruptedException {
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "1/5/2017");
        write(SCOREDate_tf, "1/15/2017");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
        Thread.sleep(2000);
        //Edit same record for verification 
        click(EditBtn);
        //Update Event Name
        Thread.sleep(2000);
        EventName_tf.clear();
        write(EventName_tf, "Test Event Name");
        Thread.sleep(2000);
        click(SaveBtn);

        //Check Event Name was same as updated
        Assert.assertEquals(EventName_DetailPage.getText(), "Test Event Name", "Couldn't update Event Name");


        // *******************Again Chnaged JDE Project Name 103968500 *********************** //
        click(EditBtn);
        click(JDEProject_lookUp);
        switchToWindow(driver);
        switchToIframe(searchFrame);
        write(lookUpSearch_tf, "103968500");
        lookUpSearch_tf.submit();
        driver.switchTo().defaultContent();
        switchToIframe(resultFrame);
        driver.findElement(By.linkText("103968500")).click();
        driver.switchTo().window(parentWindow);
        Thread.sleep(1000);
        click(SaveBtn);
        //Verification that updated Event Name is override on previous Event Name

        Assert.assertNotEquals(EventName_DetailPage.getText(), "Test Event Name", "Couldn't Override Event Name");

    }

    //@Function: Used to Check Non BU Specific Sub Program Framework is not mandatory if Client Code i other than 1208- IBM
    public void OtherClientCodeFunctionality() throws InterruptedException {
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "1/5/2017");
        write(SCOREDate_tf, "1/15/2017");
        selectByVisibleText(ClientCode_picklist, "224895 - IBM Non Marketing");
        click(SaveBtn);
        Assert.assertEquals(driver.getTitle().contains("GPJ SCORE Cost Saving"), true, "Record doesn't save");
    }

    //To check for Field Officer user's privileges 
    public void Field_Officer_Functionality() throws Throwable {
        //Login with Field Officer Usr i.e. Julie Priebe
        navigate("Field_Officer");
        isLoggedIn = true;
        //click LogIn button
        click(User_Login_btn);
        Thread.sleep(2000);

        GPJSCORECostSavingRecordSubmission();

        click(GPJ_SCORE_CostSavingTab);

        //Select APAC - 2. Pending Regional Approval from View PickList 
        //selectByTextUsingJavaScript(selectListView_picklist, "APAC - 2. Pending Regional Approval");
        //selectByVisibleText(selectListView_picklist, "APAC - 2. Pending Regional Approval");
        
        clickDropdownElement(selectListView_picklist,"option","CQ - 2. Pending Regional Approval");
        Thread.sleep(3000);

        click(go_btn);
        
        Assert.assertEquals("CQ - 2. Pending Regional Approval", getSelectedOption(selectListView_picklist), "Selected Value not displaying");

        //Check records are available on List View 
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        closeAlert();
      
        //checkCheckBox(allCheckbox);
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCheckbox.get(j).click();
        }

        Thread.sleep(2000);
        //Click Regional Approval
        click(Regional_Approval_btn);

        //Verify Filed Officer Privileges For regional Approval 
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Field Officer couldn't perform Reginoal Approval");

        // Go back to list View Page by clicking on Here Link
        click(here_btn);
        // ************** Check for Quarterly Approval *************************//
        //Select APAC - 3. Pending Quarterly Approval from View PickList 
        Thread.sleep(2000);

        click(GPJ_SCORE_CostSavingTab);
        Thread.sleep(5000);

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 3. Pending Quarterly Approval");

        //click Go
        click(go_btn);

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
        Thread.sleep(5000);
        
        closeAlert();
        
        checkCheckBox(allCheckbox);

        //click Quarterly Approval 
        click(Quarterly_Approval_btn);

        //Verify Filed Officer Privileges For Quarterly Approval 
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Field Officer couldn't perform Quarterly Approval");

        // Go back to list View Page by clicking on Here Link
        click(here_btn);

        // ***************** Corporate Approval ************************ //
        //Select APAC - 4. Pending Corporate Approval from View PickList 
        Thread.sleep(2000);

        click(GPJ_SCORE_CostSavingTab);
        Thread.sleep(3000);

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 4. Pending Corporate Approval");

        //click Go
        click(go_btn);

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");
        Thread.sleep(5000);
        
        closeAlert();
        
        checkCheckBox(allCheckbox);


        Thread.sleep(5000);
        //click Quarterly Approval 
        click(Corporate_Approval_btn);

        //Verify Filed Officer Privileges For regional Approval 
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Field Officer couldn't perform Corporate Approval");

        // Go back to list View Page by clicking on Here Link
        click(here_btn);

        //Logout
        click(Header_link);
        Logout(logout_btn);
        isLoggedIn = false;
    }

    //To check for Regional Officer user's privileges 
    public void Regional_Officer_Functionality() throws Throwable {
        if (!isLoggedIn) {
            //Login with Field Officer Usr i.e. Julie  APAC - 2. Pending Regional Approval
            navigate("Regional_Officer");
        } else {
            click(Header_link);
            Logout(logout_btn);
            isLoggedIn = false;
            navigate("Regional_Officer");


        }
        //click LogIn button
        click(User_Login_btn);
        isLoggedIn = true;
        Thread.sleep(2000);

        GPJSCORECostSavingRecordSubmission();

        click(GPJ_SCORE_CostSavingTab);

        //Select Pending Regional Approval
        //selectByTextUsingJavaScript(selectListView_picklist, "APAC - 2. Pending Regional Approval");
        clickDropdownElement(selectListView_picklist,"option","APAC - 2. Pending Regional Approval");
        Thread.sleep(5000);

        Assert.assertEquals("APAC - 2. Pending Regional Approval", getSelectedOption(selectListView_picklist), "Selected Value not displaying");
        
        click(go_btn);

        //Check records are available on List View 
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        closeAlert();
        
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCheckbox.get(j).click();
        }

        //Click Regional Approval
        click(Regional_Approval_btn);
        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        //Get Success message
        successRegionalApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");
        //Verify
        Assert.assertEquals(successRegionalApprovalMsg, true, "Didn't get Success message while Regional Approval");

        // Click on Back button
        click(ReginoalApprovedBack_btn);

        //Select APAC - 3. Pending Quarterly Approval 
        click(GPJ_SCORE_CostSavingTab);
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 3. Pending Quarterly Approval");
        click(go_btn);

        //Check records are available on List View
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        closeAlert();
        
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemQCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemQCheckbox.get(j).click();
        }

        Thread.sleep(3000);
        click(Quarterly_Approval_btn);

        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        //Get Success message of Quarterly Approval
        successQuarterlyApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");

        //Verify
        Assert.assertEquals(successRegionalApprovalMsg, true, "Didn't get Success message while Quarterly Approval");

        // Click on Back button 
        click(ReginoalApprovedBack_btn);

        //Select APAC - 3. Pending Corporate Approval 
        click(GPJ_SCORE_CostSavingTab);
        Thread.sleep(3000);

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 4. Pending Corporate Approval");

        //click Go
        click(go_btn);

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        closeAlert();
        
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCCheckbox.get(j).click();
        }

        Thread.sleep(3000);
        click(Corporate_Approval_btn);
        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Regional Officer couldn't perform Corporate Approval");

        // Click on Back button APAC - 4. Pending Corporate Approval
        click(here_btn);

        //Logout
        click(Header_link);
        Logout(logout_btn);
        isLoggedIn = false;

    }

    public void Corporate_Officer_Functionality() throws Throwable {
        if (!isLoggedIn) {
            //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
            navigate("Corporate_Officer");
        } else {
            click(Header_link);
            Logout(logout_btn);
            isLoggedIn = false;
            navigate("Corporate_Officer");


        }
        //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
        //navigate("Corporate_Officer");

        //click LogIn button
        click(User_Login_btn);
        isLoggedIn = true;
        Thread.sleep(2000);

        GPJSCORECostSavingRecordSubmission();

        click(GPJ_SCORE_CostSavingTab);

        //Select Pending Regional Approval
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 2. Pending Regional Approval");
        Thread.sleep(5000);

        click(go_btn);

        //Check records are available on List View 
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        closeAlert();
        
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCheckbox.get(j).click();
        }

        //Click Regional Approval
        click(Regional_Approval_btn);
        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        //Get Success message
        successRegionalApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");
        //Verify
        Assert.assertEquals(successRegionalApprovalMsg, true, "Didn't get Success message while Regional Approval");

        // Click on Back button
        click(ReginoalApprovedBack_btn);

        //Select APAC - 3. Pending Quarterly Approval 
        click(GPJ_SCORE_CostSavingTab);
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 3. Pending Quarterly Approval");
        click(go_btn);

        //Check records are available on List View
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        closeAlert();
        
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemQCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemQCheckbox.get(j).click();
        }

        Thread.sleep(3000);
        click(Quarterly_Approval_btn);

        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        //Get Success message of Quarterly Approval
        successQuarterlyApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");

        //Verify
        Assert.assertEquals(successQuarterlyApprovalMsg, true, "Didn't get Success message while Quarterly Approval");

        // Click on Back button 
        click(ReginoalApprovedBack_btn);

        //Select APAC - 3. Pending Corporate Approval 
        click(GPJ_SCORE_CostSavingTab);
        Thread.sleep(3000);

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 4. Pending Corporate Approval");

        //click Go
        click(go_btn);

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        closeAlert();
        
        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCCheckbox.get(j).click();
        }

        Thread.sleep(3000);
        click(Corporate_Approval_btn);
        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        //Get Success message of Quarterly Approval
        successCorporateApprovalMsg = successMsgAftersubmissionApproval.getText().contains("Success:" + "\n" +
            "1 Score have been Approved.");

        //Verify
        Assert.assertEquals(successCorporateApprovalMsg, true, "Didn't get Success message while Quarterly Approval");

        // Click on Back button 
        click(ReginoalApprovedBack_btn);

        //Logout
        click(Header_link);
        Logout(logout_btn);
        isLoggedIn = false;

    }

    public void Verify_Draft_SCORE_All_Aprroval_For_RegionalUser() throws InterruptedException {
        //Login with Field Officer Usr i.e. Julie  APAC - 2. Pending Regional Approval
        //navigate("Regional_Officer");

        if (!isLoggedIn) {
            //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
            navigate("Regional_Officer");
        } else {
            click(Header_link);
            Logout(logout_btn);
            isLoggedIn = false;
            navigate("Regional_Officer");

        }
        //click LogIn button
        click(User_Login_btn);
        isLoggedIn = true;
        Thread.sleep(2000);

        GPJSCORECostSavingRecordSubmission();

        click(GPJ_SCORE_CostSavingTab);

        //Select Pending Submission
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 1. Pending Submission");
        Thread.sleep(5000);

        click(go_btn);

        //Check records are available on List View 
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCheckbox.get(j).click();
        }

        //Click Regional Approval
        click(Regional_Approval_btn);
        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        //Get Success message
        //successRegionalApprovalMsg = successMsgAftersubmissionApproval.getText().contains("No records are available for Regional Approval");

        //Verify
        Assert.assertEquals(successMsgAftersubmissionApproval.getText(), "No records are available for Regional Approval", "Didn't get alert message while approving drafted Score to Regional");

        // Click on Back button
        click(ReginoalApprovedBack_btn);

        //Select APAC - 3. Pending Quarterly Approval 
        click(GPJ_SCORE_CostSavingTab);
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 1. Pending Submission");
        click(go_btn);

        //Check records are available on List View
        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemQCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemQCheckbox.get(j).click();
        }

        Thread.sleep(3000);
        click(Quarterly_Approval_btn);

        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        //Get Success message of Quarterly Approval
        //successRegionalApprovalMsg = successMsgAftersubmissionApproval.getText().contains("No records are available for Quarterly Approval");

        //Verify
        Assert.assertEquals(successMsgAftersubmissionApproval.getText(), "No records are available for Quarterly Approval", "Didn't get alert message while approving drafted Score to Regional");

        // Click on Back button 
        click(ReginoalApprovedBack_btn);

        //Select APAC - 3. Pending Corporate Approval 
        click(GPJ_SCORE_CostSavingTab);
        Thread.sleep(3000);

        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 1. Pending Submission");

        //click Go
        click(go_btn);

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        //Write Validations for GPJ_SCORE_Regional_Approval_Page_IBM Page 
        List < WebElement > elemCCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 1; j++) {
            elemCCheckbox.get(j).click();
        }

        Thread.sleep(3000);
        click(Corporate_Approval_btn);
        Thread.sleep(2000);

        //Click Approve Button
        click(Approved_btn);

        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Insufficient Privileges' Error message As Regional Officer couldn't perform Corporate Approval");

        // Click on Back button APAC - 4. Pending Corporate Approval
        click(here_btn);

        //Logout
        click(Header_link);
        Logout(logout_btn);
        isLoggedIn = false;

    }

    public void Only_RecordOwner_Allowed_To_Submit_Score() throws InterruptedException {
        if (!isLoggedIn) {
            //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
            navigate("Field_Officer");
        } else {
            click(Header_link);
            Logout(logout_btn);
            isLoggedIn = false;
            navigate("Field_Officer");


        }
        //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
        //navigate("Corporate_Officer");

        //click LogIn button
        click(User_Login_btn);
        isLoggedIn = true;
        Thread.sleep(2000);

        // Create Score Record
        CostSavingMandatoryFields();
        entryDate_tf.clear();
        write(entryDate_tf, "1/5/2017");
        write(SCOREDate_tf, "1/15/2017");
        selectByVisibleText(ClientCode_picklist, "1208 - IBM");
        selectByVisibleText(NonBUSpecificSubProgramFramework_picklist, "Non BU Specific - Hrs Ovr Rtr");
        click(SaveBtn);
        recordURL = driver.getCurrentUrl();
        Thread.sleep(2000);

        //Logout
        click(Header_link);
        Logout(logout_btn);
        isLoggedIn = false;

        //now Login with Regional User
        if (!isLoggedIn) {
            //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
            navigate("Regional_Officer");
        } else {
            click(Header_link);
            Logout(logout_btn);
            isLoggedIn = false;
            navigate("Regional_Officer");

        }
        //click LogIn button
        click(User_Login_btn);
        isLoggedIn = true;
        Thread.sleep(2000);

        //Navigate to created record URL
        driver.get(recordURL);

        // click on Submit button
        click(submitBtn);

        //Verify
        Assert.assertEquals(successMsgAftersubmissionApproval.getText(), "Only Record Owner is allowed to Submit the SCORE.", "Alert message i.e. 'Only Record Owner is allowed to Submit the SCORE.' not displayed while submitting the Score." + recordURL);

        //click on done button
        click(doneBtn);

        //Logout
        click(Header_link);
        Logout(logout_btn);
        isLoggedIn = false;
    }

    public void Corporate_Approval_Not_Deleted_By_FieldandRegionalUsers() throws Throwable {
        if (!isLoggedIn) {
            //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
            navigate("Field_Officer");
        } else {
            click(Header_link);
            Logout(logout_btn);
            isLoggedIn = false;
            navigate("Field_Officer");


        }
        //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
        //navigate("Corporate_Officer");

        //click LogIn button
        click(User_Login_btn);
        isLoggedIn = true;
        Thread.sleep(2000);

        //click on Tab
        click(GPJ_SCORE_CostSavingTab);

        // select APAC - 5. Corporate Approved
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 5. Corporate Approved");

        // click go
        click(go_btn);

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        // click top record and open in tab
        List < WebElement > elemCCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-NAME']"));
        for (int j = 0; j < 1; j++) {
            elemCCheckbox.get(j).click();
        }

        Thread.sleep(3000);

        //click delete button
        click(DeleteBtn);
        if (isAlertPresents()) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }


        //Verify Filed Officer Privileges For regional Approval 
        Assert.assertEquals(ValidationErrorsMsg.getText().contains("Validation Errors While Saving Record(s)"), true, "Failed: It should display 'Validation Errors While Saving Record(s)' Error message As Corporate Approval Not Deleted By Field Users");

        click(here_btn);

        //Logout
        click(Header_link);
        Logout(logout_btn);
        isLoggedIn = false;


        //now Login with Regional User
        if (!isLoggedIn) {
            //Login with Field Officer User i.e. Julie  APAC - 2. Pending Regional Approval
            navigate("Regional_Officer");
        } else {
            click(Header_link);
            Logout(logout_btn);
            isLoggedIn = false;
            navigate("Regional_Officer");

        }
        //click LogIn button
        click(User_Login_btn);
        isLoggedIn = true;
        Thread.sleep(2000);

        //click on Tab
        click(GPJ_SCORE_CostSavingTab);

        // select APAC - 5. Corporate Approved
        selectByTextUsingJavaScript(selectListView_picklist, "All");
        Thread.sleep(3000);
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 5. Corporate Approved");

        // click go
        if (driver.findElements(By.name("go")).size() != 0) {
            click(go_btn);
        }

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        // click top record and open in tab
        List < WebElement > elemCCheckbox1 = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-NAME']"));
        for (int k = 0; k < 1; k++) {
            elemCCheckbox1.get(k).click();
        }

        Thread.sleep(3000);

        //click delete button
        click(DeleteBtn);
        if (isAlertPresents()) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
        //Verify Filed Officer Privileges For regional Approval 
        Assert.assertEquals(InsufficientErrorMsg.getText().contains("Insufficient Privileges"), true, "Failed: It should display 'Validation Errors While Saving Record(s)' Error message As Corporate Approval Not Deleted By Regional Users");

        click(here_btn);

        //Logout
        click(Header_link);
        Logout(logout_btn);
        isLoggedIn = false;

    }
    
    public void Summition_Of_SavingsInUSD_OnApprovalPage() throws InterruptedException{
    	

        //click on Tab
        click(GPJ_SCORE_CostSavingTab);

        // select APAC - 5. Corporate Approved
        selectByTextUsingJavaScript(selectListView_picklist, "APAC - 2. Pending Regional Approval");

        // click go
        click(go_btn);

        Assert.assertNotEquals(driver.findElement(By.id("ext-gen11")).getText(), "No records to display.", "No Data for display || Hence Test Cases Skipped.");

        // click top record and open in tab
        List < WebElement > elemCheckbox = driver.findElements(By.cssSelector("[class='x-grid3-cell-inner x-grid3-col-checkbox']"));
        for (int j = 0; j < 10; j++) {
            elemCheckbox.get(j).click();
        }

        Thread.sleep(2000);
        
        //Click Regional Approval
        click(Regional_Approval_btn);
        
        //Get Title Value
        Title = Double.valueOf(titleApproval.getText().substring(titleApproval.getText().indexOf("$")+1, titleApproval.getText().indexOf("(") -1));
        List<Double> scoreTotalList = new ArrayList<Double>();
        List<WebElement> totalList = driver.findElements(By.xpath("//h3[@class='accordion-head maincont']"));
        for (WebElement match: totalList) {
            match.click();
            System.out.println(match.getText());
            System.out.println(match.getText().substring(match.getText().indexOf("$")+1, match.getText().indexOf("(") -1));
            scoreTotalList.add(Double.parseDouble(match.getText().substring(match.getText().indexOf("$")+1, match.getText().indexOf("(") -1)));
            
        }
        
        for(Double sum : scoreTotalList){
       	 scoreSum += sum;
       	 
        }
        
        Assert.assertEquals(Title, scoreSum,scoreSum+" is not equall to Header's value i.e. " + Title);
        
           
        Thread.sleep(2000);
        
        
    	
    }
}