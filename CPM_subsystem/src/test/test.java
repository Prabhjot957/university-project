package com.mycompany.CPM_subsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class SearchServiceTest {

    private List<Customer> customerList;
    private List<Pet> petList;
    private SearchService searchService;

    @BeforeEach
    void setUp() {
        // Sample customers and pets for the test cases
        Customer customer1 = new Customer("C001", "John Doe", "123456789", "john@example.com", "123 Pet St", true);
        Customer customer2 = new Customer("C002", "Jane Smith", "987654321", "jane@example.com", "456 Pet Ave", true);

        Pet pet1 = new Pet("P001", "Fluffy", "Poodle", "Medium", 3, "None", "Friendly", customer1);
        Pet pet2 = new Pet("P002", "Max", "Bulldog", "Large", 5, "None", "Loyal", customer2);

        // Initialize customer and pet lists
        customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        // Initialize the SearchService
        searchService = new SearchService(customerList, petList);
    }

    @Test
    void testSearchCustomerByName() {
        Customer foundCustomer = searchService.searchCustomer("John Doe", null, null);
        assertNotNull(foundCustomer);
        assertEquals("John Doe", foundCustomer.getName());
    }

    @Test
    void testSearchCustomerByEmail() {
        Customer foundCustomer = searchService.searchCustomer(null, null, "jane@example.com");
        assertNotNull(foundCustomer);
        assertEquals("Jane Smith", foundCustomer.getName());
    }

    @Test
    void testSearchPetByName() {
        Pet foundPet = searchService.searchPet("Fluffy", null, null);
        assertNotNull(foundPet);
        assertEquals("Fluffy", foundPet.getName());
    }

    @Test
    void testSearchPetByBreed() {
        Pet foundPet = searchService.searchPet(null, "Bulldog", null);
        assertNotNull(foundPet);
        assertEquals("Max", foundPet.getName());
    }

    @Test
    void testPreventDuplicateCustomerEntry() {
        Customer newCustomer = new Customer("C003", "Alex", "555123456", "alex@example.com", "789 Pet Ln", true);
        boolean customerAdded = searchService.preventDuplicateCustomerEntry(newCustomer);
        assertTrue(customerAdded);
    }
}
