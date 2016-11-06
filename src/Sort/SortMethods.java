package Sort;

import java.util.Arrays;
import java.util.Random;

public class SortMethods {

	public static void main(String[] args) {

		Random random = new Random();
		int length = 100000;
		int[] array1 = new int[length];
		for (int i = 0; i < length; i ++) {
			array1[i] = random.nextInt(length);
		}
		int[] array2 = new int[length];
		for (int i = 0; i < length; i ++) {
			array2[i] = array1[i];
		}
		
		int[] testArray = {3,1,4,1,5,9,2,6};
		int[] goldenSepArray = {0,6,1,8,0,3,3,9,8,8,7,4,9,8,9,4,8,4,8,2,0};

		int[] approximalSortedArray = quickSort(array1);
		
		long quickSortStart=System.currentTimeMillis();
		int[] quickSortedArray = quickSort(array1);
		long quickSortEnd=System.currentTimeMillis();
		long quickSortEndInterval=quickSortEnd-quickSortStart;
		System.out.println("Quick sort Costs : " + quickSortEndInterval + "ms");
		
		long bubbleSortStart=System.currentTimeMillis();
		int[] bubbleSortedArray = bubbleSort(array1);
		long bubbleSortEnd=System.currentTimeMillis();
		long bubbleSortEndInterval=bubbleSortEnd-bubbleSortStart;
		System.out.println("Bubble sort Costs : " + bubbleSortEndInterval + "ms");
		
		long insertSortStart=System.currentTimeMillis();
		int[] insertSortedArray = insertSort(array1);
		long insertSortEnd=System.currentTimeMillis();
		long insertSortEndInterval=insertSortEnd-insertSortStart;
		System.out.println("Insert sort Costs : " + insertSortEndInterval + "ms");
		
		long mergeSortStart=System.currentTimeMillis();
		int[] mergeSortedArray = mergeSort(array1);
		long mergeSortEnd=System.currentTimeMillis();
		long mergeSortEndInterval=mergeSortEnd-mergeSortStart;
		System.out.println("Merge sort Costs : " + mergeSortEndInterval + "ms");
		
		long systemSortStart=System.currentTimeMillis();
		Arrays.sort(array1);
		long systemSortEnd=System.currentTimeMillis();
		long systemSortInterval=systemSortEnd-systemSortStart;
		System.out.println("System sort Costs : " + systemSortInterval + "ms");

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
	
	public static int[] insertSort(int[] array) {
		if(array == null || array.length == 0) {
			return null;
		}
		
		int[] sortedArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++){
			sortedArray[i] = array[i];
		}
		
		for(int i = 1; i < sortedArray.length; i++) {
			int j = i;
			while(j > 0 && sortedArray[j] < sortedArray[j-1]) {
				int temp = sortedArray[j-1];
				sortedArray[j-1] = sortedArray[j];
				sortedArray[j] = temp;
				j--;
			}
		}

		return sortedArray;
	}
	
	public static int[] mergeSort(int[] array) {
		if(array == null || array.length == 0) {
			return null;
		}
		
		int[] sortedArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++){
			sortedArray[i] = array[i];
		}
		
		int arrayLength = array.length;
		int subArrayLength = 1;
		while(subArrayLength < arrayLength) {
			int firstStartIndex = 0;
			int secondStartIndex = firstStartIndex + subArrayLength;
			while(secondStartIndex < arrayLength) {

				SortMethodsHelper.merge(sortedArray, firstStartIndex, secondStartIndex);
				
				firstStartIndex += 2 * subArrayLength;
				secondStartIndex += 2 * subArrayLength;
			}
			
			subArrayLength = 2 * subArrayLength;
			
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
			int benchIndex = (int) (left + Math.random() * (right - left));
			//int benchIndex = left;
			
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
		
		private static void merge(int[] array, int firstStartIndex, int secondStartIndex) {
			int subArrayLength = secondStartIndex - firstStartIndex;
			int[] tempSorted = new int[2 * subArrayLength];
			
			int i = firstStartIndex;
			int j = secondStartIndex;
			int k = 0;
			int arrayLength = array.length;
			while (i < secondStartIndex && j < arrayLength && j < (secondStartIndex + subArrayLength)) {
				if(array[i] < array[j]) {
					tempSorted[k] = array[i];
					i++;
					k++;
				} else {
					tempSorted[k] = array[j];
					j++;
					k++;
				}
			}
			
			if (i == secondStartIndex) {
				while(j < arrayLength && j < (secondStartIndex + subArrayLength)) {
					tempSorted[k] = array[j];
					j++;
					k++;
				}
			} else if (j == arrayLength || j == (secondStartIndex + subArrayLength)) {
				while(i < secondStartIndex) {
					tempSorted[k] = array[i];
					i++;
					k++;
				}
			}

			k--;
			j--;
			while(j >= firstStartIndex) {		
				array[j] = tempSorted[k];
				
				k--;
				j--;
			}
		}
	}
}
