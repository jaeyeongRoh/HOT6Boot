package com.hotsix.titans.board.repository;

import com.hotsix.titans.salary.entity.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface BoardCommunityRepository extends JpaRepository<Bonus, String> {
//
//    int deleteByBoardCommunityCategoryCode(String boardCommunityCategoryCode);
}
