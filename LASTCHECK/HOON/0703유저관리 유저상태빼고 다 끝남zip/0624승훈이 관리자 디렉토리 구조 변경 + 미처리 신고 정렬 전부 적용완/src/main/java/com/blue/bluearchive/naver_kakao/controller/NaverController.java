package com.blue.bluearchive.naver_kakao.controller;


import com.blue.bluearchive.member.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;

import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class NaverController {
    public String getUserIdx(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) principal;
        String  userIdx=Long.toString(userDetails.getIdx());
        return userIdx;
    }


    @GetMapping("/test/naver/search")
    public String naverSearchAPI() {
        String NAVER_API_URL = "https://openapi.naver.com/v1/search/blog?query=";
        String CLIENT_ID = "afNikLLqpUy1dnsZZ2KJ";
        String CLIENT_SECRET = "bJiUQKNBri";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", CLIENT_ID);
        headers.add("X-Naver-Client-Secret", CLIENT_SECRET);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(NAVER_API_URL + "어깨 루틴", HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("=====================");
            System.out.println(response.getBody());
            return "redirect:/";
        } else {
            System.out.println("실패");
            return "redirect:/";
        }
    }

    @GetMapping("/test/crawling")
    public String testCrawling() {
        try {
            String url = "https://search.naver.com/search.naver?where=blog&query=%EC%96%B4%EA%B9%A8%EB%A3%A8%ED%8B%B4&sm=tab_opt&nso=so%3Ar%2Cp%3A1w";
            Document doc = Jsoup.connect(url).get();
            Elements blogEntries = doc.select("div.total_wrap.api_ani_send");
            for (Element blogEntry : blogEntries) {
                String title = blogEntry.select("a.api_txt_lines.total_tit").text();
                String link = blogEntry.select("a.api_txt_lines.total_tit").attr("href");

                System.out.println("Title: " + title);
                System.out.println("Link: " + link);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }





}
