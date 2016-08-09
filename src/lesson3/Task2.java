package lesson3;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {

	public static void main(String[] args) {
	
		int [] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		selectionSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void selectionSort (int [] arr){
		for(int j = 0; j < arr.length - 1; j++){
			int minIndex = j;
			for(int i = j + 1; i < arr.length; i++){
				if(arr[i] < arr[minIndex]){
					minIndex = i;
				}
			}	
			
			swap(arr, j, minIndex);
		}
		
	}
	

	
	
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void bubleSort(int[] array) {
		
		boolean hasChange = true;
		for (int i = 0; hasChange; i++) {
			hasChange = false;
			System.out.println(Arrays.toString(array));
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					
					swap(array, j, j + 1);
//					int buff = array[j + 1];
//					array[j + 1] = array[j];
//					array[j] = buff;
					hasChange = true;
				}
			}
			
		}
		
	}
}
