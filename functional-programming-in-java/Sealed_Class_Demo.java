//        humans
//    male      female
//    employee
// inheritance allowed only human->male/ human->female, male->employee
// all the permitted class have to use sealed, non-sealed or final


sealed class Humans permits Male,Female {
  public Humans(){
    System.out.println("Humans created");
  }
}
// we again made it to sealed class
sealed class Male extends Humans permits Employee  {
  public Male () {
    System.out.println("Male created");
  }
}
// now no class can extend this class
final class Employee extends Male{
  public Employee() {
    System.out.println("Employee created");
  }
}
// non-sealed make female like a normal class with no restrictions now, any class can extents it now
non-sealed class Female extends Humans {
  public Female(){
    System.out.println("Female created");
  }
}
// same sealed logic is applied with interface, there we can only use sealed or non-sealed with the permitted interfaces(as we know interface can be made as final)
sealed interface X permits Y{}
non-sealed interface Y extends  X{}
public class Sealed_Class_Demo {
  public static void main(String[] args) {
    System.out.println("inside main class");
    Employee employee = new Employee();
    Female female = new Female();
  }
}