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

    protected Weather(){
    }
    public Weather(Double temperatureHigh, Double temperatureLow, Double windSpeed, Double precipProbability, DailyDetails daily) {
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.windSpeed = windSpeed;
        this.precipProbability = precipProbability;
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




}


