package com.cw.entity;

import com.cw.standdata.StandData;
import lombok.Data;

@Data
public class ResponseVO {

    @StandData("code")
    private String code;

}
