package testerClases;

import Interfaces.Queue;
import implementation.ArrayQueue;
import implementation.SLLQueue;

public class Main {
	// Queue tester
public static void main(String[] args) {
	Queue<Integer> q1 = new SLLQueue<Integer>();
	Queue<Integer> q2 = new ArrayQueue<Integer>();
	 
	int dataL = 5;
	int[] q1Data = {1,3,5,7,9};
	int[] q2Data = {0,2,4,6,8};
	
	for(int i = 0 ; i< dataL; i++) {
		q1.enqueue(q1Data[i]);
		q2.enqueue(q2Data[i]);
	}
	System.out.println(q1.toString());
	System.out.println(q2.toString());
	
	System.out.println(q1.dequeue());
	System.out.println(q2.dequeue());
	
	System.out.println(q1.toString());
	System.out.println(q2.toString());


	q2.enqueue(10);
	q2.enqueue(11);
	q2.enqueue(12);
	q2.enqueue(13);
	
		
	System.out.println(q2.toString());
		 
}


}
