package tqs.weatherapp2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//import tqs.weatherapp.exception.ResourceNotFoundException;
import java.util.HashMap;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import java.util.List;
        import java.util.Optional;
        import tqs.weatherapp2.model.Forecast;
        import tqs.weatherapp2.repository.ForecastRepo;


/**
 *
 * @author claudio
 */
@Controller
@RequestMapping(path="/api")
public class ForecastController {

    @Autowired
    private ForecastRepo forecastRepo;
    private static final Logger log = LoggerFactory.getLogger(ForecastController.class);
    RestTemplate rt = new RestTemplate();


    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Forecast> getAllForecasts() {
        return forecastRepo.findAll();

    }
    @GetMapping(path="/deleteall")
    public @ResponseBody boolean deleteAll() {
        forecastRepo.deleteAll();
        return true;

    }

    @GetMapping(path="/coord/{lat:-?\\d+(?:\\.\\d+)?}/{lon:-?\\d+(?:\\.\\d+)?}")
    public @ResponseBody Forecast getForecastByCoord(@PathVariable Double lat,
                                                     @PathVariable Double lon)
    {

        Forecast fc = rt.getForObject("https://api.darksky.net/forecast/9c771ff1f84a69d6f4539b004f151dd4/" + lat + "," + lon, Forecast.class);
        forecastRepo.save(fc);
        log.info(fc.toString());
        return fc;
    }
}
