package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.TeamRole;
import com.hotsix.titans.member.entity.TeamRolePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRoleRepository extends JpaRepository<TeamRole, TeamRolePk> {

}
