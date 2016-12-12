package MinimalTree;


// Question: Given a sorted (increasing order) array with unique integer elements, write an algorithm to create
// binary search tree with minimal height;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
}

public class Soltuion {
	TreeNode createMinimalBST(int array[]){
		if(array == null) return null;
		return createMinimalBST(array, 0, array.length - 1);
	}

	private TreeNode createMinimalBST(int[] array, int start, int end) {
		if(start > end) return null;// to do
		
		int mid = start + (end - start) /2;
		TreeNode node = new TreeNode();
		node.value = array[mid];
		node.left = createMinimalBST(array, start, mid -1);
		node.right = createMinimalBST(array, mid + 1, end);
		return node;
	}
}
