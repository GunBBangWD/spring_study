package com.blue.bluearchive.member.repository;

import com.blue.bluearchive.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long > {
    Member findByEmail(String email);
    Member findByIdx(Long idx);
    Member findByNameAndPhoneNum(String name, String phoneNum);
    Member findByPhoneNum(String phoneNum);
    Member findBynickName(String nickName);
}
