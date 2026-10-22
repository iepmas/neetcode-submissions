class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    private void backtrack(int[] nums) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // add
        for (int j = 0; j < nums.length; j++) {
            if (visited.contains(nums[j])) {
                continue;
            }
            visited.add(nums[j]);
            curr.add(nums[j]);
            backtrack(nums);
            curr.remove(curr.size() - 1);
            visited.remove(nums[j]);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return result;
    }
}
