/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tqs.weatherapp2.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;

import static javax.persistence.CascadeType.*;

/**
 *
 * @author claudio
 */

@Entity
public class Forecast {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Double latitude, longitude;

    @Column(length = 3000)
    private HashMap<String, Object> currently;


    @OneToOne(cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    private DailyDetails daily;

    protected Forecast(){
    }

    public Forecast(Double latitude, Double longitude,
                    HashMap<String, Object> currently,
                    DailyDetails daily){

        this.latitude = latitude;
        this.longitude = longitude;
        this.currently = currently;
        this.daily = daily;

    }


    @Override
    public String toString() {
        return "Forecast {" +
                "Latitude: " + getLatitude() + '\'' +
                "Longitude: '" + getLongitude() + '\'' +
                "Currently: " + getCurrently() +
                '}';
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }



    /**
     * @return the currently
     */
    public Map<String, Object> getCurrently() {
        return currently;
    }



    /**
     * @return the daily
     */
    public DailyDetails getDaily() {
        return daily;
    }

}