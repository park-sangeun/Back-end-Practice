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
<<<<<<< HEAD
    public String deleteById(@PathVariable Long id, Model model) {
        memberService.deleteById(id); // 데이터베이스에서 회원 삭제
        List<MemberDTO> memberDTOList = memberService.findAll(); // 새로운 목록을 가져옴
        model.addAttribute("memberList", memberDTOList); // 새로운 목록을 모델에 추가
        return "list"; // 삭제가 완료된 목록을 보여주는 페이지(list.html)로 이동
=======
    public String deleteById(@PathVariable Long user_no) {
        memberService.deleteById(user_no);
        return "redirect:/member/";
>>>>>>> 1e3b62e62ca02bcf2c11a288f0544f5f73c9b295
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
<<<<<<< HEAD
=======

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

>>>>>>> 1e3b62e62ca02bcf2c11a288f0544f5f73c9b295
}
