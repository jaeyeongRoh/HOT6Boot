package com.hotsix.titans.message.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TBL_MESSAGE_ATTACHMENT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Attachment {

    @Id
    @Column(name ="ATTACH_CODE")
    private String attachCode;

    @Column(name ="ATTACH_NAME")
    private String attachName;

    @Column(name ="CHANGE_ATTACH_NAME")
    private String changeAttachName;

    @Column(name ="ATTACH_ROUTE")
    private String attachRoute;

    @Column(name ="ATTACH_TYPE")
    private String attachType;

    @Column(name ="ATTACH_DATE")
    private Date attachDate;

    @Column(name ="ATTACH_DELETE_YN")
    private String attachDeleteYn;

    /*FK*/
    @Column(name = "MESSAGE_CODE")
    private String messageCode;


}
