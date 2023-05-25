//package com.blue.bluearchive.member.service;
//
//import com.blue.bluearchive.member.entity.Member;
//import com.blue.bluearchive.member.repository.MemberRepository;
//import com.blue.bluearchive.member.dto.CustomUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("+=================================================================="+username+"===============================================");
//        Member member = memberRepository.findByEmail(username);
//
//        return new CustomUserDetails(
//                member.getId(),
//                member.getName(),
//                member.getEmail(),
//                member.getPassword(),
//                member.getAddress(),
//                member.getRole()
//        );
//    }
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User user = userRepository.findByUsername(username);
////
////        if (user == null) {
////            throw new UsernameNotFoundException("Could not find user");
////        }
////
////        // User의 추가적인 정보를 불러오는 로직 추가
////        String extraInfo = user.getExtraInfo();
////
////        return new CustomUserDetails(user, extraInfo);
////    }
//}
