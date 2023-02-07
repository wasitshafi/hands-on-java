class ThreadA extends Thread{
  @Override
  public void run() {
    System.out.println("Inside run method :: Thread.currentThread().getState() :: " + Thread.currentThread().getState());
    for (int i=0; i < 10; i++) {
      System.out.println("Thead.currentThread : " + Thread.currentThread() + "__i + " + i);
    }
  }
}

public class Thread_Methods_Demo_getId_threadId_getName_getPriority_getState_isAlive_isInterrupted_isDaemon_currentThread{
  public static void main(String[] args) throws InterruptedException {
    ThreadA myThread = new ThreadA();
    // CTM :getId is depricated now
    System.out.println("myThread.getId() :: " + myThread.getId() +"  __myThread.threadId() :: "+  myThread.threadId() +  "  __myThread.getName() :: " + myThread.getName() + "  __myThread.getPriority() :: " + myThread.getPriority()    + "  __myThread.getState() :: " + myThread.getState() + "  __myThread.isAlive() :: " +  myThread.isAlive() + "  __myThread.isInterrupted() :: " + myThread.isInterrupted() + "  __myThread.isDaemon :: " + myThread.isDaemon());
    myThread.start();
    System.out.println("After starting a thread :: myThread.getState() :: " + myThread.getState());
    Thread.sleep(3000);
    System.out.println("After starting a thread and sleep of 3 seconds for main thread :: myThread.getState() :: " + myThread.getState()); // assuming the myThread has completed is executions in 3 seconds

  }
}