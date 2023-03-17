package com.hotsix.titans.board.cotroller;

import com.hotsix.titans.board.dto.BoardNoticeDTO;
import com.hotsix.titans.board.entity.BoardNotice;
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

        List<BoardNoticeDTO> boardNoticeList = boardNoticeService.listAll();
        System.out.println("boardNoticeList = " + boardNoticeList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 조회 성공", boardNoticeList));
    }

    @PostMapping(value = "/board/notice/insert")
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

        System.out.println("boardNoticeDTO = " + boardNoticeDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 등록 성공", boardNoticeService.insertBoardNotice(boardNoticeDTO)));
    }

    @PutMapping("/board/notice/{noticeCode}") // 끝에 / 적으면 안됨
    public ResponseEntity<ResponseDTO> updateBoardNotice(@PathVariable String noticeCode) {

            ResponseDTO responseDTO = new ResponseDTO();
            BoardNoticeDTO boardNoticeDTO = new BoardNoticeDTO();

            boardNoticeDTO.setNoticeCode(noticeCode);
            boardNoticeDTO.setMemberCode(String.valueOf(140001));
            boardNoticeDTO.setNoticeTitle("PUT테스트");
            boardNoticeDTO.setNoticeDate(Date.valueOf(LocalDate.now()));
            boardNoticeDTO.setNoticeCount(0);
            boardNoticeDTO.setNoticeContent("PUT테스트");
            boardNoticeDTO.setNoticeDeleteYN('Y');

            System.out.println("boardNoticeDTO = " + boardNoticeDTO);
            return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 수정(삭제) 성공", boardNoticeService.updateBoardNotice(boardNoticeDTO)));
        }
}
