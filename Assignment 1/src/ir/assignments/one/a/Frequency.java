package ir.assignments.one.a;

import java.util.Comparator;

/**
 * Basic class for pairing a word/2-gram/palindrome with its frequency.
 * 
 * DO NOT MODIFY THIS CLASS
 */
public final class Frequency{
	private final String word;
	private int frequency;

	public static void main(String[] args){
		System.out.println("Yes");
	}
	
	public Frequency(String word) {
		this.word = word;
		this.frequency = 0;
	}
	
	public Frequency(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}
	
	public String getText() {
		return word;
	}
	
	public int getFrequency() {
		return frequency;
	}
	public void incrementFrequency() {
		frequency++;
	}
	
	@Override
	public String toString() {
		return word + ":" + frequency;
	}

	public static Comparator<Frequency> FrequencyComparator = new Comparator<Frequency>() {
		public int compare(Frequency f1, Frequency f2) {

			if (f1.getFrequency() < f2.getFrequency()) {
				return -1;
			} else if (f1.getFrequency() == f2.getFrequency()) {
				return f1.getText().compareTo(f2.getText());
			} else {
				return 1;
			}
		}};



	}


