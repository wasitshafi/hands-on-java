class Animal {
  public void fetch() {
    System.out.println("Animal Animal...");
  }
  public void messageFromAnimal() {
    System.out.println("I am animal.");
  }

}

class Dog  extends Animal{
  @Override
  public void fetch() {
    System.out.println("Wow Wow...");
  }
  public void messageFromDog(){
    System.out.println("I am dog.");
  }
}

class Cat extends Animal {
  @Override
  public void fetch(){
    System.out.println("Meow Meow...");
  }
  public void messageFromCat() {
    System.out.println("I am cat.");
  }
}

public class Upcasting_Downcasting_Demo {
  public static void main(String[] args) {
    // implicit up-casting -> gets done automatically by java like here sub-class Dog is converted to super-class Animal type
    Animal myAnimal = new Dog();

    // since myAnimal is of type Animal so we can directly only call method in Animal Class and in-case if any method is overridden by sub-class then that is able abe to get called from myAnimal object directly

    myAnimal.messageFromAnimal();
    myAnimal.fetch(); // fetch() in Dog will be called as that is overridden in sub-class

    // this will not work due to fact in java down-casting is not implicit
//    myAnimal.messageFromDog(); // can't call this as myAnimal is of type Animal not Dog, so we need to do casting inorder to call Dog class methods which are not overridden

    // here we know myAnimal is of type super-class and inorder to access any sub-class  methods we need to type casting to sub-class instance ie from parent type to child type object
    ((Dog)myAnimal).messageFromDog();
    // alternate by creating new reference value
    Dog dog = (Dog)myAnimal;
    dog.messageFromDog();

    // Question: why we are allowed to make type of super-class and initializing as sub-class -> because it allows as to store all the sub-types of any sub-class
    Animal myCat = new Cat();
    Cat myCat2 = new Cat();

    System.out.print("\nlogAnimal(myAnimal) :: ");
    logAnimal(myAnimal);
    System.out.print("\nlogAnimal(myCat) :: ");
    logAnimal(myCat);
    System.out.print("\nlogAnimal(myCat2) :: ");
    logAnimal(myCat2);
  }
  public static void logAnimal(Animal animal) {
    // here animal can be of type any sub-class of Animal

    if(animal instanceof Dog) {
      ((Dog)animal).messageFromDog();
    } else if(animal instanceof Cat) {
      ((Cat)animal).messageFromCat();
    }
  }

}