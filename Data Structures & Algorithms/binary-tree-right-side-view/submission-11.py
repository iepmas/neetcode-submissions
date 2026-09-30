# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    # deepest_level = 0
    # ret = []
    
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ret = []
        q = collections.deque()
        q.append(root)

        while q:
            qLen = len(q)
            rightmostNode = None
            for i in range(qLen):
                node = q.popleft()
                if node:
                    rightmostNode = node
                    q.append(node.left)
                    q.append(node.right)
            if rightmostNode:
                ret.append(rightmostNode.val)
        return ret
