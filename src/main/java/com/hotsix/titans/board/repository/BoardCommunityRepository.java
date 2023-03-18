package com.hotsix.titans.board.repository;

import com.hotsix.titans.board.entity.BoardCommunity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardCommunityRepository extends JpaRepository<BoardCommunity, String> {
    List<BoardCommunity> findByBoardDeleteYnOrderByBoardInsertDateDesc(char deleteYn);

    BoardCommunity findByBoardCode(String communityCode);
}
