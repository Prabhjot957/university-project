package com.mycompany.CPM_subsystem;

import java.util.List;
import java.util.ArrayList;

public class SearchService {

    // List to store customer data for searching (for simplicity, using in-memory storage)
    private List<Customer> customers = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    // Constructor to initialize search service with customer and pet lists
    public SearchService(List<Customer> customers, List<Pet> pets) {
        this.customers = customers;
        this.pets = pets;
    }

    // Search for a customer by name, phone, or email
    public Customer searchCustomer(String name, String phone, String email) {
        for (Customer customer : customers) {
            if ((name != null && customer.getName().equalsIgnoreCase(name)) ||
                (phone != null && customer.getPhoneNumber().equals(phone)) ||
                (email != null && customer.getEmail().equalsIgnoreCase(email))) {
                return customer;
            }
        }
        return null;  // Return null if no customer is found
    }

    // Search for a pet by name, breed, or owner
    public Pet searchPet(String name, String breed, Customer customer) {
        for (Pet pet : pets) {
            if ((name != null && pet.getName().equalsIgnoreCase(name)) ||
                (breed != null && pet.getBreed().equalsIgnoreCase(breed)) ||
                (customer != null && pet.getOwner().equals(customer))) {
                return pet;
            }
        }
        return null;  // Return null if no pet is found
    }

    // Prevent duplicate customer entries in the list
    public boolean preventDuplicateCustomerEntry(Customer customer) {
        for (Customer c : customers) {
            if (c.getEmail().equalsIgnoreCase(customer.getEmail()) || 
                c.getPhoneNumber().equals(customer.getPhoneNumber())) {
                System.out.println("Duplicate entry detected for customer: " + customer.getName());
                return false;  // Return false if duplicate is found
            }
        }
        customers.add(customer);  // Add the new customer if no duplicate
        return true;
    }

    // Prevent duplicate pet entries in the list
    public boolean preventDuplicatePetEntry(Pet pet) {
        for (Pet p : pets) {
            if (p.getPetID().equals(pet.getPetID())) {
                System.out.println("Duplicate pet entry detected for pet: " + pet.getName());
                return false;  // Return false if duplicate is found
            }
        }
        pets.add(pet);  // Add the new pet if no duplicate
        return true;
    }
}
