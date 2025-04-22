package org.example;


public class MyThread extends Thread {

  @Override
  public void run() {
    try {
      MyThread.sleep(2000);
//      System.out.println("New thread finish");
      System.out.println("Run method : " + Thread.currentThread().getName());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

  public static void main(String[] args) throws InterruptedException {

    MyThread myThread = new MyThread();

    // Run method will start in same main thread
//    myThread.run();
    // Start method will start by create a new thread
    myThread.start();
    //    By using Join main thread will wait for new created thread to finish
    myThread.join();
    System.out.println("Main method : " + Thread.currentThread().getName());

//    System.out.println("Main thread..");

  }

}