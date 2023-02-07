// all fields of interface are public, static and final
interface Human {
  int age = 0; // is same as => public static final int age = 0
  void sayHello(); // is same as => public abstract void sayHello();
  // default method
  default void messageFromHumans() {
    System.out.println("This is default methods in interface");
  }
  // static method
  static void logInterfaceName() {
    System.out.println("Static method in interface :: Interface :: Human");
  }
}

interface Male extends Human {
  void messageFromMale();
}

class Employee implements Male {
  public void sayHello() {
    System.out.println("hello world");

  }
  public void messageFromMale(){
    System.out.println("hello world from message from male");
  }
}

// creating custom functional interface
@FunctionalInterface
interface Logger {
  void log (int x);
//  void sayHello(); // if we uncomment this it will raise error, as functional interface can only have 1 method

}
class Interface_Demo {
  public static void main(String[] args) {
    Human o = new Employee();
    o.sayHello();
    o.messageFromHumans();
    Human.logInterfaceName();
    System.out.println("Human.age :: " + Human.age);
    //
    Logger console = (x) -> System.out.println("Logging :: " + x);
    console.log(123);

  }
}