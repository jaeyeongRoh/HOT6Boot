package com.hotsix.titans.electronicApproval.dto;


import lombok.*;


import java.sql.Date;
import java.time.LocalDate;


@Getter
@Setter

public class EALeaveDTO extends EADocumentDTO {

    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;

    public EALeaveDTO(String eaCode, String memberDraft, String memberMiddleSigner, String memberFinalSigner, String eaSubject, String eaDetail, String eaCategory, String eaType, LocalDate eaDate, Integer eaDraftStatus, Integer eaMiddleStatus, String eaMiddleComment, Integer eaFinalStatus, String eaFinalComment, Integer eaDocuStatus, String isDeleted, LocalDate leaveStartDate, LocalDate leaveEndDate) {
        super(eaCode, memberDraft, memberMiddleSigner, memberFinalSigner, eaSubject, eaDetail, eaCategory, eaType, eaDate, eaDraftStatus, eaMiddleStatus, eaMiddleComment, eaFinalStatus, eaFinalComment, eaDocuStatus, isDeleted);
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
    }

    public EALeaveDTO(LocalDate leaveStartDate, LocalDate leaveEndDate) {
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
    }

    public EALeaveDTO() {
    }

    @Override
    public String toString() {
        return super.toString()+"EALeaveDTO{" +
                "leaveStartDate=" + leaveStartDate +
                ", leaveEndDate=" + leaveEndDate +
                '}';
    }
}