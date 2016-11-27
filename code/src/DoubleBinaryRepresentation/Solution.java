package DoubleBinaryRepresentation;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	String printBinary(double num){
		if(num > 1 || num <0)
			return "Error";
		StringBuilder sb = new StringBuilder();
		sb.append('.');
		while(num != 0){
			if(sb.length() >= 32) return "Error";
			
			double r = num * 2;
			if(r > 1){
				sb.append(1);
				r = r -1;
			}else{
				sb.append(0);
			}
			
			num = r;
		}
		
		return sb.toString();
	}

}
