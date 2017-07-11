package com.wit.hbcs.qic.it.htmldb.page.servicePoint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wit.hbcs.qic.it.htmldb.base.ServerUtils;

import lombok.Getter;

@Getter
public class MyHomePage {

    protected final WebDriver driver;

    @FindBy(id = "currSupplierName")
    private WebElement currSupplierName;

    public WebElement getCurrSupplierName() {
        return currSupplierName;
    }

    public static MyHomePage to(WebDriver driver) throws Exception {
        driver.get(ServerUtils.getServerUri("/pep/我的主页"));
        return PageFactory.initElements(driver, MyHomePage.class);
    }

    public MyHomePage(WebDriver driver) {
        this.driver = driver;
    }

}
