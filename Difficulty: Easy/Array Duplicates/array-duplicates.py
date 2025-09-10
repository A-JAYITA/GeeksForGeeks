class Solution:
    def findDuplicates(self, arr):
        # code here
        seen=set()
        duplicates=[]
        for num in arr:
            if num in seen:
                duplicates.append(num)
            else:
                seen.add(num)
        return duplicates
        