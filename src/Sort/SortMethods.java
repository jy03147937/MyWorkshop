package Sort;

import java.util.Random;

public class SortMethods {

	public static void main(String[] args) {

		Random random = new Random();
		int[] array = new int[100000];
		for (int i = 0; i < 100000; i ++) {
			array[i] = random.nextInt(100000);
		}
		
		int[] testArray = {3,1,4,1,5,9,2,6};
		
		long quickSortStart=System.currentTimeMillis();
		int[] quickSortedArray = quickSort(array);
		long quickSortEnd=System.currentTimeMillis();
		long quickSortEndInterval=quickSortEnd-quickSortStart;
		System.out.println("Quick sort Costs : " + quickSortEndInterval + "ms");
		
		long bubbleSortStart=System.currentTimeMillis();
		int[] bubbleSortedArray = bubbleSort(array);
		long bubbleSortEnd=System.currentTimeMillis();
		long bubbleSortEndInterval=bubbleSortEnd-bubbleSortStart;
		System.out.println("Bubble sort Costs : " + bubbleSortEndInterval + "ms");
		
		System.out.println("hello,world");
	}
	
	public static int[] quickSort(int[] array){
		
		if(array == null || array.length == 0) {
			return null;
		}
		
		int[] sortedArray = new int[array.length];
		for(int i = 0; i < array.length; i++){
			sortedArray[i] = array[i];
		}
		
		SortMethodsHelper.qSort(sortedArray, 0, sortedArray.length-1);
		
		return sortedArray;
	}
	
	public static int[] bubbleSort(int[] array){
		
		if(array == null || array.length == 0) {
			return null;
		}
		
		int[] sortedArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++){
			sortedArray[i] = array[i];
		}
		
		for(int i = 0; i < sortedArray.length - 1; i++) {
			for (int j = i + 1; j < sortedArray.length; j++) {
				if (sortedArray[i] > sortedArray[j]) {
					int temp = sortedArray[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = temp;
				}
			}
		}
		
		return sortedArray;
	}
	
	/*
	 * The helper class is private
	 */
	private static class SortMethodsHelper {
		private static void qSort(int[] array, int left, int right){
			int i = left;
			int j = right;
			int benchIndex = left;
			while (i < j) {
				for(; j > i; j--) {
					if(array[i] > array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						benchIndex = j;
						break;
					}
				}
				
				for(; i < j; i++) {
					if(array[i] > array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						benchIndex = i;
						break;
					}
				}
			}
			
			if(left < benchIndex - 1 ) {
				qSort(array, left, benchIndex - 1);
			}
			if(right > benchIndex + 1 ) {
				qSort(array, benchIndex + 1, right);
			}

		}
	}
}
