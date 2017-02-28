package Base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Keywords extends TestBase {

    //open a browser if its not opened
    public void openBrowser() {

        if (CONFIG.getProperty("browserType").equals("MOZILLA")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver(capabilities);
        } else if (CONFIG.getProperty("browserType").equals("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//IEDriverServer.exe");
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(ieCapabilities);
        } else if (CONFIG.getProperty("browserType").equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
            driver = new ChromeDriver();
        } else if (CONFIG.getProperty("browserType").equals("HTML")) {
            driver = new HtmlUnitDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


    }

    //Login
    public void login() throws IOException {
        try {
            driver.findElement(By.name(OR.getProperty("uname_tf"))).sendKeys(CONFIG.getProperty("username"));
            driver.findElement(By.name(OR.getProperty("pwd_tf"))).sendKeys(CONFIG.getProperty("password"));
            driver.findElement(By.name(OR.getProperty("login_btn"))).click();

        } catch (Throwable t) {
            System.out.println("Login Failed ");

        }

    }


    // close browser
    public void closeBrowser() {
        driver.quit();

    }

    public static void takeSnapShot(String fileWithPath) throws Exception {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination 
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }

    //Navigate 
    public static void navigate(String URL) {
        
        try {
            driver.navigate().to(CONFIG.getProperty(URL));
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Throwable t) {
            System.out.println("ERR -- Navigating to URL" + URL + t.getMessage());

        }
    }

    // Refresh the Page.
    public static void refresh() {
        driver.navigate().refresh();
    }

    // clicks on a weblement
    public static void click(WebElement elem) {
    	System.out.println("Executing click..");
        try {
            elem.click();
        } catch (Throwable t) {
        	System.out.println("ERR -- Executing click.." + t.getMessage());

        }
    }

    // writes to a textbox
    public static void write(WebElement elem, String data) {
    	System.out.println("Executing writing to a text box..");
        try {
            elem.sendKeys(data);
            System.out.println("Writing to a text box is successful..");
        } catch (Throwable t) {
        	System.out.println("ERR -- Executing writing to a text box.." + t.getMessage());

        }
    }

    // clicks on a link
    public static void clickLink(WebElement elem) {
    	System.out.println("Executing clickLink..");
        try {
            elem.click();
            System.out.println("PASS -- Executing clickLink..");
        } catch (Throwable t) {
        	System.out.println("ERR --  while clicking on link - " + t.getMessage());

        }

    }

    // verify ant element's text
    public static void verifyText(WebElement elem, String expected) {
    	System.out.println("Executing verifyText..");
        String actual = elem.getText();
        try {
            Assert.assertEquals(actual, expected);
            System.out.println("PASS -- Executing verifyText.." + expected + " alert message displayed");
        } catch (Throwable t) {
            // error
        	System.out.println("Error in verifying text - " + elem + " -- " + t.getMessage());
        	System.out.println("Actual text found - " + actual);
        	System.out.println("Expected text is -" + expected);

        }
    }

    public static void verifyTextPresent(String expected) {
    	System.out.println("Executing verifyTextPresent..");
        String ps = driver.getPageSource();
        try {
            if (ps.contains(expected)) {
            	System.out.println("PASS -- Executing verifyText Present.." + expected + " text Present");
            } else {
            	System.out.println("Error in verifying text present - expected text npt found- ");
            	System.out.println("Expected text is -" + expected);
            }
        } catch (Throwable t) {
            // error
        	System.out.println("Error in verifying text present - expected text npt found- " + t.getMessage());
            System.out.println("Expected text is -" + expected);

        }
    }

    public static void verifyElementPresent(WebElement elem) throws IOException {
        System.out.println("Executing verify Element Present..");

        try {
            if (elem.isDisplayed()) {
                System.out.println("Element is displyed -- > " + elem.getText());
            } else {
                System.out.println("ERR -- Element is not  displyed " + elem.getText());
            }

        } catch (Throwable t) {
            // error
            System.out.println("ERR -- Element is not  displyed " + t.getMessage());
            System.out.println("ERR -- Element is not  displyed " + elem.getText());


            //capturescreenshot(elem.getText() + "_not_displayed");
        }
    }

    public static void selectByIndex(WebElement elem, int index) {
        System.out.println("Executing select Keyword.. ");

        try {
            Select sec = new Select(elem);
            sec.selectByIndex(index);
            System.out.println("PASS -- Selecting an option from drop down box.." + elem + " and with index -- " + index);
        } catch (Throwable t) {
            System.out.println("ERR -- Error while selecting a value based on index from drop down box." + t.getMessage());

        }
    }


    public static void selectByValue(WebElement elem, String value) {
        System.out.println("Executing select Keyword.. ");

        try {
            Select sec = new Select(elem);
            sec.selectByValue(value);
            System.out.println("PASS -- Selecting an option from drop down box.." + elem + " and with value -- " + value);
        } catch (Throwable t) {
            System.out.println("ERR -- Error while selecting a value based on value from drop down box." + t.getMessage());

        }
    }

    public static void selectByVisibleText(WebElement elem, String text) {
        System.out.println("Executing select Keyword.. ");

        try {
            Select sec = new Select(elem);
            sec.selectByVisibleText(text);
            System.out.println("PASS -- Selecting an option from drop down box.." + elem + " and with text -- " + text);
        } catch (Throwable t) {
            System.out.println("ERR -- Error while selecting a value based on text from drop down box." + t.getMessage());

        }
    }

    public static void selectByTextUsingJavaScript(WebElement elem, String option) {
        elem.click();
        JavascriptExecutor excutor = (JavascriptExecutor) driver;
        excutor.executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", elem, option);

    }
    
    public static List<WebElement> getElementsByTagName(WebElement element, String optionName)
    {
       List<WebElement> listOfElements = element.findElements(By.tagName(optionName));
       if(listOfElements.size()!=0)
          return listOfElements;
       else
    	   return null;
    }
    
    public static void clickDropdownElement(WebElement element, String optionName, String optionsValue){
    	try{
    	List<WebElement> listOfViewOptions = getElementsByTagName(element,optionName);
    	for(int i =0; i<listOfViewOptions.size(); i++ ){
    		if(listOfViewOptions.get(i).getText().contains(optionsValue)){
    			listOfViewOptions.get(i).click();
    			break;
    		}
    		}
    	}
    	catch(NoSuchElementException  e){
    		System.out.println("Option value not find in dropdown");
    	}
    }
    
    public static String getSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement selectedElement = select.getFirstSelectedOption();
		String selectedOption = selectedElement.getText();
		return selectedOption;
	}

    public static void checkCheckBox(WebElement elem) {
        try {
            String isChecked = elem.getAttribute("Checked");
            if (isChecked == null) {
                elem.click();
            }
            System.out.println("PASS -- Checking the chechbox.." + elem);
        } catch (Throwable t) {
            System.out.println("ERR -- Error while checking the checkbox." + elem + " -- " + t.getMessage());

        }
    }

    public static void uncheckCheckBox(WebElement elem) {
        try {
            String isChecked = elem.getAttribute("Checked");
            if (isChecked != null) {
                elem.click();
            }
            System.out.println("PASS -- Checking the chechbox.." + elem);
        } catch (Throwable t) {
            System.out.println("ERR -- Error while checking the checkbox." + elem + " -- " + t.getMessage());

        }

    }


    public static void selectRadioBtn(WebElement elem) {
        try {
            String isChecked = elem.getAttribute("selected");
            if (isChecked == null) {
                elem.click();
            }
            System.out.println("PASS -- Selecting the radio button.." + elem);
        } catch (Throwable t) {
            System.out.println("ERR -- Error while Selecting the radio button.." + elem + " -- " + t.getMessage());

        }

    }

    // Manage look up
    public static void switchToWindow(WebDriver dr) {
        parentWindow = dr.getWindowHandle();
        Set < String > handles = dr.getWindowHandles();
        for (String windowHandle: handles) {
            if (!windowHandle.equals(parentWindow)) {
                dr.switchTo().window(windowHandle);
                //System.out.println("Switched to Child window");

            }
        }
    }

    // Manage iFrame
    public static void switchToIframe(WebElement elem) {
        driver.switchTo().frame(elem);
    }

     public static void switchToTab() {
        try {
            ArrayList < String > tabs = new ArrayList(driver.getWindowHandles());
            System.out.println(tabs.size());
            driver.switchTo().window(tabs.get(1));
            System.out.println(driver.getTitle());
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }

    public static void Logout(WebElement elem) {
        Actions action = new Actions(driver);
        action.moveToElement(elem).click().build().perform();

    }

    public static void safeJavaScriptClick(WebElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }
    }

    public static void doubleClick(WebElement element) {
        try {
            Actions action = new Actions(driver).doubleClick(element);
            action.build().perform();

            System.out.println("Double clicked the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " +
                e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM " +
                e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable " +
                e.getStackTrace());
        }
    }

    public void rightClick(WebElement element) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " +
                e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM " +
                e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable " +
                e.getStackTrace());
        }
    }
    

    public boolean isAlertPresents() {
    	try {
    	driver.switchTo().alert();
    	return true;
    	}// try
    	catch (Exception e) {
    	return false;
    	}// catch
    	}

}