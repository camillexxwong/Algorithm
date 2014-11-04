package cawang.algorithm.datastructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class MyStack<E>   implements List<E>{
	private Object[] elementData;
	private int size;
	private int capacity;
	private E top; //Not needed
/*	public MyStack(){
		super();
		elementData=new Object[100];
		this.capacity=100;
	}*/
	public MyStack(int capacity){
		super();
		this.capacity=capacity;
		elementData=new Object[capacity];
	}
	
	public void std(){
		Stack<Integer> stdStack=new Stack<Integer>();
		stdStack.add(1);
		stdStack.add(1, 1);
		stdStack.clear();
		stdStack.pop();
		stdStack.set(1, 1);
	}

	

	@Override
	public void clear() {
		size=0;
		capacity=0;
		for(Object e:elementData){
			e=null;
		}
		elementData=null;
	}

	@Override
	public int indexOf(Object o) {
		if(o==null){
			for(int i=0;i<size;i++){
				if (elementData[i]==null)return i;
			}
		}
		else{
			for(int i=0;i<size;i++){
				if (o.equals(elementData[i]))return i;
			}
		}
		return -1;
	}

	
	@Override
	public E set(int index, E element) {
		checkIndex(index);
		E oldEle=get(index);
		elementData[index]=element;
		return oldEle;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	public E pop(){
		if(size<=0)return null;
		E last=(E)elementData[--size];
		top=(E) elementData[size-1];
		return last;
		
		
	}
	public E push(E e){
		if(size==capacity)return null;
		elementData[size++]=e;
		top=(E) elementData[size-1];
		return e;
		
		
	}
	private void checkIndex(int index){
		if (index<0||index>this.size-1)
			throw new IndexOutOfBoundsException("invalid index: "+index);
	}
	

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
