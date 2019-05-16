package AVL;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		AVLtree treeRandom = new AVLtree();
		
		//добавление 500 элементов от 0 до 499 в рандомном порядке
		int min = 0;
		int max = 500;
		int diff = max - min;
		for(int i = 0; i < 500; i++) {
			Random rand = new Random();
			int randomInt = rand.nextInt(diff+1) + min;
			if(treeRandom.size() != i)
				i--;
			treeRandom.insert(randomInt, 2);
		}
		System.out.println(treeRandom.size());
		
		//удаление элементов от 0 до 99
		for(int i = 0; i < 100; i++) {
			treeRandom.deleteNode(treeRandom.head, i);
		}
		System.out.println(treeRandom.size());
		
		System.out.println();
		
		//пример добавления #1
		AVLtree treeFirst = new AVLtree();
		treeFirst.insert(10, "FirstTree");
		treeFirst.insert(7, "FirstTree");
		treeFirst.insert(15, "FirstTree");
		treeFirst.insert(12, "FirstTree");
		treeFirst.insert(5, "FirstTree");
		treeFirst.insert(8, "FirstTree");
		treeFirst.postOrderPrint(treeFirst.head);
		treeFirst.insert(13, "FirstTree");
		treeFirst.postOrderPrint(treeFirst.head);
		
		System.out.println();
		
		//пример добавления #2
		
		AVLtree treeSecond = new AVLtree();
		treeSecond.insert(10, "SecondTree");
		treeSecond.insert(7, "SecondTree");
		treeSecond.insert(15, "SecondTree");
		treeSecond.insert(13, "SecondTree");
		treeSecond.insert(20, "SecondTree");
		treeSecond.postOrderPrint(treeSecond.head);
		treeSecond.insert(17, "SecondTree");
		treeSecond.postOrderPrint(treeSecond.head);
		
		System.out.println();
		
		//пример удаления #1
		AVLtree treeThird = new AVLtree();
		treeThird.insert(10, "ThirdTree");
		treeThird.insert(7, "ThirdTree");
		treeThird.insert(15, "ThirdTree");
		treeThird.insert(4, "ThirdTree");
		treeThird.insert(9, "ThirdTree");
		treeThird.insert(13, "ThirdTree");
		treeThird.insert(20, "ThirdTree");
		treeThird.insert(1, "ThirdTree");
		treeThird.insert(6, "ThirdTree");
		treeThird.insert(8, "ThirdTree");
		treeThird.insert(17, "ThirdTree");
		treeThird.insert(5, "ThirdTree");
		treeThird.postOrderPrint(treeThird.head);
		treeThird.deleteNode(treeThird.head, 13);
		treeThird.postOrderPrint(treeThird.head);
		
		System.out.println();
		
		//пример удаления #2
		AVLtree treeFourth = new AVLtree();
		treeFourth.insert(10, "FourthTree");
		treeFourth.insert(7, "FourthTree");
		treeFourth.insert(17, "FourthTree");
		treeFourth.insert(4, "FourthTree");
		treeFourth.insert(9, "FourthTree");
		treeFourth.insert(15, "FourthTree");
		treeFourth.insert(20, "FourthTree");
		treeFourth.insert(1, "FourthTree");
		treeFourth.insert(6, "FourthTree");
		treeFourth.insert(8, "FourthTree");
		treeFourth.insert(19, "FourthTree");
		treeFourth.insert(5, "FourthTree");
		treeFourth.postOrderPrint(treeFourth.head);
		treeFourth.deleteNode(treeFourth.head, 7);
		treeFourth.postOrderPrint(treeFourth.head);
	}

}
