/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.CPM_subsystem;

public class main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Pet pet = new Pet();
        GroomingRecord record = new GroomingRecord();
        SearchService search = new SearchService();

        // Just call the methods (they don't do anything yet)
        customer.registerCustomer();
        pet.registerPet();
        record.viewGroomingHistory();
        search.searchCustomer("prabhjyot", "123456", "john@example.com");
    }
}

