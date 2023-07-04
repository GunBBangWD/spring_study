package com.blue.bluearchive.admin.dto;

import com.blue.bluearchive.constant.MemberStat;
import lombok.Data;

//건희 추가
@Data
public class AdminUserDto {
    private Long idx;
    private String id;
    private String name;
    private String nickName;
    private String email;
    private MemberStat memberStat;


}
