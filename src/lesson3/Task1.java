package lesson3;

public class Task1 {
	
	public static void main(String[] args) {
		
		String str = "!!!! \"hello\", \"world\', \"hssergsergero\", world, hello, world";
		
		String res = str.replaceAll("\"([^\"']*)\"", "'$1'");
		
		
		
		System.out.println(res);
//		System.out.println(str);
		
	}
	
	public static void bubbleSort(int [] array) {
		
	}

}
