class Solution {
    public String minWindow(String s, String t) {
        // first check if length of t is at least as long as s.
        // then we create a map of counts for each char t.
        // we do sliding window and keep track of current counts.
        // rather than check
        
        if (s.length() < t.length()) {
            return "";
        }

        int resL = 0;
        int resLength = Integer.MAX_VALUE;

        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int have = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                have++;
            }

            while (have == need.size()) {
                if (r - l + 1 < resLength) {
                    resL = l;
                    resLength = r - l + 1;
                }

                char cLeft = s.charAt(l);
                window.put(cLeft, window.get(cLeft) - 1);

                if (need.containsKey(cLeft) && window.get(cLeft) < need.get(cLeft)) {
                    have--;
                }
                l++;
            }
        }
        return resLength == Integer.MAX_VALUE ? "" : s.substring(resL, resL + resLength);
    }
}
