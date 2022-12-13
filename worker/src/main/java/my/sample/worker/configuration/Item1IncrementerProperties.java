package my.sample.worker.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "my-sample.worker.item1-incrementer")
public class Item1IncrementerProperties {
    private long id;
    private int delta;
}
