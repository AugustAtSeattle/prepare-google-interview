package FindPathInMatrics;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<List<Integer>> findPathLengthThree(int [][] matrix){
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if(matrix.length == 0) return list;
		int m = matrix.length ;
		int n = matrix[0].length ;
		
		for(int i = 0 ; i < m ; i++ ){
			for(int j = 0 ; j < n ; j++){
				List<Integer> subList =  new LinkedList<Integer>();

				dfs(matrix, m, n, i, j, list, subList , 0);
			}
		}
		
		
		return list;

	}

	private void dfs(int[][] matrix, int m, int n, int i, int j, List<List<Integer>> list, List<Integer> subList, int direction) {

		
		if( i < 0 || i >= m || j <0 || j >= n  || subList.size() >= 3) return ;
	    
		subList.add(matrix[i][j]);
	    
		if(subList.size() == 3) {
			list.add(new LinkedList<Integer>(subList));
			subList.remove(subList.size() - 1);
			return;
		}
		
		if (direction != 2) dfs(matrix, m, n, i - 1, j, list, subList, 1);
		if (direction != 1) dfs(matrix, m, n, i + 1, j, list, subList, 2);
		if (direction != 4) dfs(matrix, m, n, i, j - 1, list, subList, 3);
		if (direction != 3) dfs(matrix, m, n, i, j + 1, list, subList, 4);
		
		subList.remove(subList.size() - 1);
		
	}
	
	public static void main(String args[]) {

		int[][] matrix = new int[][] { { 1, 2 }, 			{ 3, 4}};		
		Solution solution = new Solution();	
		List<List<Integer>> res = solution.findPathLengthThree(matrix);	
		for(List<Integer>list : res){
			for(int num : list){
				System.out.println(num);
			}
			System.out.println("***************");
		}
	}

	
	
}
