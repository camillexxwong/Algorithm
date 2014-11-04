/**
 * 
 */
package cawang.algorithm.datastructure;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author cawang
 * @param <E>
 *
 */
public class MyArrayList<E> implements List<E> {
	private Object[] array;
	int size;
	int capacity;
	
	MyArrayList(){
		super();
		this.array=new Object[]{};//cannot change to E[], not supported
		
	}
	MyArrayList(int size) {
		//this.size=size;
		if(size<0)throw new IndexOutOfBoundsException("size<0");
		array=new Object[size];
		capacity=size;
	}
	
//O(n)
	@Override
	public boolean add(E e) {
		if (size<capacity)	{
			array[size++]=e;
			return true;
		}
		return false;
	}

	@Override
	public void add(int index, E element) {
		if(index>capacity||index<0||size==capacity)return;
			for(int i=size-1;i>=index;i--){
				array[i+1]=array[i];
			}
			array[index]=element;
	}// cannot append to tail
	//O(n)
	@Override
	public E remove(int index) {
		if(index>size-1||index<0)return null;
		E oldValue=(E)array[index]; //Cast cannot be avoided, safe cast
		for(int i=index;i<size-1;i++){
			array[i]=array[i++];
		}
		array[--size]=null; //important
		return oldValue;
	}
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public void clear() {
		for(int i=0;i<size;i++){
			array[i]=null;
		}
		size=0;
	}
	
	@Override
	public boolean contains(Object o) {
/*		for(int i=0;i<size;i++){
			if(array[i].equals((E)o)) return true;
		}
		return false;*/
		return indexOf(o)>=0;
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
	    for (Object e : c)
	        if (!contains(e))
	            return false;
	    return true;
	}
	@Override
	public int indexOf(Object o) {
		if (o==null){
			for(int i=0;i<size;i++){
				if (array[i]==null) //cannot call null.equals, otherwise need to add null check in following loop
					return i;
			}
		}
		else{
			for(int i=0;i<size;i++){
				if (o.equals(array[i])) //Notice: not array[i].equals(o), in case array[i] is null
					return i;
			}
		}
		return -1;
	}
	@Override
	public E get(int index) {
		if(index>=0&&index<size&&size>0)
			return (E) array[index];//safe cast
		return null;
	}

	
	public void std(){
		AbstractList<Integer> stdObj=new ArrayList<Integer>();
		
		stdObj.add(1);
		stdObj.add(1,2);
		stdObj.isEmpty();
		stdObj.clear();
		stdObj.contains(1);
		stdObj.indexOf(2);
		stdObj.get(1);
		stdObj.size();
		stdObj.remove(1);
		stdObj.containsAll(stdObj);
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
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
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
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
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
