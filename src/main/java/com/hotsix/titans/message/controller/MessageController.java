package com.hotsix.titans.message.controller;


import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.service.MemberService;
import com.hotsix.titans.message.dto.MessageDTO;
import com.hotsix.titans.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MessageController {


    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/message/msgAllMember")
    public ResponseEntity<ResponseDTO> selectMessageAllMember(){

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", messageService.selectMessageAllMember()));
    }

    /*메세지 코드로 검색*/
    @GetMapping("/message/{messageCode}")
    public ResponseEntity<ResponseDTO> seletMessageCode(@PathVariable String messageCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", messageService.selectMessageCode(messageCode)));
    }

    /*검색한 결과를 포함한 결과*/
    @GetMapping("/message/search/{memberName1}")
    public ResponseEntity<ResponseDTO> seletMessageName(@PathVariable String memberName1){

        System.out.println("이름" + memberName1);
        System.out.println("테스트");
//        System.out.println(" 값전달 테스트 = " +  messageService.selectMemberName(memberName1));
        
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", messageService.selectMemberName(memberName1)));
    }



    /*메세지 보내기 버튼 누를 때 작동*/
    @PostMapping("/message")
    public ResponseEntity<ResponseDTO> insertMessage(@RequestBody MessageDTO messageDTO){

        System.out.println("messageTitle = " + messageDTO.getMessageTitle());
        System.out.println("messageContent = " + messageDTO.getMessageContent());
        System.out.println("recipients = " + messageDTO.getRecipients());
        System.out.println("memberCode = " + messageDTO.getMemberCode());



        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "메세지 전송성공", messageService.insertMessage(messageDTO)));
    }



    /*휴지통*/
    @PostMapping("/messageTrash")
    public ResponseEntity<ResponseDTO> checkTrashEmail(@RequestBody MessageDTO messageDTO){

        System.out.println("messageDTO 받은편지함 = " + messageDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "받은메세지 테스트", messageService.checkTrashEmail(messageDTO)));
    }

    /*휴지통 카운트*/
    @PostMapping("/messageTrashCount")
    public ResponseEntity<ResponseDTO> checkTrashEmailCount(@RequestBody MessageDTO messageDTO){

        System.out.println("messageDTO 받은편지함 = " + messageDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "받은메세지 테스트", messageService.checkTrashEmail(messageDTO).size()));
    }


    /*받은 편지함*/
    @PostMapping("/messageReceived")
    public ResponseEntity<ResponseDTO> checkReceivedEmail(@RequestBody MessageDTO messageDTO){

        System.out.println("messageDTO 받은편지함 = " + messageDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "받은메세지 테스트", messageService.checkReceivedEmail(messageDTO)));
    }

    /*받은 편지함 카운트*/
    @PostMapping("/messageReceivedCount")
    public ResponseEntity<ResponseDTO> checkReceivedEmailCount(@RequestBody MessageDTO messageDTO){


        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", messageService.checkReceivedEmail(messageDTO).size()));
    }


    /*보낸 편지함*/
    @PostMapping("/messageSent")
    public ResponseEntity<ResponseDTO> checkSentEmail(@RequestBody MessageDTO messageDTO){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", messageService.checkSentEmail(messageDTO)));
    }


    /*보낸 편지함 카운트*/
    @PostMapping("/messageSentCount")
    public ResponseEntity<ResponseDTO> checkSentEmailCount(@RequestBody MessageDTO messageDTO){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", messageService.checkSentEmail(messageDTO).size()));
    }


    /*휴지통 선택값 y로 변경*/

    @PostMapping("/messageReceivedDelete")
    public ResponseEntity<ResponseDTO> checkReceivedEmailDelete(@RequestBody MessageDTO messageDTO){

        System.out.println("messageDTO 휴지통" +messageDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",  messageService.selectMessageCodeDelete(messageDTO)));
    }

}

//
