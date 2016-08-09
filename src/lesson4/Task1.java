package lesson4;

public class Task1 {
	
	public static void main(String[] args) {
	
	
		int result = sum(1, 400);
		
		System.out.println(result);
	}
	
	
	public static void f(int count, int limit) {
		System.out.println(count);
		if(count >= limit){
			return;
		}
		f(count + 1, limit);
		System.out.println(count);
		return;
	}
	
	
	public static int sum(int n, int m){
		if(n == m){
			return m;
		}
		return n + sum(n + 1, m);
//		int recResult = sum(n + 1, m);
//		int res = n + recResult;
//		return res;
	}
}
