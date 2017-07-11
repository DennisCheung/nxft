package com.wit.hbcs.qic.it.htmldb.page.business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WriteVerificationPage {
    protected final WebDriver driver;

    @FindBy(id = "testArea")
    private WebElement testArea;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    public WriteVerificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTestArea() {
        return testArea;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public <T> T joinBusinessCricleAndReturnToMainPage(Class<T> resultPage, String verificationMessage) throws Exception {
        Coordinates coor = ((Locatable) this.testArea).getCoordinates();
        coor.inViewPort();
        this.testArea.sendKeys(verificationMessage);

        Coordinates coor1 = ((Locatable) this.saveButton).getCoordinates();
        coor1.inViewPort();
        this.saveButton.click();

        WebElement confirmBtn = driver.findElement(By.className("layui-layer-btn0"));

        Coordinates coor2 = ((Locatable) confirmBtn).getCoordinates();
        coor2.inViewPort();
        confirmBtn.click();
        return PageFactory.initElements(driver, resultPage);
    }
}
