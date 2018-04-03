package testerClases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Interfaces.Queue;
import implementation.ArrayQueue;
import implementation.SLLQueue;

import java.util.regex.Pattern;



public class Exercise2Main {

	public static void main(String[] args) throws FileNotFoundException {
		for(int i =1; i<=3; i++) {
		//DataReader
		Scanner time = new Scanner(new File("input"+i+".txt")).useDelimiter("\\D");
		
		//List && Queues
		SLLQueue<Job> q1 = new SLLQueue<>();
		ArrayQueue<Job> q2 = new ArrayQueue<>();
		ArrayList<Job> jobList = new ArrayList<>();
		
		
		int timeCheck = 0;
		
		int id = 1;
		while(time.hasNextInt()) {
			Job newJob = new Job(id, time.nextInt(), time.nextInt());
			q1.enqueue(newJob);
			id++;
		}
		time.close();

		while(!(q1.isEmpty()) || !(q2.isEmpty())) {
			if(!(q2.isEmpty())) {
				q2.first().isServed(1);
				if(q2.first().getRemainingTime() == 0) {
					q2.first().setDepartureTime(timeCheck);
					jobList.add(q2.dequeue()); 
				}
				else
					q2.enqueue(q2.dequeue());
			}
			if(!(q1.isEmpty()) && q1.first().getArrivalTime() == timeCheck)
				q2.enqueue(q1.dequeue());
			timeCheck++;	
		}
		
		// Compute final statistics
		double avg = 0;
		for(Job j : jobList) {
			int totalTime = j.getDepartureTime() - j.getArrivalTime();
			avg += totalTime;
		}
		avg = avg / jobList.size();
		
		System.out.println("Average Time in System is: " + avg);
	}
	}
}

