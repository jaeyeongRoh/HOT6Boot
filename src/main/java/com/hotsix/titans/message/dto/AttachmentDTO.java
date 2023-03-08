package com.hotsix.titans.message.dto;

import java.util.Date;

public class AttachmentDTO {

    private String attachCode;
    private String attachName;
    private String changeAttachName;
    private String attachRoute;
    private String attachType;
    private Date attachDate;
    private String attachDeleteYn;

    public AttachmentDTO() {
    }

    public String getAttachCode() {
        return attachCode;
    }

    public void setAttachCode(String attachCode) {
        this.attachCode = attachCode;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getChangeAttachName() {
        return changeAttachName;
    }

    public void setChangeAttachName(String changeAttachName) {
        this.changeAttachName = changeAttachName;
    }

    public String getAttachRoute() {
        return attachRoute;
    }

    public void setAttachRoute(String attachRoute) {
        this.attachRoute = attachRoute;
    }

    public String getAttachType() {
        return attachType;
    }

    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    public Date getAttachDate() {
        return attachDate;
    }

    public void setAttachDate(Date attachDate) {
        this.attachDate = attachDate;
    }

    public String getAttachDeleteYn() {
        return attachDeleteYn;
    }

    public void setAttachDeleteYn(String attachDeleteYn) {
        this.attachDeleteYn = attachDeleteYn;
    }

    @Override
    public String toString() {
        return "AttachmentDTO{" +
                "attachCode='" + attachCode + '\'' +
                ", attachName='" + attachName + '\'' +
                ", changeAttachName='" + changeAttachName + '\'' +
                ", attachRoute='" + attachRoute + '\'' +
                ", attachType='" + attachType + '\'' +
                ", attachDate=" + attachDate +
                ", attachDeleteYn='" + attachDeleteYn + '\'' +
                '}';
    }
}
