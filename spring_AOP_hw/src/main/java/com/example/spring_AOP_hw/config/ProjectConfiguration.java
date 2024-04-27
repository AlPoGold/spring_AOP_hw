package com.example.spring_AOP_hw.config;

import com.example.spring_AOP_hw.aspect.TrackUserAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public TrackUserAspect aspect(){
        return new TrackUserAspect();
    }
}
