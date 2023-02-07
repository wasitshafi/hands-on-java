
// mocking with sleep()
class MyThread_Demo1 extends Thread {
  // mocking the thread take long taken task by using sleep()
  public void run() {
    for(int i = 0; i < 5; i++) {
      System.out.println("i :: " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
//      throw new RuntimeException(e);
        System.out.println("Inside catch interrupting the thread : Thread.currentThread().isInterrupted()= " + Thread.currentThread().isInterrupted() + "____Thread.interrupted()" + Thread.interrupted());
        break; // this is how most of the time the thread interrupting is handled, like when thread is in sleep() and interruption has happened the it will cause an exception
      }
    }
    System.out.println("END OF RUN METHOD...");
  }
}

public class Thread_Interruptions_Demo1 {
  public static void main(String[] args) {
    MyThread_Demo1 thread1 = new MyThread_Demo1();
    thread1.start();
    System.out.println("Before interrupting the thread : thread1.isInterrupted()= " + thread1.isInterrupted() + "____Thread.interrupted()" + Thread.interrupted());
    thread1.interrupt();
    System.out.println("After interrupting the thread : thread1.isInterrupted()= " + thread1.isInterrupted() + "____Thread.interrupted()" + Thread.interrupted());

    try {
      Thread.sleep(1000); //  we want thread to get some
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    // if isInterrupted() is true then it resets the interrupt flag, that is why in below line the thread1.isInterrupted() is false
    System.out.println("After interrupting the thread : thread1.isInterrupted()= " + thread1.isInterrupted() + "____Thread.interrupted()" + Thread.interrupted());
  }
}