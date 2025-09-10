class Solution:
    def getSecondLargest(self, arr):
        # Code Here
        arr.sort()
        n=len(arr)
        largest=arr[-1]
        for i in range(n-2,-1,-1):
            if arr[i]<largest:
                return arr[i]
        return -1