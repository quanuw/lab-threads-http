import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

/**
 * A class that races sorting algorithms.
 *
 * @author Joel Ross
 */
public class SortRacer {

	public static void main(String[] args)
	{

        // Start mergeSort.
        (new Thread(new MergeSort())).start();
        // Start quicksort.
        (new Thread(new QuickSort())).start();
	}


	/**
	 * A utility method that returns a shuffled (randomly sorted) array of integers from 1 to the given number.
	 * @param n The number of numbers to shuffle
	 * @param seed A random seed, if less than 0 then unseeded
	 * @return An array of shuffled integers
	 */
	public static Integer[] shuffled(int n, int seed)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			nums.add(i+1);
		}
		if(seed >= 0)
			Collections.shuffle(nums, new Random(seed));
		else
			Collections.shuffle(nums);
		return nums.toArray(new Integer[0]);
	}

    // nested class for mergesort implements Runnable interface
    public static class MergeSort implements Runnable {
        public void run() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSSS"); //for output
            Integer[] nums = shuffled((int)Math.pow(10,7), 448);
            System.out.println("Starting merge sort at "+dateFormat.format(new Date()));
            Sorting.mergeSort(nums);
            System.out.println("Merge sort finished at "+dateFormat.format(new Date())+" !");
        }
    }

    // nested class for quicksort implements Runnable interface
    public static class QuickSort implements Runnable {
        public void run() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSSS"); //for output
            Integer[] nums = shuffled((int)Math.pow(10,7), 448);
            nums = shuffled((int)Math.pow(10,7), 448); //a list of shuffled 10 million numbers
            System.out.println("Starting quicksort at "+dateFormat.format(new Date()));
            Sorting.quickSort(nums);
            System.out.println("Quicksort finished at "+dateFormat.format(new Date())+" !");
        }
    }
}
