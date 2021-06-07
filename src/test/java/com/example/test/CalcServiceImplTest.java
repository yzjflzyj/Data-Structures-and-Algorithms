package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import com.example.test.springTest.aopDemo.service.CalcService;

@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CalcServiceImplTest {

    @Autowired
    CalcService calcService;

    @Test
    public void divTest(){
        System.out.println(String.format("Spring Verision : %s, Sring Boot Version : %s.", //
                SpringVersion.getVersion(), SpringBootVersion.getVersion()));
        System.out.println();
        //calcService.div(1, 2);
        calcService.div(1, 0);
    }
}
