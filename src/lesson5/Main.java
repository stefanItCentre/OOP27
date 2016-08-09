package lesson5;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		

		Person person1 = new Person();

		person1.age = 20;
		person1.name = "Vasia";
		
		
		Person person2 = new Person();

		Person person3 = new Person();

		person2.age = 40;
		person2.name = "Petro";
		
		person1.foo = 20;
		
		System.out.println(person1.foo);
	
		System.out.println(person2.foo);
		
		Person.foo = 30;
		
		
		
	}
	
	
	
	public static void printPerson(Person p){
		System.out.println(p.age + " ------- " + p.name);
	}

}
