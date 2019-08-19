package net.fernandosimon.crosstownbrewery.services;

import lombok.extern.slf4j.Slf4j;
import net.fernandosimon.crosstownbrewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-13
 * @time 21:02
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        //todo impl - would add a real impl to update a beer
    }

    @Override
    public void deleteBeerById(UUID beerId) {

        log.debug("Deleting a beer...");
    }
}
