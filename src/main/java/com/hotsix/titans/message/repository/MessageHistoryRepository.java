package com.hotsix.titans.message.repository;

import com.hotsix.titans.message.entity.MessageHistory;
import com.hotsix.titans.message.entity.MessageHistoryIds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageHistoryRepository extends JpaRepository<MessageHistory, MessageHistoryIds> {



    List<MessageHistory> findByMessageReceiverEmail(String memberEmail);


    List<MessageHistory> findByMessageReceiverEmailAndMessageReceiverDeleteYn(String memberEmail, String messageReceiverDeleteYn);

    MessageHistory findByMessageCode(String messageCode);
}
