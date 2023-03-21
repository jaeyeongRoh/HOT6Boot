package com.hotsix.titans.board.cotroller;

import com.hotsix.titans.board.dto.BoardNoticeDTO;
import com.hotsix.titans.board.service.BoardNoticeService;
import com.hotsix.titans.commons.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        System.out.println("boardNoticeDTO : " + boardNoticeDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 등록 성공", boardNoticeService.insertBoardNotice(boardNoticeDTO)));
    }

    @Operation(summary = "공지사항 수정", description = "공지사항 제목, 내용 수정 및 저장", tags = { "BoardNoticeController" })
    @PutMapping("/board/notice/{noticeCode}") /* 끝에 / 적으면 안됨 */
    public ResponseEntity<ResponseDTO> updateBoardNotice(@ModelAttribute BoardNoticeDTO boardNoticeDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 수정(삭제) 성공", boardNoticeService.updateBoardNotice(boardNoticeDTO)));
    }
}
