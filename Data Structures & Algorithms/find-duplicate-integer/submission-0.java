class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        int floyd = nums[0];

        while (floyd != slow) {
            slow = nums[slow];
            floyd = nums[floyd];

        }
        return floyd;
    }
}
