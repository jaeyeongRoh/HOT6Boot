package com.hotsix.titans.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/* 엔티티 및 레포지토리 인터페이스를 인식 시켜주기 위해 반드시 필요한 설정!!!(미리 만들어 두자) */
@Configuration
@EntityScan(basePackages = "com.hotsix.titans")  // 인지할 Entity 범위
@EnableJpaRepositories(basePackages = "com.hotsix.titans") // 인지할 repository 범위
public class JpaConfiguration {
}