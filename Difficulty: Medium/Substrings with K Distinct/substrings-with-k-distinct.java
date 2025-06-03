// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    // Helper method to count substrings with at most k distinct characters
    private int atMostK(String s, int k) {
        int[] freq = new int[26]; // since the string has only lowercase letters
        int left = 0, right = 0, count = 0, distinct = 0;

        while (right < s.length()) {
            if (freq[s.charAt(right) - 'a'] == 0) {
                distinct++;
            }
            freq[s.charAt(right) - 'a']++;
            right++;

            while (distinct > k) {
                freq[s.charAt(left) - 'a']--;
                if (freq[s.charAt(left) - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }

            count += right - left;
        }

        return count;
    }
}
