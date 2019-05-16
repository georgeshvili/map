package AVL;

public class AVLtree <T extends Comparable<T>, E>  {
	
	Node<T,E> head;
	private int count = 0;
	
	public AVLtree() {
		this.head = null;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private int height(Node<T,E> node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	private void postOrder(Node<T,E> node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		node.height = findHeight(node) + 1;
		
		node.balance = height(node.left) - height(node.right);

	}
	
	public void postOrderPrint(Node<T,E> node) {
		if(node == null) return;
		postOrderPrint(node.left);
		postOrderPrint(node.right);
		System.out.println("Key: " + node.key + ", Value: " + node.value + ";");
		node.height = findHeight(node) + 1;
		
		node.balance = height(node.left) - height(node.right);

	}
	
	private int findHeight(Node<T,E> node) {
		if(node == null) {
			return -1;
		}
		int l = findHeight(node.left);
		int r = findHeight(node.right);
		if(l > r) {
			return l+1;
		} else {
			return r+1;
		}
		
	}
	
	public void insert(T k, E val) {
		Node<T,E> nodeToInsert = new Node<T,E>(k,val);
		Node<T,E> tmpNode = insertBST(k , val, nodeToInsert);
		
		if(tmpNode == null) return;
		
		postOrder(head);

		while(tmpNode != head && tmpNode.balance != 2 && tmpNode.balance != -2) {
			tmpNode = tmpNode.parent;
		}
		
		if(tmpNode.balance == 2 && height(tmpNode.left.left) >= height(tmpNode.left.right)) {
 			toRight(tmpNode.left);
 			System.out.println("r");
 			
 		} else if(tmpNode.balance == 2 && height(tmpNode.left.left) < height(tmpNode.left.right)) {
 			Node<T,E> tmp = toLeft(tmpNode.left.right);
 			toRight(tmp);
 			System.out.println("br");
 			
 		} else if(tmpNode.balance == -2 && height(tmpNode.right.right) >= height(tmpNode.right.left)) {
 			toLeft(tmpNode.right);
 			System.out.println("l");
 			
 		} else if(tmpNode.balance == -2 && height(tmpNode.right.right) < height(tmpNode.right.left)) {
 			Node<T,E> tmp = toRight(tmpNode.right.left);
 			toLeft(tmp);
 			System.out.println("bl");
 		}
		
	}
	
	private Node<T,E> insertBST(T k, E val, Node<T,E> nodeToInsert) {

		if(head == null) {
			head = new Node<T,E>(k, val, nodeToInsert);
			count++;
			return head;
		} else {
			Node<T,E> tmpNode1 = head;
			Node<T,E> tmpNode2 = null;
			while(true) {
				tmpNode2 = tmpNode1;
				if(k.compareTo(tmpNode1.key) < 0) {
					tmpNode1 = tmpNode1.left;
					if(tmpNode1 == null) {
						tmpNode2.left = new Node<T,E>(k, val, tmpNode2);
						count++;
						return tmpNode2.left;
					}
				} else if(k.compareTo(tmpNode1.key) > 0) {
					tmpNode1 = tmpNode1.right;
					if(tmpNode1 == null) {
						tmpNode2.right = new Node<T,E>(k, val, tmpNode2);
						count++;
						return tmpNode2.right;
					}
				} else {
					System.out.println("Can't insert same keys");
					return null;
				}
			}
		}
		
	}
	
	private Node<T,E> minValueNode(Node<T,E> node){  
        Node<T,E> current = node;  
  
        while (current.left != null)  
        current = current.left;  
  
        return current;  
    }  
  
    public Node<T,E> deleteNode(Node<T,E> head, T key) {

        if (head == null)  {
        	count--;
            return head;  
        }
        
        if (key.compareTo(head.key) < 0)  
            head.left = deleteNode(head.left, key);

        else if (key.compareTo(head.key) > 0)  
            head.right = deleteNode(head.right, key); 

        else {
        	
        	count--;
 
            if ((head.left == null) || (head.right == null)) {  
                Node<T,E> tmpNode = null;  
                if (tmpNode == head.left)  
                    tmpNode = head.right;  
                else
                    tmpNode = head.left;  

                if (tmpNode == null) {  
                    tmpNode = head;  
                    head = null;  
                } else 
                    head = tmpNode; 
            }  
            else {  

                Node<T,E> tmpNode = minValueNode(head.right);  

                head.key = tmpNode.key;  

                head.right = deleteNode(head.right, tmpNode.key);  //
            }  
        }  

        if (head == null) 
            return head;  
        
        postOrder(head);
  
		if(head.balance >= 2 && height(head.left.left) >= height(head.left.right)) {
 			toRight(head.left);
 			System.out.println("r");
 			return head.left;
 			
 		} else if(head.balance >= 2 && height(head.left.left) < height(head.left.right)) {
 			System.out.println("br");
 			Node<T,E> tmp = toLeft(head.left.right);
 			return toRight(tmp);
 			
 		} else if(head.balance <= -2 && height(head.right.right) >= height(head.right.left)) {
 			toLeft(head.right);
 			System.out.println("l");
 			return head.right;
 			
 		} else if(head.balance <= -2 && height(head.right.right) < height(head.right.left)) {
 			System.out.println("bl");
 			Node<T,E> tmp = toRight(head.right.left);
 			return toLeft(tmp);
 		} 
		return head;
    } 
	
	public Node<T,E> toLeft(Node<T,E> rightSon) {

		Node<T,E> n = rightSon.parent;
		Node<T,E> leftSonSon = rightSon.left;
		
		
		if (rightSon.parent != head) {
			
			rightSon.parent = n.parent;
			
			if(n.isLeft(n.parent)) {
				n.parent.left = rightSon;
			} else {
				n.parent.right = rightSon;
			}
			
		} else {
			
			rightSon.parent = null;
			head = rightSon;
			
		}
		
		n.parent = rightSon;
		rightSon.left = n;
		n.right = leftSonSon;
		if(leftSonSon != null) {
			leftSonSon.parent = n;
		}

		return rightSon;
		
	}
	
	public Node<T,E> toRight(Node<T,E> leftSon) {
		
		Node<T,E> n = leftSon.parent;
		Node<T,E> rightSonSon = leftSon.right;
		
		if (leftSon.parent != head) {
			
			leftSon.parent = n.parent;
			
			if(n.isRight(n.parent)) {
				n.parent.right = leftSon;
			} else {
				n.parent.left = leftSon;
			}
			
		} else {
			
			leftSon.parent = null;
			head = leftSon;
			
		}
		
		n.parent = leftSon;
		leftSon.right = n;
		n.left = rightSonSon;
		if(rightSonSon != null) {
			rightSonSon.parent = n;
		}

		return leftSon;

	}
}
