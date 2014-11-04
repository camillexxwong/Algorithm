package cawang.algorithm.sort;

import java.util.Arrays;


/**
 * @author cawang
 * Time: O(n^2)
 * Space: O(1)
 * has the less elements moves(O(n))
 */
public class SelectionSort extends AbstractSort implements ISort {

	@Override
	public Comparable[] sort(Comparable[] array) {
		printArray(true, array);
		if(array==null)return null;
		for(int i=0;i<array.length;i++){
			int minIdx=i;
			for(int j=i+1;j<array.length;j++){
				if(array[minIdx].compareTo(array[j])>0)
					minIdx=j;
			}
			Comparable temp=array[minIdx];
			array[minIdx]=array[i];
			array[i]=temp;
		}
		printArray(false, array);
		return array;
	}
}
