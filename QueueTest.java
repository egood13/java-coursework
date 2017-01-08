
// Test Queue class

import java.security.SecureRandom;

public class QueueTest
{
	public static void main(String[] args)
	{
		Queue<Integer> queue = new Queue<>();
		SecureRandom num = new SecureRandom();

		for (int i = 1; i <= 20; i++) // enqueue random integers from 1-6
		{
			queue.enqueue(1 + num.nextInt(6));
		}

		queue.print();

		// get all queue data for average
		System.out.println("Getting average...");
		int[] array = new int[20];
		for (int i = 1; i <= 20; i++)
		{
			array[i-1] = queue.getNode(i); // queue
		}
		
		System.out.printf("The average of all integers in queue is %.2f", getAverage(array));
	}

	public static double getAverage(int[] array)
	{
		// return double type average from integer list of array
		double total = 0.0;

		for (int element : array)
			total += element;

		return total/array.length;
	}

}
