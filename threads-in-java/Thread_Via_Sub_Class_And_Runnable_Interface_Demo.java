
// creating thread by extending the Thread class
class FirstThread extends Thread {
  private int id;

  public FirstThread(int id) {
    this.id = id;
  }

  @Override
  public void run() {
    for(int i = 1; i <= 5; i++) {
      System.out.println("i : " + i + "__Thread name : " + Thread.currentThread().getName() +  " __ID : " + id);
    }
  }
}

// creating the thread by implementing the Runnable interface
class MyRunnable implements Runnable{
  private int id;
  public MyRunnable(int id) {
    this.id = id;
  }
  @Override
  public  void run(){
    for(int j = 1; j <= 5; j++) {
      System.out.println("j : " + j + "__Thread name : " + Thread.currentThread().getName() +  " __ID : " + id);
    }
  }
}
public class Thread_Via_Sub_Class_And_Runnable_Interface_Demo {
  public static void main(String[] args) {
    FirstThread thread1 = new FirstThread(101);
    FirstThread thread2 = new FirstThread(102);
    MyRunnable runnable1 = new MyRunnable(103);
    Thread thread = new Thread(runnable1);

    thread1.start();
    thread2.start();
    thread.start();
  }
}