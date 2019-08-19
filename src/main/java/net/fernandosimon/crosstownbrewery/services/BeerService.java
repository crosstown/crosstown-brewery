package net.fernandosimon.crosstownbrewery.services;

import net.fernandosimon.crosstownbrewery.web.model.BeerDTO;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-13
 * @time 20:59
 */
public interface BeerService {

    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteBeerById(UUID beerId);
}
