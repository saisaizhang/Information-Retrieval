package ir.assignments.one.a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * A collection of utility methods for text processing.
 */
public class Utilities {
	public static void main(String[] args ){
		String str= "analysis1.txt";
		File input = new File(str);
		ArrayList<String> rslt = tokenizeFile(input);
		for ( int i = 0; i<rslt.size(); i++){
			System.out.println(rslt.get(i));
		}
	}

	/**
	 * Reads the input text file and splits it into alphanumeric tokens.
	 * Returns an ArrayList of these tokens, ordered according to their
	 * occurrence in the original text file.
	 * 
	 * Non-alphanumeric characters delineate tokens, and are discarded.
	 *
	 * Words are also normalized to lower case. 
	 * 
	 * Example:
	 * 
	 * Given this input string
	 * "An input string, this is! (or is it?)"
	 * 
	 * The output list of strings should be
	 * ["an", "input", "string", "this", "is", "or", "is", "it"]
	 * 
	 * @param input The file to read in and tokenize.
	 * @return The list of tokens (words) from the input file, ordered by occurrence.
	 */
	public static ArrayList<String> tokenizeFile(File input) {
		ArrayList<String> rslt = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			String line;

			while (true){
				line = br.readLine();
				if (line == null) break;
				List<String> linesplit = Arrays.asList(line.split(" "));
				for ( int i =0;i<linesplit.size();i++) {
					rslt.add(linesplit.get(i));
				}



			}
			return rslt;


		}catch (FileNotFoundException e){
			System.out.println("File not found");
		}catch (IOException e){
			System.out.print("no lines left");
		}
		return rslt;



	}
	
	/**
	 * Takes a list of {@link Frequency}s and prints it to standard out. It also
	 * prints out the total number of items, and the total number of unique items.
	 * 
	 * Example one:
	 * 
	 * Given the input list of word frequencies
	 * ["sentence:2", "the:1", "this:1", "repeats:1",  "word:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total item count: 6
	 * Unique item count: 5
	 * 
	 * sentence	2
	 * the		1
	 * this		1
	 * repeats	1
	 * word		1
	 * 
	 * 
	 * Example two:
	 * 
	 * Given the input list of 2-gram frequencies
	 * ["you think:2", "how you:1", "know how:1", "think you:1", "you know:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total 2-gram count: 6
	 * Unique 2-gram count: 5
	 * 
	 * you think	2
	 * how you		1
	 * know how		1
	 * think you	1
	 * you know		1
	 * 
	 * @param frequencies A list of frequencies.
	 */
	public static void printFrequencies(List<Frequency> frequencies) {
		int totalCount = 0;
		int uniqueCount = 0;
		for ( int i = 0; i<frequencies.size(); i++){
			Frequency one = frequencies.get(i);
			uniqueCount +=1;
			totalCount += one.getFrequency();
		}
		System.out.println("Total item count: "+totalCount);
		System.out.println("Unique item count: "+uniqueCount);
		System.out.println("\n");

		String word = new String();
		int count = 0;
		for ( int i =0; i<frequencies.size(); i++){
			Frequency one = frequencies.get(i);
			word= one.getText();
			count = one.getFrequency();
			System.out.format("%s",word);
			System.out.print("\t");
			System.out.format("%d%n",count);

		}
	}
}
