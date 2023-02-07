import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream_ParallelStream_Collector_Demo{
  public static void main(String[] args) {

    List<Integer> list = new ArrayList<Integer>();
    List<String> fruits = new ArrayList<String>();
    Function<Integer,Integer> getDouble = (x)-> x*x;
    // in predicate we just pass argument type in generics, as we already know the return type is boolean
    Predicate<Integer> isEven = (x)-> x%2 ==0;
    // for BinaryOperator we have to specify only one datatype that will be for both the input arguments and return type
    BinaryOperator<Integer> getSum = (accumulator, item) -> accumulator + item;
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    fruits.add("apple");
    fruits.add("Mango");
    fruits.add("Grapes");
    fruits.add("kiwi");
    fruits.add("water mellon");

    System.out.println("\n\nMAP");
    System.out.println("list.stream().map(getDouble) :: "+list.stream().map(getDouble)); // map, filter returns stream but reduce don't return stream
    System.out.println("list.stream().map(getDouble).collect(Collectors.toList()) :: "+list.stream().map(getDouble).collect(Collectors.toList()));
    System.out.println("list.stream().map(x->x*x).collect(Collectors.toList()) :: " + list.stream().map(x->x*x).collect(Collectors.toList())); // directly using lambda

    System.out.println("\n\nFilter");
    // for filter() we need predicate functional interface
    System.out.println("list.stream().filter(isEven).collect(Collectors.toList()):: " + list.stream().filter(isEven).collect(Collectors.toList()));
    System.out.println("list.stream().filter((x)-> x%2==0).collect(Collectors.toList()):: " + list.stream().filter((x)-> x%2==0).collect(Collectors.toList())); // directly using lambda
    // using parallelStream instead of serial stream for increasing performance and speed
    System.out.println("list.parallelStream().filter((x)-> x%2==0).collect(Collectors.toList()):: " + list.parallelStream().filter((x)-> x%2==0).collect(Collectors.toList())); // directly using lambda

    System.out.println("\n\nReduce");
    // for filter we need BinarayOperator function interface
    System.out.println("list.parallelStream().reduce(getSum):: " + list.parallelStream().reduce(getSum));
    // here 0 is the initial value for accumulator, if we don't specify accumulator will be the assigned with first element
    System.out.println("list.parallelStream().reduce(0, getSum):: " + list.parallelStream().reduce(0, getSum));
    System.out.println("list.parallelStream().reduce((accumulator, item)-> accumulator+ item):: " + list.parallelStream().reduce((accumulator, item)-> accumulator+ item)); // directly using lambda

    //Collectors
    System.out.println("\n\nCollectors");
    System.out.println("fruits.stream().collect(Collectors.joining(\"-\")):: " + fruits.stream().collect(Collectors.joining("-")));
    System.out.println("list.stream().filter(isEven).collect(Collectors.counting()):: " + list.stream().filter(isEven).collect(Collectors.counting()));
    // it only divides in 2 parts
    System.out.println("list.stream().collect(Collectors.partitioningBy(isEven)):: " + list.stream().collect(Collectors.partitioningBy(isEven)));
    // it can divide in multiple parts
    System.out.println("list.stream().collect(Collectors.partitioningBy(isEven)):: " + list.stream().collect(Collectors.partitioningBy(isEven)));

  }
}