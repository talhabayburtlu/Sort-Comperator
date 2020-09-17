import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class QuickSelect extends Set {
	private int count;
	
	public QuickSelect(String theCase) throws IOException {
		super(theCase);
	}
	
	private int partition(int lower , int upper) { // Partitions normally.
		int pivot = getSet()[lower] , pivotLocation = lower; // Selecting pivot as first index.
		for (int i = lower + 1; i <= upper ; i++ ) { 
			if (getSet()[i] < pivot) { // If element is lower than pivot, it goes to the left side of pivot.
				swap(i,pivotLocation);
				pivotLocation++;
				setCount(getCount() + 1); 
			}	
		}
		
		return pivotLocation;
	}
	
	private int partitionByMOT(int lower , int upper) { // Partitions with median of three method.
		int pivotLocation = medianOfThree(lower, (lower + upper) / 2, upper); // Selecting pivot as median of lower, middle, and upper.
		swap(pivotLocation,upper);
		int pivot = getSet()[upper] , i = lower-1; // Swapping pivot with upper element.
		for (int j = lower ; j < upper ; j++) { // 
			if (getSet()[j] < pivot) { // If element is lower than pivot, it goes to the left side of pivot.
				i++;
				swap(i,j);
			}
			setCount(getCount() + 1);
		}
		
		swap(i+1,upper); // Inserting pivot to it's final location.
		return i+1;
	}
	
	private int medianOfThree(int lower, int middle , int upper) { // Finds median of three indexes.
		int arr[] = {getSet()[lower],getSet()[middle],getSet()[upper]};
		Arrays.sort(arr); 
		
		if (arr[1] == getSet()[lower])
			return lower;
		else if (arr[1] == getSet()[middle])
			return middle;
		else
			return upper;
	}
	
	private void swap(int index1, int index2) { // Swaps two given indexes.
		if (index1 != index2)
			setCount(getCount() + 1);
		int temp = getSet()[index2];
		getSet()[index2] = getSet()[index1];
		getSet()[index1] = temp;
	}
	
	private int findIthSmallest(int lower, int upper, int index) { // Finds Ith smallest in data set.
		int partition = partition(lower,upper);
		
		if (partition > index) { // If pivot is greater than searched index, reduce problem to the lower part.
			setCount(getCount() + 1); 
			return findIthSmallest(lower, partition - 1, index);
		}
		else if (partition < index) { // If pivot is lower than searched index, reduce problem to the upper part.
			setCount(getCount() + 1); 
			return findIthSmallest(partition + 1, upper, index);	
		}
		else
			return getSet()[index];
	}
	
	private int findIthSmallestWithMOT(int lower, int upper, int index) { // Finds Ith smallest in data set.
		int partition = partitionByMOT(lower,upper);
		
		if (partition > index) { // If pivot is greater than searched index, reduce problem to the lower part.
			setCount(getCount() + 1);
			return findIthSmallestWithMOT(lower, partition - 1, index);
		}
		else if (partition < index) { // If pivot is lower than searched index, reduce problem to the upper part.
			setCount(getCount() + 1);
			return findIthSmallestWithMOT(partition + 1, upper, index);
		}
		else {
			return getSet()[index];
		}
			
	}
	
	public int findMedian() { // Finds median with normal partitioning.
		findIthSmallest(0, getSet().length - 1, getSet().length / 2);
		
		return getSet()[getSet().length / 2]; // Returning median.
	}
	
	public int findMedianWithMOT() { // Finds median with median of three partitioning.
		findIthSmallestWithMOT(0, getSet().length - 1, getSet().length / 2); 
		
		return getSet()[0]; // Returning median.
	}
	
	public void process() throws FileNotFoundException { // Dynamically processes all data sets.
		long startTime , endTime;
		
		for (int i = 0; i < getQuickSelectSizes().length ; i++ , setCount(0)) {
			getSetWithSize(getQuickSelectSizes()[i]); // Getting data set with given size.
			startTime = System.nanoTime(); // Starting time.
			findMedian();
			endTime = System.nanoTime(); // Ending time.
			System.out.println(this.getClass().getName() + " -> " + getTheCase() +" -> Size " + getQuickSelectSizes()[i]+ " -> " + (endTime - startTime) + " nanoseconds -> Count -> " + getCount());
		}
		System.out.println();
		
	}
	
	public void processMOT() throws FileNotFoundException { // Dynamically processes all data sets with median of three partitioning.
		long startTime , endTime;
		
		for (int i = 0; i < getQuickSelectSizes().length ; i++ , setCount(0)) {
			getSetWithSize(getQuickSelectSizes()[i]); // Getting data set with given size.
			startTime = System.nanoTime(); // Starting time.
			findMedianWithMOT();
			endTime = System.nanoTime(); // Ending time.
			System.out.println(this.getClass().getName() + " MOT -> " + getTheCase() +" -> Size " + getQuickSelectSizes()[i]+ " -> " + (endTime - startTime) + " nanoseconds -> Count -> " + getCount());
		}
		System.out.println();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
