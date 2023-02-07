class ThreadA extends Thread {
  public void run() {
    for(int i = 0 ; i < 10; i++) {
      System.out.println("Thread A : i  = " + i);
      // mock time taking execution
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

class ThreadB extends Thread {
  public void run() {
    for(int j = 0 ; j < 10; j++) {
      System.out.println("Thread B : j  = " + j);
    }
  }
}
class ThreadC extends Thread {
  public void run() {
    for(int k = 0 ; k < 10; k++) {
      System.out.println("Thread C : k  = " + k);
    }
  }
}


public class Join_Demo{
  public static void main(String[] args) {
    ThreadA threadA = new ThreadA();
    ThreadB threadB = new ThreadB();
    ThreadC threadC = new ThreadC();


    threadA.start();
    try {
      System.out.println("Before thread.join()");
      threadA.join(); // the current thread which is 'main' thread will pause until the 'threadA' completes its execution
      System.out.println("After thread.join(), this line will be executed only once the threadA completes is execution!!");
//      threadA.join(100); // the current thread which is 'main' thread will pause for 100 milliseconds
//      threadA.join(100,10); // the current thread which is 'main' thread will pause for 100 milliseconds and 10 nanoseconds
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    threadB.start();
    threadC.start();
  }
}