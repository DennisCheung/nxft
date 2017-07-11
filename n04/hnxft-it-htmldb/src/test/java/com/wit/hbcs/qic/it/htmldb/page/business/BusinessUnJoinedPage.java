package com.wit.hbcs.qic.it.htmldb.page.business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessUnJoinedPage {

    protected final WebDriver driver;

    @FindBy(id = "infoText")
    private WebElement infoText;

    public BusinessUnJoinedPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInfoText() {
        return this.infoText;
    }

    public <T> T clickJoinBusinessCircle(Class<T> resultPage, String businessId) throws Exception {
        WebElement c = driver.findElement(By.className("joinid-sq"));
        Coordinates coor = ((Locatable) c).getCoordinates();
        coor.inViewPort();

        c.click();
        return PageFactory.initElements(driver, resultPage);
    }
}
