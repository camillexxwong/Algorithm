package cawang.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author cawang
 * Time: O(nlogN)
 * Use Random method to shuffle the array first, the closer the value to the middle, the better
 * 	防止最坏情况（每次选择的是最小、最大值）
 * Improvement:
 * 	1. During recursion, If high<low+M, use InsertionSort instead.
 *	2. Use Median as partition value, but need to calculate Median, use 三取样切分
 *	3. Use "guard" instead of boundary condition
 *	4. 三向切分，对于有大量重复元素的数组较好 , Page189, Dijkstra
 */
public class QuickSort extends AbstractSort {

	/* (non-Javadoc)
	 * @see sort.algorithm.cawang.AbstractSort#sort(java.lang.Comparable[])
	 * recursive
	 * sort in-place
	 */
	@Override
	public Comparable[] sort(Comparable[] array) {
		printArray(true, array);
		if(array==null) return null;
		//shuffle the array first
		List<Comparable> list=Arrays.asList(array); //the Array object inside ArrayList is set as array (reference!!)
		Collections.shuffle(list);  //this will change the array too!!!!
		//array=list.toArray(array);   //not necessary
		_sort_helper(array,0,array.length-1);
		printArray(false, array);
		return array;
	}
	
	public void _sort_helper(Comparable[] array, int low, int high) {
		if(low>=high) return;
		int med=_partition(array,low, high); //get the expected position of array[low]
		_sort_helper(array, low,med-1);   //Notice: med-1, not med; sort left half
		_sort_helper(array,med+1, high);  //sort right half
	}
	
	/**
	 * @param array
	 * @return
	 * 
	 * calculate the expected position of array[low], and put it to the right position
	 */
	private int _partition(Comparable[] array, int low, int high){
		//if(low>=high) return low;
		//assert low<high;
		int i=low;   //start from i+1
		int j=high+1; //start from high
		Comparable val=array[low];
		while(true){
			while(array[++i].compareTo(val)<=0)if(i==high) break; //++1 not i++; use ==, because ++i is in while condition
			while(array[--j].compareTo(val)>=0)if(j==low) break;
			if(i>=j) break;	//not >, not ==
			exchange(array,i,j);
		}
		exchange(array,low,j);
		return j;
	}
	
	public Comparable[] sort_ThreeWay(Comparable[] array){
		printArray(true, array);
		if(array==null) return null;
		List<Comparable> list=Arrays.asList(array); //the Array object inside ArrayList is set as array (reference!!)
		Collections.shuffle(list);  //this will change the array too!!!!
		_sort_ThreeWay_helper(array,0,array.length-1);
		printArray(false, array);
		return array;
	}

	/**
	 * @param array
	 * @param low
	 * @param high
	 * elements between [lt, i-1] are always same and equal to val
	 */
	private void _sort_ThreeWay_helper(Comparable[] array, int low, int high) {
		if (low>=high) return;
		int lt=low;  //lt is the left boarder of val
		int gt=high;  //gt is the right boarder of val
		int i=low+1;
		Comparable val=array[low];
		while(i<=gt){
			if(val.compareTo(array[i])>0) exchange(array, lt++, i++);
			else if(val.compareTo(array[i])<0) exchange(array, i, gt--);
			else i++;
		}
		_sort_ThreeWay_helper(array, low, lt-1);
		_sort_ThreeWay_helper(array, gt+1, high);
	}
	public void _sort_Median(){
		Arrays.sort(new int[]{1});
	}
	
	public Comparable[] sort_nonrecursive(Comparable[] array){
		printArray(true,array);
		if (array==null)return null;
		int low=0;
		int high=array.length-1;
		if(low>=high) return array; //important for case {1}
		Stack<Integer> stack=new Stack<Integer>();
		int med=_partition(array, low,high);
		if(med-1>low){  //{1,2,3} doesn't need to sorted anymore
			stack.push(med-1);
			stack.push(low);
		}
		if(med+1<high){
			stack.push(high);
			stack.push(med+1);
		}
		while(!stack.empty()){
			int sublow=stack.pop();
			int subhigh=stack.pop();
			int submed=_partition(array, sublow,subhigh);
			if(submed-1>sublow){  
				stack.push(submed-1);
				stack.push(sublow);
			}
			if(submed+1<subhigh){
				stack.push(subhigh);
				stack.push(submed+1);
			}
		}
		printArray(false,array);
		return array;
	}
}
