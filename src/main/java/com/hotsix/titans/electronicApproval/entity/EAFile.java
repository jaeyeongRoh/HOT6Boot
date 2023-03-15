package com.hotsix.titans.electronicApproval.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TBL_EA_FILE")
public class EAFile {

    @Id
    @Column(name = "EA_FILE_CODE")
    private String eaFileCode;

    @Column(name = "EA_CODE")
    private String eaCode;

    @Column(name = "EA_FILE_ORIGIN")
    private String eaFileOrigin;

    @Column(name = "EA_FILE_RENAME")
    private String eaFileRename;

    @Column(name = "EA_FILE_UPLOAD_DATE")
    private LocalDate eaFileUploadDate;

    @Column(name = "EA_FILE_SIZE")
    private String eaFileSize;

    @Column(name = "EA_FILE_EXTENTION")
    private String eaFileExtension;

    @Column(name = "EA_FILE_ROUTE")
    private String eaFileRoute;
}
