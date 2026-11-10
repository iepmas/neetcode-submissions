class distanceComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] p1, int[] p2) {
        return Double.compare(distance(p1, new int[]{0, 0}), distance(p2, new int[]{0,0}));
    }

    private double distance(int[] p1, int[] p2) {
        return Math.sqrt((Math.pow(p1[0] - p2[0], 2)) + (Math.pow(p1[1] - p2[1], 2)));
    }
}

class Solution {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(new distanceComparator());
    int[][] result;

    public int[][] kClosest(int[][] points, int k) {
        result = new int[k][2];

        for (int[] point : points) {
            minHeap.add(point);
        }

        for (int i = 0; i < k; i++) {
            int[] tmp = minHeap.poll();
            result[i] = tmp;
        }
        return result;
    }
}
