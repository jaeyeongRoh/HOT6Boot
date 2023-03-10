package com.hotsix.titans.board.service;

import com.hotsix.titans.board.dto.BoardNoticeDTO;
import com.hotsix.titans.board.entity.BoardNotice;
import com.hotsix.titans.board.repository.BoardNoticeRepository;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.salary.entity.Salary;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardNoticeService {

    private static final Logger log = LoggerFactory.getLogger(BoardNoticeService.class);
    private final BoardNoticeRepository boardNoticeRepository;
    private final ModelMapper modelMapper;

    /* 이미지 저장 할 위치 및 응답 할 이미지 주소(WebConfig 설정파일 추가하기) */
//    @Value("${image.image-dir}")
//    private String IMAGE_DIR;
//    @Value("${image.image-url}")
//    private String IMAGE_URL;

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
        // 엔티티 객체로 받아온 것을 DTO로 변환 왜
    }

    @Transactional
    public Object insertBoardNotice(BoardNoticeDTO boardNoticeDTO) {

        BoardNotice boardNotice = new BoardNotice();

        boardNotice.setNoticeCode(boardNoticeDTO.getNoticeCode());
        boardNotice.setMemberCode(boardNoticeDTO.getMemberCode());
        boardNotice.setNoticeTitle(boardNoticeDTO.getNoticeTitle());
        boardNotice.setNoticeDate(boardNoticeDTO.getNoticeDate());
        boardNotice.setNoticeCount(boardNoticeDTO.getNoticeCount());
        boardNotice.setNoticeContent(boardNoticeDTO.getNoticeContent());
        boardNotice.setNoticeDeleteYN(boardNoticeDTO.getNoticeDeleteYN());

        boardNoticeRepository.saveAndFlush(boardNotice);
        int result = 1;
        return result;
    }

    @Transactional
    public Object updateBoardNotice(BoardNoticeDTO boardNoticeDTO) {

        BoardNotice boardNotice = boardNoticeRepository.findByNoticeCode(boardNoticeDTO.getNoticeCode());

        boardNotice.setNoticeCode(boardNoticeDTO.getNoticeCode()); // 복사
        boardNotice.setMemberCode(boardNoticeDTO.getMemberCode());
        boardNotice.setNoticeTitle(boardNoticeDTO.getNoticeTitle());
        boardNotice.setNoticeDate(boardNoticeDTO.getNoticeDate());
        boardNotice.setNoticeCount(boardNoticeDTO.getNoticeCount());
        boardNotice.setNoticeContent(boardNoticeDTO.getNoticeContent());
        boardNotice.setNoticeDeleteYN(boardNoticeDTO.getNoticeDeleteYN());

        boardNoticeRepository.saveAndFlush(boardNotice);
        int result = 1;
        return result;
    }
}
