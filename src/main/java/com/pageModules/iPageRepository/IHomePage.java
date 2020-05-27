package com.pageModules.iPageRepository;

import org.openqa.selenium.By;

public interface IHomePage {
    By loginBtn = By.xpath("//span[text()='Login']");
    By username = By.id("lid");
    By password = By.id("pwd");
    By signin = By.id("signin_submit");
    By popUp = By.id("NEW_DIALOG_CLOSE_MARK");
    By chartNotes = By.xpath("//span[text()='Chart Notes']");
    By patientChart = By.xpath("(//tbody[@id='chartRecords']/tr)[1]/td[1]");
    By editBtn = By.id("pastEncButton");
    By loder = By.xpath("//div[text()='Loading']");
    By physicianNotes = By.linkText("Physician Notes");
    By historyText = By.id("encounterTab_2");
    By frame = By.xpath("//div[contains(text(),'History of Present Illness')]/../div[@id='editor_2']//iframe");
    By historyOfPresentIllnessTextFiled = By.xpath("//body[@class='ze_body']");
}
