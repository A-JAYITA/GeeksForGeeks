class Solution:
    def vowelCount(self, s):
        #code here
        # streak 19/07/2025
        dic={}
        se={'a','e','i','o','u'}
        for i in s:
            if i in se:
                dic[i]=dic.get(i,0)+1
        if not dic:
            return 0
        fact = 1
        for i,j in enumerate(dic.values()):
            fact*=(i+1)*j
        return fact