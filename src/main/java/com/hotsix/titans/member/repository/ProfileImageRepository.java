package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, String> {

    ProfileImage findByMemberCode(String memberCode);
}