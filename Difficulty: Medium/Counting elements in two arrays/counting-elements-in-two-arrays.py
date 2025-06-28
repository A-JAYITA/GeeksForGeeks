class Solution:
    def countLessEq(self, a, b):
        # code here
        f=[0]*(max(b)+1)
        for i in b:
            f[i]+=1
        ps=[f[0]]
        for i in f[1::]:
            ps.append(ps[-1]+i)
        res=[]
        for i in a:
            if i>= len(ps):
                res.append(ps[-1])
            else:
                res.append(ps[i])
        return res