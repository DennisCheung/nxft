package com.wit.hbcs.qic.it.htmldb.base;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.wit.fxp.it.dbscript.DbScriptManager;
import com.wit.fxp.it.h2.H2Utils;
import com.wit.fxp.it.springtestdbunit.SpringtestdbunitConfiguration;
import com.wit.hnxft.dbscript.DbScripts;

@RunWith(SpringRunner.class)
@TestExecutionListeners(
        listeners = {DbUnitTestExecutionListener.class},
        mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@DbUnitConfiguration(
        databaseConnection = {SpringtestdbunitConfiguration.H2CONNECTION_BEANNAME},
        dataSetLoaderBean = SpringtestdbunitConfiguration.DATA_SET_LOADER_BEANNAME)
@DatabaseSetup({DbScripts.FXP_XML, DbScripts.HBCS_XML, DbScripts.TEH_XML})
@DatabaseSetup({"000/init.xml"})
public abstract class AbstractHbcsqHtmlDbTest {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired private DataSourceProperties dsp;
    @Autowired protected Environment env;

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        String dbScriptFullPath = DbScriptManager.getDbScriptFullPath(getClass());
        H2Utils.executeSqlFile(dsp.getUrl(),  dsp.getUsername(), dsp.getPassword(), dbScriptFullPath + "testcase/000/init.sql");

        setServerPort();
        createDriverIfNot();
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected void createDriverIfNot() throws Exception {
        if (driver == null) {
            // 设置驱动器
            String port = env.getProperty("test.server.port");  // 参见pom.xml
            if (port != null) {
                driver = createHtmlUnitDriver();
            }
            else {
                String driverName = env.getProperty("it.driverName", "chrome");
                switch (driverName) {
                case "htmlunit":
                    driver = createHtmlUnitDriver();
                    break;
                case "firefox":
                    driver = createFirefoxDriver();
                    break;
                case "chrome":
                    driver = createChromeDriver();
                    break;
                default:
                    throw new RuntimeException("未知的驱动器名称：" + driverName);
                }
            }

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    /**
     * 模拟企业号用户。
     *
     * @throws UnsupportedEncodingException
     */
    protected void mockUser(String userId) throws UnsupportedEncodingException {
        String redirectUri = URLEncoder.encode("/ping", "utf-8");
        String path = new StringBuilder("/qic/auth")
                .append("?type=USER_ID")
                .append("&token=AUTH-TOKEN-").append(userId)
                .append("&redirectUri=").append(redirectUri)
                .toString();

        String menuUrl = ServerUtils.getServerUri(path);
        driver.get(menuUrl);
    }

    /**
     * 模拟访客。
     *
     * @throws UnsupportedEncodingException
     */
    protected void mockGuest(String openId) throws UnsupportedEncodingException {
        String redirectUri = URLEncoder.encode("/ping", "utf-8");
        String path = new StringBuilder("/qic/auth")
                .append("?type=OPEN_ID")
                .append("&token=AUTH-TOKEN-").append(openId)
                .append("&redirectUri=").append(redirectUri)
                .toString();

        String menuUrl = ServerUtils.getServerUri(path);
        driver.get(menuUrl);

        String pong = driver.findElement(By.tagName("body")).getText();
        if (!"pong".equals(pong)) {
            String errorText = "访问不到测试服务器，是否尚未启动？";
            LOGGER.error(errorText);
            throw new IllegalStateException(errorText);
        }
    }

    /**
     * 设置服务器端口号，需针对内嵌和分离测试模式分别设置。
     */
    protected abstract void setServerPort();

    private HtmlUnitDriver createHtmlUnitDriver() {
        HtmlUnitDriver d = new HtmlUnitDriver(BrowserVersion.CHROME);
        d.setJavascriptEnabled(true);
        return d;
    }

    private MarionetteDriver createFirefoxDriver() throws Exception {
        DesiredCapabilities dc = null;

        File xpi = new File("d:\\jt\\webdriver\\webdriver_element_locator-2.0-fx.xpi");
        if (!xpi.exists()) {
            LOGGER.warn("Firefox组件文件不存在：{}", xpi.getAbsoluteFile());
        }
        else {
            FirefoxProfile profile = new FirefoxProfile();
            profile.addExtension(xpi);

            dc = DesiredCapabilities.firefox();
            dc.setCapability(FirefoxDriver.PROFILE, profile);
        }

        System.setProperty("webdriver.gecko.driver", "d:\\jt\\webdriver\\geckodriver.exe");
        MarionetteDriver d = new MarionetteDriver(dc);

        // 设置到左上角
        d.manage().window().setPosition(new Point(0, 0));
        d.manage().window().setSize(new Dimension(400, 711));

        return d;
    }

    private ChromeDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "d:\\jt\\webdriver\\chromedriver.exe");
        ChromeDriver d = new ChromeDriver();

        // 设置到左上角
        d.manage().window().setPosition(new Point(0, 0));
        d.manage().window().setSize(new Dimension(400, 711));

        return d;
    }

}
