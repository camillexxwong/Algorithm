package cawang.algorithm.sort;

/**
 * @author cawang
 *
 * @param <T>
 */
public class PriorityQueue<T extends Comparable<T>> {
	private Comparable[] array; //size=heap size+1, array[0] doesn't store element
	private int size;
	private int capacity;
	/**
	 * 
	 */
	public PriorityQueue(){
		super();
	}
	public PriorityQueue(int maxSize){
		super();
		capacity=maxSize;
	}
	public PriorityQueue(T[] array){
		super();
		this.array=array;
		this.size=array.length;
	}
	
	public void insert(T value){
		
	}
	/**
	 * return the max element
	 */
	public T peekMax(){
		return null;
	}
	/**
	 * delete the max element
	 */
	public T popMax(){
		return null;
	}
	public boolean isEmpty(){
		return false;
	}
	public int size(){
		return -1;
	}
	
	
}
