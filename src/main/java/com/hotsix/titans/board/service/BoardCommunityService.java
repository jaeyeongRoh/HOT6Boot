package com.hotsix.titans.board.service;

import org.springframework.stereotype.Service;

@Service
public class BoardCommunityService {
//
//    private final BoardCommunityRepositoryAndBoardCommunityPaymentHistory boardCommunityRepositoryAndBoardCommunityPaymentHistory;
//    private final BoardCommunityRepository boardCommunityRepository;
//    private final ModelMapper modelMapper;
//
//    @Autowired
//    public BoardCommunityService(BoardCommunityRepositoryAndBoardCommunityPaymentHistory boardCommunityRepositoryAndBoardCommunityPaymentHistory, BoardCommunityRepository boardCommunityRepository, ModelMapper modelMapper) {
//        this.boardCommunityRepositoryAndBoardCommunityPaymentHistory = boardCommunityRepositoryAndBoardCommunityPaymentHistory;
//        this.boardCommunityRepository = boardCommunityRepository;
//        this.modelMapper = modelMapper;
//    }
//
//
//    public List<BoardCommunityCategoryAndBoardCommunityPaymentHistoryDTO> listAll() {
//
//        List<BoardCommunityCategoryAndBoardCommunityPaymentHistory> boardCommunityPaymentHistoryList = boardCommunityRepositoryAndBoardCommunityPaymentHistory.findAll();
//
//        System.out.println("boardCommunityPaymentHistoryList : " + boardCommunityPaymentHistoryList);
//        return boardCommunityPaymentHistoryList.stream().map(boardCommunityPaymentHistory -> modelMapper.map(boardCommunityPaymentHistory, BoardCommunityCategoryAndBoardCommunityPaymentHistoryDTO.class)).collect(Collectors.toList());
//    }
//
//    @Transactional
//    public Object insertBoardCommunityCategory(BoardCommunityCategoryDTO boardCommunityCategoryDTO) {
//
//        int result = 0;
//
//        try {
//
//            BoardCommunityCategory insertBoardCommunityCategory = modelMapper.map(boardCommunityCategoryDTO, BoardCommunityCategory.class);
//
//            boardCommunityRepository.save(insertBoardCommunityCategory);
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
//    public Object deleteBoardCommunityCategory(String boardCommunityCategoryCode) {
//
//        int result = boardCommunityRepository.deleteByBoardCommunityCategoryCode(boardCommunityCategoryCode);
//        return (result > 0) ? "휴가 기준 삭제 성공" : "휴가 기준 삭제 실패";
//    }
}
