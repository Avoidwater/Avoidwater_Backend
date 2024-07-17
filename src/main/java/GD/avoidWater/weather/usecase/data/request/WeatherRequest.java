package GD.avoidWater.weather.usecase.data.request;

public record WeatherRequest(
        double latitude,
        double longitude,
        int hour
) {
}
