package com.mycompany.CPM_subsystem;

public class Customer {
    private String customerID;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean isActive;

    // Constructor
    public Customer(String customerID, String name, String phoneNumber, String email, String address, boolean isActive) {
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isActive = isActive;
    }

    // Getter and Setter Methods
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Methods for customer management
    public void registerCustomer() {
        System.out.println("Customer " + name + " registered successfully.");
    }

    public void updateCustomerInfo(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        System.out.println("Customer info updated.");
    }

    public void deactivateProfile() {
        isActive = false;
        System.out.println("Customer " + name + "'s profile deactivated.");
    }

    public void reactivateProfile() {
        isActive = true;
        System.out.println("Customer " + name + "'s profile reactivated.");
    }

    // toString method for displaying customer details
    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + name + ", Email: " + email + ", Active: " + isActive;
    }
}
