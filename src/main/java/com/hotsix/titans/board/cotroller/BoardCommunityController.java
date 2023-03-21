package com.hotsix.titans.board.cotroller;

import com.hotsix.titans.board.dto.BoardCommunityDTO;
import com.hotsix.titans.board.service.BoardCommunityService;
import com.hotsix.titans.commons.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BoardCommunityController {

    private final BoardCommunityService boardCommunityService;

    @Autowired
    public BoardCommunityController(BoardCommunityService boardCommunityService) {
        this.boardCommunityService = boardCommunityService;
    }

    @Operation(summary = "커뮤니티 게시물 전체 조회 요청", description = "커뮤니티 게시물 전체 조회가 진행됩니다.", tags = {"BoardCommunityController"})
    @GetMapping("/board/community")
    public ResponseEntity<ResponseDTO> listAllPrint() {

        List<BoardCommunityDTO> boardCommunityList = boardCommunityService.listAll();
        System.out.println("boardCommunityList = " + boardCommunityList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "자유게시판 조회 성공", boardCommunityList));
    }

    @Operation(summary = "선택한 커뮤니티 게시물 조회 요청", description = "선택한 커뮤니티 게시물 조회가 진행됩니다.", tags = {"BoardCommunityController"})
    @GetMapping("/board/community/{communityCode}")
    public ResponseEntity<ResponseDTO> selectBoardCommunityDetail(@PathVariable String communityCode) {
        System.out.println("communityCode : " + communityCode);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", boardCommunityService.selectBoardCommunityDetail(communityCode)));

//        /* 댓글 작성 완료 후 추가할 것 */
//        List<ReplyDTO> replyList = boardService.selectAllReplyList(no);
//        model.addAttribute("replyList", replyList);
//        log.info("[BoardController] replyList : " + replyList);
//
//        log.info("[BoardController] =========================================================");
//        return "content/board/boardDetail";
    }

    @Operation(summary = "커뮤니티 게시물 등록 요청", description = "커뮤니티 게시물 등록이 진행됩니다.", tags = {"BoardCommunityController"})
    @PostMapping(value = "/board/community/write")
    public ResponseEntity<ResponseDTO> insertBoardCommunity(@RequestBody BoardCommunityDTO boardCommunityDTO) {

        System.out.println("boardCommunityDTO : " + boardCommunityDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "자유게시판 등록 성공", boardCommunityService.insertBoardCommunity(boardCommunityDTO)));
    }

    @Operation(summary = "커뮤니티 게시물 수정 요청", description = "커뮤니티 게시물 수정이 진행됩니다.", tags = {"BoardCommunityController"})
    @PutMapping("/board/community/{communityCode}") /* 끝에 / 적으면 안됨 */
    public ResponseEntity<ResponseDTO> updateBoardCommunity(@RequestBody BoardCommunityDTO boardCommunityDTO) {

        System.out.println("boardCommunityDTO = " + boardCommunityDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "자유게시판 수정(삭제) 성공", boardCommunityService.updateBoardCommunity(boardCommunityDTO)));
    }


    // 댓글
//    @PostMapping("/registReply")
//    public ResponseEntity<List<ReplyDTO>> registReply(@RequestBody ReplyDTO registReply) throws ReplyRegistException {
//
//        log.info("");
//        log.info("");
//        log.info("[BoardController] =========================================================");
//        log.info("[BoardController] registReply Request : " + registReply);
//
//        List<ReplyDTO> replyList = boardService.registReply(registReply);
//
//        log.info("[BoardController] replyList : " + replyList);
//        log.info("[BoardController] =========================================================");
//
//        return ResponseEntity.ok(replyList);
//    }

//    @PutMapping("/board/community/{communityCode}") /* 끝에 / 적으면 안됨 */
//    public ResponseEntity<ResponseDTO> updateBoardCommunity(@ModelAttribute BoardCommunityDTO boardCommunityDTO) {
//
//        System.out.println("boardCommunityDTO = " + boardCommunityDTO);
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "자유게시판 수정(삭제) 성공", boardCommunityService.updateBoardCommunity(boardCommunityDTO)));
//    }
}
