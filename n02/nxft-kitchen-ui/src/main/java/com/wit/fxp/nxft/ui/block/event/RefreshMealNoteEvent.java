package com.wit.fxp.nxft.ui.block.event;

import java.util.Date;

import lombok.Value;

@Value
public class RefreshMealNoteEvent {

    private String userId;

    private String mealSchenoteId;

    private Date mealDate;

    private String mealTypeId;
}
