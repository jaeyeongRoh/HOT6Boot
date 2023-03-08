package com.hotsix.titans.board.repository;

import com.hotsix.titans.board.entity.BoardNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardNoticeRepository extends JpaRepository<BoardNotice, String> {

    List<BoardNotice> findByNoticeDeleteYN(char deleteYn);
}
