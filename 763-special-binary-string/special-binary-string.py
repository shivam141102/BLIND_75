class Solution:  # Define the Solution class
    def makeLargestSpecial(self, s: str) -> str:  # Define the main function
        subs = []  # List to store top-level special substrings
        count = 0  # Counter to track balance between '1's and '0's
        start = 0  # Start index of a special substring

        for i, c in enumerate(s):  # Iterate through the string with index and character
            if c == '1':  # If character is '1'
                count += 1  # Increment count
            else:  # If character is '0'
                count -= 1  # Decrement count
            if count == 0:  # If a special substring is found
                # Recursively process the inner substring and wrap with '1' and '0'
                subs.append('1' + self.makeLargestSpecial(s[start + 1:i]) + '0')  # Add to subs
                start = i + 1  # Update start index

        subs.sort(reverse=True)  # Sort substrings in descending lex order
        return ''.join(subs)  # Concatenate and return the result