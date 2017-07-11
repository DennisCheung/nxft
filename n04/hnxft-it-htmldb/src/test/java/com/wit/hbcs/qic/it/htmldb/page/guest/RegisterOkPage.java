package com.wit.hbcs.qic.it.htmldb.page.guest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterOkPage {

    protected final WebDriver driver;

    @FindBy(id = "succ")
    private WebElement username;

    public RegisterOkPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return username;
    }

}
