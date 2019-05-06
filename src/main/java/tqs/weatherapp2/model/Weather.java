package tqs.weatherapp2.model;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double temperatureHigh;
    private Double temperatureLow;
    private Double windSpeed;



    private Double precipProbability;
    @ManyToOne(cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    private DailyDetails daily;
    protected Weather(){
    }
    public Weather(Double temperatureHigh, Double temperatureLow, Double windSpeed, Double precipProbability, DailyDetails daily) {
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.windSpeed = windSpeed;
        this.precipProbability = precipProbability;
        this.daily = daily;
    }

    public Double getTemperatureHigh() {
        return temperatureHigh;
    }

    public Double getTemperatureLow() {
        return temperatureLow;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Double getPrecipProbability() {
        return precipProbability;
    }

    public DailyDetails getDaily() {
        return daily;
    }

    public Weather(Double temperatureHigh, Double temperatureLow, Double windSpeed, Double precipProbability) {
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.windSpeed = windSpeed;
        this.precipProbability = precipProbability;
    }
}


