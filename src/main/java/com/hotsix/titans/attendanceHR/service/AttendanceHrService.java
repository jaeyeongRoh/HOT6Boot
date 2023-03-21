package com.hotsix.titans.attendanceHR.service;

import com.hotsix.titans.attendanceHR.dto.*;
import com.hotsix.titans.attendanceHR.entity.*;
import com.hotsix.titans.attendanceHR.repository.CRUDattendanceHrRepository;
import com.hotsix.titans.attendanceHR.repository.*;

import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.util.FileUploadUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AttendanceHrService {

    private final ModelMapper modelMapper;
    private final CRUDattendanceHrRepository crudAttendanceHrRepository;
    private final EntityManager entityManager;
    private final MemberRepository memberRepository;
    private final MypageSelectAttendanceRepository mypageSelectAttendanceRepository;
    private final AttendanceHrRepository attendanceHrRepository;
    private final AttendanceHrReasonRepository attendanceHrReasonRepository;
    private final MyAttendanceHRRepository myAttendanceHRRepository;

    @Value("src/main/resources/static/files")
    private String FILE_DIR;
    @Value("http://localhost:8888/files/")
    private String FILE_URL;

    @Autowired
    public AttendanceHrService(ModelMapper modelMapper, CRUDattendanceHrRepository crudAttendanceHrRepository, EntityManager entityManager, MemberRepository memberRepository, MypageSelectAttendanceRepository mypageSelectAttendanceRepository, AttendanceHrRepository attendanceHrRepository, AttendanceHrReasonRepository attendanceHrReasonRepository, MyAttendanceHRRepository myAttendanceHRRepository) {
        this.modelMapper = modelMapper;
        this.crudAttendanceHrRepository = crudAttendanceHrRepository;
        this.entityManager = entityManager;
        this.memberRepository = memberRepository;
        this.mypageSelectAttendanceRepository = mypageSelectAttendanceRepository;
        this.attendanceHrRepository = attendanceHrRepository;
        this.attendanceHrReasonRepository = attendanceHrReasonRepository;
        this.myAttendanceHRRepository = myAttendanceHRRepository;
    }

    public List<AttendanceHrDTO> selectAttendance(SelectAttendanceDTO selectAttendanceDTO) {

        TypedQuery<AttendanceHR> query = entityManager.createQuery(
                "SELECT a " +
                        "FROM AttendanceHR a " +
                        "JOIN a.memberAttendance m " +
                        "JOIN m.team t " +
                        "WHERE t.teamCode = :teamCode " +
                        "AND  (:memberName is null OR m.memberName = :memberName) " +
                        "AND a.commuteDate BETWEEN :startDate AND :startDate2 "+
                        "ORDER BY a.commuteDate DESC", AttendanceHR.class);


        query.setParameter("teamCode", selectAttendanceDTO.getTeamCode());
        query.setParameter("memberName", selectAttendanceDTO.getMemberName());
        query.setParameter("startDate", new java.sql.Date(selectAttendanceDTO.getStartDate().getTime()));
        query.setParameter("startDate2", new java.sql.Date(selectAttendanceDTO.getStartDate2().getTime()));

        System.out.println("데이트 테스트"+new java.sql.Date(selectAttendanceDTO.getStartDate().getTime()));
        System.out.println("데이트 테스트"+new java.sql.Date(selectAttendanceDTO.getStartDate2().getTime()));

        List<AttendanceHR> attendanceHR = query.getResultList();
        System.out.println("attendanceHR = " + attendanceHR);


        return attendanceHR.stream()
                .map(attendanceList -> modelMapper.map(attendanceList, AttendanceHrDTO.class))
                .collect(Collectors.toList());
    }

    /*1*/
    /*근태 등록*/    
    @Transactional
    public String attendanceMypageRegistCommute(String commuteStartTime, MemberDTO memberDTO) throws ParseException {


        int result;
        String status;

        /*날짜처리*/
        Date today = new Date(); //현재 시각을 저장
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = dateFormat.parse(commuteStartTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.parse(commuteStartTime, DateTimeFormatter.ISO_DATE_TIME);

        LocalDateTime dateTime = offsetDateTime.atZoneSameInstant(ZoneId.of("Asia/Seoul")).toLocalDateTime();


        /*9시기준  DateTime*/
        OffsetDateTime offsetDateTime2 = OffsetDateTime.parse(commuteStartTime, DateTimeFormatter.ISO_DATE_TIME);

        LocalDateTime dateTime2 = offsetDateTime2.atZoneSameInstant(ZoneId.of("Asia/Seoul")).toLocalDateTime();

        System.out.println("dateTime2 = " + dateTime2);

        /*1분~59분사이에 있을시 올람*/
        System.out.println("dateTime = " + dateTime);

        dateTime = dateTime.plusMinutes((dateTime.getMinute() > 0 && dateTime.getMinute() < 60) ? 60 - dateTime.getMinute() : 0).minusSeconds(dateTime.getSecond());;

        System.out.println("After dateTime = " + dateTime);

        /*시간 테스트용*/
        String commuteStartTime3 = "2023-03-15T23:57:42.580";
        LocalDateTime dateTime3 = LocalDateTime.parse(commuteStartTime3, DateTimeFormatter.ISO_DATE_TIME);




        /*9시 출근전후로 정상출근, 지각 표시*/
        LocalTime workStartTime = LocalTime.of(9, 0);

        if(dateTime.toLocalTime().isBefore(workStartTime)){
            status = "정상 출근";
        } else {
            status =  "지각";
        }





        /*맴버코드 조회*/
        Member member = memberRepository.findByMemberCode(memberDTO.getMemberCode());

        /*로그 처리*/
        System.out.println("memberDTO service = " + memberDTO);
        System.out.println("member = " + member);
        System.out.println("date = " + date);


        /*출근 기록 등록*/
        try {
        CRUDattendanceHR attendanceHR = new CRUDattendanceHR();

//        attendanceHR.setCommuteCode("CM166");
        attendanceHR.setMemberCode(member.getMemberCode()); //사원번호
        attendanceHR.setCommuteStatus(status);              //상태
                                                            //부서
                                                            //직급
                                                            //성명
        attendanceHR.setCommuteDate(today);                 //날짜c
        attendanceHR.setCommuteStartTime(date);             //근무시작시간
        attendanceHR.setCommuteScountTime(dateTime);        //출근시간
                                                            //근무종료시간
                                                            //퇴근시간

              crudAttendanceHrRepository.save(attendanceHR);

              result =1;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return result == 1 ? "출근 등록이 완료 됐습니다." : "실패했습니다.";
    }

    /*2*/
    @Transactional
    /*출근하기 값의 코드에 퇴근하기 등록*/
    public String attendanceMypageRegistFinishCommute(String commuteFinishTime, MemberDTO memberDTO) throws ParseException {

        String status = null;

        int result;

        System.out.println("Finish memberDTO service = " + memberDTO);


        Member member = memberRepository.findByMemberCode(memberDTO.getMemberCode());
        System.out.println("Finish memeber 리스트 = " + member);


        /*날짜처리*/
        Date today = new Date(); //현재 시각을 저장
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = dateFormat.parse(commuteFinishTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.parse(commuteFinishTime, DateTimeFormatter.ISO_DATE_TIME);

        LocalDateTime dateTime = offsetDateTime.atZoneSameInstant(ZoneId.of("Asia/Seoul")).toLocalDateTime();

        /*1분~59분 사이면 내림 처리*/
        dateTime = dateTime.minusMinutes((dateTime.getMinute() > 0 && dateTime.getMinute() < 60) ? dateTime.getMinute() : 0).minusSeconds(dateTime.getSecond());




        /*들어오는 Finish Date 변환*/
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date2 = dateFormat.parse(commuteFinishTime);


        /*18시 퇴근전 조퇴 표시*/
        LocalTime workStartTime = LocalTime.of(18, 0);

        if(dateTime.toLocalTime().isBefore(workStartTime)){
            status = "조퇴";
        }



        LocalDateTime startDateTime = LocalDate.now().atStartOfDay();
        LocalDateTime endDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);

        TypedQuery<SelectAttendanceHR> query = entityManager.createQuery(
                "SELECT a FROM SelectAttendanceHR a " +
                        "WHERE a.memberAttendance.memberCode = :memberCode " +
                        "AND a.commuteDate BETWEEN :startDate AND :endDate",
                SelectAttendanceHR.class
        );

        query.setParameter("memberCode", member.getMemberCode());
        query.setParameter("startDate", startDateTime);
        query.setParameter("endDate", endDateTime);


        List<SelectAttendanceHR> attendanceHR = query.getResultList();

        System.out.println("Finish attendanceHR = " + attendanceHR);

        System.out.println("코드값 출력" + attendanceHR.get(0).getCommuteCode());


        for (SelectAttendanceHR selectAttendanceHR : attendanceHR) {

            CRUDattendanceHR attendanceHREntity = entityManager.find(CRUDattendanceHR.class, attendanceHR.get(0).getCommuteCode());


            attendanceHREntity.setCommuteFinishTime(date2);
            attendanceHREntity.setCommuteFcountTime(dateTime);
            attendanceHREntity.setCommuteTotalTime(dateTime.getHour()-(attendanceHREntity.getCommuteScountTime().getHour()));
            attendanceHREntity.setCommuteStatus(status);


            entityManager.merge(attendanceHREntity);

        }
        result = 1;

        return result == 1 ? "퇴근 등록이 완료 됐습니다." : "실패했습니다.";
    }



    /*3*/
    /*근태 등록 후 조회*/
    public List<SelectAttendanceHrDTO> attendanceMypageSelectRegistCommute(String commuteStartTime, MemberDTO memberDTO) throws ParseException {




        System.out.println("memberDTO service = " + memberDTO);

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dateFormat.parse(commuteStartTime);
//        System.out.println("date = " + date);
        Member member = memberRepository.findByMemberCode(memberDTO.getMemberCode());
        System.out.println("memeber = " + member);
//        AttendanceHR attendanceHR = attendanceHrRepository.findByCommuteDateAndMemberMemberCode(date,member.getMemberCode());


        LocalDateTime startDateTime = LocalDate.now().atStartOfDay();
        LocalDateTime endDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);

        TypedQuery<SelectAttendanceHR> query = entityManager.createQuery(
                "SELECT a FROM SelectAttendanceHR a " +
                        "WHERE a.memberAttendance.memberCode = :memberCode " +
                        "AND a.commuteDate BETWEEN :startDate AND :endDate",
                SelectAttendanceHR.class
        );

        query.setParameter("memberCode", member.getMemberCode());
        query.setParameter("startDate", startDateTime);
        query.setParameter("endDate", endDateTime);


        List<SelectAttendanceHR> attendanceHR = query.getResultList();


        return attendanceHR.stream()
                .map(attendanceList -> modelMapper.map(attendanceList, SelectAttendanceHrDTO.class))
                .collect(Collectors.toList());
    }



    @Transactional
    /*모달 수정*/
    public Object attendanceMypageAttendanceModalSave(SelectAttendanceDTO selectAttendanceDTO) {

        int result;

        CRUDattendanceHR attendanceHREntity = entityManager.find(CRUDattendanceHR.class, selectAttendanceDTO.getCommuteCode());

        try {
            attendanceHREntity.setCommuteStatus(selectAttendanceDTO.getCommuteStatus());
            entityManager.merge(attendanceHREntity);
            result = 1;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while updating attendance: " + e.getMessage());
        }

        return (result == 1) ? "등록성공" : "등록실패" ;
    }

    public List<MypageSelectAttendanceDTO> attendanceMypageFinishRegistCommute(String memberCode) {

        List<MypageSelectAttendance> mypageSelectAttendanceList = mypageSelectAttendanceRepository.findByMemberCode(memberCode);

        return mypageSelectAttendanceList.stream().map(mypageSelectAttendance -> modelMapper.map(mypageSelectAttendance, MypageSelectAttendanceDTO.class)).collect(Collectors.toList());
    }

    public Page<MyAttendanceHR> selectMyAttendance(String memberCode, int page, int size) {

        Sort sort = Sort.by("commuteDate").descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        return myAttendanceHRRepository.findByMemberCode(pageable, memberCode);
    }

    @Transactional
    public Object createReason(AttendanceHrReasonDTO attendanceHrReasonDTO, MultipartFile reasonFile) {

        String changeFileName = UUID.randomUUID().toString().replace("-", "");
        String reasonFileName = null;
        int result = 0;

        try {
            reasonFileName = FileUploadUtils.saveFile(FILE_DIR, changeFileName, reasonFile);

            attendanceHrReasonDTO.setReasonFname(reasonFile.getOriginalFilename());
            attendanceHrReasonDTO.setReasonCname(reasonFileName);
            attendanceHrReasonDTO.setReasonFaddress(FILE_URL);

            AttendanceHrReason attendanceHrReason = modelMapper.map(attendanceHrReasonDTO, AttendanceHrReason.class);

            attendanceHrReasonRepository.save(attendanceHrReason);

        } catch (Exception e) {

            System.out.println("등록 실패입니다 ㅉㅏ식아");
            FileUploadUtils.deleteFile(FILE_DIR, reasonFileName);
            throw new RuntimeException(e);
        }

        return (result > 0) ? "사유서 등록 성공" : "사유서 등록 실패";
    }

    @Transactional
    public AttendanceHrDTO selectFile(String commuteNo) {

        AttendanceHR attendanceHR = attendanceHrRepository.findByCommuteCode(commuteNo);
        AttendanceHrReason attendanceHrReason = attendanceHrReasonRepository.findByCommuteCode(commuteNo);
        attendanceHrReason.setReasonFaddress(FILE_URL + attendanceHrReason.getReasonCname());

        System.out.println("attendanceHR = " + attendanceHR);
        System.out.println("attendanceHrReason.getReasonCname = " + attendanceHrReason.getReasonCname());

        return modelMapper.map(attendanceHR, AttendanceHrDTO.class);

    }




    public MypageAttendanceCheckDTO myPageAttendanceMonth(AttendanceHrDTO attendanceHrDTO) {

        int count1 = 0;
        int count2 = 0;

        Member member = memberRepository.findByMemberCode(attendanceHrDTO.getMemberCode());

        TypedQuery<MyPageSelectAttendanceHR> query = entityManager.createQuery(
                "SELECT a FROM MyPageSelectAttendanceHR a " +
                        "WHERE a.memberAttendance.memberCode = :memberCode " +
                        "AND a.commuteDate BETWEEN :startDate AND :endDate",
                MyPageSelectAttendanceHR.class
        );

        LocalDate now = LocalDate.now();
        int month = now.getMonthValue(); //달 구하기

        LocalDate startDateTime = now.withDayOfMonth(1);  //이번달 시작일
        LocalDate endDateTime =  now.withDayOfMonth(now.lengthOfMonth()); //이번달 막날

        query.setParameter("memberCode", member.getMemberCode());
        query.setParameter("startDate", startDateTime);
        query.setParameter("endDate", endDateTime);

        List<MyPageSelectAttendanceHR> attendanceHR = query.getResultList();


        for(int i =0; i < attendanceHR.size(); i++) {

            if ("정상출근".equals(attendanceHR.get(i).getCommuteStatus())) {
                count1++;
                System.out.println("count 정상출근 갯수 확인 = " + count1);
            }
        }

        for(int i =0; i < attendanceHR.size(); i++) {

            if("지각".equals(attendanceHR.get(i).getCommuteStatus())) {
                count2++;
                System.out.println("count 지각 갯수 확인 = " + count2);
            }
        }

        System.out.println("attendanceHR 결과값 확인 = " + attendanceHR);


        List<MypageAttendanceCheckDTO> mypageAttendanceCheckDTOList = new ArrayList<>();
        MypageAttendanceCheckDTO checkList = new MypageAttendanceCheckDTO();

        checkList.setThisMonth(month);
        checkList.setCountOnTime(count1);
        checkList.setCountLate(count2);

        System.out.println("checkList = " + checkList);


        /* 이번주 일한 시간 구하기*/


        TypedQuery<MyPageSelectAttendanceHR> query2 = entityManager.createQuery(
                "SELECT a FROM MyPageSelectAttendanceHR a " +
                        "WHERE a.memberAttendance.memberCode = :memberCode2 " +
                        "AND a.commuteDate BETWEEN :startDate2 AND :endDate2",
                MyPageSelectAttendanceHR.class
        );

        LocalDate startOfWeek = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)); //이번주 시작일
        LocalDate endOfWeek = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)); //이번주 마지막 일

        System.out.println("startOfWeek = " + startOfWeek);
        System.out.println("endOfWeek = " + endOfWeek);

        query2.setParameter("memberCode2", member.getMemberCode());
        query2.setParameter("startDate2", startOfWeek);
        query2.setParameter("endDate2", endOfWeek);

        List<MyPageSelectAttendanceHR> attendanceHR2 = query2.getResultList();

        System.out.println("attendanceHR2 = " + attendanceHR2);

        int totalTime =0;

        for(int i =0; i < attendanceHR2.size(); i++) {


            totalTime += attendanceHR2.get(i).getCommuteTotalTime();

            System.out.println("total확인 = " + totalTime);
        }

        checkList.setThisWeekTotalTime(totalTime);

        return checkList;
    }
}
