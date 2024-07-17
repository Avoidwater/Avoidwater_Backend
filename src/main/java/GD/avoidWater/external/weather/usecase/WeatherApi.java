package GD.avoidWater.external.weather.usecase;

import GD.avoidWater.external.properties.WeatherApiProperties;
import GD.avoidWater.external.weather.usecase.data.response.WeatherResponse;
import GD.avoidWater.external.webclient.WebClientSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class WeatherApi {

    private final WebClientSupport webClientSupport;
    private final WeatherApiProperties properties;

    public WeatherResponse get(
            double latitude,
            double longitude,
            int hour
    ) {
        String url = properties.getUrl() + "?";
        //1. key
        url += ("key=" + properties.getKey());
        //2. q
        url += ("&q=" + latitude + "," + longitude);
        //3. hour
        url += ("&hour=" + hour);
        //4. lang
        url += ("&lang=" + "ko");

        /*
        Map<String, Object> result = webClientSupport.get(url, Map.class).block();

        for(Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue().toString());
        }*/

        return webClientSupport.get(url, WeatherResponse.class).block();
    }

}
