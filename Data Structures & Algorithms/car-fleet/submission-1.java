class Solution {
    private float computeTime(int position, int speed, int target) {
        return (float) (target - position) / speed;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Float> stack = new Stack<>();
        int ret = 0;
        int n = position.length;
        
        // failing because I'm not sorting?
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < position.length; i++) {
            if (!stack.isEmpty()) {
                float currCarTime = computeTime(cars[i][0], cars[i][1], target);
                float frontCarTime = stack.peek();
                if (currCarTime > frontCarTime) {
                    stack.push(currCarTime);
                }
            } else {
                stack.push(computeTime(cars[i][0], cars[i][1], target));
            }
        }
        
        while (!stack.isEmpty()) {
            stack.pop();
            ret++;
        }

        return ret;
    }
}
