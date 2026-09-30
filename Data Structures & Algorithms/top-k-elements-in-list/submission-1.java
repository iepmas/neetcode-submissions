class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        int count = 0;
        int[] ret = new int[k];
        for (int freq = buckets.length - 1; freq >= 0; freq --) {
            List<Integer> bucket = buckets[freq];

            if (bucket == null) continue;

            for (int n : bucket) {
                // use curr val of count then increment after setting it.
                ret[count++] = n;
                if (count == k) {
                    return ret;
                }
            }
        }
        return ret;
    }
}
