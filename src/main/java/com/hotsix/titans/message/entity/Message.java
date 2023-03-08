package com.hotsix.titans.message.entity;


import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.message.dto.AttachmentDTO;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_MESSAGE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Message {

    @Id
    @Column(name = "MESSAGE_CODE")
    @GeneratedValue(generator = "SEQ_MESSAGE_CODE")
    @GenericGenerator(name = "SEQ_MESSAGE_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "MSG")
            })
    private String messageCode;

    @Column(name = "MESSAGE_TITLE")
    private String messageTitle;

    @Column(name = "MESSAGE_CONTENT")
    private String messageContent;

    @Column(name = "MESSAGE_SEND_DATE")
    private Date messageSendDate;

    @Column(name = "MESSAGE_READ_YN")
    private String messageReadYn;

    @Column(name = "MESSAGE_DELETE_YN")
    private String messageDeleteYn;

    @Column(name = "MESSAGE_DELETE_DATE")
    private Date messageDeleteDate;

    @Column(name = "MEMBER_CODE")
    private String memberCode;



    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MESSAGE_CODE")
    private List<Attachment> attachment;



    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MESSAGE_CODE")
    private List<MessageHistory> messageHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_CODE", referencedColumnName = "MEMBER_CODE", insertable = false, updatable = false)
    private Member member;


    @Override
    public String toString() {
        return "Message{" +
                "messageCode='" + messageCode + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageSendDate=" + messageSendDate +
                ", messageReadYn='" + messageReadYn + '\'' +
                ", messageDeleteYn='" + messageDeleteYn + '\'' +
                ", messageDeleteDate=" + messageDeleteDate +
                ", memberCode='" + memberCode + '\'' +
                ", attachment=" + attachment +
                ", messageHistory=" + messageHistory +
                '}';
    }
}
