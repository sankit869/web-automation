package com.pageModules.pagesActions;

import com.helperActions.HelperActionsUtils;
import com.pageModules.iPageRepository.IHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends HelperActionsUtils implements IHomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public void commonSteps() {
        closePopUp();
        navToChartNotes();
    }
    public void navToLoginPage(){
        safeClick(loginBtn);
    }
    public void login(){
        safeType(username,"dev+4@deepscribe.ai");
        safeType(password,"vgS9Y3RDhq2tnhE");
        safeClick(signin);
    }
    public void closePopUp(){
        try{
            waitForElementNotToBeDisplay(loder, 60);
            waitForElementToBeDisplay(popUp,60);
            safeClick(popUp);
        }catch (Exception e){
            System.out.println("no popup found "+e.getMessage());
        }
    }


    public String getPhysicianNotes(){
        return getText(physicianNotes);
    }
    public void navToChartNotes(){
        waitForElementNotToBeDisplay(loder, 60);
        waitForElementToPresence(chartNotes,60);
        safeClick(chartNotes);
        waitForElementNotToBeDisplay(loder, 60);
    }
    public void navToPatientChart(){
        waitForElementNotToBeDisplay(loder, 60);
        waitForElementToBeClickable(patientChart,60);
        safeClick(patientChart);
    }

    public void clickOnHistoryTab() {
        waitForElementToBeClickable(historyText,60);
        safeClick(historyText);
    }

    public void frame() {
        waitForElementToBeDisplay(frame, 60);
        driver.switchTo().frame(driver.findElement(frame))
                .findElement(historyOfPresentIllnessTextFiled)
                .sendKeys("Patient have very high fever");
        driver.switchTo().defaultContent();
    }

    public void clickOnEditBtn(){
        waitForElementToPresence(editBtn,60);
        safeClick(editBtn);
    }
    public void waitUntilLoaderDisappear(){
        isElementDisplayed(loder);
    }
}