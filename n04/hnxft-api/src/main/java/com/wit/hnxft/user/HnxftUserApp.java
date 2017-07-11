package com.wit.hnxft.user;

/**
 * 助餐点工作站操作员接口
 * @author lyb
 *
 */
public interface HnxftUserApp {

    /**
     * 验证操作员
     * @param userId
     * @param password
     * @return
     */
    boolean verificationUser(String userId, String password);
}
