package com.blue.bluearchive.shop_inquiry.service;

import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.member.repository.MemberRepository;
import com.blue.bluearchive.shop.entity.Item;
import com.blue.bluearchive.shop.repository.ItemRepository;
import com.blue.bluearchive.shop_inquiry.dto.InquiryDto;
import com.blue.bluearchive.shop_inquiry.entity.Inquiry;
import com.blue.bluearchive.shop_inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryService {

    @Autowired
    private final InquiryRepository inquiryRepository;

    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final MemberRepository memberRepository;



    @Transactional(readOnly = true)
    public List<Inquiry> getInquiryListByItemId(Long itemId) {
        List<Inquiry> inquiryList = new ArrayList<>();
        List<InquiryDto> inquiryDtoList = inquiryRepository.findByItemId(itemId);

        for (InquiryDto inquiryDto : inquiryDtoList) {
            Inquiry inquiry = new Inquiry();
            inquiry.setId(inquiryDto.getId());
            inquiry.setContent(inquiryDto.getContent());

            Member member = memberRepository.findByEmail(inquiryDto.getCreatedBy());
            inquiry.setCreatedBy(member.getName());
            inquiry.setRegTime(inquiryDto.getRegTime());
            Item item = itemRepository.findById(inquiryDto.getItemId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            inquiry.setItem(item);
            inquiryList.add(inquiry);
        }

        return inquiryList;
    }


    @Transactional(readOnly = false)
    public void inquiryWrite(Long itemId, String email, String content) {
        // Item 조회
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 아이템 ID입니다."));

        // Member 조회
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            throw new IllegalArgumentException("유효하지 않은 회원 이메일입니다.");
        }

        // Inquiry 생성 및 저장
        Inquiry inquiry = new Inquiry();
        inquiry.setItem(item);
        inquiry.setCreatedBy(member.getEmail());
        if (content != null) {
            inquiry.setContent(content);
        } else {
            throw new IllegalArgumentException("문의 내용을 입력해주세요.");
        }


        inquiryRepository.save(inquiry);
    }


    @Transactional(readOnly = false)
    public void inquiryDelete(Long id) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 문의 ID입니다."));
        inquiryRepository.delete(inquiry);
    }

}
