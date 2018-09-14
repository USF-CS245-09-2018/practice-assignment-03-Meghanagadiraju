import java.util.Random;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;


	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}


	public int find_min_iterative () {
		
		double val = arr[0];//O(1)
		int min = 0;//0(1)
		for (int i = 1; i < arr.length; i++)//O(1)
		{	
			if (arr[i]<val)//O(n)
			{
				val = arr[i];//O(n)
				min = i;//O(n)
			}
			
		}
		return min;//O(1)


		// TODO: Fill in this iterative function.
	}	// = O(n)

	public int find_min_recursive () 
	{
	
		int min = 0;//O(1)
		return find_min_recursive (min, 1);//O(1)
	}

	public int find_min_recursive(int min, int element)
	{
		if (element > arr.length -1)//O(1)
		{
			return min;//O(1)
		}	
		if (arr[element]<arr[min])//O(1)
		{
			min = element;//O(1)
		}
		return find_min_recursive (min, element+1);//O(n)
	}

	// = O(n)


	
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative());
		System.out.println("Recursively determined min at index " + find_min_recursive());
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
