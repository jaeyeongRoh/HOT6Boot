package com.hotsix.titans.member.entity;

import com.hotsix.titans.salary.entity.Severance;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_RETIREE")
public class Retiree {

    @Id
    @Column(name = "RETIREE_CODE")
    private String retireeCode;             // 퇴직번호

    @Column(name = "RETIREE_DATE")
    private Date retireeDate;               // 퇴직일

    @OneToOne
    @JoinColumn(name = "SEVERANCE_CODE")
    private Severance severance;

    public Retiree() {
    }

    public Retiree(String retireeCode, Date retireeDate) {
        this.retireeCode = retireeCode;
        this.retireeDate = retireeDate;
    }

    public Retiree(String retireeCode, Date retireeDate, Severance severance) {
        this.retireeCode = retireeCode;
        this.retireeDate = retireeDate;
        this.severance = severance;
    }

    public String getRetireeCode() {
        return retireeCode;
    }

    public void setRetireeCode(String retireeCode) {
        this.retireeCode = retireeCode;
    }

    public Date getRetireeDate() {
        return retireeDate;
    }

    public void setRetireeDate(Date retireeDate) {
        this.retireeDate = retireeDate;
    }

    public Severance getSeverance() {
        return severance;
    }

    public void setSeverance(Severance severance) {
        this.severance = severance;
    }

    @Override
    public String toString() {
        return "Retiree{" +
                "retireeCode='" + retireeCode + '\'' +
                ", retireeDate=" + retireeDate +
                ", severance=" + severance +
                '}';
    }
}
