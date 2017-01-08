// Example of bubble sort algorithm and big O notation from coursework for M.S. Operations Research 

//Bubble Sort O(n^2)

/*
The bubble sort is an O(n^2) algorithm due to the fact that it requires
two loops to complete the sort. The first loop controls when the algorithm
can end and can potentially loop n times to get the last element to the
first position. Furthermore, the inner loop compares each successive
pair of elements starting at n-1 times, then n-2, and so on until we get to
one. So a loop can take n*((n-1)+(n-2)+(n-3)+...); since the n^2 piece
dominates as n becomes large, we get O(n^2).
*/

public class BubbleSort
{
	public static void main(String[] args)
	{
		// test method bubbleSort
		int[] array1 = {20,5,4,11,2,14,2,5,50,12,44};
		System.out.print("Original array: ");
		printArray(array1);
		System.out.print("Sorted array:   ");
		bubbleSort(array1);
		printArray(array1);
	}
	
	public static void bubbleSort(int[] array)
	{
		int valueHolder = 0; // value holder to swap elements
		boolean sorted = false; // boolean to indicate when all elements are sorted
		int counter = array.length - 2; // counter to track when loop can end
		
		while (!sorted)
		{
			sorted = true; // run sort until no switches occur

			for (int i = 0; i <= counter; i++)
			{
				if (array[i] > array[i+1])
				{
					valueHolder = array[i];
					array[i] = array[i+1];
					array[i+1] = valueHolder;
					sorted = false;
				}
			}
			counter--;
		}
	}

	public static void printArray(int[] array)
	{
		// method to print 1D array of ints
		System.out.print("[");
		for (int element : array)
		{
			if (element == array[array.length - 1])
			{
				System.out.printf("%d]\n", element);	
			}
			else
			{
				System.out.printf("%d\t", element);
			}
		}
	}
}

