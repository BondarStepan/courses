package com.iba.courses;

import com.iba.courses.service.ImsConnectionService;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class CoursesApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CoursesApplication.class, args);
        ImsConnectionService ims = new ImsConnectionService();
        ims.init();
        ims.connect();
        System.out.println(ims.execute("/DIS TRAN ADDINV"));
}

}
