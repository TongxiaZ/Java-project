// -----------------------------------------------------
// Assignment 4
// Question: 2
// Written by:  Tongxia Zhang id:40192534 and Liuxinyi Sun id:40187025
// -----------------------------------------------------
/**
 * 
 * @author Tongxia Zhang, Liuxinyi Sun
 * id: 40192534, 40187025
 * Assignment #4
 * Due Date 2022.4.15
 *
 */
/**
 * This class opens the Cell_Info.txt file and do the process.
 * 
 * @author Tongxia Zhang, Liuxinyi Sun
 *
 */
package cell;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {

	public static void main(String[] args) {
		/**
		 * Create two empty lists from CellList class.
		 */
		CellList list1=new CellList();
		CellList list2;
		long serialNum;
		File file =new File("/Users/tongxiazhang/Desktop/Cell_Info.txt");
		
		System.out.println("-------------------Welcome to Tongxia and Liuxinyi's Program-------------------");
		
		Scanner input=null;
		Scanner kb=new Scanner(System.in);
		try {
			input=new Scanner(new FileInputStream(file));
			System.out.println("The text file will be processed without duplicates.");
			while(input.hasNext()) {
				serialNum=input.nextLong();
				if(!list1.contains(serialNum))
					list1.addToStart(new CellPhone(serialNum, input.next(), input.nextDouble(), input.nextInt()));
				else {
					input.next();
					input.nextDouble();
					input.nextInt();
				}
			}
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			System.out.println("The contents and size of the list will be displayed.");
			list1.showContents();
			System.out.print("\nThe size of the list is: "+list1.getSize());
			
			/**
			 * Prompt the user to enter serial numbers.
			 */
			for(int i=0;i<3;i++) {
				System.out.print("\nPlease enter a serial number: ");
				serialNum=kb.nextLong();
				System.out.println("The serial number is "+list1.contains(serialNum));
				System.out.println("The serial number is "+list1.find(serialNum));
			}
			CellPhone iPhone20=new CellPhone(2011815,"Cookie",508.10,2011);
			
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			System.out.println("Now let's replace index 2 in the list with an iPhone20.");
			
			list1.replaceAtIndex(iPhone20, 2);
			list1.showContents();
			
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			System.out.println("Now let's insert iPhone20 into the 6th index.");
			list1.insertAtIndex(iPhone20, 6);
			list1.showContents();
			
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			System.out.println("Now let's make a copy of the list and then delete nodes.");
			list2=new CellList(list1);
			list2.deleteFromStart();
			System.out.println("Let's delete the node of index 7.");
			list2.deleteFromIndex(7);
			list2.showContents();
			System.out.println("The equal lists are "+list1.equals(list2));
			
			System.out.println("--------------------------------------------------------------");
			System.out.println();
			System.out.println("Let's test with another object.");
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			System.out.println("Now let's replace index 1 in the list with an iPhone21.");
			CellPhone iPhone21=new CellPhone(1111111,"Ashley",100.00,2000);
			list1.replaceAtIndex(iPhone21, 1);
			list1.showContents();
			
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			System.out.println("Now let's insert iPhone21 into the 3th index.");
			list1.insertAtIndex(iPhone21, 3);
			list1.showContents();
			
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			System.out.println("Now let's make a copy of the list and then delete nodes.");
			list2=new CellList(list1);
			list2.deleteFromStart();
			System.out.println("Let's delete the node of index 1.");
			list2.deleteFromIndex(1);
			list2.showContents();
			System.out.println("The equal lists are "+list1.equals(list2));
			
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			System.out.println("Thanks for using the program.");
			
		}catch(FileNotFoundException e) {
			System.out.println("File "+file+" cannot be found/opened. The system will terminate.");
			System.exit(0);
		}
		finally {
			input.close();
			kb.close();
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
