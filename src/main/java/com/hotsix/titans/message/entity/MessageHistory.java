package com.hotsix.titans.message.entity;

import com.hotsix.titans.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(MessageHistoryIds.class)
@Table(name ="TBL_MESSAGE_HISTORY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MessageHistory implements Serializable {

    @Id
    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Id
    @Column(name = "MESSAGE_CODE")
    private String messageCode;

    @Column(name = "MESSAGE_RECEIVER")
    private String messageReceiver;

    @Column(name = "MESSAGE_RECEIVER_EMAIL")
    private String messageReceiverEmail;






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageHistory that = (MessageHistory) o;
        return Objects.equals(memberCode, that.memberCode) && Objects.equals(messageCode, that.messageCode) && Objects.equals(messageReceiver, that.messageReceiver) && Objects.equals(messageReceiverEmail, that.messageReceiverEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberCode, messageCode, messageReceiver, messageReceiverEmail);
    }

}
