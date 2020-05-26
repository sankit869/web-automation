package com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

    public WebDriver driver;
    public static Properties prop;
    private String browserName;
    protected final Logger BASE_LOGGER = LoggerFactory.getLogger(BaseSetup.class);
    public static String url;
    public static SoftAssert softAssert = new SoftAssert();

    public Properties loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream fileInputStream =
                new FileInputStream(System.getProperty("user.dir") + "/configurator.properties");
        prop.load(fileInputStream);
        browserName = prop.getProperty("browser");
        url = prop.getProperty("url");
        return prop;
    }

    public WebDriver initializeDriver() throws IOException {
        loadProperties();
        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void getFailedScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File("./test-output/screenshots/failure/" + result.getName()
                        + ".png"));
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    public void getScreenshotOnAnyCase(ITestResult result) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./test-output/screenshots/allScreenshots/" + result.getName()
                    + ".png"));
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
}