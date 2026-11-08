class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public int lastStoneWeight(int[] stones) {
        for (int i : stones) {
            maxHeap.add(i);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first == second) {
                continue;
            }

            int remainder = first - second;
            maxHeap.add(remainder);
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
