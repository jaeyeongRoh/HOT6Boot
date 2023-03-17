package com.hotsix.titans.board.cotroller;

import com.hotsix.titans.board.dto.BoardNoticeDTO;
import com.hotsix.titans.board.dto.BoardNoticeMemberDTO;
import com.hotsix.titans.board.entity.BoardNotice;
import com.hotsix.titans.board.entity.BoardNoticeMember;
import com.hotsix.titans.board.repository.BoardNoticeRepository;
import com.hotsix.titans.board.service.BoardNoticeService;
import com.hotsix.titans.commons.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BoardNoticeController {

    private final BoardNoticeService boardNoticeService;

    @Autowired
    public BoardNoticeController(BoardNoticeService boardNoticeService) {
        this.boardNoticeService = boardNoticeService;
    }

    /* */
    @GetMapping("/board/notice")
    public ResponseEntity<ResponseDTO> listAllPrint() {

        List<BoardNoticeDTO> boardNoticeList = boardNoticeService.listAll();
        System.out.println("boardNoticeList = " + boardNoticeList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 조회 성공", boardNoticeList));
    }

    @GetMapping("/board/notice/{noticeCode}")
    public ResponseEntity<ResponseDTO> selectBoardNoticeDetail(@PathVariable String noticeCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", boardNoticeService.selectBoardNoticeDetail(noticeCode)));
    }

    @PostMapping(value = "/board/notice/write")
    public ResponseEntity<ResponseDTO> insertBoardNotice(@RequestBody BoardNoticeDTO boardNoticeDTO) {

        System.out.println("boardNoticeDTO =================================== " + boardNoticeDTO);

//        ResponseDTO responseDTO = new ResponseDTO();
//        BoardNoticeDTO boardNoticeDTO = new BoardNoticeDTO();
//
//        boardNoticeDTO.setNoticeCode(String.valueOf(5));
//        boardNotidhceDTO.setMemberCode(String.valueOf(140001));
//        boardNoticeDTO.setNoticeTitle("공지사항 테스트5 포스트맨용 제목");
//        boardNoticeDTO.setNoticeDate(Date.valueOf(LocalDate.now()));
//        boardNoticeDTO.setNoticeCount(0);
//        boardNoticeDTO.setNoticeContent("공지사항 테스트5 포스트맨용 본문");
//        boardNoticeDTO.setNoticeDeleteYN('N');
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 등록 성공", boardNoticeService.insertBoardNotice(boardNoticeDTO)));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 등록 성공", boardNoticeService.insertBoardNotice(boardNoticeDTO)));
    }

    @PutMapping("/board/notice/{noticeCode}") /* 끝에 / 적으면 안됨 */
    public ResponseEntity<ResponseDTO> updateBoardNotice(@ModelAttribute BoardNoticeDTO boardNoticeDTO) {

        System.out.println("boardNoticeDTO = " + boardNoticeDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 수정(삭제) 성공", boardNoticeService.updateBoardNotice(boardNoticeDTO)));
    }
}
