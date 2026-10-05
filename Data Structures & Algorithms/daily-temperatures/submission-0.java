class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int ithDay = stack.pop();
                result[ithDay] = i - ithDay;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
}
