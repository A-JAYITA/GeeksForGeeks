class Solution:
    def kBitFlips(self, arr, k):
        n = len(arr)
        isFlipped = [0] * n
        flipped = 0
        ans = 0
        for i in range(n):
            if i >= k:
                flipped ^= isFlipped[i - k]
            if arr[i] ^ flipped == 0:
                if i + k > n:  # can't flip, out of bounds
                    return -1
                isFlipped[i] = 1
                flipped ^= 1
                ans += 1
        return ans
        