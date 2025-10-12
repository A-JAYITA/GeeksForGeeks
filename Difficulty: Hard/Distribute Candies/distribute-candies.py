'''
class Node:
    def __init__(self, val):
        self.data = val
        self.right = None
        self.left = None
'''

class Solution:
    def solve(self, root):
        r1, r2 = (0, 0), (0, 0)
        if root.left:
            r1 = self.solve(root.left)
        if root.right:
            r2 = self.solve(root.right)
        add = r1[0] + r2[0] + root.data - 1
        moves = r1[1] + r2[1] + abs(add)
        return add, moves

    def distCandy(self, root):
        return self.solve(root)[1]