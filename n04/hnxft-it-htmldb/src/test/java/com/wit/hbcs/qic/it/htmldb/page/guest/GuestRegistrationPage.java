package com.wit.hbcs.qic.it.htmldb.page.guest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wit.hbcs.qic.it.htmldb.base.ServerUtils;

import lombok.Getter;

@Getter
public class GuestRegistrationPage {

    protected final WebDriver driver;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "onlyLx")
    private WebElement onlyLx;

    @FindBy(id = "submit")
    private WebElement submit;

    public static GuestRegistrationPage to(WebDriver driver) throws Exception {
        driver.get(ServerUtils.getServerUri("/public/注册"));
        return PageFactory.initElements(driver, GuestRegistrationPage.class);
    }

    public GuestRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T register(Class<T> resultPage, String name, String onlyLx) throws Exception {
        this.name.sendKeys(name);
        this.onlyLx.sendKeys(onlyLx);
        this.submit.click();
        return PageFactory.initElements(driver, resultPage);
    }

}
