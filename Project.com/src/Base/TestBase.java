package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

//    public static Logger APP_LOGS = null;
    public static Properties CONFIG = null;
    public static Properties OR = null;
    public static WebDriver driver = null;
    public static String parentWindow = "";
    public static String file = System.getProperty("user.dir") + "\\" + "screenshot" + (new Random().nextInt()) + ".png";
    public static DecimalFormat f = new DecimalFormat("##.000");
    public static List < WebElement > elem;

    public static String actual_EstimatedCostInUSD = "";
    public static String actual_NegotiatedCostInUSD = "";
    public static String actual_SavingsInUSD = "";
    public static String actual_ExchangeRate = "";

    public static String EstimatedCostInLocal = "";
    public static String NegotiatedCostInLocal = "";
    public static String SavingsInLocal = "";
    public static String ExchangeRate = "";

    public static double expected_EstimatedCostInUSD = 0;
    public static double expected_NegotiatedCostInUSD = 0;
    public static double expected_SavingsInUSD = 0;

    public static boolean successSubmissionMsg;
    public static boolean successRegionalApprovalMsg;
    public static boolean successQuarterlyApprovalMsg;
    public static boolean successCorporateApprovalMsg;
    public static String Score_Link = "";
    public static boolean isLoggedIn = false;
    public static String recordURL="";
    public static double Title=0;
    public static double scoreSum =0;


    // initialize .Properties files
    public void initialize() throws Exception {

       
        CONFIG = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//src//Config//Config.properties");
        CONFIG.load(ip);

        OR = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "//src//Config/OR.properties");
        OR.load(ip);
        


    }



}