package com.hotsix.titans.message.repository;

import com.hotsix.titans.message.entity.MessageHistory;
import com.hotsix.titans.message.entity.MessageHistoryIds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageHistoryRepository extends JpaRepository<MessageHistory, MessageHistoryIds> {
}
