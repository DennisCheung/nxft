package com.wit.fxp.nxft.it;

import org.springframework.test.context.jdbc.Sql;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.wit.fxp.it.AbstractFxpVaadinServiceTest;

/**
 * 集成测试基类。
 *
 * @author yw
 *
 */
@DatabaseSetup({"../fxp/h2script/h2fxp-表数据.xml", "../h2script/h2nxft-表数据.xml"})
@DatabaseSetup({"000/init.xml"})
@Sql("file:dbscript:testcase/000/init.sql")
public abstract class AbstractDBUnitTest extends AbstractFxpVaadinServiceTest {

}
