import java.util.function.Function;
import java.util.function.BiFunction;
class MyMath {
  public static int getSquare(int x){
    return x * x;
  }

}
interface TriFunction<T, U, V, R> {
  R apply(T t, U u, V v);
}

interface NoAgrFunction<R> {
  R apply();
}
class MathDemo {
  public static int add(int x, int y){
    return x + y;
  }
  public static int subtract(int x, int y){
    return x - y;
  }
  public static int combineXandY(BiFunction<Integer,Integer,Integer> foo, int x, int y) {
    return foo.apply(x, y);
  }
  public static Function<Integer, Integer> createMultiplier(int x) {
    return (y)-> x * y;
  }
}

public class Function_Interface {
  public static void main(String[] args) {
    // Function interface allow as to define functions as variables
    Function<Integer, Integer> mySquare = MyMath::getSquare; // Function interface take exactly 1 input and gives 1 output
    // using lambda expressions and function interfaces
    Function<Integer, Integer> mySquare2 = (x) -> x*x;

    // now getSquare is assigned in a variable named as mySquare
    System.out.println("mySquare.apply  :: Square of 10 is : " + mySquare.apply(10));
    System.out.println("mySquare2.apply :: Square of 10 is (using lambda expressions): " + mySquare2.apply(10));
    // in case we have 2 inputs then we can use BiFunction
    BiFunction<Integer,Integer, Integer> myAdd = (x,y)-> x + y;
    System.out.println("myAdd :: myAdd.apply(10,20) :: " + myAdd.apply(10,20));
    // for 3 or more inputs or no output we don't all the possible Function interfaces, but we can easily make our own custom function interface for that.

    // custom function interface with 3 input and 1 output
    TriFunction<Integer, Integer, Integer, Integer> myAddTri = (x,y,z) -> x+ y+z;
    System.out.println("myAddTri.apply(10,20,30) :: " + myAddTri.apply(10,20,30));

    // custom function interface with 0 in put and 1 output
    NoAgrFunction<String> printPi = ()->{double pi = 3.1415; return "Value of PI is " + pi;};
    System.out.println(printPi.apply());

    // passing function as argument
    System.out.println("MathDemo.combineXandY(MathDemo::add, 3,2) :: "+ MathDemo.combineXandY(MathDemo::add, 3,2));
    System.out.println("MathDemo.combineXandY(MathDemo::subtract, 3,2) :: "+ MathDemo.combineXandY(MathDemo::subtract, 3,2));
    // passing function as arguments using  lambda expressions
    System.out.println("MathDemo.combineXandY((x, y)-> x + y, 3,2) :: "+ MathDemo.combineXandY((x, y)-> x + y, 3,2));

    // function returning function
    Function<Integer, Integer> timesTwo = MathDemo.createMultiplier(2);
    Function<Integer, Integer> timesThree = MathDemo.createMultiplier(3);
    Function<Integer, Integer> timesFour = MathDemo.createMultiplier(4);

    System.out.println("timesTwo.apply(2) :: " + timesTwo.apply(2));
    System.out.println("timesThree.apply(2) :: " + timesThree.apply(2));
    System.out.println("timesFour.apply(2) :: " + timesFour.apply(2));
  }
}