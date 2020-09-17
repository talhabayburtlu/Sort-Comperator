import java.io.FileNotFoundException;
import java.io.IOException;

public class InsertionSort extends Set{
	private int count = 0;
	
	public InsertionSort(String theCase) throws IOException {
		super(theCase);
	}
	
	public int sort() { // Sorting current data set based on insertion sort.
		for (int i = 0 ; i < getSet().length ; i++ , setCount(getCount() + 1)) { 
			int currKey = getSet()[i], j = i - 1; // Getting current key.
			
			//System.out.println(getSet()[j]);
			for (; (j != -1) && getSet()[j] > currKey ; j-- , setCount(getCount() + 1)) // Searching for a place in sorted side to insert current key.
				getSet()[j + 1] = getSet()[j];
			
			
			getSet()[j + 1] = currKey; // Inserting current key to the sorted side.
		}
		
		return getSet()[getSet().length / 2]; // Returning median value.
	}
	
	public void process() throws FileNotFoundException { // Dynamically processes all data sets.
		long startTime , endTime;
		
		for (int i = 0; i < getSizes().length ; i++ , setCount(0)) {
			getSetWithSize(getSizes()[i]); // Getting data set with given size.
			startTime = System.nanoTime(); // Starting time.
			sort();
			endTime = System.nanoTime(); // Ending time.
			System.out.println(this.getClass().getName() + " -> " + getTheCase() +" -> Size " + getSizes()[i]+ " -> " + (endTime - startTime) + " nanoseconds -> Counter -> " + getCount());
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
