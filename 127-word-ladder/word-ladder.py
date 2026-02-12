from collections import deque, defaultdict # Import deque for BFS and defaultdict for pattern mapping

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: # If endWord is not in wordList, no solution
            return 0 # Return 0 as per problem statement

        L = len(beginWord) # All words are of same length
        all_combo_dict = defaultdict(list) # Dictionary to hold all combinations

        for word in wordList: # Preprocess word list
            for i in range(L): # For each position in the word
                pattern = word[:i] + '*' + word[i+1:] # Create pattern with wildcard
                all_combo_dict[pattern].append(word) # Map pattern to word

        queue = deque([(beginWord, 1)]) # Initialize BFS queue with beginWord and level 1
        visited = set([beginWord]) # Set to keep track of visited words

        while queue: # While there are nodes to process
            current_word, level = queue.popleft() # Get current word and level
            for i in range(L): # For each position in the word
                pattern = current_word[:i] + '*' + current_word[i+1:] # Create pattern
                for word in all_combo_dict[pattern]: # For all words matching this pattern
                    if word == endWord: # If we found the endWord
                        return level + 1 # Return the number of steps
                    if word not in visited: # If word has not been visited
                        visited.add(word) # Mark as visited
                        queue.append((word, level + 1)) # Add to queue with incremented level
                all_combo_dict[pattern] = [] # Clear the list to prevent re-processing
        return 0 # If endWord is not found, return 0