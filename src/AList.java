
public class AList {

	private int size;

	private Object obj[];
	private int pointer = 0;

	// threshold 50% size
	public AList() {
		this.size = 10;
		obj = new Object[this.size];
	}

	public AList(int size) {
		this.size = size;
		obj = new Object[this.size];
	}

	public boolean add(Object item) {
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
		Object objNew[] = new Object[newSize];

		for (int i = 0; i < this.pointer; i++) {
			objNew[i] = this.obj[i];
		}

		obj = objNew;
		this.size = newSize;
		System.out.println("===newsize => " + this.size);
	}

	public Object get(int index) {
		if (index >= this.size && index < 0) {
			return -1;
		} else {
			return obj[index];
		}
	}

	public int size() {
		return this.pointer;
	}
}
