package GD.avoidWater.external.weather;

import GD.avoidWater.external.weather.usecase.WeatherApi;
import GD.avoidWater.external.weather.usecase.data.response.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/weather")
@Slf4j
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherApi api;

    @GetMapping
    public WeatherResponse get(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("hour") int hour
    ) {
        log.info("latitude : {}", latitude);
        log.info("longitude : {}", longitude);
        log.info("hour : {}", hour);
        return api.get(
                latitude,
                longitude,
                hour
        );
    }
}

//precip_mm : 강수량(mm단위)
