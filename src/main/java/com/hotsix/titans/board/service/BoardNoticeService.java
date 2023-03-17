package com.hotsix.titans.board.service;

import com.hotsix.titans.board.dto.BoardNoticeDTO;
import com.hotsix.titans.board.entity.BoardNotice;
import com.hotsix.titans.board.repository.BoardNoticeRepository;
import com.hotsix.titans.member.entity.Member;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardNoticeService {

    private static final Logger log = LoggerFactory.getLogger(BoardNoticeService.class);
    private final BoardNoticeRepository boardNoticeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BoardNoticeService(BoardNoticeRepository boardNoticeRepository, ModelMapper modelMapper) {
        this.boardNoticeRepository = boardNoticeRepository;
        this.modelMapper = modelMapper;
    }


    public List<BoardNoticeDTO> listAll() {

        char deleteYn = 'N';

        List<BoardNotice> boardNoticeList = boardNoticeRepository.findByNoticeDeleteYN(deleteYn);

        System.out.println("boardNoticeList : " + boardNoticeList);
        return boardNoticeList.stream().map(boardNotice -> modelMapper.map(boardNotice, BoardNoticeDTO.class)).collect(Collectors.toList());
        // 엔티티 객체로 받아온 것을 DTO로 변환
    }

    public Object selectBoardNoticeDetail(String noticeCode) {
        log.info("[BoardNoticeService] getBoardNoticeDetail Start ==============================");

        BoardNotice boardNotice = boardNoticeRepository.findById(noticeCode).get();

        log.info("[BoardNoticeService] getBoardNoticeDetail End ==============================");

        return modelMapper.map(boardNotice, BoardNoticeDTO.class);
    }

    @Transactional
    public BoardNoticeDTO insertBoardNotice(BoardNoticeDTO boardNoticeDTO) {
        log.info("[BoardNoticeService] boardNoticeMember Start");
        log.info("[BoardNoticeService] boardNoticeDTO {}", boardNoticeDTO);

        BoardNotice boardNotice = modelMapper.map(boardNoticeDTO, BoardNotice.class);
        boardNotice.setNoticeDate(LocalDateTime.now());

        BoardNotice result = boardNoticeRepository.save(boardNotice);

        System.out.println("result : " + result);
        log.info("[BoardNoticeService] BoardNotice Insert Result {}",
                (result != null) ? "공지사항 등록 성공" : "공지사항 등록 실패");

        return boardNoticeDTO;
    }


    @Transactional
    public Object updateBoardNotice(BoardNoticeDTO boardNoticeDTO) {

//        BoardNotice boardNotice = boardNoticeRepository.findByNoticeCode(boardNoticeDTO.getNoticeCode());
//
//        boardNotice.setNoticeCode(boardNoticeDTO.getNoticeCode()); // 복사
//        boardNotice.setMemberCode(boardNoticeDTO.getMemberCode());
//        boardNotice.setNoticeTitle(boardNoticeDTO.getNoticeTitle());
//        boardNotice.setNoticeDate(boardNoticeDTO.getNoticeDate());
//        boardNotice.setNoticeCount(boardNoticeDTO.getNoticeCount());
//        boardNotice.setNoticeContent(boardNoticeDTO.getNoticeContent());
//        boardNotice.setNoticeDeleteYN(boardNoticeDTO.getNoticeDeleteYN());
//
//        boardNoticeRepository.saveAndFlush(boardNotice);

        return null;
    }
}
