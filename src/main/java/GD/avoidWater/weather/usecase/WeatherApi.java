package GD.avoidWater.weather.usecase;

import GD.avoidWater.external.properties.WeatherApiProperties;
import GD.avoidWater.weather.usecase.data.response.WeatherResponse;
import GD.avoidWater.external.webclient.WebClientSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


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

        return webClientSupport.get(url, WeatherResponse.class).block();
    }

}

//http://101.101.209.184:33334/weather?latitude=35.85548176&longitude=128.6375875&hour=20