class Solution {
    public int longestConsecutive(int[] nums) {
        // need to consider "runs"
        // use hashset to look for num - 1. if doesn't exist, it is the start of a run and we check!
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int maxLen = 0;
        int length = 1;
        
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                // it's a run!
                length = 1;
                int nextNum = num + 1;
                while (true) {
                    if (set.contains(nextNum)) {
                        length += 1;
                        nextNum += 1;
                        continue;
                    }
                    break;
                }

            }
            maxLen = Math.max(maxLen, length);
        }
        return maxLen;
    }
}
