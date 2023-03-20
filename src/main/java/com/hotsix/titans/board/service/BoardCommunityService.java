package com.hotsix.titans.board.service;

import com.hotsix.titans.board.dto.BoardCommunityDTO;
import com.hotsix.titans.board.entity.BoardCommunity;
import com.hotsix.titans.board.repository.BoardCommunityRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardCommunityService {

    private static final Logger log = LoggerFactory.getLogger(BoardCommunityService.class);
    private final BoardCommunityRepository boardCommunityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BoardCommunityService(BoardCommunityRepository boardCommunityRepository, ModelMapper modelMapper) {
        this.boardCommunityRepository = boardCommunityRepository;
        this.modelMapper = modelMapper;
    }

    public List<BoardCommunityDTO> listAll() {

        char deleteYn = 'N';

        List<BoardCommunity> boardCommunityList = boardCommunityRepository.findByBoardDeleteYnOrderByBoardInsertDateDesc(deleteYn);

        System.out.println("boardCommunityList : " + boardCommunityList);
        return boardCommunityList.stream().map(boardCommunity -> modelMapper.map(boardCommunity, BoardCommunityDTO.class)).collect(Collectors.toList());
        // 엔티티 객체로 받아온 것을 DTO로 변환
    }

    public Object selectBoardCommunityDetail(String boardCode) {
        log.info("[BoardCommunityService] getBoardCommunityDetail Start");

        BoardCommunity boardCommunity = boardCommunityRepository.findById(boardCode).get();

        log.info("[BoardCommunityService] getBoardCommunityDetail End");

        return modelMapper.map(boardCommunity, BoardCommunityDTO.class);
    }


    @Transactional
    public BoardCommunityDTO insertBoardCommunity(BoardCommunityDTO boardCommunityDTO) {
        log.info("[BoardCommunityService] boardCommunityDTO {}", boardCommunityDTO);

        BoardCommunity boardCommunity = modelMapper.map(boardCommunityDTO, BoardCommunity.class);
        boardCommunity.setBoardInsertDate(LocalDateTime.now());

        BoardCommunity result = boardCommunityRepository.save(boardCommunity);
        System.out.println("result : " + result);
        log.info("[BoardCommunityService] BoardCommunity Insert Result {}",
                (result != null) ? "공지사항 등록 성공" : "공지사항 등록 실패");

        return boardCommunityDTO;
    }


    @Transactional
    public Object updateBoardCommunity(BoardCommunityDTO boardCommunityDTO) {

        log.info("[BoardCommunityService] updateMyInfo Start");

        int result = 0;

        /* 엔티티 조회 */
        BoardCommunity boardCommunity = boardCommunityRepository.findByBoardCode(boardCommunityDTO.getBoardCode());

        /* update를 위한 엔티티 값 수정 */
        boardCommunity.setBoardCode(boardCommunityDTO.getBoardCode());
        boardCommunity.setMemberCode(boardCommunityDTO.getMemberCode());
        boardCommunity.setBoardTitle(boardCommunityDTO.getBoardTitle());
        boardCommunity.setBoardContent(boardCommunityDTO.getBoardContent());
        boardCommunity.setBoardInsertDate(boardCommunityDTO.getBoardInsertDate());
        boardCommunity.setBoardUpdateDate(boardCommunityDTO.getBoardUpdateDate());
        boardCommunity.setBoardCount(boardCommunityDTO.getBoardCount());
        boardCommunity.setBoardDeleteYn(boardCommunityDTO.getBoardDeleteYn());

        if (boardCommunity.getBoardCode() == boardCommunityDTO.getBoardCode()) {
            result = 1;
        }

        log.info("[BoardCommunityService] updateBoardCommunity End ");
        return (result > 0) ? "공지사항 수정 성공" : "공지사항 수정 실패";
    }


//    /* 해당 게시글의 전체 댓글 조회용 메소드 */
//    public List<ReplyDTO> selectAllReplyList(Long boardNo) {
//        List<ReplyDTO> replyList = null;
//
//        replyList = mapper.selectReplyList(boardNo);
//
//        return replyList;
//    }


//    /* 댓글 등록용 메소드 */
//    @org.springframework.transaction.annotation.Transactional
//    public List<ReplyDTO> registReply(ReplyDTO registReply) throws ReplyRegistException {
//        List<ReplyDTO> replyList = null;
//
//        int result = mapper.insertReply(registReply);
//
//        if(result > 0) {
//            replyList = mapper.selectReplyList(registReply.getRefBoardNo());
//        } else {
//            throw new ReplyRegistException("댓글 등록에 실패하셨습니다.");
//        }
//
//        return replyList;
//    }

//    /* 댓글 삭제용 메소드 */
//    @org.springframework.transaction.annotation.Transactional
//    public List<ReplyDTO> removeReply(ReplyDTO removeReply) throws ReplyRemoveException {
//        List<ReplyDTO> replyList = null;
//
//        int result = mapper.deleteReply(removeReply.getNo());
//
//        if(result > 0) {
//            replyList = mapper.selectReplyList(removeReply.getRefBoardNo());
//        } else {
//            throw new ReplyRemoveException("댓글 삭제에 실패하셨습니다.");
//        }
//
//        return replyList;
//    }

//    @Transactional
//    public Object updateBoardCommunity(BoardCommunityDTO boardCommunityDTO) {
//
////        BoardCommunity boardCommunity = boardCommunityRepository.findByCommunityCode(boardCommunityDTO.getCommunityCode());
////
////        boardCommunity.setCommunityCode(boardCommunityDTO.getCommunityCode()); // 복사
////        boardCommunity.setMemberCode(boardCommunityDTO.getMemberCode());
////        boardCommunity.setCommunityTitle(boardCommunityDTO.getCommunityTitle());
////        boardCommunity.setCommunityDate(boardCommunityDTO.getCommunityDate());
////        boardCommunity.setCommunityCount(boardCommunityDTO.getCommunityCount());
////        boardCommunity.setCommunityContent(boardCommunityDTO.getCommunityContent());
////        boardCommunity.setCommunityDeleteYN(boardCommunityDTO.getCommunityDeleteYN());
////
////        boardCommunityRepository.saveAndFlush(boardCommunity);
//
//        return null;
//    }

}
