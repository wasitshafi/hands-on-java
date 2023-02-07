import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Function  : takes input and returns output
// Predicate : takes input and returns boolean output
// Consumer  : takes input don't return output
// Supplier  : no input only output
class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() { return this.name;}
  public String setName(String name) {
    return this.name = name;
  }
}
public class Function_Predicate_Consumer_Supplier_Demo {

  public static void main(String[] args) {
    int MIN_STRING_LENGTH = 5;
    Function<Integer, Integer> square = x -> x* x;
    Predicate<String> checkLength = (s) -> s.length() > MIN_STRING_LENGTH;
    Consumer<Person> updater = (e) -> {e.setName("Wasit Shafi");};
    Supplier<Double> input = ()-> Math.random();

    // Function
    System.out.println("square.apply(4) :: " + square.apply(4));

    // Predicate
    System.out.println("checkLength.test(\"hello world\") :: " + checkLength.test("hello world"));
    System.out.println("checkLength.test(\"hi\") :: " + checkLength.test("hi"));

    // Consumer
    Person personInstance = new Person("abc");
    System.out.println("personInstance.getName() :: " + personInstance.getName());
    updater.accept(personInstance);
    System.out.println("personInstance.getName() :: " + personInstance.getName());

    // Supplier
    System.out.println("input.get() :: " + input.get());
  }
}