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


}
