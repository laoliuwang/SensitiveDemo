package com.cw.entity;

import com.cw.sensitive.SensitiveInfo;
import com.cw.sensitive.SensitiveType;
import com.cw.standdata.StandData;
import lombok.Data;

@Data
public class UserInfo {
    private String userId;
    private String sex;


    @SensitiveInfo(SensitiveType.ID_CARD)
    @StandData("code")
    private String idCard;

    private int age;

    private String mobile;
    private String nativePlace;

    public static UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(23);
        userInfo.setIdCard("130428101111111192");
        userInfo.setUserId("1234567890");
        userInfo.setMobile("18302974301");
        return userInfo;
    }

}
