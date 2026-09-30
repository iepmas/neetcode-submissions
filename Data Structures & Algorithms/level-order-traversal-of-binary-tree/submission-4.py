# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []

        queue = collections.deque()
        queue.append(root)

        while queue:
            qLen = len(queue)
            sublist = []
            for i in range(qLen):
                node = queue.popleft()
                if node:
                    queue.append(node.left)
                    queue.append(node.right)
                    sublist.append(node.val)
            
            if sublist:
                res.append(sublist)
        return res
