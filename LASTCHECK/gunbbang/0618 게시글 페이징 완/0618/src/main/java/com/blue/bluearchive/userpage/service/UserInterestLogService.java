package com.blue.bluearchive.userpage.service;

import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.admin.repository.CategoryRepository;
import com.blue.bluearchive.member.dto.CustomUserDetails;
import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.member.repository.MemberRepository;
import com.blue.bluearchive.userpage.dto.UserMainCategoryDto;
import com.blue.bluearchive.userpage.dto.UserMainLogDataDto;
import com.blue.bluearchive.userpage.entity.UserInterestCount;
import com.blue.bluearchive.userpage.entity.UserInterestCount;
import com.blue.bluearchive.userpage.entity.UserInterestLog;
import com.blue.bluearchive.userpage.repository.UserInterestCountRepository;
import com.blue.bluearchive.userpage.repository.UserInterestLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInterestLogService {
    private final UserInterestCountRepository userInterestCountRepository;
    private final UserInterestLogRepository userInterestLogRepository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;



    //해당하는 카테고리 유저 부분 조회수 증가 기록
    @Transactional(readOnly = false)
    public void categoryCount(Category category){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            try {
                // 인증된 사용자인지 확인하고, CustomUserDetails로 형변환하여 처리
                CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                String loginMemberIdx = Long.toString(userDetails.getIdx());
                Member member = memberRepository.findByIdx(userDetails.getIdx());
                UserInterestCount userInterestCount =
                        userInterestCountRepository.findByMemberAndCategory(member, category);
                userInterestCount.setCategoryAllCount(userInterestCount.getCategoryAllCount() + 1);
                // 여기에 로그인된 사용자에 대한 처리를 추가하세요.
            } catch (ClassCastException e) {
                // 예외 처리: 인증된 사용자의 principal이 CustomUserDetails 타입이 아닌 경우
                e.printStackTrace();
            } catch (NullPointerException e) {
                // 예외 처리: 인증되지 않은 사용자
                e.printStackTrace();
            }
        }

    }


    @Transactional(readOnly = false)
    public void newMemberCategoryLog(Member newMember){ //회원가입시 회원수만큼 엔티티 추가
        System.out.println("============카테고리 리스트 제작 부분 진입 ==================");
        List<Category> categories = categoryRepository.findAll();
// UserCategoryCount 생성 및 추가
        List<UserInterestCount> userInterestCounts = new ArrayList<>();
        for (Category category : categories) {
            UserInterestCount userInterestCount = new UserInterestCount();
            userInterestCount.setMember(newMember);
            userInterestCount.setCategory(category);
            userInterestCount.setCategoryPreCount(0);
            userInterestCount.setCategoryAllCount(0);
            userInterestCounts.add(userInterestCount);
        }
        newMember.setUserInterestCount(userInterestCounts); // Member와 UserCategoryCount 연관 설정
    }
    @Transactional(readOnly = false)
    public void newCategoryCategoryLog(Category newCategory){ //카테고리생성시 회원수만큼 엔티티 추가
        List<Member> members = memberRepository.findAll();
        List<UserInterestCount> userInterestCounts = new ArrayList<>();
        for (Member member : members) {
            UserInterestCount userInterestCount = new UserInterestCount();
            userInterestCount.setMember(member);
            userInterestCount.setCategory(newCategory);
            userInterestCount.setCategoryPreCount(0);
            userInterestCount.setCategoryAllCount(0);
            userInterestCounts.add(userInterestCount);
        }
        newCategory.setUserInterestCount(userInterestCounts); // Member와 UserCategoryCount 연관 설정
    }


    @Transactional(readOnly = false)
    public void logAllUserCategoryCount(){ //특정 시간이 되면 log날짜를 기록하는 서비스
        List<UserInterestCount> userInterestCounts = userInterestCountRepository.findAll();
        List<UserInterestLog> userInterestLogs = new ArrayList<>();

        for (UserInterestCount userInterestCount : userInterestCounts) {
            UserInterestLog userInterestLog = new UserInterestLog();
            userInterestLog.setMember(userInterestCount.getMember());
            userInterestLog.setCategory(userInterestCount.getCategory());

            int categoryCount = userInterestCount.getCategoryAllCount() - userInterestCount.getCategoryPreCount();
            userInterestLog.setCategoryCount(categoryCount);

            userInterestCount.setCategoryPreCount(userInterestCount.getCategoryAllCount());

            userInterestLogs.add(userInterestLog);
        }
        userInterestCountRepository.saveAll(userInterestCounts);
        userInterestLogRepository.saveAll(userInterestLogs);
    }


    @Transactional(readOnly = true)
    public List<UserMainCategoryDto> getCategoryLogData(long userIdx){
        Member member = memberRepository.findByIdx(userIdx);
        List<UserMainCategoryDto> allDataDto = new ArrayList<>();
        List<UserInterestLog> entityDataList = userInterestLogRepository.findByMember(member);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");

        for(UserInterestLog log : entityDataList){
            UserMainCategoryDto currentDto = null;
            for(UserMainCategoryDto dto : allDataDto) {
                if(dto.getCategoryName().equals(log.getCategory().getCategoryName())){
                    currentDto = dto;
                    break;
                }
            }

            if(currentDto == null) {
                currentDto = new UserMainCategoryDto();
                currentDto.setCategoryName(log.getCategory().getCategoryName());
                currentDto.setUserMainLogDataDtoList(new ArrayList<>());
                allDataDto.add(currentDto);
            }

            UserMainLogDataDto logDataDto = new UserMainLogDataDto();
            logDataDto.setCategoryCount(log.getCategoryCount());
            logDataDto.setLogTime(log.getLogTime().format(formatter));

            currentDto.getUserMainLogDataDtoList().add(logDataDto);
        }
        System.out.println("============================서비스부분==================================");
        System.out.println(allDataDto);

        return allDataDto;
    }










}
