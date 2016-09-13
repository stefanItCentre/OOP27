package lesson10;

import java.util.*;

/**
 * Created by stefan on 16.08.16.
 */
public class SortOfCustomClasses {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Vasia", "Pupkin", 40),
                new Person("Petia", "Ivanov", 20),
                new Person("Vasia", "Pupkin", 20),
                new Person("Petia", "Petrov", 30),
                new Person("Vasia", "Petrov", 50),
                new Person("Misha", "Ivanov", 35),
                new Person("Sasha", "Pupkin", 35),
                new Person("Vasilisa", "Pupkina", 35),
                new Person("Maria", "Ivanova", 25)
        ));

//        Collections.sort(persons, Person.BY_AGE);



        Collections.sort(persons);


        System.out.println(persons);

    }

//    public static Comparator<Person> makeComparator(){
//        if(){
//            return ...
//        } else {
//            return Person.BY_AGE.thenComparing(makeComparator());
//        }
//    }


}


class Person implements Comparable<Person>{

    public static final Comparator<Person> BY_AGE = new CmpByAge();

    public static final Comparator<Person> BY_NAME = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public static final Comparator<Person> BY_SURNAME = (p1, p2) -> p1.surname.compareTo(p2.surname);



    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", name, surname, age);
    }


    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    private static class CmpByAge implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.age, o2.age);
        }
    }

}

