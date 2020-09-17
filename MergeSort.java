import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort extends Set {
	private int count = 0;
	
	public MergeSort(String theCase) throws IOException {
		super(theCase);
	}

	public int sort(int lower , int upper) { // Sorting current data set based on merge sort.
		if (lower < upper) {
			setCount(getCount() + 1); 
			int middle = (lower + upper) / 2;
			sort(lower,middle); // Sorting lower-middle part.
			sort(middle + 1 , upper); // Sorting middle - upper part.
			merge(lower,middle,upper); // Merging two subsets.
		}
		return getSet()[getSet().length / 2];
	}
	
	public void merge(int lower, int middle, int upper) {
		int firstSetSize = middle - lower + 1 , secondSetSize = upper-middle; // Setting subset sizes.
		int firstSubSet[] = Arrays.copyOfRange(getSet(), lower, lower + firstSetSize), secondSubSet[] = Arrays.copyOfRange(getSet(), middle + 1, middle + 1 + secondSetSize); // Creating subsets.

		int i = 0, j = 0, k = lower;
		while (i < firstSetSize && j < secondSetSize) { // Checking if one of the arrays becomes empty or not.
			if (firstSubSet[i] <= secondSubSet[j]) { // Checking which sub set's current index is lower. Lower one replaces original set. 
				getSet()[k] = firstSubSet[i];
				i++;
			} else {
				getSet()[k] = secondSubSet[j];
				j++;
			}
			setCount(getCount() + 1);
			k++;
		}		
		
		for (; i < firstSetSize ; i++, k++) { // Replacing remaining subset to corresponding places in original set.
			getSet()[k] = firstSubSet[i];
		}
		
		for (; j < secondSetSize ; j++, k++) { // Replacing remaining subset to corresponding places in original set.
			getSet()[k] = secondSubSet[j];
		}
	}
	
	public void process() throws FileNotFoundException, InterruptedException { // Dynamically processes all data sets.
		long startTime , endTime;
		
		for (int i = 0; i < getSizes().length ; i++ , setCount(0)) {		
			getSetWithSize(getSizes()[i]); // Getting data set with given size.
			startTime = System.nanoTime(); // Starting time.
			sort(0,getSizes()[i]- 1);
			endTime = System.nanoTime(); // Ending time.
			System.out.println(this.getClass().getName() + " -> " + getTheCase() +" -> Size " + getSizes()[i]+ " -> " + (endTime - startTime) + " nanoseconds -> Comparison -> " + getCount());
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
