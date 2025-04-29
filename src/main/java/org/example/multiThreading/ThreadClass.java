package org.example.multiThreading;

public class ThreadClass extends Thread {

  private final Counter counter;

  public ThreadClass(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      counter.addCount();
    }
  }

}
