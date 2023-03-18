package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.MemberAndRetiree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MemberAndRetireeRepository extends JpaRepository<MemberAndRetiree, String> {


}
