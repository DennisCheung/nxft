package com.wit.hnxft.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 当前用户服务。
 *
 * @author yw
 *
 */
@Service
public class CurrentUser {

    public String getUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
