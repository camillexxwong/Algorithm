package cawang.algorithm.sort;

/**
 * @author cawang
 * Time: O(nlogN)
 * Space: O(n)
 */
public class MergeSort extends AbstractSort implements ISort{	

	@Override
	public Comparable[] sort(Comparable[] array) {
		return sort_recursive(array);
		//return null;
	}
	
	public Comparable[] sort_nonrecursive(Comparable[] array) {
		printArray(true,array);
		if(array==null)return null;
		for(int size=1;size<array.length;size*=2){ //size is the size of {low, mid}
			for( int low=0;low<array.length-size;low+=size*2){
				merge(array,low,low+size-1,Math.min(low+2*size-1, array.length-1));
			}
		}
		
		printArray(false,array);
		return array;
	}
	

	public Comparable[] sort_recursive(Comparable[] array) {
		super.printArray(true,array);
		if(array==null)return null;
		_sort_recursive_helper(array, 0, array.length-1);
		super.printArray(false,array);
		return array;
	}
	
	private void _sort_recursive_helper(Comparable[] array, int low, int high){
		if(high<=low) return;
		int mid=low+(high-low)/2;
		_sort_recursive_helper(array, low, mid);
		_sort_recursive_helper(array, mid+1, high); //mid+1
		merge(array, low, mid, high);
	}

	/**
	 * @param array
	 * @param low
	 * @param mid
	 * @param high
	 * merge in place
	 * It's better to declare newArray s local var of _sort_recursive_helper
	 */
	private void merge(Comparable[] array, int low, int mid, int high) {
		if(array[mid].compareTo(array[mid+1])<=0)return; //sorted array will be lineary if adding this line
		//System.out.println(""+low+mid+high);
		Comparable[] newArray=new Comparable[high-low+1];
		int i=low;
		int j=mid+1;
		for(int k=0;k<newArray.length;k++){ //dont't use i<=high&&j<=high, actually the upper boarder is high+1
			//System.out.println("k: "+k+", j: "+j+", i: "+i);
			if(i>mid)	newArray[k]=array[j++];
			else if(j>high)	newArray[k]=array[i++];
			else if(array[i].compareTo(array[j])<0)	newArray[k]=array[i++];
			else newArray[k]=array[j++];
		}
		//array=newArray;// won't work, because the parameter array still pointing to the old object, must use deep clone
		for(int k=0;k<newArray.length;k++){
			array[low+k]=newArray[k];
		}
	}
}
