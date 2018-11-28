package com.grzeszczyk;

public class Car {
    private Integer id;
    private String name;
    private Double engineCapacity;
    private Integer enginePower;
    private FuelType fuelType;
    private Integer numberOfDoors;
    private Integer numberOfSeats;
    private Integer yearOfProduction;
    private String color;
    private String gearbox;
    private Integer numberVIN;

    public Car(Integer id, String name, Double engineCapacity, Integer enginePower, FuelType fuelType, Integer numberOfDoors, Integer numberOfSeats, Integer yearOfProduction, String color, String gearbox, Integer numberVIN) {
        this.id = id;
        this.name = name;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.yearOfProduction = yearOfProduction;
        this.color = color;
        this.gearbox = gearbox;
        this.numberVIN = numberVIN;
    }

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getNumberVIN() {
        return numberVIN;
    }

    public void setNumberVIN(Integer numberVIN) {
        this.numberVIN = numberVIN;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", enginePower=" + enginePower +
                ", fuelType=" + fuelType +
                ", numberOfDoors=" + numberOfDoors +
                ", numberOfSeats=" + numberOfSeats +
                ", yearOfProduction=" + yearOfProduction +
                ", color='" + color + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", numberVIN=" + numberVIN +
                '}';
    }
}
