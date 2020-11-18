package com.dtag.WFMTAT;

import java.util.ArrayList;

public class Dispatcher {
    private int index = -1;

    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }

    public int hystericSearch(int[] array, int searchable, int numberOfThreads, int attempts) {
        ArrayList<Thread> agentThreads = new ArrayList<>();
        ArrayList<Agent> agents = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            agents.add(new Agent(this, array, searchable, attempts, "Agent " + i));
            agentThreads.add(new Thread(agents.get(i)));
            System.out.println(agents.get(i).getName() + " Started");
            agentThreads.get(i).start();
        }

        boolean alive = true;
        while(alive) {
            if(index != -1) {
//                for (Agent agent: agents) {
//                    agent.setToStop(true);
//                    System.out.println(" Stop!!! " + agent.getName());
//                }
                for (Thread agentThread: agentThreads) {
                    agentThread.interrupt();
                    System.out.println(" Interrupt!!! " + agentThread.getName());
                }
                return index;
            }

            for (int i = 0; i < agentThreads.size(); i++) {

                if (agentThreads.get(i).isAlive()) {
                    alive = true;
                } else {
                    alive = false;
                }
            }
        }

        return -1;
    }
}
