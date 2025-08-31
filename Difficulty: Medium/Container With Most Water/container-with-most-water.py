class Solution:
    def maxWater(self, arr):
        # code here
        l,r = 0, len(arr)-1
        max_water = 0
        
        while l < r:
            max_water = max(max_water, (r-l)* min(arr[l],arr[r]))
            
            if arr[l] < arr[r]:
                l+=1
            else:
                r -=1
        
        return max_water
        