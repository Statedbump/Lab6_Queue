package implementation;

import java.util.Arrays;

import Interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {
private static final int IC = 4;
private E[] elements;
private int size, first;

public ArrayQueue() {
	elements = (E[]) new Object[IC];
	first = 0;
	size = 0;
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
		return elements[first];
		
	}

	@Override
	public void enqueue(E element) {
		if(size == elements.length) {
			this.changeCapacity(IC*2);
		}
		elements[(first +size)%elements.length] = element;
		size ++;
	}

	@Override
	public E dequeue() {
		if(isEmpty())
			return null;
		
		E etr = elements[first];
		elements[first]= null;
		first = (first +1)%elements.length;
		size --;
		if (elements.length >= 2*IC && size < elements.length/4)
            changeCapacity(elements.length/2); 
		return etr;
	}
	
	private void changeCapacity(int newCapacity) {
		if(newCapacity >= size) {
			E[] newArr = (E[]) new Object[newCapacity];
			for(int i =0; i<size;i++) {
				newArr[i] = elements[(first + i)%size];
				
			}
			elements = newArr;
			first = 0;
			
		}
	}
	public String toString() {
		return Arrays.toString(elements);
	}

}
