/**
 * Assignment #2 - Question #1
 * @author Steffen L. Norgren - A00683006
 *
 */
import java.util.Calendar;

public class Quicksort {

	public Quicksort() {	
	}
	
	public void sort(int[] input) {
		this.sort(input, 0, input.length - 1);
	}
	
	public void sort(int[] input, int left, int right) {
		if (right <= left) {
			return;
		}
		else {
			int pivot = this.partition(input, left, right);
			this.sort(input, left, pivot - 1);
			this.sort(input, pivot + 1, right);
		}
	}
	
	private int partition(int[] input, int left, int right) {
        int i = left - 1;
        int j = right;
        
        while (true) {
            while (input[++i] < input[right]) {
                ; // do nothing, just iterate
            }
            
            while (input[--j] > input[right]) {
                if (j == left) {
                	break;
                }
            }
            
            if (i >= j) {
            	break;            
            }
            
            swap(input, i, j);
        }
        
        swap(input, i, right);
        return i;
	}
	
	private void swap(int[] input, int xPos, int yPos) {
		int xVal = input[xPos];
		
		input[xPos] = input[yPos];
		input[yPos] = xVal;
	}
	
	public void runTests(int runTimes) {
		ArrayUtils au = new ArrayUtils();
		
		// Store time averages & set # of run times
		double[] avg = new double[12];		
		
		// Run Quicksort tests
		System.out.println("Running Quicksort " + runTimes + " times...");
		for (int i = 0; i < runTimes; i++) {
			avg[0] += testSort(au.CreateRandom(100, 1, 100));
			avg[1] += testSort(au.CreateRandom(1000, 1, 100));
			avg[2] += testSort(au.CreateRandom(10000, 1, 100));
			avg[3] += testSort(au.CreateRandom(100000, 1, 100));

			avg[4] += testSort(au.CreateSequential(100));
			avg[5] += testSort(au.CreateSequential(1000));
			avg[6] += testSort(au.CreateSequential(10000));
//			avg[7] += testSort(au.CreateSequential(100000));
			
			avg[8] += testSort(au.CreateDecremental(100));
			avg[9] += testSort(au.CreateDecremental(1000));
			avg[10] += testSort(au.CreateDecremental(10000));
//			avg[11] += testSort(au.CreateDecremental(100000));
		}
		
		System.out.println("Random with size n = 10^2: " + (avg[0] / runTimes) + "ms");
		System.out.println("Random with size n = 10^3: " + (avg[1] / runTimes) + "ms");
		System.out.println("Random with size n = 10^4: " + (avg[2] / runTimes) + "ms");
		System.out.println("Random with size n = 10^5: " + (avg[3] / runTimes) + "ms");

		System.out.println("Sequential with size n = 10^2: " + (avg[4] / runTimes) + "ms");
		System.out.println("Sequential with size n = 10^3: " + (avg[5] / runTimes) + "ms");
		System.out.println("Sequential with size n = 10^4: " + (avg[6] / runTimes) + "ms");
		System.out.println("Sequential with size n = 10^5: Throws a stack overflow");
		
		System.out.println("Decremental with size n = 10^2: " + (avg[8] / runTimes) + "ms");
		System.out.println("Decremental with size n = 10^3: " + (avg[9] / runTimes) + "ms");
		System.out.println("Decremental with size n = 10^4: " + (avg[10] / runTimes) + "ms");
		System.out.println("Decremental with size n = 10^5: Throws a stack overflow");

	}
	
	private double testSort(int[] input) {

		double start = Calendar.getInstance().getTimeInMillis();		
		this.sort(input);
		double end = Calendar.getInstance().getTimeInMillis();
		
		return (end - start);
	}
}
