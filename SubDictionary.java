// -----------------------------------------------------
// Assignment 4
// Question: 1
// Written by:  Tongxia Zhang id:40192534 and Liuxinyi Sun id:40187025
// -----------------------------------------------------
/**
 * 
 * @author Tongxia Zhang, Liuxinyi Sun
 * id: 40192534
 * Assignment #4
 * Due Date 2022.4.15
 *
 */
/**
 * The purpose of this program is to read an input text and then generate a sub dictionary.
 * Numbers, symbols, abbreviation and single letters (except A and I) are removed.
 * The words will be capital and stored in alphabetical order.
 * 
 * @author Tongxia Zhang, Liuxinyi Sun
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SubDictionary{
	/**
	/**
	 * Remove things.
	 */
	public static String remove(Scanner process) {
		String word=process.next().toUpperCase();
		if(word.length() == 1 && !word.equalsIgnoreCase("a") && !word.equalsIgnoreCase("i") ||word.contains("0") || word.contains("1") || word.contains("2") || word.contains("3") || word.contains("4") ||
                word.contains("5") || word.contains("6") || word.contains("7") || word.contains("8") || word.contains("9"))
            return null;
        else if(word.endsWith(",") || word.endsWith("?") || word.endsWith(":") ||word.endsWith(";") || word.endsWith("!") || word.endsWith(".")||word.endsWith("="))
            return word.substring(0, word.length() - 1);
        else if(word.contains("'"))
            return word.substring(0, word.length() - 2);
        else {
            return word;
        }
	}
	
	/**
	 * This method is to check if there is any duplicated word.
	 */
	public static boolean alreadyIn(String test, ArrayList<String> Dictionary) {
		for(String word:Dictionary)
			if(test.equalsIgnoreCase(word))
				return true;
		return false;
	}
	/**
	 * If the first number variable indexed has value, this method will sort the array list
	 * to let it be in increasing order.
	 * @param array
	 * @param number is the number of indexes in the list.
	 */
	public static void sort(ArrayList<String> array, int number){
        int index;
        int secondSmall;
        for(index = 0;index < number- 1;index++){
            secondSmall = smallest(index, array, number);
            change(index, secondSmall, array);
        }
	}
	
	/**
	 * This method is to return the index of the smallest value in the array.
	 * @param start
	 * @param array
	 * @param number
	 * @return
	 */
	public static int smallest(int start, ArrayList<String> array, int number) {
		String min=array.get(start);
		int indexOfMin=start;
		int index;
		for(index=start+1;index<number;index++) {
			/**
			 * min is the smallest of array[start].
			 * If array[index] is less than min.
			 */
			if(array.get(index).compareTo(min)<0) {
				min=array.get(index);
				indexOfMin=index;
			}
		}
		return indexOfMin;
	}
	
	public static void change(int ind1, int ind2, ArrayList<String>array) {
		String tem;
		tem=array.get(ind1);
		array.set(ind1, array.get(ind2));
		array.set(ind2, tem);
	}
	
	/**
	 * The method sort the ArrayList object into an alphabetical order.
	 */
	public static ArrayList<String> sortWords(ArrayList<String> unordered){
		ArrayList<String> ordered=new ArrayList<String>();
		for(String s:unordered) {
			String curArray;
			curArray=s.toUpperCase();
			/**
			 * Remove symbols.
			 */
			if(curArray.indexOf(',')!=-1) {
				curArray=curArray.substring(0,(curArray.length()-1));
			}
			if(ordered.size()!=(0)) {
				for(int i=0;i<ordered.size();i++) {
					if(curArray.contains("=")) {
						break;
					}
					/**
					 * If a word appears more than once, it won't be stored again.
					 */
					String same=ordered.get(i);
					if(curArray.equals(same)) {
						break;
					}
					else {
						break;
					}
				}
			}
			else {
				ordered.add(curArray);
			}
		}
		return ordered;
	}
	
	public static void main(String[]args) {
		int count=0;
		char title=' ';
		Scanner kb=new Scanner(System.in);
		Scanner input=null;
		PrintWriter output=null;
		String name=null;
		ArrayList<String> dictionary=new ArrayList<String>();
		
		System.out.println("--------------------Welcome to Tongxia and Liuxinyi's Sub-Dictionary Creator-------------------");
		System.out.println("Please enter the path of the file: ");
		name=kb.nextLine();
		
		try {
			input=new Scanner(new FileInputStream(name));
			output=new PrintWriter(new FileOutputStream("SubDictionary.txt"));
			while(input.hasNext()) {
				name=remove(input);
				if(name!=null&&!alreadyIn(name, dictionary)) {
					dictionary.add(name);
					count++;
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File cannot be found. The program will terminate.");
			System.exit(0);
		}
		sort(dictionary, dictionary.size());
		output.println("There are "+count+" entries in the txt file.");
		for(String word: dictionary) {
			if(word.charAt(0)!=title) {
				title=word.charAt(0);
				output.println("\n"+title+"\n= =");
				output.println(word);
			}
			else
				output.println(word);
		}
		System.out.println("The Sub_Dictionary.txt file is created.");
		System.out.println("There are "+count+" entries in the txt file.");
		System.out.println("Thanks for using.");
		
		input.close();
		output.close();
		kb.close();
	}
}









