package com.wit.hbcs.qic.it.htmldb.page.order;

import lombok.Getter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wit.hbcs.qic.it.htmldb.base.ServerUtils;

@Getter
public class NewOrderPage {

    protected final WebDriver driver;

    @FindBy(id = "shouli")
    private WebElement shouli;

    public static NewOrderPage to(WebDriver driver, String messageId, String greenSvcnoteId) throws Exception {
        driver.get(ServerUtils.getServerUri("/teh/order/menu/订单详情?messageId=" + messageId + "&orderId=" + greenSvcnoteId));
        return PageFactory.initElements(driver, NewOrderPage.class);
    }

    public NewOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T accept(Class<T> resultPage) throws Exception {
        this.shouli.click();
        return PageFactory.initElements(driver, resultPage);
    }
}
