package com.hotsix.titans.message.repository;

import com.hotsix.titans.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Integer>  {
    Message findByMessageCode(String messageCode);


    List<Message> findByMemberCode(String memberCode);
}
