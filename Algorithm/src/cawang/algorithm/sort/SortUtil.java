package cawang.algorithm.sort;

import java.util.Arrays;

public class SortUtil {
	public static String printArray(String msg, Comparable[] array){
		return msg+Arrays.toString(array);
		//return null;
	}
	public static  void exchange(Comparable[] array, int i, int j) {
		Comparable temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
