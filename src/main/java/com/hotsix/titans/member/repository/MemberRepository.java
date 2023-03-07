package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findByWorkingStatus(String workingStatus);

    List<Member> findByMemberNameContaining(String memberName);

    Member findByMemberCode(String memberCode);
}
