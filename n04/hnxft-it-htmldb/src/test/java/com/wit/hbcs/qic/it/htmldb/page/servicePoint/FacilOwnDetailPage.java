package com.wit.hbcs.qic.it.htmldb.page.servicePoint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacilOwnDetailPage {

    protected final WebDriver driver;

    @FindBy(id = "releseDevice")
    private WebElement releseDevice;

    @FindBy(id = "recoveryDevice")
    private WebElement recoveryDevice;

    public WebElement getReleseDevice() {
        return releseDevice;
    }

    public WebElement getRecoveryDevice() {
        return recoveryDevice;
    }

    public FacilOwnDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T clickToReleseDevice(Class<T> resultPage) throws Exception {
        Coordinates coor = ((Locatable) this.releseDevice).getCoordinates();
        coor.inViewPort();

        this.releseDevice.click();
        return PageFactory.initElements(driver, resultPage);
    }

    public <T> T clickToRecoveryDevice(Class<T> resultPage) throws Exception {
        Coordinates coor = ((Locatable) this.recoveryDevice).getCoordinates();
        coor.inViewPort();

        this.recoveryDevice.click();
        return PageFactory.initElements(driver, resultPage);
    }
}
