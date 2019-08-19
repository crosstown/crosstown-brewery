package net.fernandosimon.crosstownbrewery.services;

import lombok.extern.slf4j.Slf4j;
import net.fernandosimon.crosstownbrewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-13
 * @time 21:15
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("Pepe Honguito")
                .build();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("Fernando Weston")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        //todo impl
        log.debug("Updating customer...");
    }

    @Override
    public void deleteCustomerById(UUID customerId) {

        log.debug("Deleting a beer...");
    }


}
