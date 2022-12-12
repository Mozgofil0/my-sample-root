package my.sample.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"my.sample"})
public class SampleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleWebApplication.class, args);
    }

}
