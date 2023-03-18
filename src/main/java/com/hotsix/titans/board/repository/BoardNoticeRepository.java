package com.hotsix.titans.board.repository;

import com.hotsix.titans.board.dto.BoardNoticeDTO;
import com.hotsix.titans.board.entity.BoardNotice;
import com.hotsix.titans.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface BoardNoticeRepository extends JpaRepository<BoardNotice, String> {


    List<BoardNotice> findByNoticeDeleteYNOrderByNoticeCodeDesc(char deleteYn);

    BoardNotice findByNoticeCode(String noticeCode);
}
