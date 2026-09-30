class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        int runningPre = 1;
        int runningPost = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = runningPre;
            postfix[nums.length - i - 1] = runningPost;
            
            runningPre *= nums[i];
            runningPost *= nums[nums.length - i - 1];
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = prefix[i] * postfix[i];
        }
        
        return ret;
    }
}  
