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

    @Operation(summary = "공지사항 게시물 전체 조회 요청", description = "공지사항 게시물 전체 조회가 진행됩니다.", tags = {"BoardNoticeController"})
    @GetMapping("/board/notice")
    public ResponseEntity<ResponseDTO> listAllPrint() {

        List<BoardNoticeDTO> boardNoticeList = boardNoticeService.listAll();
        System.out.println("boardNoticeList = " + boardNoticeList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 조회 성공", boardNoticeList));
    }

    @Operation(summary = "선택한 공지사항 게시물 조회 요청", description = "선택한 공지사항 게시물 조회가 진행됩니다.", tags = {"BoardNoticeController"})
    @GetMapping("/board/notice/{noticeCode}")
    public ResponseEntity<ResponseDTO> selectBoardNoticeDetail(@PathVariable String noticeCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", boardNoticeService.selectBoardNoticeDetail(noticeCode)));
    }

    @Operation(summary = "공지사항 게시물 등록 요청", description = "공지사항 게시물 등록이 진행됩니다.", tags = {"BoardNoticeController"})
    @PostMapping(value = "/board/notice/write")
    public ResponseEntity<ResponseDTO> insertBoardNotice(@RequestBody BoardNoticeDTO boardNoticeDTO) {

        System.out.println("boardNoticeDTO : " + boardNoticeDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 등록 성공", boardNoticeService.insertBoardNotice(boardNoticeDTO)));
    }

    @Operation(summary = "공지사항 게시물 수정 요청", description = "공지사항 게시물 수정이 진행됩니다.", tags = {"BoardNoticeController"})
    @PutMapping("/board/notice/{noticeCode}")
    public ResponseEntity<ResponseDTO> updateBoardNotice(@ModelAttribute BoardNoticeDTO boardNoticeDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 수정 성공", boardNoticeService.updateBoardNotice(boardNoticeDTO)));
    }
}
