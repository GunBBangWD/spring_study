package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ListController {
    private final MemberService memberService;

    @Autowired
    public ListController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public String listview(Model model) {
       /* List<Bord> bords = bordService.findBords();
        model.addAttribute("bords", bords);*/
        return "list";
    }
    @GetMapping("/view")
    public String view() {
        return "view";
    }
    @GetMapping("/edit")
    public String editview() {
        return "edit";
    }
    @GetMapping("/write")
    public String writeview() {
        return "write";
    }
}
