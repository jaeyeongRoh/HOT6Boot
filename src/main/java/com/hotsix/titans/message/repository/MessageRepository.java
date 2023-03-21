package com.hotsix.titans.message.repository;

import com.hotsix.titans.message.dto.MessageDTO;
import com.hotsix.titans.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Integer>  {
    Message findByMessageCode(String messageCode);


    List<Message> findByMemberCode(String memberCode);

    Message findByMessageDeleteYn(String n);

    Message findAllByMessageCode(String s);

    List<Message> findAllByMessageCodeInOrderByMessageSendDateDesc(List<String> receivedMessage);


}
