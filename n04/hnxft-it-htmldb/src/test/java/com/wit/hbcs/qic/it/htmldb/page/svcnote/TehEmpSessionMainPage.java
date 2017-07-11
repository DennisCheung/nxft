package com.wit.hbcs.qic.it.htmldb.page.svcnote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wit.hbcs.qic.it.htmldb.base.ServerUtils;

import lombok.Getter;

@Getter
public class TehEmpSessionMainPage {

    protected final WebDriver driver;

    @FindBy(id = "acceptButton")
    private WebElement acceptButton;

    @FindBy(id = "refuseButton")
    private WebElement refuseButton;

    public static TehEmpSessionMainPage to(WebDriver driver) throws Exception {
        driver.get(ServerUtils.getServerUri("/public/tehempsession/index?svcnoteId=00136"));
        return PageFactory.initElements(driver, TehEmpSessionMainPage.class);
    }

    public TehEmpSessionMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T accept(Class<T> resultPage) throws Exception {
        Coordinates coor = ((Locatable) this.acceptButton).getCoordinates();
        coor.inViewPort();
        this.acceptButton.click();
        return PageFactory.initElements(driver, resultPage);
    }

    public <T> T refuse(Class<T> resultPage) throws Exception {
        Coordinates coor = ((Locatable) this.refuseButton).getCoordinates();
        coor.inViewPort();
        this.refuseButton.click();
        return PageFactory.initElements(driver, resultPage);
    }

}
