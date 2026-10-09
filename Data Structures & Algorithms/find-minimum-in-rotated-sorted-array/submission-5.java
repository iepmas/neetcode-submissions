class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int minimum = nums[l];

        while (l <= r) {
            int m = l + (r - l) / 2;

            // if (nums[l] <= nums[r]) {
            //     return nums[l];
            // }
            
            if (nums[l] <= nums[m]) {
                minimum = Math.min(minimum, nums[l]);

                l = m + 1;
            } else {
                minimum = Math.min(minimum, nums[m]);
                r = m - 1;
            }
        }
        return minimum;
    }
}
