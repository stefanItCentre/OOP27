package lesson5;

public class Person {
	
	String name;
	int age;
	
	
	
	static int foo;
	
	
	
	public void print(){
		System.out.println(name + " " + age);
	}
	
	public static void printPerson(){
		System.out.println(foo);
	}

}
