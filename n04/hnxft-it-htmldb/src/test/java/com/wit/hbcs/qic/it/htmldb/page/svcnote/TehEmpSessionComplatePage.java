package com.wit.hbcs.qic.it.htmldb.page.svcnote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TehEmpSessionComplatePage {

    protected final WebDriver driver;

    @FindBy(id = "state")
    private WebElement state;

    public TehEmpSessionComplatePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public WebElement getState() {
        return this.state;
    }

}
