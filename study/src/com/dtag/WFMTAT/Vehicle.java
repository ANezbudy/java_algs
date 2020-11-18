package com.dtag.WFMTAT;

import java.util.ArrayList;

public class Vehicle implements Measurable {
    private int position;
    private double weight;
    private double speed;
    private int color;
    private double length;
    private double width;
    private double height;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSpeed () {
        return speed;
    }

    public void setSpeed (double speed) {
        this.speed = speed;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }



    public Vehicle(double weight, int color) {
        setWeight(weight);
        this.setColor(color);
    }

    public Vehicle(double weight) {
        this(weight, (int) (Math.random()*10));
    }

    // Классы и объекты 2

    //1. Сделайте метод, который печатает в консоль тип и цвет каждого Vehicle в массиве, который поступает на вход

    public static void printVehicles(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println("The type of the vehicle is " + vehicle.getType() + " and the color is " + vehicle.getColor());
        }
    }

    /* 4. Напишите метод, который создает массив Vehicle длинны n и заполняет его, выбирая тип, вес и цвет случайным образом.
    Цвет в диапазоне от 1 до 10, тип - Truck или Car, вес для Car от 500 до 1500, для Truck от 2000 до 10000
     */

    public static Vehicle[] vehiclesFactory(int n) {
        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < vehicles.length; i++) {
            int type = (int) (Math.random()*2 + 1);
            int color = (int) (Math.random()*10 + 1);

            if (type == 1) {
                double weight = (Math.random()*1001) + 500;
                vehicles[i] = new Car(weight, color);
            }

            if (type == 2) {
                double weight = (Math.random()*8001) + 2000;
                vehicles[i] = new Truck(weight, color);
            }
        }

        return vehicles;
    }

    public static Measurable[] measurablesFactory(int n) {
        Measurable[] measurables = new Measurable[n];

        for (int i = 0; i < measurables.length; i++) {
            int type = (int) (Math.random()*2 + 1);
            int color = (int) (Math.random()*10 + 1);
            int width = (int) (Math.random()*3 + 1);
            int height = (int) (Math.random()*5 + 1);
            int length = (int) (Math.random()*3 + 1);


            if (type == 1) {
                double weight = (Math.random()*3001) + 1000;
                measurables[i] = new Car(weight, width, height, length);
            }

            if (type == 2) {
                double weight = (Math.random()*8001) + 2000;
                measurables[i] = new Truck(weight, width, height, length);
            }
        }

        return measurables;
    }

    // 6. Добавьте в Vehicle метод aPrint, который вводит(?) последовательно тип, цвет и вес ("type:  ; weight: ; ....")
    public void aPrint() {
        System.out.println("type: " + this.getType() + "; color: " + this.getColor() + "; weight: " + this.getWeight());
    }


    /*
    8. Напишите в Vehicle статический метод, который распечатывает массив Vehicle, с выдачей полной информации, в зависимости от типа (используя метод Print)
     */
    public static void fullPrint(Vehicle[] vehicles) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        ArrayList<Vehicle> trucks = new ArrayList<>();

        for (Vehicle v : vehicles) {
            if (v.getClass() == Car.class) {
                cars.add(v);
            }

            if (v.getClass() == Truck.class) {
                trucks.add(v);
            }
        }

        for (Vehicle veh : cars) {
            ((Car)veh).aPrint();
        }

        for (Vehicle veh : trucks) {
            ((Truck)veh).aPrint();
        }
    }

}
