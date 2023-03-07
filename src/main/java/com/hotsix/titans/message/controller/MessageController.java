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
@CrossOrigin(origins = "http://localhost:3000")
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
    @GetMapping("/message/search/{memberName}")
    public ResponseEntity<ResponseDTO> seletMessageName(@PathVariable String memberName){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", messageService.selectMemberName(memberName)));
    }




    @PostMapping("/message")
    public ResponseEntity<ResponseDTO> insertMessage(@RequestBody MessageDTO messageDTO){

        System.out.println("messageTitle = " + messageDTO.getMessageTitle());
        System.out.println("messageContent = " + messageDTO.getMessageContent());
        System.out.println("recipients = " + messageDTO.getRecipients());


        ArrayList<String> test = new ArrayList<>();
        test.add("메세지입니다.");

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "메세지 전송성공", messageService.insertMessage(messageDTO)));
    }

}
