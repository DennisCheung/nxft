package com.wit.fxp.nxft.domain.model.order;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wit.fxp.it.dbscript.DbScriptManager;
import com.wit.fxp.it.h2.H2Utils;
import com.wit.fxp.nxft.domain.model.meal.AllMealDomainsTest;
import com.wit.fxp.nxft.test.NxftSqlFiles;

/**
 * 本集成测试通过对每一个实体对象执行一次查询，以检查实体对象与数据库表结构是否一致。
 *
 * @author Benewit Code Generator V1.0
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class AllOrderDomainsTest {

    /*
     * 以下请勿修改，下次生成后将被覆盖！！！
     * BEGIN>>>@$^*!#%&1
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-checkerunittest.template
     */

    @Autowired
    protected ApplicationContext nxft;

    @Autowired
    private com.wit.fxp.nxft.domain.model.order.checker.OrderCheckerRepo repo;

    // 配送单生成日志
    @Test
    public void testDeliveCreateLog() {
        this.repo.findDeliveCreateLog();
    }

    // 配送单明细
    @Test
    public void testDeliveDetail() {
        this.repo.findDeliveDetail();
    }

    // 配送单
    @Test
    public void testDeliveNote() {
        this.repo.findDeliveNote();
    }

    // 配餐订单
    @Test
    public void testNxftOrder() {
        this.repo.findNxftOrder();
    }

    /*
     * 以上请勿修改，下次生成后将被覆盖！！！
     * END<<<&%#!*^$@1
     */

    /**
     * 本集成测试的Spring配置类。
     *
     * @author Created by Benewit Code Generator V1.0
     *
     */
    @Configuration
    @Import(com.wit.fxp.nxft.domain.model.order.checker.HibernateOrderCheckerRepoImpl.class)
    @EnableTransactionManagement
    static class TestConfig {

        private static final String DB_USERNAME = "sa";
        private static final String DB_PASSWORD = "";
        private static final String DB_URL = "jdbc:h2:mem:nxft-order;MODE=Oracle;DB_CLOSE_DELAY=-1";

        @Autowired
        private ApplicationContext applicationContext;

        @Bean(destroyMethod = "close")
        public DataSource dataSource() throws SQLException {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName(org.h2.Driver.class.getName());
            ds.setUrl(DB_URL);
            ds.setUsername(DB_USERNAME);
            ds.setPassword(DB_PASSWORD);
            return ds;
        }

        @Bean(name = "nxft.hibernateSessionFactory")
        public SessionFactory sessionFactory() throws Exception {
            LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());

            String[] locations = {"classpath*:/com/wit/**/domain/**/*.hbm.xml"};
            for (String location : locations) {
                Resource[] mappingResources = this.applicationContext.getResources(location);
                for (Resource resource : mappingResources) {
                    builder.addInputStream(resource.getInputStream());
                }
            }

            builder.setProperty("hibernate.dialect", org.hibernate.dialect.H2Dialect.class.getName());
            builder.setProperty("hibernate.default_batch_fetch_size", "64");

            return builder.buildSessionFactory();
        }

        @Bean
        public HibernateTransactionManager transactionManager() throws Exception {
            HibernateTransactionManager txManager = new HibernateTransactionManager();
            txManager.setSessionFactory(sessionFactory());
            return txManager;
        }

        /**
         * 创建集成测试数据库表结构，不含数据。
         */
        @PostConstruct
        void init() {
            String dbScriptFullPath = DbScriptManager.getDbScriptFullPath(AllMealDomainsTest.class);
            String[] sqlFiles = DbScriptManager.getAllSqlFiles(dbScriptFullPath, NxftSqlFiles.SQL_FILE_NAMES);
            H2Utils.createDatabase(sqlFiles, DB_URL, DB_USERNAME, DB_PASSWORD);
        }

    }   // TestConfig

}
