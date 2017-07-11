package com.wit.hbcs.qic.it.htmldb.page.servicePoint;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManFacilPage {

    protected final WebDriver driver;

    @FindBy(id = "joinyet")
    private WebElement username;

    @FindBy(id = "name")
    private List<WebElement> name;

    public ManFacilPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return username;
    }

    public List<WebElement> getName() {
        return name;
    }

    public <T> T choiseServicePoint(Class<T> resultPage, String siteName) throws Exception {
        List<WebElement> list = this.getName();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(siteName)) {
                WebElement site = list.get(i);
                Coordinates coor = ((Locatable) site).getCoordinates();
                coor.inViewPort();
                site.click();
                return PageFactory.initElements(driver, resultPage);
            }
        }
        return null;
    }

}
