package com.hotsix.titans.message.entity;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
/*복합키*/
public class MessageHistoryIds implements Serializable {

    private String memberCode;
    private String messageCode;
    private String messageReceiver;
    private String messageReceiverEmail;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageHistoryIds that = (MessageHistoryIds) o;
        return Objects.equals(memberCode, that.memberCode) && Objects.equals(messageCode, that.messageCode) && Objects.equals(messageReceiver, that.messageReceiver) && Objects.equals(messageReceiverEmail, that.messageReceiverEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberCode, messageCode, messageReceiver, messageReceiverEmail);
    }
}
