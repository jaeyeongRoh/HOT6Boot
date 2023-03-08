package com.hotsix.titans.board.service;

import com.hotsix.titans.board.dto.BoardNoticeDTO;
import com.hotsix.titans.board.entity.BoardNotice;
import com.hotsix.titans.board.repository.BoardNoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardNoticeService {

    private final BoardNoticeRepository boardNoticeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BoardNoticeService(BoardNoticeRepository boardNoticeRepository, ModelMapper modelMapper) {
        this.boardNoticeRepository = boardNoticeRepository;
        this.modelMapper = modelMapper;
    }


    public List<BoardNoticeDTO> listAll() {

        List<BoardNotice> boardNoticeList = boardNoticeRepository.findAll();

        System.out.println("boardNoticeList : " + boardNoticeList);
        return boardNoticeList.stream().map(boardNotice -> modelMapper.map(boardNotice, BoardNoticeDTO.class)).collect(Collectors.toList());
        // 엔티티 객체로 받아온 것을 DTO로 변환 왜
    }

//    @Transactional
//    public Object insertBoardNotice(BoardNoticeDTO boardNoticeDTO) {
//
//        int result = 0;
//
//        try {
//
//            BoardNotice insertBoardNotice = modelMapper.map(boardNoticeDTO, BoardNotice.class);
//
//            boardNoticeRepository.save(insertBoardNotice);
//
//            result = 1;
//        } catch (Exception e) {
//
//            throw new RuntimeException(e);
//        }
//
//        return (result > 0) ? "입력 성공" : "입력 실패";
//    }

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
//
//    @Transactional
//    public Object insertBoardNoticeCategory(BoardNoticeCategoryDTO boardNoticeCategoryDTO) {
//
//        int result = 0;
//
//        try {
//
//            BoardNoticeCategory insertBoardNoticeCategory = modelMapper.map(boardNoticeCategoryDTO, BoardNoticeCategory.class);
//
//            boardNoticeRepository.save(insertBoardNoticeCategory);
//
//            result = 1;
//        } catch (Exception e) {
//
//            throw new RuntimeException(e);
//        }
//
//        return (result > 0) ? "입력 성공" : "입력 실패";
//    }
//
//    @Transactional
//    public Object deleteBoardNoticeCategory(String boardNoticeCategoryCode) {
//
//        int result = boardNoticeRepository.deleteByBoardNoticeCategoryCode(boardNoticeCategoryCode);
//        return (result > 0) ? "휴가 기준 삭제 성공" : "휴가 기준 삭제 실패";
//    }
}
