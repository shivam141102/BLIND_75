class Solution {
    public int findBestValue(int[] arr, int target) {
        // Find the maximum value in the array
        int left = 0; // Start of binary search range
        int right = 0; // End of binary search range
        for (int num : arr) {
            if (num > right) right = num;
            // Find the maximum value in arr for binary search upper bound
        }
        
        int result = 0; // Store the best value found
        int minDiff = Integer.MAX_VALUE; // Store the minimum difference found
        
        // Binary search for the best value
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid value
            int sum = getMutatedSum(arr, mid); // Get mutated sum for mid
            
            int diff = Math.abs(sum - target); // Calculate absolute difference
            
            if (diff < minDiff || (diff == minDiff && mid < result)) {
                result = mid; // Update result if better or same diff but smaller value
                minDiff = diff; // Update minimum difference
            }
            
            if (sum < target) {
                left = mid + 1; // Try a larger value
            } else {
                right = mid - 1; // Try a smaller value
            }
        }
        
        return result; // Return the best value found
    }
    
    // Helper function to calculate mutated sum
    private int getMutatedSum(int[] arr, int value) {
        int sum = 0; // Initialize sum
        for (int num : arr) {
            sum += Math.min(num, value); // Add min(num, value) to sum
        }
        return sum; // Return the mutated sum
    }
}