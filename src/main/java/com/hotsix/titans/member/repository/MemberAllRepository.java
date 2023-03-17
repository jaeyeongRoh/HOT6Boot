package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.MemberAll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberAllRepository extends JpaRepository<MemberAll, String> {

    List<MemberAll> findByMemberNameContaining(String string);
    List<MemberAll> findAllByWorkingStatus(String workingStatus);

}
