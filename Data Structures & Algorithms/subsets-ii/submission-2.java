class Solution {
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> curr = new ArrayList<>();

    private void backtrack(int[] nums, int i) {
        if (nums.length == i) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            backtrack(nums, j + 1);
            curr.add(nums[j]);
            backtrack(nums, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return new ArrayList<>(result);
    }
}
