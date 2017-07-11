package com.wit.hnxft.runtime.fxp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.benewit.core.env.CurrentDate;
import com.benewit.core.env.IdGenerator;
import com.benewit.core.env.RuntimeContext;
import com.benewit.orm.service.EntityDaoService;
import com.benewit.orm.service.EntityDaoServiceImpl;
import com.wit.annotations.Fxp;
import com.wit.fxp.domain.id.FxpIdGenerator;
import com.wit.fxp.domain.service.BillNumberService;

@Configuration
public class FxpConfiguration {

    @Autowired
    @Fxp
    SessionFactory sessionFactory;

    @Autowired
    BillNumberService bnService;

    @Bean
    public EntityDaoService entityDaoService() {
        return new EntityDaoServiceImpl(sessionFactory);
    }

    @Bean
    public RuntimeContext runtimeContext() {
        return new RuntimeContext(new CurrentDate(), idGenerator());
    }

    @Bean
    public IdGenerator idGenerator() {
        return new FxpIdGenerator(sessionFactory, bnService);
    }

}
