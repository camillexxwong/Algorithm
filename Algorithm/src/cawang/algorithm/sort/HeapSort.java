/**
 * 
 */
package cawang.algorithm.sort;

/**
 * @author cawang
 *
 */
public class HeapSort extends AbstractSort implements ISort{

	@Override
	public Comparable[] sort(Comparable[] array) {
		printArray(true, array);
		if(array==null) return null;
		int size=array.length-1;  //size is the biggest index
		for(int i=size/2;i>=0;i--){ //use sink to construct heap, after this, array is heap-sorted
			sink(array,i,size);
		}
		while(size>0){				//exchange max(root) with array[size], and sink new root
			exchange(array,0,size--);
			sink(array,0,size);
		}
		printArray(false, array);
		return array;
	}
	/**
	 * @param array
	 * @param changeIdx
	 * @param size: max accessible index; array.length-1 actually
	 * @return
	 * Same as BinaryHeapMax.sink(); move the size to parameter
	 * index start from 0
	 */
	private int sink(Comparable[] array, int changeIdx, int size){
		int parent=changeIdx;
		while(2*parent+1<=size){
			int child=2*parent+1; //child =left childe
			if(child!=size&&array[child].compareTo(array[child+1])<0) child++; // child=right child
			if(array[parent].compareTo(array[child])>=0) break;
			SortUtil.exchange(array, parent, child);
			parent=child;
		}
		return parent;
	}
	
}
