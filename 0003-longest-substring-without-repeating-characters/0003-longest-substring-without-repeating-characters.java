class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int n = s.length();
        int res = 0;
        HashSet<Character> hs = new HashSet<>();

        for (int r = 0; r < n; r++) {
            if (!hs.contains(s.charAt(r))) {
                hs.add(s.charAt(r));
            } else {
                while (hs.contains(s.charAt(r))) {
                    hs.remove(s.charAt(l));
                    l++;
                }
                hs.add(s.charAt(r));
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}