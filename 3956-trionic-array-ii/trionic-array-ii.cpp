#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    long long maxSumTrionic(vector<int>& nums) {
        int n = nums.size();
        if (n < 4) return 0; // Impossible to satisfy l < p < q < r

        long long INF = 1e18; // Use a large number for negative infinity
        
        // dp vectors to store max sums ending at i
        // state 0: inc1 (strictly increasing, length >= 2)
        // state 1: dec  (inc1 -> decreasing, dec length >= 2)
        // state 2: inc2 (inc1 -> dec -> increasing, inc length >= 2)
        vector<long long> inc1(n, -INF);
        vector<long long> dec(n, -INF);
        vector<long long> inc2(n, -INF);

        long long globalMax = -INF;

        for (int i = 1; i < n; ++i) {
            // --- Phase 1: Strictly Increasing (len >= 2) ---
            if (nums[i] > nums[i-1]) {
                // Option A: Extend an existing increasing sequence of len >= 2
                // Option B: Start a new increasing sequence of len 2 (just [i-1, i])
                // Note: nums[i-1] is the sum of the sequence of length 1 ending at i-1
                inc1[i] = max(inc1[i-1], (long long)nums[i-1]) + nums[i];
            }

            // --- Phase 2: Strictly Decreasing (len >= 2) ---
            if (nums[i] < nums[i-1]) {
                // Option A: Extend an existing decreasing sequence (Phase 2)
                if (dec[i-1] != -INF) {
                    dec[i] = max(dec[i], dec[i-1] + nums[i]);
                }
                
                // Option B: Transition from Phase 1. 
                // We become the 2nd element of the decreasing part.
                // The peak was at i-1. We need a valid inc1 ending at i-1.
                if (inc1[i-1] != -INF) {
                    dec[i] = max(dec[i], inc1[i-1] + nums[i]);
                }
            }

            // --- Phase 3: Strictly Increasing (len >= 2) ---
            if (nums[i] > nums[i-1]) {
                // Option A: Extend an existing Phase 3 sequence
                if (inc2[i-1] != -INF) {
                    inc2[i] = max(inc2[i], inc2[i-1] + nums[i]);
                }

                // Option B: Transition from Phase 2.
                // We become the 2nd element of the final increasing part.
                // The valley was at i-1. We need a valid dec ending at i-1.
                if (dec[i-1] != -INF) {
                    inc2[i] = max(inc2[i], dec[i-1] + nums[i]);
                }
            }

            // Update global max only if we have a valid Phase 3 ending at i
            if (inc2[i] != -INF) {
                globalMax = max(globalMax, inc2[i]);
            }
        }

        return globalMax;
    }
};