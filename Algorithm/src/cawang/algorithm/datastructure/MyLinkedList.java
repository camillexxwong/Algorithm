package cawang.algorithm.datastructure;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class MyLinkedList<E> implements List<E>{
	private int size;
	private MyDNode<E> first;
	private MyDNode<E> last;
	
	//Doesn't need constructor
	
	//Add to Last
	@Override
	public boolean add(E e) {
		MyDNode<E> newNode=new MyDNode<E>(e);
		if(size==0){
			first=newNode;
		}
		else{
			last.setNext(newNode);
			newNode.setPrevious(last);
		}
		last=newNode;
		size++;
		return true;
	}
	
	//std
	private void stdLinkLast(E e) {
        final MyDNode<E> l = last;
        final MyDNode<E> newNode = new MyDNode<E>(e);
        newNode.setPrevious(last);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.setNext(newNode);
        size++;
        //modCount++;
    }

	@Override
	public void add(int index, E element) {
		checkIndex(index);
		if(size==0||index==size) add(element); //not size-1
		if(index==0) addFirst(element);
		else{
			MyDNode<E> newNode=new MyDNode<E>(element);
			MyDNode<E> currentNode=getNode(index);
			newNode.setNext(currentNode);
			newNode.setPrevious(currentNode.getPrevious());
			currentNode.setPrevious(newNode);
		}
		
	}
	private void addFirst(E element){
		MyDNode<E> newNode=new MyDNode<E>(element);
		if(size==0){
			last=newNode;
		}
		else{
			first.setPrevious(newNode);
			newNode.setNext(last);
		}
		first=newNode;
		size++;
	}

	@Override
	public void clear() {
		size=0;
		first=null;
		last=null;
	}
	
    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void stdClear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (MyDNode<E> x = first; x != null; ) {
        	MyDNode<E> next = x.getNext();
        	x.setValue(null);
            x.setNext( null);
            x.setPrevious(null);
            x = next;
        }
        first = last = null;
        size = 0;
       // modCount++;
    }

	@Override
	public boolean contains(Object o) {
		return indexOf(o)>=0;
	}
	
	//O(n)
	@Override
	public E get(int index) {
		return getNode(index).getValue();
	}

	@Override
	public int indexOf(Object o) {
		//if( o.getClass()!=E) return-1;//No need to check type, 
		if(o==null){
			int i=0;
			for(MyDNode<E> node=first;node!=null;node=node.getNext()){ 
				if(node.getValue()==null)
					 return i;
				i++;
			}
		}
		else{
			//Better than loop i
			int i=0;
			for(MyDNode<E> node=first;node!=null;node=node.getNext()){ 
				if(o.equals(node.getValue()))
					 return i;
				i++;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public E set(int index, E element) {
		MyDNode<E> node=getNode(index);
		E oldVaule=node.getValue();
		node.setValue(element);
		return oldVaule;
	}

	@Override
	public int size() {
		return this.size;
	}

	private MyDNode<E> getNode(int index){
		checkIndex(index);
		if(index<(size>>1)){
			MyDNode<E> target=first;
			for(int i=1;i<index;i++){ //Not <=index
				target=target.getNext();
			}
			return target;
		}
		else{
			MyDNode<E> target=last;
			for(int i=size-1;i>index;i--){
				target=target.getPrevious();
			}
			return target;
		}
	}
	
	private void checkIndex(int index)	{
		if(index<0||index>size-1) throw new IndexOutOfBoundsException("invalid index: "+index);
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
	
	
	public String toString(){
		StringBuilder s=new StringBuilder("[");
		for (int i=0;i<size-1;i++){
			s.append(this.get(i)+",");
		}
		s.append(this.get(size-1)+"]");
		return s.toString();
	}
	
	public void std(){
		AbstractList<Integer> stdObj=new LinkedList<Integer>();
		Queue<String> queue = new LinkedList<String>();
		
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
		stdObj.removeAll(stdObj);
	}
	public static void main(String args[]){
		MyLinkedList<Integer> list=new MyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(list.toString());
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
	public boolean containsAll(Collection<?> c) {
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
