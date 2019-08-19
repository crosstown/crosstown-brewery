package net.fernandosimon.crosstownbrewery.web.controller;

import net.fernandosimon.crosstownbrewery.services.BeerService;
import net.fernandosimon.crosstownbrewery.web.model.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-13
 * @time 20:50
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId) {

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDTO beerDTO) {

        BeerDTO savedDTO = beerService.saveNewBeer(beerDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        // todo add hostname to url
        httpHeaders.add("Location", "/api/v1/beer/" + savedDTO.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId")
    public ResponseEntity handleUpdate(@PathVariable UUID beerId, BeerDTO beerDTO) {

        beerService.updateBeer(beerId, beerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId) {
        beerService.deleteBeerById(beerId);
    }

}
