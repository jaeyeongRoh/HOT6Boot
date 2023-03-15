package com.hotsix.titans.board.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BoardCommunityController {
//    private final BoardCommunityService boardCommunityService;
//
//    @Autowired
//    public BoardCommunityController(BoardCommunityService boardCommunityService) {
//        this.boardCommunityService = boardCommunityService;
//    }
//
//    /* 휴가 기준 리스트 조회 */
//    @GetMapping("/annual/standardsManagement")
//    public ResponseEntity<ResponseDTO> listAllPrint() {
//
//        List<BoardCommunityCategoryAndBoardCommunityPaymentHistoryDTO> boardCommunityCAtegoryList = boardCommunityService.listAll();
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", (Object) boardCommunityCAtegoryList));
//    }
//
//    /* 휴가 기준 등록 */
//    @PostMapping(value = "/annual/standardsManagement")
//    public ResponseEntity<ResponseDTO> insertBoardCommunity(@ModelAttribute BoardCommunityCategoryDTO boardCommunityCategoryDTO) {
//
//        System.out.println("-------------" + boardCommunityCategoryDTO);
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "휴가기준 입력 성공", boardCommunityService.insertBoardCommunityCategory(boardCommunityCategoryDTO)));
//    }
//
//    /* 휴가 기준 삭제 */
//    @DeleteMapping(value = "/annual/standardsManagement/{boardCommunityCategoryCode}")
//    public ResponseEntity<ResponseDTO> deleteBoardCommunityCategory(@PathVariable String boardCommunityCategoryCode) {
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "휴가기준 삭제 성공", boardCommunityService.deleteBoardCommunityCategory(boardCommunityCategoryCode)));
//    }
}
