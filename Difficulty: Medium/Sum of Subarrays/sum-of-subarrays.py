class Solution:
    def subarraySum(self, arr):
        n=len(arr)
        return sum((i+1)*(n-i)*arr[i] for i in range(n))
        