from itertools import accumulate
from collections import defaultdict
class Solution:

    def maxScore(self, s, jumps):
        # algorithm: 
        # 1) build a graph from jumps + ch can jump to itself
        # 2) build presum to calculate range sum of string
        # 3) build a lookup, at any position i, lookup[i][ord(x)-ord('a')] will 
        #    return the closest right position of character x.
        # do dp from right to left to avoid any same characters that in the between
    
        prefix_sum = list(accumulate(map(ord, s), initial=0))
        graph = defaultdict(set) 
        for u, v in jumps:
            graph[u].add(v) 
        for ch in set(s):
            graph[ch].add(ch) 
        
        lookup = [[-1]*26 for _ in range(len(s))]
        last_idx = [-1]*26 
        for i in range(len(s)-1, -1, -1):
            for j in range(26):
                lookup[i][j] = last_idx[j] 
            last_idx[ord(s[i])-ord('a')] = i 
        
        dp = [0]*len(s)
    
        for i in range(len(s)-2, -1, -1):
            for ch in graph[s[i]]:
                nxt_pos = lookup[i][ord(ch)-ord('a')] 
                if nxt_pos == -1:
                    continue 
                if ch == s[i]:
                    dp[i] = max(dp[i], dp[nxt_pos] + prefix_sum[nxt_pos] - prefix_sum[i+1])
                else:
                    dp[i] = max(dp[i], dp[nxt_pos] + prefix_sum[nxt_pos] - prefix_sum[i])
        return dp[0]