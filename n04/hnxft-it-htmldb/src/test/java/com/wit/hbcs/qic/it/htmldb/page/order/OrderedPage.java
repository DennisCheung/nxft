package com.wit.hbcs.qic.it.htmldb.page.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderedPage {

    protected final WebDriver driver;

    @FindBy(id = "ttype")
    private WebElement type;

    public OrderedPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getType() {
        return type;
    }
}
