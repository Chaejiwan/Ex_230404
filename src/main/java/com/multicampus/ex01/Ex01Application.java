package com.multicampus.ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //AuditingEntityListener 를 활성화 시키기 위해 설정
public class Ex01Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex01Application.class, args);
    }

}
