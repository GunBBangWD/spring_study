package com.blue.bluearchive.member.controller;

import com.blue.bluearchive.member.dto.MemberFormDto;
import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.member.repository.MemberRepository;
import com.blue.bluearchive.member.service.MailService;
import com.blue.bluearchive.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
    private final MemberRepository memberRepository;

    @GetMapping(value = "/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }
    @ResponseBody
    @PostMapping("/validate-email")
    public Map<String, Object> validateEmail(@RequestParam("email") String email) {
        boolean isDuplicate = memberRepository.findByEmail(email) != null;
        Map<String, Object> result = new HashMap<>();
        result.put("isDuplicate", isDuplicate);
        return result;
    }
    @ResponseBody
    @PostMapping("/validate-phone-num")
    public Map<String, Object> validatePhoneNum(@RequestParam("phoneNum") String phoneNum) {
        boolean isDuplicate = memberService.findByPhoneNum(phoneNum) != null;
        Map<String, Object> result = new HashMap<>();
        result.put("isDuplicate", isDuplicate);
        return result;
    }

    @GetMapping("/find-email")
    public String showFindEmailForm() {
        return "member/findEmailForm";
    }

    @PostMapping("/find-email")
    public String findEmail(@RequestParam("name") String name,
                            @RequestParam("phone") String phoneNum,
                            Model model) {
        String email = memberService.findEmailByNamePhone(name, phoneNum);

        if (email != null) {
            model.addAttribute("email", email);
            return "member/displayEmail";
        } else {
            model.addAttribute("error", "일치하는 이메일을 찾을 수 없습니다.");
            return "member/findEmailForm";
        }
    }

    @GetMapping("/find-password")
    public String showFindPasswordForm() {

        return "member/findPasswordForm";
    }

    @PostMapping("/find-password")
    public String sendVerificationCode(
            @RequestParam("email") String email, Model model) {
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            model.addAttribute("error", "존재하지 않는 회원입니다.");
            return "member/findPasswordForm";
        }
        int randomCode = new Random().nextInt(900000) + 100000;
        String verificationCode = String.valueOf(randomCode);
        mailService.sendMail1(email, verificationCode);

        model.addAttribute("email", email);
        model.addAttribute("verificationCode", verificationCode);
        return "member/enterVerificationCode";
    }

    @PostMapping("/verify-code")
    public String verifyCode(
            @RequestParam("email") String email,
            @RequestParam("userInputCode") String userInputCode,
            @RequestParam("verificationCode") String verificationCode,
            Model model) {
        if (!userInputCode.equals(verificationCode)) {
            model.addAttribute("error", "인증 코드가 올바르지 않습니다.");
            model.addAttribute("email", email);
            model.addAttribute("verificationCode", verificationCode);
            return "member/enterVerificationCode";
        }

        model.addAttribute("email", email);
        return "member/updatePasswordForm";
    }

    @PostMapping("/update-password")
    public String updatePassword(
            @RequestParam("email") String email,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("confirmPassword") String confirmPassword,
            Model model) {
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            model.addAttribute("email", email);
            return "member/updatePasswordForm";
        }

        try {
            Member member = memberService.updatePassword(email, passwordEncoder.encode(newPassword));
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("email", email);
            return "member/updatePasswordForm";
        }

        return "redirect:/member/login";
    }

    @ResponseBody
    @PostMapping("/mail")
    public Map<String, Object> MailSend(String mail) {
        Map<String, Object> response = new HashMap<>();
        try {
            int number = mailService.sendMail(mail);
            response.put("success", true);
            response.put("code", number);
        } catch (Exception e) {
            response.put("false", false);
        }
        return response;
    }

    @PostMapping(value = "/new")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "member/memberForm";
        }
        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        }catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberForm";
        }
        return "redirect:/";
    }
    @ResponseBody
    @PostMapping("/validate-nickName")
    public Map<String, Object> validatenickName(@RequestParam("nickName") String nickName) {
        boolean isDuplicate = memberRepository.findBynickName(nickName) != null;
        Map<String, Object> result = new HashMap<>();
        result.put("isDuplicate", isDuplicate);
        return result;
    }

    @GetMapping(value = "/login")
    public String loginMember() {
        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/login/error")
    public String LoginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "/member/memberLoginForm";
    }
}