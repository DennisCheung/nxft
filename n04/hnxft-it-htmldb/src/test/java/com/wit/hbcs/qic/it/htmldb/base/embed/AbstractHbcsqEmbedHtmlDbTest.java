package com.wit.hbcs.qic.it.htmldb.base.embed;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

import com.wit.fxp.it.base.htmldb.FxpHtmlDbTestConfiguration;
import com.wit.hbcs.qic.it.htmldb.base.AbstractHbcsqHtmlDbTest;
import com.wit.hbcs.qic.it.htmldb.base.ServerUtils;

/**
 * 内嵌测试模式，即测试时内嵌启动服务器，其特点是允许模拟测试。
 *
 * @author yw
 *
 */
@SpringBootTest(classes = AbstractHbcsqEmbedHtmlDbTest.MyConfiguration.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AbstractHbcsqEmbedHtmlDbTest extends AbstractHbcsqHtmlDbTest {

    @LocalServerPort
    private int serverPort;

    /**
     * 设置内嵌测试模式时的服务器随机端口号。
     */
    @Override
    protected void setServerPort() {
        ServerUtils.setServerPort(serverPort);
    }

    @TestConfiguration
    @Import(FxpHtmlDbTestConfiguration.class)
    static class MyConfiguration {

    }

}
