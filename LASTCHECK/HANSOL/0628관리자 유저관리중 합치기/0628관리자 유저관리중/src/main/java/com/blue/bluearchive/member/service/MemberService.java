package com.blue.bluearchive.member.service;

import com.blue.bluearchive.member.dto.CustomUserDetails;
import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.member.repository.MemberRepository;
import com.blue.bluearchive.userpage.service.UserCategoryLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final UserCategoryLogService userCategoryLogService;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        Member newMember = memberRepository.save(member);
        System.out.println("============회원가입 진입 ==================");
        userCategoryLogService.newMemberCategoryLog(newMember);
        return newMember;
    }

    private void validateDuplicateMember(Member member) {
        Member fundMember = memberRepository.findByEmail(member.getEmail());
        if(fundMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        if(member == null) {
            throw new UsernameNotFoundException(email);
        }
        return CustomUserDetails.builder()
                .idx(member.getIdx())
                .id(member.getId())
                .name(member.getName())
                .password(member.getPassword())
                .nickName(member.getNickName())
                .email(member.getEmail())
                .address(member.getAddress())
                .phoneNum(member.getPhoneNum())
                .role(member.getRole())
                .grade(member.getGrade())
                .memberStat(member.getMemberStat())
                .createdBy(member.getCreatedBy())
                .build();
    }
    public String findEmailByNamePhone(String name,String phoneNum) {
        // 이름,휴대폰 번호를 사용하여 이메일을 찾는 로직을 작성합니다.
        Member member = memberRepository.findByNameAndPhoneNum(name,phoneNum);
        if (member != null) {
            return member.getEmail();
        } else {
            return null;
        }
    }
    @Transactional
    public Member updatePassword(String email, String encodedPassword) {
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }
        member.setPassword(encodedPassword);
        return member;
    }
    public Member findByPhoneNum(String phoneNum) {
        return memberRepository.findByPhoneNum(phoneNum);
    }
}

