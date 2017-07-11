package com.wit.hbcs.qic.it.htmldb.page.business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wit.hbcs.qic.it.htmldb.base.ServerUtils;

import lombok.Getter;

@Getter
public class BusinessMainPage {

    protected final WebDriver driver;

    @FindBy(id = "contactList")
    private WebElement contactList;

    public static BusinessMainPage to(WebDriver driver) throws Exception {
        driver.get(ServerUtils.getServerUri("/hall/开通服务"));
        return PageFactory.initElements(driver, BusinessMainPage.class);
    }

    public BusinessMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public WebElement getContactList() {
        return this.contactList;
    }

    public <T> T choiseBusinessCirle(Class<T> resultPage, String businessId) throws Exception {
        WebElement w = driver.findElement(By.id(businessId));

        Coordinates coor = ((Locatable) w).getCoordinates();
        coor.inViewPort();

        w.click();
        return PageFactory.initElements(driver, resultPage);
    }
}
