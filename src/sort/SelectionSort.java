package sort;

public class SelectionSort {
   
	public static void main(String[] args) {
		int a[] = { 5, 4, 3, 2, 1 };
		int tmp;// swap
		System.out.println("Array Before Sorting...");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// sort
		int min;
		for (int i = 0; i < a.length - 1; i++) { // n-1
			min = i;
			for (int j = i + 1; j < a.length; j++) {// n
				if (a[min] > a[j]) {
					min = j;
				}
			}
			if (min != i) {
				tmp = a[min];
				a[min] = a[i];
				a[i] = tmp;
			}
			System.out.println("\nPass : " + (i + 1) + " ");
			for (int x = 0; x < a.length; x++) {
				System.out.print(a[x] + " ");
			}
		}

		System.out.println("\nArray After Sorting...");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
