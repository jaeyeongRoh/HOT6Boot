package com.hotsix.titans.message.dto;

import java.util.Date;
import java.util.List;

public class MessageDTO {

    private String messageCode;
    private String messageTitle;
    private String messageContent;
    private Date messageSendDate;
    private String messageReadYn;
    private String messageDeleteYn;
    private Date messageDeleteDate;
    private List<AttachmentDTO> attachment;

    public MessageDTO() {
    }

    public MessageDTO(String messageCode, String messageTitle, String messageContent, Date messageSendDate, String messageReadYn, String messageDeleteYn, Date messageDeleteDate, List<AttachmentDTO> attachment) {
        this.messageCode = messageCode;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.messageSendDate = messageSendDate;
        this.messageReadYn = messageReadYn;
        this.messageDeleteYn = messageDeleteYn;
        this.messageDeleteDate = messageDeleteDate;
        this.attachment = attachment;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageSendDate() {
        return messageSendDate;
    }

    public void setMessageSendDate(Date messageSendDate) {
        this.messageSendDate = messageSendDate;
    }

    public String getMessageReadYn() {
        return messageReadYn;
    }

    public void setMessageReadYn(String messageReadYn) {
        this.messageReadYn = messageReadYn;
    }

    public String getMessageDeleteYn() {
        return messageDeleteYn;
    }

    public void setMessageDeleteYn(String messageDeleteYn) {
        this.messageDeleteYn = messageDeleteYn;
    }

    public Date getMessageDeleteDate() {
        return messageDeleteDate;
    }

    public void setMessageDeleteDate(Date messageDeleteDate) {
        this.messageDeleteDate = messageDeleteDate;
    }

    public List<AttachmentDTO> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<AttachmentDTO> attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "messageDTO{" +
                "messageCode='" + messageCode + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageSendDate=" + messageSendDate +
                ", messageReadYn='" + messageReadYn + '\'' +
                ", messageDeleteYn='" + messageDeleteYn + '\'' +
                ", messageDeleteDate=" + messageDeleteDate +
                ", attachment=" + attachment +
                '}';
    }
}
