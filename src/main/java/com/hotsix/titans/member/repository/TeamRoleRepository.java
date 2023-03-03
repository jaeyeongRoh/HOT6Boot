package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.MemberRole;
import com.hotsix.titans.member.entity.MemberRolePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRoleRepository extends JpaRepository<MemberRole, MemberRolePk> {

}
