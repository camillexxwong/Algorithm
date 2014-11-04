package cawang.algorithm.sort;

import java.util.Arrays;

import org.junit.Test;

public class BinarySearch {
	public static int search(Comparable[] array, Comparable target){
		if (target==null||array==null) return -1;
		int low=0;
		int high=array.length-1;
		while(low<=high){ //if not use mid+-1, here should be <, not<=
			int mid=low+(high-low)/2;
			if (target.equals(array[mid])) return mid;
			else if(target.compareTo(array[mid])>0) low=mid+1;
			else high=mid-1;
		}
		return -1;
	}
	
	public static int[] search_range(Comparable[] array, Comparable target){
		int[] range=new int[2];
		if (target==null||array==null) range[0]=range[1]=-1;
		int low=0;
		int high=array.length-1;
		while(low<=high){ //if not use mid+-1, here should be <, not<=
			int mid=low+(high-low)/2;
			if (target.equals(array[mid])) range[0]=range[1]=mid;
			else if(target.compareTo(array[mid])>0) low=mid+1;
			else high=mid-1;
		}
		range[0]=high;
		range[1]=low;
		return range;
	}
	@Test
	public void test(){
		Integer[] array1={1,2,4,5};
		Integer[] array2={1,2,4,4,5};
		System.out.println(Arrays.toString(search_range(array1, 3)));
		System.out.println(Arrays.toString(search_range(array1, 3)));
	}
}
