package com.wit.fxp.nxft.ui.toolbar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SiteViewModel {

    private String name;
    private String orgId;
    private String deptId;
}
