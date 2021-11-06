package com.example.project1.dao;

import com.example.project1.bean.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberDao extends JpaRepository<Member, Long> {
    Member findBynumeroEtudiant(String numeroEtudiant);
    Member findMemberById(Long id);
    int deleteMemberById(Long id);
}
