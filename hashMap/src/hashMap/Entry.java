package hashMap;

public class Entry<K,V> {

	final K key;
	V value;
	Entry next;
	int hash;
	
	public Entry (K key, V value, int hash) {
		this.key = key;
		this.value = value;
		this.hash = hash;
		next = null;
	}
	
	public void print () {
		
		System.out.print("key = " + key + ", value = " + value + "; ");
		System.out.println();
	}
	
}
