package com.dtag.WFMTAT;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
//        Truck truck1 = new Truck(16, 1);
//        Truck truck2 = new Truck(12);
//
//        Car car1 = new Car(8, 2);
//        Car car2 = new Car(10, 2);
//        Car car3 = new Car(9.5);
//
//        Vehicle[] vehicles = new Vehicle[5];
//
//        vehicles[0] = truck1;
//        vehicles[1] = truck2;
//        vehicles[2] = car1;
//        vehicles[3] = car2;
//        vehicles[4] = car3;
//
//
//        Vehicle[] vehicles_1 = Vehicle.vehiclesFactory(5);
//        Vehicle.printVehicles(vehicles_1);
//
//        // 5. Разделите свой массив на 2 массива, каждый из которых будет содержать только элементы одного типа
//
//        ArrayList<Vehicle> cars = new ArrayList<>();
//        ArrayList<Vehicle> trucks = new ArrayList<>();
//
//        for (Vehicle v : vehicles_1) {
//            if (v.getClass() == Car.class) {
//                cars.add(v);
//            }
//
//            if (v.getClass() == Truck.class) {
//                trucks.add(v);
//            }
//        }
//
//        for (Vehicle veh : cars) {
//            veh.aPrint();
//        }
//
//        for (Vehicle veh : trucks) {
//            veh.aPrint();
//        }
//
//        Vehicle.fullPrint(vehicles_1);

//        int [] in = ArraySandBox.randomArray(5, 10);
////        int[] in = {8, 2, 7, 0, 5};
//        int[] list = MergeSort.mergeSort(in);
//        ArraySandBox.printArray(list);

//        BinaryTreeNode b = new BinaryTreeNode(6);
//        b.addCountedNode(6);
//        b.addCountedNode(8);
//        b.addCountedNode(8);
//        b.addCountedNode(6);
//        b.addCountedNode(3);
////        b.printTree();
////        ArraySandBox.printArray(b.treeSort());
////        System.out.println();
//        ArraySandBox.printArray(b.treeSortArray());
//        System.out.println();
//        System.out.println(b.treeCounter());


//        int[] array = ArraySandBox.randomArrayRange(2000, 1, 4000);
//        ArraySandBox.printArray(array);
//        System.out.println();
////        System.out.print(ArraySandBox.arraySearch(array, 145));
//        System.out.println(HashMapSandbox.countEntryPut(array));
//        ArraySandBox.printArray(ArraySandBox.arraySortHashMap(array));

//        String inStr = "Вася который к Пете пришел на себя зеленую шляпу в слово надел";
//
//        System.out.println(inStr);
//        System.out.println(Censor.censor(inStr));

//        InterfaceSandBox.basicInterfaceExample();

//        int[] sarray = {0, 0, 0, 0, 1, 1, 1, 3, 5, 9, 12, 13, 14, 15, 15, 16, 17, 18, 18, 18,};
////        System.out.println(10/16);
//
//        int searchable = (int)(Math.random()*20);
////        int searchable = 16;
//        System.out.println(searchable);
//
//        int[] array = SimpleSortSandbox.bubbleSort(ArraySandBox.randomArray(20, 20));
//        ArraySandBox.printArray(array);
//        System.out.println();
//        System.out.println(SearchSandBox.binarySearch(searchable, array));

//        Car car = new Car(3000, 5, 5, 8);
//        System.out.println(CheckPoint.checkParameters(car));
//
//        Measurable[] vechiclesToCheck = Vehicle.measurablesFactory(10);
//        System.out.println(vechiclesToCheck.toString());
////
//        for (int i = 0; i < vechiclesToCheck.length; i++) {
//            System.out.println(CheckPoint.checkParameters(vechiclesToCheck[i]));
//        }

        // test list
//        int[] array = ArraySandBox.randomArray(10, 10);
//        int[] array = {8, 8, 8, 4, 2, 7, 8, 2, 5, 8, 8, 8};
//        ArraySandBox.printArray(array);
//        System.out.println();
//        IntList list = IntList.putArrayInList(array);
//        list.printList();
//        System.out.println();
//        IntList.printReversedArray(array);
//        System.out.println();
//        ArraySandBox.printArray(IntList.reverseArray(array));
//        System.out.println();
//        System.out.println(list.size());
//        list = list.reverseList();
//        System.out.println();
//        list.printList();
//        System.out.println();
////        System.out.println(list.removeListNode(5));
//        System.out.println(list.removeAllNodes(2));
////        System.out.println(list.removeListNodeLinked(2));
//        list.printList();

//        int[] array = ArraySandBox.randomArray(10, 20);
//        int searchable = 5;
//        int numberOfThreads = 10;
//        int numberOfAttemps = 20;
//
//        Dispatcher dispatcher = new Dispatcher();
//        dispatcher.hystericSearch(array, searchable, numberOfThreads, numberOfAttemps);

//        try {
//            ExceptionExample.examplify();
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }
//        ExceptionExample.examplify();

//        SwitchCaseSandbox.faceControl(Outfit.CASUAL, EventType.WOLK);
        //tree with counted nodes
        BalancedBinaryTree b = new BalancedBinaryTree(6);
        b.add(6);
        b.add(8);
        b.add(8);
        b.add(6);
        b.add(6);
        b.add(6);
        b.add(6);
        b.add(3);
        b.printBalancedTree();
        System.out.println();
        b.printBalancedTreeLeft();
        System.out.println();
        b.printBalancedTreeRight();
        System.out.println();
    }

    public static void conditionExample() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number from 1 to 10");
        int a = in.nextInt();
        in.close();

        if (a > 10) {
            System.out.println("The number is bigger then 10!");
            return;
        }

        int b;

        if (a >= 5) {
            b = 10;
        } else {
            b = 0;
        }
        System.out.println("a = " + a +"; " + "b = " + b);
    }

    public static void stringExample() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter two lines!");

        String s1 = in.next();
        String s2 = in.next();
        in.close();

        int result = s1.compareTo(s2);
        String biggerStr;
        if (result > 0) {
            biggerStr = s1;
        } else {
            biggerStr = s2;
        }

        System.out.println(biggerStr);

    }

    public static void stringLexicalCompExample() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter two lines!");

        String s1 = in.next();
        String s2 = in.next();
        in.close();

        int compareResult = ArraySandBox.lexicalComparator(s1, s2);

        if(compareResult == 1) {
            System.out.println("\""+ s1 + "\"" + "is bigger then " + "\"" + s2 + "\"");
        }

        if (compareResult == -1) {
            System.out.println("\""+ s2 + "\"" + "is bigger then " + "\"" + s1 + "\"");
        }

        if (compareResult == 0) {
            System.out.println("\""+ s1 + "\"" + "is equal to " + "\"" + s2 + "\"");
        }
    }

    public static void ManageSampleArray() {
        int[] sampleArray = SimpleSortSandbox.createRandomArray(13);
        int min = SimpleSortSandbox.findMinElement(sampleArray);
        int max = SimpleSortSandbox.findMaxElement(sampleArray);

        ArraySandBox.printArray(sampleArray);
        System.out.println(min);
        System.out.println(max);
    }


}
