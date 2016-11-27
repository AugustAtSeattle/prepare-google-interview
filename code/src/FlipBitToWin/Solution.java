package FlipBitToWin;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	public int flipBit(int a){
		int max = 1;
		int mask = 1;
		int curLen = 0;
		int preLen = 0;
		while(mask != 0){
			int curBit = a & 1;
			if(curBit == 1){
				curLen = curLen++;
			}else{
				preLen = curLen;
				curLen = 0;
			}
			
			max = Math.max(max,curLen + preLen + 1);
			a >>>= 1;
		}
		
		return max;
	}

}
