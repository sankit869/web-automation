package com.helperActions;

import com.utils.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperActionsUtils extends BaseSetup {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement webElement;
    public HelperActionsUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void getUrl() {
        try {
            driver.get(url);
            BASE_LOGGER.info("Successfully navigated to the URL as :  " + BaseSetup.url);
        } catch (Exception ex) {
            String exceptionData = ex.getCause().getMessage();
            BASE_LOGGER.error("Unable to navigate to URL  : " + BaseSetup.url + " with the error as : " + exceptionData);
        }
    }

    public void safeClick(By element) {
        try {
            waitForElementToBeClickAble(element, 150);
            driver.findElement(element).click();
        } catch (Exception e) {
            String message = e.getMessage();
            BASE_LOGGER.error("Error encountered i.e : " + message
                    + " while performing safeClick on the element : " + element);
        }
    }
    public boolean isElementDisplayed(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
            return driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void safeType(By element, String value) {
        try {
            waitForElementToBeClickAble(element, 60);
            driver.findElement(element).sendKeys(value);
        } catch (Exception e) {
            String message = e.getCause().getMessage();
            BASE_LOGGER.error("Error encountered i.e : " + message
                    + " while performing safeType on the element : " + element);
        }
    }

    public void safeClear(By element) {
        try {
            waitForElementToBeClickAble(element, 60);
            driver.findElement(element).clear();
        } catch (Exception e) {
            String message = e.getCause().getMessage();
            BASE_LOGGER.error("Error encountered i.e : " + message
                    + " while performing safeClear on the element : " + element);
        }
    }

    public void waitForElementNotToBeDisplay(By element, int timeOuts) {
        try {
            webElement = driver.findElement(element);
            wait = new WebDriverWait(driver, timeOuts);
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (Exception ex) {
            String exceptionData = ex.getCause().getMessage();
            BASE_LOGGER.error("waitForElementNotToBeDisplay operation has been failed for the locator : "
                    + String.valueOf(element) + " with the exception i.e : " + exceptionData);
        }
    }

    public void waitForElementToBeClickable(By element, int timeOuts) {
        try {
            wait = new WebDriverWait(driver, timeOuts);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception ex) {
            String exceptionData = ex.getCause().getMessage();
            BASE_LOGGER.error("waitForElementToBeClickable operation has been failed for the locator : "
                    + String.valueOf(element) + " with the exception i.e : " + exceptionData);
        }
    }

    public void waitForElementToBeDisplay(By element, int timeOuts) {
        try {
            wait = new WebDriverWait(driver, timeOuts);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception ex) {
            String exceptionData = ex.getCause().getMessage();
            BASE_LOGGER.error("waitForElementToBeDisplayed operation has been failed for the locator : "
                    + String.valueOf(element) + " with the exception i.e : " + exceptionData);
        }
    }

    public void waitForElementToBeClickAble(By element, int timeOuts) {
        try {
            wait = new WebDriverWait(driver, timeOuts);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception ex) {
            String exceptionData = ex.getCause().getMessage();
            BASE_LOGGER.error("waitForElementToBeClickAble operation has been failed for the locator : "
                    + String.valueOf(element) + " with the exception i.e : " + exceptionData);
        }
    }


    public void waitForElementToPresence(By element, int timeOuts) {
        try {
            wait=new WebDriverWait(driver,timeOuts);
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (Exception ex) {
            String exceptionData = ex.getCause().getMessage();
            BASE_LOGGER.error("waitForElementToPresence operation has been failed for the locator : "
                    + String.valueOf(element)
                    + " with the exception i.e : " + exceptionData);
        }
    }

    public List<WebElement> getElements(By elements) {
        try {
            waitForElementToBeClickAble(elements, 60);
            List<WebElement> allElements = driver.findElements(elements);
            return allElements;
        } catch (Exception ex) {
            String exceptionData = ex.getCause().getMessage();
            BASE_LOGGER.error("GetElements operation has been failed for the locator : " + String.valueOf(elements)
                    + " with the exception i.e : " + exceptionData);
            return null;
        }
    }

    public String getText(By element) {
        try {
            waitForElementToPresence(element, 10);
            String string = driver.findElement(element).getText();
            return string;
        } catch (Exception ex) {
            String exceptionData = ex.getCause().getMessage();
            BASE_LOGGER.error("getText operation has been failed for the locator : "
                    + String.valueOf(element) + " with the exception i.e : " + exceptionData);
            return null;
        }
    }

    public boolean isDisplayed(By element) {
        boolean isDisplayed = false;
        try {
            waitForElementToBeDisplay(element, 15);
            if(driver.findElement(element).isDisplayed()) {
                isDisplayed = true;
            }
        } catch (Exception e) {
            BASE_LOGGER.error("Error encountered while checking isDisplayed for element as : " + element + "As : "
                    + e.getCause().getMessage());
        }
        return isDisplayed;
    }

    public void scrollToParticularElement(By element) {
        try {
            WebElement webElement = driver.findElement(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            waitForElementToBeDisplay(element, 30);
        } catch (Exception e) {
            BASE_LOGGER.error("Error encountered while scrolling to the element on : " + element + "As : "
                    + e.getCause().getMessage());
        }
    }

    public boolean isEnabled(By element) {
        boolean isEnabled = false;
        try {
            waitForElementToBeDisplay(element, 15);
            if(driver.findElement(element).isEnabled()) {
                isEnabled = true;
            }
        } catch (Exception e) {
            BASE_LOGGER.error("Error encountered while checking isEnabled for element as : " + element + "As : "
                    + e.getCause().getMessage());
        }
        return isEnabled;
    }
}