package org.example.multiThreading;

public class Counter {

  private int count = 0;


  /**
   * Increments the count in a thread-safe way. Why synchronized? ----------------- - Multiple
   * threads may call this method at the same time. - Without synchronization, a race condition may
   * occur Used in critical section mention atomic variables (`AtomicInteger`) as an alternative.
   */
  public void addCount() {
    count++;
  }

  public int getCount() {
    return count;
  }

}
