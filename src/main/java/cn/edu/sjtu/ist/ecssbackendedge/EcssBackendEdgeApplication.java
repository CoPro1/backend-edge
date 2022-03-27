package cn.edu.sjtu.ist.ecssbackendedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class EcssBackendEdgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcssBackendEdgeApplication.class, args);
    }

}
