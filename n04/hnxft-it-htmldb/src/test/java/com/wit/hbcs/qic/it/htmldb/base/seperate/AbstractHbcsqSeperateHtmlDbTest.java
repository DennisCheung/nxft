package com.wit.hbcs.qic.it.htmldb.base.seperate;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.wit.hbcs.qic.it.htmldb.base.AbstractHbcsqHtmlDbTest;
import com.wit.hbcs.qic.it.htmldb.base.ServerUtils;

/**
 * 分离测试模式，即先手工启动服务器然后运行测试，其特点是测试速度快，但不能进行模拟测试。
 *
 * @author yw
 *
 */
@SpringBootTest(classes = HbcsqHtmlDbTestConfiguration.class, webEnvironment = WebEnvironment.NONE)
public abstract class AbstractHbcsqSeperateHtmlDbTest extends AbstractHbcsqHtmlDbTest {

    /**
     * 设置分离测试模式时的服务器端口号，分两种情况：
     * <ul>
     * <li>在maven中执行时从pom中取随机端口号。</li>
     * <li>在eclipse里执行时端口号为在服务器属性文件中定义的静态值。
     * 这里返回{@code 8080}，若修改了属性文件则需返回新端口号。</li>
     * </ul>
     */
    @Override
    protected void setServerPort() {
        String port = env.getProperty("test.server.port");  // 参见pom.xml
        if (port == null) {
            port = "8080";
        }
        ServerUtils.setServerPort(Integer.valueOf(port));
    }

}
