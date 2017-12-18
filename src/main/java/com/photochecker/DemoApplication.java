package com.photochecker;

import com.photochecker.filters.RoleFilter;
import com.photochecker.filters.SessionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackageClasses = {RoleFilter.class, SessionFilter.class})
@SpringBootApplication
@EnableAutoConfiguration

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
