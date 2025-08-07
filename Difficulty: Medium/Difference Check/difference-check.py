class Solution:
    def minDifference(self, arr):
        lst=[]
        for i in arr:
            lst.append(i.split(":"))
        lst.sort()
        mini=float('inf')
        lst.append(lst[0])
        six=60*60*60
        for i in range(1,len(lst)):
            val=0
            for k in range(1,4):
                val+=(int(lst[i][k-1])-int(lst[i-1][k-1]))*(six//60**k)
            if val<0:
                val=86400+val
            mini=min(mini,val)
        return mini