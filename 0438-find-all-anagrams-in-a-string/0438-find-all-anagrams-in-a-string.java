import java.util.*;

class Solution {
    // Helper function to compare two frequency maps
    public boolean func(HashMap<Character,Integer> hma, HashMap<Character,Integer> hmb) {
        if (hma.size() != hmb.size()) {
            return false;
        }

        for (char key : hma.keySet()) {
            if (!hmb.containsKey(key)) {
                return false;
            }
            int a = hma.get(key);
            int b = hmb.get(key);
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;

        // Frequency map for string p
        HashMap<Character,Integer> hmp = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            hmp.put(ch, hmp.getOrDefault(ch, 0) + 1);
        }

        int l = 0;
        int k = p.length();
        HashMap<Character,Integer> hms = new HashMap<>();

        // Sliding window
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            hms.put(ch, hms.getOrDefault(ch, 0) + 1);

            // Shrink window if size > k
            if (r - l + 1 > k) {
                char tch = s.charAt(l);
                hms.put(tch, hms.getOrDefault(tch, 0) - 1);
                if (hms.get(tch) == 0) {
                    hms.remove(tch);
                }
                l++;
            }

            // If window size == k, check for anagram
            if (r - l + 1 == k && func(hms, hmp)) {
                ans.add(l);
            }
        }

        return ans;
    }
}
