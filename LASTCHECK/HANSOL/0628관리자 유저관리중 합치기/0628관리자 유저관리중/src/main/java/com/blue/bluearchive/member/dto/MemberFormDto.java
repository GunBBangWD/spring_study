package com.blue.bluearchive.member.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class MemberFormDto {

    private String name;

    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    private String id;

    private String password;

    private String postcode;

    private String address;

    private String extraAddress;

    private String detailAddress;

    private String phoneNum;

    private String nickName;

    public String getAddress() {
        return postcode + " " +address + " " + extraAddress + " " + detailAddress;
    }
}

