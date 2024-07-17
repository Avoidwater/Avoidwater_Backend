package GD.avoidWater.external.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "external.weather")
public class WeatherApiProperties {

    private String url;
    private String key;

}
