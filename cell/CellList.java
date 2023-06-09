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
 * This class is a linked list with an inner class CellNode.
 * 
 * @author Tongxia Zhang, Liuxinyi Sun
 *
 */
package cell;
import java.util.NoSuchElementException;

public class CellList {
	
	
	private class CellNode{
		private CellPhone Phone;
		private CellNode next;
		/**
		 * Default constructor.
		 */
		private CellNode() {
			Phone=null;
			next=null;
		}
		/**
		 * Parameterized constructor.
		 * @param c
		 * @param d
		 */
		private CellNode(CellPhone c, CellNode d) {
			this.Phone=c;
			this.next=d;
			size++;
		}
		/**
		 * Copy constructor.
		 * @param other
		 */
		private CellNode(CellNode other) {
			this.Phone=other.Phone;
			this.next=other.next;
		}
		/**
		 * Clone method.
		 */
		protected CellNode clone() {
			return new CellNode(this);
		}
		/**
		 * Get method of Phone.
		 * @return
		 */
		private CellPhone getPhone() {
			return Phone;
		}
		/**
		 * Get method of next.
		 * @return
		 */
		private CellNode getNext() {
			return next;
		}
		/**
		 * Set method of Phone.
		 * @param Phone
		 */
		private void setPhone(CellPhone Phone) {
			this.Phone=Phone;
		}
		/**
		 * Set method of next.
		 * @param next
		 */
		private void setNext(CellNode next) {
			this.next=next;
		}
	}
	
	private CellNode head;
	private int size;
	
	/**
	 * Default constructor that creates an empty list.
	 */
	public CellList() {
		this.head=null;
		this.size=0;
	}
	/**
	 * Copy constructor.
	 * @param other
	 */
	public CellList(CellList other) {
		this.head=other.head;
		this.size=other.size;
	}
	/**
	 * Return current size of CellList.
	 * @return
	 */
	public int getSize() {
		return size;
	}
	/**
	 * addToStart method that creates the node and add it to the head of the list.
	 * @param add
	 */
	public void addToStart(CellPhone add) {
		CellNode temp=new CellNode(add,head);
		head=temp;
	}
	/**
	 * The insertAtIndex method is to check if the index is valid and insert the node to an index of the list.
	 * @param cellPhone
	 * @param index
	 * @throws NoSuchElementException
	 */
	public void insertAtIndex(CellPhone cellPhone, int index) throws NoSuchElementException{
		if(index<0||index>size-1) {
			System.out.println("Invalid index. The program will be terminated.");
			throw new NoSuchElementException();
		}else {
			/**
			 * If size equals to 0, call the addToStart method and initialize new head.
			 */
			if(size==0)
				addToStart(cellPhone);
			if(index==0) {
				addToStart(cellPhone);
				size=size+1;
				return;
			}
			/**
			 * Insert a new cellPhone at index.
			 */
			CellNode pre=head;
			CellNode cur=head.next;
			int tem=1;
			CellNode tempNode=new CellNode(cellPhone, null);
			while(index!=tem) {
				pre=pre.next;
				cur=cur.next;
				tem++;
			}
			pre.next=tempNode;
			tempNode.next=cur;
			size=size+1;
		}
	}
	
	/**
	 * The deleteFromIndex method is to check if the index is valid and delete the next index.
	 * @param index
	 */
	public void deleteFromIndex(int index) {
		if(index<0||index>size-1) {
			System.out.println("Incalid index. The program will be terminated.");
			throw new NoSuchElementException();
		}
		int tem=1;
		CellNode pre=head;
		CellNode cur=head.next;
		/**
		 * To the next index.
		 */
		while(index!=tem) {
			pre=pre.next;
			cur=cur.next;
			tem++;
		}
		pre.next=cur.next;
		size=size-1;
	}
	
	/**
	 * The deleteFromStart method is to delete the first node in the list.
	 */
	public void deleteFromStart() {
		if(size>1) {
			head=head.next;
			size--;
		}
		else {
			System.out.println("The list is empty. Cannot delete the node.");
		}
	}
	
	/**
	 * The replaceAtIndex method replace the  certain cellPhone at the given index.
	 * @param cellPhone
	 * @param index
	 * @return
	 */
	public boolean replaceAtIndex(CellPhone cellPhone, int index) {
		if(head==null)
			return false;
		else {
			if(index<0||index>size-1)
				return false;
			else {
				CellNode tem=head;
				if(index==0)
					head=new CellNode(cellPhone, tem.next);
				else {
					for(int i=0; i<index-1;i++)
						tem=tem.next;
					if(tem.next.next==null) {
						tem.next=new CellNode(cellPhone, null);
					}
					else {
						tem.next=new CellNode(cellPhone, tem.next.next);
						tem=null;
					}
				}
				return true;
			}
		}
	}
	
	/**
	 * The find method is to find the CellNode with the given serial number and
	 * return a reference to it. If no CellNode is found, it will return null.
	 * That will cause a privacy leak because of returning a reference.
	 * Maybe returning a deep copy of the CellNode by clone will work.
	 * @param serialNum
	 * @return
	 */
	public CellNode find(long serialNum) {
		  boolean found=false;
		  int times=1;
		  CellNode position=head;
		  while(position!=null) {
		   /**
		    * If found the node, break the loop and return true.
		    */
		   if(position.Phone.getSerialNum()==serialNum) {
		    found=true;
		    System.out.println("The cellphone with serial number of "+serialNum+" exists.");
		    break;
		   }
		   /**
		    * If the node is not found, continue the loop.
		    */
		   position=position.next;
		   times++;
		  }
		  if(found==true) {
		   System.out.println("There are "+times+" interations made before finding the node.");
		   return position;
		  }
		  else {
		   return null;
		  }
		 }
	
	/**
	 * The contains method is to check if the serial number is on the CellList.
	 * @param serialNum
	 * @return
	 */
	public boolean contains(long serialNum) {
		if(find(serialNum)==null)
			return false;
		return true;
	}
	
	
	public void showContents() {
		CellNode tem=head;
		if(tem==null)
			System.out.println("The list is empty.");
		else {
			System.out.println("The current size of the list is "+size+". Here are the contents of the list.");
			int count=0;
			while(tem!=null) {
				System.out.print(tem.Phone+" ---> ");
				tem=tem.next;
				count++;
				/**
				 * Create a new line after 3 CellNode.
				 */
				if(count%3==0&&count!=0)
					System.out.println();
			}
			System.out.println("X");
		}
	}
	
	/**
	 * The equal method is to compare 2 CellList object and see if they are equal.
	 */
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		else if(getClass()!=obj.getClass())
			return false;
		else {
			CellList other=(CellList)obj;
			if(size!=other.size)
				return false;
			CellNode cur=head;
			CellNode tem=other.head;
			while(cur!=null) {
				if(!cur.getPhone().equals(tem.getPhone()))
					return false;
				cur=cur.next;
				tem=tem.next;
			}
			return true;
		}
	}
}
