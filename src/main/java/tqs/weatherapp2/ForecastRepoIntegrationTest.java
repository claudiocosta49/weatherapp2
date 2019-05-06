package tqs.weatherapp2;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import tqs.weatherapp2.model.Forecast;
import tqs.weatherapp2.repository.ForecastRepo;
import static org.assertj.core.api.Java6Assertions.assertThat;



@RunWith(SpringRunner.class)
@DataJpaTest
public class ForecastRepoIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ForecastRepo ForecastRepo;

    @Test
    public void whenFindByCoord_thenReturnForecast() {
        // given
        Forecast fc = new Forecast(10.1010, 30.3030);
        entityManager.persist(fc);
        entityManager.flush();

        // when
        Forecast found = ForecastRepo.findByLatitudeAndLongitude(fc.getLatitude(), fc.getLongitude());

        // then
        assertThat(found.getLatitude())
                .isEqualTo(fc.getLatitude());

        assertThat(found.getLongitude())
                .isEqualTo(fc.getLongitude());

    }



}
