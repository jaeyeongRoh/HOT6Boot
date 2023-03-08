package com.hotsix.titans.board.cotroller;

import com.hotsix.titans.board.dto.BoardNoticeDTO;
import com.hotsix.titans.board.service.BoardNoticeService;
import com.hotsix.titans.commons.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v2") // 추후 수정 필요
public class BoardNoticeController {

    private final BoardNoticeService boardNoticeService;

    @Autowired
    public BoardNoticeController(BoardNoticeService boardNoticeService) {
        this.boardNoticeService = boardNoticeService;
    }

    /* */
    @GetMapping("/board/notice")
    public ResponseEntity<ResponseDTO> listAllPrint() {

        List<BoardNoticeDTO> boardNoticeCategoryList = boardNoticeService.listAll();
        System.out.println("boardNoticeCategoryList = " + boardNoticeCategoryList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 조회 성공", (Object) boardNoticeCategoryList));
    }

//    @PostMapping(value = "/board/insert")
//    public ResponseEntity<ResponseDTO> insertBoardNotice(@ModelAttribute BoardNoticeDTO boardNoticeDTO) {
//
//        System.out.println("boardNoticeDTO = " + boardNoticeDTO);
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 등록 성공",  boardNoticeService.insertBoardNotice(BoardNoticeDTO)));
//    }

    @PostMapping(value = "/board/insert")
    public ResponseEntity<ResponseDTO> insertBoardNotice() {

        ResponseDTO responseDTO = new ResponseDTO();

        BoardNoticeDTO boardNoticeDTO = new BoardNoticeDTO();

        boardNoticeDTO.setNoticeCode(String.valueOf(5));
        boardNoticeDTO.setMemberCode(String.valueOf(140001));
        boardNoticeDTO.setNoticeTitle("공지사항 테스트5 포스트맨용 제목");
        boardNoticeDTO.setNoticeDate(Date.valueOf(LocalDate.now()));
        boardNoticeDTO.setNoticeCount(0);
        boardNoticeDTO.setNoticeContent("공지사항 테스트5 포스트맨용 본문");
        boardNoticeDTO.setNoticeDeleteYN('N');

        System.out.println(boardNoticeDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 등록 성공", boardNoticeService.insertBoardNotice(boardNoticeDTO)));
    }
//
//    /* 휴가 기준 등록 */
//    @PostMapping(value = "/annual/standardsManagement")
//    public ResponseEntity<ResponseDTO> insertBoardNotice(@ModelAttribute BoardNoticeCategoryDTO boardNoticeCategoryDTO) {
//
//        System.out.println("-------------" + boardNoticeCategoryDTO);
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "휴가기준 입력 성공",  boardNoticeService.insertBoardNoticeCategory(boardNoticeCategoryDTO)));
//    }
//
//    /* 휴가 기준 삭제 */
//    @DeleteMapping(value = "/annual/standardsManagement/{boardNoticeCategoryCode}")
//    public ResponseEntity<ResponseDTO> deleteBoardNoticeCategory(@PathVariable String boardNoticeCategoryCode) {
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"휴가기준 삭제 성공",boardNoticeService.deleteBoardNoticeCategory(boardNoticeCategoryCode)));
//    }
}
