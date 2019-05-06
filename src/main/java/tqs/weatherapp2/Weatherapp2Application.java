package tqs.weatherapp2;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;
import tqs.weatherapp2.controller.ForecastController;

@SpringBootApplication
@RunWith(SpringRunner.class)
public class Weatherapp2Application {

    public static void main(String[] args) {
        SpringApplication.run(Weatherapp2Application.class, args);
    }

    @Mock
    private ForecastController fc;


}
