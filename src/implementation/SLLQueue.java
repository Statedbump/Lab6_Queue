package implementation;

import Interfaces.Queue;

public class SLLQueue<E> implements Queue<E> {
	
	private static class Node<E> { 
		private E element; 
		private Node<E> next;
		public Node(E e) {
			element = e;
			next = null;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
} 
	

	private Node<E>  first,last;

	private int size;
	
	public SLLQueue() {
		first = last = null;
		size = 0 ;
	}
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public E first() {
		if(isEmpty())
		return null;
		
		return first.getElement();
	}

	@Override
	public void enqueue(E element) {
		
		if (size == 0) 
            first = last = new Node<E>(element); 
        else { 
           last.setNext(new Node<E>(element));
           last = last.getNext();
        }
        size++; 
   
	}

	@Override
	public E dequeue() {
		if (isEmpty()) 
			return null;
		Node<E> ntr = first;
		first = first.getNext();
		if(size == 1 ) {
			last = null;
		}
		size --;
		E etr = ntr.getElement();
		
		return etr;
}
	public String toString() {
		Node<E> t = first;
		String s = "{";
		boolean temp = true;
				if(isEmpty())
					return "{ }";
				
				while(t!= null) {
					if(temp == true) {
						s = s + t.getElement();
						temp = false;
					}else {
						s = s + "," +  t.getElement();
					}
					t = t.getNext();
				}
				return s + "}" ;
	}
}