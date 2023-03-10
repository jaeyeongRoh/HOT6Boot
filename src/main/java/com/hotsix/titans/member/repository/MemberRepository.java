package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByMemberCode(String string);

    List<Member> findByWorkingStatus(String workingStatus);

    List<Member> findByMemberNameContaining(String string);

    Member findByMemberName(String memberName);


//
//    Member findByMemberEmail(String memberEmail);
//
//    /* jpql과 @Query를 활용한 구문 */
//    @Query("SELECT MAX(a.memberCode) FROM Member a")	// jpql에서 엔티티 이름은 대소문자까지 완벽히 일치할 것
//    String maxMemberCode();
//
//    /* purchase 도메인 추가하면서 추가한 메소드 */
//    @Query("SELECT a.memberCode FROM Member a WHERE a.memberCode = ?1")
//    int findMemberCodeByMemberCode(String orderMemberCode);
}
