package com.blue.bluearchive.userpage.repository;

import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.userpage.entity.UserInterestLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInterestLogRepository extends JpaRepository<UserInterestLog,Integer> {
    List<UserInterestLog> findByMember(Member member);

}
