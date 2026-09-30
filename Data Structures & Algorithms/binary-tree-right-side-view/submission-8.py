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
        self.deepest_level = 0  # Reset deepest_level for each test case
        self.ret = []  
        def dfs(root, curr_level = 0):
            if root:
                print("<===>")
                print(f"root: {root.val}")
                print(f"current level: {curr_level}")
                print(f"Deepest level: {self.deepest_level}")
                print("<===>")

            if root is None:
                return None
            if curr_level >= self.deepest_level:
                self.ret.append(root.val)
                self.deepest_level += 1
            curr_level += 1
            dfs(root.right, curr_level)
            dfs(root.left, curr_level)
        dfs(root)
        return self.ret