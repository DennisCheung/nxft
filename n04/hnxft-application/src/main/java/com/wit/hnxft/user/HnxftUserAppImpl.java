package com.wit.hnxft.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wit.fxp.domain.service.user.UserService;

@Transactional
@Component
public class HnxftUserAppImpl implements HnxftUserApp {

    @Autowired private UserService userService;

    @Override
    public boolean verificationUser(String userId, String password) {
        return this.userService.verificationUser(userId, password);
    }

}
