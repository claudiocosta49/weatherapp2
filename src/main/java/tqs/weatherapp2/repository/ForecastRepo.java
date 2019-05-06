/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.weatherapp2.repository;
import tqs.weatherapp2.model.Forecast;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author claudio
 */
public interface ForecastRepo extends CrudRepository<Forecast, Double> {

    boolean existsByLatitudeAndLongitude(Double latitude, Double longitude);
    List<Forecast> findByLatitudeAndLongitude(Double latitude, Double longitude);

}
