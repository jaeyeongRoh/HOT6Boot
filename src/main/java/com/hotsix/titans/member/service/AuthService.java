package com.hotsix.titans.member.service;


import com.hotsix.titans.exception.LoginFailedException;
import com.hotsix.titans.jwt.TokenProvider;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.TokenDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.member.repository.TeamRoleRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final ModelMapper modelMapper;
    private final TeamRoleRepository teamRoleRepository;

    @Autowired
    public AuthService(MemberRepository memberRepository, PasswordEncoder passwordEncoder
            , TokenProvider tokenProvider, ModelMapper modelMapper
            , TeamRoleRepository teamRoleRepository) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.modelMapper = modelMapper;
        this.teamRoleRepository = teamRoleRepository;
    }

    public Object login(MemberDTO memberDTO) {
        log.info("[AuthService] Login Start ======================================");
        log.info("[AuthService] {}", memberDTO);

        log.info("'''''''''''''''''''''' " + memberDTO.getMemberCode());
        String memberCode = memberDTO.getMemberCode();
        /* 1. 사번 조회 */
        Member member = memberRepository.findByMemberCode(memberCode);
        log.info("++++++++++++ ");
        System.out.println("=======" + member);
        if (member == null) {
            throw new LoginFailedException(memberDTO.getMemberCode() + "를 찾을 수 없습니다.");
        }

        /* 2. 비밀번호 매칭(BCrypt 암호화 라이브러리 bean을 의존성 주입받아 처리하는 부분부터 security 설정 부분을 추가해 보자.) */
        /* matches(평문, 다이제스트) */
        if (!passwordEncoder.matches(memberDTO.getMemberPassword(), member.getMemberPassword())) {
            log.info("[AuthService] Password Match Fail!!!");
            throw new LoginFailedException("잘못된 비밀번호 입니다.");
        }

        /* 3. 토큰 발급 */
        TokenDTO tokenDTO = tokenProvider.generateTokenDTO(member);
        log.info("[AuthService] tokenDTO {}", tokenDTO);

        log.info("[AuthService] Login End ======================================");
        return tokenDTO;
    }
}
