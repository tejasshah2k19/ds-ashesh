package ll;

import java.util.Scanner;

//insert 3 insertlast insertbeg insertanyafter insertanybefore 
//delete 3 last beg node[index,value]  
//display 1 
//search
//count 

public class LinkedListDemo {

	public static void main(String[] args) {
		Node head = null, last = null;// first node
		int ch, num;
		Scanner scr = new Scanner(System.in);
		while (true) {
			System.out.println("\n0 for exit\n1 For Insert\n2 for Display\n3 for delete\nEnter your choice:");

			ch = scr.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter number");
				num = scr.nextInt();
				if (head == null) {
					head = new Node();
					head.data = num;
					head.next = null;
					last = head;
				} else {
					Node tmp = new Node();
					tmp.data = num;
					tmp.next = null;
					last.next = tmp;
					last = tmp;
				}

				break;
			case 2:
				Node tmp = head;

				while (tmp != null) {
					System.out.print(tmp.data + " -> ");
					tmp = tmp.next;
				}

				break;
			case 3:
				 //delete 
				Node p = head; 
				 
				while(p.next != last) {
					p=p.next;
				}
				 last = null; 
				 p.next = null;
				 last = p; 
				 
			case 0:
				System.exit(0);
			}
		}

	}
}

class Node {
	int data;
	Node next;
}
