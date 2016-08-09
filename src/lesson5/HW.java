package lesson5;

import java.util.Arrays;

public class HW {

	public static void main(String[] args) {
		permute(new int []{1, 2, 3, 4}, 0);
	}

	public static void shaker(int[] arr) {
		boolean repeat = true;

		int left = 0;
		int right = arr.length;

		while (repeat) {
			repeat = false;
			for (int j = left; j < right - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int buff = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = buff;
					repeat = true;
				}
			}
			right--;
			for (int k = right; k > left; k--) {
				if (arr[k] < arr[k - 1]) {
					int buff = arr[k - 1];
					arr[k - 1] = arr[k];
					arr[k] = buff;
					repeat = true;
				}
			}
			left++;
		}
	}

	public static void insertion(int[] array) {

		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
				lesson3.Task2.swap(array, j - 1, j);
			}
		}
	}

	public static void insert(int[] array) {
		for (int j = 0; j < array.length - 1; j++) {
			if (array[j] > array[j + 1]) {
				lesson3.Task2.swap(array, j, j + 1);
				for (int i = j + 1; i >= 2; i--) {
					if (array[i - 2] > array[i - 1]) {
						lesson3.Task2.swap(array, i - 2, i - 1);
					} else {
						i = 0;
					}
				}
			}
		}
	}

	public static void insertSort(int[] arr) {
		boolean check = true;

		for (int i = 0; i < arr.length - 1 && check; i++) {
			check = false;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					lesson3.Task2.swap(arr, i, j);
					for (int w = i; w != 0; w--) {
						if (arr[w] < arr[w - 1]) {
							lesson3.Task2.swap(arr, w, w - 1);
							check = true;
						}
					}
					check = true;
				}
			}
			// System.out.println(Arrays.toString(arr));
		}

	}

	public static void shellSort(int[] array) {
		int step = array.length / 2;
		while (step > 0) {
			for (int i = 0; i < (array.length - step); i++) {
				int j = i;
				while (j >= 0 && (array[j] > array[j + step])) {
					int temp = array[j];
					array[j] = array[j + step];
					array[j + step] = temp;
					j--;
				}

			}
		}
	}

	public static int sum(int n) {
		return (n == 0 ? 0 : sum(n / 10) + (n % 10));
	}

	public static void revers(int num) {
		System.out.print(num % 10);
		if (num / 10 == 0) {
			return;
		}
		revers(num / 10);
	}

	public static int Rev(int n) {
		return Integer.parseInt(new StringBuilder().append(n).reverse()
				.toString());
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static long fact(int num) {
		if (num == 1) {
			return 1;
		}
		return num * fact(num - 1);
	}

	public static long factV2(int a) {
		return a == 1 ? 1 : a * factV2(a - 1);
	}

	public static int foo(int a, int b, int c) {
		return a > b ? a > c ? a : b > c ? b : c : b;
	}

	public static int powV2(int num, int pow) {
		return pow == 0 ? 1 : num * powV2(num, pow - 1);
	}

	public static int powV3(int num, int pow) {
		if (pow == 0)
			return 1;
		else
			return num * powV3(num, pow - 1);
	}

	public static int pow(int num, int pow) {

		if (pow == 0) {
			return 1;
		} else {
			return num * pow(num, pow - 1);
		}
	}

	public static void permute(int[] arr, int idx) {
		
		if (idx == arr.length - 1) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			
			swap(arr, idx, i);
			permute(arr, idx + 1);
			swap(arr, idx, i);
		}

	}
	public static void swap(int[] array, int i, int j) {
        int buff = array[i];
        array[i] = array[j];
        array[j] = buff;
    }
}
