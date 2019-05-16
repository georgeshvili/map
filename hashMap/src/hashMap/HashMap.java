package hashMap;

import java.util.LinkedList;

public class HashMap <K,V>{

	public LinkedList<Entry>[] hashTable;
	double loadFactor; //коэффициент загрузки
	int capacity; //количество линкдлистов
	double threshold; //capacity * loadFactor предельное количество элементов
	int size;// количество элементов
	
	public HashMap(int capacity, double loadFactor) {
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		threshold = capacity * loadFactor;
		hashTable = new LinkedList[capacity];
		for(int i = 0; i < capacity; i++)
			hashTable[i] = new LinkedList<Entry>();
	}
	
	public void insert(K key, V value) {

		int index = getIndex(key, capacity);
		
		Entry<K,V> newEntry = new Entry(key, value, key.hashCode());
		
		if(hashTable[index].isEmpty()) 
			hashTable[index].add(newEntry);
		else {
			for(int i = 0; i < hashTable[index].size(); i++) 
				if(hashTable[index].get(i).hash == key.hashCode() && key.equals(hashTable[index].get(i).key)) {
					hashTable[index].get(i).value = value;
					return;
				}
			hashTable[index].add(newEntry);
		}
		size++;

		if((double)size >= threshold) 
			resize(2*size + 1);
	}
	
	public Entry<K,V> search(K key) {
		
		int index = getIndex(key, capacity);
		
		for(Entry entries : hashTable[index])
			if(key.equals(entries.key))
				return entries;

		System.out.println("No such element");
		return null;
		
	}
	
	public void delete(K key) {
		
		int index = getIndex(key, capacity);
		
		for(Entry entries : hashTable[index]) {
			if(key.equals(entries.key)) {
				hashTable[index].remove(entries);
				size--;
				return;
			}
		}
	}
	
	private void resize(int newCapacity) {
		
		if(hashTable.length == Integer.MAX_VALUE/2) {
			threshold = Integer.MAX_VALUE;
			return;
		}
	
		LinkedList<Entry>[] extendedHashTable = new LinkedList[newCapacity];
		hashTable = transfer(extendedHashTable, newCapacity);
	
		this.hashTable = extendedHashTable;
		this.capacity = newCapacity;
		threshold = capacity * loadFactor;
	
	}
	
	private LinkedList<Entry>[] transfer(LinkedList<Entry>[] extendedHashTable, int newCapacity) {
		
		for(int i = 0; i < newCapacity; i++) 
			extendedHashTable[i] = new LinkedList<Entry>();
		
		for(int i = 0; i < capacity; i++) 
			for(Entry entries : hashTable[i]) 
				extendedHashTable[getIndex((K)entries.key, newCapacity)].add(entries);
			
		return extendedHashTable;
	}
	
	private int getIndex(K key, int capacity) {
		
		int index = Math.abs(key.hashCode()) % capacity;
		return index;
		
	}
	
	public void print() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print(i + ": ");
            for (Entry entries : hashTable[i])
                System.out.print("key = " + entries.key + ", value = " + entries.value + "; ");
            System.out.println();
        }
    }
}
