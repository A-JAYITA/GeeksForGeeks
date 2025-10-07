'''
class Node:
    def __init__(self, val):
        self.data = val
        self.right = None
        self.left = None
'''

class Solution:
    def bottomView(self, root):
        # code here
        from collections import deque
        
        if not root:
            return []

        # Dictionary to store the last node at each horizontal distance
        hd_node_map = {}

        # Queue for level order traversal: stores pairs of (node, horizontal distance)
        queue = deque([(root, 0)])

        while queue:
            node, hd = queue.popleft()
            # Overwrite the value at horizontal distance with the current node
            hd_node_map[hd] = node.data

            if node.left:
                queue.append((node.left, hd - 1))
            if node.right:
                queue.append((node.right, hd + 1))

        # Extract the bottom view from the map, sorted by horizontal distance
        bottom_view = [hd_node_map[hd] for hd in sorted(hd_node_map)]
        return bottom_view
        