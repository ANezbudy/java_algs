package com.dtag.WFMTAT;

public class Car extends Vehicle {
    private int numOfPassangers;

    public int getNumOfPassangers() {
        return numOfPassangers;
    }

    public void setNumOfPassangers(int numOfPassangers) {
        this.numOfPassangers = numOfPassangers;
    }

    // 2. Напишите конструкторы для Truck и для Car, которые принимают на вход вес и цвет
    // constructor
    public Car(double weight, int color) {
        super(weight,color);
    }

    // 3. Напишите конструкторы для Truck и для Car, котоыре принимают на вход только вес, а цвет определяют самостоятельно
    public Car(double weight) {
        super(weight);
    }

    public Car(double weight, double width, double height, double length) {
        super(weight);
        this.setWidth(width);
        this.setHeight(height);
        this.setLength(length);
    }


    /*
    7. Переопределите в Truck и Car метод aPrint так, чтобы выводилось то-же самое, что и для Vehicle, а также,
    для грузовика capacity, а для легковушки numOfPassengers
     */

    @Override
    public void aPrint() {
        super.aPrint();
        System.out.println("Number Of Passangers: " + this.getNumOfPassangers());
    }
}
