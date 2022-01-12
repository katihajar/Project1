package com.example.project1.rest.jury;

import com.example.project1.bean.Member;
import com.example.project1.exception.NotAnImageFileException;
import com.example.project1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.example.project1.filter.JwtConstant.FORWARD_SLASH;
import static com.example.project1.filter.JwtConstant.USER_FOLDER;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@RestController
@RequestMapping("/jury/member")
public class MemberJuryRest {
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
    @PostMapping("/updateProfileImage")
    public ResponseEntity<Member> updateProfileImage(@RequestParam("username") String username, @RequestParam(value = "profileImage") MultipartFile profileImage)
            throws IOException, NotAnImageFileException {
        Member user = memberService.updateProfileImage(username, profileImage);
        return new ResponseEntity<>(user, OK);
    }

    @GetMapping(path = "/image/{username}/{fileName}", produces = IMAGE_JPEG_VALUE)
    public byte[] getProfileImage(@PathVariable("username") String username, @PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(USER_FOLDER + username + FORWARD_SLASH + fileName));
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
