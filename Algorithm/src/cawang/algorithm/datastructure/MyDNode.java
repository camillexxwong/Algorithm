package cawang.algorithm.datastructure;

public class MyDNode<E> {
	private MyDNode<E> previous;
	private MyDNode<E> next;
	private E value;
	
	public MyDNode(E e){
		value=e;
	}
	
	public MyDNode<E> getPrevious() {
		return previous;
	}
	public void setPrevious(MyDNode<E> previous) {
		this.previous = previous;
	}
	public MyDNode<E> getNext() {
		return next;
	}
	public void setNext(MyDNode<E> next) {
		this.next = next;
	}
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	
}
