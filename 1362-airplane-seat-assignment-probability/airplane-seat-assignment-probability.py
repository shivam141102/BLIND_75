class Solution:
    def nthPersonGetsNthSeat(self, n: int) -> float:
        # If there is only one passenger, they get their own seat
        if n == 1:
            return 1.0  # Only one seat, so probability is 1
        # For n >= 2, the probability is always 0.5
        return 0.5  # For all other cases, probability is 0.5