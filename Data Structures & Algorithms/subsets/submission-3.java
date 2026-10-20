class Solution {
    Set<List<Integer>> result = new HashSet<>();
    ArrayList<Integer> curr = new ArrayList<>();
    
    private void backtracking(int[] nums, int i) {
        List<Integer> copy = curr.stream().sorted().collect(Collectors.toList());
        if (i == nums.length) {
            // save?
            result.add(copy);
            return;
        }
        
        backtracking(nums, i+1);

        curr.add(nums[i]);
        backtracking(nums, i+1);

        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return new ArrayList<>(result);
    }
}
