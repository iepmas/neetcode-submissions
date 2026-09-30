class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
            window.put(s2.charAt(i), window.getOrDefault(s2.charAt(i), 0) + 1);
        }



        // iterate window
        int l = 0;
        int r = s1.length() - 1;
        while (r < s2.length()) {
            // check if window is valid window?
            boolean contains = true;
            for (Map.Entry<Character, Integer> entry : need.entrySet()) {
                if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    contains = false;
                    break;
                }
            }
            
            // check if we found one
            if (contains) {
                return true;
            }

            // otherwise update window
            window.put(s2.charAt(l), window.get(s2.charAt(l)) - 1);
            l++;
            r++;

            if (r >= s2.length()) {
                break;
            }
            window.put(s2.charAt(r), window.getOrDefault(s2.charAt(r), 0) + 1);
        }
        return false;
    }
}
