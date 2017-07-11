package com.wit.hbcs.qic.it.htmldb.page.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoiceServicePointPage {

    protected final WebDriver driver;

    @FindBy(id = "onclickBtn")
    private WebElement servicePoint;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    public ChoiceServicePointPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getServicePoint() {
        return servicePoint;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public <T> T clickedServicePointToJoinBusinessCircle(Class<T> resultPage) throws Exception {
        Coordinates coor = ((Locatable) this.servicePoint).getCoordinates();
        coor.inViewPort();
        this.servicePoint.click();
        Coordinates coor1 = ((Locatable) this.saveButton).getCoordinates();
        coor1.inViewPort();
        this.saveButton.click();
        return PageFactory.initElements(driver, resultPage);
    }
}
