# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    ret = True
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(root):
            if root is None:
                return 0
            
            leftChild = dfs(root.left)
            rightChild = dfs(root.right)
            if abs(leftChild - rightChild) > 1:
                self.ret = False

            return max(leftChild, rightChild) + 1
        dfs(root)
        return self.ret
        