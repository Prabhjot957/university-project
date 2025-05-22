package com.mycompany.CPM_subsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        
        // Sample customer and pet lists
        List<Customer> customerList = new ArrayList<>();
        List<Pet> petList = new ArrayList<>();

        // Input for customer
        System.out.println("Enter customer details:");
        System.out.print("Customer ID: ");
        String customerID = scanner.nextLine();
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Is customer active (true/false): ");
        boolean isActive = Boolean.parseBoolean(scanner.nextLine());
        
        Customer customer1 = new Customer(customerID, name, phoneNumber, email, address, isActive);
        customerList.add(customer1);

        // Input for pet
        System.out.println("\nEnter pet details:");
        System.out.print("Pet ID: ");
        String petID = scanner.nextLine();
        
        System.out.print("Pet Name: ");
        String petName = scanner.nextLine();
        
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        
        System.out.print("Size: ");
        String size = scanner.nextLine();
        
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Allergies: ");
        String allergies = scanner.nextLine();
        
        System.out.print("Temperament: ");
        String temperament = scanner.nextLine();
        
        Pet pet1 = new Pet(petID, petName, breed, size, age, allergies, temperament, customer1);
        petList.add(pet1);

        // Initialize SearchService with customer and pet lists
        SearchService searchService = new SearchService(customerList, petList);

        // Grooming record example
        Date groomingDate = new Date();  // Use current date for grooming
        GroomingRecord record = new GroomingRecord("GR001", groomingDate, "Full Groom", "Cleaned and styled the pet");
        record.viewGroomingHistory();
        
        // Search for a customer
        System.out.println("\nSearch for a customer:");
        System.out.print("Enter customer name: ");
        String searchCustomerName = scanner.nextLine();
        Customer foundCustomer = searchService.searchCustomer(searchCustomerName, null, null);
        
        if (foundCustomer != null) {
            System.out.println("Found customer: " + foundCustomer.getName());
        } else {
            System.out.println("Customer not found.");
        }

        // Search for a pet
        System.out.println("\nSearch for a pet:");
        System.out.print("Enter pet name: ");
        String searchPetName = scanner.nextLine();
        Pet foundPet = searchService.searchPet(searchPetName, null, customer1);
        
        if (foundPet != null) {
            System.out.println("Found pet: " + foundPet.getName());
        } else {
            System.out.println("Pet not found.");
        }

        // Preventing duplicate customer entry
        System.out.println("\nAttempting to add a new customer...");
        System.out.print("Enter new customer name: ");
        String newCustomerName = scanner.nextLine();
        
        System.out.print("Enter new customer phone number: ");
        String newCustomerPhone = scanner.nextLine();
        
        System.out.print("Enter new customer email: ");
        String newCustomerEmail = scanner.nextLine();
        
        Customer newCustomer = new Customer("C003", newCustomerName, newCustomerPhone, newCustomerEmail, "789 Pet Ln", true);
        boolean customerAdded = searchService.preventDuplicateCustomerEntry(newCustomer);
        if (customerAdded) {
            System.out.println("New customer registered successfully.");
        } else {
            System.out.println("Duplicate customer entry detected.");
        }

        // Preventing duplicate pet entry
        System.out.println("\nAttempting to add a new pet...");
        System.out.print("Enter pet name for new pet: ");
        String newPetName = scanner.nextLine();
        
        Pet newPet = new Pet("P003", newPetName, "Labrador", "Medium", 4, "None", "Friendly", customer1);
        boolean petAdded = searchService.preventDuplicatePetEntry(newPet);
        if (petAdded) {
            System.out.println("New pet registered successfully.");
        } else {
            System.out.println("Duplicate pet entry detected.");
        }

        // Close scanner to avoid resource leak
        scanner.close();
    }
}
