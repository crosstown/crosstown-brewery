package net.fernandosimon.crosstownbrewery.services;

import net.fernandosimon.crosstownbrewery.web.model.CustomerDTO;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-13
 * @time 21:14
 */
public interface CustomerService {

    CustomerDTO getCustomerById(UUID customerId);

    CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

    void updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomerById(UUID customerId);
}
