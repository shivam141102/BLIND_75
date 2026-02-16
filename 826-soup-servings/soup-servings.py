class Solution:
    def soupServings(self, n: int) -> float:
        # For large n, the probability approaches 1, so return 1 directly
        if n > 5000:
            return 1.0  # For large n, probability is almost 1

        from functools import lru_cache  # Import memoization decorator

        n = (n + 24) // 25  # Scale down n to units of 25 mL

        @lru_cache(None)  # Memoize the function to avoid redundant calculations
        def dp(a, b):
            # If both soups are empty at the same time
            if a <= 0 and b <= 0:
                return 0.5  # Both empty, return 0.5
            # If soup A is empty first
            if a <= 0:
                return 1.0  # A empty first, return 1
            # If soup B is empty first
            if b <= 0:
                return 0.0  # B empty first, return 0

            # Average probability over the four serving options
            return 0.25 * (
                dp(a - 4, b) +         # Serve 100 from A, 0 from B
                dp(a - 3, b - 1) +     # Serve 75 from A, 25 from B
                dp(a - 2, b - 2) +     # Serve 50 from A, 50 from B
                dp(a - 1, b - 3)       # Serve 25 from A, 75 from B
            )

        return dp(n, n)  # Start with both soups full