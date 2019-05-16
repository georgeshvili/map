package AVL;

public class Node<T extends Comparable<T>, E> {
	
	int height, balance;
	T key;
	E value;
	Node<T,E> left, right, parent;
	
	public Node(T key, E value, Node<T,E> parent) {
		//height = 1;
		this.key = key;
		this.value = value;
		this.parent = parent;
		left = null;
		right = null;
	}
	
	public Node(T key, E value) {
		this(key, value, null);
	}
	
	public int compareTo(Node<T,E> o) {
		return key.compareTo(o.key);
	}
	
	boolean isLeft(Node<T, E> p) {
        if (p.left.key == null) return false;
        return p.left.key.compareTo(this.key) == 0;
    }
	
	boolean isRight(Node<T, E> p) {
        if (p.right.key == null) return false;
        return p.right.key.compareTo(this.key) == 0;
    }

}
