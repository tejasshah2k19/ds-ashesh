package sort;

public class BubbleSort {

	public static void main(String[] args) {
		int a[] = {5,4,3,2,1};
		int tmp;// swap
		boolean isSwap = true;
		System.out.println("Array Before Sorting...");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// sort
		for (int i = 0; i < a.length && isSwap == true; i++) { // n
			isSwap= false;
			for (int j = 0; j < a.length - 1 - i ; j++) {// n-1
				if (a[j] > a[j + 1]) {// n*n-1
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					isSwap= true;
				}
			}
			System.out.println("\nPass : "+(i+1)+" ");
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
