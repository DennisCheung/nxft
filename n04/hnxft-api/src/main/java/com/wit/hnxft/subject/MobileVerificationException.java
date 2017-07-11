package com.wit.hnxft.subject;

/**
 * 手机号码验证异常
 * @author lyb
 *
 */
public class MobileVerificationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MobileVerificationException(String str) {
        super(str);
    }
}
