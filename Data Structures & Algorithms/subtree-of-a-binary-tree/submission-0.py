# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def sameTree(p, q):
            if p is None and q is None:
                return True
            elif p is None:
                return False
            elif q is None:
                return False
            
            if p.val != q.val:
                return False
            
            lc = sameTree(p.left, q.left)
            rc = sameTree(p.right, q.right)

            return lc and rc
        
        if subRoot is None:
            return True
        
        if root is None:
            return False

        if sameTree(root, subRoot):
            return True
        
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
        