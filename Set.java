import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Set {
	private static int sizes[] = {5000,10000,15000,20000,25000,30000,35000,40000}; // Sizes of data sets excluding QuickSelect.
	private static int quickSelectSizes[] = {2500,5000,7500,10000,12500,15000,17500}; // Sizes of data sets only for QuickSelect.
	private static Writer outFileWriter = null;
	private int set[]; // Data set.
	private String theCase; // Input type.

	public Set(String theCase) {
		this.theCase = theCase;
	}
	
	private static void createSetSortedWithSize(int size) throws IOException { // Creating sorted set with given size.
		outFileWriter = new FileWriter("sets/Sorted-" + size + ".txt");
		for (int i = 0, last = 0; i < size ; i++) {
			last += (int)((1 + Math.random() * 4));
			outFileWriter.append(last + " ");
		}
		outFileWriter.close();
	}
	
	private static void createSetRandomWithSize(int size) throws IOException { // Creating random set with given size.
		outFileWriter = new FileWriter("sets/Random-" + size + ".txt");
		for (int i = 0 ; i < size ; i++)
			outFileWriter.append((int)((1 + Math.random() * (size -1))) + " ");
		outFileWriter.close();
	}
	
	private static void createSetReverseSortedWithSize(int size) throws IOException { // Creating reverse sorted set with given size.
		outFileWriter = new FileWriter("sets/ReverseSorted-" + size + ".txt");
		for (int i = 0, last = size * 5 ; i < size ; i++) {
			last -= (int)((1 + Math.random() * 4));
			outFileWriter.append(last + " ");
		}
		outFileWriter.close();
	}
	
	public void getSetWithSize(int size) throws FileNotFoundException { // Getting size for current input type.
		int newSet[] = new int[size];
		
		Scanner setFile = new Scanner(new File("sets/" + theCase + "-" + size + ".txt"));
		for (int i = 0; i < size && setFile.hasNextInt(); i++)
			newSet[i] = setFile.nextInt();
		
		this.setSet(newSet);
		setFile.close();
	}
	
	public static void createSetSorted() throws IOException { // Creating sorted sets based on dynamic sizes.
		for (int i = 0 ; i < getSizes().length ; i++)
			createSetSortedWithSize(getSizes()[i]);
		for (int i = 0; i < getQuickSelectSizes().length ; i++)
			createSetSortedWithSize(getQuickSelectSizes()[i]);
	}
	
	public static void createSetRandom() throws IOException {  // Creating random sets based on dynamic sizes.
		for (int i = 0 ; i < getSizes().length ; i++)
			createSetRandomWithSize(getSizes()[i]);
		for (int i = 0; i < getQuickSelectSizes().length ; i++)
			createSetRandomWithSize(getQuickSelectSizes()[i]);
	}
	
	public static void createSetReverseSorted() throws IOException { // Creating reverse sorted sets based on dynamic sizes.
		for (int i = 0 ; i < getSizes().length ; i++)
			createSetReverseSortedWithSize(getSizes()[i]);
		for (int i = 0; i < getQuickSelectSizes().length ; i++)
			createSetReverseSortedWithSize(getQuickSelectSizes()[i]);
	}
	
	
	// Getter and Setter methods.
	public int[] getSet() {
		return set;
	}

	public void setSet(int set[]) {
		this.set = set;
	}
	
	public String getTheCase() {
		return theCase;
	}

	public void setTheCase(String theCase) {
		this.theCase = theCase;
	}

	public static int[] getSizes() {
		return sizes;
	}

	public static void setSizes(int newSizes[]) {
		sizes = newSizes;
	}
	
	public static int[] getQuickSelectSizes() {
		return quickSelectSizes;
	}

	public static void setQuickSelectSizes(int[] quickSelectSizes) {
		Set.quickSelectSizes = quickSelectSizes;
	}
}
