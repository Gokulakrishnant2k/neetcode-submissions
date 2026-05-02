class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String res = "";

        for (int i = 0; i < s.length(); i++) {

            // Odd-length 
            String p1 = expand(s, i, i);
            if (p1.length() > res.length()) {
                res = p1;
            }

            // Even-length 
            String p2 = expand(s, i, i + 1);
            if (p2.length() > res.length()) {
                res = p2;
            }
        }

        return res;
    }

    private String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }


        return s.substring(left + 1, right);
          
    }
}
