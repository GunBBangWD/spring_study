package com.blue.bluearchive.member.dto;

import com.blue.bluearchive.constant.Grade;
import com.blue.bluearchive.constant.MemberStat;
import com.blue.bluearchive.constant.Role;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Builder
public class CustomUserDetails implements UserDetails {
    private final String id;
    private final String name;
    private final String nickName;
    private final String email;
    private final String password;
    private final String address;
    private final String phoneNum;
    private final Role role;
    private final Grade grade;
    private final MemberStat memberStat;
    private final String createdBy;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        authorities.add(new SimpleGrantedAuthority("GRADE_" + grade.name()));
        authorities.add(new SimpleGrantedAuthority("STAT_" + memberStat.name()));
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return name;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
