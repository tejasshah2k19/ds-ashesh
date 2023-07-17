
public class MyHashMap<K, V> {

	static int defaultSize = 10;
	int capacity;
	Entry<K, V> data[];

	public MyHashMap() {
		this(defaultSize);
	}

	public MyHashMap(int cap) {
		this.capacity = cap;
		this.data = new Entry[this.capacity];
	}

	class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}// Entry end

	void put(K key, V value) {// 10 Ten
		Entry<K, V> obj = new Entry<>(key, value);

		int index = hash(key);// 2
		System.out.println("index => "+index);
		if (this.data[index] == null) {
			this.data[index] = obj;// 51
		} else {
			//
			Entry current = this.data[index]; // 50
			current.next = obj;
		}
	}

	int hash(K key) {
		System.out.println("key => "+key);
		return key.hashCode() % this.capacity; // 50 % 20 => 2
	}

}
