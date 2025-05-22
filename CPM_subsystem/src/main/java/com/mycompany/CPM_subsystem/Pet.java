package com.mycompany.CPM_subsystem;

public class Pet {
    private String petID;
    private String name;
    private String breed;
    private String size;
    private int age;
    private String allergies;
    private String temperament;
    private boolean isActive;
    private Customer owner;

    // Constructor to initialize pet information
    public Pet(String petID, String name, String breed, String size, int age, String allergies, String temperament, Customer owner) {
        this.petID = petID;
        this.name = name;
        this.breed = breed;
        this.size = size;
        this.age = age;
        this.allergies = allergies;
        this.temperament = temperament;
        this.isActive = true;  // Assume pets are active by default
        this.owner = owner;
    }

    // Getter and Setter methods for all fields
    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    // Methods for managing pet profiles
    public void registerPet() {
        System.out.println("Registering pet: " + name);
    }

    public void updatePetInfo() {
        System.out.println("Updating info for pet: " + name);
    }

    public void deactivateProfile() {
        this.isActive = false;
        System.out.println("Deactivating profile for pet: " + name);
    }

    public void reactivateProfile() {
        this.isActive = true;
        System.out.println("Reactivating profile for pet: " + name);
    }

    // Method to display pet details
    @Override
    public String toString() {
        return "Pet [petID=" + petID + ", name=" + name + ", breed=" + breed + ", size=" + size + ", age=" + age
                + ", allergies=" + allergies + ", temperament=" + temperament + ", isActive=" + isActive + ", owner=" + owner.getName() + "]";
    }
}
