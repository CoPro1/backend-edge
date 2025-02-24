package cn.edu.sjtu.ist.ecssbackendedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication()
public class EcssBackendEdgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcssBackendEdgeApplication.class, args);
    }

}
