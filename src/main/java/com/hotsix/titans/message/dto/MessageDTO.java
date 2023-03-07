package com.hotsix.titans.message.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MessageDTO {

    private String messageCode;
    private String messageTitle;
    private String messageContent;
    private Date messageSendDate;
    private String messageReadYn;
    private String messageDeleteYn;
    private Date messageDeleteDate;
    private List<AttachmentDTO> attachment;
    private List<Recipient> recipients; // 수신자들
    private List<MessageHistoryDTO> messageHistoryDTO;

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }
}
