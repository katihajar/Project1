package com.example.project1.dao;

import com.example.project1.bean.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Long> {
}
