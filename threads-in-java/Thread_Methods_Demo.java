public class Thread_Methods_Demo {
  public static void main(String[] args) {

      try {
        System.out.println("main thread will pause for 2 seconds");
        Thread.sleep(2000);
        System.out.println("main thread will pause for 2 seconds and 200 nano seconds");
        Thread.sleep(2000, 200);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    System.out.println("End of program");
  }
}