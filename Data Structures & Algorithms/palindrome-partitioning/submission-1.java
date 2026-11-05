class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> curr = new ArrayList<>();
    
    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    private void backtrack(String s, int start) {
        // base case
        if (start == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // choices
        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
            if (!isPalindrome(sub)) {
                continue;
            }

            curr.add(sub);
            backtrack(s, end + 1);
            curr.remove(curr.size() - 1);            
        }

    }

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }
}
