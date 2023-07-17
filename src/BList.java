
public class BList<T> {

	private int size;

	private T obj[];
	private int pointer = 0;

	// threshold 50% size
	public BList() {
		this.size = 10;
		obj = (T[]) new Object[this.size];
	}

	public BList(int size) {
		this.size = size;
		obj = (T[]) new Object[this.size];
	}

	public boolean add(T item) {
		System.out.println("pointer => " + pointer);
		System.out.println(((int) (this.size * 0.75)));
		if (this.pointer == ((int) (this.size * 0.75))) {
			grow();
		}
		this.obj[pointer] = item;
		pointer++;

		return true;

	}

	private void grow() {
		System.out.println("===Total Utilized==>" + this.pointer);

		int newSize = this.size * 2;
		T objNew[] = (T[]) new Object[newSize];

		for (int i = 0; i < this.pointer; i++) {
			objNew[i] = this.obj[i];
		}

		obj = objNew;
		this.size = newSize;
		System.out.println("===newsize => " + this.size);
	}

	public T get(int index) {
		if (index >= this.size && index < 0) {
			return null;
		} else {
			return obj[index];
		}
	}

	public int size() {
		return this.pointer;
	}
}
