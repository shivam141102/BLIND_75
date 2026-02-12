# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def serialize(self, root):
        # Helper function for preorder traversal
        def preorder(node):
            # If node is None, append '#' to represent null
            if not node:
                vals.append('#')
                return
            # Append the value of the node
            vals.append(str(node.val))
            # Traverse left subtree
            preorder(node.left)
            # Traverse right subtree
            preorder(node.right)
        # List to store serialized values
        vals = []
        # Start preorder traversal from root
        preorder(root)
        # Join all values with commas and return as string
        return ','.join(vals)

    def deserialize(self, data):
        # Split the data string into a list
        vals = iter(data.split(','))
        # Helper function to build tree recursively
        def build():
            # Get the next value
            val = next(vals)
            # If value is '#', return None (null node)
            if val == '#':
                return None
            # Create a new TreeNode with the value
            node = TreeNode(int(val))
            # Build left subtree
            node.left = build()
            # Build right subtree
            node.right = build()
            # Return the constructed node
            return node
        # Start building the tree and return the root
        return build()