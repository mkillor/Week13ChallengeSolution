package com.company;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Restroom1 obj1 = new Restroom1();
        Restroom2 obj2 = new Restroom2();
        Restroom3 obj3 = new Restroom3();
        Restroom4 obj4 = new Restroom4();
        Timer obj5 = new Timer();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(obj3);
        Thread t4 = new Thread(obj4);
        Thread t5 = new Thread(obj5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        /*Semaphore sem = new Semaphore(4,true);
        try { sem.acquire(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Number of permits:" + sem.availablePermits() );
        System.out.println(sem.isFair());
        sem.release(1);
        System.out.println("Number of permits: " + sem.availablePermits());*/

    }
    public static int x = 20;
    static Semaphore sem = new Semaphore(4,true);//have them write the code without this first
    //then alter the amount of permits available to 2. Fire rules only allow so many students in the restroom!?
}

class Restroom1 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.x; i++) {
            try { Main.sem.acquire(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 1 in use");
            try { Thread.sleep(2125); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 2 available");
            Main.x-=1;
            System.out.println(Main.x);
            Main.sem.release(1);
        }
    }
}

class Restroom2 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.x; i++) {
            try { Main.sem.acquire(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 2 in use");
            try { Thread.sleep(3500); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 2 available");
            Main.x-=1;
            System.out.println(Main.x);
            Main.sem.release(1);
        }
    }
}
class Restroom3 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.x; i++) {
            try { Main.sem.acquire(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 3 in use");
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }//adjusted the millis to 500 to see if time is dramatically reduced.
            // Next alter the permits and say the bouncer only has 3 passes.
            System.out.println("Restroom 3 available");
            Main.x-=1;
            System.out.println(Main.x);
            Main.sem.release(1);
        }
    }
}
class Restroom4 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.x; i++) {
            try { Main.sem.acquire(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 4 in use");
            try { Thread.sleep(2250); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 4 available");
            Main.x-=1;
            System.out.println(Main.x);
            Main.sem.release(1);
        }
    }
}

class Timer implements Runnable{
    public void run(){
        for (int i = 1; i < 30; i++) {
            System.out.println(i + " second");
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}