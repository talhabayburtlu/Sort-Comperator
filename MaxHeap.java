import java.io.FileNotFoundException;
import java.io.IOException;

public class MaxHeap extends Set{
	private int count;
	
	public MaxHeap(String theCase) throws IOException {
		super(theCase);
	}

	public int sort() {// Sorting current data set based on merge sort.
		int length = getSet().length ;
		for (int i = length / 2 - 1; i >= 0 ; --i) { // Building max heap with given data set.
			heapify(i,length);
		}
		
		for (int i = length - 1 ; i >= length / 2 ; i--) { // Extracting maximum n/2 times for finding median.
			// Swapping max element with last element
			int temp = getSet()[0];
			getSet()[0] = getSet()[i];
			getSet()[i] = temp;
			
			length -= 1;
			heapify(0,length); // Restoring max heap property.
		}
		
		return getSet()[0];
	}
	
	private void heapify(int root,int length) { // Restores max heap property.
		int largest = root, left = 2 * root + 1 , right = 2 * root + 2; // Determining left and right of root.
		
		if (left < length && getSet()[left] > getSet()[largest]) { // Checking if the left is the largest or not.
			largest= left;
		}
		setCount(getCount() + 1); 
		
		
		if (right < length && getSet()[right] > getSet()[largest]) { // Checking if the right is the largest or not.
			largest = right;
		}
		setCount(getCount() + 1); 
		
		if (largest != root) { // If there is max property violation, swap root with largest and call heapify for restoring max heap property for the largest. 
			int temp = getSet()[root];
			getSet()[root] = getSet()[largest];
			getSet()[largest] = temp;
			
			heapify(largest,length);
		}
		setCount(getCount() + 1);
	}
	
	public void process() throws FileNotFoundException { // Dynamically processes all data sets.
		long startTime , endTime;
		
		for (int i = 0; i < getSizes().length ; i++ , setCount(0)) {
			getSetWithSize(getSizes()[i]); // Getting data set with given size.
			startTime = System.nanoTime(); // Starting time.
			sort();
			endTime = System.nanoTime(); // Ending time.
			System.out.println(this.getClass().getName() + " -> " + getTheCase() +" -> Size " + getSizes()[i]+ " -> " + (endTime - startTime) + " nanoseconds -> Count -> " + getCount());
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
