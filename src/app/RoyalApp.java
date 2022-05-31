package app;

import java.util.Scanner;

public class RoyalApp {

	public static void main(String[] args) {

		Student head = null;
		Student last = null;
		Scanner scr = new Scanner(System.in);

		while (true) {
			System.out.println("\n0 For exit\n1 For Add student\n2 For List student\nEnter choice");
			int ch = scr.nextInt();
			switch (ch) {
			case 1:

				if (head == null) {
					head = new Student();
					head.getData();
					head.next = null;
					last = head; 
				} else {
					Student st = new Student();// 1 2 3
					st.getData();
					st.next = null;
					last.next = st;
					last  = st;
				}
				break;
			case 2:
				// 5student
				Student p = head; 
				
				while(p!=null) {
					p.display();
					p = p.next; 
				}
				
				
				break;
			case 0:
				System.exit(0);
			}
		}
	}
}

class Student {
	String name;
	int maths, sci, eng;
	float perc;
	Student next;

	void getData() {
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter name and marks of three subjects");
		name = scr.next();
		maths = scr.nextInt();
		sci = scr.nextInt();
		eng = scr.nextInt();
		perc = (maths + sci + eng) / 3;
	}

	void display() {
		System.out.println(name + "   " + maths + "  " + sci + "  " + eng + "  " + perc);
	}

}
