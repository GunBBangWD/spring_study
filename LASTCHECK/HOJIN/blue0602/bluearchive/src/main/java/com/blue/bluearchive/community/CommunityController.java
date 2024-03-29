package com.blue.bluearchive.community;


import com.blue.bluearchive.member.dto.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comm")
public class CommunityController {


    @GetMapping("/boardMain")
    public String boardMain(){
        return "community/list";
    }

    @GetMapping("/writingBoard")
    public String write(){
        return "community/write";
    }
    @GetMapping("/boardView")
    public String view(){
        return "community/view";
    }
}
