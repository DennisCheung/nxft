package com.wit.hnxft.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class HnxftSchenoteModel {
    private List<WeekTime> weekTimes;

    private MealTypeModel breakfast;

    private MealTypeModel lunch;

    private MealTypeModel dinner;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class MealTypeModel {
        private List<String> mon;
        private List<String> tues;
        private List<String> wed;
        private List<String> thur;
        private List<String> fri;
        private List<String> sat;
        private List<String> sun;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class WeekTime {
        private Date date;

        private String weekName;

        private Integer week;
    }
}
