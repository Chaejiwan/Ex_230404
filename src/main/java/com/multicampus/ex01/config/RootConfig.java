package com.multicampus.ex01.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configration 이용해서 해당 클래스가 스프링 설정 클래스임을 명시하고 ModelMapper를 스프링빈으로 설정한다.
@Configuration
public class RootConfig {

    @Bean
    public ModelMapper getMapper(){
        ModelMapper  modelMapper = new ModelMapper();
                 modelMapper.getConfiguration()
                         .setFieldMatchingEnabled(true)
                         .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                         .setMatchingStrategy(MatchingStrategies.STRICT);


        return modelMapper;
    }


}
