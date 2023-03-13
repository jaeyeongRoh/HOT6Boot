package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.SimpleMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimpleMemberRepository extends JpaRepository<SimpleMember, String> {

    SimpleMember findByMemberCode(String string);
}
