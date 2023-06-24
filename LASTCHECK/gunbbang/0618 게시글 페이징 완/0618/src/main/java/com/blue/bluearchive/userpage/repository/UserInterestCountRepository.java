package com.blue.bluearchive.userpage.repository;

import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.userpage.entity.UserInterestCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestCountRepository extends JpaRepository<UserInterestCount,Integer> {
    UserInterestCount findByMemberAndCategory(Member member, Category category);
}
