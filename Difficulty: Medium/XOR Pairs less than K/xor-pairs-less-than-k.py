class TrieNode:
    def __init__(self):
        self.child = [None, None]
        self.count = 0

class Solution:
    def cntPairs(self, arr, k):
        root = TrieNode()

        def insert(num):
            node = root
            for i in range(15, -1, -1):
                bit = (num >> i) & 1
                if not node.child[bit]:
                    node.child[bit] = TrieNode()
                node = node.child[bit]
                node.count += 1

        def query(num, k):
            node = root
            total = 0
            for i in range(15, -1, -1):
                if not node:
                    break

                bit = (num >> i) & 1
                kbit = (k >> i) & 1

                if kbit == 1:
                    # If kbit = 1, add matches for XOR < k at this bit
                    if node.child[bit]:
                        total += node.child[bit].count
                    node = node.child[1 - bit]
                else:
                    node = node.child[bit]
            return total

        ans = 0
        for x in arr:
            ans += query(x, k)
            insert(x)

        return ans
