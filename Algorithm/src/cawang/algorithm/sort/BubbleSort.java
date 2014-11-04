package cawang.algorithm.sort;

import java.util.Arrays;

/**
 * @author cawang
 * Time: O(n^2)
 * Space: O(1)
 */
public class BubbleSort extends AbstractSort implements ISort {
	
	//sort in place
	//more like selection sort
	public Comparable[] sort_notStandard(Comparable[] array){
		printArray(true, array);
		if(array==null){
			printArray(false, array);
			return null;
		}
		for(int i=0;i<array.length;i++){
			
			for(int j=i+1;j<array.length;j++){ //get min
				if(array[i].compareTo(array[j])>0){
					Comparable temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		printArray(false, array);
		return array;
	}
	
	//standard
	//if loop from i+1 to length, compare j and j+1, get min;
	//i and j loop direction are different
	//but not if loop from length to i+1, compare j and j-1
	public Comparable[] sort(Comparable[] array){
		printArray(true, array);
		if(array==null){
			printArray(false, array);
			return null;
		}
		for(int i=0;i<array.length;i++){
			for(int j=array.length-1;j>i;j--){ //get min
				if(array[j].compareTo(array[j-1])<0){
					Comparable temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
		printArray(false, array);
		return array;
	}
	
	//if loop from i+1 to length, compare j and j+1
	public Comparable[] _sort_wrong2(Comparable[] array){
		System.out.println("BubbleSort Origianl Array: "+Arrays.toString(array));
		if(array==null){
			System.out.println("BubbleSort New Array: null");
			return null;
		}
		for(int i=0;i<array.length;i++){
			for(int j=i;j<array.length-1;j++){
				if(array[j].compareTo(array[j+1])>0){
					Comparable temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		System.out.println("BubbleSort New Array: "+Arrays.toString(array));
		return array;
	}
	
	public Comparable[] _sort_wrong(Comparable[] array){
		System.out.println("BubbleSort Origianl Array: "+Arrays.toString(array));
		if(array==null){
			System.out.println("BubbleSort New Array: null");
			return null;
		}
		for(int i=0;i<array.length;i++){
			
			for(int j=i+1;j<array.length;j++){
				if(array[j].compareTo(array[j-1])<0){
					Comparable temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		System.out.println("BubbleSort New Array: "+Arrays.toString(array));
		return array;
	}

}
