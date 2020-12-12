import java.util.Scanner;
import java.util.HashSet;

class Node {
	private int data;
	private Node next;
	private Node prev;
	
	public Node() {
		this.data = 0;
		this.next = null;
		this.prev = null;
	}
	
	public Node(int data, Node next, Node prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public void setNextLink(Node next) {
		this.next = next;
	}
	
	public void setPrevLink(Node prev) {
		this.prev = prev;
	}
	
	public Node getNextLink() {
		return this.next;
	}
	
	public Node getPrevLink() {
		return this.prev;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
}

class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void insertAtHead(int data) {
		Node newNode = new Node(data, null, null);
		
		if(head == null) {
			head = newNode;
			tail = head;
		}else {
			head.setPrevLink(newNode);
			newNode.setNextLink(head);
			head = newNode;
		}
		
		this.size++;
	}
	
	public void insertAtEnd(int data) {
		Node newNode = new Node(data, null, null);
		
		if(head == null) {
			head = newNode;
			tail = head;
		}else {
			tail.setNextLink(newNode);
			newNode.setPrevLink(tail);
			tail = newNode;
		}
		
		this.size++;
	}
	
	public void insertAtPos(int data, int index) {
		Node newNode = new Node(data, null, null);
		
		if(index == 1) {
			this.insertAtHead(data);
			return;
		}
		
		Node curr_node = head;
		
		for(int i = 2; i <= this.size; i++) {
			if(i == index) {
				
				Node temp = curr_node.getNextLink();
				curr_node.setNextLink(newNode);
				newNode.setPrevLink(curr_node);
				newNode.setNextLink(temp);
				temp.setPrevLink(newNode);
				
			}
			curr_node = curr_node.getNextLink();
		}
		
		this.size++;
	}
	
	public void removeFirst() {
		if(isEmpty())
			throw new RuntimeException("List is empty");
		
		int headData = head.getData();
		head = head.getNextLink();
		head.setPrevLink(null);
		this.size--;
	}
	
	public void removeLast() {
		
		if(isEmpty())
			throw new RuntimeException("List is empty");
		
		int tailData = tail.getData();
		tail = tail.getPrevLink();
		tail.setNextLink(null);
		this.size--;
		
	}
	
	public void deleteAtPos(int index) {
		
		if(index == 1)
			this.removeFirst();
		if(index == this.size)
			this.removeLast();
		
		Node curr_node = head.getNextLink();
		
		for(int i = 2; i <= this.size; i++) {
			if(i == index) {
				Node p = curr_node.getPrevLink();
				Node n = curr_node.getNextLink();
				p.setNextLink(n);
				n.setPrevLink(p);
				this.size--;
				return;
			}
			curr_node = curr_node.getNextLink();
		}
	}
	
	public void displayList() {
		System.out.print("\nDoubly Linked List = ");
		
		//edge case 1, empty list
		if(this.size == 0) {
			System.out.print("Empty\n");
			return;
		}
		
		//edge case 2, single item list 
		if(head.getNextLink() == null) {
			System.out.println(head.getData() + " ");
			return;
		}
		
		//first
		Node curr_node = head;
		System.out.print(head.getData() + " <-> ");
		curr_node = head.getNextLink();
		//traverse
		while(curr_node.getNextLink() != null) {
			System.out.print(curr_node.getData() + " <-> ");
			curr_node = curr_node.getNextLink();
		}
		
		//last
		System.out.print(curr_node.getData() + " \n");
	}
	
	public boolean removeDuplicates() {
		HashSet<Integer> set = new HashSet<Integer>();
		if(isEmpty())
			return false;
		Node p = null;
		Node curr_node = head;
		boolean containsDup = false;
		while(curr_node != null) {
			if(set.contains(curr_node.getData())) {
				containsDup = true;
				p.setNextLink(curr_node.getNextLink());
			}else {
				set.add(curr_node.getData());
				p = curr_node;
			}
			curr_node = curr_node.getNextLink();
		}
		
		return containsDup;
	}
}

public class DoublyLinkedList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		/* Creating object of linkedList */
		LinkedList list = new LinkedList();
		System.out.println("Doubly Linked List Test\n");
		char ch;

		/* Perform list operations */

		do {
			System.out.println("\nDoubly Linked List Operations\n");
			System.out.println("1. insert at begining");
			System.out.println("2. insert at end");
			System.out.println("3. insert at position");
			System.out.println("4. delete at position");
			System.out.println("5. remove at beginning");
			System.out.println("6. remove at end");
			System.out.println("7. check empty");
			System.out.println("8. get size");
			System.out.println("9. remove duplicates");
			System.out.println("10. display list");

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				list.insertAtHead(scan.nextInt());
				break;

			case 2:
				System.out.println("Enter integer element to insert");
				list.insertAtEnd(scan.nextInt());
				break;

			case 3:
				System.out.println("Enter integer element to insert");
				int num = scan.nextInt();
				System.out.println("Enter position");
				int pos = scan.nextInt();
				if (pos < 1 || pos > list.getSize())
					System.out.println("Invalid position\n");
				else
					list.insertAtPos(num, pos);
				break;

			case 4:
				System.out.println("Enter position");
				int p = scan.nextInt();
				if (p < 1 || p > list.getSize())
					System.out.println("Invalid position\n");
				else
					list.deleteAtPos(p);
				break;

			case 5:
				//remove at beginning
				list.removeFirst();
				System.out.println("Removed from beginning of list.");
				break;
			case 6:
				//remove at end
				list.removeLast();
				System.out.println("Removed from end of list.");
				break;
			case 7:
				System.out.println("Empty status = " + list.isEmpty());
				break;

			case 8:
				System.out.println("Size = " + list.getSize() + " \n");
				break;
				
			case 9:
				//remove duplicates
				boolean hasDuplicates = list.removeDuplicates();
				if(hasDuplicates)
					System.out.println("The duplicates removed");
				else
					System.out.println("No Duplicates");
				break;
			case 10:
				list.displayList();
				break;

			default:
				System.out.println("Wrong Entry \n ");
				break;

			}

			/* Display List */
			list.displayList();
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');
	}
}
