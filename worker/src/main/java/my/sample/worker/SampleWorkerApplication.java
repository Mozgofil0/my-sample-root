package my.sample.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"my.sample"})
@ConfigurationPropertiesScan(basePackages = {"my.sample"})
@EnableScheduling
public class SampleWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleWorkerApplication.class, args);
    }

}
