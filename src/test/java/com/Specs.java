package com;

import com.helperActions.HelperActionsUtils;
import com.pageModules.pagesActions.HomePage;
import com.utils.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Specs extends BaseSetup {
    WebDriver driver;
    public HelperActionsUtils helperActionsUtils;
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void loginAndSetup() throws IOException {
        driver = initializeDriver();
        helperActionsUtils = new HelperActionsUtils(driver);;
        helperActionsUtils.getUrl();
        homePage = new HomePage(driver);
        homePage.navToLoginPage();
        homePage.login();
    }

    @Test
    public void task1() {
        homePage = new HomePage(driver);
        homePage.closePopUp();
        homePage.navToChartNotes();
        homePage.navToPatientChart();
        homePage.clickOnEditBtn();
        softAssert.assertEquals(homePage.getPhysicianNotes(),"Physician Notes");
        softAssert.assertAll();
    }
    @Test(dependsOnMethods ={"task1"})
    public void task2(){
        homePage.clickOnHistoryTab();
        homePage.frame();
        driver.findElement(By.xpath("//div[text()='Physical Examination']")).click();
        driver.findElement(By.linkText("Templates")).click();

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
