package ThreeSumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        int result = nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                
                if(Math.abs(target - sum) < Math.abs(target - result)){
                    result = sum;
                }
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
        }
        
        return result;
    }
}

//Summary
// Math.abs();