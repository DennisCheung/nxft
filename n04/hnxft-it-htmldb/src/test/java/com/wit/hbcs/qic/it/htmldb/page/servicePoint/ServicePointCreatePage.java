package com.wit.hbcs.qic.it.htmldb.page.servicePoint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wit.hbcs.qic.it.htmldb.base.ServerUtils;

import lombok.Getter;

@Getter
public class ServicePointCreatePage {

    protected final WebDriver driver;

    @FindBy(id = "siteName")
    private WebElement siteName;

    @FindBy(id = "contactPhone")
    private WebElement contactPhone;

    @FindBy(id = "submit")
    private WebElement submit;

    public static ServicePointCreatePage to(WebDriver driver) throws Exception {
        driver.get(ServerUtils.getServerUri("/pep/创建服务点"));
        return PageFactory.initElements(driver, ServicePointCreatePage.class);
    }

    public ServicePointCreatePage(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T createServicePoint(Class<T> resultPage, String siteName, String contactPhone) throws Exception {
        this.siteName.sendKeys(siteName);
        this.contactPhone.sendKeys(contactPhone);

        Coordinates coor = ((Locatable) this.submit).getCoordinates();
        coor.inViewPort();

        this.submit.click();
        return PageFactory.initElements(driver, resultPage);
    }

}
