package lesson13;

import lesson5.Person;

import java.util.Date;

/**
 * Created by stefan on 06.09.16.
 */
public class Task1 {

    public static void main(String[] args) {
//        StringWithDate wd = new StringWithDate("Hello");
//        System.out.println(wd);
//
//        System.out.println(wd.getValue());
        WithDate<String> owd1 = new WithDate<>("Lesson");

        WithDate<Integer> owd2 = new WithDate<>(9999);

        WithDate<Person> owd3 = new WithDate<>(new Person());

        Person p = owd3.getValue();

        System.out.println(p);
    }
}



class PersonWithDate {

    private Person value;
    private Date date;

    public PersonWithDate(Person value) {
        this.value = value;
        this.date = new Date();
    }

    public Person getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return value + " " + date;
    }
}

class StringWithDate {

    private String value;
    private Date date;

    public StringWithDate(String value) {
        this.value = value;
        this.date = new Date();
    }

    public String getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return value + " " + date;
    }
}

class WithDate<E>{

    private E value;
    private Date date;

    public WithDate(E value) {
        this.value = value;
        this.date = new Date();
    }

    public E getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

//    @Override
//    public String toString() {
//        return value + " " + date;
//    }
}