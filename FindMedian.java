import java.io.File;
import java.io.IOException;

public class FindMedian {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Creating folder if it is not existing.
		File setsFolder = new File("sets/"); 
		if (!setsFolder.exists())
			setsFolder.mkdirs();
		
		// Creating data sets.
		Set.createSetSorted(); 
		Set.createSetRandom();
		Set.createSetReverseSorted();
		
		// Creating InsertionSort instances.
		InsertionSort sortedInsertion = new InsertionSort("Sorted");
		InsertionSort randomInsertion = new InsertionSort("Random");
		InsertionSort reverseSortedInsertion = new InsertionSort("ReverseSorted");
		
		// Processing InsertionSort instances.
		sortedInsertion.process();
		randomInsertion.process();
		reverseSortedInsertion.process(); 
		
		// Creating MergeSort instances.
		MergeSort sortedMerge = new MergeSort("Sorted");
		MergeSort randomMerge = new MergeSort("Random");
		MergeSort reverseSortedMerge = new MergeSort("ReverseSorted");
		
		// Processing MergeSort instances.
		sortedMerge.process();
		randomMerge.process();
		reverseSortedMerge.process();
		
		// Creating MaxHeap instances.
		MaxHeap sortedHeap = new MaxHeap("Sorted");
		MaxHeap randomHeap = new MaxHeap("Random");
		MaxHeap reverseSortedHeap = new MaxHeap("ReverseSorted");
		
		// Processing MaxHeap instances.
		sortedHeap.process();
		randomHeap.process();
		reverseSortedHeap.process();
		
		// Creating QuickSelect instances.
		QuickSelect sortedQuick = new QuickSelect("Sorted");
		QuickSelect randomQuick = new QuickSelect("Random");
		QuickSelect reverseSortedQuick = new QuickSelect("ReverseSorted");
		
		// Processing QuickSelect instances.
		sortedQuick.process();
		randomQuick.process();
		reverseSortedQuick.process();
		
		// Creating QuickSelect Median of Three instances.
		QuickSelect sortedQuickMOT = new QuickSelect("Sorted");
		QuickSelect randomQuickMOT = new QuickSelect("Random");
		QuickSelect reverseSortedQuickMOT = new QuickSelect("ReverseSorted");
		
		// Processing QuickSelect Median of Three instances.
		sortedQuickMOT.processMOT();
		randomQuickMOT.processMOT();
		reverseSortedQuickMOT.processMOT();
	}
}
