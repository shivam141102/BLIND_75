class Solution:
    def longestOnes(self, nums: list[int], k: int) -> int:
        left = 0  # Initialize the left pointer of the window
        zeros = 0  # Count of zeros in the current window
        max_len = 0  # Store the maximum length found
        
        for right in range(len(nums)):  # Iterate with the right pointer
            if nums[right] == 0:  # If the current element is 0
                zeros += 1  # Increment the zero count
            
            while zeros > k:  # If there are more than k zeros in the window
                if nums[left] == 0:  # If the leftmost element is 0
                    zeros -= 1  # Decrement the zero count
                left += 1  # Move the left pointer to the right
            
            max_len = max(max_len, right - left + 1)  # Update the max length
        
        return max_len  # Return the maximum length found