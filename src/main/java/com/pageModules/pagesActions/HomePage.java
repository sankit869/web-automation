package com.pageModules.pagesActions;

import com.helperActions.HelperActionsUtils;
import com.pageModules.iPageRepository.IHomePage;
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
            waitForElementToPresence(popUp,60);
            safeClick(popUp);
        }catch (Exception e){
            System.out.println("no popup found "+e.getMessage());
        }
    }
    public String getPhysicianNotes(){
       return getText(physicianNotes);
    }
    public void navToChartNotes(){
        waitForElementToPresence(chartNotes,60);
        safeClick(chartNotes);
    }
    public void navTopatientChart(){
        waitForElementToPresence(patientChart,60);
        safeClick(patientChart);
    }
    public void frame(){
        driver.switchTo().frame(driver.findElement(frame));
    }
    public void clickOnEditBtn(){
        waitForElementToPresence(editBtn,60);
        safeClick(editBtn);
    }
    public void waitUntilLoaderDisappear(){
        isElementDisplayed(loder);
    }
}
