class Solution:
    def missingNumber(self, arr):
        seen = set(arr)

        for i in range(1,(10**5)+1):
            if i not in seen:
                return i