package com.company;

import java.util.concurrent.Semaphore;

public class Passengers extends Thread{

    Semaphore semaphore;
    int num = 0;
    int id;

    public Passengers(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 5) {
                semaphore.acquire();
                System.out.println("Passenger " + id + " is served!");
                sleep(500);

                System.out.println("Passenger " + id + " is finish!");
                semaphore.release();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
}
