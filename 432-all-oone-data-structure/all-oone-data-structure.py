class Node:
    def __init__(self, count):
        self.count = count  # The count this node represents
        self.keys = set()  # Set of keys with this count
        self.prev = None  # Previous node in the list
        self.next = None  # Next node in the list

class AllOne:
    def __init__(self):
        self.key_count = {}  # Map key to its count
        self.count_node = {}  # Map count to its node
        self.head = Node(float('-inf'))  # Dummy head
        self.tail = Node(float('inf'))  # Dummy tail
        self.head.next = self.tail  # Link head to tail
        self.tail.prev = self.head  # Link tail to head

    def _add_node_after(self, new_node, prev_node):
        new_node.prev = prev_node  # Set previous pointer
        new_node.next = prev_node.next  # Set next pointer
        prev_node.next.prev = new_node  # Link next node back to new node
        prev_node.next = new_node  # Link prev node to new node

    def _remove_node(self, node):
        node.prev.next = node.next  # Bypass node in list
        node.next.prev = node.prev  # Bypass node in list
        del self.count_node[node.count]  # Remove from count_node map

    def inc(self, key: str) -> None:
        count = self.key_count.get(key, 0)  # Get current count
        new_count = count + 1  # Increment count
        self.key_count[key] = new_count  # Update key_count

        if new_count not in self.count_node:  # If node for new_count doesn't exist
            new_node = Node(new_count)  # Create new node
            self.count_node[new_count] = new_node  # Add to count_node
            prev_node = self.count_node[count] if count in self.count_node else self.head  # Find previous node
            self._add_node_after(new_node, prev_node)  # Insert new node

        self.count_node[new_count].keys.add(key)  # Add key to new node

        if count > 0:  # If key was already present
            node = self.count_node[count]  # Get old node
            node.keys.remove(key)  # Remove key from old node
            if not node.keys:  # If old node is empty
                self._remove_node(node)  # Remove old node

    def dec(self, key: str) -> None:
        count = self.key_count[key]  # Get current count
        node = self.count_node[count]  # Get node for current count
        node.keys.remove(key)  # Remove key from node

        if count == 1:  # If count becomes 0
            del self.key_count[key]  # Remove key from key_count
        else:
            new_count = count - 1  # Decrement count
            self.key_count[key] = new_count  # Update key_count
            if new_count not in self.count_node:  # If node for new_count doesn't exist
                new_node = Node(new_count)  # Create new node
                self.count_node[new_count] = new_node  # Add to count_node
                self._add_node_after(new_node, node.prev)  # Insert new node
            self.count_node[new_count].keys.add(key)  # Add key to new node

        if not node.keys:  # If node is empty
            self._remove_node(node)  # Remove node

    def getMaxKey(self) -> str:
        if self.tail.prev == self.head:  # If list is empty
            return ""  # Return empty string
        return next(iter(self.tail.prev.keys))  # Return any key from max node

    def getMinKey(self) -> str:
        if self.head.next == self.tail:  # If list is empty
            return ""  # Return empty string
        return next(iter(self.head.next.keys))  # Return any key from min node