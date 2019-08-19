package net.fernandosimon.crosstownbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.fernandosimon.crosstownbrewery.services.BeerService;
import net.fernandosimon.crosstownbrewery.web.model.BeerDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * @author developer
 * @date 2019-08-15
 * @time 17:03
 */
public class BeerControlerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mocMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDTO validBeer;

    @Before
    public void setup() {
        validBeer = BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("PALE ALE")
                .upc(123456789012L)
                .build();
    }

    @Test
    public void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mocMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Beer1")));
    }
}
