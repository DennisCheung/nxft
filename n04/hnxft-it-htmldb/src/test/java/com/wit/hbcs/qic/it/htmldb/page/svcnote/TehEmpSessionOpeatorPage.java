package com.wit.hbcs.qic.it.htmldb.page.svcnote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lombok.Getter;

@Getter
public class TehEmpSessionOpeatorPage {

    protected final WebDriver driver;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    @FindBy(id = "selectO")
    private WebElement selectO;

    @FindBy(id = "descTextArea")
    private WebElement descTextArea;

    public TehEmpSessionOpeatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public <T> T complate(Class<T> resultPage) throws Exception {
        Coordinates coor = ((Locatable) this.selectO).getCoordinates();
        coor.inViewPort();

        Select selectMon = new Select(selectO);

        selectMon.selectByValue("1");

        Coordinates coor1 = ((Locatable) this.descTextArea).getCoordinates();
        coor1.inViewPort();

        this.descTextArea.sendKeys("已送老人回家");

        Coordinates coor2 = ((Locatable) this.saveButton).getCoordinates();
        coor2.inViewPort();

        this.saveButton.click();
        return PageFactory.initElements(driver, resultPage);
    }

    public <T> T cancel(Class<T> resultPage) throws Exception {
        Coordinates coor = ((Locatable) this.selectO).getCoordinates();
        coor.inViewPort();

        Select selectMon = new Select(selectO);

        selectMon.selectByValue("2");

        Coordinates coor1 = ((Locatable) this.descTextArea).getCoordinates();
        coor1.inViewPort();

        this.descTextArea.sendKeys("老人已被其他助老员送回家");

        Coordinates coor2 = ((Locatable) this.saveButton).getCoordinates();
        coor2.inViewPort();

        this.saveButton.click();
        return PageFactory.initElements(driver, resultPage);
    }

    public WebElement getDescTextArea() {
        return descTextArea;
    }

}
