package GD.avoidWater.weather.usecase.data.response;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class WeatherResponse {

    private Location location;
    private Current current;

    @Getter
    @NoArgsConstructor
    static class Location {
        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;
        private String tz_id;
        private long localtime_epoch;
        private String localtime;
    }

    @Getter
    @NoArgsConstructor
    static class Current {
        private long last_updated_epoch;
        private String last_updated;
        private double temp_c;
        private double temp_f;
        private int is_day;
        private Condition condition;
        private double wind_mph;
        private double wind_kph;
        private int wind_degree;
        private String wind_dir;
        private int pressure_mb;
        private double pressure_in;
        private double precip_mm;
        private double precip_in;
        private int humidity;
        private int cloud;
        private double feelslike_c;
        private double feelslike_f;
        private double windchill_c;
        private double windchill_f;
        private double heatindex_c;
        private double heatindex_f;
        private double dewpoint_c;
        private double dewpoint_f;
        private int vis_km;
        private int vis_miles;
        private int uv;
        private double gust_mph;
        private double gust_kph;

        @Getter
        @NoArgsConstructor
        static class Condition {
            private String text;
            private String icon;
            private int code;
        }
    }

}