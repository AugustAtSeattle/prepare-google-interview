package Successor;


class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
}

public class Solution {
	public TreeNode inorderSuccessor(TreeNode node){
		if(node == null) return null;
		if(node.right != null){
			TreeNode mostLeft = node.right;
			while(mostLeft.left != null){
				mostLeft = mostLeft.left;
			}
			return mostLeft;
		}else{
			
			TreeNode parent = node.parent;
			
			while(parent != null && parent.right == node){
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
}
