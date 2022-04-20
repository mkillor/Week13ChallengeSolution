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
    public static int x = 0;
}

class Restroom1 implements Runnable{

    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Restroom 1 in use");
            try { Thread.sleep(2125); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 2 available");
            Main.x-=1;
            System.out.println(Main.x);
        }

    }

}

class Restroom2 implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Restroom 2 in use");
            try { Thread.sleep(3500); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 2 available");
            Main.x+=1;
            System.out.println(Main.x);
        }
    }
}
class Restroom3 implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Restroom 3 in use");
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 3 available");
            Main.x+=1;
            System.out.println(Main.x);
        }
    }
}
class Restroom4 implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Restroom 4 in use");
            try { Thread.sleep(2250); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 4 available");
            Main.x+=1;
            System.out.println(Main.x);
        }
    }
}

class Timer implements Runnable{
    public void run(){
        for (int i = 1; i < 30; i++) {
            System.out.println(i + "second");
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}