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

				dfs(matrix, m, n, i, j, list, subList);
			}
		}
		
		
		return list;

	}

	private void dfs(int[][] matrix, int m, int n, int i, int j, List<List<Integer>> list, List<Integer> subList) {

		
		if( i < 0 || i > m || j <0 || j > 0 ) return ;
	    
		subList.add(matrix[i][j]);
	    
		if(subList.size() == 3) {
			list.add(new LinkedList<Integer>(subList));
			return;
		}
		
		dfs(matrix, m, n, i - 1, j, list, subList);
		dfs(matrix, m, n, i + 1, j, list, subList);
		dfs(matrix, m, n, i, j - 1, list, subList);
		dfs(matrix, m, n, i, j + 1, list, subList);
		
		list.remove(list.size() - 1);
		
	}
}
