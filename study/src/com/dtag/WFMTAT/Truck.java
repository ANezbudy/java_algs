package com.dtag.WFMTAT;

public class Truck extends Vehicle {
    private double capacity;

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    // 2. Напишите конструкторы для Truck и для Car, которые принимают на вход вес и цвет
    // constructor
    public Truck(double weight, int color) {
        super(weight, color);
    }

    public Truck(double weight, double width, double height, double length) {
        super(weight);
        this.setWidth(width);
        this.setHeight(height);
        this.setLength(length);
    }

    // 3. Напишите конструкторы для Truck и для Car, котоыре принимают на вход только вес, а цвет определяют самостоятельно

    public Truck(double weight) {
        super(weight);
    }

    /*
    7. Переопределите в Truck и Car метод aPrint так, чтобы выводилось то-же самое, что и для Vehicle, а также,
    для грузовика capacity, а для легковушки numOfPassengers
     */

    @Override
    public void aPrint() {
        super.aPrint();
        System.out.println("capacity: " + this.getCapacity());
    }
}
