package recursion;

public class Factorial {

	int fact(int n) {
		int ans = 1;
		for (int i = 1; i <= n; i++) {
			ans = ans * i;
		}
		return ans;
	}

	// recursion - method /function itself

	int factt(int n) {
		if(n ==1 ) {
			return 1;
		}
		return n * factt(n - 1);//return 5*factt(4)
										//return 4*factt(3)
											//return 3 * factt(2)
												//return 2*fact(1); 
	}

	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.fact(5));
		System.out.println(f.fact(3));

		System.out.println(f.factt(5));
		
		//mult(5,XXXXX);
		//5 * 1 = 5
		//5 * 2 = 10
		//5 * 3= 15
		
	}
}
