from collections import deque # Import deque for BFS queue

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list) -> int:
        wordSet = set(wordList) # Convert wordList to set for O(1) lookup
        if endWord not in wordSet:
            return 0 # If endWord not in wordList, no transformation possible

        queue = deque() # Initialize BFS queue
        queue.append((beginWord, 1)) # Start with beginWord and step count 1
        visited = set() # Set to track visited words
        visited.add(beginWord) # Mark beginWord as visited

        while queue:
            word, steps = queue.popleft() # Pop word and current step count
            if word == endWord:
                return steps # Found endWord, return steps

            for i in range(len(word)): # For each character position
                for c in 'abcdefghijklmnopqrstuvwxyz': # Try all possible letters
                    nextWord = word[:i] + c + word[i+1:] # Change one letter
                    if nextWord in wordSet and nextWord not in visited:
                        queue.append((nextWord, steps + 1)) # Enqueue new word with incremented steps
                        visited.add(nextWord) # Mark as visited

        return 0 # If endWord not found, return 0