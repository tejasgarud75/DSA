package org.example.multiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample extends Thread {

  public static Lock lock = new ReentrantLock();

  public static void outerMethod() {
    lock.lock();
    try {
      System.out.println("Locked outer method");
      innerMethod();
    } finally {
      lock.unlock();
    }

  }

  private static void innerMethod() {
    lock.lock();
    try {
      System.out.println("Locked Inner method");
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    outerMethod();

  }

}
