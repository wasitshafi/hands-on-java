class MyThread_Demo1 extends Thread {

  public void run() {
    for(int i = 0; i < 100; i++) {
      // do some work here
      System.out.println("i :: " + i);

      // check if any interruption
      if(Thread.interrupted()) {
        break; //  stop out work as some interrupt is done, also we want to terminate our processing
      }
    }
    System.out.println("END OF RUN METHOD...");
  }
}
public class Thread_Interruptions_Demo2 {
  public static void main(String[] args) {
    MyThread_Demo1 thread1 = new MyThread_Demo1();
    thread1.start();
    System.out.println("Before interrupting the thread : thread1.isInterrupted()= " + thread1.isInterrupted() + "____Thread.interrupted()" + java.lang.Thread.interrupted());
    thread1.interrupt();
    System.out.println("After interrupting the thread : thread1.isInterrupted()= " + thread1.isInterrupted() + "____Thread.interrupted()" + java.lang.Thread.interrupted());

    try {
      java.lang.Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
   // Thread.isInterrupted() also clears the flag if the current thread is interrupted
    System.out.println("After interrupting the thread : thread1.isInterrupted()= " + thread1.isInterrupted() + "____Thread.interrupted()" + java.lang.Thread.interrupted());
  }
}