class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stackIndex = new Stack<>();
        Stack<Integer> stackHeight = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stackHeight.isEmpty() && stackHeight.peek() > heights[i]) {
                int index = stackIndex.pop();
                int height = stackHeight.pop();
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stackIndex.push(start);
            stackHeight.push(heights[i]);
        }

        while (!stackIndex.isEmpty()) {
            int index = stackIndex.pop();
            int height = stackHeight.pop();
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
