package com.wit.hbcs.qic.it.htmldb.page.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConversationPage {

    protected final WebDriver driver;

    @FindBy(id = "wdwd")
    private WebElement show;

    public ConversationPage(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T show(Class<T> resultPage) throws Exception {
        this.show.click();
        return PageFactory.initElements(driver, resultPage);
    }
}
