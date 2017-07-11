package com.wit.hbcs.qic.it.htmldb.page.device;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReleaseRecordPage {

    protected final WebDriver driver;

    @FindBy(id = "releaseButton")
    private WebElement releaseButton;

    public ReleaseRecordPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getReleaseButton() {
        return releaseButton;
    }

    public <T> T release(Class<T> resultPage) throws Exception {
        Coordinates coor = ((Locatable) this.releaseButton).getCoordinates();
        coor.inViewPort();

        this.releaseButton.click();
        return PageFactory.initElements(driver, resultPage);
    }
}
