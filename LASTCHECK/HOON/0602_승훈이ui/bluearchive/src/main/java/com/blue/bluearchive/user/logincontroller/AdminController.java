package com.blue.bluearchive.user.logincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/main")
    public String adminMain(){
        return "adminPage/manageMain";
    }
    @GetMapping("/userMgt")
    public String userMgt(){
        return "adminPage/manageUser";
    }
    @GetMapping("/commMgt")
    public String commMgt(){
        return "adminPage/manageCommunity";
    }
    @GetMapping("/shopMgt")
    public String shopMgt(){
        return "adminPage/manageShop";
    }
    @GetMapping("/sellUserMgt")
    public String sellUserMgt(){
        return "/adminPage/manageUserSell";
    }
    @GetMapping("/cateMgt")
    public String cateMgt(){
        return "/adminPage/manageCommunity";
    }
    @GetMapping("/boardMgt")
    public String boardMgt(){
        return "/adminPage/manageCommunity_board";
    }
    @GetMapping("/commentMgt")
    public String commentMgt(){
        return "/adminPage/manageCommunity_comment";
    }
}
