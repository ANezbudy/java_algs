package com.dtag.WFMTAT;

public class Agent implements Runnable {
    private Dispatcher dispatcher;
    private int[] array;
    private int searchable;
    private int attempts;
    private String name;
    private boolean toStop = false;


    public Agent(Dispatcher dispatcher, int[] array, int searcheble, int attempts, String name) {
        this.dispatcher = dispatcher;
        this.array = array;
        this.searchable = searcheble;
        this.attempts = attempts;
        this.name = name;

    }

    public void run() {
        for (int i = 1; i <= attempts&&!Thread.interrupted(); i++) {
            int index = (int) (Math.random() * array.length);

            // check via index of exact dispatcher
//            if (dispatcher.getIndex() != -1) {
//                return;
//            }

            // check via index toStop parameter

//            if (toStop) {
//                System.out.println(name + " Stopped");
//                return;
//            }

//            if (Thread.interrupted()) {
//                return;
//            }
//
            try {
                Thread.sleep(100);
                System.out.println("To sleep - " + name + "// ");
                System.out.println(Thread.interrupted());
            } catch (InterruptedException e) {
                System.out.println("I was interrapted!");
                e.printStackTrace();
                return;
            }


            if (array[index] == searchable) {
                dispatcher.setIndex(index);
                System.out.println("Name: " + name + " Index: " + index + " found and passed in dispatcher");
                return;
            }
            System.out.println("Name: " + name + " Index not found");
//            return;
        }

    }

    public void setToStop(boolean toStop) {
        this.toStop = toStop;
    }

    public void StopAgent() {
        setToStop(false);
    }

    public String getName() {
        return name;
    }
}
