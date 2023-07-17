
public class AListDemo {

	public static void main(String[] args) {

		AList list = new AList();// 10

		for (int i = 1; i <= 20; i++) {
			list.add(10);
			System.out.println("added " + i);
		}

		System.out.println("Elements in list:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		Integer y = (Integer) list.get(0);

		BList<Integer> b1 = new BList<Integer>();
		b1.add(12);
		Integer x = b1.get(0);

		BList<Float> b2 = new BList<>();
		b2.add(20.20f);
		Float p = b2.get(0);
		
		BList<String> b3 = new BList<>();
		BList<Object> b4 = new BList<>();

	}
}
