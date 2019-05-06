/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.weatherapp2.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

/**
 *
 * @author claudio
 */

@Entity
public class DailyDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String summary;
    private String icon;
    @OneToMany(cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    private List<Weather> data;

    protected DailyDetails(){
    }


    public DailyDetails(String summary, String icon, Double temperatureHigh, Double temperatureLow, Double windSpeed, List<Weather> data){
        this.summary = summary;
        this.icon = icon;
        this.data = data;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }
    public List<Weather> getData() {
        return data;
    }


    @Override
    public String toString() {
        return "DailyDetails{" +
                "summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", weatherDetails=" + data +
                '}';
    }
}
