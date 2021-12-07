package com.example.project1.rest.member;

import com.example.project1.bean.Member;
import com.example.project1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member/member")
public class MemberMemberRest {
    @Autowired
    private MemberService memberService;

    @GetMapping("/id/{id}")
    public Member findMemberById(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    @GetMapping("/numeroEtudiant/{numeroEtudiant}")
    public Member findBynumeroEtudiant(@PathVariable String numeroEtudiant) {
        return memberService.findBynumeroEtudiant(numeroEtudiant);
    }

    @DeleteMapping("/delete-Multiple")
    public int deleteListMemberById(@RequestBody List<Member> member) {
        return memberService.deleteListMemberById(member);
    }

    @DeleteMapping("/id/{id}")
    public int deleteMemberById(@PathVariable Long id) {
        return memberService.deleteMemberById(id);
    }
    @GetMapping("/")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Member member) {
        return memberService.save(member);
    }
    @GetMapping("/login/{login}/password/{password}")
    public Object findByCritere(@PathVariable String login,@PathVariable String password) {
        return memberService.findByCritere(login, password);
    }


    @PutMapping("/")
    public Member update(@RequestBody Member member) {
        return memberService.update(member);
    }
}
