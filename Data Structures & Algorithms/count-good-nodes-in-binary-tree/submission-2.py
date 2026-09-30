# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    count = 0
    def goodNodes(self, root: TreeNode) -> int:

        def dfs(root, max_so_far):
            if root is None:
                return
            
            if root.val >= max_so_far:
                max_so_far = root.val
                self.count += 1
            
            dfs(root.left, max_so_far)
            dfs(root.right, max_so_far)
        dfs(root, root.val)
        return self.count