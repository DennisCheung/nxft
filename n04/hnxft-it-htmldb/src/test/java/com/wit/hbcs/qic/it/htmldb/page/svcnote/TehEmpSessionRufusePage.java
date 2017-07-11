package com.wit.hbcs.qic.it.htmldb.page.svcnote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TehEmpSessionRufusePage {

    protected final WebDriver driver;

    @FindBy(id = "state")
    private WebElement state;

    public TehEmpSessionRufusePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public WebElement getState() {
        return this.state;
    }
}
