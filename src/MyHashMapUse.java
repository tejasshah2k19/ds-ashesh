
public class MyHashMapUse {

	public static void main(String[] args) {

		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>(20);
	
		map.put(50, "ten");
		map.put(51, "ten2");
		
		System.out.println(map.data[10].value);
		System.out.println(map.data[11].value);
		
		
	}
}
