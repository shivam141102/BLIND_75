from typing import List # Import List for type hinting

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits: # If input is empty, return empty list
            return [] # No combinations possible

        # Mapping of digits to letters as per phone keypad
        phone = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }

        res = [] # List to store all combinations

        def backtrack(index, path):
            if index == len(digits): # If path length equals digits length
                res.append(path) # Add current combination to result
                return # Backtrack

            possible_letters = phone[digits[index]] # Get letters for current digit
            for letter in possible_letters: # Iterate through each letter
                backtrack(index + 1, path + letter) # Recurse for next digit

        backtrack(0, "") # Start backtracking from index 0 and empty path
        return res # Return all combinations