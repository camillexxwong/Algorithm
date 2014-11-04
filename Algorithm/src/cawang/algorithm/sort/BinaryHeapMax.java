package cawang.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryHeapMax<T extends Comparable<T>> {
	private int size;
	private T[] array; //size=heap size+1, array[0] doesn't store element
	private int capacity;
	protected BinaryHeapMax(){
		super();
		this.capacity=20;
		this.array=(T[]) Array.newInstance(Comparable.class, capacity);
		this.size=0;
	}
	
	public BinaryHeapMax(int capacity){
		super();
		this.array=(T[]) Array.newInstance(Comparable.class, capacity);
		this.size=0;
		this.capacity=capacity;
	}
	
	/**
	 * @param array: start from array[1]
	 * @param capacity
	 */
	public BinaryHeapMax(T[] array, int capacity){
		super();
		this.array=Arrays.copyOf(array, capacity);
		this.size=array.length;
		this.capacity=capacity;
	}
	
	/**
	 * @param k
	 * @return return the new index 
	 * re-sort (in-place) when some child is child and may be bigger than parent 
	 * index start from 1
	 */
	private int swim(int changeIdx){
		int i=changeIdx;
		//int parent=changeIdx/2;
		while(i>1&&array[i].compareTo(array[i/2])>0){ //root is array[1]
			SortUtil.exchange(array, changeIdx, changeIdx/2);
			i/=2;
		}
		return i;
	}
	
	/**
	 * @param k
	 * @return return the new index
	 * re-sort (in-place) when some parent is changed and may be smaller than child 
	 * index start from 1
	 */
	private int sink(int changeIdx){
		int parent=changeIdx;
		while(2*parent<=size){
			int child=2*parent; //child =left childe
			if(child!=size&&array[child].compareTo(array[child+1])<0) child++; // child=right child
			if(array[parent].compareTo(array[child])>=0) break;
			SortUtil.exchange(array, parent, child);
			parent=child;
		}
		return parent;
	}
	
	/**
	 * @param val: the value to be insert
	 * @return return the new index
	 */
	private int insert(T val){
		if(size==capacity) return-1;
		array[++size]=val; //not size++
		return swim(size);
	}
	
	

	/**
	 * return the max element
	 */
	public T peekMax(){
		return array[1];
	}
	/**
	 * delete the max element
	 */
	public T popMax(){
		if(isEmpty()) return null;
		T oldRoot=array[1]; //Better to use clone(), how to do?? //No need...
		array[1]=array[size--];
		array[size+1]=null;
		sink(1);
		return oldRoot;
	}
	public boolean isEmpty(){
		return this.size<=0;
	}
	public int size(){
		return this.size;
	}
	
	public  static void main(String[] main){
		//_test();
	}
	private static void _test(){
		BinaryHeapMax a=new BinaryHeapMax(1);
		BinaryHeapMax b=a;
		System.out.println(a==b);
		a=new BinaryHeapMax(1);
		System.out.println(a==b);
	}
}
