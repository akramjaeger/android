package com.example.mini_projet;

public class Car {
    private String id; // Unique identifier
    private String name; // Name of the car
    private String type; // Type of car (e.g., Sedan, SUV)
    private double pricePerDay; // Price per day to rent the car

    // Default constructor required for Firebase
    public Car() {
    }

    // Parameterized constructor
    public Car(String id, String name, String type, double pricePerDay) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
