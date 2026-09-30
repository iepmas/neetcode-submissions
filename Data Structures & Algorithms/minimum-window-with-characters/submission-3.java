class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        int retL = 0;
        int retR = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int have =  0;
        int needTypes = need.size();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.get(c) != null && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }
            
            while (have == needTypes) {
                // check for shorter minWinSubStr
                if (r - l + 1 < minLen) { 
                    retL = l;
                    retR = r;
                    minLen = r - l + 1;
                }

                // shrink from left since this is valid window
                c = s.charAt(l);
                window.put(c, window.get(c) - 1);
                l++;
                if (need.get(c) != null && window.get(c) < need.get(c)) {
                    have--;
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(retL, retR + 1);
    }
}
