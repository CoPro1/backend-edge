package cn.edu.sjtu.ist.ecssbackendedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages = {"cn.edu.sjtu.ist.ecssbackendedge", "com.github.yeecode.objectlogger"})
public class EcssBackendEdgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcssBackendEdgeApplication.class, args);
    }

}
