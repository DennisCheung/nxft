package com.wit.fxp.nxft.ui.usermain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class TeamViewModel {
    private String name;
    private String circleId;
    private String teamId;
}
