class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            if (set.contains(str))  {
                int x, y;
                switch (str) {
                    case "+":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(x + y);
                        break;
                    case "-":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y - x);
                        break;
                    case "*":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(x * y);
                        break;
                    case "/":
                        x = stack.pop();
                        y = stack.pop();
                        stack.push(y / x);
                        break;
                }
            } else {
                int val = Integer.parseInt(str);
                stack.push(val);
            }
        }
        return stack.pop();
    }
}
