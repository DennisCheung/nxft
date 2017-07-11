package com.wit.fxp.nxft.personpage.section;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@NoArgsConstructor
@AllArgsConstructor
@BuilderCall
public class PersonPageRightPartEvent {
    /**
     * 客户id
     */
    private String subjectId;

    /**
     * 客户主页右边业务页面
     */
    private PersonWorkPresenter personWorkPresenter;

    /**
     *  客户主页右边业务页面需要的参数
     */
    private Object params;

    /**
     * 客户主页标签页标题
     */
    private String viewTitle;

    private String key;
}
