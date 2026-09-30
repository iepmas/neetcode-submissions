class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        // Arrays.asList()
        
        
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 2; l++) {
            int r = nums.length - 1;
            int m = l + 1;

            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                if (sum == 0) {
                    List<Integer> candidate = Arrays.asList(nums[l], nums[m], nums[r]);
                    set.add(candidate);
                    r--;
                    m++;
                } else if (sum > 0) {
                    r--;
                } else {
                    m++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
