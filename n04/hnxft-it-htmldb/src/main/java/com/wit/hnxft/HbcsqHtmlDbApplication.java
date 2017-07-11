package com.wit.hnxft;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import com.wit.fxp.it.dbscript.DbScriptManager;
import com.wit.fxp.it.h2.H2Utils;
import com.wit.hnxft.dbscript.DbScripts;
import com.wit.hnxft.runtime.EnableHnxftRuntime;

@EnableHnxftRuntime
public class HbcsqHtmlDbApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HbcsqHtmlDbApplication.class);

    private static final String[] SQL_FILE_NAMES = new String[] {
            DbScripts.FXP_SQL,
            DbScripts.HBCS_SQL,
            DbScripts.TEH_SQL
    };

    /**
     * 尽早创建集成测试数据库表结构，不含数据。有些作业在Spring启动未完成时就开始执行，
     * 如果尚未创建数据库则显然这些作业会执行失败。
     *
     * <p>很难控制Spring Bean的创建顺序。实测结果是，放在这里的代码似乎比较早执行。
     */
    @Autowired
    void createH2Database(DataSourceProperties dsp) {
        String dbScriptFullPath = DbScriptManager.getDbScriptFullPath(getClass());
        String[] sqlFiles = DbScriptManager.getAllSqlFiles(dbScriptFullPath, SQL_FILE_NAMES);

        LOGGER.info("创建H2集成测试数据库：sql = {}, url = {}, username = {}, password = {}",
                Arrays.toString(sqlFiles), dsp.getUrl(), dsp.getUsername(), dsp.getPassword());

        H2Utils.createDatabase(sqlFiles, dsp.getUrl(), dsp.getUsername(), dsp.getPassword());
    }

    public static void main(String[] args) throws Exception {
        LOGGER.info("启动hbcs企业号客户端-集成测试模式。");
        SpringApplication.run(HbcsqHtmlDbApplication.class, args);
    }

}
