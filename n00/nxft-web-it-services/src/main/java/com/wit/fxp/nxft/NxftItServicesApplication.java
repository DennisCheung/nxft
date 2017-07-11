package com.wit.fxp.nxft;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import com.wit.fxp.it.dbscript.DbScriptManager;
import com.wit.fxp.it.h2.H2Utils;
import com.wit.fxp.nxft.test.NxftSqlFiles;

@NxftWebRuntime
public class NxftItServicesApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(NxftItServicesApplication.class);

    @Autowired private DataSourceProperties dsp;

    /**
     * 尽早创建集成测试数据库表结构，不含数据。有些作业在Spring启动未完成时就开始执行，
     * 如果尚未创建数据库则显然这些作业会执行失败。
     *
     * <p>很难控制Spring Bean的创建顺序。实测结果是，放在这里的代码似乎比较早执行。
     */
    @PostConstruct
    void init() {
        String dbScriptFullPath = DbScriptManager.getDbScriptFullPath(getClass());
        String[] sqlFiles = DbScriptManager.getAllSqlFiles(dbScriptFullPath, NxftSqlFiles.SQL_FILE_NAMES);

        LOGGER.info("创建H2集成测试数据库：sql = {}, url = {}, username = {}, password = {}",
                Arrays.toString(sqlFiles), dsp.getUrl(), dsp.getUsername(), dsp.getPassword());

        H2Utils.createDatabase(sqlFiles, dsp.getUrl(), dsp.getUsername(), dsp.getPassword());
    }

}
