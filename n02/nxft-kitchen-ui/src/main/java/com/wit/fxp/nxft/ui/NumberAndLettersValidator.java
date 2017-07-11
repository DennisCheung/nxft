package com.wit.fxp.nxft.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.data.Validator;

/**
 * 只允许输入数字和字母
 * @author wck
 *
 */
public class NumberAndLettersValidator implements Validator {
    private static final long serialVersionUID = 1L;

    private String errMessage;

    public NumberAndLettersValidator() {
        super();
        errMessage = "输入格式错误，必须为字母或数字";
    }

    public NumberAndLettersValidator(String errMessage) {
        super();
        this.errMessage = errMessage;
    }

    @Override
    public void validate(Object value) throws InvalidValueException {
        if (value == null || "".equals(value.toString())) {
            return;
        }
        Pattern compile = Pattern.compile("^[A-Z[a-z[0-9]]]+$");
        Matcher matcher = compile.matcher((String) value);
        if (!matcher.find()) {
            throw new InvalidValueException(errMessage);
        }
    }
}
