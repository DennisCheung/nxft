package com.wit.hnxft;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wit.fxp.it.dbscript.DbScriptManager;
import com.wit.fxp.it.h2.H2Utils;
import com.wit.fxp.nxft.test.NxftSqlFiles;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=prod,test")
public class HnxftApplicationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HnxftApplicationTest.class);

    @Test
    public void test() {
    }

    @TestConfiguration
    static class MyConfiguration {

        @Autowired
        void setUpDatabase(DataSourceProperties dsp) {
            if (dsp.getPassword() != null && !"".equals(dsp.getPassword())) {
                throw new IllegalStateException("为安全起见仅当数据库密码为空时才重建数据库！");
            }

            String dbScriptFullPath = DbScriptManager.getDbScriptFullPath(getClass());
            String[] sqlFiles = DbScriptManager.getAllSqlFiles(dbScriptFullPath, NxftSqlFiles.SQL_FILE_NAMES);

            LOGGER.info("创建H2集成测试数据库：sql = {}, url = {}, username = {}, password = {}",
                    Arrays.toString(sqlFiles), dsp.getUrl(), dsp.getUsername(), dsp.getPassword());

            H2Utils.createDatabase(sqlFiles, dsp.getUrl(), dsp.getUsername(), dsp.getPassword());
        }

    }

}
