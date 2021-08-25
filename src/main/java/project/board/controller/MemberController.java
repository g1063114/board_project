package project.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.board.dto.MemberForm;
import project.board.entity.Address;
import project.board.entity.Member;
import project.board.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createMember(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String enroll(@Valid MemberForm memberForm){
        Address address = new Address(memberForm.getCity(),memberForm.getStreet(),memberForm.getZipcode());

        Member member = new Member(memberForm.getName(), address);
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String memberList(Model model){
        List<Member> findMembers = memberService.findMembers();
        model.addAttribute("members",findMembers);
        return "members/memberList";
    }
}
