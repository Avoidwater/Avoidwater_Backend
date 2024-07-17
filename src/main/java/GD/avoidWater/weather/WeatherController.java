package GD.avoidWater.weather;

import GD.avoidWater.weather.usecase.WeatherApi;
import GD.avoidWater.weather.usecase.data.response.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/weather")
@Slf4j
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherApi api;

    @PostMapping
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
//http://101.101.209.184:33334/weather?latitude=35.85548176&longitude=128.6375875&hour=21
//http://101.101.209.184:33334/weather?latitude=35.8714354&longitude=128.601445&hour=21