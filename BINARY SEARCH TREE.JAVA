package Binary;

//simple binary search tree
//each node to left of the node is less and is a binary search tree, each node to the right is greater and is a bst
//log n search/insert/delete

public class BinarySearchTree {
	//wrapper class
	class Node {
		int key;
		Node left;
		Node right;
	
	public Node(int item) {
			this.key = item;
			this.left = null;
			this.right = null;
		}
	}
	
	Node root;
	public BinarySearchTree() {
		this.root = null;
	}
	
	//alternate constructor pass in default root node;
	public BinarySearchTree(int root) {
		this.root = new Node(root);
	}
	
	public void insert(int item) {
		root = insertRec(root, item);
	}
	
	public Node insertRec(Node root, int item) {
		if(root == null) {
			Node newNode = new Node(item);
			root = newNode;
			return root;
		}
		
		if(item < root.key) {
			root.left = insertRec(root.left, item);
		}else {
			root.right = insertRec(root.right, item);
		}
		
		return root;
	}
	
	public void inOrder() {
		System.out.println("In order traversal of tree: ");
		inOrder(root);
	}
	
	public void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}
	
	
	public boolean search(int item) {
		if(root == null)
			return false;
		
		Node current = root;
		
		while(current != null) {
			if(current.key == item)
				return true;
			else if(item < current.key)
				current = current.left;
			else
				current = current.right;
		}
		return false;
	}
	
	public int getMax() {
		return getMax(root);
	}
	
	public int getMax(Node root) {
		if(root == null)
			return -1;
		else if(root.right == null)
			return root.key;
		else
			return getMax(root.right);
	}
	
	public int getMin() {
		return getMin(root);
	}
	
	public int getMin(Node root) {
		if(root == null)
			return -1;
		else if(root.left == null)
			return root.key;
		else
			return getMin(root.left);
	}
	
	public int size() {
		return size(root);
	}
	
	public int size(Node root) {
		if(root == null)
			return 0;
		else
			return size(root.left) + size(root.right) + 1;
	}
	
	public int countLeaves() {
		return countLeaves(root);
	}
	
	public int countLeaves(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		else
			return countLeaves(root.left) + countLeaves(root.right); 
	}
	
	public void deleteKey(int key) {
		root = deleteRec(root, key);
	}
	
	public Node deleteRec(Node root, int key) {
		//base case the tree is empty
		
		if(root == null)
			return root;
		
		if(key < root.key)
			root.left = deleteRec(root.left, key);
		else if(key > root.key)
			root.right = deleteRec(root.right, key);
		else {
			if(root.left==null)
				return root.right;
			else if(root.right == null)
				return root.left;
			
			root.key = getMin(root.right);
			root.right = deleteRec(root.right, key);
		}
		return root;
	}
	
	public int height() {
		return height(root);
	}
	
	public int height(Node root) {
		if(root == null)
			return 0; // 0 is the first level 
		
		else
			return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public int getLeftHeight() {
		return getLeftHeight(root);
	}
	
	public int getLeftHeight(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 0;
		else 
			return 1 + getLeftHeight(root.left);
	}
	
	public int getRightHeight() {
		return getRightHeight(root);
	}
	
	public int getRightHeight(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 0;
		else 
			return 1 + getRightHeight(root.left);
	}
	
	public int levelsDifference() {
		return Math.abs(getLeftHeight() - getRightHeight());
	}
	
	public void preOrder() {
		System.out.println("PREORDER TRAVERSAL OR DFS: " );
		preOrder(root);
	}
	
	public void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder() {
		System.out.println("Post order traversal: ");
		postOrder(root);
	}
	
	public void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.key + " ");
		}
	}
	
	public Node sortedArrayToBst(int[] A, int low, int high) {
		
		if(high < low)
			return null;
		//get the middle and make it the root, then recurse
		int mid = low + (high - low) / 2;
		
		Node node = new Node(A[mid]);
		node.left = sortedArrayToBst(A, low, mid - 1);
		node.right = sortedArrayToBst(A, mid + 1, high);
		
		return node;
		
		
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(1);
		
		
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(600); 
        tree.insert(80); 
        
        int maxNode = tree.getMax();
        int minNode = tree.getMin();
        
        System.out.println("Max element in tree is: " + maxNode);
        System.out.println("Min Element in tree is: " + minNode);
        
        int sizeOfTree = tree.size();
        
        System.out.println("The number of nodes in the tree: " + sizeOfTree);
        
        int numLeaves = tree.countLeaves();
        
        System.out.println("The number of leaf nodes in the tree: " + numLeaves);
        
        tree.deleteKey(600);
        tree.inOrder();
        tree.insert(600);
        tree.inOrder();
        
        int numLevels = tree.height();
        
        System.out.println("\nDifference in levels of left subtree and right subtree: " + tree.levelsDifference());
        System.out.println("\nThe number of levels or log_2(n) = " + numLevels);
	
        BinarySearchTree BST2 = new BinarySearchTree();
        
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7}; 
        
        BST2.root = BST2.sortedArrayToBst(arr, 0, arr.length -1);
        
        BST2.preOrder();
	}
}
