# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    # ret = True
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        
        def dfs(p, q):
            if p is None and q is None:
                return True
            elif p is None:
                return False
            elif q is None:
                return False
            
            if p.val != q.val:
                return False
            
            lc = dfs(p.left, q.left)
            rc = dfs(p.right, q.right)
            return rc and lc
        ret = dfs(p, q)
        return ret