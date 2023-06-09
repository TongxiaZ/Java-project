// -----------------------------------------------------
// Assignment 4
// Question: 2
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
 * The purpose of this class is to create objects of cellphone.
 * 
 * @author Tongxia Zhang, Liuxinyi Sun
 *
 */
package cell;
import java.util.Scanner;

public class CellPhone {
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**
	 * The parameterized constructor.
	 * @param serialNum
	 * @param brand
	 * @param price
	 * @param year
	 */
	public CellPhone(long serialNum, String brand, double price, int year) {
		this.serialNum=serialNum;
		this.brand=brand;
		this.year=year;
		this.price=price;
	}
	
	/**
	 * The copy constructor.
	 * @param c
	 * @param serialNum
	 */
	public CellPhone(CellPhone c, long serialNum) {
		this.serialNum=serialNum;
		this.brand=c.brand;
		this.year=c.year;
		this.price=c.price;
	}
	
	/**
	 * Getter for the serial number.
	 * @return
	 */
	public long getSerialNum() {
		return serialNum;
	}
	
	/**
	 * Getter for the brand.
	 * @return
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Getter for the year.
	 * @return
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Getter for the price.
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter for the serial number.
	 * @param serialNum
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum=serialNum;
	}
	
	/**
	 * Setter for the brand.
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand=brand;
	}
	
	/**
	 * Setter for the year.
	 * @param year
	 */
	public void setYear(int year) {
		this.year=year;
	}
	
	/**
	 * Setter for the price.
	 * @param price
	 */
	public void setPrice(double price) {
		this.price=price;
	}
	
	/**
	 * The clone method which prompt the user to enter a new serial number.
	 * Then it creates and return a deep copy of a CellPhone object.
	 */
	public CellPhone clone() {
		Scanner kb=new Scanner(System.in);
		System.out.println("Please enter a new serial number: ");
		long serialNum=kb.nextLong();
		CellPhone copy=new CellPhone(this, serialNum);
		return copy;
	}
	
	/**
	 * Equal method that compares 2 CellPhone objects.
	 */
	public boolean equals(Object o) {
		if(o==null)
			return false;
		else if(this.getClass()!=o.getClass())
			return false;
		else {
			CellPhone cp=(CellPhone) o;
			return this.brand.equals(cp.brand)&&this.year==cp.year&&this.price==cp.price;
		}
	}
	
	/**
	 * The toString method that return a string with all information.
	 */
	public String toString() {
		return "["+serialNum+": "+brand+" "+price+"$ "+year+"]";
	}
}
