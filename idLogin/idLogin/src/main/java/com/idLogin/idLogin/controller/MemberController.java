package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.dto.MemberDTO;
import com.idLogin.idLogin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/member/signup")
    public String signUpForm(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "signup";
    }

    @PostMapping("/member/signup")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "redirect:/member/login";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        String loginResult = memberService.login(memberDTO);
        if ("success".equals(loginResult)) {
            session.setAttribute("loginId", memberDTO.getUserId());
            // login 성공
            return "redirect:/main";
        } else {
            // login 실패
            return "login";
        }
    }

    @GetMapping("/main")
    public String mainForm() {
        return "main";
    }

    @GetMapping("/admin/list")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        // 어떠한 html로 가져갈 데이터가 있다면 model사용
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    @GetMapping("/member/{id}")
    public String findById(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model) {
        String myId = (String) session.getAttribute("loginId");
        MemberDTO memberDTO = memberService.updateForm(myId);
        model.addAttribute("updateUser", memberDTO);
        return "update";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getUser_no();
    }

    @GetMapping("/member/delete/{id}")
    public String deleteById(@PathVariable Long user_no) {
        memberService.deleteById(user_no);
        return "redirect:/member/";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @PostMapping("/member/id-check")
    public @ResponseBody String IdCheck(@RequestParam("user_id") String userId) {
        System.out.println("userId = " + userId);
        String checkResult = memberService.IdCheck(userId);
        return checkResult;
//        if (checkResult != null) {
//            return "ok";
//        } else {
//            return "no";
//        }
    }

}
