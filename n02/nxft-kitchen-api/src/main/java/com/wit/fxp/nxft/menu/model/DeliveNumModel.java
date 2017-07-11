package com.wit.fxp.nxft.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class DeliveNumModel {
    private DeliveDetailNumModel today;

    private DeliveDetailNumModel week;

    private DeliveDetailNumModel month;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class DeliveDetailNumModel {
        private Integer breakfastNum;

        private Integer lunchNum;

        private Integer dinnerNum;
    }
}
