package hashMap;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		int capacity = 10;
		double loadFactor = 2.0;
		
		HashMap hashMap = new HashMap(capacity, loadFactor);
		Entry e;
		
		System.out.println(hashMap.capacity);
		System.out.println(hashMap.threshold);
		
		int min = 0;
		int max = 1000;
		int diff = max - min;
		for(int i = 0; i < 500; i++) {
			Random rand = new Random();
			int randomInt = rand.nextInt(diff+1) + min;
			hashMap.insert(i, randomInt);
		}
		System.out.println(hashMap.size);
		e = hashMap.search(250);
		e.print();
		for(int i = 0; i < 500; i++)
			hashMap.delete(i);
		System.out.println(hashMap.size);
	}
}
