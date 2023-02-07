import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Scratch {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<Integer>();

    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);

    System.out.println("numbers.forEach(System.out::print)");
    numbers.forEach(System.out::print);

    System.out.println("\n\nnumbers.forEach((x)-> {System.out.println(\"element :: \" + x);}) :: ");
    numbers.forEach((x)-> {System.out.println("element :: " + x);});

    System.out.println("\n\nnumbers.stream().forEach(System.out::print) :: ");
    numbers.stream().forEach(System.out::print);

    System.out.println("\n\nnumbers.parallelStream().forEach(System.out::print) :: ");
    numbers.parallelStream().forEach(System.out::print);

    System.out.println("\n\nnumbers.parallelStream().forEach((x)-> {System.out.println(\"element(using parallelStream) :: \" + x);})");
    numbers.parallelStream().forEach((x)-> {System.out.println("element(using parallelStream) :: " + x);});

    // composition,  combining 2 function
    Function<Integer, Integer> timesTwo = x-> x*3;
    Function<Integer, Integer> minusOne = x -> x -1;

    Function<Integer,Integer> timesTwoAndMinusOne = timesTwo.compose(minusOne);
    Function<Integer,Integer> minusOneAndTimesTwo = minusOne.andThen(timesTwo);
    Function<Integer,Integer> timesTwoAndMinusOne2 = timesTwo.andThen(minusOne);

    System.out.println("\n\ntimesTwoAndMinusOne.apply(3)  :: " + timesTwoAndMinusOne.apply(3));
    System.out.println("timesTwoAndMinusOne2.apply(3) :: " + timesTwoAndMinusOne2.apply(3));
    System.out.println("minusOneAndTimesTwo.apply(3)  :: " + minusOneAndTimesTwo.apply(3));
  }
}