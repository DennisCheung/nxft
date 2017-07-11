package com.wit.fxp.nxft.paging;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagingInfo {
    private Integer startIndex = 0;
    private Integer endIndex = 2;
    private Integer pageSize = 2;
    private Integer totalRecord = 0;
    private Integer currPage = 1;
    private Integer totalPage = 1;
    private boolean isNeedResetTotalNum = false;

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
        this.currPage = this.startIndex / this.pageSize + 1;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
        this.totalPage = (this.totalRecord - 1) / this.pageSize + 1;
    }
}
